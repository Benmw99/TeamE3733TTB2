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

    @Override
    protected void onLeave() {}

    @Override
    void onLoad() {}

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

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

}
