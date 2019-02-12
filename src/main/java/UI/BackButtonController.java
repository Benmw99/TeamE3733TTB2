package UI;

import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class BackButtonController implements Initializable {

    @FXML
    JFXHamburger Hamburger;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(Hamburger);
        Hamburger.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transition.setRate(transition.getRate()*-1);
                transition.play();
      //          System.out.println("Got Here!!");
            }
        });
        Hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                AttributeContainer ac = AttributeContainer.getInstance();
                ac.backlog.pop();
                ac.current_page.goToPage((ac.backlog.pop()));
            }
        });
        Hamburger.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transition.setRate(transition.getRate()*-1);
                transition.play();
            }
        });
    }

}
