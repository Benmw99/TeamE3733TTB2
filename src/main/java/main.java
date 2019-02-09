import DB.TableBuilder;
import Entities.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Iterator;

public class main {
    private static SessionFactory factory;

    public static void main(String[] args) {
        System.out.println("Hello Iteration 2!");
        DB.TableBuilder tb = DB.TableBuilder.getTablebuilder();
        tb.resetDB();

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        main m = new main();
        m.insertAddress("Worcester", "MA", "01609", "100 Institute Road", "John Smith");
        m.listAddress();
    }

    public Integer insertAddress(String city, String state, String zip, String street, String name) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer addressID = null;

        try {
            tx = session.beginTransaction();
            Address address = new Address();
            address.setCity(city); //All of these can be replaced by creating a correct constructor that puts things in
            address.setState(state);
            address.setZip(zip);
            address.setStreet(street);
            address.setName(name);
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

    public void listAddress() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            @SuppressWarnings("JpaQlInspection") List addresses = session.createQuery("FROM Address").list();
            for (Iterator iterator = addresses.iterator(); iterator.hasNext();){
                Address employee = (Address) iterator.next();
                System.out.print(employee.getName() + " " + employee.getStreet() + " " + employee.getCity() + " " + employee.getState() + " " + employee.getZip());
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