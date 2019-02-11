package UI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterPageController extends PageControllerUI implements IRegister {

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
    public TextField getRegisterUserFirstNameTextField() {
        return RegisterUserFirstNameTextField;
    }

    @Override
    public TextField getRegisterUserLastNameTextField() {
        return RegisterUserLastNameTextField;
    }

    @Override
    public TextField getRegisterUserUsernameTextField() {
        return RegisterUserUsernameTextField;
    }

    @Override
    public TextField getRegisterUserEmailTextField() {
        return RegisterUserEmailTextField;
    }

    @Override
    public TextField getRegisterUserPasswordTextField() {
        return RegisterUserPasswordTextField;
    }

    @Override
    public TextField getRegisterUserPasswordCheckTextField() {
        return RegisterUserPasswordCheckTextField;
    }

    @Override
    public Button getSubmitRegistrationButton() {
        return SubmitRegistrationButton;
    }

    protected void onLeave(){}

    void onLoad(){}

}
