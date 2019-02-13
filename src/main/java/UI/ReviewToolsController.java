package UI;

import DB.Database;
import Entities.Agent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ReviewToolsController extends PageControllerUI implements Initializable {

    @FXML
    public TextField email;
    @FXML
    public TextField message;
    @FXML
    public Button sendAgentButton;
    @FXML
    public TextField ttb_id;

    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sendAgentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Agent to_recv = new Agent();
                to_recv.loadUser();
                Database db = Database.getDatabase();
                AttributeContainer.getInstance().currentForm.setWorkingOn(to_recv.getAgentID());
                db.dbSelect.updateWorkingOn(AttributeContainer.getInstance().currentForm);
            }
        });
    }
}
