package UI;

import Entities.Agent;
import Entities.Manufacturer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class LoginController extends PageControllerUI {


    @FXML
    TextField LoginUserUsernameTextField;
    @FXML
    TextField LoginUserPasswordTextField;
    @FXML
    Button LoginUserLoginButton;
    @FXML
    RadioButton ManRadioButton;
    @FXML
    RadioButton AgentRadioButton;




    Button getLoginUserLoginButton() {
        return LoginUserLoginButton;
    }


    public void enableButton(){
        getLoginUserLoginButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                authenticate();
                event.getTarget();
                goToPage("AgentHome.fxml");
            }
        });
    }


    public void login(){
        if(authenticate()){
            if(ManRadioButton.isSelected()){
                goToPage("ManHome.fxml");
            }
            if(AgentRadioButton.isSelected()){
                goToPage("AgentHome.fxml");
            }
        }
    }

    public boolean authenticate(){
        String user = LoginUserUsernameTextField.getText();
        String pass = LoginUserPasswordTextField.getText();
        AttributeContainer attributeContainer = AttributeContainer.getInstance();
        if(ManRadioButton.isSelected() && !AgentRadioButton.isSelected()){
            attributeContainer.currentUser = new Manufacturer();
            attributeContainer.currentUser.setLogin(user);
            attributeContainer.currentUser.setPassword(pass);
            System.out.println(attributeContainer.currentUser.authenticate());
            return attributeContainer.currentUser.authenticate();
        }
        if(AgentRadioButton.isSelected() && !ManRadioButton.isSelected()){
            attributeContainer.currentUser = new Agent();
            attributeContainer.currentUser.setLogin(user);
            attributeContainer.currentUser.setPassword(pass);
            return attributeContainer.currentUser.authenticate();
        }
        if((!AgentRadioButton.isSelected() && !ManRadioButton.isSelected()) || (AgentRadioButton.isSelected() && ManRadioButton.isSelected())){
            System.out.println("select only one option");
        }
        return false;
    }

    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {
        AttributeContainer.getInstance().currentUser = null;
    }
}
