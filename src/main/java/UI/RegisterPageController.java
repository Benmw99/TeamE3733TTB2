package UI;

import DB.Database;
import Entities.Agent;
import Entities.Manufacturer;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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


    protected void onLeave(){}

    void onLoad(){}

    /**
     * Sets up fields and buttons
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.SubmitRegistrationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO figure out what the logic will be to tell if this is a Agent or Manufacturer registration
                if (true) {
                    if (RegisterUserPasswordTextField.getText().equals(RegisterUserPasswordCheckTextField.getText())) {
                        Agent reg = new Agent();
                        reg.setLogin(RegisterUserUsernameTextField.getText());
                        reg.setName(RegisterUserFirstNameTextField.getText() + RegisterUserLastNameTextField.getText());
                        reg.setPassword(RegisterUserPasswordTextField.getText());
                        Database.getDatabase().dbInsert.insertAgent(reg);
                    } else {
                        //TODO Make a password / username do not match screen
                    }
                } else {
                    if (RegisterUserPasswordTextField.getText().equals(RegisterUserPasswordCheckTextField.getText())) {
                        Manufacturer reg = new Manufacturer();
                        reg.setLogin(RegisterUserUsernameTextField.getText());
                        reg.setManName(RegisterUserFirstNameTextField.getText() + RegisterUserLastNameTextField.getText());
                        reg.setPassword(RegisterUserPasswordTextField.getText());
                        Database.getDatabase().dbInsert.insertCompany(reg);
                    }
                }
            }
        });
    }
}
