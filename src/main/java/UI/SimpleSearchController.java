package UI;

import DB.Database;
import Entities.Agent;
import Entities.Form;
import Entities.SearchResult;
import SearchAlgo.SearchContainer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.application.Application;
import javafx.scene.text.Text;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SimpleSearchController extends PageControllerUI implements Initializable {

    @FXML
    JFXButton searchButton;

    @FXML
    JFXButton randomDrink;

    @FXML
    JFXTextField searchBy;

    @FXML
    JFXButton goBack;

    @FXML
    JFXButton goAdvSearch;

    @FXML
    StackPane UsernameStackPane;

    @FXML
    JFXButton UsernameButton;

    @FXML
    Text title;

    @FXML
    Text descriptor;

    @Override
    protected void onLeave() {}

    @Override
    void onLoad() {
        searchButton.setFont(new Font("Roboto Light", 18));
        randomDrink.setFont(new Font("Roboto Light", 18));
        searchBy.setFont(new Font ("Roboto Light", 24));
        goAdvSearch.setFont(new Font("Roboto Light", 18));
        title.setFont(new Font("Roboto Light", 48));
        descriptor.setFont(new Font("Roboto Light", 24));
        UsernameButton.setFont(new Font("Roboto Light", 18));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(attributeContainer.currentUser != null){
//            System.out.println("This is true");
            UsernameStackPane.setOpacity(1);
            UsernameButton.setText(attributeContainer.currentUser.getLogin());
        }
        else{
            UsernameStackPane.toBack();
        }
    }

    public void pourMeADrink(ActionEvent event){
        AttributeContainer.getInstance().currentForm = Database.getDatabase().dbSelect.randomForm();
        goToPage("ViewSelectedForm.fxml");

    }

    public void search(ActionEvent event){
        if(searchBy.getText() != null && !searchBy.getText().trim().isEmpty()){
            SearchContainer.getInstance().searchResult = new SearchResult();
            List<Form> forms = Database.getDatabase().dbSelect.simpleSearch(searchBy.getText().trim());
            SearchContainer.getInstance().searchResult.setResults(forms);
            SearchContainer.getInstance().query = searchBy.getText().trim();
            SearchContainer.getInstance().setPages();
            SearchContainer.getInstance().currentPage = 1;
            if(SearchContainer.getInstance().searchResult.getResults().size() != 0) {
                SearchContainer.getInstance().loadQueue();
            }
            goToPage("HomeSearch.fxml");
        }
    }


    public void advancedSearch(ActionEvent actionEvent) {
        goToPage("HomeSearch.fxml");
    }

    public void login(ActionEvent actionEvent) {
        attributeContainer.currentUser = null;
        SearchContainer.getInstance().searchResult = new SearchResult();
        SearchContainer.getInstance().currentPage = 1;
        AttributeContainer.getInstance().formQueue = new ArrayList<Form>();
        AttributeContainer.getInstance().currentResults = new SearchResult();
        goToPage("Login.fxml");
    }

    @FXML
    public void toProfile(){
        goToPage("Profile.fxml");
    }

}
