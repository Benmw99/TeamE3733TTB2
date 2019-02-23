from imutils import paths
import numpy as np
import argparse
import imutils
import cv2

# argument parser
ap = argparse.ArgumentParser()
ap.add_argument("-i", "--images", type=str, required=True, help="path to input directory of images to stitch")
ap.add_argument("-o", "--output", type=str, required=True, help="path to the output image")
ap.add_argument("-c", "--crop", type=int, default=0, help="whether to crop out largest rectangular region")
args = vars(ap.parse_args())

# import images
imagePaths = sorted(list(paths.list_images(args["images"])))
images = [cv2.imread(image) for image in imagePaths]

# # OpenCV 3
# stitcher = cv2.createStitcher()

# OpenCV 4
stitcher = cv2.Stitcher_create()

# STITCH!
(status, stitched) = stitcher.stitch(images)

# if status is '0', stitching succeeded

if status == 0:
    # Cropping (optional)
	if args["crop"] == 1:
		# create a 10 pixel border surrounding the stitched image
		stitched = cv2.copyMakeBorder(stitched, 10, 10, 10, 10, cv2.BORDER_CONSTANT, (0, 0, 0))

		# Grayscale then threshold the image
		# The outside region is black (0), and the stitched region is gray (>0) so it gets bumped up to white when thresholded
		gray = cv2.cvtColor(stitched, cv2.COLOR_BGR2GRAY)
		thresh = cv2.threshold(gray, 0, 255, cv2.THRESH_BINARY)[1]

		# find all contours of the image
		cnts = cv2.findContours(thresh.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
		# compatability line
		cnts = imutils.grab_contours(cnts)
		# find the contour with the largest enclosed area
		c = max(cnts, key=cv2.contourArea)
		# get bounding box of largest contour
		(x, y, w, h) = cv2.boundingRect(c)

		# Preallocate mask
		mask = np.zeros(thresh.shape, dtype="uint8")
		# draw a nice rectangle mask
		cv2.rectangle(mask, (x, y), (x + w, y + h), 255, -1)

		# new copy to hold the new smaller mask
		minRect = mask.copy()
		# temporary copy to help us count remaining nonzero pixels
		sub = mask.copy()

		# erode repeatedly
		while cv2.countNonZero(sub) > 0:
			minRect = cv2.erode(minRect, None)
			sub = cv2.subtract(minRect, thresh)

		# same deal here
		cnts = cv2.findContours(minRect.copy(), cv2.RETR_EXTERNAL,
			cv2.CHAIN_APPROX_SIMPLE)
		cnts = imutils.grab_contours(cnts)
		c = max(cnts, key=cv2.contourArea)
		(x, y, w, h) = cv2.boundingRect(c)

		# get the piece of the image sitting in the smaller bounding box
		stitched = stitched[y:y + h, x:x + w]

	# write the output image to filesystem
	cv2.imwrite(args["output"], stitched)

	# show
	cv2.imshow("output", stitched)
	cv2.waitKey(0)


elif status == 1 or status == 2:
	print("OpenCV Stitcher Error "+str(status))
	print("Likely a bad image directory/path or too few images")