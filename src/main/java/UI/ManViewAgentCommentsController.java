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
import java.awt.dnd.DragSourceDragEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManViewAgentCommentsController extends PageControllerUI implements Initializable {

    @FXML
    JFXTextArea agentComments;

    ///////////////////////////////////////////////////
    ///////////       The Actual Code      ////////////
    ///////////////////////////////////////////////////

    @Override
    void onLoad() {
    }

    @Override
    protected void onLeave() {
    }

   public void receiveNewComments() throws IOException{
        // TODO figure out how pull in comments and display them
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO need to figure out what to put in here
    }
}
