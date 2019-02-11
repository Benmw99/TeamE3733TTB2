package DB.Test;

import Entities.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import static org.junit.Assert.*;

public class SelectTest {
    static DB.Database db = DB.Database.getInstance();

    @BeforeClass
    public static void setup() {
        db.tableBuilder.resetDB();
        Timestamp timestamp = Timestamp.valueOf("2007-09-23 10:10:10.0");
        try {
            db.dbInsert.insertCompany(123, "Budweiser", "Buddy", "12345");
            db.dbInsert.insertAgent("Mark", 1263, "Agent_Mark", "PassWord");
            db.dbInsert.insertForm("123YY", "ABC", "123", true, true, null,
                    "jim@jimmail.com", 123, Timestamp.from(Instant.now()), "Jimmy", "6035026034", AlcoholType.MaltBeverage.toInt(), 1.0);
            db.dbInsert.insertForm("12Y", "Suds", "Delio", true, true, null,
                    "tim@jimmail.com", 123, Timestamp.from(Instant.now()), "Tim", "6045026034", AlcoholType.Wine.toInt(), 2.0);
            db.dbInsert.insertForm("93F", "SodaB", "Escus", true, false, null,
                    "bob@jimmail.com", 123, Timestamp.from(Instant.now()), "Bob", "6025026034", AlcoholType.DistilledLiquor.toInt(), 14.0);
            db.dbInsert.insertForm("123YY", "ABC", "123", true, false, null,
                    "jim@jimmail.com", 123, Timestamp.from(Instant.now()), "Jimmy", "6035026034", AlcoholType.MaltBeverage.toInt(), 1.0);
        } catch (SQLException e) {
            System.out.println("ERROR: TEST DB INIT FAILED.");
            System.out.println(e.toString());
        }
    }

    @Test
    public void loginCompanyTest() {
        DB.Database db = DB.Database.getInstance();
        assertTrue(db.dbSelect.AuthenticateCompany("Buddy", "12345"));
        assertFalse(db.dbSelect.AuthenticateCompany("Buddy", "GOD IS DEAD"));
        assertFalse(db.dbSelect.AuthenticateCompany("UNREGISTERDCOMPANY", "12345"));
    }

    @Test
    public void loginAgentTest() {
        DB.Database db = DB.Database.getInstance();
        assertTrue(db.dbSelect.AuthenticateAgent("Agent_Mark", "PassWord"));
        assertFalse(db.dbSelect.AuthenticateAgent("Agent_Mark", "WrongPass"));
        assertFalse(db.dbSelect.AuthenticateAgent("Agent_Mork", "PassWord"));
    }

    @Test
    public void retrieveList_TTBIDTest() {
        Manufacturer man = new Manufacturer(123, null, null, null);
        Manufacturer man2 = new Manufacturer(456, null, null, null);
        List<Integer> list = db.dbSelect.getTTB_IDbyManufacturer(man);
        assertEquals(4, list.size());
        assertTrue(list.get(0) == 1);
        List<Integer> list2 = db.dbSelect.getTTB_IDbyManufacturer(man2);
        assertTrue(list2.size() == 0);
    }
    @Test
    public void retrieveFormTest(){
        Form form = db.dbSelect.getFormByTTB_ID(1);
        assertEquals("ABC", form.getFancifulName());
        assertEquals("123", form.getBrandName());
        assertEquals(true, form.getSource());
//not implemented        assertEquals(true, form.getApproval());
    }
    @Test
    public void retrieveManTest(){
        Manufacturer man = db.dbSelect.getManufacturer("Buddy");
        assertEquals(123, man.manID);
    }

    @Test
    public void searchByTest() {
        DB.Database db = DB.Database.getInstance();

        AdvancedSearch ASNone = new AdvancedSearch();
        AdvancedSearch ASBrand = new AdvancedSearch();
        ASBrand.setBrandName("123");
        AdvancedSearch ASType = new AdvancedSearch();
        ASType.setAlcoholType(AlcoholType.Wine);
        AdvancedSearch ASBoth = new AdvancedSearch();
        ASBoth.setBrandName("123");
        ASBoth.setAlcoholType(AlcoholType.MaltBeverage);

        SearchResult SRNone = new SearchResult();
        SearchResult SRBrand = new SearchResult();
        SearchResult SRType = new SearchResult();
        SearchResult SRBoth = new SearchResult();

        SRNone.addResult(new Form(AlcoholType.MaltBeverage, "123", (float)8.3));
        SRNone.addResult(new Form(AlcoholType.Wine, "Delio", (float)12.3));
        SRBrand.addResult(new Form(AlcoholType.MaltBeverage, "123", (float)8.3));
        SRType.addResult(new Form(AlcoholType.Wine, "Delio", (float)12.3));
        SRBoth.addResult(new Form(AlcoholType.MaltBeverage, "123", (float)8.3));

        assertEquals(SRNone.getResults().size(), db.dbSelect.searchBy(ASNone).getResults().size());
        assertEquals(SRBrand.getResults().size(), db.dbSelect.searchBy(ASBrand).getResults().size());
        assertEquals(SRType.getResults().size(), db.dbSelect.searchBy(ASType).getResults().size());
        assertEquals(SRBoth.getResults().size(), db.dbSelect.searchBy(ASBoth).getResults().size());


        System.out.println(SRBrand.getResults().get(0).getBrandName());
        System.out.println(db.dbSelect.searchBy(ASBrand).getResults().get(0).getBrandName());
    }


    @Test
    public void getThreeFormsTest(){
        assertEquals(2, db.dbSelect.getThreeForms().size());
    }

    /*@AfterClass
    public static void close(){
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException e) {}
    }*/
    }

