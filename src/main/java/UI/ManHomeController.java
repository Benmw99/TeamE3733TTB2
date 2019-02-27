package UI;

import Entities.Form;
import Entities.FormExporter;
import Entities.Manufacturer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;

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
    JFXButton helpButton;

    @FXML
    Pane largePane;

    @FXML
    Pane smallPane;

    @FXML
    JFXButton goToSingleApp;

    @FXML
    JFXButton exitHelp;

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
        goToPage("ManViewAgentComments.fxml");
       /* if(attributeContainer.currentForm.getApproval().getQualifications() != null) {
            if(attributeContainer.currentForm.getApprovalStatus().toInt() == 1) {
                Alert agentComments = new Alert(Alert.AlertType.INFORMATION);
                agentComments.setHeaderText("Qualifications");
                agentComments.setTitle("Form approved with following qualifications:");
                agentComments.setContentText(attributeContainer.currentForm.getApproval().getQualifications());
                agentComments.show();
            } else if(attributeContainer.currentForm.getApprovalStatus().toInt() == 2) {
                Alert agentComments = new Alert(Alert.AlertType.INFORMATION);
                agentComments.setHeaderText("Corrections");
                agentComments.setTitle("Form rejected with following corrections needed:");
                agentComments.setContentText(attributeContainer.currentForm.getApproval().getQualifications());
                agentComments.show();
            } else if(attributeContainer.currentForm.getApprovalStatus().toInt() == 3) {
                Alert agentComments = new Alert(Alert.AlertType.INFORMATION);
                agentComments.setHeaderText("Rejected");
                agentComments.setTitle("Form rejected for following reasons:");
                agentComments.setContentText(attributeContainer.currentForm.getApproval().getQualifications());
                agentComments.show();
            }
        } else {
            Alert agentComments = new Alert(Alert.AlertType.INFORMATION);
            agentComments.setContentText("No current comments");
            agentComments.setHeaderText("Agent Comments");
            agentComments.setTitle("Comments");
            agentComments.show();
        } */
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
        if(AttributeContainer.getInstance().currentForm != null){
            new FormExporter(AttributeContainer.getInstance().currentForm, "S");
            printButton.setText("Printed!");
        } else {
            Alert yikes = new Alert(Alert.AlertType.WARNING);
            yikes.setContentText("Please select a form!");
            yikes.setHeaderText("Invalid Form Selection");
            yikes.show();
        }
    }

    @FXML
    public void handleHelp(ActionEvent event) {
        final Node source = (Node) event.getSource();
        String id = source.getId();
        if (id.equals("helpButton")) {
            largePane.setOpacity(0.63);
            largePane.setDisable(false);
            smallPane.setOpacity(1);
            smallPane.setDisable(false);
//            System.out.println(event.getSource());
            System.out.println(id + " true");
        } else if(id.equals("exitHelp")){
            System.out.println(id + " else");
            largePane.setOpacity(0);
            largePane.setDisable(true);
            smallPane.setOpacity(0);
            smallPane.setDisable(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AttributeContainer.getInstance().formQueue = ((Manufacturer)AttributeContainer.getInstance().currentUser).loadForms();
        for(Form f : AttributeContainer.getInstance().formQueue){
        }

        //helpButton.setSelected(false);
        largePane.setOpacity(0);
        largePane.setDisable(true);
        smallPane.setOpacity(0);
        smallPane.setDisable(true);



    }
}
