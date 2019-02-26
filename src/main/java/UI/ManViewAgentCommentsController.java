package UI;

import DB.Database;
import Entities.Agent;
import Entities.Mailer;
import SearchAlgo.AsciiPrinter;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.dnd.DragSourceDragEvent;
import java.io.IOException;
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

   public void receiveNewComments(ActionEvent event) throws IOException{
        agentComments.setValue(attributeContainer.currentForm.getApproval().getQualifications());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO need to figure out what to put in here
    }
}

