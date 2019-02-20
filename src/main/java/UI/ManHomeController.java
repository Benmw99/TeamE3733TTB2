package UI;

import Entities.Form;
import Entities.Manufacturer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
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

    @FXML
    JFXToggleButton helpToggleButton;

    @FXML
    Pane largePane;

    @FXML
    Pane smallPane;

    @FXML
    JFXButton goToSingleApp;

    FormDisplayController formViewController;

    public FormDisplayController getFormViewController() {
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
     * Directs user to a single paged form
     * @param event
     * @throws IOException
     */
    @FXML
    public void addSingleForm(ActionEvent event) throws IOException{
        AttributeContainer.getInstance().currentForm = new Form();
        goToPage("ManSingleAppPage.fxml");
    }
    /**
     * Directs user to ManApp to input a form
     * @param event
     * @throws IOException
     */
    @FXML
    public void addForm(ActionEvent event) throws IOException {
        AttributeContainer.getInstance().currentForm = new Form();

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
        AttributeContainer.getInstance().formQueue = ((Manufacturer)AttributeContainer.getInstance().currentUser).loadForms();
        for(Form f : AttributeContainer.getInstance().formQueue){
        }

        helpToggleButton.setSelected(false);
        largePane.setOpacity(0);
        largePane.setDisable(true);
        smallPane.setOpacity(0);
        smallPane.setDisable(true);

        helpToggleButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (helpToggleButton.isSelected()){
                    largePane.setOpacity(0.63);
                    largePane.setDisable(false);
                    smallPane.setOpacity(1);
                    smallPane.setDisable(false);
                    System.out.println("Is selected");


                }
                else {
                    largePane.setOpacity(0);
                    largePane.setDisable(true);
                    smallPane.setOpacity(0);
                    smallPane.setDisable(true);
                    System.out.println("Is not selector");

                }
            }
        });

    }
}
