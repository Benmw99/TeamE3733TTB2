package DB;

import Entities.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        result.setQuery(null);
        return result;
    }

    /** //TODO FINISH THIS
     * A wildcard sql search of the database for brand name and fanciful name
     * @author Jordan
     * @param as An advanced search that has all the fields that want to be searched for set
     * @return A list of forms of everything that matched that wildcard search
     */
    public List<Form> searchByWild(AdvancedSearch as) {

    }

    /** //TODO FINISH THIS
     * Gets a list of all potential brand names for the LD search that match the first criteria
     * @author Jordan
     * @param as An AdvancedSearch that contains all the search criteria except for anything that will be searched for using LD
     * @return A list of strings of brand names that match those first basic search criteria
     */
    public List<String> searchByLD(AdvancedSearch as) {

    }

    /**
     * Part of the LD search. Finds anything matching the trimmed list of LD brand name strings
     * @author Jordan
     * @param as The advanced search that contains the search criteria for everything else
     * @param brands A list of all the brand names that should be searched for
     * @return A list of all forms that matched any of those brand names in addition to the other results
     */
    public List<Form> searchByLDBrand(AdvancedSearch as, List<String> brands) {
        List<Form> results = new ArrayList<>();
        for (int i = 0; i < brands.size(); i++) {
            as.setBrandName(brands.get(i));
            List<Form> tempResult = new ArrayList<>();
            tempResult = searchBy(as).getResults();
            for (int j = 0; j < tempResult.size(); j++) {
                results.add(tempResult.get(j));
            }
        }
        return results;
    }

    //TODO FINISH THIS
    public Form getNextUnapproved() {
        Session session = factory.openSession();
        String q = "FROM Form F WHERE F.approvalStatus = :approval";
        Query query = session.createQuery(q);
        query.setParameter("approval", ApprovalStatus.Incomplete);
        return (Form)query.getSingleResult();
    }


    /**
     * Generates the query to be used for downloading as a search result.
     * @author Jordan
     * @param sr The searchresult of the query to be downloaded
     */
    private void generateQuery(SearchResult sr) {
        AdvancedSearch as = sr.getSearch();
        if (sr.getQuery() == null || sr.getQuery().equals("")) {
            String baseString;
            if (as.getAlcoholType().toInt() == AlcoholType.Wine.toInt() && ((as.vintageYear > 0) || (as.pH > 0) || (as.grapeVarietal != null) || (as.appellation != null))) {
                baseString = "SELECT TTB_ID, Serial_Number, Fanciful_Name, Brand_Name, Alcohol_Type, APV FROM Form JOIN Wine ON Form.TTB_ID = Wine.TTB_ID WHERE APPROVE = 1";
            } else {
                baseString = "SELECT TTB_ID, Serial_Number, Fanciful_Name, Brand_Name, Alcohol_Type, APV FROM Form WHERE APPROVE = 1";
            }
            if (as.source != null) {
                baseString += " AND Source = ?";
            }
            if (as.serialNumber != null) {
                baseString += " AND Serial_Number = ?";
            }
            if (as.alcoholType != null) {
                baseString += " AND Alcohol_Type = " + as.getAlcoholType().toInt();
            }
            if (as.brandName != null) {
                baseString += " AND Brand_Name = ?";
            }
            if (as.fancifulName != null) {
                baseString += " AND Fanciful_Name = ?";
            }
            if (as.getAlcoholType().toInt() == 1 && as.vintageYear > 0) {
                baseString += " AND Vintage = ?";
            }
            if (as.getAlcoholType().toInt() == 1 && as.pH > 0) {
                baseString += " AND PH = ?";
            }
            if (as.getAlcoholType().toInt() == 1 && as.grapeVarietal != null) {
                baseString += " AND Grape_Varietals = ?";
            }
            if (as.getAlcoholType().toInt() == 1 && as.appellation != null) {
                baseString += " AND Wine_Appellation = ?";
            }
            if (as.ttbID > 0) {
                baseString += " AND TTB_ID = ?";
            }
            sr.setQuery(baseString);
        }
    }

    /**
     * Downloads the search result as a file onto the computer
     * @author Jordan
     * @param sr The searchresult that you want printed
     * @param isCSV Whether or not it should be printed as a csv. True for csv, false for ASCII-Deliminated
     * @return True if it succeeds, false if it fails
     */
    public boolean downloadQuery(SearchResult sr, boolean isCSV) {
        generateQuery(sr);
        Connection connection = null;
        try {
            String driver = "org.apache.derby.jdbc.EmbeddedDriver";
            Class.forName(driver).newInstance();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        try {
            String path = "./ttb.db";
            connection = DriverManager.getConnection("jdbc:derby:" + path + ";create=true");
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        java.util.Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String download = "CALL SYSCS_UTIL.SYSCS_EXPORT_QUERY (?,?,?,?,?)";
        AdvancedSearch search = sr.getSearch();
        try {
            PreparedStatement ps = connection.prepareStatement(download);
            ps.setString(1, sr.getQuery());
            int set = 2;
            if (search.source != null) {
                ps.setBoolean(set, search.source);
                set += 1;
            }
            if (search.serialNumber != null) {
                ps.setString(set, search.serialNumber);
                set += 1;
            }
            if (search.brandName != null) {
                ps.setString(set, search.brandName);
                set += 1;
            }
            if (search.fancifulName != null) {
                ps.setString(set, search.fancifulName);
                set += 1;
            }
            if (search.alcoholType.toInt() == AlcoholType.Wine.toInt() && search.vintageYear > 0) {
                ps.setInt(set, search.vintageYear);
                set += 1;
            }
            if (search.alcoholType.toInt() == AlcoholType.Wine.toInt() && search.pH > 0) {
                ps.setFloat(set, search.pH);
                set += 1;
            }
            if (search.alcoholType.toInt() == AlcoholType.Wine.toInt() && search.grapeVarietal != null) {
                ps.setString(set, search.grapeVarietal);
                set += 1;
            }
            if (search.alcoholType.toInt() == AlcoholType.Wine.toInt() && search.appellation != null) {
                ps.setString(set, search.appellation);
                set += 1;
            }
            if (search.ttbID > 0) {
                ps.setInt(set, search.ttbID);
                set += 1;
            }
            if (isCSV) {
                ps.setString(set,"TTBSearch" + dateFormat.format(date) + ".csv");
                ps.setString(set + 1,null);
                ps.setString(set + 2,null);
                ps.setString(set + 3,null);
                ps.execute();
                ps.close();
            } else {
                ps.setString(set,"TTBSearch" + dateFormat.format(date) + ".txt");
                ps.setString(set + 1,String.valueOf((char)30));
                ps.setString(set + 2,String.valueOf((char)31));
                ps.setString(set + 3,null);
                ps.execute();
                ps.close();
            }
            connection.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves a list of all the label images involved with that ttb id
     * @author Jordan
     * @param ttbID the ttbid that you want to retrieve all the images of
     * @return A list that contains all the label images from that selected ttb id
     */
    public List<LabelImage> selectImagesbyTTBID(int ttbID) {
        List<LabelImage> results = new ArrayList<>();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String q = "FROM LabelImage L WHERE L.ttbID = :id";
            Query query = session.createQuery(q);
            query.setParameter("id", ttbID);
            List images = query.list();
            for (Iterator iterator = images.iterator(); iterator.hasNext();){
                LabelImage image = (LabelImage) iterator.next();
                results.add(image);
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
}
