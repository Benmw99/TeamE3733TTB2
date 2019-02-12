package Entities;

import javax.persistence.*;

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
