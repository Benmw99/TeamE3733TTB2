package UI;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXToggleButton;
import com.sun.xml.internal.ws.api.pipe.PipelineAssembler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.net.PasswordAuthentication;
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
    private JFXButton ChangePass;

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
    private Pane PasswordPane;

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
        NameLabel.setText(attributeContainer.currentUser.getName());
        UsernameLabel.setText(attributeContainer.currentUser.getLogin());
        EmailLabel.setText(attributeContainer.currentUser.getEmail());

        PasswordPane.setPickOnBounds(false);
        PasswordPane.setOpacity(1);
        ChangePasswordToggleButton.setSelected(false);


    }

    @FXML
    public void changePasswordToggle(){

        if(ChangePasswordToggleButton.isSelected()){
            PasswordPane.setOpacity(0);
        }
        else
            PasswordPane.setOpacity(1);
    }
}
