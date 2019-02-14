package UI;

import Entities.Agent;
import Entities.IUser;
import Entities.Manufacturer;
import com.sun.xml.internal.ws.api.FeatureConstructor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import com.jfoenix.controls.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends PageControllerUI implements Initializable {


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

    MenuDrawerController menu;

    IUser newuser;




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

    /**
     * Logs user in
     */
    @FXML
    public void login(){
        if(authenticate()){
            if(ManRadioButton.isSelected()){
                AttributeContainer.getInstance().currentUser = newuser;
                AttributeContainer.getInstance().currentUser.loadUser();
                AttributeContainer.getInstance().formQueue = ((Manufacturer)AttributeContainer.getInstance().currentUser).loadForms();
                AttributeContainer.getInstance().currentForm = null;
                goToPage("ManHome.fxml");
            }
            if(AgentRadioButton.isSelected()){
                AttributeContainer.getInstance().currentUser = newuser;
                AttributeContainer.getInstance().currentUser.loadUser();
                goToPage("AgentHome.fxml");
               System.out.println(((Agent)AttributeContainer.getInstance().currentUser).getAgentID());
            }
        }
    }
    @FXML
    public void register(){
        AttributeContainer.getInstance().currentUser = null;
        goToPage("RegisterPage.fxml");
    }

    /**
     * Directs user to HomeSearch page
     */
    @FXML
    void search() {
        goToPage("HomeSearch.fxml");
    }

    /**
     * Authenticates user by name and password to login
     * @return
     */
    @FXML
    public boolean authenticate(){
        String user = LoginUserUsernameTextField.getText();
        String pass = LoginUserPasswordTextField.getText();

        if(ManRadioButton.isSelected()){
            newuser = new Manufacturer();
            newuser.setLogin(user);
            newuser.setPassword(pass);
            return newuser.authenticate();
        }
        if(AgentRadioButton.isSelected()){
            newuser = new Agent();
            newuser.setLogin(user);
            newuser.setPassword(pass);
            return newuser.authenticate();
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

    /**
     * Clears current user (logout in essence) and sets radio buttons correctly
     */
    @Override
    void onLoad() {
        AttributeContainer.getInstance().currentUser = null;
        ManRadioButton.setToggleGroup(userOptions);
        AgentRadioButton.setToggleGroup(userOptions);
        ManRadioButton.setSelected(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // menu.GoHomeSlider.setDisable(true);
       // menu.LogOutSlider.setDisable(true);


    }
}
