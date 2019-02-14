package UI;

import Entities.Form;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class MenuDrawerController extends PageControllerUI implements Initializable {

    @FXML
    JFXHamburger Hamburger;

    @FXML
    JFXDrawer Drawer;

    @FXML
    JFXButton SearchSlider;

    @FXML
    JFXButton GoHomeSlider;

    @FXML
    JFXButton LogOutSlider;

    @FXML
    VBox BoxSlider;


    @Override
    protected void onLeave() {}

    @Override
    void onLoad() {}


    /**
     * Sets up menu drawer functionality
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Drawer.setSidePane(BoxSlider);
        HamburgerNextArrowBasicTransition transition = new HamburgerNextArrowBasicTransition(Hamburger);

        /*for(Node node: BoxSlider.getChildren()){
            if(node.getAccessibleText() != null){
                node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                    switch (node.getAccessibleText()){
                        case "SEARCH":
                    }
                });
            }
        }*/

        Hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                BoxSlider.toFront();
                Drawer.toFront();
                Hamburger.toFront();
                LogOutSlider.toFront();
                GoHomeSlider.toFront();
                SearchSlider.toFront();

                transition.setRate(transition.getRate()*-1);
                transition.play();
                if(Drawer.isOpened()){
                    Drawer.close();
                    BoxSlider.toBack();
                    Drawer.toBack();
                    LogOutSlider.toBack();
                    GoHomeSlider.toBack();
                    SearchSlider.toBack();
                }
                else{
                    Drawer.open();
                }

            }
        });
    }

    @FXML
    public void goBack(){
        AttributeContainer ac = AttributeContainer.getInstance();
        ac.backlog.pop();
        ac.current_page.goToPage((ac.backlog.pop()));
    }

    @FXML
    public void goToSearch(){
        AttributeContainer ac = AttributeContainer.getInstance();
        if(ac.currentUser == null){

            ac.currentForm = null;
            ac.formQueue = new ArrayList<Entities.Form>();
            goToPage("HomeSearch.fxml");
        }
        else {
            if (ac.currentUser.isAgent()) {
                ac.currentForm = null;
                ac.formQueue = new ArrayList<Entities.Form>();
                goToPage("HomeSearch.fxml");
            }
            if (ac.currentUser.isManufacturer()) {
                ac.currentForm = null;
                ac.formQueue = new ArrayList<Entities.Form>();
                goToPage("HomeSearch.fxml");
            }
        }
    }


    @FXML
    public void goToHome(){
        AttributeContainer ac = AttributeContainer.getInstance();
        if(ac.currentUser.isAgent()){
            goToPage("AgentHome.fxml");
        }
        if(ac.currentUser.isManufacturer()){
            goToPage("ManHome.fxml");
        }

    }

    @FXML
    public void goToLogOut(){
        AttributeContainer.getInstance().wipeSession();
        goToPage("HomeSearch.fxml");
    }

}
