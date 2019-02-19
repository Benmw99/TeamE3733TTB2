package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Class for constructing the database. Class is a singleton
//NOTE RIGHT NOW CAN ONLY RESET THE DB ONCE AS IT CLOSES AFTER THAT
public class TableBuilder {
    private static TableBuilder tablebuilder;
    private Connection connection;
    //Constant for the imagesize in the database
    private static final String IMAGESIZE = "1M";

    private TableBuilder() {
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
    }

    private static class SingletonHelper {
        private static final TableBuilder tablebuilder = new TableBuilder();
    }

    protected static TableBuilder getTablebuilder() {
        return SingletonHelper.tablebuilder;
    }


    /**
     * Resets the DB completely. Note this removes all info from the DB
     * @author Jordan
     */
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
        /*try {
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
        } catch (SQLException ignored) {}*/
        buildAgents();
        buildReps();
        buildCompany();
        buildForm();
        buildBrewersPermit();
        buildApproval();
        buildAddress();
        buildWine();
        buildLabel();
        try { //CLOSING CONNECTION BECAUSE YOU SHOULD ONLY NEED TO RESET ONCE
            connection.close();
        } catch (SQLException ignored) {}
    }

    /**
     * Sends a statement to the DB to be executed
     * @param buildString The string of the query to be executed
     */
    void sendStatement(String buildString) {
        try {
            PreparedStatement ps =  connection.prepareStatement(buildString);
            ps.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

    private void buildAddress(){
        String buildString = "CREATE TABLE ADDRESS (" +
                "Zip_Code VARCHAR(8), " +
                "isMailing BOOLEAN, " +
                "City VARCHAR(32), " +
                "State VARCHAR(2), " +
                "Street VARCHAR(50), " +
                "Name VARCHAR(88), " +
                "TTB_ID BIGINT, " +
                "ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                "Constraint Address_PK Primary Key (ID), " +
                "Constraint Address_FK Foreign Key (TTB_ID) References Form(TTB_ID) On Delete Cascade)";
        sendStatement(buildString);
        //String createSeq = "create sequence Address_ID as BIGINT start with 1";
        //sendStatement(createSeq);
    }

    private void buildWine(){
        String buildString = "CREATE TABLE WINE (" +
                "ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                "Grape_Varietals VARCHAR(256)," +
                "Wine_Appellation VARCHAR(80), " +
                "PH REAL, " +
                "Vintage INT, " +
                "TTB_ID BIGINT, " +
                "Constraint Wine_PK Primary Key (ID), " +
                "Constraint Wine_FK Foreign Key (TTB_ID) References Form(TTB_ID) On Delete Cascade)";
        sendStatement(buildString);
    }

    private void buildBrewersPermit(){
        String buildString = "CREATE TABLE BREWERSPERMIT (" +
                "Brewers_No VARCHAR(32)," +
                "TTB_ID BIGINT," +
                "isPrimary BOOLEAN, " +
                "ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                "Constraint BrewersPermit_PK Primary Key (ID), " +
                "Constraint BrewersPermit_FK Foreign Key (TTB_ID) References Form(TTB_ID) On Delete Cascade)";
        sendStatement(buildString);
    }

    private void buildApproval(){
        String buildString = "CREATE TABLE APPROVAL (" +
                "Approving_Agent VARCHAR(32)," +
                "TTB_ID BIGINT, " +
                "ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                "Date_Approved DATE," +
                "Expiration DATE," +
                "Page_1 Int," +
                "Page_2 Int," +
                "Page_3 Int, " +
                "Page_4 Int, " +
                "CT Int, " +
                "Origin Int, " +
                "Qualification VARCHAR(600) DEFAULT NULL, " +
                "Constraint Approval_PK Primary Key (ID), " +
                "Constraint Approval_FK Foreign Key (TTB_ID) References Form(TTB_ID) On Delete Cascade)";
        sendStatement(buildString);
    }

    private void buildLabel(){
        String buildString = "CREATE TABLE LABEL (" +
                "ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                "Image blob(" + IMAGESIZE + "), " +
                "ImageName varchar(64), " +
                "TTB_ID BIGINT, " +
                "Constraint Label_PK Primary Key (id), " +
                "Constraint Label_FK Foreign Key (TTB_ID) References Form(TTB_ID) On Delete Cascade)";
        sendStatement(buildString);
        //String createSeq = "create sequence Label_ID as BIGINT start with 1";
        //sendStatement(createSeq);
    }

    private void buildForm(){
        String buildString = "CREATE TABLE FORM (" +
                "TTB_ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                "Serial_Number VARCHAR(12)," +
                "Fanciful_Name VARCHAR(256)," +
                "Brand_Name VARCHAR(256)," +
                "Source BOOLEAN," +
                "Approve SMALLINT," +
                "Email VARCHAR(256)," +
                "Date_Submitted DATE," +
                "Applicant_Name VARCHAR(32)," +
                //"Text VARCHAR(256) DEFAULT NULL, " +
                "Phone VARCHAR(16)," +
                "Alcohol_Type SMALLINT," +
                "APV REAL, " +
                "WorkingOn BIGINT, " +
                "Formula VARCHAR(16) DEFAULT NULL," +
                "Rep_ID VARCHAR(16) DEFAULT NULL," +
                "Other_Info VARCHAR(256), " +
                "Company_ID BIGINT," +
                "Constraint Form_PK Primary Key (TTB_ID))";
                //TODO IMPLEMENT REPS            "Constraint Form_FK_Rep Foreign Key (Rep_ID) References Reps(Rep_ID), " +
                //"Constraint Form_FK_Company Foreign Key (Company_ID) References Company(Company_ID))";
        sendStatement(buildString);
        //String createSeq = "create sequence Form_ID as BIGINT start with 1";
        //sendStatement(createSeq);
    }

    //Agent ID's are currently generated
    private void buildAgents() {
        String buildString = "CREATE TABLE AGENTS (" +
                "Agent_Name VARCHAR(32), " +
                "Agent_ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
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

    private void buildCompany() {
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
