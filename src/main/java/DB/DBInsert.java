package DB;

import Entities.*;
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
     //* @param city
     //* @param state
     //* @param zip
     //* @param street
     //* @param name
     * @return The id of that address
     */
    /*
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

    }*/

    //TODO GET RID OF REPEATED CODE

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

    public void insertCompany(Company company) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(company);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void insertRep(Rep rep) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(rep);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public int insertAgent(Agent agent) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer agentID = null;
        try {
            tx = session.beginTransaction();
            agentID = (Integer) session.save(agent);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return agentID;
    }

    /**
     * Takes the form with a changed approval. This change of approval must be done by entities
     * @param form The form that was updated
     */
    public void updateApproval(Form form) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(form);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
