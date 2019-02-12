package UI;

import Entities.Agent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class AgentViewFormController extends PageControllerUI {


    @FXML
    Button logoutButton;

    @FXML
    Button printButton;

    @FXML
    Button approveButton;

    @FXML
    Button rejectButton;

    @FXML
    Button homeButton;

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



    ///////////////////////////////////////////////////
    ///////////       The Actual Code      ////////////
    ///////////////////////////////////////////////////

    @Override
    void onLoad(){}

    @Override
    protected void onLeave(){}

    @FXML
    public void logOut(ActionEvent event) throws IOException {
        attributeContainer.wipeSession();
        goToPage("AgentLogin.fxml");
    }

    @FXML
    public void approveForm(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {

            //TODO: get qualifications from text field
            ((Agent) attributeContainer.currentUser).approveForm(attributeContainer.currentForm, "");
            attributeContainer.formQueue.remove(attributeContainer.currentForm);
            attributeContainer.currentForm = null;
        }
    }
    @FXML
    public void rejectForm(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {
            ((Agent) attributeContainer.currentUser).rejectForm(attributeContainer.currentForm);
            attributeContainer.formQueue.remove(attributeContainer.currentForm);
            attributeContainer.currentForm = null;
        }
    }

    @FXML
    public void print(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {
            System.out.println("lol nah");
        }
    }
    @FXML
    public void returnHome(ActionEvent event) throws IOException {
        goToPage("AgentHome.fxml");
    }

}
