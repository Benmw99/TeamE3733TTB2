package UI;

import Entities.AlcoholType;
import Entities.Form;
import Entities.Manufacturer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.awt.*;
import java.io.IOException;
import java.sql.Timestamp;

public class ManHomeController extends PageControllerUI  {

    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {

    }


    ////////////////////////////////////
    ////////Controller Functions////////
    ////////////////////////////////////

    @FXML
    public void logOut(ActionEvent event) throws IOException {
        attributeContainer.currentUser = null;
        goToPage("Login.fxml");
    }

    @FXML
    public void addForm(ActionEvent event) throws IOException {
        goToPage("ManApp.fxml");
    }

    @FXML
    public void refreshForms(ActionEvent event) throws IOException {
        ((Manufacturer)attributeContainer.currentUser).loadForms();
        //TODO Integrate tableViewHelper to make work
    }

    @FXML
    public void viewAgentComments(ActionEvent event) throws IOException {
        //TODO Make comments a thing
    }

    @FXML
    public void download(ActionEvent event) throws IOException {
        //TODO Make download
    }

    @FXML
    public void print(ActionEvent event) throws IOException {
        //TODO Make print
    }

}
