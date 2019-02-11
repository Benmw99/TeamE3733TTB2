package DB;

import Entities.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

public class DBInsert extends DatabaseAbstract {
    private static DBInsert dbInsert_instance = null;

    private DBInsert(String path ) {
        super(path);
    }

    /**
     * Gets the one instance of the class making it a singleton
     * @author Jordan
     * @return The current instance of DBSelect
     */
    static DBInsert getInstance() {
        if (dbInsert_instance == null) {
            dbInsert_instance = new DBInsert("./ttb.db");
        }
        return dbInsert_instance;
    }

    /**
     * Inserts an address into the database, attached to the TTB form corresponding to the TTB_ID
     * @param Zip The Zip code, shouldn't exceed 8 chars
     * @param isMailing A Boolean, true iff this is the mailing address
     * @param City The city name, TODO Standardize all string lengths
     * @param State The State, TODO Standardize all string lengths
     * @param Street The street address TODO Standardize all string lengths
     * @param TTB_ID The TTB_ID of the form this address goes with
     * @throws SQLException
     */
    public void insertAddress(String Zip, Boolean isMailing, String City, String State, String Street, int TTB_ID) throws SQLException{
        String insertString = "INSERT INTO ADDRESS (Zip_Code, isMailing, City, Street, State, TTB_ID, ID) VALUES (" +
                "?, ?, ?, ?, ?, ?, NEXT VALUE FOR Address_ID)";
        PreparedStatement statement = connection.prepareStatement(insertString);
        statement.setString(1, Zip);
        statement.setBoolean(2, isMailing);
        statement.setString(3, City);
        statement.setString(4, Street);
        statement.setString(5, State);
        statement.setInt(6, TTB_ID);
        statement.execute();
    }

    /**
     *  Inserts an Other_Info entry into the src.DB, attatches to a TTB_Form
     * @param TTB_ID The form to attach to
     * @param text The text of the other info //TODO standardize string length
     * @throws SQLException
     */
    public void insertOtherInfo(int TTB_ID, String text) throws SQLException{
        String insertString = "INSERT INTO OTHERINFO (TTB_ID, Text) VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(insertString);
        statement.setInt(1, TTB_ID);
        statement.setString(2, text);
        statement.execute();
    }

    /**
     * Inserts a special wine entry for a wine for a wine, attached to a TTB_Form
     * @param TTB_ID The form to which this is attatched
     * @param Grape_Varietals The grape varietals field for the entry
     * @param Wine_Appellation The wine appellation field for the entry
     * @throws SQLException
     */
    public void insertWine(int TTB_ID, String Grape_Varietals, String Wine_Appellation, float pH, int Vintage) throws SQLException{
        String insertString = "INSERT INTO WINE (TTB_ID, Grape_Varietals, Wine_Appellation, pH, Vintage) VALUES (?,?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertString);
        statement.setInt(1, TTB_ID);
        statement.setString(2, Grape_Varietals);
        statement.setString(3, Wine_Appellation);
        statement.setFloat(4, pH);
        statement.setInt(5, Vintage);
        statement.execute();
    }

    /**
     *  Inserts a BrewersPermit entry
     * @param Permit_No The brewers permit number
     * @param TTB_ID The form this is associated with
     * @param isPrimary True if and only if this is the primary permit entry for the associated form
     * @throws SQLException
     */
    public void insertBrewersPermit(String Permit_No, int TTB_ID, Boolean isPrimary) throws SQLException{
        String insertString = "INSERT INTO BREWERSPERMIT (Brewers_No, TTB_ID, isPrimary) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertString);
        statement.setString(1, Permit_No);
        statement.setInt(2, TTB_ID);
        statement.setBoolean(3, isPrimary);
        statement.execute();
    }

    /**
     * Inserts an Agent entry
     * @param name The name of the agent
     * @param ID The agent's unique agent ID
     * @param Login_Name the login name the agent will use
     * @param Password The agent's password. //TODO HASH
     * @throws SQLException
     */
    public void insertAgent(String name, int ID, String Login_Name, String Password) throws SQLException{
        String insertString = "INSERT INTO AGENTS (Agent_Name, Agent_ID, Login_Name, Password) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertString);
        statement.setString(1, name);
        statement.setInt(2, ID);
        statement.setString(3, Login_Name);
        statement.setString(4, Password);
        statement.execute();
    }

    /**
     *  Inserts a comapny entry
     * @param Company_ID The ID For the company
     * @param Company_Name The name of the company
     * @param Login_Name The login name the company will be able to use
     * @param Password The password the company will use //TODO Hash
     * @throws SQLException
     */
    public void insertCompany(int Company_ID, String Company_Name, String Login_Name, String Password) throws SQLException {
        String insertString = "INSERT INTO COMPANY (Company_ID, Company_Name, Login_Name, Password) VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(insertString);
        statement.setInt(1, Company_ID);
        statement.setString(2, Company_Name);
        statement.setString(3, Login_Name);
        statement.setString(4, Password);
        statement.execute();
    }

    /**
     *
     * @param Serial_Number
     * @param Fanciful_Name
     * @param Brand_Name
     * @param Source
     * @param Approve
     * @param Rep_ID
     * @param email
     * @param Company_ID
     * @param submitted
     * @param name
     * @param phone
     * @param Alcohol_Type
     * @throws SQLException
     */
    public void insertForm(String Serial_Number, String Fanciful_Name, String Brand_Name, Boolean Source,
                    Boolean Approve, String Rep_ID, String email, int Company_ID, Timestamp submitted, String name,
                    String phone, int Alcohol_Type, double APV) throws SQLException {
        String insertString = "INSERT INTO FORM (TTB_ID, Serial_Number, Fanciful_Name, Brand_Name, Source, Approve," +
                " Rep_ID, Email, Company_ID, Date_Submitted, Applicant_Name, Phone, Alcohol_Type, APV) " +
                "VALUES (NEXT VALUE FOR Form_ID, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; //TODO MAKE REP ID AND FORMULA OPTIONAL
        PreparedStatement statement = connection.prepareStatement(insertString);
        statement.setString(1, Serial_Number);
        statement.setString(2, Fanciful_Name);
        statement.setString(3, Brand_Name);
        statement.setBoolean(4, Source);
        if(Approve == true){
            statement.setInt(5,1);
        } else {
            statement.setInt(5, 2);
        }
        statement.setString(6, Rep_ID);
        statement.setString(7, email);
        statement.setInt(8, Company_ID);
        statement.setTimestamp(9, submitted);
        statement.setString(10, name);
        statement.setString(11, phone);
        statement.setInt(12, Alcohol_Type);
        statement.setFloat(13, (float)APV);
        statement.execute();
    }


    public void insertForm(String Serial_Number, String Fanciful_Name, String Brand_Name, Boolean Source,
                           Boolean Approve, String Rep_ID, String email, int Company_ID, Timestamp submitted, String name,
                           String phone, int Alcohol_Type, double APV, String formula) throws SQLException {
        String insertString = "INSERT INTO FORM (TTB_ID, Serial_Number, Fanciful_Name, Brand_Name, Source, Approve," +
                " Rep_ID, Email, Company_ID, Date_Submitted, Applicant_Name, Phone, Alcohol_Type, APV, Formula) " +
                "VALUES (NEXT VALUE FOR Form_ID, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; //TODO MAKE REP ID AND FORMULA OPTIONAL
        PreparedStatement statement = connection.prepareStatement(insertString);
        statement.setString(1, Serial_Number);
        statement.setString(2, Fanciful_Name);
        statement.setString(3, Brand_Name);
        statement.setBoolean(4, Source);
        if(Approve == true){
            statement.setInt(5,1);
        } else {
            statement.setInt(5, 2);
        }
        statement.setString(6, Rep_ID);
        statement.setString(7, email);
        statement.setInt(8, Company_ID);
        statement.setTimestamp(9, submitted);
        statement.setString(10, name);
        statement.setString(11, phone);
        statement.setInt(12, Alcohol_Type);
        statement.setFloat(13, (float)APV);
        statement.setString(14, formula);
        statement.execute();
    }


    /**
     * Inserts a representative into the database.
     * @param Rep_ID The Rep_ID for the new representative
     * @throws SQLException
     */
    public void insertReps(String Rep_ID, String login, String password) throws SQLException{
        String insertString = "INSERT INTO REPS (Rep_ID, Login_Name, Password) VALUES (?, ?, ?)";
        PreparedStatement statement =  connection.prepareStatement(insertString);
        statement.setString(1, Rep_ID);
        statement.setString(2, login);
        statement.setString(3, password);
        statement.execute();
    }

    /**
     * Inserts a label into the database
     * @param inputFile A File that was made from the input image file selection
     * @param fileName The file name of that image
     * @throws SQLException
     */
    public void insertLabel(File inputFile, String fileName) throws SQLException{
        String insertString = "INSERT INTO LABEL (ID, Image, ImageName) VALUES (NEXT VALUE FOR Label_ID, ?, ?)";
        FileInputStream input = null;
        try {
            input = new FileInputStream(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
        PreparedStatement statement =  connection.prepareStatement(insertString);
        statement.setBinaryStream(1, input);
        statement.setString(2, fileName);
        statement.execute();
    }

    /**
     * Inserts approval into the database
     * @param appovingAgent The approving agents name
     * @param TTB_ID The TTB ID of the form that is being approved
     * @param date The date of its approval
     * @param expiration The expiration of the approved form
     * @param qualification Any special qualification the agent writes in
     * @throws SQLException
     */
    @Deprecated
    public void insertApproval(String appovingAgent, int TTB_ID, Timestamp date, Timestamp expiration, String qualification) throws SQLException {
        String insertString = "INSERT INTO APPROVAL VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertString);
        statement.setString(1, appovingAgent);
        statement.setInt(2, TTB_ID);
        statement.setTimestamp(3, date);
        statement.setTimestamp(4, expiration);
        statement.setString(5, qualification);
        statement.execute();
        statement.close();
    }

    public void insertApproval(String approvingAgent, int TTB_ID, Timestamp date, Timestamp expiration, String qualification, ApprovalStatus page1, ApprovalStatus page2, ApprovalStatus page3, ApprovalStatus page4) throws SQLException {
        String insertString = "INSERT INTO APPROVAL (Approving_Agent, TTB_ID, Date, Expiration, Page_1, Page_2, Page_3, Page_4, Qualification) VALUES" +
                " (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertString);
        statement.setString(1, approvingAgent);
        statement.setInt(2, TTB_ID);
        statement.setTimestamp(3, date);
        statement.setTimestamp(4, expiration);
        statement.setInt(5, page1.toInt());
        statement.setInt(6, page2.toInt());
        statement.setInt(7, page3.toInt());
        statement.setInt(8, page4.toInt());
        statement.setString(9, qualification);
        statement.execute();
        statement.close();
    }

    public void insertApproval(Approval approval, int TTB_ID) throws SQLException{
        insertApproval(approval.getAgentApprovalName(), TTB_ID, approval.getTimestamp(), approval.getExpDate(),
                approval.getQualifications(), approval.getPage1()
        , approval.getPage2(), approval.getPage3(), approval.getPage4());
    }

    //TODO APPROVE FORM --> Make UPDATE

    public int insertForm(Form to_insert, Manufacturer inserting) { //TODO FINISH THIS FUNCTION OR PASS IT TO ENTITIES
        int TTB_ID = -1;
        try{
            String selstr =  "VALUES (NEXT VALUE FOR FORM_ID)";
            PreparedStatement ps = connection.prepareStatement(selstr);
            ResultSet rs = ps.executeQuery();
            rs.next();
            TTB_ID = rs.getInt(1);
            TTB_ID ++;
            ps.close();
        insertForm(to_insert.getSerialNumber(),
                to_insert.getFancifulName(),
                to_insert.getBrandName(),
                to_insert.getSource(),
                false,
                to_insert.getRepID(),
                to_insert.getEmail(),
                inserting.manID,
                Timestamp.from(Instant.now()),
                to_insert.getApplicantName(),
                to_insert.getPhoneNumber(),
                to_insert.getAlcoholType().toInt(),
                to_insert.getAlcoholContent(),
                to_insert.getFormula());
        if(to_insert.getAlcoholType() == AlcoholType.Wine && to_insert.getWineFormItems() != null) {
            insertWine(TTB_ID, to_insert.getWineFormItems());
        }
        insertOtherInfo(TTB_ID, to_insert.getBlownBrandedEmbossedInfo());
        if(to_insert.getMailingAddress() != null) {
            insertMailingAddress(TTB_ID, to_insert.getMailingAddress());
        }
        if(to_insert.getAddress() != null) {
            for (Address a : to_insert.getAddress()) {
                insertOtherAddress(TTB_ID, a);
            }
        }
        if(to_insert.getBrewersPermit() != null) {
            for (int i = 0; i < to_insert.getBrewersPermit().size(); i++) {
                insertBrewersPermit(to_insert.getBrewersPermit().get(i), TTB_ID, false);
            }

        }
        } catch (SQLException e ){
            System.out.println(e.toString());
            e.printStackTrace();
        }
        to_insert.setTtbID(TTB_ID);
        return TTB_ID;
    }

    public void insertWine(int TTB_ID, WineFormItems wine) throws SQLException{
        insertWine(TTB_ID, wine.getGrapeVarietal(), wine.getAppellation(), wine.getpH(), wine.getVintageYear());
    }

    public void insertMailingAddress(int TTB_ID, Address to_insert) throws SQLException {
        insertAddress(to_insert.getZip(), true,  to_insert.getCity(), to_insert.getState(), to_insert.getStreet(), TTB_ID);
    }
    public void insertOtherAddress(int TTB_ID, Address to_insert) throws SQLException {
        insertAddress(to_insert.getZip(), false,  to_insert.getCity(), to_insert.getState(), to_insert.getStreet(), TTB_ID);
    }


}
