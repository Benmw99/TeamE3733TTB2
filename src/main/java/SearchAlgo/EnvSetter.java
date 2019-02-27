package SearchAlgo;

import com.google.protobuf.ByteString;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;

public class EnvSetter {

    public String getPath(String filename){
        try {
         //   File doc2 = new File();
            getClass().getResourceAsStream("/" + filename);
            File file = new File("google.json");

            FileOutputStream fos = new FileOutputStream(file);
            InputStream is = getClass().getResourceAsStream("/" + filename);
            //     System.out.println(file.toPath());
            //       Path path = file.toPath();
            byte[] data = IOUtils.toByteArray(is);
            fos.write(data);
            return file.getAbsolutePath();
           // return doc2.toPath().toString();
        } catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public static void setEnv(Map<String, String> newenv) throws Exception {
        try {
            Class<?> processEnvironmentClass = Class.forName("java.lang.ProcessEnvironment");
            Field theEnvironmentField = processEnvironmentClass.getDeclaredField("theEnvironment");
            theEnvironmentField.setAccessible(true);
            Map<String, String> env = (Map<String, String>) theEnvironmentField.get(null);
            env.putAll(newenv);
            Field theCaseInsensitiveEnvironmentField = processEnvironmentClass.getDeclaredField("theCaseInsensitiveEnvironment");
            theCaseInsensitiveEnvironmentField.setAccessible(true);
            Map<String, String> cienv = (Map<String, String>)     theCaseInsensitiveEnvironmentField.get(null);
            cienv.putAll(newenv);
        } catch (NoSuchFieldException e) {
            Class[] classes = Collections.class.getDeclaredClasses();
            Map<String, String> env = System.getenv();
            for(Class cl : classes) {
                if("java.util.Collections$UnmodifiableMap".equals(cl.getName())) {
                    Field field = cl.getDeclaredField("m");
                    field.setAccessible(true);
                    Object obj = field.get(env);
                    Map<String, String> map = (Map<String, String>) obj;
                    map.clear();
                    map.putAll(newenv);
                }
            }
        }
    }
}
