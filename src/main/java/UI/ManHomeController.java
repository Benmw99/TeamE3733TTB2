package UI;

import Entities.AlcoholType;
import Entities.Form;
import Entities.Manufacturer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class ManHomeController extends PageControllerUI  implements Initializable {

    @FXML
    JFXButton printButton;

    @FXML
    JFXButton downloadButton;

    @FXML
    JFXButton commentsButton;

    @FXML
    JFXToggleButton editToggle;

    @FXML
    JFXButton refreshButton;

    @FXML
    JFXButton addNewApp;

    @FXML
    JFXTextField searchAppsTextField;

    FormViewController formViewController;

    public FormViewController getFormViewController() {
        return formViewController;
    }

    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {
    }


    ////////////////////////////////////
    ////////Controller Functions////////
    ////////////////////////////////////

    //New controller overrides
    @FXML
    public void logOut(ActionEvent event) throws IOException {
        attributeContainer.currentUser = null;
        goToPage("Login.fxml");
    }

    /**
     * Directs user to ManApp to input a form
     * @param event
     * @throws IOException
     */
    @FXML
    public void addForm(ActionEvent event) throws IOException {
        goToPage("ManApp.fxml");
    }

    /**
     * Refresh form in inbox
     * @param event
     * @throws IOException
     */
    @FXML
    public void refreshForms(ActionEvent event) throws IOException {
        ((Manufacturer)attributeContainer.currentUser).loadForms();
        //TODO Integrate tableViewHelper to make work
    }

    /**
     * View comments agent has made on forms
     * @param event
     * @throws IOException
     */
    @FXML
    public void viewAgentComments(ActionEvent event) throws IOException {
        //TODO Make comments a thing
    }

    /**
     * Download current form
     * @param event
     * @throws IOException
     */
    @FXML
    public void download(ActionEvent event) throws IOException {
        //TODO Make download
    }

    /**
     * Download current form in printable format
     * @param event
     * @throws IOException
     */
    @FXML
    public void print(ActionEvent event) throws IOException {
        //TODO Make print
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Bdshjbfkjnl");
        AttributeContainer.getInstance().formQueue = ((Manufacturer)AttributeContainer.getInstance().currentUser).loadForms();
        for(Form f : AttributeContainer.getInstance().formQueue){
            System.out.println("BITCH");
        }
    }
}
