package Entities;

import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COMPANY")
public class Manufacturer implements IUser {
    @Id
    @Column(name = "Company_ID")
    private int manID;

    @Column(name = "Company_Name")
    private String manName;

    @Column(name = "Login_Name")
    private String login;

    @Column(name = "Password")
    private String password;


    public Manufacturer(int manID, String manName, String login, String password) {
        this.manID = manID;
        this.manName = manName;
        this.login = login;
        this.password = password;
    }

    public Manufacturer(String login, String password) {
        this.manID = 0;
        this.manName = null;
        this.login = login;
        this.password = password;
    }

    public Manufacturer(){
        this.manID = 0;
        this.manName = null;
        this.login = null;
        this.password = null;
    }

    public boolean isAgent() {
        return false;
    }
    public boolean isManufacturer() {
        return true;
    }
    public boolean isRepresentative() {
        return false;
    }

    public int getManID() {
        return manID;
    }

    public void setManID(int manID) {
        this.manID = manID;
    }

    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getName() { return manName;}

    @Override
    public String getEmail() { return Integer.toString(manID); }



    public boolean authenticate(){
        DB.Database db = DB.Database.getDatabase();
        return db.dbSelect.AuthenticateCompany(login,password);
    }

    public void loadUser(){
        DB.Database db = DB.Database.getDatabase();
        Manufacturer man = db.dbSelect.getManufacturer(login);
        this.manID = man.getManID();
        this.manName = man.getManName();
    }

    /**
     * @author Michael
     * @return A List of forms corresponding to this manufacturer.
     */
    public List<Form> loadForms(){
        DB.Database db = DB.Database.getDatabase();
        List<Form> lof = db.dbSelect.getFormsManu(this.getManID());
        return lof;
    }

    /**
     *  Commits a manufacturer to the database. Make sure the manufacturer is well-formed
     *  with all fields initilized.
     *  @author Michael
     *  @return true for a success, false for a failure
     */
    public boolean registerCompany(){
        DB.Database db = DB.Database.getDatabase();
        db.dbInsert.insertCompany(this);
        return true;
    }


    public SearchResult search(AdvancedSearch advancedSearch) {
        DB.Database db = DB.Database.getDatabase();
        return db.dbSelect.searchBy(advancedSearch);
    }

    //FORM MUST BE FULLY SET INCLUDING AN EMPTY APPROVAL THAT IS INCOMPLETE, AND APPROVALSTATUS MUST BE INCOMPLETE
    public void submitForm(Form form) {
        try {
            form.setCompanyID(this.manID);
            DB.Database db = DB.Database.getDatabase();
            form.setTtbID(db.dbInsert.insertForm(form));
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }

    public String encryptPassword(){
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
            return byteCipherText.toString().substring(0, 50);
        } catch (Exception e){

        }
        return "We should never get here";
    }

    void SubmitLabel() {

    }

    void CheckProgress() {

    }

    boolean equals(Manufacturer aMan){
        return( this.manID == aMan.manID &&
            this.manName.equals(aMan.manName) &&
            this.login.equals(aMan.login) &&
            this.password.equals(aMan.password));
    }



}
