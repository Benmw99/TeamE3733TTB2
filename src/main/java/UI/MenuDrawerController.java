package UI;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuDrawerController implements Initializable {

    @FXML
    JFXHamburger Hamburger;

    //@FXML
    //JFXDrawer Drawer;

    /**
     * Sets up menu drawer functionality
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Drawer.setSidePane( );
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(Hamburger);

        Hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("HeRE");
                transition.setRate(transition.getRate()*-1);
                transition.play();
                AttributeContainer ac = AttributeContainer.getInstance();
/*
                if(Drawer.isOpened()){
                    Drawer.close();
                }
                else{
                    Drawer.open();
                }
*/
                ac.backlog.pop();
                ac.current_page.goToPage((ac.backlog.pop()));
            }
        });
    }

}
