package UI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

@Deprecated
public class ViewSelectedController extends PageControllerUI {

    @FXML
    Button backButton;

    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {

    }
    @FXML
    void goBack()   {
        goToPage("HomeSearch.fxml");
    }

    //TODO Make this a thing.
}
