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

public class FormExporter {
    public XWPFDocument doc;

    public FormExporter(Form form) {
        try {
            File doc2 = new File("/Users/mjclements/IdeaProjects/TeamE3733TTB2/src/main/resources/converted.docx");
            InputStream inputstream = new FileInputStream(doc2);
            doc = new XWPFDocument(inputstream);
            for (XWPFTable tbl : doc.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                               // replaceString(r, "TTB_ID", String.valueOf(form.getTtbID()));
                              //  replaceString(r, "REP_ID", form.getRepID());
                                replaceString(r, "REP_ID", form.getRepID());
                                replaceString(r, "TTB_ID", String.valueOf(form.getTtbID()));
                                replaceString(r, "PLANT_REGISTRY", form.getBrewersPermit().get(0).getBrewersNo());
                                //TODO _DOM_ and _IMP_
                                Address add = form.getMailingAddress();
                                if(add != null) {
                                    String addy = add.getName() + "\n" + add.getStreet() + "\n" + add.getCity() +
                                            "\n" + add.getState() + "\n" + add.getZip();
                                    replaceString(r, "_ADDRESS_", addy);
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
                            }
                        }
                    }
                }
            }
            File file = new File("/Users/mjclements/IdeaProjects/TeamE3733TTB2/src/main/resources/output.docx");
            doc.write(new FileOutputStream(file));
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
        if(to_rep == null){
            rep_String = "";
        } else {
            rep_String = to_rep;
        }
        if(text!= null && text.contains(rep) ){
            text = text.replace(rep, rep_String);
            r.setText(text, 0);
        }
    }

}

