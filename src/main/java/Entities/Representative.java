package Entities;

import javax.persistence.*;

@Entity
@Table(name = "REPS")
public class Representative implements IUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Rep_ID")
    private int repID;

    @Column(name = "Login_Name")
    private String login;

    @Column(name = "Password")
    private String password;

    @Column(name = "emailStatus")
    private boolean emailStatus;

    @Column(name = "docPass")
    private String documentPassword;

    public Representative(String login, String password, boolean emailStatus, String documentPassword) {
        this.login = login;
        this.password = password;
        this.emailStatus = emailStatus;
        this.documentPassword = documentPassword;
    }

    public Representative(String login, String password, boolean emailStatus) {
        this.login = login;
        this.password = password;
        this.emailStatus = emailStatus;
    }

    public Representative(int repID, String login, String password) {
        this.repID = repID;
        this.login = login;
        this.password = password;
    }

    public Representative(){
        this.repID = 0;
        this.login = null;
        this.password = null;
        this.emailStatus = false;
    }

    public boolean isAgent() {
        return false;
    }
    public boolean isManufacturer() {
        return false;
    }
    public boolean isRepresentative() {
        return true;
    }

    public int getRepID() {
        return repID;
    }

    public void setRepID(int repID) {
        this.repID = repID;
    }

    public boolean isEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(boolean emailStatus) {
        this.emailStatus = emailStatus;
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

    public String getDocumentPassword() {
        return documentPassword;
    }

    public void setDocumentPassword(String documentPassword) {
        this.documentPassword = documentPassword;
    }

    @Override
    public String getName(){ return "" + this.repID; }


    public boolean authenticate(){
        DB.Database db = DB.Database.getDatabase();
        return db.dbSelect.AuthenticateRep(login,password);
    }

    public void loadUser(){
        DB.Database db = DB.Database.getDatabase();
        Representative rep = db.dbSelect.getRepresentative(login);
        this.repID = rep.getRepID();
    }


    public SearchResult search(AdvancedSearch advancedSearch) {
        DB.Database db = DB.Database.getDatabase();
        return db.dbSelect.searchBy(advancedSearch);
    }

    void SubmitForm() {

    }

    void SubmitLabel() {

    }

    void CheckProgress() {

    }
    boolean equals(Representative rep){
        return(this.repID == (rep.repID) &&
            this.login.equals(rep.login) &&
            this.password.equals(rep.password));
    }

}
