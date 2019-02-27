import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {
    public static void main(String[] args) {
        SearchAlgo.EnvSetter env = new SearchAlgo.EnvSetter();
        Map<String,String> map = new HashMap<String,String>();
        map.put("GOOGLE_APPLICATION_CREDENTIALS", env.getPath("My First Project-b6981c3f2253.json"));
        try {
            env.setEnv(map);
        } catch (Exception e){ }

        System.out.println("Starting program...");
        //FINALLY DISABLES THE INFO MESSAGES
        Logger hibSystem = Logger.getLogger("org.hibernate");
        hibSystem.setLevel(Level.WARNING);
        Logger c3System = Logger.getLogger("com.mchange.v2.c3p0");
        c3System.setLevel(Level.WARNING);
        Logger MLogSystem = Logger.getLogger("com.mchange");
        MLogSystem.setLevel(Level.WARNING);
        //Mongodb info message disable doesn't work, I'm still searching for what it is called
        //Logger mongoSystem = Logger.getLogger("mongodb");
        //mongoSystem.setLevel(Level.WARNING);

        DB.Database db = DB.Database.getDatabase();


        System.out.println("Hello Iteration 2!");
        UI.MainUI.main(args);

    }
}