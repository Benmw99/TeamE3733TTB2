package DB;

import Entities.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.SequenceGenerator;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

    public List<Form> selectAllForm() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Form> results = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            List forms = session.createQuery("FROM Form").list();
            for (Iterator iterator = forms.iterator(); iterator.hasNext();){
                Form form = (Form) iterator.next();

                //Initialize brewers permit and address
                //TODO SWITCH TO ACTUAL INITIALIZE FUNCTION
                form.getBrewersPermit().size();
                form.getAddress().size();

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

    public Form getFormByTTB_ID(int TTBID) {
        Session session = factory.openSession();
        String q = "FROM FORM F WHERE F.TTB_ID = :id";
        Query query = session.createQuery(q);
        query.setParameter("id", TTBID);
        return (Form)query.getSingleResult();
    }

    public boolean AuthenticateCompany(String login, String pass) {
        String q = "SELECT count(*) FROM COMPANY C WHERE C.Login_Name = :login AND C.Password = :pass";
        return Authenticate(q, login, pass);
    }

    public boolean AuthenticateAgent(String login, String pass) {
        String q = "SELECT count(*) FROM AGENTS C WHERE C.Login_Name = :login AND C.Password = :pass";
        return Authenticate(q, login, pass);
    }

    public boolean AuthenticateRep(String login, String pass) {
        String q = "SELECT count(*) FROM REPS C WHERE C.Login_Name = :login AND C.Password = :pass";
        return Authenticate(q, login, pass);
    }

    protected boolean Authenticate(String q, String login, String pass) {
        Session session = factory.openSession();
        Query query = session.createQuery(q);
        query.setParameter("login", login);
        query.setParameter("pass", pass);
        int result = 0;
        final Object obj = query.uniqueResult();
        if (obj != null) {
            result = (Integer) obj;
        }
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    public SearchResult searchBy(AdvancedSearch as) {
        Session session = factory.openSession();
        Transaction tx = null;
        SearchResult result = new SearchResult();
        result.setSearch(as);
        List<Form> forms = new ArrayList<>();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Form> cr = cb.createQuery(Form.class);
        Root<Form> root = cr.from(Form.class);
        Predicate[] predicates = new Predicate[10];
        if (as.source != null) {
            predicates[0] = cb.equal(root.get("source"), as.source);
        }
        if (as.serialNumber != null) {
            predicates[1] = cb.equal(root.get("serialNumber"), as.serialNumber);
        }
        if (as.alcoholType != null) {
            predicates[2] = cb.equal(root.get("alcoholType"), as.alcoholType);
        }
        if (as.brandName != null) {
            predicates[3] = cb.equal(root.get("brandName"), as.brandName);
        }
        if (as.fancifulName != null) {
            predicates[4] = cb.equal(root.get("fancifulName"), as.fancifulName);
        }
        if (as.getAlcoholType() == AlcoholType.Wine && as.vintageYear > 0) {
            //predicates[5] = cb.equal(root.get("vintage"), as.vintageYear);
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
            predicates[9] = cb.equal(root.get("ttbID"), as.ttbID);
        }
        cr.select(root).where(predicates);
        Query<Form> query = session.createQuery(cr);

        try {
            tx = session.beginTransaction();
            List<Form> results = query.getResultList();
            for (Iterator iterator = results.iterator(); iterator.hasNext();){
                Form form = (Form) iterator.next();

                //Initialize brewers permit and address
                //TODO SWITCH TO ACTUAL INITIALIZE FUNCTION
                form.getBrewersPermit().size();
                form.getAddress().size();

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
}
