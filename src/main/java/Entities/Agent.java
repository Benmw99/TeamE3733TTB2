package Entities;

import java.util.List;

import static Entities.ApprovalStatus.Complete;
import static Entities.ApprovalStatus.Incorrect;

public class Agent implements IUser {

    private String repID;
    private String login;
    private String password;
    private String name;

    public Agent(String repID, String login, String password) {
        this.repID = repID;
        this.login = login;
        this.password = password;
    }

    public Agent( String login, String password) {
        this.repID = null;
        this.login = login;
        this.password = password;
    }

    public Agent (){
        this.password = null;
        this.repID = null;
        this.login = null;
    }
    public String getName() {
        return name;
    }

    public String getRepID() {
        return repID;
    }

    public void setRepID(String repID) {
        this.repID = repID;
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


    public List<Form> getThreeForms() {
        DB.Database db = DB.Database.getInstance();
        return db.dbSelect.getThreeForms();
    }

    public boolean authenticate(){
        DB.Database db = DB.Database.getInstance();
        return db.dbSelect.AuthenticateAgent(login,password);
    }

    public void loadUser(){

    }

    public SearchResult search(AdvancedSearch advancedSearch) {
        DB.Database db = DB.Database.getInstance();
        return db.dbSelect.searchBy(advancedSearch);
    }

    public void approveForm(Form form, String qualifications) {
        Approval app = new Approval();
        form.setApproval(app);
        form.getApproval().approve(name, qualifications);
        form.setApprovalStatus(Complete);
        DB.Database db = DB.Database.getInstance();
        db.dbSelect.approveForm(form,form.getApproval());

    }

    public void rejectForm(Form form) {
        form.setApprovalStatus(Incorrect);
        DB.Database db = DB.Database.getInstance();
        Approval app = new Approval();
        app.setPage1(Incorrect);
        app.setPage2(Incorrect);
        app.setPage3(Incorrect);
        app.setPage4(Incorrect);
        app.setAgentApprovalName(this.getName());
        form.setApproval(app);
        db.dbSelect.approveForm(form, form.getApproval());

    }

    void fillQueue() {

    }

    Form importPhysicalForm() {
        Form form = new Form();
        return form;
    }

    void SendToAgent() {

    }

    public void csvDownload(String query, AdvancedSearch advancedSearch){
        DB.Database db = DB.Database.getInstance();
        db.dbSelect.downloadResults(query,advancedSearch);

    }

    public boolean equals(Agent anAgent){
        return (this.repID.equals(anAgent.repID)&&
        this.login.equals(anAgent.login) &&
        this.password.equals(anAgent.password) &&
        this.name.equals(anAgent.name));
    }


}
