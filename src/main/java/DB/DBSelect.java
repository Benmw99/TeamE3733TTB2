package DB;

import Entities.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Class for handling all the selection operations of the database. Class is a singleton
public class DBSelect {
    private static DBSelect dbselect; //TODO GET RID OF REPEATED CODE
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
     * Gets all the addresses in the DB. CURRENTLY ONLY PRINTS THEM
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

    /**
     * Gets all the forms in the database.
     * @author Jordan
     * @return A list of all the forms in the database
     */
    public List<Form> selectAllForm() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Form> results = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            List forms = session.createQuery("FROM Form").list();
            for (Iterator iterator = forms.iterator(); iterator.hasNext();){
                Form form = (Form) iterator.next();


                Hibernate.initialize(form.brewersPermit);
                Hibernate.initialize(form.address);

                //form.getBrewersPermit().size();
                //form.getAddress().size();

                //Set that primary address
                for (int i = 0; i < form.getAddress().size(); i++) {
                    if (form.getAddress().get(i).isMailing()) {
                        form.setMailingAddress(form.getAddress().get(i));
                    }
                }

                results.add(form);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    /**
     * Gets a form from the database
     * @author Jordan
     * @param TTBID The ttb id of the form you want to retrieve
     * @return The selected form
     */
    public Form getFormByTTB_ID(int TTBID) {
        Session session = factory.openSession();
        String q = "FROM Form F WHERE F.ttbID = :id";
        Query query = session.createQuery(q);
        query.setParameter("id", TTBID);
        return (Form)query.getSingleResult();
    }

    /**
     * Authenticates a company login
     * @author Jordan
     * @param login String of the entered login
     * @param pass String of the entered password
     * @return True for successful login, false for failure
     */
    public boolean AuthenticateCompany(String login, String pass) {
        String q = "SELECT count(*) FROM Company C WHERE C.login = :login AND C.password = :pass";
        return Authenticate(q, login, pass);
    }

    /**
     * Authenticates an agent login
     * @author Jordan
     * @param login String of the entered login
     * @param pass String of the entered password
     * @return True for successful login, false for failure
     */
    public boolean AuthenticateAgent(String login, String pass) {
        String q = "SELECT count(*) FROM Agent C WHERE C.login = :login AND C.password = :pass";
        return Authenticate(q, login, pass);
    }

    /**
     * Authenticates a rep login
     * @author Jordan
     * @param login String of the entered login
     * @param pass String of the entered password
     * @return True for successful login, false for failure
     */
    public boolean AuthenticateRep(String login, String pass) {
        String q = "SELECT count(*) FROM Rep C WHERE C.login = :login AND C.password = :pass";
        return Authenticate(q, login, pass);
    }

    /**
     * Authenticates a passed query, checking that there is 1 result in the database
     * @author Jordan
     * @param q String of the query to be used
     * @param login String of the entered login
     * @param pass String of the entered password
     * @return True for successful login, false for failure
     */
    protected boolean Authenticate(String q, String login, String pass) {
        Session session = factory.openSession();
        Query query = session.createQuery(q);
        query.setParameter("login", login);
        query.setParameter("pass", pass);
        int result = 0;
        Long temp;
        final Object obj = query.uniqueResult();
        if (obj != null) {
            temp = (Long) obj;
            result = temp.intValue();
        }
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Searches by a set of info and returns any forms that match those
     * CURRENTLY WINE SEARCHING FOR TYPES DON'T WORK
     * @author Jordan
     * @param as Advanced search with the things that want to be search for set
     * @return A SearchResult with all the forms that came from the query
     */
    public SearchResult searchBy(AdvancedSearch as) {
        Session session = factory.openSession();
        Transaction tx = null;
        SearchResult result = new SearchResult();
        result.setSearch(as);
        List<Form> forms = new ArrayList<>();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Form> cr = cb.createQuery(Form.class);
        Root<Form> root = cr.from(Form.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(root.get("approvalStatus"), as.approvalStatus));
        if (as.source != null) {
            predicates.add(cb.equal(root.get("source"), as.source));
        }
        if (as.serialNumber != null) {
            predicates.add(cb.equal(root.get("serialNumber"), as.serialNumber));
        }
        if (as.alcoholType != null) {
            predicates.add(cb.equal(root.get("alcoholType"), as.alcoholType));
        }
        if (as.brandName != null) {
            predicates.add(cb.equal(root.get("brandName"), as.brandName));
        }
        if (as.fancifulName != null) {
            predicates.add(cb.equal(root.get("fancifulName"), as.fancifulName));
        }
        if (as.getAlcoholType() == AlcoholType.Wine && as.vintageYear > 0) {
            //predicates.add(cb.equal(root.get("wineFormItems.vintageYear"), as.vintageYear));
        }
        if (as.getAlcoholType() == AlcoholType.Wine && as.pH > 0) {
            //
        }
        if (as.getAlcoholType() == AlcoholType.Wine && as.grapeVarietal != null) {
            //
        }
        if (as.getAlcoholType() == AlcoholType.Wine && as.appellation != null) {
            //
        }
        if (as.ttbID > 0) {
            predicates.add(cb.equal(root.get("ttbID"), as.ttbID));
        }
        cr.select(root).where(predicates.toArray(new Predicate[]{}));

        try {
            tx = session.beginTransaction();
            List<Form> results = session.createQuery(cr).list();
            for (Iterator iterator = results.iterator(); iterator.hasNext();){
                Form form = (Form) iterator.next();


                Hibernate.initialize(form.brewersPermit);
                Hibernate.initialize(form.address);

                //form.getBrewersPermit().size();
                //form.getAddress().size();

                //Set that primary address
                for (int i = 0; i < form.getAddress().size(); i++) {
                    if (form.getAddress().get(i).isMailing()) {
                        form.setMailingAddress(form.getAddress().get(i));
                    }
                }
                forms.add(form);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        result.setResults(forms);
        return result;
    }

    //TODO IMPLEMENT public boolean downloadResults
}
