package Entities;

import com.google.protobuf.ByteString;
import org.apache.commons.io.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOpener {
    public ByteString fileOpener(String string) throws Exception {
        System.out.println(string);
        try {
            InputStream is = getClass().getResourceAsStream("/" + string);
       //     System.out.println(file.toPath());
     //       Path path = file.toPath();
            byte[] data = IOUtils.toByteArray(is);
            return ByteString.copyFrom(data);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ByteString fileOpener(String path, boolean is) throws Exception {
        try {
            File file = new File(path);
            Path path2 = file.toPath();
            byte[] data = Files.readAllBytes(path2);
            return ByteString.copyFrom(data);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
