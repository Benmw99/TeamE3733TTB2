package Entities;

import DB.Database;
import UI.AttributeContainer;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.persistence.*;
import java.security.SecureRandom;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "AGENTS")
public class Agent implements IUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Agent_ID")
    private int agentID;

    @Column(name = "Login_Name")
    private String login;

    @Column(name = "Password")
    private String password;

    @Column(name = "Agent_Name")
    private String name;
    public Agent() {
    }

    public Agent(int agentID, String login, String password, String name) {
        this.agentID = agentID;
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public Agent(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public Agent(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean isAgent() {
        return true;
    }
    public boolean isManufacturer() {
        return false;
    }
    public boolean isRepresentative() {
        return false;
    }

    public int getAgentID() {
        return agentID;
    }

    public void setAgentID(int agentID) {
        this.agentID = agentID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * This may or may not work.
     * @throws  NullPointerException if there are no more forms to get
     * @Author: probably nick.
     * @return
     */
    private Form getNextUnapproved() throws NullPointerException  {
        DB.Database db = DB.Database.getDatabase();
        Form temp = db.dbSelect.getNextUnapproved();
        if(temp == null){
            throw  new NullPointerException();
        } else {
            System.out.println(this.agentID);
            temp.setWorkingOn(this.agentID);
            db.dbSelect.updateWorkingOn(temp);
            return temp;
        }
    }

    /**
     * Puts the form queue into the Current Queue in the AC
     * @author Michael
     */
    public void getQueueIntoAC(){
        AttributeContainer ac =  AttributeContainer.getInstance();
        ac.formQueue = new ArrayList<Form>();
        ac.formQueue.addAll(this.getQueue());
    }
    /**
     * Gets the list of forms currently associated with the agent.
     */
    public List<Form> getCurrentQueue(){
        return Database.getDatabase().dbSelect.getCurrentApprovalQueue(this.agentID);
    }

    /**
     * Gets a number of forms based upon the integer set in the Attribute Container...
     * Should properly set those forms as working on. Only gets forms as long as there are forms to get...
     * @author Michael
     * @return The List of Forms.
     */
    private List<Form> getQueue(){
        List<Form> lof = new ArrayList<Form>();
        int end = AttributeContainer.getInstance().numForQueue;
        List<Form> current = new ArrayList<Form>();
        current = Database.getDatabase().dbSelect.getCurrentApprovalQueue(this.getAgentID());
        int start = current.size();
        for(int i = start; i < end; i ++){
            try {
                lof.add(getNextUnapproved());
            } catch (NullPointerException e){
                //There was no valid form
            }
        }
        current.addAll(lof);
        return current;
    }

    public void encryptPassword(){
        try {
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(128);
            SecureRandom secRand = new SecureRandom();
            secRand.setSeed(123);
            generator.init(secRand);
            SecretKey secKey = generator.generateKey();
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
            byte[] byteCipherText = aesCipher.doFinal(this.password.getBytes());
            this.password =  byteCipherText.toString().substring(0, 50);
        } catch (Exception e){

        }
    }


    public boolean authenticate(){
        DB.Database db = DB.Database.getDatabase();
        return db.dbSelect.AuthenticateAgent(login,password);
    }

    /**
     * Loads a user from the database as long as THIS user's login is correct.
     */
    public void loadUser(){
         Agent temp = Database.getDatabase().dbSelect.getAgent(this.login);
         this.password = temp.getPassword();
         System.out.println(temp.getAgentID());
         this.agentID = temp.getAgentID();
         this.name = temp.getName();

    }

    public SearchResult search(AdvancedSearch advancedSearch) {
        DB.Database db = DB.Database.getDatabase();
        return db.dbSelect.searchBy(advancedSearch);
    }

    public void approveForm(Form form, String qualifications, Date expiration) {
        long milli = System.currentTimeMillis();
        Date approved = new Date(milli);
        DB.Database db = DB.Database.getDatabase();
        Approval app = form.getApproval();
        app.setAgentApprovalName(this.getName());
        app.setDateApproved(approved);
        app.setExpDate(expiration);
        app.setQualifications(qualifications);
        app.setPage1(ApprovalStatus.Complete);
        app.setPage2(ApprovalStatus.Complete);
        app.setPage3(ApprovalStatus.Complete);
        app.setPage4(ApprovalStatus.Complete);
        form.setApprovalStatus(ApprovalStatus.Complete);
        form.setApproval(app);
   //     Mailer inform = new Mailer();
     //   inform.sendMail(form);
        db.dbInsert.updateApproval(form);
    }

    public void approveForm(Form form, String qualifications) {
        long milli = System.currentTimeMillis();
        Date approved = new Date(milli);
        DB.Database db = DB.Database.getDatabase();
        Approval app = new Approval();
        app.setAgentApprovalName(this.getName());
        app.setDateApproved(approved);
        app.setExpDate(null);
        app.setQualifications(qualifications);
        app.setPage1(ApprovalStatus.Complete);
        app.setPage2(ApprovalStatus.Complete);
        app.setPage3(ApprovalStatus.Complete);
        app.setPage4(ApprovalStatus.Complete);
        form.setApprovalStatus(ApprovalStatus.Complete);
        form.setApproval(app);
   //     Mailer inform = new Mailer();
     //   inform.sendMail(form);
        db.dbInsert.updateApproval(form);
    }

    public void rejectForm(Form form) {
        DB.Database db = DB.Database.getDatabase();
        Approval app = form.getApproval();
        app.setAgentApprovalName(this.getName());
        app.setPage1(ApprovalStatus.Incorrect);
        app.setPage2(ApprovalStatus.Incorrect);
        app.setPage3(ApprovalStatus.Incorrect);
        app.setPage4(ApprovalStatus.Incorrect);
        form.setApprovalStatus(ApprovalStatus.Incorrect);
        form.setApproval(app);
   //     Mailer inform = new Mailer();
     //   inform.sendMail(form);
        db.dbInsert.updateApproval(form);
    }

    void fillQueue() {

    }

    Form importPhysicalForm() {
        Form form = new Form();
        return form;
    }

    void SendToAgent() {

    }

    public void csvDownload(SearchResult sr, boolean isCSV){
        DB.Database db = DB.Database.getDatabase();
        db.dbSelect.downloadQuery(sr, isCSV);

    }

    public boolean equals(Agent anAgent){
        return (this.agentID == (anAgent.agentID)&&
        this.login.equals(anAgent.login) &&
        this.password.equals(anAgent.password) &&
        this.name.equals(anAgent.name));
    }


}
