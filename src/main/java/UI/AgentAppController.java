package UI;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class AgentAppController extends PageControllerUI {
    //TODO: copy from manAppController
    //TODO: add AgentApp.fxml


    @FXML
    private JFXButton page1;

    @FXML
    private JFXButton page2;

    @FXML
    private JFXButton page3;

    @FXML
    private JFXButton page4;

    @FXML
    private Pane pane1;

    @FXML
    private HBox GrapeVarHBox;

    @FXML
    private HBox WineAppHBox;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private Pane pane4;

    // Below are OG fx:id's

    @FXML
    private JFXTextField RepIDField;

    @FXML
    private JFXTextField ProducerNumField;

    @FXML
    private JFXComboBox<String> SourceComboBox;

    @FXML
    private JFXTextField SerialYearField;

    @FXML
    private JFXTextField SerialDigitsField;

    @FXML
    private JFXComboBox<String> TypeComboBox;

    @FXML
    private JFXTextField VintageYearField;

    @FXML
    private JFXTextField PhField;

    @FXML
    private JFXTextField BrandField;

    @FXML
    private JFXTextField FancifulField;

    @FXML
    private JFXTextField Name8Field;

    @FXML
    private JFXComboBox<String> State8ComboBox;

    @FXML
    private JFXTextField Address8Field;

    @FXML
    private JFXTextField City8Field;

    @FXML
    private JFXTextField Zip8Field;

    @FXML
    private JFXRadioButton SameAddressRadioButton;

    @FXML
    private JFXTextField Name9Field;

    @FXML
    private JFXComboBox<String> State9ComboBox;

    @FXML
    private JFXTextField Address9Field;

    @FXML
    private JFXTextField City9Field;

    @FXML
    private JFXTextField Zip9Field;

    @FXML
    private JFXTextField FormulaField;

    @FXML
    private JFXTextField GrapeVarField;

    @FXML
    private JFXTextField WineAppField;

    @FXML
    private JFXTextField PhoneNumField;

    @FXML
    private JFXTextField EmailField;

    @FXML
    private JFXRadioButton LiquorRadioButton;

    @FXML
    private JFXRadioButton CertRadioButton;

    @FXML
    private JFXTextField AmountField;

    @FXML
    private JFXRadioButton ExemptionRadioButton;

    @FXML
    private JFXComboBox<String> State15ComboBox;

    @FXML
    private JFXRadioButton ResubmitRadioButton;

    @FXML
    private JFXTextField TTBIDField;

    @FXML
    private JFXTextField AdditionalInfoField;

    @FXML
    private JFXTextField TranslationField;

    @FXML
    private JFXDatePicker AppDate;

    @FXML
    private JFXTextField SignatureField;

    @FXML
    private JFXButton SubmitButton;

    @FXML
    private JFXTextField AlcoholContentTextField;

    void onLoad() {
    }

    protected void onLeave() {
    }





    public static boolean errorInForm = false;

}
