import Entities.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class main {
    //private static SessionFactory factory;
    public static void main(String[] args) {
        DB.Database db = DB.Database.getDatabase();
        db.tableBuilder.resetDB();
        db.dbInsert.insertCompany(new Manufacturer(123, "Brewers Inc.", "manu", "manu"));
        db.dbInsert.insertAgent(new Agent("ttb", "ttb", "Sam Adamster"));
        db.dbInsert.insertRep(new Representative("123abc", "TestRep", "1234"));
        //db.dbInsert.insertData();
        System.out.println("Hello Iteration 2!");

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
                "1112223333", "john@johnmail.com", "No other info", d, 123,
                new Approval(), (float)12.3, ApprovalStatus.Incomplete);
        form.setWorkingOn(0);


        //AttributeContainer.getInstance().formQueue.add(form);

        db.dbInsert.insertForm(form);
        UI.MainUI.main( args);
    }

}