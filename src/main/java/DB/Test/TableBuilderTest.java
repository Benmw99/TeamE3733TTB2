package DB.Test;

import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TableBuilderTest {
    @BeforeClass
    public static void setup() {
        DB.Database db = DB.Database.getInstance();
        db.tableBuilder.resetDB();
        Timestamp timestamp = Timestamp.valueOf("2007-09-23 10:10:10.0");
        try {
            db.dbInsert.insertCompany(12345, "Budweiser", "test123", "qwerty");
            db.dbInsert.insertForm("123", "Bud-lite", "Bud", true, false, null, "123@gmail.com", 12345, timestamp, "John", "7817817811", 2, 1.0);
            db.dbInsert.insertAddress("12345", true, "Worcester", "MA", "100 Road Road", 1);
            db.dbInsert.insertAddress("67890", false, "Acton", "MA", "200 Street Street", 1);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void selectAllCompany() {
        DB.Database db = DB.Database.getInstance();
        ResultSet rset = db.dbSelect.selectAllCompany();
        int compID = 0;
        String compName = "";
        String loginName = "";
        String password = "";
        try {
            while (rset.next()) {
                compID = rset.getInt("Company_ID");
                compName = rset.getString("Company_Name");
                loginName = rset.getString("Login_Name");
                password = rset.getString("Password");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        assertEquals(12345, compID);
        assertEquals("Budweiser", compName);
        assertEquals("test123", loginName);
        assertEquals("qwerty", password);
    }

    @Test
    public void selectAllAddress() {
        DB.Database db = DB.Database.getInstance();
        ResultSet rset = db.dbSelect.selectAllAddress();
        String id = "";
        String street = "";
        try {
            while (rset.next()) {
                id += rset.getInt("ID") + ",";
                street += rset.getString("Street") + ",";
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        assertEquals("1,2,", id);
        assertEquals("100 Road Road,200 Street Street,", street);
    }

    /*@AfterClass
    public static void close() {
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException e) {}
    }*/
}