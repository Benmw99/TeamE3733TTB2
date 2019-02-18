package UI;

import Entities.Form;
import Entities.Manufacturer;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.Initializable;
import Entities.Form;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class ManViewAgentCommentsController extends PageControllerUI  implements Initializable {

    @FXML
    JFXTextArea AgentQualifications;

    @FXML

    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AttributeContainer.getInstance().formQueue = ((Manufacturer)AttributeContainer.getInstance().currentUser).loadForms();
        for(Form f : AttributeContainer.getInstance().formQueue){
        }
    }

    public void displayAgentComments(ActionEvent event) throws IOException{
        // need to figure out how to pull the selected form's qualifications
    }


}
