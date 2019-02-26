// Imports the Google Cloud client library
package Entities;
import DB.Database;
import com.google.api.client.util.Lists;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.protobuf.ByteString;


import io.grpc.Context;
import org.omg.CORBA.Environment;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoogleVision {
    public static void main(String... args) throws Exception {
//
//        // Instantiates a client
//        //db.dbInsert.insertData();
//
//
//        //Oh boy lets make a complete form
//        List<BrewersPermit> Brews = new ArrayList<>();
//        Brews.add(new BrewersPermit("123ABC", true));
//        Brews.add(new BrewersPermit("456DEF", false));
//
//        List<Address> Adds = new ArrayList<>();
//        Adds.add(new Address("Worcester", "MA", "01609", "100 Institute Road", "John Smith", true));
//        Adds.add(new Address("Acton", "MA", "123456", "2 Street Ave", "Bob Dijon", false));
//
//        long milli = System.currentTimeMillis();
//        Date d = new Date(milli);
//
//        Form form = new Form(null, Brews, true, "00123SE", AlcoholType.MaltBeverage,
//                "Bubbly", "BU", Adds, "John Smith", null, new WineFormItems(),
//                "1112223333", "mjclements@wpi.edu", "No other info", d, 123,
//                new Approval(), (float) 12.3, ApprovalStatus.Incomplete);
//        form.setWorkingOn(0);
//
//
//        //AttributeContainer.getInstance().formQueue.add(form);
//
//
//   //     detectText("pyramid.jpg", form);
//     //   detectLogoText("pyramid.jpg", form);
//
//        System.out.println(form.getLogoText());
//  //      detectBiggestText("pyramid.jpg");
//
//        String s = form.getLabelText();
//        s = s.replaceAll("\n", "");
//        s = s.replaceAll(" ", "");
//        System.out.println(s);
//        form.setLabelText(s);
//        form.setBrandName("Pyramid");
//        System.out.println(form.verifyBrandName());
//        System.out.println(form.detectAlcType());
//        Pattern p = Pattern.compile("\\d*\\.?\\d*%");
//        Matcher m = p.matcher(s);
//        System.out.print("ALCOHOL CONTENT FOUND:");
//        m.find();
//        int i = m.start();
//        int j = m.end() - 1;
//        Double content = Double.parseDouble(s.substring(i,j));
//        System.out.println(content);
//
//
//        Form form2 = new Form();
//        form2.setWineFormItems(new WineFormItems());
//        form2.getWineFormItems().setAppellation("CHARDONNAY");
//        //detectText("chardonnay.jpg", form2);
//        System.out.println(form2.verifyAppellation());
//
//        new FormExporter(form);

    }


    /**
     * This is the function to get all the text off an image and toss it into the GoogleVision API
     *
     * @param filePath The path of the file to be "google visioned"
     * @param form     the form associated with that document. The LabelText will be set to a scrubbed version
     * @throws Exception
     * @throws IOException
     */
    public void detectText(String filePath, Form form) throws Exception, IOException {
        FileOpener opener = new FileOpener();
        GoogleCredentials credentials = GoogleCredentials.fromStream( new FileInputStream(new File(getClass().getResource("/" + "My First Project-b6981c3f2253.json").toURI())));
       List<String> los =  Lists.newArrayList();
       los.add("https://www.googleapis.com/auth/cloud-platform");
        credentials.createScoped(los);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();


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
                                System.out.println(annotation.getDescription());
                    form.setLabelText(form.getLabelText() + annotation.getDescription());

                }
            }
        }
        String s = form.getLabelText();
        s = s.replaceAll("\n", "");
        s = s.replaceAll(" ", "");
        form.setLabelText(s);
    }


    public void detectLogoText(String filePath, Form form) throws Exception, IOException {
        GoogleCredentials credentials = GoogleCredentials.fromStream( new FileInputStream(new File(getClass().getResource("/" + "My First Project-b6981c3f2253.json").toURI())));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        List<AnnotateImageRequest> requests = new ArrayList<>();

        ByteString imgBytes = new FileOpener().fileOpener(filePath);

        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Type.LOGO_DETECTION).build();
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
                for (EntityAnnotation annotation : res.getLogoAnnotationsList()) {
                    //            System.out.println(annotation.getDescription());
                    form.setLogoText(annotation.getDescription());

                }
            }
        }
        String s = form.getLabelText();
        s = s.replaceAll("\n", "");
        s = s.replaceAll(" ", "");
        form.setLabelText(s);
    }

//    public static String detectBiggestText(String filePath) throws Exception, IOException {
//        String s = "";
//        int max = 0;
//        List<AnnotateImageRequest> requests = new ArrayList<>();
//
//        ByteString imgBytes = new FileOpener().fileOpener(filePath);
//
//        Image img = Image.newBuilder().setContent(imgBytes).build();
//        Feature feat = Feature.newBuilder().setType(Type.).build();
//        AnnotateImageRequest request =
//                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
//        requests.add(request);
//
//        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
//            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
//            List<AnnotateImageResponse> responses = response.getResponsesList();
//            for (AnnotateImageResponse res : responses) {
//                if (res.hasError()) {
//                    System.out.printf("Error: %s\n", res.getError().getMessage());
//                    return "";
//                }
//
//                for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
//                    if(annotation.getBoundingPoly().getVertices(0).getX() > max){
//                        max = annotation.getBoundingPoly().getVertices(0).getX();
//                        s = annotation.getDescription();
//                    }
//
//                }
//            }
//        }
//        System.out.print("MAX:");
//        System.out.println(s);
//        return s;
//    }



}
