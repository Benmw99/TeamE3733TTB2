package UI;

import DB.Database;
import Entities.Agent;
import Entities.Mailer;
import SearchAlgo.AsciiPrinter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AgentReviewingToolsController extends PageControllerUI implements Initializable {

    @FXML
    JFXComboBox<String> sectionMarkComboBox;

    @FXML
    JFXButton printViewFormButton;

    @FXML
    Button logoutButton;

    @FXML
    Button printButton;

    @FXML
    JFXButton approveButton;

    @FXML
    JFXButton rejectButton;

    @FXML
    JFXButton homeButton;

    @FXML
    Label Display1Label;
    @FXML
    Label Display2Label;

    @FXML
    Label Display3Label;

    @FXML
    Label DisplayReview4Label1;

    @FXML
    Label Display4Label2;

    @FXML
    Label Display5Label1;

    @FXML
    Label Display5Label2;

    @FXML
    Label Display5Label3;

    @FXML
    Label Display6Label;

    @FXML
    Label Display7Label;

    @FXML
    Label Display8Label;

    @FXML
    Label Display9Label;

    @FXML
    Label Display10Label;

    @FXML
    Label Display11Label;

    @FXML
    Label Display12Label;

    @FXML
    Label Display13Label;

    @FXML
    Label Display14Label;

    @FXML
    Label Display15Label1;

    @FXML
    Label Display15Label2;

    @FXML
    Label Display15Label3;

    @FXML
    Label Display16Label1;

    @FXML
    Label Display16Label2;

    @FXML
    Label Display17Label;

    @FXML
    Label Display18Label;

    @FXML
    Label Display20Label;

    @FXML
    Button sendAgentButton;

    @FXML
    JFXTextField email;

    @FXML
    JFXTextArea message;

    @FXML
    JFXTextField ttb_id;

    @FXML
    Pane formDisplay;

    @FXML
    FormDisplayController formDisplayController;

    boolean page1Complete;
    boolean page2Complete;
    boolean page3Complete;
    boolean page4Complete;
    boolean page1Incomplete;
    boolean page2Incomplete;
    boolean page3Incomplete;
    boolean page4Incomplete;
    boolean page1Incorrect;
    boolean page2Incorrect;
    boolean page3Incorrect;
    boolean page4Incorrect;

    @FXML
    JFXTextArea comment;


    ///////////////////////////////////////////////////
    ///////////       The Actual Code      ////////////
    ///////////////////////////////////////////////////

    @Override
    void onLoad(){}

    @Override
    protected void onLeave(){}

    //New controller overrides
    @FXML
    public void logOut(ActionEvent event) throws IOException {
        attributeContainer.wipeSession();
        goToPage("AgentLogin.fxml");
    }

    /**
     * Set approval status of current form to approved
     * @param event
     * @throws IOException
     */
    @FXML
    public void approveForm(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {

            //TODO: get qualifications from text field
            ((Agent) attributeContainer.currentUser).approveForm(attributeContainer.currentForm, comment.getText());
            attributeContainer.formQueue.remove(attributeContainer.currentForm);
            AttributeContainer.getInstance().formQueue = ((Agent) attributeContainer.currentUser).getCurrentQueue();
            Thread mailThread = new Thread( new Mailer(AttributeContainer.getInstance().currentForm));
            mailThread.start();
            attributeContainer.currentForm = null;
            goToPage("AgentHome.fxml");
        }
    }

    /**
     * Set approval status of current form to rejected
     * @param event
     * @throws IOException
     */
    @FXML
    public void rejectForm(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {
            ((Agent) attributeContainer.currentUser).rejectForm(attributeContainer.currentForm, comment.getText());
            attributeContainer.formQueue.remove(attributeContainer.currentForm);
            AttributeContainer.getInstance().formQueue = ((Agent) attributeContainer.currentUser).getCurrentQueue();
            Thread mailThread = new Thread( new Mailer(AttributeContainer.getInstance().currentForm));
            mailThread.start();
            attributeContainer.currentForm = null;
            goToPage("AgentHome.fxml");
        }
    }

    /**
     * Sends current form to printable format
     * @param event
     * @throws IOException
     */
    @FXML
    public void print(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {
            AsciiPrinter.print(AttributeContainer.getInstance().formQueue, ',');
        }
    }

    /**
     * Directs Agent back to home page
     * @param event
     * @throws IOException
     */
    @FXML
    public void returnHome(ActionEvent event) throws IOException {
        goToPage("AgentHome.fxml");
    }

    /**
     * Marks page of form as complete/incomplete/incorrect
     */
    public void markForm() {
        System.out.println("C-C-C-COMBO BOX");
        if(sectionMarkComboBox.getValue() == "Complete"){
            if(formDisplayController.getTab() == 1) {
                page1Complete = true;
                page1Incomplete = false;
                page1Incorrect = false;
            } else if(formDisplayController.getTab() == 2) {
                page2Complete = true;
                page2Incomplete = false;
                page2Incorrect = false;
            } else if(formDisplayController.getTab() == 3) {
                page3Complete = true;
                page3Incomplete = false;
                page3Incorrect = false;
            } else if(formDisplayController.getTab() == 4) {
                page4Complete = true;
                page4Incomplete = false;
                page4Incorrect = false;
            }
        } else if (sectionMarkComboBox.getValue().equals("Incomplete")) {
            if(formDisplayController.getTab() == 1) {
                page1Complete = false;
                page1Incomplete = true;
                page1Incorrect = false;
            } else if(formDisplayController.getTab() == 2) {
                page2Complete = false;
                page2Incomplete = true;
                page2Incorrect = false;
            } else if(formDisplayController.getTab() == 3) {
                page3Complete = false;
                page3Incomplete = true;
                page3Incorrect = false;
            } else if(formDisplayController.getTab() == 4) {
                page4Complete = false;
                page4Incomplete = true;
                page4Incorrect = false;
            }
        } else {
            if(formDisplayController.getTab() == 1) {
                page1Complete = false;
                page1Incomplete = false;
                page1Incorrect = true;
            } else if(formDisplayController.getTab() == 2) {
                page2Complete = false;
                page2Incomplete = false;
                page2Incorrect = true;
            } else if(formDisplayController.getTab() == 3) {
                page3Complete = false;
                page3Incomplete = false;
                page3Incorrect = true;
            } else if(formDisplayController.getTab() == 4) {
                page4Complete = false;
                page4Incomplete = false;
                page4Incorrect = true;
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**
         * The different combo box options
         */
        sectionMarkComboBox.getItems().addAll("Complete", "Incomplete", "Incorrect");

        sendAgentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                /**
                 * This is the logic which takes care of sending a form to an agent... it loads the agent based on the login
                 *
                 */
                Agent to_recv = new Agent();
                to_recv.setLogin(email.getText());
                Database db = Database.getDatabase();

                if(!db.dbSelect.checkIfUsedAgent(email.getText())){
                    Alert yikes = new Alert(Alert.AlertType.WARNING);
                    yikes.setContentText("User does not exist");
                    yikes.setHeaderText("Error");
                    yikes.show();
                } else {
                    to_recv.loadUser();
                    Thread mailThread = new  Thread( new Mailer(to_recv, message.getText()));
                    mailThread.start();
                    AttributeContainer.getInstance().currentForm.setWorkingOn(to_recv.getAgentID());
                    db.dbSelect.updateWorkingOn(AttributeContainer.getInstance().currentForm);
                    AttributeContainer.getInstance().currentForm = null;
                    AttributeContainer.getInstance().formQueue = ((Agent) AttributeContainer.getInstance().currentUser).getCurrentQueue();
                    goToPage("AgentHome.fxml");
                }
            }
        });
    }
}
