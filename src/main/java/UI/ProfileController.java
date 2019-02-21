package UI;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController extends PageControllerUI implements Initializable {

    @FXML
    private Label NameLabel;

    @FXML
    private Label UsernameLabel;

    @FXML
    private Label EmailLabel;

    @FXML
    private JFXToggleButton FormPrefToggleButton;

    @FXML
    private JFXToggleButton EmailPrefToggleButton;

    @FXML
    private JFXToggleButton ChangePasswordToggleButton;

    @FXML
    private JFXButton ChangeButton;

    @FXML
    private JFXButton uploadButton;

    @FXML
    private JFXPasswordField OldPasswordField;

    @FXML
    private JFXPasswordField NewPasswordField1;

    @FXML
    private JFXPasswordField NewPasswordField2;

    @FXML
    private StackPane MenuStackPane;

    @FXML
    public void changePass() {
        //Yeet a new password into the DB

    }

    @FXML
    public void setProfile() {
        //Yeet a new password into the DB
    }

    @FXML
    public void observer() {
        //Yeet a new password into the DB
    }


    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
