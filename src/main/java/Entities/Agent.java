package Entities;

import javax.persistence.*;

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
}
