package Entities;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.persistence.*;
import java.security.SecureRandom;
import java.sql.Date;
import java.sql.SQLException;


@Entity
@Table(name = "AGENTS")
public class Agent {
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

    public Form getNextUnapproved() {
        DB.Database db = DB.Database.getDatabase();
        Form temp = db.dbSelect.getNextUnapproved();
        temp.setWorkingOn(this.agentID);
        db.dbSelect.updateWorkingOn(temp);
        return temp;

    }

    String encryptPassword(){
        try {
            KeyGenerator generator = new KeyGenerator("AES");
            generator.init(128);
            SecureRandom secRand = new SecureRandom();
            secRand.setSeed(123);
            generator.init(secRand);
            SecretKey secKey = generator.generateKey();
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
            byte[] byteCipherText = aesCipher.doFinal(this.password.getBytes());
            return byteCipherText.toString();
        } catch (Exception e){

        }
        return "We should never get here";
    }


    public boolean authenticate(){
        DB.Database db = DB.Database.getDatabase();
        return db.dbSelect.AuthenticateAgent(login,password);
    }

    public void loadUser(){

    }

    public SearchResult search(AdvancedSearch advancedSearch) {
        DB.Database db = DB.Database.getDatabase();
        return db.dbSelect.searchBy(advancedSearch);
    }

    public void approveForm(Form form, String qualifications, Date expiration, Date approved) {
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
