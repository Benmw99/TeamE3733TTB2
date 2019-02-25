import numpy as np
import cv2
import serial
import serial.tools.list_ports
import time

# Connect to comport
try:
    # Always try COM12 - its the best
    comms = serial.Serial("COM12")
    serAvailable = True
except:
    serAvailable = False

if not serAvailable:
    ports = serial.tools.list_ports.comports(False)
    for port in ports:
        try:
            comms = serial.Serial(port.location)
            serAvailable = True
        except:
            serAvailable = False
        if serAvailable:
            break


    if serAvailable:
        comms.baudrate = 9600
        comms.open()

last_time = 0
cap = cv2.VideoCapture(0)
face_cascade = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')
# eye_cascade = cv2.CascadeClassifier('haarcascade_eye.xml')
while(True):
    # Capture frame-by-frame
    ret, frame = cap.read()
    # img = cv2.imread('sachin.jpg')
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    faces = face_cascade.detectMultiScale(gray, 1.3, 5)
    xk = 0
    wk = 0
    for (x,y,w,h) in faces:
        cv2.rectangle(frame,(x,y),(x+w,y+h),(255,0,0),2)
        roi_gray = gray[y:y+h, x:x+w]
        roi_color = frame[y:y+h, x:x+w]
        if w > wk:
            xk = x
            wk = w
    cv2.imshow('frame',frame)





    # get the horizontal position
    # frameWidth = frame.shape(1)
    # stepsWindow = 60
    # dist_of_mid_in_window = x+w/2
    # absOrientation = 100 - 60/2 +(60*(x+w/2)/frame.shape(1))
    if len(faces):
        goto = 130 - ((60*(xk+wk/2))//frame.shape[1])
    # print(goto)
        if time.time()-last_time > 1:
            if serAvailable:
                if goto:
                    comms.write(("goto "+str(int(goto))).encode("ASCII"))
                    print(("goto " + str(goto)).encode("ASCII"))
                    print(comms.read_all())
            last_time = time.time()
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()
comms.close()
