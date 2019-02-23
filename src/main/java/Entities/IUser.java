package Entities;


public interface IUser {

    String getLogin();
    void setLogin(String login);
    String getPassword();
    void setPassword(String password);
    String getName();
    String getEmail();

    boolean authenticate();
    void loadUser();

    boolean isAgent();
    boolean isManufacturer();
    boolean isRepresentative();


    //needs additional parameters relating to size of returned search
    SearchResult search(AdvancedSearch advancedSearch);

}
