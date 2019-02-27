package Entities;
import DB.Database;
import javafx.scene.image.Image;

import java.io.*;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class FormExporter {
    public XWPFDocument doc;

    /**
     * Constructor for new Directory
     * @param form
     * @param s
     */
    public FormExporter(Form form, String s) {
        String home = System.getProperty("user.home");
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        try {

            File doc2 = new File(getClass().getResource("/" + "converted.docx").toURI());
            System.out.println(doc2.toPath());

            Address add = form.getMailingAddress();
            InputStream inputstream = new FileInputStream(doc2);
            doc = new XWPFDocument(inputstream);
            for(XWPFParagraph p : doc.getParagraphs()){
                for(XWPFRun r : p.getRuns()){
                    if( form.getApproval() != null && form.getApproval().getQualifications() != null){
                        replaceString(r, "_QUALIFICATIONS_", form.getApproval().getQualifications());
                    } else {
                        replaceString(r, "_QUALIFICATIONS_", "");
                    }
                }
            }
            for (XWPFTable tbl : doc.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                //replaceString(r, "REP_ID", form.getRepID());
                                try {
                                    replaceString(r, "REP_ID", form.getRepID());
                                } catch (Exception e){
                                    replaceString(r, "REP_ID", " ");
                                }
                                replaceString(r, "TTB ID", "TTB ID: " + String.valueOf(form.getTtbID()));
                                replaceString(r, "PLANT_REGISTRY", form.getBrewersPermit().get(0).getBrewersNo());
                                //TODO _DOM_ and _IMP_
                                if(add != null) {
                                    replaceString(r, "_NM", form.getMailingAddress().getName());
                                    replaceString(r, "_STREET_", form.getMailingAddress().getStreet());
                                    replaceString(r, "_CS_", form.getMailingAddress().getCity() + " " + form.getMailingAddress().getState());
                                    replaceString(r, "_ZIP_", form.getMailingAddress().getZip());
                                }
                                else{
                                    replaceString(r, "_NM", "");
                                    replaceString(r, "_STREET_", "");
                                    replaceString(r, "_CS_", "");
                                    replaceString(r, "_ZIP_", "");
                                }
                                if(form.getAddress() != null && !form.getAddress().isEmpty()) {
                                    Address a = form.getAddress().get(0);
                                    replaceString(r, "QW", a.getName());
                                    replaceString(r, "_MTREET_", a.getStreet());
                                    replaceString(r, "_MS_", a.getCity() + " " + a.getState());
                                    replaceString(r, "_MIP_", a.getZip());
                                }
                                else{
                                    replaceString(r, "QW", "");
                                    replaceString(r, "_MTREET_", "");
                                    replaceString(r, "_MS_", "");
                                    replaceString(r, "_MIP_", "");
                                }
                                replaceString(r, "C_T", " ");
                                replaceString(r, "O_R", " ");

                                replaceString(r, "SERIAL_1", form.getSerialNumber().substring(0,1));
                                replaceString(r, "SERIAL_2", form.getSerialNumber().substring(1,2));
                                replaceString(r, "SERIAL_3", form.getSerialNumber().substring(2,3));
                                replaceString(r, "SERIAL_4", form.getSerialNumber().substring(3,4));
                                replaceString(r, "SERIAL_5", form.getSerialNumber().substring(4,5));
                                replaceString(r, "SERIAL_6", form.getSerialNumber().substring(5,6));
                                replaceString(r, "_BRAND_", form.getBrandName());
                                replaceString(r,"_FANCY_", form.getFancifulName());
                                replaceString(r, "_FORMULA_", form.getFormula());
                                if(form.getAlcoholType() == AlcoholType.Wine) {
                                    replaceString(r, "_GRAPE_VARIETAL_", form.getWineFormItems().getGrapeVarietal());
                                    replaceString(r,"_WINEAPP_", form.getWineFormItems().getWineFormItems().getAppellation());
                                } else {
                                    replaceString(r, "_GRAPE_VARIETAL_", "");
                                    replaceString(r,"_WINEAPP_", "");
                                }
                                replaceString(r, "_PHONE_", form.getPhoneNumber());
                                replaceString(r, "_EMAIL_", form.getEmail());
                                replaceString(r, "_OTHER_INFO_", form.getOtherInfo());

                                if(form.getDateSubmitted() != null){
                                    replaceString(r, "_DATEOFAPP_", form.getDateSubmitted().toString());
                                } else {
                                    replaceString(r, "_DATEOFAPP_", "");
                                }
                                replaceString(r, "_NAMEAPP_", form.getApplicantName());
                                replaceString(r, "_DATEISS_", java.time.LocalDate.now().toString());


                                //if true, isImported
                                if(form.getSource() == true){
                                    replaceString(r, "IMP_", "    ☒");
                                    replaceString(r, "_DOM_", "    ☐");
                                }
                                else{
                                    replaceString(r, "IMP_", "   ☐");
                                    replaceString(r, "_DOM_", "   ☒");
                                }

                                if(form.getAlcoholType() == AlcoholType.Wine){
                                    replaceString(r, "_WINE_", "☒  ");
                                    replaceString(r, "_DIST_", "☐  ");
                                    replaceString(r, "_MALT_", "☐  ");
                                }
                                else if(form.getAlcoholType() == AlcoholType.DistilledLiquor){
                                    replaceString(r, "_WINE_", "☐  ");
                                    replaceString(r, "_DIST_", "☒  ");
                                    replaceString(r, "_MALT_", "☐  ");
                                }
                                else{
                                    replaceString(r, "_WINE_", "☐  ");
                                    replaceString(r, "_DIST_", "☐  ");
                                    replaceString(r, "_MALT_", "☒  ");
                                }


                            }
                        }
                    }
                }
            }
            DB.Database db = DB.Database.getDatabase();
            List<LabelImage> labels = db.dbSelect.selectImagesbyTTBID(form.getTtbID());
            if (!labels.isEmpty()) {
                InputStream targetStream = new ByteArrayInputStream(labels.get(0).getImage());
                Image img = new Image(targetStream);
                if (labels.get(0).getImageName().contains("png")) {
                    doc.addPictureData(labels.get(0).getImage(), XWPFDocument.PICTURE_TYPE_PNG);
                } else {
                    doc.addPictureData(labels.get(0).getImage(), XWPFDocument.PICTURE_TYPE_JPEG);
                }
            }
                //File file = new File(getClass().getResource("/" +"output.docx").toURI());
            //    File file = new File("C:\\Users\\Elizabeth Del Monaco\\Desktop\\TeamE3733TTB2\\src\\main\\resources\\output.docx");
            File file = new File(home + "/Downloads/" + "TTBFORM" + s + ".docx");

            doc.write(new FileOutputStream(file));
            doc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public FormExporter(Form form) {
        String home = System.getProperty("user.home");
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        try {

            File doc2 = new File(getClass().getResource("/" + "converted.docx").toURI());
 //           System.out.println(doc2.toPath());

            Address add = form.getMailingAddress();
            InputStream inputstream = new FileInputStream(doc2);
            doc = new XWPFDocument(inputstream);


            for(XWPFParagraph p : doc.getParagraphs()){
                for(XWPFRun r : p.getRuns()){
                    if( form.getApproval() != null && form.getApproval().getQualifications() != null){
                        replaceString(r, "_QUALIFICATIONS_", form.getApproval().getQualifications());
                    } else {
                        replaceString(r, "_QUALIFICATIONS_", "");
                    }
                    File img = new File(getClass().getResource("/pyramid.jpg").toURI());
                    if(r.getText(0) != null && r.getText(0).contains("IMGFILE")) {
                        replaceString(r, "IMGFILE", "");
                        Database db = Database.getDatabase();
                        List<LabelImage> labels = db.dbSelect.selectImagesbyTTBID(form.getTtbID());
                        if(labels.size() >= 1) {
                            InputStream is = new ByteArrayInputStream(labels.get(0).getImage());
                            if (labels.get(0).getImageName().contains("png")) {
                                r.addPicture(is, XWPFDocument.PICTURE_TYPE_PNG, "/image.png", Units.toEMU(600), Units.toEMU(600));
                            } else {
                                r.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, "/image.jpg", Units.toEMU(600), Units.toEMU(600));
                            }
                            is.close();
                        }
                    }
                }
            }
            for (XWPFTable tbl : doc.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                //replaceString(r, "REP_ID", form.getRepID());
                                replaceString(r, "REP_ID", "hello");
                                replaceString(r, "TTB ID", "TTB ID: " + String.valueOf(form.getTtbID()));
                                try {
                                    replaceString(r, "PLANT_REGISTRY", form.getBrewersPermit().get(0).getBrewersNo());
                                } catch (NullPointerException e){

                                }
                                if(add != null) {
                                    replaceString(r, "_NM", form.getMailingAddress().getName());
                                    replaceString(r, "_STREET_", form.getMailingAddress().getStreet());
                                    replaceString(r, "_CS_", form.getMailingAddress().getCity() + " " + form.getMailingAddress().getState());
                                    replaceString(r, "_ZIP_", form.getMailingAddress().getZip());
                                }
                                else{
                                    replaceString(r, "_NM", "");
                                    replaceString(r, "_STREET_", "");
                                    replaceString(r, "_CS_", "");
                                    replaceString(r, "_ZIP_", "");
                                }
                                if(form.getAddress() != null && !form.getAddress().isEmpty()) {
                                    Address a = form.getAddress().get(0);
                                    replaceString(r, "QW", a.getName());
                                    replaceString(r, "_MTREET_", a.getStreet());
                                    replaceString(r, "_MS_", a.getCity() + " " + a.getState());
                                    replaceString(r, "_MIP_", a.getZip());
                                }
                                else{
                                    replaceString(r, "QW", "");
                                    replaceString(r, "_MTREET_", "");
                                    replaceString(r, "_MS_", "");
                                    replaceString(r, "_MIP_", "");
                                }
                                    replaceString(r, "C_T", " ");
                                    replaceString(r, "O_R", " ");
                                    String serial = form.getSerialNumber().concat("      ");
                                replaceString(r, "SERIAL_1", serial.substring(0,1));
                                replaceString(r, "SERIAL_2", serial.substring(1,2));
                                replaceString(r, "SERIAL_3", serial.substring(2,3));
                                replaceString(r, "SERIAL_4", serial.substring(3,4));
                                replaceString(r, "SERIAL_5", serial.substring(4,5));
                                replaceString(r, "SERIAL_6", serial.substring(5,6));

                                replaceString(r, "_BRAND_", form.getBrandName());
                                replaceString(r,"_FANCY_", form.getFancifulName());
                                replaceString(r, "_FORMULA_", form.getFormula());
                                if(form.getAlcoholType() == AlcoholType.Wine) {
                                    replaceString(r, "_GRAPE_VARIETAL_", form.getWineFormItems().getGrapeVarietal());
                                    replaceString(r,"_WINEAPP_", form.getWineFormItems().getWineFormItems().getAppellation());
                                } else {
                                    replaceString(r, "_GRAPE_VARIETAL_", "");
                                    replaceString(r,"_WINEAPP_", "");
                                }
                                replaceString(r, "_PHONE_", form.getPhoneNumber());
                                replaceString(r, "_EMAIL_", form.getEmail());
                                replaceString(r, "_OTHER_INFO_", form.getOtherInfo());

                                if(form.getDateSubmitted() != null){
                                    replaceString(r, "_DATEOFAPP_", form.getDateSubmitted().toString());
                                } else {
                                    replaceString(r, "_DATEOFAPP_", "");
                                }
                                replaceString(r, "_NAMEAPP_", form.getApplicantName());
                                replaceString(r, "_DATEISS_", java.time.LocalDate.now().toString());

                                //if true, isImported
                                if(form.getSource() == true){
                                    replaceString(r, "IMP_", "    ☒");
                                    replaceString(r, "_DOM_", "    ☐");
                                }
                                else{
                                    replaceString(r, "IMP_", "   ☐");
                                    replaceString(r, "_DOM_", "   ☒");
                                }

                                if(form.getAlcoholType() == AlcoholType.Wine){
                                    replaceString(r, "_WINE_", "☒  ");
                                    replaceString(r, "_DIST_", "☐  ");
                                    replaceString(r, "_MALT_", "☐  ");
                                }
                                else if(form.getAlcoholType() == AlcoholType.DistilledLiquor){
                                    replaceString(r, "_WINE_", "☐  ");
                                    replaceString(r, "_DIST_", "☒  ");
                                    replaceString(r, "_MALT_", "☐  ");
                                }
                                else{
                                    replaceString(r, "_WINE_", "☐  ");
                                    replaceString(r, "_DIST_", "☐  ");
                                    replaceString(r, "_MALT_", "☒  ");
                                }


                            }
                        }
                    }
                }
            }
            //File file = new File(getClass().getResource("/" +"output.docx").toURI());
        //    File file = new File("C:\\Users\\Elizabeth Del Monaco\\Desktop\\TeamE3733TTB2\\src\\main\\resources\\output.docx");
            FileOpener fo = new FileOpener();
            DB.Database db = DB.Database.getDatabase();
            List<LabelImage> labels = db.dbSelect.selectImagesbyTTBID(form.getTtbID());
            if (!labels.isEmpty()) {
                InputStream targetStream = new ByteArrayInputStream(labels.get(0).getImage());
                Image img = new Image(targetStream);
                if(labels.get(0).getImageName().contains("png")) {
                    doc.addPictureData(labels.get(0).getImage(), XWPFDocument.PICTURE_TYPE_PNG);
                } else {
                    doc.addPictureData(labels.get(0).getImage(), XWPFDocument.PICTURE_TYPE_JPEG);
                }
            }
       //     File img = new File(getClass().getResource("/pyramid.jpg").toURI());
            File file = new File(getClass().getResource("/" + "output.docx").toURI());
            for(XWPFPictureData x : doc.getAllPictures()){
                System.out.println(x.getFileName());
            }


       //     System.out.println(doc3.toPath());
            doc.enforceReadonlyProtection();
            doc.write(new FileOutputStream(file));
            doc.close();

            POIFSFileSystem fs = new POIFSFileSystem();
            EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
// EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile, CipherAlgorithm.aes192, HashAlgorithm.sha384, -1, -1, null);

            Encryptor enc = info.getEncryptor();
            enc.confirmPassword("foobaa");

// Read in an existing OOXML file and write to encrypted output stream
// don't forget to close the output stream otherwise the padding bytes aren't added
            try (OPCPackage opc = OPCPackage.open(file, PackageAccess.READ_WRITE);
                 OutputStream os = enc.getDataStream(fs)) {
                opc.save(os);
            }
// Write out the encrypted version
            FileOutputStream fos = new FileOutputStream(file);
            fs.writeFilesystem(fos);
            fos.close();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param r
     * @param rep
     * @param to_rep
     */
    public void replaceString(XWPFRun r, String rep, String to_rep){
        String text = r.getText(0);
        String rep_String;
 //       System.out.println(text);
        if(to_rep == null){
            rep_String = "";
        } else {
            rep_String = to_rep;
        }
  //      System.out.println(text);
        if(text!= null && text.contains(rep) ){
            text = text.replace(rep, rep_String);
            r.setText(text, 0);
        }
    }

}

