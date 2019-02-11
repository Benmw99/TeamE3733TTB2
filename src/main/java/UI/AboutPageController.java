package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AboutPageController extends PageControllerUI {
    Button backButton;

    @FXML
    public void goBack(ActionEvent event) throws IOException {
        goToPage("WelcomePage.fxml");
    }

    @Override
    void onLoad(){}

    @Override
    protected void onLeave(){}
}
