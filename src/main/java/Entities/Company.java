package Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COMPANY")
public class Company {
    @Id
    @Column(name = "Company_ID")
    private int companyID;

    @Column(name = "Company_Name")
    private String companyName;

    @Column(name = "Login_Name")
    private String login;

    @Column(name = "Password")
    private String password;

    //private List<Form> forms; //TODO PROPERLY IMPLEMENT THIS, OR NOT? I DON'T KNOW IF I NEED THIS

    public Company() {
    }

    public Company(int companyID, String companyName, String login, String password) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.login = login;
        this.password = password;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
