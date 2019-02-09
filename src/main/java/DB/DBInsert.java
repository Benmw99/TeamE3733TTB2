package DB;

import Entities.Address;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DBInsert {
    private static DBInsert dbinsert;
    private static SessionFactory factory;

    private DBInsert() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static class SingletonHelper {
        private static final DBInsert dbinsert = new DBInsert();
    }

    protected static DBInsert getDbinsert() {
        return SingletonHelper.dbinsert;
    }


    /**
     * Inserts an Address into the DB
     * @author Jordan
     * @param city
     * @param state
     * @param zip
     * @param street
     * @param name
     * @return The id of that address
     */
    public Integer insertAddress(String city, String state, String zip, String street, String name) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer addressID = null;

        try {
            tx = session.beginTransaction();
            Address address = new Address(city, state, zip, street, name);
            addressID = (Integer) session.save(address);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return addressID;

    }
}
