package Entities;
import org.apache.poi.POIDocument;
import org.apache.poi.*;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class FormExporter {
    public POIDocument document;

    public FormExporter(){
        this.document = new POIDocument() {
            @Override
            public void write() throws IOException {

            }

            @Override
            public void write(File newFile) throws IOException {

            }

            @Override
            public void write(OutputStream out) throws IOException {

            }
        }
    }



}
