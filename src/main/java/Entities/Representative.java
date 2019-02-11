package Entities;

public class Representative implements IUser {

    private String repID;
    private String login;
    private String password;

    public Representative(String repID, String login, String password) {
        this.repID = repID;
        this.login = login;
        this.password = password;
    }

    public Representative(){
        this.repID = null;
        this.login = null;
        this.password = null;
    }

    public String getRepID() {
        return repID;
    }

    public void setRepID(String repID) {
        this.repID = repID;
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

    public boolean authenticate(){
        DB.Database db = DB.Database.getInstance();
        return db.dbSelect.AuthenticateRep(login,password);
    }

    public void loadUser(){
        DB.Database db = DB.Database.getInstance();
        Representative rep = db.dbSelect.getRepresentative(login);
        this.repID = rep.getRepID();

    }


    public SearchResult search(AdvancedSearch advancedSearch) {
        DB.Database db = DB.Database.getInstance();
        return db.dbSelect.searchBy(advancedSearch);
    }

    void SubmitForm() {

    }

    void SubmitLabel() {

    }

    void CheckProgress() {

    }
    boolean equals(Representative rep){
        return(this.repID.equals(rep.repID) &&
            this.login.equals(rep.login) &&
            this.password.equals(rep.password));
    }

}
