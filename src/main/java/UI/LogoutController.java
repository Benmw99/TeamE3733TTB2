package UI;

import javafx.fxml.FXML;

import java.awt.*;

public class LogoutController extends PageControllerUI {
    @FXML
    Button LogOutButton;

    @FXML
    void logOut(){
        AttributeContainer ac = AttributeContainer.getInstance();
        ac.wipeSession();
        goToPage("WelcomePage.fxml");
    }


    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {

    }
}
