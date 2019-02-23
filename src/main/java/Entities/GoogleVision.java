// Imports the Google Cloud client library
package Entities;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.protobuf.ByteString;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GoogleVision {
    public static void main(String... args) throws Exception {

        // Instantiates a client



        Form form = new Form();
        detectText("newProfile.png", System.out, form);
        System.out.println(form.getLabelText());

    }


        public static void detectText(String filePath, PrintStream out, Form form) throws Exception, IOException {
            List<AnnotateImageRequest> requests = new ArrayList<>();

            ByteString imgBytes = new FileOpener().fileOpener(filePath);

            Image img = Image.newBuilder().setContent(imgBytes).build();
            Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
            AnnotateImageRequest request =
                    AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
            requests.add(request);

            try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
                BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
                List<AnnotateImageResponse> responses = response.getResponsesList();

                for (AnnotateImageResponse res : responses) {
                    if (res.hasError()) {
                        System.out.printf("Error: %s\n", res.getError().getMessage());
                        return;
                    }

                    // For full list of available annotations, see http://g.co/cloud/vision/docs
                    for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
                        System.out.println("LOOP");
                        form.setLabelText(form.getLabelText() + annotation.getDescription());
         //               System.out.printf("Text: %s\n", annotation.getDescription());
           //             System.out.printf("Position : %s\n", annotation.getBoundingPoly());
                    }
                }
            }
        }

}