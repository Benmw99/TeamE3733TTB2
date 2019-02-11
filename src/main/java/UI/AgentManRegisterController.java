package UI;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AgentManRegisterController extends PageControllerUI implements IRegister {

    TextField RegisterUserFirstNameTextField;

    TextField RegisterUserLastNameTextField;

    TextField RegisterUserUsernameTextField;

    TextField RegisterUserEmailTextField;

    TextField RegisterUserPasswordTextField;

    TextField RegisterUserPasswordCheckTextField;

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

    void onLoad(){}

    protected void onLeave(){}
}
