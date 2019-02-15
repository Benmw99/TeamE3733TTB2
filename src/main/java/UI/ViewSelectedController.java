package UI;

import javafx.fxml.FXML;

public class ViewSelectedController extends PageControllerUI {
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
