package UI;

import Entities.Agent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LoginHelper {

    public LoginController controller;

    public LoginHelper(LoginController controller){
        this.controller = controller;
        controller.setLoginHelper(this);
    }


    public void enableButton(){
        controller.getLoginUserLoginButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                authenticate();
                event.getTarget();
                controller.goToPage("AgentHome.fxml");
            }
        });
    }

    /**
     *
     * @return
     */
    public boolean authenticate(){
        String user = controller.getLoginUserUsernameTextField().getText();
        AttributeContainer attributeContainer = AttributeContainer.getInstance();
        attributeContainer.currentUser = new Agent();
        return true; //TODO MAKE THIS REAL
    }
}
