package UI;

import DB.Database;
import Entities.Agent;
import Entities.Mailer;
import Entities.Manufacturer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
//import Entities.Agent.*;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.Random;
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

   // Mailer mailer;


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
        attributeContainer = AttributeContainer.getInstance();
    }

    /**
     * @author Parker and Sierra
     * Checks to see which type of user is registering, then navigates to the correct page
     * Also checks if a user is already registered
     * @param event
     */
    @FXML
    public void handleTheThing(ActionEvent event) {

        attributeContainer.firstTimeRegister = true;
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
                    byte[] agentKey = new byte[8];
                    new Random().nextBytes(agentKey);
                    keyGeneration();
                    System.out.println(AttributeContainer.getInstance().generatedKey);
                    Thread mailThread = new Thread( new Mailer(RegisterUserEmailTextField.getText(), attributeContainer.generatedKey));
                    mailThread.start();
                    goToPage("Authenticate.fxml");
                }
                else{
                    Alert yikes = new Alert(Alert.AlertType.WARNING);
                    yikes.setContentText("User already exists");
                    yikes.setHeaderText("Error");
                    yikes.show();

                }
            } else {
                Alert yikes = new Alert(Alert.AlertType.WARNING);
                yikes.setContentText("Passwords do not match");
                yikes.setHeaderText("Error");
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
                        byte[] manKey = new byte[8];
                        new Random().nextBytes(manKey);
                        keyGeneration();
                        System.out.println(AttributeContainer.getInstance().generatedKey);
                    Thread mailThread = new Thread( new Mailer(RegisterUserEmailTextField.getText(), attributeContainer.generatedKey));
                    mailThread.start();
                        goToPage("Authenticate.fxml");
                }
                else{
                    Alert yikes = new Alert(Alert.AlertType.WARNING);
                    yikes.setContentText("User already exists");
                    yikes.setHeaderText("Error");
                    yikes.show();

                }
            } else {
                Alert yikes = new Alert(Alert.AlertType.WARNING);
                yikes.setContentText("Passwords do not match");
                yikes.setHeaderText("Error");
                yikes.show();
            }
        }
    }

    /**
     *  @author Sierra
     *  creates a random key using 8 lowercase letters
     */
    public void keyGeneration(){
        // uses lowercase alphabet
        int leftLimit = 97;
        int rightLimit = 122;
        int keyLength = 8;
        Random rand = new Random();
        StringBuilder buffer = new StringBuilder(keyLength);
        for (int i = 0; i < keyLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (rand.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        AttributeContainer.getInstance().generatedKey = buffer.toString();
    }

}
