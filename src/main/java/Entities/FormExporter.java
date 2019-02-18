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
                                replaceString(r, "REP_ID", "Peach");
                            }
                        }
                    }
                }
            }
            File file = new File("/Users/mjclements/IdeaProjects/TeamE3733TTB2/src/main/resources/output.docx");
            doc.write(new FileOutputStream(file));
        } catch (Exception e) {
            System.out.println(e.toString());
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
        if(text!= null && text.contains(rep)){
            text.replace(rep, to_rep);
            r.setText(text);
        }
    }

}

