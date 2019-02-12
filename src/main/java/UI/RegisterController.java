package UI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterController  extends PageControllerUI{

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

    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {

    }

    @FXML
    void register(){
        //void
    }

}
