import Entities.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {
    //private static SessionFactory factory;
    public static void main(String[] args) {
        System.out.println("Starting program...");
        //FINALLY DISABLES THE INFO MESSAGES
        Logger hibSystem = Logger.getLogger("org.hibernate");
        hibSystem.setLevel(Level.WARNING);
        Logger c3System = Logger.getLogger("com.mchange.v2.c3p0");
        c3System.setLevel(Level.WARNING);
        Logger MLogSystem = Logger.getLogger("com.mchange");
        MLogSystem.setLevel(Level.WARNING);

        DB.Database db = DB.Database.getDatabase();
        db.tableBuilder.resetDB();
        db.dbInsert.insertCompany(new Manufacturer(123, "Brewers Inc.", "manu", "manu"));
        db.dbInsert.insertCompany(new Manufacturer(420, "Michael's Company", "mike", "1234"));
        db.dbInsert.insertAgent(new Agent("ttb", "ttb", "Sam Adamster"));
    //    db.dbInsert.insertAgent(new Agent("wwong2@wpi.edu", "pass", "Wilson Wong"));
        db.dbInsert.insertAgent(new Agent("mjclements@wpi.edu", "1234", "Michael Clements"));
        db.dbInsert.insertRep(new Representative("123abc", "TestRep", "1234"));
        //db.dbInsert.insertData();


        //Oh boy lets make a complete form
        List<BrewersPermit> Brews = new ArrayList<>();
        Brews.add(new BrewersPermit("123ABC", true));
        Brews.add(new BrewersPermit("456DEF", false));

        List<Address> Adds = new ArrayList<>();
        Adds.add(new Address("Worcester", "MA", "01609", "100 Institue Road", "John Smith", true));
        Adds.add(new Address("Acton", "MA", "123456", "2 Street Ave", "Bob Dijon", false));

        long milli = System.currentTimeMillis();
        Date d = new Date(milli);

        Form form = new Form(null, Brews, true, "00123SE", AlcoholType.MaltBeverage,
                "Bubbly", "BU", Adds, "John Smith", null, null,
                "1112223333", "mjclements@wpi.edu", "No other info", d, 123,
                new Approval(), (float)12.3, ApprovalStatus.Incomplete);
        form.setWorkingOn(0);


        //AttributeContainer.getInstance().formQueue.add(form);

        db.dbInsert.insertForm(form);


        System.out.println("Hello Iteration 2!");
        UI.MainUI.main( args);
    }
}