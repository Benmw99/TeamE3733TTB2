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

        ManufacturerRadio.setToggleGroup(userOptions);
        AgentRadio.setToggleGroup(userOptions);
        ManufacturerRadio.setSelected(true);
    }

    /**
     * Sets up fields and buttons
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        this.SubmitRegistrationButton.setOnAction(new EventHandler<ActionEvent>() {
//                                                      @Override
//                                                      public void handle(ActionEvent event) {
//                                                          //TODO figure out what the logic will be to tell if this is a Agent or Manufacturer registration
//                                                          if (AgentRadio.isSelected()) {
//                                                              if (RegisterUserPasswordTextField.getText().equals(RegisterUserPasswordCheckTextField.getText())) {
//                                                                  Agent reg = new Agent();
//                                                                  reg.setLogin(RegisterUserUsernameTextField.getText());
//                                                                  reg.setName(RegisterUserFirstNameTextField.getText() + RegisterUserLastNameTextField.getText());
//                                                                  reg.setPassword(RegisterUserPasswordTextField.getText());
//                                                                  Database.getDatabase().dbInsert.insertAgent(reg);
//                                                              } else {
//                                                                  //TODO Make a password / username do not match screen
//                                                                  Alert yikes = new Alert(Alert.AlertType.WARNING);
//                                                                  yikes.setContentText("Passwords do not match");
//                                                                  yikes.setHeaderText("Oh Noes");
//                                                              }
//                                                          } else {
//                                                              if (RegisterUserPasswordTextField.getText().equals(RegisterUserPasswordCheckTextField.getText())) {
//                                                                  Manufacturer reg = new Manufacturer();
//                                                                  reg.setLogin(RegisterUserUsernameTextField.getText());
//                                                                  reg.setManName(RegisterUserFirstNameTextField.getText() + RegisterUserLastNameTextField.getText());
//                                                                  reg.setPassword(RegisterUserPasswordTextField.getText());
//                                                                  Database.getDatabase().dbInsert.insertCompany(reg);
//                                                              } else {
//                                                                  //TODO Make a password / username do not match screen
//                                                                  Alert yikes = new Alert(Alert.AlertType.WARNING);
//                                                                  yikes.setContentText("Passwords do not match");
//                                                                  yikes.setHeaderText("Oh Noes");
//                                                              }
//                                                          }
//                                                      }
//                                                  });
//    void registerAgent()    {
//        Agent currentAgent = new Agent();
//        currentAgent.setLogin(RegisterUserUsernameTextField.getText());
//        currentAgent.setPassword(RegisterUserPasswordTextField.getText());
//        currentAgent.setName(RegisterUserFirstNameTextField.getText() +" "+ RegisterUserLastNameTextField.getText());
//        currentAgent.register();
//    }
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
                Database.getDatabase().dbInsert.insertAgent(reg);
                attributeContainer.currentUser = reg;
                goToPage("AgentHome.fxml");
            } else {
                //TODO Make a password / username do not match screen
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
                Database.getDatabase().dbInsert.insertCompany(reg);
                attributeContainer.currentUser = reg;
                goToPage("ManHome.fxml");
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
