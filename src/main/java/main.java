import Entities.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Iterator;

public class main {
    //private static SessionFactory factory;

    public static void main(String[] args) {
        DB.Database db = DB.Database.getDatabase();
        db.tableBuilder.resetDB();
        db.dbInsert.insertCompany(new Manufacturer(123, "Brewers Inc.", "man1", "pass"));
        db.dbInsert.insertAgent(new Agent("TestAgent", "1234", "Sam Adamster"));
        db.dbInsert.insertRep(new Representative("123abc", "TestRep", "1234"));
        System.out.println("Hello Iteration 2!");
        UI.MainUI.main( args);
    }
}