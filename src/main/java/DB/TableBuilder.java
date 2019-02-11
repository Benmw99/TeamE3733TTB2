package DB;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TableBuilder extends DatabaseAbstract {
    private static TableBuilder tableBuilder_instance = null;
    private static final String IMAGESIZE = "1M";

    private TableBuilder(String path) {
       super(path);
    }

    /**
     * Gets the one instance of the class making it a singleton
     * @author Jordan
     * @return The current instance of DBSelect
     */
    static TableBuilder getInstance() {
        if (tableBuilder_instance == null) {
            tableBuilder_instance = new TableBuilder("./ttb.db");
        }
        return tableBuilder_instance;
    }

    public void resetDB() {
        try {
            String dropString = "Drop table Address";
            PreparedStatement ps =  connection.prepareStatement(dropString);
            ps.execute();
        } catch (SQLException ignored) {}
        try {
            String dropString = "Drop table Wine";
            PreparedStatement ps =  connection.prepareStatement(dropString);
            ps.execute();
        } catch (SQLException ignored) {}
        try {
            String dropString = "Drop table Approval";
            PreparedStatement ps =  connection.prepareStatement(dropString);
            ps.execute();
        } catch (SQLException ignored) {}
        try {
            String dropString = "Drop table BrewersPermit";
            PreparedStatement ps =  connection.prepareStatement(dropString);
            ps.execute();
        } catch (SQLException ignored) {}
        try {
            String dropString = "Drop table OtherInfo";
            PreparedStatement ps =  connection.prepareStatement(dropString);
            ps.execute();
        } catch (SQLException ignored) {}
        try {
            String dropString = "Drop table Label";
            PreparedStatement ps =  connection.prepareStatement(dropString);
            ps.execute();
        } catch (SQLException ignored) {}
        try {
            String dropString = "Drop table Form";
            PreparedStatement ps =  connection.prepareStatement(dropString);
            ps.execute();
        } catch (SQLException ignored) {}
        try {
            String dropString = "Drop table Agents";
            PreparedStatement ps =  connection.prepareStatement(dropString);
            ps.execute();
        } catch (SQLException ignored) {}
        try {
            String dropString = "Drop table Reps";
            PreparedStatement ps =  connection.prepareStatement(dropString);
            ps.execute();
        } catch (SQLException ignored) {}
        try {
            String dropString = "Drop table Company";
            PreparedStatement ps =  connection.prepareStatement(dropString);
            ps.execute();
        } catch (SQLException ignored) {}
        try {
            String dropString = "Drop Sequence Address_ID RESTRICT ";
            PreparedStatement ps =  connection.prepareStatement(dropString);
            ps.execute();
        } catch (SQLException ignored) {}
        try {
            String dropString = "Drop Sequence Label_ID RESTRICT ";
            PreparedStatement ps =  connection.prepareStatement(dropString);
            ps.execute();
        } catch (SQLException ignored) {}
        try {
            String dropString = "Drop Sequence Form_ID RESTRICT ";
            PreparedStatement ps =  connection.prepareStatement(dropString);
            ps.execute();
        } catch (SQLException ignored) {}
        buildAgents();
        buildReps();
        buildCompany();
        buildForm();
        buildBrewersPermit();
        buildApproval();
        buildAddress();
        buildOtherInfo();
        buildWine();
        buildLabel();
    }

    void sendStatement(String buildString) {
        try {
            PreparedStatement ps =  connection.prepareStatement(buildString);
            ps.execute();
        } catch (SQLException e){
            System.out.println(e.toString());
        }
    }

    private void buildAddress(){
        String buildString = "CREATE TABLE ADDRESS (" +
                "Zip_Code VARCHAR(8), " +
                "isMailing BOOLEAN, " +
                "City VARCHAR(32), " +
                "TTB_ID BIGINT, " +
                "State VARCHAR(2), " +
                "Street VARCHAR(32), " +
                "ID BIGINT," +
                "Constraint Address_PK Primary Key (ID), " +
                "Constraint Address_FK Foreign Key (TTB_ID) References Form(TTB_ID) On Delete Cascade)";
        sendStatement(buildString);
        String createSeq = "create sequence Address_ID as BIGINT start with 1";
        sendStatement(createSeq);
    }

    private void buildOtherInfo(){
        String buildString = "CREATE TABLE OTHERINFO (" +
                "TTB_ID BIGINT," +
                "Text VARCHAR(256), " +
                "Constraint OtherInfoPK Primary Key (TTB_ID), " +
                "Constraint OtherInfoFK Foreign Key (TTB_ID) References Form(TTB_ID) On Delete Cascade)";
        sendStatement(buildString);
    }

    private void buildWine(){
        String buildString = "CREATE TABLE WINE (" +
                "TTB_ID BIGINT," +
                "Grape_Varietals VARCHAR(256)," +
                "Wine_Appellation VARCHAR(32), " +
                "PH REAL, " +
                "Vintage INT, " +
                "Constraint Wine_PK Primary Key (TTB_ID), " +
                "Constraint Wine_FK Foreign Key (TTB_ID) References Form(TTB_ID) On Delete Cascade)";
        sendStatement(buildString);
    }

    private void buildBrewersPermit(){
        String buildString = "CREATE TABLE BREWERSPERMIT (" +
                "Brewers_No VARCHAR(32)," +
                "TTB_ID BIGINT," +
                "isPrimary BOOLEAN, " +
                "Constraint BrewersPermit_PK Primary Key (TTB_ID, Brewers_No), " +
                "Constraint BrewersPermit_FK Foreign Key (TTB_ID) References Form(TTB_ID) On Delete Cascade)";
        sendStatement(buildString);
    }

    private void buildApproval(){
        String buildString = "CREATE TABLE APPROVAL (" +
                "Approving_Agent VARCHAR(32)," +
                "TTB_ID BIGINT," +
                "Date TIMESTAMP," +
                "Expiration TIMESTAMP," +
                "Page_1 Int," +
                "Page_2 Int," +
                "Page_3 Int, " +
                "Page_4 Int, " +
                "Qualification VARCHAR(256) DEFAULT NULL, " +
                "Constraint Approval_PK Primary Key (TTB_ID), " +
                "Constraint Approval_FK Foreign Key (TTB_ID) References Form(TTB_ID) On Delete Cascade)";
        sendStatement(buildString);
    }

    private void buildLabel(){
        String buildString = "CREATE TABLE LABEL (" +
                "ID BIGINT, " +
                "Image blob(" + IMAGESIZE + "), " +
                "ImageName varchar(64), " +
                "TTB_ID BIGINT, " +
                "Constraint Label_PK Primary Key (id), " +
                "Constraint Label_FK Foreign Key (TTB_ID) References Form(TTB_ID) On Delete Cascade)";
        sendStatement(buildString);
        String createSeq = "create sequence Label_ID as BIGINT start with 1";
        sendStatement(createSeq);
    }

    private void buildForm(){
        String buildString = "CREATE TABLE FORM (" +
                "TTB_ID BIGINT," +
                "Serial_Number VARCHAR(8)," +
                "Fanciful_Name VARCHAR(256)," +
                "Brand_Name VARCHAR(256)," +
                "Source BOOLEAN," +
                "APPROVE SMALLINT," +
                "Email VARCHAR(256)," +
                "Date_Submitted TIMESTAMP," +
                "Applicant_Name VARCHAR(32)," +
                "Phone VARCHAR(16)," +
                "Alcohol_Type SMALLINT," +
                "APV REAL, " +
                "Formula VARCHAR(16) DEFAULT NULL," +
                "Rep_ID VARCHAR(16) DEFAULT NULL," +
                "Company_ID BIGINT," +
                "Constraint Form_PK Primary Key (TTB_ID), " +
    //TODO IMPLEMENT REPS            "Constraint Form_FK_Rep Foreign Key (Rep_ID) References Reps(Rep_ID), " +
                "Constraint Form_FK_Company Foreign Key (Company_ID) References Company(Company_ID))";
        sendStatement(buildString);
        String createSeq = "create sequence Form_ID as BIGINT start with 1";
        sendStatement(createSeq);
    }

    private void buildAgents() {
        String buildString = "CREATE TABLE AGENTS (" +
                "Agent_Name VARCHAR(32), " +
                "Agent_ID BIGINT, " +
                "Login_Name VARCHAR(32), " +
                "Password VARCHAR(256), " +
                "Constraint Agents_PK Primary Key (Login_Name), " +
                "Constraint Agents_UQ Unique (Agent_ID))";
        sendStatement(buildString);
    }

    private void buildReps() {
        String buildString = "CREATE TABLE REPS (" +
                "Rep_ID VARCHAR(16), " +
                "Login_Name VARCHAR(32), " +
                "Password VARCHAR(256), " +
                "Constraint Reps_PK Primary Key (Login_Name), " +
                "Constraint Reps_UQ Unique (Rep_ID))";
        sendStatement(buildString);
    }

    private void buildCompany(){
        String buildString = "CREATE TABLE COMPANY (" +
                "Company_ID BIGINT," +
                "Company_Name VARCHAR(256), " +
                "Login_Name VARCHAR(32), " +
                "Password VARCHAR(256), " +
                "Constraint Company_PK Primary Key (Login_Name), " +
                "Constraint Company_UQ Unique (Company_ID))";
        sendStatement(buildString);
    }
}
