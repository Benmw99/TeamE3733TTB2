package DB;

import Entities.*;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.Transient;
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
    }

    private static class SingletonHelper {
        private static final DBSelect dbselect = new DBSelect();
    }

    static DBSelect getDbselect() {
        return SingletonHelper.dbselect;
    }

    public static void setFactory(SessionFactory factory) {
        DBSelect.factory = factory;
    }

    /**
     * Gets all the forms in the database.
     * @author Jordan
     * @return A list of all the forms in the database
     */
    public List<Form> selectAllForm() {
        //Creates a new session and transaction
        Session session = factory.openSession();
        Transaction tx = null;
        List<Form> results = new ArrayList<>();

        try {
            //Starts the transaction
            tx = session.beginTransaction();
            //Sends the query off and gets the results as a list
            List forms = session.createQuery("FROM Form").list();
            //Iterates through that list initiazing and setting stuff
            for (Iterator iterator = forms.iterator(); iterator.hasNext();){
                Form form = (Form) iterator.next();

                //Initializes the brewersPermit and the address
                Hibernate.initialize(form.brewersPermit);
                Hibernate.initialize(form.address);

                //Previous way of initiliazation
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
            //Commit the transaction
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            //Close the session
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
        Form form = (Form)query.getSingleResult();
        Hibernate.initialize(form.brewersPermit);
        Hibernate.initialize(form.address);
        for (int i = 0; i < form.getAddress().size(); i++) {
            if (form.getAddress().get(i).isMailing()) {
                form.setMailingAddress(form.getAddress().get(i));
            }
        }
        session.close();
        return form;
    }

    /**
     * Authenticates a company login
     * @author Jordan
     * @param login String of the entered login
     * @param pass String of the entered password
     * @return True for successful login, false for failure
     */
    public boolean AuthenticateCompany(String login, String pass) {
        String q = "SELECT count(*) FROM Manufacturer C WHERE C.login = :login AND C.password = :pass";
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
        String q = "SELECT count(*) FROM Representative C WHERE C.login = :login AND C.password = :pass";
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
    private boolean Authenticate(String q, String login, String pass) {
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
            session.close();
            return true;
        } else {
            session.close();
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
        //Starts a new criteria builder which will be used to set the criteria for the search
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Form> cr = cb.createQuery(Form.class);
        Root<Form> root = cr.from(Form.class);
        //Predicate list which will be added to for every new condition
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(root.get("approvalStatus"), as.approvalStatus));
        //Manually set those conditions if they are in the advanced search
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
        //Convert the predicates to an array and set the where statement with them
        cr.where(predicates.toArray(new Predicate[]{}));
        //Only selects the needed items for a minimal form to be displayed
        cr.multiselect(root.get("ttbID"), root.get("serialNumber"), root.get("alcoholType"), root.get("brandName"), root.get("dateSubmitted"), root.get("approvalStatus"));

        try {
            tx = session.beginTransaction();
            List<Form> results = session.createQuery(cr).list();
            for (Iterator iterator = results.iterator(); iterator.hasNext();){
                Form form = (Form) iterator.next();
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

    /**
     * A wildcard sql search of the database for brand name and fanciful name
     * @author Jordan
     * @param as An advanced search that has all the fields that want to be searched for set
     * @return A list of forms of everything that matched that wildcard search
     */
    public SearchResult searchByWild(AdvancedSearch as) {
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
        if (as.brandName != null) { //These both set everything to lowercase and do a basic like with wildcards in front and behind the entered query
            predicates.add(cb.like(cb.lower(root.get("brandName")), "%" + as.brandName.toLowerCase() + "%"));
        }
        if (as.fancifulName != null) {
            predicates.add(cb.like(cb.lower(root.get("fancifulName")), "%" + as.fancifulName.toLowerCase() + "%"));
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
        cr.where(predicates.toArray(new Predicate[]{}));
        //Only selects the needed items for a minimal form to be displayed
        cr.multiselect(root.get("ttbID"), root.get("serialNumber"), root.get("alcoholType"), root.get("brandName"), root.get("dateSubmitted"), root.get("approvalStatus"));

        try {
            tx = session.beginTransaction();
            List<Form> results = session.createQuery(cr).list();
            for (Iterator iterator = results.iterator(); iterator.hasNext();){
                Form form = (Form) iterator.next();
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

    /**
     * Gets a list of all potential brand names for the LD search that match the first criteria
     * @author Jordan
     * @param as An AdvancedSearch that contains all the search criteria except for anything that will be searched for using LD
     * @return A list of strings of brand names that match those first basic search criteria
     */
    public List<String> searchByLD(AdvancedSearch as) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<String> result = new ArrayList<>();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<String> cr = cb.createQuery(String.class);
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
        }//No brand name or fanciful name
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
        cr.where(predicates.toArray(new Predicate[]{}));
        //Adds a select so we only get the brandName from the results
        cr.select(root.get("brandName").as(String.class));
        try {
            tx = session.beginTransaction();
            result = session.createQuery(cr).list();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    /**
     * Part of the LD search. Finds anything matching the trimmed list of LD brand name strings
     * @author Jordan
     * @param as The advanced search that contains the search criteria for everything else
     * @param brands A list of all the brand names that should be searched for
     * @return A list of all forms that matched any of those brand names in addition to the other results
     */
    public List<Form> searchByLDBrand(AdvancedSearch as, List<String> brands) {
        //continously set the brandname in as to something new and get those exact results and then append them and reset the brand name
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

    /**
     * Gets the next unapproved form that no agent is currently working on.
     * @author Jordan
     * @return A Form that does not have anyone currently working on it and is not approved
     */
    public Form getNextUnapproved() {
        Session session = factory.openSession();
        String q = "FROM Form F WHERE F.approvalStatus = :approval AND F.workingOn = 0";
        Query query = session.createQuery(q);
        query.setParameter("approval", ApprovalStatus.Incomplete);
        Form form = (Form)query.getSingleResult();
        session.close();
        return form;
    }

    /**
     * Retrieves an agents current queue that they are working on
     * @author Jordan
     * @param agentID The agent id that you want to get all the forms in their queue for
     * @return A list of all the current forms assigned to that agent
     */
    public List<Form> getCurrentApprovalQueue(int agentID) {
        List<Form> results = new ArrayList<>();
        Session session = factory.openSession();
        Transaction tx = null;
        String q = "FROM Form F WHERE F.approvalStatus = :approval AND F.workingOn = :agent";
        Query query = session.createQuery(q);
        query.setParameter("approval", ApprovalStatus.Incomplete);
        query.setParameter("agent", agentID);
        try {
            //Starts the transaction
            tx = session.beginTransaction();
            //Sends the query off and gets the results as a list
            List forms = query.list();
            //Iterates through that list initiazing and setting stuff
            for (Iterator iterator = forms.iterator(); iterator.hasNext();){
                Form form = (Form) iterator.next();

                //Initializes the brewersPermit and the address
                Hibernate.initialize(form.brewersPermit);
                Hibernate.initialize(form.address);

                //Previous way of initiliazation
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
            //Commit the transaction
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            //Close the session
            session.close();
        }
        return results;
    }

    /**
     * Once a form has been assigned to an agent we need to update that form in the db so it isn't reclaimed
     * @author Jordan
     * @param form Form with workingOn set to the agent id of the agent that claimed it
     */
    public void updateWorkingOn(Form form) {
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
     * Generates the query to be used for downloading as a search result.
     * @author Jordan
     * @param sr The searchresult of the query to be downloaded
     */
    private String generateQuery(SearchResult sr) {
        AdvancedSearch as = sr.getSearch();
        String baseString;
        if (as.alcoholType != null && as.getAlcoholType().toInt() == AlcoholType.Wine.toInt() && ((as.vintageYear > 0) || (as.pH > 0) || (as.grapeVarietal != null) || (as.appellation != null))) {
            baseString = "SELECT TTB_ID, Serial_Number, Fanciful_Name, Brand_Name, Alcohol_Type, APV FROM FORM JOIN Wine ON Form.TTB_ID = Wine.TTB_ID WHERE Approve = " + (ApprovalStatus.Complete.toInt() - 1);
        } else {
            baseString = "SELECT TTB_ID, Serial_Number, Fanciful_Name, Brand_Name, Alcohol_Type, APV FROM FORM WHERE Approve = " + (ApprovalStatus.Complete.toInt() - 1);
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
        if (as.alcoholType != null && as.getAlcoholType().toInt() == 1 && as.vintageYear > 0) {
            baseString += " AND Vintage = ?";
        }
        if (as.alcoholType != null && as.getAlcoholType().toInt() == 1 && as.pH > 0) {
            baseString += " AND PH = ?";
        }
        if (as.alcoholType != null && as.getAlcoholType().toInt() == 1 && as.grapeVarietal != null) {
            baseString += " AND Grape_Varietals = ?";
        }
        if (as.alcoholType != null && as.getAlcoholType().toInt() == 1 && as.appellation != null) {
            baseString += " AND Wine_Appellation = ?";
        }
        if (as.ttbID > 0) {
            baseString += " AND TTB_ID = ?";
        }
        return baseString;
    }

    /**
     * Downloads the search result as a file onto the computer
     * @author Jordan
     * @param sr The searchresult that you want printed
     * @param isCSV Whether or not it should be printed as a csv. True for csv, false for ASCII-Deliminated
     * @return True if it succeeds, false if it fails
     */
    public boolean downloadQuery(SearchResult sr, boolean isCSV) {
        sr.setQuery(generateQuery(sr));
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
            if (search.alcoholType != null && search.alcoholType.toInt() == AlcoholType.Wine.toInt() && search.vintageYear > 0) {
                ps.setInt(set, search.vintageYear);
                set += 1;
            }
            if (search.alcoholType != null && search.alcoholType.toInt() == AlcoholType.Wine.toInt() && search.pH > 0) {
                ps.setFloat(set, search.pH);
                set += 1;
            }
            if (search.alcoholType != null && search.alcoholType.toInt() == AlcoholType.Wine.toInt() && search.grapeVarietal != null) {
                ps.setString(set, search.grapeVarietal);
                set += 1;
            }
            if (search.alcoholType != null && search.alcoholType.toInt() == AlcoholType.Wine.toInt() && search.appellation != null) {
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
            String q = "FROM LabelImage L WHERE L.TTBID = :id";
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

    /**
     * Retrieves the manufacturer related to that login name
     * @author Jordan
     * @param login Login name for the user
     * @return A manufacturer that is related to that login
     */
    public Manufacturer getManufacturer(String login) {
        Session session = factory.openSession();
        String q = "FROM Manufacturer M WHERE M.login = :log";
        Query query = session.createQuery(q);
        query.setParameter("log", login);
        Manufacturer man = (Manufacturer) query.getSingleResult();
        session.close();
        return man;
    }


    /**
     * Gets a list of forms related to a manufacturer id
     * @author Jordan
     * @param manID The manufacturer id that you want all the forms for
     * @return A list of all the forms related to that man id
     */
    public List<Form> getFormsManu(int manID) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Form> results = new ArrayList<>();

        try {
            //Starts the transaction
            tx = session.beginTransaction();
            //Sends the query off and gets the results as a list
            Query q = session.createQuery("FROM Form F WHERE F.companyID = :compID");
            q.setParameter("compID", manID);
            List forms = q.list();
            //Iterates through that list initiazing and setting stuff
            for (Iterator iterator = forms.iterator(); iterator.hasNext();){
                Form form = (Form) iterator.next();

                //Initializes the brewersPermit and the address
                Hibernate.initialize(form.brewersPermit);
                Hibernate.initialize(form.address);

                //Previous way of initiliazation
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
            //Commit the transaction
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            //Close the session
            session.close();
        }
        return results;
    }

    /**
     * Retrieves the rep related to that user
     * @author Jordan
     * @param login Login name for the user
     * @return A rep that is related to that login
     */
    public Representative getRepresentative(String login) {
        Session session = factory.openSession();
        Transaction tx = null;
        String q = "FROM Representative R WHERE R.login = :log";
        Query query = session.createQuery(q);
        query.setParameter("log", login);
        Representative rep = (Representative) query.getSingleResult();
        session.close();
        return rep;
    }

    /**
     * Retrives the agent related to that user
     * @author Jordan
     * @param login Login name for the user
     * @return An agent that is related to that login
     */
    public Agent getAgent(String login) {
        Session session = factory.openSession();
        String q = "FROM Agent A WHERE A.login = :log";
        Query query = session.createQuery(q);
        query.setParameter("log", login);
        Agent agent = (Agent) query.getSingleResult();
        session.close();
        return agent;
    }
}
