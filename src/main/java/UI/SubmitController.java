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

    public JFXTextField getWineAppField() {
        return WineAppField;
    }

    public JFXTextField getPhoneNumField() {
        return PhoneNumField;
    }

    public JFXTextField getEmailField() {
        return EmailField;
    }

    public JFXRadioButton getCertRadioButton() {
        return CertRadioButton;
    }

    public JFXRadioButton getExemptionRadioButton() {
        return ExemptionRadioButton;
    }

    public JFXComboBox<String> getState15ComboBox() {
        return State15ComboBox;
    }

    public JFXRadioButton getLiquorRadioButton() {
        return LiquorRadioButton;
    }

    public JFXTextField getAmountField() {
        return AmountField;
    }

    public JFXRadioButton getResubmitRadioButton() {
        return ResubmitRadioButton;
    }

    public JFXTextField getTTBIDField() {
        return TTBIDField;
    }

    public JFXTextField getAdditionalInfoField() {
        return AdditionalInfoField;
    }

    public JFXTextField getTranslationField() {
        return TranslationField;
    }

    public JFXDatePicker getAppDate() {
        return AppDate;
    }

    public JFXTextField getSignatureField() {
        return SignatureField;
    }

    public JFXButton getSubmitButton() {
        return SubmitButton;
    }


    /**
     * This is the method which gets a form from the associated controller and persists
     * it to the database. Pass it the manufacturer who is inserting the form. Later there might
     * be another option using no Manufacturer at all.
     * @param man The manufacturer performing the insert... We need to think about this?
     */
    void getForm(Manufacturer man){
        Form working = new Form();
        working.setBrandName(getBrandField().getText());
        working.setSerialNumber(getSerialYearField().getText()
                + getSerialDigitsField().getText());
        working.setPhoneNumber(getPhoneNumField().getText());
        working.setOtherInfo(getAdditionalInfoField().getText());
        working.setEmail(getEmailField().getText());
        working.setAlcoholContent(Float.parseFloat(getAlcoholContentTextField().getText()));
        working.setFancifulName(getFancifulField().getText());
        ArrayList<String> los = new ArrayList<String>();
        los.add(getProducerNumField().getText());
        working.setRepID(getRepIDField().getText());
        working.setFormula(getFormulaField().getText());
        if(getSourceComboBox().getValue().equals("Domestic")) {
            working.setSource(false);
        } else {
            working.setSource(true);
        }
        if(getTypeComboBox().getValue().equals("Malt Beverage")){
            working.setAlcoholType(AlcoholType.MaltBeverage);
        } else if(getTypeComboBox().getValue().equals("Wine")){
            working.setAlcoholType(AlcoholType.Wine);
            /* This part takes care of the Wine */
            WineFormItems wine = new  WineFormItems();
            wine.setVintageYear(Integer.valueOf(getVintageYearField().getText()));
            wine.setGrapeVarietal(getGrapeVarField().getText());
            wine.setpH(Float.valueOf(getPhField().getText()));
            wine.setAppellation(getWineAppField().getText());
            working.setWineFormItems(wine);
        } else {
            working.setAlcoholType(AlcoholType.DistilledLiquor);
        }
        /* Mailing Address */
        Address addy = new Address();
        addy.setCity(getCity8Field().getText());
        addy.setName(getName8Field().getText());
        addy.setState(getState8ComboBox().getValue());
        addy.setStreet(getAddress8Field().getText());
        addy.setZip(getZip8Field().getText());
        if(!getSameAddressRadioButton().isSelected()){
            /* Other Address */
            Address other = new Address();
            addy.setCity(getCity9Field().getText());
            addy.setName(getName9Field().getText());
            addy.setState(getState9ComboBox().getValue());
            addy.setStreet(getAddress9Field().getText());
            addy.setZip(getZip9Field().getText());
        }
        man.submitForm(working);

    }


    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {

    }
}