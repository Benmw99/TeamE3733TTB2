package Entities;

import com.google.protobuf.ByteString;
import org.apache.commons.io.FileExistsException;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOpener {
    public ByteString fileOpener(String string) throws Exception {
        System.out.println(string);
        try {
            File file = new File(getClass().getResource("/" + string).toURI());
            System.out.println(file.toPath());
            Path path = file.toPath();
            byte[] data = Files.readAllBytes(path);
            return ByteString.copyFrom(data);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
}
