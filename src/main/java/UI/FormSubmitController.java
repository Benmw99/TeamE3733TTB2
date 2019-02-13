package UI;

import Entities.*;
import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class FormSubmitController {
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

    /**
     * This is the function the button uses to submit a form.
     */
    @FXML
        public void submitFormButton(){
        getForm((Manufacturer) AttributeContainer.getInstance().currentUser);
    }


        /**
         * This is the method which gets a form from the associated controller and persists
         * it to the database. Pass it the manufacturer who is inserting the form. Later there might
         * be another option using no Manufacturer at all.
         * @param man The manufacturer performing the insert... We need to think about this?
         */
        void getForm(Manufacturer man){
            Form working = new Form();
            working.setBrandName(this.BrandField.getText());
            working.setSerialNumber(this.SerialYearField.getText()
                    + this.SerialDigitsField.getText());
            working.setPhoneNumber(this.PhoneNumField.getText());
            working.setOtherInfo(this.AdditionalInfoField.getText());
            working.setEmail(this.EmailField.getText());
            working.setAlcoholContent(Float.parseFloat(this.AlcoholContentTextField.getText()));
            working.setFancifulName(this.FancifulField.getText());
            ArrayList<String> los = new ArrayList<String>();
            los.add(this.ProducerNumField.getText());
            working.setRepID(this.RepIDField.getText());
            working.setFormula(this.FormulaField.getText());
            if(this.SourceComboBox.getValue().equals("Domestic")) {
                working.setSource(false);
            } else {
                working.setSource(true);
            }
            if(this.TypeComboBox.getValue().equals("Malt Beverage")){
                working.setAlcoholType(AlcoholType.MaltBeverage);
            } else if(this.TypeComboBox.getValue().equals("Wine")){
                working.setAlcoholType(AlcoholType.Wine);
                /* This part takes care of the Wine */
                WineFormItems wine = new  WineFormItems();
                wine.setVintageYear(Integer.valueOf(this.VintageYearField.getText()));
                wine.setGrapeVarietal(this.GrapeVarField.getText());
                wine.setpH(Float.valueOf(this.PhField.getText()));
                wine.setAppellation(this.WineAppField.getText());
                working.setWineFormItems(wine);
            } else {
                working.setAlcoholType(AlcoholType.DistilledLiquor);
            }
            /* Mailing Address */
            Address addy = new Address();
            addy.setCity(this.City8Field.getText());
            addy.setName(this.Name8Field.getText());
            addy.setState(this.State8ComboBox.getValue());
            addy.setStreet(this.Address8Field.getText());
            addy.setZip(this.Zip8Field.getText());
            if(!this.SameAddressRadioButton.isSelected()){
                /* Other Address */
                Address other = new Address();
                addy.setCity(this.City9Field.getText());
                addy.setName(this.Name9Field.getText());
                addy.setState(this.State9ComboBox.getValue());
                addy.setStreet(this.Address9Field.getText());
                addy.setZip(this.Zip9Field.getText());
            }
            man.submitForm(working);
            AttributeContainer.getInstance().labelImage.setTTBID(working.getTtbID());
            AttributeContainer.getInstance().labelImage.insert();
        }


}
