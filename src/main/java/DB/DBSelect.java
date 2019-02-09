package DB;

import Entities.Address;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class DBSelect {
    private static DBSelect dbselect;
    private static SessionFactory factory;

    private DBSelect() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static class SingletonHelper {
        private static final DBSelect dbselect = new DBSelect();
    }

    protected static DBSelect getDbselect() {
        return SingletonHelper.dbselect;
    }


    /**
     * Gets all the addresses in the DB, CURRENTLY ONLY PRINTS THEM
     * @author Jordan
     */
    public void selectAllAddress() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List addresses = session.createQuery("FROM Address").list();
            for (Iterator iterator = addresses.iterator(); iterator.hasNext();){
                Address employee = (Address) iterator.next();
                System.out.println(employee.getName() + "\n" + employee.getStreet() + " " + employee.getCity() + " " + employee.getState() + " " + employee.getZip());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
