package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AgentLoginController extends PageControllerUI implements ILogin, Initializable {
    @FXML
    TextField LoginUserUsernameTextField;

    @FXML
    PasswordField LoginUserPasswordTextField;

    @FXML
    Button LoginUserLoginButton;

    LoginHelper loginHelper = new LoginHelper(this);

    @Override
    public void setLoginHelper(LoginHelper loginHelper) {
        this.loginHelper = loginHelper;
    }

    @Override
    public TextField getLoginUserUsernameTextField() {
        return LoginUserUsernameTextField;
    }

    @Override
    public PasswordField getLoginUserPasswordTextField() {
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
        setLoginHelper(new LoginHelper(this));
        attributeContainer.currentUser = null;
    }


    @FXML
    public void login(ActionEvent event) throws IOException {
        if(loginHelper.authenticate()){
            goToPage("AgentHome.fxml");
        }
        else {
            System.out.println("lol get wrecked scrub");
            //TODO: make popup warning
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.setLoginHelper(new LoginHelper(this));
        System.out.println(getLoginUserLoginButton().toString());
    }
}
