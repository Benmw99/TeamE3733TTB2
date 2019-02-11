package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ManLoginController extends PageControllerUI implements ILogin{

    @FXML
    TextField LoginUserUsernameTextField;
    @FXML
    TextField LoginUserPasswordTextField;
    @FXML
    Button LoginUserLoginButton;

    LoginHelper loginHelper;

    public void setLoginHelper(LoginHelper loginHelper){
        this.loginHelper = loginHelper;
    }

    @Override
    public TextField getLoginUserUsernameTextField() {
        return LoginUserUsernameTextField;
    }

    @Override
    public TextField getLoginUserPasswordTextField() {
        return LoginUserPasswordTextField;
    }

    @Override
    public Button getLoginUserLoginButton() {
        return LoginUserLoginButton;
    }

    @Override
    protected void onLeave(){}
    @Override
    void onLoad(){
        attributeContainer.currentUser = null;
    }

    @FXML
    public void login(ActionEvent event) throws IOException {
        if(loginHelper.authenticate()){
            goToPage("ManHome.fxml");
        }
        else {
            System.out.println("Uh this should be a popup dude, but you logged in wrong");
            //TODO: make popup warning
        }
    }
}
