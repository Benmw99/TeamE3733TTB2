package DB;

import Entities.Address;
import Entities.Form;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class DBSelect {
    private static DBSelect dbselect;
    private static SessionFactory factory; //TODO ONE SESSIONFACTORY, INTERFACE THAT INCLUDES CLOSING METHOD

    private DBSelect() {
        try {
            //factory = new Configuration().configure().buildSessionFactory();
            factory = new Configuration().configure().addAnnotatedClass(Address.class).buildSessionFactory();
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

    public void selectAllForm() { //TODO ADD MORE TO TEST THAT THIS WORKS
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List forms = session.createQuery("FROM Form").list();
            for (Iterator iterator = forms.iterator(); iterator.hasNext();){
                Form form = (Form) iterator.next();

                form.getBrewersPermit().size();
                form.getAddress().size();

                System.out.println(form.getBrewersPermit().size());
                System.out.println(form.getAddress().size());

                System.out.println(form.getTtbID());
                //System.out.println(form.getApproval().getPage1().toInt());
                //System.out.println(form.getWineFormItems().getId());
                System.out.println(form.getBrewersPermit().get(0).getBrewersNo());
                System.out.println(form.getBrewersPermit().get(1).getBrewersNo());
                System.out.println(form.getAddress().get(0).getStreet());
                System.out.println(form.getAddress().get(1).getStreet());
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
