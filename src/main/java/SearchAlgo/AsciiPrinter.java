package SearchAlgo;

import Entities.*;
import com.opencsv.bean.OpencsvUtils;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AsciiPrinter {

    static public void print(List<Form> lof, char Sep) {
        String home = System.getProperty("user.home");
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        File output = new File(home + "/Downloads/" + "TTBSearch" + dateFormat.format(date) + ".csv");
        try {   //TODO: YEET
            FileWriter fw = new FileWriter(output);
            fw.write("TTBID");
            fw.write(Sep);
            fw.write("Brand Name");
            fw.write(Sep);
            fw.write("Fanciful Name");
            fw.write(Sep);
            fw.write("Serial Number");
            fw.write(Sep);
            fw.write("Alcohol Type");
            fw.write(Sep);
            fw.write("\n");
            for (Form f : lof) {
                fw.write("" + f.getTtbID());
                fw.write(Sep);
                fw.write(f.getBrandName());
                fw.write(Sep);
                if (f.getFancifulName() != null) {
                    fw.write(f.getFancifulName());
                } else {
                    fw.write("N/A");
                }
                fw.write(Sep);
                fw.write(f.getSerialNumber());
                fw.write(Sep);
                fw.write(f.getAlcoholType().toString());
                fw.write(Sep);
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
