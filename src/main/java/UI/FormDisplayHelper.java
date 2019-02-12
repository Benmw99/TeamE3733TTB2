package UI;

import Entities.Address;
import Entities.Form;

public class FormDisplayHelper {
    IFormDisplay controller;

    public FormDisplayHelper(IFormDisplay controller){
        this.controller = controller;
        controller.setFormDisplayHelper(this);
    }

    /**
     * This is the piece of code that cleans out the form and displays it as blank.
     */
    protected void wipeForm(){
        controller.getDisplay1Label().setText("N/A");
        controller.getDisplay2Label().setText("N/A");
        controller.getDisplay3Label().setText("N/A");
        controller.getDisplayReview4Label1().setText("N/A");
        controller.getDisplay4Label2().setText("N/A");
        controller.getDisplay5Label1().setText("N/A");
        controller.getDisplay5Label2().setText("N/A");
        controller.getDisplay5Label3().setText("N/A");
        controller.getDisplay6Label().setText("N/A");
        controller.getDisplay7Label().setText("N/A");
        controller.getDisplay8Label().setText("N/A");
        controller.getDisplay9Label().setText("N/A");
        controller.getDisplay10Label().setText("N/A");
        controller.getDisplay11Label().setText("N/A");
        controller.getDisplay12Label().setText("N/A");
        controller.getDisplay13Label().setText("N/A");
        controller.getDisplay14Label().setText("N/A");
        controller.getDisplay15Label1().setText("N/A");
        controller.getDisplay15Label2().setText("N/A");
        controller.getDisplay16Label1().setText("N/A");
        controller.getDisplay16Label2().setText("N/A");
        controller.getDisplay17Label().setText("N/A");
        controller.getDisplay20Label().setText("N/A");
    }
    /**
     * This is the function to display a form in the Form Display area of any given Scene
     * whose controller properly implements the IDisplayForm Interface.
     * This will be evoked by accessing the FormDisplayHelper on the Controller
     * and then passing in the form that needs to be displayed.
     * @param form The form which needs to be displayed
     */
    protected void displayForm(Form form){
        this.wipeForm();
        controller.getDisplay1Label().setText(form.getRepID());
        System.out.println(form.getBrandName());
        System.out.println(form.getEmail());
        if(!form.getBrewersPermit().isEmpty()){
            controller.getDisplay2Label().setText(form.getBrewersPermit().get(0).getBrewersNo());
        }
        String dom;
        if(form.getSource()){
            dom = "IMPORTED";
        } else {
            dom = "DOMESTIC";
        }
        controller.getDisplay3Label().setText(dom);
        if(form.getSerialNumber() != null) {
            controller.getDisplayReview4Label1().setText(form.getSerialNumber().substring(0, 2)); //First 2
            controller.getDisplay4Label2().setText(form.getSerialNumber().substring(2)); //Rest
        }
        if(form.getAlcoholType() != null) {
            controller.getDisplay5Label1().setText(form.getAlcoholType().toString()); //Type of Product
        }
        if(form.getWineFormItems() != null) {
            controller.getDisplay5Label2().setText("" + form.getWineFormItems().getVintageYear()); //Vintage year
            controller.getDisplay5Label3().setText(String.valueOf(form.getWineFormItems().getpH()));
            if(form.getWineFormItems().getGrapeVarietal() != null){
                controller.getDisplay11Label().setText(form.getWineFormItems().getGrapeVarietal());
            }
            if(form.getWineFormItems().getAppellation() != null){
                controller.getDisplay12Label().setText(form.getWineFormItems().getAppellation());
            }
        }
        if(form.getBrandName() != null) {
            controller.getDisplay6Label().setText(form.getBrandName());
        } else {
            controller.getDisplay6Label().setText("N/A");
        }
        if(form.getFancifulName() != null) {
            controller.getDisplay7Label().setText(form.getFancifulName());
        }
        if(form.getMailingAddress() != null) {
            controller.getDisplay8Label().setText(form.getMailingAddress().getName());
            Address add = form.getMailingAddress();
            String addy = add.getName() + "\n" + add.getStreet() + "\n" + add.getCity() +
                    "\n" + add.getState() + "\n" + add.getZip();
            controller.getDisplay9Label().setText(addy);
        }
        if(form.getFormula() != null) {
            controller.getDisplay10Label().setText(form.getFormula());
        }

        if(form.getPhoneNumber() != null) {
            controller.getDisplay13Label().setText(form.getPhoneNumber());
        }
        if(form.getEmail() != null) {
            controller.getDisplay14Label().setText(form.getEmail());
        }
//        Man15Label1().setText(); //TODO TYPE OF APPLICATION
//        Man15Label2().setText();
//        Man15Label3().setText(); //END TODO
        if(form.getOtherInfo() != null) {
            controller.getDisplay16Label1().setText(form.getOtherInfo());
        }
//        Man16Label2().setText(); //TODO TRANSLATION
        if(form.getDateSubmitted() != null) {
            controller.getDisplay17Label().setText(form.getDateSubmitted().toString());
        }
        controller.getDisplay20Label().setText(String.valueOf(form.getAlcoholContent()));
    }

}

