package DB;

import Entities.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class DBSelectTest {
    @BeforeClass
    public static void setup() {
        DB.Database db = DB.Database.getDatabase();
        db.tableBuilder.resetDB();
        //db.dbInsert.insertData();


        db.dbInsert.insertCompany(new Manufacturer(123, "Brewers Inc.", "TestCompany", "1234"));
        db.dbInsert.insertAgent(new Agent("TestAgent", "1234", "Sam Adamster"));
     //   db.dbInsert.insertRep(new Representative("123abc", "TestRep", "1234"));

        //Oh boy lets make a complete form
        List<BrewersPermit> Brews = new ArrayList<>();
        Brews.add(new BrewersPermit("123ABC", true));
        Brews.add(new BrewersPermit("456DEF", false));

        List<Address> Adds = new ArrayList<>();
        Adds.add(new Address("Worcester", "MA", "01609", "100 Institue Road", "John Smith", true));
        Adds.add(new Address("Acton", "MA", "123456", "2 Street Ave", "Bob Dijon", false));

        long milli = System.currentTimeMillis();
        Date d = new Date(milli);

        Form form = new Form(null, Brews, true, "00123SE", AlcoholType.MaltBeverage, "Bubbly", "BU", Adds, "John Smith", null, null, "1112223333", "john@johnmail.com", "No other info", d, 123, new Approval(), (float)12.3, ApprovalStatus.Complete);

        db.dbInsert.insertForm(form);


        List<BrewersPermit> Brews1 = new ArrayList<>();
        Brews1.add(new BrewersPermit("789CAB", true));
        Brews1.add(new BrewersPermit("9432LOT", false));

        List<Address> Adds1 = new ArrayList<>();
        Adds1.add(new Address("Aberdeen", "SD", "57401", "677 Mill St", "Alfred Reds", true));
        Adds1.add(new Address("Willoughby", "OH", "44094", "9 1st St", "Tim St. Ayys", false));

        long milli1 = System.currentTimeMillis();
        Date d1 = new Date(milli1);

        Form form1 = new Form(null, Brews1, false, "56799BD", AlcoholType.DistilledLiquor, "VodWine", "VW", Adds1, "Alfred Redster", "18900f", null, "1112223333", "Bobert@johnmail.com", "750ml on bottle", d1, 123, new Approval(), (float)43.43, ApprovalStatus.Incomplete);
        form1.setWorkingOn(0);

        db.dbInsert.insertForm(form1);

    }

    @Test
    public void getFormByTTB_ID() {
        DB.Database db = DB.Database.getDatabase();
        Form ans = db.dbSelect.getFormByTTB_ID(1);
        System.out.println(ans.getTtbID() + " " + ans.getBrandName());
    }

    @Test
    public void authenticateCompany() {
        DB.Database db = DB.Database.getDatabase();
        assertTrue(db.dbSelect.AuthenticateCompany("TestCompany", "1234"));
        assertFalse(db.dbSelect.AuthenticateCompany("Fake", "1234"));
        assertFalse(db.dbSelect.AuthenticateCompany("TestCompany", "Fake"));
    }

    @Test
    public void authenticateAgent() {
        DB.Database db = DB.Database.getDatabase();
        assertTrue(db.dbSelect.AuthenticateAgent("TestAgent", "1234"));
        assertFalse(db.dbSelect.AuthenticateAgent("Fake", "1234"));
        assertFalse(db.dbSelect.AuthenticateAgent("TestAgent", "Fake"));
    }

    @Test
    public void authenticateRep() {
        DB.Database db = DB.Database.getDatabase();
        assertTrue(db.dbSelect.AuthenticateRep("TestRep", "1234"));
        assertFalse(db.dbSelect.AuthenticateRep("Fake", "1234"));
        assertFalse(db.dbSelect.AuthenticateRep("TestRep", "Fake"));
    }

    @Test
    public void searchBy() {
        DB.Database db = DB.Database.getDatabase();

        AdvancedSearch as1 = new AdvancedSearch();
        as1.setAlcoholType(AlcoholType.MaltBeverage);

        AdvancedSearch as2 = new AdvancedSearch();
        as2.setBrandName("VodWine");

        AdvancedSearch as3 = new AdvancedSearch();

        SearchResult sr1 = db.dbSelect.searchBy(as1);
        SearchResult sr2 = db.dbSelect.searchBy(as2);
        SearchResult sr3 = db.dbSelect.searchBy(as3);

        System.out.println("as1");
        for (int i = 0; i < sr1.getResults().size(); i++) {
            System.out.println(sr1.getResults().get(i).getBrandName());
        }

        System.out.println("as2");
        for (int i = 0; i < sr2.getResults().size(); i++) {
            System.out.println(sr2.getResults().get(i).getBrandName());
        }

        System.out.println("as3");
        for (int i = 0; i < sr3.getResults().size(); i++) {
            System.out.println(sr3.getResults().get(i).getBrandName());
        }
    }

    @Test
    public void searchByWild() {
        DB.Database db = DB.Database.getDatabase();

        AdvancedSearch as1 = new AdvancedSearch();
        as1.setBrandName("Vod");

        AdvancedSearch as2 = new AdvancedSearch();
        as2.setBrandName("wine");

        AdvancedSearch as3 = new AdvancedSearch();
        as3.setBrandName("in");

        SearchResult sr1 = db.dbSelect.searchByWild(as1);
        SearchResult sr2 = db.dbSelect.searchByWild(as2);
        SearchResult sr3 = db.dbSelect.searchByWild(as3);

        System.out.println("as1 Wild");
        for (int i = 0; i < sr1.getResults().size(); i++) {
            System.out.println(sr1.getResults().get(i).getBrandName());
        }

        System.out.println("as2 Wild");
        for (int i = 0; i < sr2.getResults().size(); i++) {
            System.out.println(sr2.getResults().get(i).getBrandName());
        }

        System.out.println("as3 Wild");
        for (int i = 0; i < sr3.getResults().size(); i++) {
            System.out.println(sr3.getResults().get(i).getBrandName());
        }
    }

    /*@Test
    public void testDownload() {
        DB.Database db = DB.Database.getDatabase();

        AdvancedSearch as = new AdvancedSearch();

        SearchResult sr = db.dbSelect.searchBy(as);

        db.dbSelect.downloadQuery(sr, true);
        db.dbSelect.downloadQuery(sr, false);
    }*/

    @Test
    public void searchByLD() {
        DB.Database db = DB.Database.getDatabase();

        AdvancedSearch as = new AdvancedSearch();
        as.setAlcoholType(AlcoholType.MaltBeverage);
        as.setBrandName("Bubbly");
        List<String> temp = db.dbSelect.searchByLD(as);

        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
    }

    @Test
    public void testInsertData() {
        DB.Database db = DB.Database.getDatabase();
        AdvancedSearch as = new AdvancedSearch();
        SearchResult temp = db.dbSelect.searchBy(as);
        System.out.println(temp.getResults().size());
    }

    @Test
    public void testApprovalMerges() {
        DB.Database db = DB.Database.getDatabase();
        Form pulled = db.dbSelect.getFormByTTB_ID(2);
        //Proving that the pulled form is at first not set approved and doesn't have a qualification
        assertThat(ApprovalStatus.Complete, not(pulled.getApprovalStatus()));
        assertThat("Can't be used because this program isn't real", not(pulled.getApproval().getQualifications()));

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

        Form pulledUpdate = db.dbSelect.getFormByTTB_ID(2);
        //Proves that the updated form is succesfully set and updated
        assertEquals(ApprovalStatus.Complete, pulledUpdate.getApprovalStatus());
        assertEquals("Can't be used because this program isn't real", pulledUpdate.getApproval().getQualifications());
    }

    //Hardcoded tests cause I'm a scrub sometimes
    @Test
    public void testWorkingOnMerge() {
        DB.Database db = DB.Database.getDatabase();

        Form newForm = db.dbSelect.getNextUnapproved();
        //Check that it retrieved the form that was not approved and has no one working on it.
        assertEquals(2, newForm.getTtbID());
        newForm.setWorkingOn(1);
        db.dbSelect.updateWorkingOn(newForm);

        Form checkWorkingOn = db.dbSelect.getFormByTTB_ID(2);
        //Checks that workingOn was actually updated
        assertEquals(1, checkWorkingOn.getWorkingOn());
        //Checks that it can't get another form, which means the first is claimed
        assertNull(db.dbSelect.getNextUnapproved());

        List<Form> currentQ = db.dbSelect.getCurrentApprovalQueue(1);
        assertEquals(1, currentQ.size());
        assertEquals(1, currentQ.get(0).getWorkingOn());
    }
}