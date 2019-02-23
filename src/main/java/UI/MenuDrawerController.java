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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class MenuDrawerController extends PageControllerUI implements Initializable {
    @FXML
    public AnchorPane Pane;

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

    @FXML
    JFXButton ProfileSlider;


    @Override
    protected void onLeave() {
    }

    @Override
    void onLoad() {
    }

    /**
     * Sets up menu drawer functionality
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boolean isSignedIn;
        Drawer.setSidePane(BoxSlider);
        HamburgerNextArrowBasicTransition transition = new HamburgerNextArrowBasicTransition(Hamburger);
        transition.setRate(transition.getRate()*-1);
        transition.play();
        if(attributeContainer.currentUser != null){
            isSignedIn = true;
        }
        else{
            isSignedIn = false;
        }

        Hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                transition.setRate(transition.getRate()*-1);
                transition.play();
                if (Drawer.isOpened()) {
                    Drawer.close();
                    Pane.setMaxSize(50, 50);
                    Drawer.setMaxSize(0, 0);
                    BoxSlider.setMaxSize(0, 0);
                    SearchSlider.setMaxSize(0, 0);
                    GoHomeSlider.setMaxSize(0, 0);
                    LogOutSlider.setMaxSize(0, 0);

                    Pane.setPrefSize(50, 50);
                    Drawer.setPrefSize(0,0);
                    BoxSlider.setPrefSize(0,0);
                    SearchSlider.setPrefSize(0, 0);
                    GoHomeSlider.setPrefSize(0, 0);
                    LogOutSlider.setPrefSize(0, 0);

                    if(isSignedIn){
                        ProfileSlider.setMaxSize(0,0);
                        ProfileSlider.setPrefSize(0,0);
                    }
                } else {
                    Pane.setMaxSize(300, 760);
                    Drawer.setMaxSize(300, 760);
                    BoxSlider. setMaxSize(300, 760);
                    SearchSlider.setMaxSize(300, 70);
                    GoHomeSlider.setMaxSize(300, 70);
                    LogOutSlider.setMaxSize(300, 70);

                    Pane.setPrefSize(300, 760);
                    Drawer.setPrefSize(300, 760);
                    BoxSlider.setPrefSize(300, 760);
                    SearchSlider.setPrefSize(300, 70);
                    GoHomeSlider.setPrefSize(300, 70);
                    LogOutSlider.setPrefSize(300,70);

                    if(isSignedIn){
                        ProfileSlider.setMaxSize(300,70);
                        ProfileSlider.setPrefSize(300,70);
                    }
                    Drawer.open();
                }
            }
        });
    }

//    @FXML
//    public void goBack() {
//        AttributeContainer ac = AttributeContainer.getInstance();
//        ac.backlog.pop();
//        ac.current_page.goToPage((ac.backlog.pop()));
//    }

    @FXML
    public void goToSearch() {
        AttributeContainer ac = AttributeContainer.getInstance();
        if (ac.currentUser == null) {

            ac.currentForm = null;
            ac.formQueue = new ArrayList<Entities.Form>();
            goToPage("HomeSearch.fxml");
        } else {
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
    public void goToHome() {
        AttributeContainer ac = AttributeContainer.getInstance();
        if (ac.currentUser == null) {
            ac.currentForm = null;
            ac.formQueue = new ArrayList<Entities.Form>();
            goToPage("HomeSearch.fxml");
        } else {
            if (ac.currentUser.isAgent()) {
                goToPage("AgentHome.fxml");
            }
            if (ac.currentUser.isManufacturer()) {
                goToPage("ManHome.fxml");
            }
        }
    }



    @FXML
    public void goToLogOut(){
        AttributeContainer.getInstance().currentForm = null;
        AttributeContainer.getInstance().formQueue = new ArrayList<Form>();
        AttributeContainer.getInstance().currentUser = null;
//        goToPage("HomeSearch.fxml");
        goToPage("Login.fxml"); // goes to login now instead of search
    }

    @FXML
    public void goToProfile(){
        goToPage("Profile.fxml");
    }

}
