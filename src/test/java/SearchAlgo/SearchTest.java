package SearchAlgo;

import Entities.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SearchTest {
    @BeforeClass
    public static void setup() {
        DB.Database db = DB.Database.getDatabase();
        db.tableBuilder.resetDB();

        db.dbInsert.insertCompany(new Manufacturer(123, "Brewers Inc.", "TestCompany", "1234"));
        db.dbInsert.insertAgent(new Agent("TestAgent", "1234", "Sam Adamster"));
        db.dbInsert.insertRep(new Representative("123abc", "TestRep", "1234"));

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

        Form form1 = new Form(null, Brews1, false, "56799BD", AlcoholType.DistilledLiquor, "VodWine", "VW", Adds1, "Alfred Redster", "18900f", null, "1112223333", "Bobert@johnmail.com", "750ml on bottle", d1, 123, new Approval(), (float)43.43, ApprovalStatus.Complete);

        db.dbInsert.insertForm(form1);
    }

    @Test
    public void searchDLBrand1() {
        AdvancedSearch advancedSearch = new AdvancedSearch();
        advancedSearch.setAlcoholType(AlcoholType.MaltBeverage);
        advancedSearch.setBrandName("Bubbly");
        List<Form> test = Search.SearchDLBrand(advancedSearch, new DamerauLevenshtein());
        assertTrue( test.get(0).getBrandName().equals("Bubbly"));

    }

    @Test
    public void searchDLBrand2() {
        AdvancedSearch advancedSearch = new AdvancedSearch();
        advancedSearch.setAlcoholType(AlcoholType.MaltBeverage);
        advancedSearch.setBrandName("Buly");
        List<Form> test = Search.SearchDLBrand(advancedSearch, new DamerauLevenshtein());
        assertTrue( test.get(0).getBrandName().equals("Bubbly"));

    }

    @Test
    public void searchDLBrand3() {
        AdvancedSearch advancedSearch = new AdvancedSearch();
        advancedSearch.setAlcoholType(AlcoholType.MaltBeverage);
        advancedSearch.setBrandName("uBblby");
        List<Form> test = Search.SearchDLBrand(advancedSearch, new DamerauLevenshtein());
        assertTrue( test.get(0).getBrandName().equals("Bubbly"));

    }

    @Test
    public void searchDLBrand4() {
        AdvancedSearch advancedSearch = new AdvancedSearch();
        advancedSearch.setAlcoholType(AlcoholType.MaltBeverage);
        List<Form> test = Search.SearchDLBrand(advancedSearch, new DamerauLevenshtein());
        assertTrue( test.get(0).getBrandName().equals("Bubbly"));

    }

    @Test
    public void algTest1() {
        ArrayList<String> test = new ArrayList<>();
        test.add("Dickson");
        test.add("Fickson");
        test.add(("Dickon"));
        test.add(("Dcksn"));
        test.add(("Diickson"));
        test.add(("Dikcson"));
        test.add(("Dickskin"));
        test.add(("iDckosn"));
        test.add(("Cheese"));
        test.add(("Roger"));
        Context fuzzyAlgo = new Context();
        fuzzyAlgo.setContext(new LevenshteinDistance());
        List<String> l1 = fuzzyAlgo.run(test,2,"Dickson");
        fuzzyAlgo.setContext(new DamerauLevenshtein());
        List<String> l2 = fuzzyAlgo.run(test,2,"Dickson");
        assertFalse(l1.contains("Cheese"));
        assertFalse(l2.contains("Cheese"));
        assertTrue(l1.contains("Dcksn"));
        assertTrue(l1.contains("Dickskin"));
        assertFalse(l1.contains("iDckosn"));
        assertTrue(l2.contains("iDckosn"));

    }

}