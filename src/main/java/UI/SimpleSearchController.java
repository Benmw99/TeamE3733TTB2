package UI;

import DB.Database;
import Entities.Agent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
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
        // TODO figure out how to pull and present a random drink from the DB
    }

    public void search(ActionEvent event){
        // TODO add way to search based upon what's typed in the search text field
    }

    public void goBackPage(ActionEvent event){
        goToPage("HomeSearchController");
    }

}
