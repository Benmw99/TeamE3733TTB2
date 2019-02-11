package UI;

import Entities.*;

import java.util.ArrayList;

public class SubmitHelper {

    ISubmit controller;
    public SubmitHelper(ISubmit controller){
        controller.setSubmitHelper(this);
        this.controller = controller;
    }

    /**
     * This is the method which gets a form from the associated controller and persists
     * it to the database. Pass it the manufacturer who is inserting the form. Later there might
     * be another option using no Manufacturer at all.
     * @param man The manufacturer performing the insert... We need to think about this?
     */
    void getForm(Manufacturer man){
        Form working = new Form();
        working.setBrandName(controller.getBrandField().getText());
        working.setSerialNumber(controller.getSerialYearField().getText()
                + controller.getSerialDigitsField().getText());
        working.setPhoneNumber(controller.getPhoneNumField().getText());
        working.setBlownBrandedEmbossedInfo(controller.getAdditionalInfoField().getText());
        working.setEmail(controller.getEmailField().getText());
        working.setAlcoholContent(Float.parseFloat(controller.getAlcoholContentTextField().getText()));
        working.setFancifulName(controller.getFancifulField().getText());
        ArrayList<String> los = new ArrayList<String>();
        los.add(controller.getProducerNumField().getText());
        working.setRepID(controller.getRepIDField().getText());
        working.setFormula(controller.getFormulaField().getText());
        if(controller.getSourceComboBox().getValue().equals("Domestic")) {
            working.setSource(false);
        } else {
            working.setSource(true);
        }
        if(controller.getTypeComboBox().getValue().equals("Malt Beverage")){
            working.setAlcoholType(AlcoholType.MaltBeverage);
        } else if(controller.getTypeComboBox().getValue().equals("Wine")){
            working.setAlcoholType(AlcoholType.Wine);
            /* This part takes care of the Wine */
            WineFormItems wine = new  WineFormItems();
            wine.setVintageYear(Integer.valueOf(controller.getVintageYearField().getText()));
            wine.setGrapeVarietal(controller.getGrapeVarField().getText());
            wine.setpH(Float.valueOf(controller.getPhField().getText()));
            wine.setAppellation(controller.getWineAppField().getText());
            working.setWineFormItems(wine);
        } else {
            working.setAlcoholType(AlcoholType.DistilledLiquor);
        }
        /* Mailing Address */
        Address addy = new Address();
        addy.setCity(controller.getCity8Field().getText());
        addy.setName(controller.getName8Field().getText());
        addy.setState(controller.getState8ComboBox().getValue());
        addy.setStreet(controller.getAddress8Field().getText());
        addy.setZip(controller.getZip8Field().getText());
        if(!controller.getSameAddressRadioButton().isSelected()){
            /* Other Address */
            Address other = new Address();
            addy.setCity(controller.getCity9Field().getText());
            addy.setName(controller.getName9Field().getText());
            addy.setState(controller.getState9ComboBox().getValue());
            addy.setStreet(controller.getAddress9Field().getText());
            addy.setZip(controller.getZip9Field().getText());
        }
        man.submitForm(working);

    }

}
