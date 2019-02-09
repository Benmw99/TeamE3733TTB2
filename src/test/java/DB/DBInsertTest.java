package DB;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DBInsertTest {
    @BeforeClass
    public static void setup() {
        DB.Database db = DB.Database.getDatabase();
        db.tableBuilder.resetDB();
    }

    @Test
    public void insertAddress() {
        DB.Database db = DB.Database.getDatabase();
        db.dbInsert.insertAddress("Worcester", "MA", "01609", "100 Institute Road", "John Smith");
        db.dbSelect.selectAllAddress();
    }
}