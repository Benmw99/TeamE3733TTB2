package DB;

import Entities.*;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DBSelect extends DatabaseAbstract {
    private static DBSelect dbSelect_instance = null;

//TODO MAKE ALL SELECTS RETURN ENTITIES
    private DBSelect(String path) {
        super(path);
    }

    /**
     * Gets the one instance of the class making it a singleton
     * @author Jordan
     * @return The current instance of DBSelect
     */
    static DBSelect getInstance() {
        if (dbSelect_instance == null) {
            dbSelect_instance = new DBSelect("./ttb.db");
        }
        return dbSelect_instance;
    }

    /**
     * Sends a query to the database and returns its results
     * @param queryString The exact query that you want sent to the database
     * @return The results from that query in a ResultSet
     */
    private ResultSet sendQuery(String queryString){
        ResultSet rs = null;
        try{
            PreparedStatement ps = connection.prepareStatement(queryString);
            rs = ps.executeQuery();
        } catch (SQLException e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * Gets all the reps in the db
     * @return A ResultSet filled with the results of the query
     */
    public ResultSet selectAllReps(){
        String selectString = "SELECT * FROM REPS";
        return sendQuery(selectString);
    }

    /**
     * Gets all the info about a rep
     * @param Rep_ID The id of the rep that you want the info of
     * @return A resultset containing all the information about that rep
     */
    public ResultSet selectRepByID(String Rep_ID){
        String selectString = "SELECT * FROM REPS WHERE Rep_ID='";
        selectString += Rep_ID += "'";
        return sendQuery(selectString);
    }

    /**
     * Gets all the companies in the database
     * @return A resultset containing all the information about all the companies
     */
    public ResultSet selectAllCompany(){
        String selectString = "SELECT * FROM COMPANY";
        return sendQuery(selectString);
    }

    /**
     * Gets all the agents in the database
     * @return A resultset containing all the information about all the agents
     */
    public ResultSet selectAllAgents(){
        String selectString = "SELECT * FROM AGENTS";
        return sendQuery(selectString);
    }

    /**
     * Gets all the forms in the database
     * @return A resultset containing all the information about all the forms
     */
    public ResultSet selectAllForms() {
        String selectString = "SELECT * FROM FORM";
        return sendQuery(selectString);
    }

    /**
     * Gets the ID and Street from of all items in the Address table
     * @return A resultset containing the id and street of all addresses
     */
    public ResultSet selectAllAddress() {
        String selectString = "SELECT ID, Street FROM ADDRESS";
        return sendQuery(selectString);
    }

    //Will return something else later
    //To be used for displaying a companies submitted forms
    public ResultSet selectByCompany(int companyID) {
        //Serial number or TTB_ID?
        String selectString = "SELECT TTB_ID, Date_Submitted, reviewDate FROM COMPANY WHERE Company_ID = ?";
        ResultSet rset = null;
        try {
            PreparedStatement statement = connection.prepareStatement(selectString);
            statement.setInt(1, companyID);
            rset = statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return rset;
    }

    public Manufacturer getManufacturer(String login){
        String selectString = "SELECT * FROM COMPANY WHERE Login_Name=?";
        Manufacturer man = new Manufacturer();
        try{
            PreparedStatement ps = connection.prepareStatement(selectString);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            rs.next();
            man.setManID(rs.getInt("Company_ID"));
            man.setManName(rs.getString("Company_Name"));
            man.setLogin(login);
        } catch (SQLException e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return man;
    }


    public Agent getAgent(String login){
        String selectString = "SELECT * FROM AGENTS WHERE Login_Name=?";
        Agent agent = new Agent();
        try{
            PreparedStatement ps = connection.prepareStatement(selectString);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            rs.next();
            agent.setLogin(login);
            agent.setRepID(String.valueOf(rs.getInt("Agent_ID")));
        } catch (SQLException e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return agent;
    }

    public Representative getRepresentative(String login){
        String selectString = "SELECT * FROM REPS WHERE Login_Name=?";
        Representative rep = new Representative();
        try{
            PreparedStatement ps = connection.prepareStatement(selectString);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            rs.next();
            rep.setLogin(login);
            rep.setRepID(String.valueOf(rs.getInt("Agent_ID")));
        } catch (SQLException e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return rep;
    }

    /**
     * Authenticates the company login
     * @author Michael
     * @param login The inputted login name
     * @param pass The inputted password
     * @return True if the login is valid, false if not
     */
    public Boolean AuthenticateCompany(String login, String pass) {
        String selectString = "SELECT COUNT(*) FROM COMPANY WHERE Login_Name =? AND Password =? ";
        return doAuthenticate(login, pass, selectString);
    }

    /**
     * Authenticates the agent login
     * @author Michael
     * @param login The inputted login name
     * @param pass The inputted password
     * @return True if the login is valid, false if not
     */
    public Boolean AuthenticateAgent(String login, String pass) {
        String selectString = "SELECT COUNT(*) FROM AGENTS WHERE Login_Name =? AND Password =? ";
        return doAuthenticate(login, pass, selectString);
    }

    /**
     * Authenticates the rep login
     * @author Jordan
     * @param login The inputted login name
     * @param pass The inputted password
     * @return True if the login is valid, false if not
     */
    public Boolean AuthenticateRep(String login, String pass) {
        String selectString = "SELECT COUNT(*) FROM REPS WHERE Login_Name =? AND Password =? ";
        return doAuthenticate(login, pass, selectString);
    }

    /**
     * A Helper function for authentication
     * @author Michael
     * @param login The login name
     * @param pass The password
     * @param selectString The select string for the table to authenticate against
     * @return True if the login is valid, else false
     */
    private Boolean doAuthenticate(String login, String pass, String selectString) {
        try {
            PreparedStatement statement = connection.prepareStatement(selectString);
            statement.setString(1, login);
            statement.setString(2, pass);
            ResultSet rs = statement.executeQuery();
            rs.next();
            if(rs.getInt(1) > 0){
                statement.close();
                return true;
            } else {
                statement.close();
                return false;
            }
        } catch(SQLException e){
            return false;
        }
    }

    /**
     * Downloads the selected results in a file without limit to the number of results
     * @author Jordan
     * @param query The query to be downloaded without a fetch first or sort in it, preferably gotten from the SearchResult
     * @param search The AdvancedSearch used to generate that query, preferably gotten from the SearchResult
     * @return True if successful, false if it failed
     */
    public boolean downloadResults(String query, AdvancedSearch search) { //TODO GET RID OF DUPLICATE CODE
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String download = "CALL SYSCS_UTIL.SYSCS_EXPORT_QUERY (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(download);
            ps.setString(1, query.replaceFirst("TTB_ID", "TTB_ID, Serial_Number, Fanciful_Name, Brand_Name, Alcohol_Type, APV"));
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
            if (search.type == 1 && search.vintageYear > 0) {
                ps.setInt(set, search.vintageYear);
                set += 1;
            }
            if (search.type == 1 && search.pH > 0) {
                ps.setFloat(set, search.pH);
                set += 1;
            }
            if (search.type == 1 && search.grapeVarietal != null) {
                ps.setString(set, search.grapeVarietal);
                set += 1;
            }
            if (search.type == 1 && search.appellation != null) {
                ps.setString(set, search.appellation);
                set += 1;
            }
            if (search.ttbID > 0) {
                ps.setInt(set, search.ttbID);
                set += 1;
            }
            ps.setString(set,"TTBSearch" + dateFormat.format(date) + ".csv");
            ps.setString(set + 1,null);
            ps.setString(set + 2,null);
            ps.setString(set + 3,null);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return false;
        }
    }

    //TODO Implement Sorting
    //public Timestamp timestamp; NOT IMPLEMENTED YET
    //THIS IS THE CIVILIAN SEARCH
    /**
     * Retrieves the forms that a user searched for by criteria from the database
     * @author Jordan
     * @param as The AdvancedSearch that was generated from the users inputs in the advanced search fields
     * @return A SearchResult containing all the forms that were gotten as a result of that search
     */
    public SearchResult searchBy(AdvancedSearch as) {
        SearchResult result = new SearchResult();
        result.setSearch(as);
        //The base search string
        String baseString;
        if (as.type == 1 && ((as.vintageYear > 0) || (as.pH > 0) || (as.grapeVarietal != null) || (as.appellation != null))) {
            baseString = "SELECT TTB_ID FROM Form JOIN Wine ON Form.TTB_ID = Wine.TTB_ID WHERE APPROVE = 1";
        } else {
            baseString = "SELECT TTB_ID FROM Form WHERE APPROVE = 1";
        }
        //Manually goes through and checks if stuff is set and then adds it to the string. Later it will set all those question marks
        if (as.source != null) {
            baseString += " AND Source = ?";
        }
        if (as.serialNumber != null) {
            baseString += " AND Serial_Number = ?";
        }
        if (as.alcoholType != null) {
            baseString += " AND Alcohol_Type = " + as.type;
        }
        if (as.brandName != null) {
            baseString += " AND Brand_Name = ?";
        }
        if (as.fancifulName != null) {
            baseString += " AND Fanciful_Name = ?";
        }
        if (as.type == 1 && as.vintageYear > 0) {
            baseString += " AND Vintage = ?";
        }
        if (as.type == 1 && as.pH > 0) {
            baseString += " AND PH = ?";
        }
        if (as.type == 1 && as.grapeVarietal != null) {
            baseString += " AND Grape_Varietals = ?";
        }
        if (as.type == 1 && as.appellation != null) {
            baseString += " AND Wine_Appellation = ?";
        }
        if (as.ttbID > 0) {
            baseString += " AND TTB_ID = ?";
        }
        result.setQuery(baseString);
        if (as.numResults > 0) {
            baseString = baseString + " FETCH NEXT " + as.numResults + " ROWS ONLY";
        }
        try {
            PreparedStatement statement = connection.prepareStatement(baseString);

            int set = 1;
            if (as.source != null) {
                statement.setBoolean(set, as.source);
                set += 1;
            }
            if (as.serialNumber != null) {
                statement.setString(set, as.serialNumber);
                set += 1;
            }
            if (as.brandName != null) {
                statement.setString(set, as.brandName);
                set += 1;
            }
            if (as.fancifulName != null) {
                statement.setString(set, as.fancifulName);
                set += 1;
            }
            if (as.type == 1 && as.vintageYear > 0) {
                statement.setInt(set, as.vintageYear);
                set += 1;
            }
            if (as.type == 1 && as.pH > 0) {
                statement.setFloat(set, as.pH);
                set += 1;
            }
            if (as.type == 1 && as.grapeVarietal != null) {
                statement.setString(set, as.grapeVarietal);
                set += 1;
            }
            if (as.type == 1 && as.appellation != null) {
                statement.setString(set, as.appellation);
                set += 1;
            }
            if (as.ttbID > 0) {
                statement.setInt(set, as.ttbID);
                set += 1;
            }

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result.addResult(getFormByTTB_ID(rs.getInt("TTB_ID")));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get a List of TTB_ID's associated with the manufactuer
     * @author Michael
     * @param man The manufacturer who has logged in to look at their forms
     * @return A list of Ints representing their TTB_ID's
     */
    public List<Integer> getTTB_IDbyManufacturer(Manufacturer man){
        String selString = "SELECT TTB_ID FROM FORM WHERE Company_ID=? ";
        int comp_id = man.manID;
        List<Integer> list_of_ids= new ArrayList<Integer>();
        try {
            PreparedStatement ps = connection.prepareStatement(selString);
            ps.setInt(1, comp_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                list_of_ids.add(rs.getInt("TTB_ID"));
            }
        }catch (SQLException e){
                System.out.println(e.toString());
                e.printStackTrace();
            }
        return list_of_ids;
        }


        //Outdated and probably unnecessary
    /**
     * Retrieves the form according to the minimal Application
     * @author Michael
     * @param TTB_ID The TTB_ID of the form to retrieve
     * @return A form filled with the minimal info
     */
    public Form getFormMinimal(int TTB_ID){
        String selString = "SELECT * FROM FORM WHERE TTB_ID=?";
        String wineString = "SELECT * FROM WINE WHERE TTB_ID=?";
        Form form = new Form();
        WineFormItems wine;
        try {
            PreparedStatement ps = connection.prepareStatement(selString);
            ps.setInt(1, TTB_ID);
            ResultSet rs = ps.executeQuery();
            form.setAlcoholContent(rs.getFloat("Alcohol_Content"));
            AlcoholType type;
            if (rs.getInt("Alcohol_Type") == 1) {
                type = AlcoholType.Wine;
            } else if (rs.getInt("Alcohol_Type") == 2) {
                type = AlcoholType.MaltBeverage;
            } else {
                type = AlcoholType.DistilledLiquor;
            }
            if(type == AlcoholType.Wine){
                ps.close();
                ps = connection.prepareStatement(wineString);
                rs = ps.executeQuery();
                wine = new WineFormItems();
                wine.setpH(rs.getFloat("pH"));
                wine.setVintageYear(rs.getInt("Vintage_Year"));
                form.setWineFormItems(wine);
            }
        } catch (SQLException e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return form;
    }

    /**
     * Gets all the information about a form including information in related tables
     * @author Michael
     * @param TTB_ID The ttb id of the form you want to get
     * @return A Form that contains all of the information that was in the database for that form
     */
    public Form getFormByTTB_ID( int TTB_ID){
        String selString = "SELECT * FROM FORM WHERE TTB_ID=?";
        String otherInfString = "SELECT * FROM OTHERINFO WHERE TTB_ID=?";
        String brewersPermit = "SELECT * FROM BREWERSPERMIT WHERE TTB_ID=?";
        String addressString = "SELECT * FROM ADDRESS WHERE TTB_ID = ?";
        ArrayList<String> list_permits = new ArrayList<String>();
        ArrayList<Address> addresses = new ArrayList<Address>();
        AlcoholType type;
        ApprovalStatus stat = ApprovalStatus.Incomplete;
        Form form = new Form();
        //TODO Communicate with Nick about addresses.
        try {
            PreparedStatement ps = connection.prepareStatement(selString);
            ps.setInt(1, TTB_ID);
            ResultSet rs = ps.executeQuery();
                 rs.next();
                form.setFancifulName(rs.getString("Fanciful_Name"));
                form.setBrandName(rs.getString("Brand_Name"));
                form.setSource(rs.getBoolean("Source"));
                form.setSerialNumber(rs.getString("Serial_Number"));
                form.setCompanyID(rs.getInt("Company_ID"));
                form.setRepID(rs.getString("Rep_ID"));
                form.setTtbID(TTB_ID);
                form.setFormula(rs.getString("Formula"));
                form.setAlcoholContent(rs.getFloat("APV"));
                form.setEmail(rs.getString("Email"));
                form.setDateSubmitted(rs.getTimestamp("Date_Submitted")); //TODO HANDLE CONVERSION
                form.setApplicantName(rs.getString("Applicant_Name"));
                form.setPhoneNumber(rs.getString("Phone"));
                if (rs.getInt("Alcohol_Type") == AlcoholType.Wine.toInt()) {
                    type = AlcoholType.Wine;
                    form.setWineFormItems(this.getWineBlock(TTB_ID));
                } else if (rs.getInt("Alcohol_Type") == AlcoholType.MaltBeverage.toInt()) {
                    type = AlcoholType.MaltBeverage;
                } else {
                    type = AlcoholType.DistilledLiquor;
                }
                form.setAlcoholType(type);
                int status = rs.getInt("Approve");
                if (status == 1) {
                    stat = ApprovalStatus.Complete;
                    form.setApproval(this.getApproval_By_TTB_ID(TTB_ID));
                } else if (status == 2) {
                    stat = ApprovalStatus.Incomplete;
                } else if (status == 3) {
                    stat = ApprovalStatus.Incorrect;
                    form.setApproval(this.getApproval_By_TTB_ID(TTB_ID));
                }
                form.setApprovalStatus(stat);
            ps.close();
            /* OTHER INFO BLOCK */
            ps = connection.prepareStatement(otherInfString);
            ps.setInt(1, TTB_ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                form.setBlownBrandedEmbossedInfo(rs.getString("Text"));
            }
            ps.close();
            /* BREWERS PERMIT BLOCK */
            ps = connection.prepareStatement(brewersPermit);
            ps.setInt(1, TTB_ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list_permits.add(rs.getString("Brewers_No"));
            }
            form.setBrewersPermit(list_permits);
            ps.close();
            /* Address Block */
            ps = connection.prepareStatement(addressString);
            ps.setInt(1, TTB_ID);
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getBoolean("isMailing")){
                   Address mailing = new Address(rs.getString("City"), rs.getString("State"),
                           rs.getString("Zip_Code"), rs.getString("Street"), "NAME");
                   form.setMailingAddress(mailing);
                   //TODO RESOLVE PROBLEMS WITH NAME
                } else {
                    addresses.add(new Address(rs.getString("City"), rs.getString("State"),
                            rs.getString("Zip_Code"), rs.getString("Street"), "NAME"));
                }
            }
            ps.close();
            form.setAddress(addresses);

        }catch (SQLException e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return form;
    }

    /**
     *
     * @author Michael
     * @return
     */
    public List<Form> getThreeForms(){
        String selStr = "SELECT * FROM FORM WHERE APPROVE=?";
        List<Integer> list_ID = new ArrayList<Integer>();
        List<Form> list_form = new ArrayList<Form>();
        try{
            PreparedStatement ps = connection.prepareStatement(selStr);
            ps.setInt(1, ApprovalStatus.Incomplete.toInt());
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while(rs.next() && i < 3){
                i ++;
                list_ID.add(rs.getInt("TTB_ID"));
            }
            ps.close();
    } catch (SQLException e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
        while(!list_ID.isEmpty()){
            list_form.add(this.getFormByTTB_ID(list_ID.get(0)));
            System.out.println(list_ID.get(0));
            list_ID.remove(0);
        }
        return list_form;
    }

    //TODO MAKE AN UPDATE CLASS

    /**
     *  Approves a form, in the loose sense of the term. You should put a form with the correct approval type here
     * @author Michael
     * @param form the form to approve
     * @param approval the approval for the form
     */
    public void approveForm(Form form, Approval approval){
        String selStr = "UPDATE FORM SET APPROVE = ? WHERE TTB_ID = ?";
        System.out.println(form.getTtbID());
        System.out.println(ApprovalStatus.Complete.toInt());
        try{
            PreparedStatement ps = connection.prepareStatement(selStr);
            ps.setInt(2, form.getTtbID());
   //         if(!approval.isApproved()){
     //           ps.setInt(1, ApprovalStatus.Complete.toInt());
       //     } else if(approval.isApproved()){
         //       ps.setInt(1,ApprovalStatus.Incorrect.toInt());
           // }
            ps.setInt(1, form.getApprovalStatus().toInt());
            System.out.println(ps.executeUpdate());
            ps.close();
            Database.getInstance().dbInsert.insertApproval(approval, form.getTtbID());
    } catch (SQLException e){
            System.out.println(e.toString());
            e.printStackTrace();
            e.printStackTrace();
        }
    }

    public void approveOrReject(Form form) throws Exception{
        if(form.getApproval() == null){
            Exception e = new Exception("No approval Object for Form. Form not ready.");
            throw e;
        } else {
            approveForm(form, form.getApproval());
        }
    }

    /**
     * Gets all the TTBID's of forms that a company has submitted for viewing on their dashboard
     * @author Jordan
     * @param companyID The company that you want all the forms for
     * @return A list of all the TTBID's of forms that the company has submitted
     */
    public ArrayList<Integer> selectFormByCompany(int companyID) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        String select = "SELECT TTB_ID FROM FORM WHERE Company_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(select);
            ps.setInt(1, companyID);
            ResultSet rs = ps.executeQuery();
            Integer ttbID = 0;
            while (rs.next()) {
                results.add(rs.getInt("TTB_ID"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return results;
    }

    /**
     * Gets all the TTBID's of forms that a rep has submitted for viewing on their dashboard
     * @author Jordan
     * @param repID The rep that you want all the forms for
     * @return A list of all the TTBID's of forms that the rep has submitted
     */
    public ArrayList<Integer> selectFormByRep(int repID) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        String select = "SELECT TTB_ID FROM FORM WHERE REP_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(select);
            ps.setInt(1, repID);
            ResultSet rs = ps.executeQuery();
            Integer ttbID = 0;
            while (rs.next()) {
                results.add(rs.getInt("TTB_ID"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return results;
    }


    public WineFormItems getWineBlock(int TTB_ID){
        String selstr = "SELECT * FROM WINE WHERE TTB_ID=?";
        WineFormItems wine = new  WineFormItems();
        try{
            PreparedStatement ps = connection.prepareStatement(selstr);
            ps.setInt(1, TTB_ID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            wine.setVintageYear(rs.getInt("Vintage"));
            wine.setpH(rs.getFloat("pH"));
            wine.setGrapeVarietal(rs.getString("Grape_Varietals"));
            wine.setAppellation(rs.getString("Wine_Appellation"));
            rs.close();
    } catch(SQLException e ){
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return wine;
    }

    public Approval getApproval_By_TTB_ID(int TTB_ID){
        String selStr = "SELECT * FROM APPROVAL WHERE TTB_ID=?";
        Approval app = new Approval();
        try{
            PreparedStatement ps = connection.prepareStatement(selStr);
            ps.setInt(1, TTB_ID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                app.setAgentApprovalName(rs.getString("Approving_Agent"));
                app.setExpDate(rs.getTimestamp("Expiration"));
                app.setTimestamp(rs.getTimestamp("Date"));
                app.setPage1(ApprovalStatus.fromInt(rs.getInt("Page_1")));
                app.setPage2(ApprovalStatus.fromInt(rs.getInt("Page_2")));
                app.setPage3(ApprovalStatus.fromInt(rs.getInt("Page_3")));
                app.setPage4(ApprovalStatus.fromInt(rs.getInt("Page_4")));
            }
            rs.close();

        } catch (SQLException e){
            System.out.println(e.toString());
            e.printStackTrace();
            System.out.println(e.getStackTrace());
        }
        return app;
    }

    /**
     * Gets all the images associated with a ttb id for a form
     * @author Jordan
     * @param ttbID The TTB_ID that you want to get all the forms of
     * @return An arrayList of LabelImages where each label image is can be loaded as an image
     */
    //THIS FUNCTION MAY NOT WORK AT ALL. IT IS POSSIBLE MEMORY CLOSURES INVALIDATES THIS
    public ArrayList<LabelImage> selectImagesbyTTBID(int ttbID) {
        ArrayList<LabelImage> results = new ArrayList<>();
        try {
            //Autcommit must be turned off to work with blobs
            connection.setAutoCommit(false);
            //Select the entry searched for in the DB
            String selectString = "SELECT * FROM Label WHERE TTB_ID = ?";
            //Create the statement and execute the query
            PreparedStatement ps = connection.prepareStatement(selectString);
            ps.setInt(1, ttbID);
            ResultSet rs = ps.executeQuery();
            Blob image = null;
            String imageFileName = null;
            int id = 0;
            //Get everything from the ResultSet
            while (rs.next()) {
                image = rs.getBlob("Image");
                imageFileName = rs.getString("ImageName");
                id = rs.getInt("ID");
                //Make an inputstream from the blobs binary stream
                InputStream in = image.getBinaryStream();
                results.add(new LabelImage(id, imageFileName, in));
            }
            connection.setAutoCommit(true);
            //Might not be necessary but also might be preventing memory leaks. I don't really know
            try{
                image.free();
            } catch (NullPointerException ignored) { }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return results;
    }
}
