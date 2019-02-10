package DB;

import Entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DBInsertTest {
    @BeforeClass
    public static void setup() {
        DB.Database db = DB.Database.getDatabase();
        db.tableBuilder.resetDB();
    }

    @Test
    public void insertForm() {
        //FUCKING CIRCULAR DEPENDENCIES. FIX THIS SHIT WITH THE FORM RELATIONS
        //and fix the form approval relationship
        //and fix all this broken shit
        //and maybe scrap this refactor
        //fuck me
        //and wineFormitems


        DB.Database db = DB.Database.getDatabase();
        //Oh boy lets make a complete form
        List<BrewersPermit> Brews = new ArrayList<>();
        Brews.add(new BrewersPermit("123ABC", true));
        Brews.add(new BrewersPermit("456DEF", false));

        List<Address> Adds = new ArrayList<>();
        Adds.add(new Address("Worcester", "MA", "01609", "100 Institue Road", "John Smith", true));
        Adds.add(new Address("Acton", "MA", "123456", "2 Street Ave", "Bob Dijon", false));

        long milli = System.currentTimeMillis();
        Date d = new Date(milli);

        Form form = new Form(null, Brews, true, "00123SE", AlcoholType.MaltBeverage, "Bubbly", "BU", Adds, "John Smith", null, null, "1112223333", "john@johnmail.com", "No other info", d, 123, new Approval(), (float)12.3, ApprovalStatus.Incomplete);

        db.dbInsert.insertForm(form);
        db.dbSelect.selectAllForm();
        assertTrue(true);
    }
}