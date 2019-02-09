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
        System.out.println("Hello Iteration 2!");
        DB.Database db = DB.Database.getDatabase();
        db.tableBuilder.resetDB();
        System.out.println("Finished!");


        /*try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }*/
    }
}