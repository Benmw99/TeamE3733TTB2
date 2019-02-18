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
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class FormExporter {
    public XWPFDocument doc2;

    public FormExporter(){
        try {
            File doc = new File("/Users/mjclements/IdeaProjects/TeamE3733TTB2/src/main/resources/converted.docx");
            InputStream inputstream = new FileInputStream(doc);
            doc2 = new XWPFDocument(inputstream);
        } catch (IOException e){
            System.out.println(e.toString());
        }

    }

}

