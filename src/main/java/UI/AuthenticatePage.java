package UI;

import Entities.Mailer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class AuthenticatePage extends PageControllerUI implements Initializable {
    @FXML
    JFXTextField passcode;

    @FXML
    JFXButton authenticate;

    @FXML
    JFXButton resendEmailButton;

    @FXML
    JFXButton goBack;

    void onLoad(){}

    protected void onLeave(){}

    @Override
    public void initialize(URL location, ResourceBundle resources){}


    /**
     * @author Sierra
     * Checks through to see if the authentication key matches what was sent to the user
     * If the key is incorrect, it displays an error. Otherwise, it navigates you to the correct
     * page
     * @param event
     */
    public void authenticatePass(ActionEvent event) {
        // Manufacturer help = new Manufacturer();
        //  Agent stuck = new Agent();
        System.out.println(AttributeContainer.getInstance().generatedKey);
        System.out.println(passcode.getText());
        if(attributeContainer.currentUser.isManufacturer()){
            if (passcode.getText().equals(AttributeContainer.getInstance().generatedKey)) {
                attributeContainer.firstTimeRegister = false;
                goToPage("ManHome.fxml");
            } else {
                Alert yikes = new Alert(Alert.AlertType.WARNING);
                yikes.setContentText("You have not entered the correct authentication key. Please try again.");
                yikes.setHeaderText("Error");
                yikes.show();
            }
        } else if(attributeContainer.currentUser.isAgent()) {
            if (passcode.getText().equals(AttributeContainer.getInstance().generatedKey)) {
                attributeContainer.firstTimeRegister = false;
                goToPage("AgentHome.fxml");
            } else {
                Alert yikes = new Alert(Alert.AlertType.WARNING);
                yikes.setContentText("You have not entered the correct authentication key. Please try again.");
                yikes.setHeaderText("Error");
                yikes.show();
            }
        }  else {
            Alert yikes = new Alert(Alert.AlertType.WARNING);
            yikes.setContentText("You have not registered correctly. Please go back and do so.");
            yikes.setHeaderText("Error");
            yikes.show();
        }
    }


    public void returnToRegistration(ActionEvent event){
        goToPage("RegisterPage.fxml");
    }

    public void resendEmail(ActionEvent event){
        Thread mailThread = new Thread( new Mailer(attributeContainer.currentUser.getEmail(), attributeContainer.generatedKey));
        mailThread.start();
    }
}
