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

        db.dbInsert.insertCompany(new Manufacturer(123, "Brewers Inc.", "TestCompany", "1234"));
    }

    @Test
    public void insertForm() {
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
        assertTrue(true);
    }

    @Test
    public void testUpdateApproval() {
        DB.Database db = DB.Database.getDatabase();

        //Inserts a form into the Db
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

        Form pulled = db.dbSelect.getFormByTTB_ID(1);
        Approval app = pulled.getApproval();
        app.setAgentApprovalName("Tom");

        long millis = System.currentTimeMillis();
        Date d1 = new Date(millis);
        app.setDateApproved(d1);
        app.setExpDate(d1);

        app.setQualifications("Can't be used because this program isn't real");
        app.setPage1(ApprovalStatus.Complete);
        app.setPage2(ApprovalStatus.Complete);
        app.setPage3(ApprovalStatus.Complete);
        app.setPage4(ApprovalStatus.Complete);
        pulled.setApprovalStatus(ApprovalStatus.Complete);

        pulled.setApproval(app);

        db.dbInsert.updateApproval(pulled);

        Form pulledUpdate = db.dbSelect.getFormByTTB_ID(1);
        System.out.println(pulledUpdate.getApprovalStatus());
        System.out.println(pulledUpdate.getApproval().getQualifications());
    }
}