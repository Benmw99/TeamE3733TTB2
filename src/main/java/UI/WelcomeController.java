package UI;

import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/*

To add new scene switch:

1. create the fxml
2. add controller to fxml
    fx:controller="UI.ManufactureController"
3. add fx:id to button
    fx:id="BacktoWelcome"
4. add button id to controller
5. copy and paste samplesceneswitch function
    change function name
6. change fxml file  and button
    button is the button from the current open scene
    fxml file is the scene you want to switch to
7. add onbutton clicked event to button, specify function you just created

*/

/*
###########################
List of fxml pages:

ManHome
ManSearch
ManFAQ
ManTTBForm1
ManTTBForm2
ManTTBForm3
ManProfile
ManLabelCompare


 */

public class WelcomeController extends PageControllerUI{

    //BackButtonController bb = new BackButtonController();

   // @FXML
   // JFXHamburger Hamburger;

    @FXML
    Button manButton;

    @FXML
    Button civilButton;

    @FXML
    Button agentButton;

    @FXML
    BackButtonController Hamburger;


    @FXML
    public void agentLogin(ActionEvent event) throws IOException{
//        pageSwitch(event, "AgentLogin.fxml", agentButton);
        pageSwitcher.pageSwitch("AgentLogin.fxml");
    }

    @FXML
    public void civilSearch(ActionEvent event) throws IOException{
//        pageSwitch(event, "HomeSearch.fxml", civilButton);
        pageSwitcher.pageSwitch("HomeSearch.fxml");
    }

    @FXML
    public void manufacturerLogin(ActionEvent event) throws IOException {
//        pageSwitch(event, "ManLogin.fxml", manButton);
        pageSwitcher.pageSwitch("ManLogin.fxml");
    }


//    public void pageSwitch(ActionEvent event, String filename, Button b) throws IOException{
//        Parent root;
//        Stage stage;
//        stage=(Stage) b.getScene().getWindow();
//        root = FXMLLoader.load(getClass().getResource(filename));
//        Scene scene = new Scene(root, 1360, 760);
//        stage.setScene(scene);
//        stage.show();
//    }


    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {

    }


    /*
    @FXML
   public void samplesceneswitch(ActionEvent event) throws IOException {
        pageSwitch(event, "filename", buttonName);
    }

    */

}
