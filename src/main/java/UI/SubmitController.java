package UI;

import Entities.*;
import com.jfoenix.controls.*;
import javafx.fxml.FXML;

import java.util.ArrayList;
@Deprecated
public class SubmitController extends PageControllerUI {

    @FXML
    JFXTextField RepIDField;
    @FXML
    JFXTextField ProducerNumField;
    @FXML
    JFXComboBox<String> SourceComboBox;
    @FXML
    JFXTextField SerialYearField;
    @FXML
    JFXTextField SerialDigitsField;
    @FXML
    JFXComboBox<String> TypeComboBox;
    @FXML
    JFXTextField VintageYearField;
    @FXML
    JFXTextField PhField;
    @FXML
    JFXTextField AlcoholContentTextField;
    @FXML
    JFXTextField BrandField;
    @FXML
    JFXTextField FancifulField;
    @FXML
    JFXTextField Name8Field;
    @FXML
    JFXComboBox<String> State8ComboBox;
    @FXML
    JFXTextField Address8Field;
    @FXML
    JFXTextField City8Field;
    @FXML
    JFXTextField Zip8Field;
    @FXML
    JFXRadioButton SameAddressRadioButton;
    @FXML
    JFXTextField Name9Field;
    @FXML
    JFXComboBox<String> State9ComboBox;
    @FXML
    JFXTextField Address9Field;
    @FXML
    JFXTextField City9Field;
    @FXML
    JFXTextField Zip9Field;
    @FXML
    JFXTextField FormulaField;
    @FXML
    JFXTextField GrapeVarField;
    @FXML
    JFXTextField WineAppField;
    @FXML
    JFXTextField PhoneNumField;
    @FXML
    JFXTextField EmailField;
    @FXML
    JFXRadioButton CertRadioButton;
    @FXML
    JFXRadioButton ExemptionRadioButton;
    @FXML
    JFXComboBox<String> State15ComboBox;
    @FXML
    JFXRadioButton LiquorRadioButton;
    @FXML
    JFXTextField AmountField;
    @FXML
    JFXRadioButton ResubmitRadioButton;
    @FXML
    JFXTextField TTBIDField;
    @FXML
    JFXTextField AdditionalInfoField;
    @FXML
    JFXTextField TranslationField;
    @FXML
    JFXDatePicker AppDate;
    @FXML
    JFXTextField SignatureField;
    @FXML
    JFXButton SubmitButton;

    public JFXTextField getRepIDField() {
        return RepIDField;
    }

    public JFXTextField getProducerNumField() {
        return ProducerNumField;
    }

    public JFXComboBox<String> getSourceComboBox() {
        return SourceComboBox;
    }

    public JFXTextField getSerialYearField() {
        return SerialYearField;
    }

    public JFXTextField getSerialDigitsField() {
        return SerialDigitsField;
    }

    public JFXComboBox<String> getTypeComboBox() {
        return TypeComboBox;
    }

    public JFXTextField getVintageYearField() {
        return VintageYearField;
    }

    public JFXTextField getPhField() {
        return PhField;
    }

    public JFXTextField getAlcoholContentTextField() {
        return AlcoholContentTextField;
    }

    public JFXTextField getBrandField() {
        return BrandField;
    }

    public JFXTextField getFancifulField() {
        return FancifulField;
    }

    public JFXTextField getName8Field() {
        return Name8Field;
    }

    public JFXComboBox<String> getState8ComboBox() {
        return State8ComboBox;
    }

    public JFXTextField getAddress8Field() {
        return Address8Field;
    }

    public JFXTextField getCity8Field() {
        return City8Field;
    }

    public JFXTextField getZip8Field() {
        return Zip8Field;
    }

    public JFXRadioButton getSameAddressRadioButton() {
        return SameAddressRadioButton;
    }

    public JFXTextField getName9Field() {
        return Name9Field;
    }

    public JFXComboBox<String> getState9ComboBox() {
        return State9ComboBox;
    }

    public JFXTextField getAddress9Field() {
        return Address9Field;
    }

    public JFXTextField getCity9Field() {
        return City9Field;
    }

    public JFXTextField getZip9Field() {
        return Zip9Field;
    }

    public JFXTextField getFormulaField() {
        return FormulaField;
    }

    public JFXTextField getGrapeVarField() {
        return GrapeVarField;
    }

    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {

    }
}
