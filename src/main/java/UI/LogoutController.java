package UI;

import javafx.fxml.FXML;

import java.awt.*;
@Deprecated
public class LogoutController extends PageControllerUI {
    @FXML
    Button LogOutButton;

    /**
     * Logs user out and directs to WelcomePage
     */
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
