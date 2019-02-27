package run;

import Entities.*;
import SearchAlgo.EnvSetter;
import java.sql.Date;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {
    public static void main(String[] args) {
        EnvSetter env = new EnvSetter();
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
        Logger mongoSystem = Logger.getLogger("mongodb");
        mongoSystem.setLevel(Level.WARNING);

        DB.Database db = DB.Database.getDatabase();



        /*db.tableBuilder.resetDB();
*/
//        db.dbInsert.insertCompany(new Manufacturer("Brewers Inc.", "manu", "manu", false, "password"));
 //       db.dbInsert.insertCompany(new Manufacturer("Michael's Company", "mike", "1234", false, "password"));
//        db.dbInsert.insertAgent(new Agent("ttb", "ttb", "Sam Adamster", false, "password"));
  //      db.dbInsert.insertAgent(new Agent("edelmonaco@wpi.edu", "1234", "Michael Clements", true, "password"));

            //    db.dbInsert.insertAgent(new Agent("wwong2@wpi.edu", "pass", "Wilson Wong", false, "password"));
            // db.dbInsert.insertRep(new Representative("TestRep", "1234", false, "password"));



        //Oh boy lets make a complete form
        List<BrewersPermit> Brews = new ArrayList<>();
        Brews.add(new BrewersPermit("123ABC", true));
        Brews.add(new BrewersPermit("456DEF", false));

        List<Address> Adds = new ArrayList<>();
        Adds.add(new Address("Worcester", "MA", "01609", "100 Institute Road", "John Smith", true));
        Adds.add(new Address("Acton", "MA", "123456", "2 Street Ave", "Bob Dijon", false));

        long milli = System.currentTimeMillis();
        Date d = new Date(milli);

        Form form = new Form(null, Brews, true, "00123SE", AlcoholType.MaltBeverage,
                "Bubbly", "BU", Adds, "John Smith", null, new WineFormItems(),
                "1112223333", "edelmonaco@wpi.edu", "No other info", d, 123,
                new Approval(), (float)12.3, ApprovalStatus.Incomplete);
        form.setWorkingOn(0);

        Mailer mail = new Mailer(form);
        mail.run();

        //AttributeContainer.getInstance().formQueue.add(form);

       // db.dbInsert.insertForm(form);


        //System.out.println("*****************Data*************************");
        //db.dbInsert.insertData();

        //System.out.println("Inserting Mongo info");
        //db.mongoFunc.insertDataMongo();

        System.out.println("Hello Iteration 2!");
        UI.MainUI.main(args);

    }
}