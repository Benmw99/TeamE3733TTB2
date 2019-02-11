package UI;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public interface ILogin extends IPage {

    void setLoginHelper(LoginHelper helper);

    TextField getLoginUserUsernameTextField();

    TextField getLoginUserPasswordTextField();

    Button getLoginUserLoginButton();
}
