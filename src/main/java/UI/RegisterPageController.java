package UI;

import DB.Database;
import Entities.Agent;
import Entities.Manufacturer;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
//import Entities.Agent.*;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterPageController extends PageControllerUI implements Initializable {

    @FXML
    TextField RegisterUserFirstNameTextField;

    @FXML
    TextField RegisterUserLastNameTextField;

    @FXML
    TextField RegisterUserUsernameTextField;

    @FXML
    TextField RegisterUserEmailTextField;

    @FXML
    TextField RegisterUserPasswordTextField;

    @FXML
    TextField RegisterUserPasswordCheckTextField;

    @FXML
    Button SubmitRegistrationButton;

    @FXML
    RadioButton ManufacturerRadio;

    @FXML
    RadioButton AgentRadio;

    ToggleGroup userOptions = new ToggleGroup();

    protected void onLeave(){}

    void onLoad(){
    }

    /**
     * Sets up fields and buttons
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ManufacturerRadio.setToggleGroup(userOptions);
        AgentRadio.setToggleGroup(userOptions);
        ManufacturerRadio.setSelected(true);
    }
    @FXML
    public void handleTheThing(ActionEvent event) {
        //TODO figure out what the logic will be to tell if this is a Agent or Manufacturer registration

        if (AgentRadio.isSelected()) {
            if (RegisterUserPasswordTextField.getText().equals(RegisterUserPasswordCheckTextField.getText())) {
                Agent reg = new Agent();
                reg.setLogin(RegisterUserUsernameTextField.getText());
                reg.setName(RegisterUserFirstNameTextField.getText() + RegisterUserLastNameTextField.getText());
                reg.setPassword(RegisterUserPasswordTextField.getText());
                if(null==Database.getDatabase().dbSelect.getAgent(reg.getLogin()))
                {
                    Database.getDatabase().dbInsert.insertAgent(reg);
                    attributeContainer.currentUser = reg;
                    goToPage("Login.fxml");
                }
                else{
                    Alert yikes = new Alert(Alert.AlertType.WARNING);
                    yikes.setContentText("User already exists");
                    yikes.setHeaderText("Oh Noes");
                    yikes.show();

                }
            } else {
                Alert yikes = new Alert(Alert.AlertType.WARNING);
                yikes.setContentText("Passwords do not match");
                yikes.setHeaderText("Oh Noes");
                yikes.show();
            }
        } else {
            if (RegisterUserPasswordTextField.getText().equals(RegisterUserPasswordCheckTextField.getText())) {
                Manufacturer reg = new Manufacturer();
                reg.setLogin(RegisterUserUsernameTextField.getText());
                reg.setManName(RegisterUserFirstNameTextField.getText() + RegisterUserLastNameTextField.getText());
                reg.setPassword(RegisterUserPasswordTextField.getText());

                if(null==Database.getDatabase().dbSelect.getManufacturer(reg.getLogin()))
                {
                    Database.getDatabase().dbInsert.insertCompany(reg);
                    attributeContainer.currentUser = reg;
                    if (null == Database.getDatabase().dbSelect.getManufacturer(reg.getLogin())) ;
                    goToPage("Login.fxml");
                }
                else{
                    Alert yikes = new Alert(Alert.AlertType.WARNING);
                    yikes.setContentText("User already exists");
                    yikes.setHeaderText("Oh Noes");
                    yikes.show();

                }
            } else {
                //TODO Make a password / username do not match screen
                Alert yikes = new Alert(Alert.AlertType.WARNING);
                yikes.setContentText("Passwords do not match");
                yikes.setHeaderText("Oh Noes");
                yikes.show();
            }
        }
    }
}
