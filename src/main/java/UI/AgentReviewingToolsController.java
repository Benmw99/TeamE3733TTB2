package UI;

import DB.Database;
import Entities.Agent;
import Entities.Mailer;
import SearchAlgo.AsciiPrinter;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AgentReviewingToolsController extends PageControllerUI implements Initializable {

    @FXML
    Pane largePane;

    @FXML
    Pane smallPane;

    @FXML
    JFXComboBox<String> markAsComboBox;

    @FXML
    JFXToggleButton helpToggleButton;

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

    ///////////////////////////////////////////////////
    ///////////       The Actual Code      ////////////
    ///////////////////////////////////////////////////

    @Override
    void onLoad() {
    }

    @Override
    protected void onLeave() {
    }

    //New controller overrides
    @FXML
    public void logOut(ActionEvent event) throws IOException {
        attributeContainer.wipeSession();
        goToPage("AgentLogin.fxml");
    }

    /**
     * Set approval status of current form to approved
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void approveForm(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {

            //TODO: get qualifications from text field
            ((Agent) attributeContainer.currentUser).approveForm(attributeContainer.currentForm, "");
            attributeContainer.formQueue.remove(attributeContainer.currentForm);
            attributeContainer.currentForm = null;
        }
    }

    /**
     * Set approval status of current form to rejected
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void rejectForm(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {
            ((Agent) attributeContainer.currentUser).rejectForm(attributeContainer.currentForm);
            attributeContainer.formQueue.remove(attributeContainer.currentForm);
            attributeContainer.currentForm = null;
        }
    }

    /**
     * Sends current form to printable format
     *
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
     *
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
        if (markAsComboBox.getValue() == "Complete") {

        } else if (markAsComboBox.getValue().equals("Incomplete")) {

        } else {

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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

                if (!db.dbSelect.checkIfUsedAgent(email.getText())) {
                    Alert yikes = new Alert(Alert.AlertType.WARNING);
                    yikes.setContentText("User does not exist");
                    yikes.setHeaderText("Error");
                    yikes.show();
                } else {
                    to_recv.loadUser();
                    Mailer mail = new Mailer();
                    mail.sendAgentMail(to_recv, message.getText());
                    AttributeContainer.getInstance().currentForm.setWorkingOn(to_recv.getAgentID());
                    db.dbSelect.updateWorkingOn(AttributeContainer.getInstance().currentForm);
                    AttributeContainer.getInstance().currentForm = null;
                    AttributeContainer.getInstance().formQueue = ((Agent) AttributeContainer.getInstance().currentUser).getCurrentQueue();
                    goToPage("AgentHome.fxml");
                }
            }
        });

        /**The different combo box options
         *
         */
        //    markAsComboBox.getItems().addAll("Complete, Incomplete, Incorrect");

        helpToggleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(helpToggleButton.isSelected()){
                    largePane.setOpacity(0);
                    smallPane.setOpacity(0);
                }
                else{
                    largePane.setOpacity(15);
                    smallPane.setOpacity(100);
                }
            }
        });
    }
}

