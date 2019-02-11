package DB.Test;

import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class InsertTest {
    @BeforeClass
    public static void setup() {
        DB.Database db = DB.Database.getInstance();
        db.tableBuilder.resetDB();
        Timestamp timestamp = Timestamp.valueOf("2007-09-23 10:10:10.0");
        try {
            db.dbInsert.insertCompany(12345, "Budweiser", "test123", "qwerty");
            db.dbInsert.insertForm("12112", "Buddy", "Budweiser", true, false, null, "abc@gmail.com",
                    12345, timestamp, "ABC", "12312124", 2, 1.0);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void checkNullForm() {
        DB.Database db = DB.Database.getInstance();
        try {
            //This format is key to freeing the resources so lockouts don't occur.
            ResultSet rset = db.dbSelect.selectAllForms();
            int answer = rset.getFetchSize();
            rset.close();
            assertTrue(answer > 0);
        } catch(SQLException e){
            System.out.println(e.toString());
        }
    }

    /*@AfterClass
    public static void close(){
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException e) {}
    }*/
}