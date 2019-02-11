package UI;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class AgentAppController extends PageControllerUI implements ISubmit {
    //TODO: copy from manAppController
    //TODO: add AgentApp.fxml

    SubmitHelper submitHelper;

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

    public void setSubmitHelper(SubmitHelper helper) {
    }

    public JFXButton getPage1() {
        return page1;
    }

    public JFXButton getPage2() {
        return page2;
    }

    public JFXButton getPage3() {
        return page3;
    }

    public JFXButton getPage4() {
        return page4;
    }

    public Pane getPane1() {
        return pane1;
    }

    @Override
    public JFXTextField getRepIDField() {
        return RepIDField;
    }

    @Override
    public JFXTextField getProducerNumField() {
        return ProducerNumField;
    }

    @Override
    public JFXComboBox<String> getSourceComboBox() {
        return SourceComboBox;
    }

    @Override
    public JFXTextField getSerialYearField() {
        return SerialYearField;
    }

    @Override
    public JFXTextField getSerialDigitsField() {
        return SerialDigitsField;
    }

    @Override
    public JFXComboBox<String> getTypeComboBox() {
        return TypeComboBox;
    }

    @Override
    public JFXTextField getVintageYearField() {
        return VintageYearField;
    }

    @Override
    public JFXTextField getPhField() {
        return PhField;
    }

    @Override
    public JFXTextField getBrandField() {
        return BrandField;
    }

    public Pane getPane2() {
        return pane2;
    }

    @Override
    public JFXTextField getFancifulField() {
        return FancifulField;
    }

    @Override
    public JFXTextField getName8Field() {
        return Name8Field;
    }

    @Override
    public JFXComboBox<String> getState8ComboBox() {
        return State8ComboBox;
    }

    @Override
    public JFXTextField getAddress8Field() {
        return Address8Field;
    }

    @Override
    public JFXTextField getCity8Field() {
        return City8Field;
    }

    @Override
    public JFXTextField getZip8Field() {
        return Zip8Field;
    }

    @Override
    public JFXRadioButton getSameAddressRadioButton() {
        return SameAddressRadioButton;
    }

    @Override
    public JFXTextField getName9Field() {
        return Name9Field;
    }

    @Override
    public JFXComboBox<String> getState9ComboBox() {
        return State9ComboBox;
    }

    @Override
    public JFXTextField getAddress9Field() {
        return Address9Field;
    }

    @Override
    public JFXTextField getCity9Field() {
        return City9Field;
    }

    @Override
    public JFXTextField getZip9Field() {
        return Zip9Field;
    }

    @Override
    public JFXTextField getFormulaField() {
        return FormulaField;
    }

    @Override
    public JFXTextField getGrapeVarField() {
        return GrapeVarField;
    }

    @Override
    public JFXTextField getWineAppField() {
        return WineAppField;
    }

    public Pane getPane3() {
        return pane3;
    }

    @Override
    public JFXTextField getPhoneNumField() {
        return PhoneNumField;
    }

    @Override
    public JFXTextField getEmailField() {
        return EmailField;
    }

    @Override
    public JFXRadioButton getLiquorRadioButton() {
        return LiquorRadioButton;
    }

    @Override
    public JFXRadioButton getCertRadioButton() {
        return CertRadioButton;
    }

    @Override
    public JFXTextField getAmountField() {
        return AmountField;
    }

    @Override
    public JFXRadioButton getExemptionRadioButton() {
        return ExemptionRadioButton;
    }

    @Override
    public JFXComboBox<String> getState15ComboBox() {
        return State15ComboBox;
    }

    @Override
    public JFXRadioButton getResubmitRadioButton() {
        return ResubmitRadioButton;
    }

    @Override
    public JFXTextField getTTBIDField() {
        return TTBIDField;
    }

    @Override
    public JFXTextField getAdditionalInfoField() {
        return AdditionalInfoField;
    }

    @Override
    public JFXTextField getTranslationField() {
        return TranslationField;
    }

    @Override
    public JFXDatePicker getAppDate() {
        return AppDate;
    }

    public Pane getPane4() {
        return pane4;
    }

    @Override
    public JFXTextField getSignatureField() {
        return SignatureField;
    }

    @Override
    public JFXButton getSubmitButton() {
        return SubmitButton;
    }

    @Override
    public void setSubmitHelper() {
    }

    @Override
    public JFXTextField getAlcoholContentTextField() {
        return AlcoholContentTextField;
    }

    public static boolean errorInForm = false;

}
