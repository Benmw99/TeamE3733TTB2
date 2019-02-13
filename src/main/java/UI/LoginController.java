package UI;

import Entities.Agent;
import Entities.Manufacturer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import com.jfoenix.controls.*;

public class LoginController extends PageControllerUI {


    @FXML
    JFXTextField LoginUserUsernameTextField;

    @FXML
    JFXPasswordField LoginUserPasswordTextField;

    @FXML
    JFXButton LoginUserLoginButton;

    @FXML
    JFXButton searchbutton;

    @FXML
    JFXRadioButton ManRadioButton;

    @FXML
    JFXRadioButton AgentRadioButton;

    ToggleGroup userOptions = new ToggleGroup();


    @FXML
    MenuDrawerController Hamburger;


//    Button getLoginUserLoginButton() {
//        return LoginUserLoginButton;
//    }
//
//
//    public void enableButton(){
//        getLoginUserLoginButton().setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                authenticate();
//                event.getTarget();
//                goToPage("AgentHome.fxml");
//            }
//        });
//    }

    @FXML
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

    @FXML
    void search() {
        goToPage("HomeSearch.fxml");
    }

    @FXML
    public boolean authenticate(){
        System.out.println("TESTESTESTESTES");
        String user = LoginUserUsernameTextField.getText();
        String pass = LoginUserPasswordTextField.getText();
        AttributeContainer attributeContainer = AttributeContainer.getInstance();
        if(ManRadioButton.isSelected()){
            attributeContainer.currentUser = new Manufacturer();
            attributeContainer.currentUser.setLogin(user);
            attributeContainer.currentUser.setPassword(pass);
            return attributeContainer.currentUser.authenticate();
        }
        if(AgentRadioButton.isSelected()){
            attributeContainer.currentUser = new Agent();
            attributeContainer.currentUser.setLogin(user);
            attributeContainer.currentUser.setPassword(pass);
            return attributeContainer.currentUser.authenticate();
        }
//        String user = LoginUserUsernameTextField.getText();
//        String pass = LoginUserPasswordTextField.getText();
//        AttributeContainer attributeContainer = AttributeContainer.getInstance();
//        if(ManRadioButton.isSelected() && !AgentRadioButton.isSelected()){
//            attributeContainer.currentUser = new Manufacturer();
//            attributeContainer.currentUser.setLogin(user);
//            attributeContainer.currentUser.setPassword(pass);
//            System.out.println(attributeContainer.currentUser.authenticate());
//            return attributeContainer.currentUser.authenticate();
//        }
//        if(AgentRadioButton.isSelected() && !ManRadioButton.isSelected()){
//            attributeContainer.currentUser = new Agent();
//            attributeContainer.currentUser.setLogin(user);
//            attributeContainer.currentUser.setPassword(pass);
//            return attributeContainer.currentUser.authenticate();
//        }
//        if((!AgentRadioButton.isSelected() && !ManRadioButton.isSelected()) || (AgentRadioButton.isSelected() && ManRadioButton.isSelected())){
//            System.out.println("select only one option");
//        }
        return false;
    }

    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {
        AttributeContainer.getInstance().currentUser = null;
        ManRadioButton.setToggleGroup(userOptions);
        AgentRadioButton.setToggleGroup(userOptions);
        ManRadioButton.setSelected(true);
    }
}
