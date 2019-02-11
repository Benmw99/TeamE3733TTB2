package DB;

import Entities.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Class controlling inserting and updating in DB. Singleton class
public class DBInsert {
    private static DBInsert dbinsert; //TODO GET RID OF REPEATED CODE
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

    static DBInsert getDbinsert() {
        return SingletonHelper.dbinsert;
    }

    /**
     * Inserts a full form into the database. All relations must be set in the form
     * @author Jordan
     * @param form The fully completed form to be submitted. Approval should be set as a default incomplete.
     * @return The TTB ID of the form that was just inserted
     */
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

    /**
     * Inserts a company into the database.
     * @author Jordan
     * @param company A fully filled out company
     */
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

    /**
     * Inserts a rep into the database
     * @author Jordan
     * @param rep A fully filled out rep to be inserted
     */
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

    /**
     * Inserts an agent into the database
     * @author Jordan
     * @param agent The agent created and filled out with all info except id
     * @return The agent id of the newly inserted agent
     */
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
     * @author Jordan
     * @param form The form that was updated
     */
    public void updateApproval(Form form) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //Merge is used as an update pretty much
            session.merge(form);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    /**
     * Inserts a labelImage into the database
     * @author Jordan
     * @param li The labelimage that you want to insert with everything except the id filled out
     */
    public void insertLabelImage(LabelImage li) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(li);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
