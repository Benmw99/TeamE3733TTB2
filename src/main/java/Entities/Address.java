package Entities;

public class Address {
    private String city;
    private String state;
    private String zip;
    private String street;
    private String name;
    private int ID;

    public Address() {
    }

    public Address(String city, String state, String zip, String street, String name, int ID) {
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.street = street;
        this.name = name;
        this.ID = ID;
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
}
