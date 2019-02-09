package DB;

import Entities.Address;
import Entities.Form;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBInsert {
    private static DBInsert dbinsert;
    private static SessionFactory factory; //TODO ONE SESSIONFACTORY, INTERFACE THAT INCLUDES CLOSING METHOD

    private DBInsert() {
        try {
            //factory = new Configuration().configure().buildSessionFactory();
            factory = new Configuration().configure().addAnnotatedClass(Address.class).buildSessionFactory();
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
     * OUTDATED AND DOESN'T FULLY WORK
     * Inserts an Address into the DB
     * @author Jordan
     * @param city
     * @param state
     * @param zip
     * @param street
     * @param name
     * @return The id of that address
     */
    public Integer insertAddress(String city, String state, String zip, String street, String name, boolean isPrimary) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer addressID = null;

        try {
            tx = session.beginTransaction();
            Address address = new Address(city, state, zip, street, name, isPrimary);
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

    public int insertForm(Form form) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer formID = null;

        try {
            tx = session.beginTransaction();
            formID = (Integer) session.save(form);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return formID;
    }
}
