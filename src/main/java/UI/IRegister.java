package UI;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public interface IRegister extends IPage{

    TextField getRegisterUserFirstNameTextField();

    TextField getRegisterUserLastNameTextField();

    TextField getRegisterUserUsernameTextField();

    TextField getRegisterUserEmailTextField();

    TextField getRegisterUserPasswordTextField();

    TextField getRegisterUserPasswordCheckTextField();

    Button getSubmitRegistrationButton();
}



