package Entities;
import org.apache.poi.POIDocument;
import org.apache.poi.*;
import org.apache.*;

import java.io.*;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.StyleDescription;
import org.apache.poi.hwpf.model.StyleSheet;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.*;
import java.time.LocalDate;

public class FormExporter {
    public XWPFDocument doc;

    public FormExporter(Form form) {
        try {

            File doc2 = new File(getClass().getResource("/" + "converted.docx").toURI());
            System.out.println(doc2.toPath());


            InputStream inputstream = new FileInputStream(doc2);
            doc = new XWPFDocument(inputstream);
            for (XWPFTable tbl : doc.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                //replaceString(r, "REP_ID", form.getRepID());
                                replaceString(r, "REP_ID", "hello");
                                replaceString(r, "TTB ID", "TTB ID: " + String.valueOf(form.getTtbID()));
                                replaceString(r, "PLANT_REGISTRY", form.getBrewersPermit().get(0).getBrewersNo());
                                //TODO _DOM_ and _IMP_
                                Address add = form.getMailingAddress();
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
                                //TODO TYPE OF PRODUCE
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
                                }
                                replaceString(r, "_NAMEAPP_", form.getApplicantName());
                                replaceString(r, "_DATEISS_", java.time.LocalDate.now().toString());
                                replaceString(r, "_QUALIFIICATIONS_", form.getApproval().getQualifications());

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
            File file = new File(getClass().getResource("/" + "output.docx").toURI());
       //     System.out.println(doc3.toPath());

            doc.write(new FileOutputStream(file));
            doc.close();

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
        System.out.println(text);
        if(to_rep == null){
            rep_String = "";
        } else {
            rep_String = to_rep;
        }
        //System.out.println(text);
        if(text!= null && text.contains(rep) ){
            text = text.replace(rep, rep_String);
            r.setText(text, 0);
        }
    }

}

