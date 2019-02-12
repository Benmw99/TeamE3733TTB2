package UI;

import Entities.Agent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController extends PageControllerUI {

    @FXML
    TextField LoginUserUsernameTextField;
    @FXML
    TextField LoginUserPasswordTextField;
    @FXML
    Button LoginUserLoginButton;


    TextField getLoginUserUsernameTextField() {
        return LoginUserPasswordTextField;
    }

    TextField getLoginUserPasswordTextField() {
        return LoginUserPasswordTextField;
    }

    Button getLoginUserLoginButton() {
        return LoginUserLoginButton;
    }


    public void enableButton(){
        getLoginUserLoginButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                authenticate();
                event.getTarget();
                goToPage("AgentHome.fxml");
            }
        });
    }

    public boolean authenticate(){
        String user = getLoginUserUsernameTextField().getText();
        AttributeContainer attributeContainer = AttributeContainer.getInstance();
        attributeContainer.currentUser = new Agent();
        return true; //TODO MAKE THIS REAL
    }

    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {
        AttributeContainer.getInstance().currentUser = null;
    }
}
