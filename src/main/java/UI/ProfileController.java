package UI;


import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class ProfileController {

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
    private JFXPasswordField OldPasswordField;

    @FXML
    private JFXPasswordField NewPasswordField1;

    @FXML
    private JFXPasswordField NewPasswordField2;

    @FXML
    private StackPane MenuStackPane;
}
