package UI;

import Entities.Agent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class AgentViewFormController extends PageControllerUI implements IFormDisplay {

    @Override
    public void setFormDisplayHelper(FormDisplayHelper helper){}

    FormDisplayHelper formDisplayHelper = new FormDisplayHelper(this);


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

    @Override
    public Label getDisplay1Label() {
        return Display1Label;
    }

    @Override
    public Label getDisplay2Label() {
        return Display2Label;
    }

    @Override
    public Label getDisplay3Label() {
        return Display3Label;
    }

    @Override
    public Label getDisplayReview4Label1() {
        return DisplayReview4Label1;
    }

    @Override
    public Label getDisplay4Label2() {
        return Display4Label2;
    }

    @Override
    public Label getDisplay5Label1() {
        return Display5Label1;
    }

    @Override
    public Label getDisplay5Label2() {
        return Display5Label2;
    }

    @Override
    public Label getDisplay5Label3() {
        return Display5Label3;
    }

    @Override
    public Label getDisplay6Label() {
        return Display6Label;
    }

    @Override
    public Label getDisplay7Label() {
        return Display7Label;
    }

    @Override
    public Label getDisplay8Label() {
        return Display8Label;
    }

    @Override
    public Label getDisplay9Label() {
        return Display9Label;
    }

    @Override
    public Label getDisplay10Label() {
        return Display10Label;
    }

    @Override
    public Label getDisplay11Label() {
        return Display11Label;
    }

    @Override
    public Label getDisplay12Label() {
        return Display12Label;
    }

    @Override
    public Label getDisplay13Label() {
        return Display13Label;
    }

    @Override
    public Label getDisplay14Label() {
        return Display14Label;
    }

    @Override
    public Label getDisplay15Label1() {
        return Display15Label1;
    }

    @Override
    public Label getDisplay15Label2() {
        return Display15Label2;
    }

    @Override
    public Label getDisplay15Label3() {
        return Display15Label3;
    }

    @Override
    public Label getDisplay16Label1() {
        return Display16Label1;
    }

    @Override
    public Label getDisplay16Label2() {
        return Display16Label2;
    }

    @Override
    public Label getDisplay17Label() {
        return Display17Label;
    }

    @Override
    public Label getDisplay18Label() {
        return Display18Label;
    }

    @Override
    public Label getDisplay20Label() {
        return Display20Label;
    }


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
            formDisplayHelper.displayForm(attributeContainer.currentForm);
        }
    }
    @FXML
    public void rejectForm(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {
            ((Agent) attributeContainer.currentUser).rejectForm(attributeContainer.currentForm);
            attributeContainer.formQueue.remove(attributeContainer.currentForm);
            attributeContainer.currentForm = null;
            formDisplayHelper.displayForm(attributeContainer.currentForm);
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
