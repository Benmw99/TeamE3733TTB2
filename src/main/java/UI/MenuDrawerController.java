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
        Drawer.setSidePane(BoxSlider);
    //    Drawer.setPickOnBounds(false);
      //  BoxSlider.setPickOnBounds(false);
        HamburgerNextArrowBasicTransition transition = new HamburgerNextArrowBasicTransition(Hamburger);
        Pane.setMaxWidth(50);
        Drawer.setMaxWidth(50);
        BoxSlider.setMaxWidth(50);
        GoHomeSlider.setMaxWidth(50);
        SearchSlider.setMaxWidth(50);
        LogOutSlider.setMaxWidth(50);

        System.out.println(Pane.getMaxWidth());


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
                transition.setRate(transition.getRate() * -1);
                transition.play();
                if (Drawer.isOpened()) {
                    Pane.setMaxWidth(50);
                    Drawer.setMaxWidth(50);
                    BoxSlider.setMaxWidth(50);
                    SearchSlider.setMaxWidth(50);
                    GoHomeSlider.setMaxWidth(50);
                    LogOutSlider.setMaxWidth(50);
                    Pane.setPrefWidth(50);
                    Drawer.setPrefWidth(50);
                    BoxSlider.setPrefWidth(50);
                    SearchSlider.setPrefWidth(50);
                    GoHomeSlider.setPrefWidth(50);
                    LogOutSlider.setPrefWidth(50);
                    Pane.setMaxHeight(50);
                    Drawer.setMaxHeight(50);
                    Pane.setPrefHeight(50);
                    Drawer.setPrefHeight(50);
                    BoxSlider.setPrefHeight(50);
                    BoxSlider.setMaxHeight(50);
                    Drawer.close();
                    BoxSlider.toBack();
                    Drawer.toBack();
                    LogOutSlider.toBack();
                    GoHomeSlider.toBack();
                    SearchSlider.toBack();
                    Pane.setMaxWidth(50);
                    Drawer.setMaxWidth(50);
                    BoxSlider.setMaxWidth(50);
                } else {
                    Pane.setMaxWidth(300);
                    Drawer.setMaxWidth(300);
                    BoxSlider.setMaxWidth(300);
                    SearchSlider.setMaxWidth(300);
                    GoHomeSlider.setMaxWidth(300);
                    LogOutSlider.setMaxWidth(300);
                    Pane.setPrefWidth(300);
                    Drawer.setPrefWidth(300);
                    BoxSlider.setPrefWidth(300);
                    SearchSlider.setPrefWidth(300);
                    GoHomeSlider.setPrefWidth(300);
                    LogOutSlider.setPrefWidth(300);
                    Pane.setMaxHeight(760);
                    Drawer.setMaxHeight(760);
                    Pane.setPrefHeight(760);
                    Drawer.setPrefHeight(760);
                    BoxSlider.setPrefHeight(760);
                    BoxSlider.setMaxHeight(760);
                    BoxSlider.toFront();
                    Drawer.toFront();
                    Hamburger.toFront();
                    LogOutSlider.toFront();
                    GoHomeSlider.toFront();
                    SearchSlider.toFront();
                    Drawer.open();
                }

            }
        });
    }

    @FXML
    public void goBack() {
        AttributeContainer ac = AttributeContainer.getInstance();
        ac.backlog.pop();
        ac.current_page.goToPage((ac.backlog.pop()));
    }

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
        goToPage("HomeSearch.fxml");
    }

}
