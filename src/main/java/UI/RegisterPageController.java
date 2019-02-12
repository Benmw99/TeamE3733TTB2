package UI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterPageController extends PageControllerUI {

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

}
