package UI;

import Entities.FormExporter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;


public class ViewSelectedController extends PageControllerUI {

    @FXML
    Button backButton;

    @FXML
    Button printButton;




    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {

    }
    @FXML
    void goBack()   {
        AttributeContainer.getInstance().backlog.pop();
        goToPage(AttributeContainer.getInstance().backlog.pop());
    }

    public void print(ActionEvent actionEvent) {
        if(AttributeContainer.getInstance().currentForm != null){
            new FormExporter(AttributeContainer.getInstance().currentForm, "S");
            printButton.setText("Printed!");
        } else {
            Alert yikes = new Alert(Alert.AlertType.WARNING);
            yikes.setContentText("Please select a form!");
            yikes.setHeaderText("Invalid Form Selection");
            yikes.show();
        }
    }

    //TODO Make this a thing.
}
