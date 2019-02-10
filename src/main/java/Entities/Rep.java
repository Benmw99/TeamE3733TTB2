package Entities;

import javax.persistence.*;

@Entity
@Table(name = "REPS")
public class Rep {
    @Id
    @Column(name = "Rep_ID")
    private String repID;

    @Column(name = "Login_Name")
    private String login;

    @Column(name = "Password")
    private String password;

    public Rep() {
    }

    public Rep(String repID, String login, String password) {
        this.repID = repID;
        this.login = login;
        this.password = password;
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
}
