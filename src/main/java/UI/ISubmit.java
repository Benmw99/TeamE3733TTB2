package UI;

import com.jfoenix.controls.*;


public interface ISubmit extends IPage {

        void setSubmitHelper(SubmitHelper helper);

        JFXTextField getRepIDField();

        JFXTextField getProducerNumField();

        JFXComboBox<String> getSourceComboBox();

        JFXTextField getSerialYearField();

        JFXTextField getSerialDigitsField();

        JFXComboBox<String> getTypeComboBox();

        JFXTextField getVintageYearField();

        JFXTextField getPhField();

        JFXTextField getAlcoholContentTextField();

        JFXTextField getBrandField();

        JFXTextField getFancifulField();

        JFXTextField getName8Field();

        JFXComboBox<String> getState8ComboBox();

        JFXTextField getAddress8Field();

        JFXTextField getCity8Field();

        JFXTextField getZip8Field();

        JFXRadioButton getSameAddressRadioButton();

        JFXTextField getName9Field();

        JFXComboBox<String> getState9ComboBox();

        JFXTextField getAddress9Field();

        JFXTextField getCity9Field();

        JFXTextField getZip9Field();

        JFXTextField getFormulaField();

        JFXTextField getGrapeVarField();

        JFXTextField getWineAppField();

        JFXTextField getPhoneNumField();

        JFXTextField getEmailField();

        JFXRadioButton getCertRadioButton();

        JFXRadioButton getExemptionRadioButton();

        JFXComboBox<String> getState15ComboBox();

        JFXRadioButton getLiquorRadioButton();

        JFXTextField getAmountField();

        JFXRadioButton getResubmitRadioButton();

        JFXTextField getTTBIDField();

        JFXTextField getAdditionalInfoField();

        JFXTextField getTranslationField();

        JFXDatePicker getAppDate();

        JFXTextField getSignatureField();

        JFXButton getSubmitButton();

    void setSubmitHelper();

}