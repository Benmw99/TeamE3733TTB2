package Entities;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address {
    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "Zip_Code")
    private String zip;

    @Column(name = "Street")
    private String street;

    @Column(name = "Name")
    private String name;

    @Column(name = "isMailing")
    private boolean isMailing;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @ManyToOne
    @JoinColumn(name = "TTB_ID", insertable = false, updatable = false, nullable = false)
    private Form form;

    public Address() {
    }


    public Address(String city, String state, String zip, String street, String name, boolean isMailing, Form form) {
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.street = street;
        this.name = name;
        this.isMailing = isMailing;
        this.form = form;
    }

    public Address(String city, String state, String zip, String street, String name) {
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.street = street;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public boolean isMailing() {
        return isMailing;
    }

    public void setMailing(boolean mailing) {
        isMailing = mailing;
    }
}
