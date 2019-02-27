package UI;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;


import java.net.URL;
import java.util.ResourceBundle;

public class ManViewAgentCommentsController extends PageControllerUI implements Initializable {

    @FXML
    Text agentComments;


    ///////////////////////////////////////////////////
    ///////////       The Actual Code      ////////////
    ///////////////////////////////////////////////////

    @Override
    void onLoad() {
    }

    @Override
    protected void onLeave() {
    }

   public void receiveNewComments() {
        attributeContainer = AttributeContainer.getInstance();
        agentComments.setText(attributeContainer.currentForm.getApproval().getQualifications());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        receiveNewComments();
    }
}

