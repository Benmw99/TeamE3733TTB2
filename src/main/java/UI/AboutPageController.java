package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AboutPageController extends PageControllerUI {

    @FXML
    Button backButton;

    /**
     * Returns to previous page
     * @param event
     * @throws IOException
     */
    @FXML
    public void goBack(ActionEvent event) throws IOException {
        goToPage("HomeSearch.fxml");
    }

    @Override
    void onLoad(){}

    @Override
    protected void onLeave(){}
}
