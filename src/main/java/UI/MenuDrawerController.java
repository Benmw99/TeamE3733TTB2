package UI;

import Entities.Form;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        if(ac.currentUser.isAgent()){

            goToPage("AgentSearch.fxml");
        }
        if(ac.currentUser.isManufacturer()){
            goToPage("ManSearch.fxml");
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
        AttributeContainer.getInstance().currentForm = null;
        AttributeContainer.getInstance().formQueue = new ArrayList<Form>();
        AttributeContainer.getInstance().currentUser = null;
        goToPage("HomeSearch.fxml");
    }

}
