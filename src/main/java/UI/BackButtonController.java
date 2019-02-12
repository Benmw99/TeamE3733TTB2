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
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition();
        Hamburger.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transition.setRate(-1);
                Hamburger.setAnimation(transition);
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
    }

}
