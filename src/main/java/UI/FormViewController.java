package UI;

import Entities.Address;
import Entities.Form;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FormViewController extends PageControllerUI implements Initializable {

    @FXML
    Label Display1Label;
    @FXML
    Label Display2Label;
    @FXML
    Label Display3Label;
    @FXML
    Label DisplayReview4Label1;
    @FXML
    Label Display4Label2;
    @FXML
    Label Display5Label1;
    @FXML
    Label Display5Label2;
    @FXML
    Label Display5Label3;
    @FXML
    Label Display6Label;
    @FXML
    Label Display7Label;
    @FXML
    Label Display8Label;
    @FXML
    Label Display9Label;
    @FXML
    Label Display10Label;
    @FXML
    Label Display11Label;
    @FXML
    Label Display12Label;
    @FXML
    Label Display13Label;
    @FXML
    Label Display14Label;
    @FXML
    Label Display15Label1;
    @FXML
    Label Display15Label2;
    @FXML
    Label Display15Label3;
    @FXML

    Label Display16Label1;
    @FXML
    Label Display16Label2;
    @FXML
    Label Display17Label;
    @FXML
    Label Display18Label;
    @FXML
    Label Display20Label;


    /**
     * Displays the current form as specified in the AttributeContainer Singleton
     */
    public void displayCurrentForm() {
        Form currentForm = AttributeContainer.getInstance().currentForm;
        displayForm(currentForm);

    }


    /**
     * This is the piece of code that cleans out the form and displays it as blank.
     */
    protected void wipeForm() {
        this.Display1Label.setText("N/A");
        this.Display2Label.setText("N/A");
        this.Display3Label.setText("N/A");
        this.DisplayReview4Label1.setText("N/A");
        this.Display4Label2.setText("N/A");
        this.Display5Label1.setText("N/A");
        this.Display5Label2.setText("N/A");
        this.Display5Label3.setText("N/A");
        this.Display6Label.setText("N/A");
        this.Display7Label.setText("N/A");
        this.Display8Label.setText("N/A");
        this.Display9Label.setText("N/A");
        this.Display10Label.setText("N/A");
        this.Display11Label.setText("N/A");
        this.Display12Label.setText("N/A");
        this.Display13Label.setText("N/A");
        this.Display14Label.setText("N/A");
        this.Display15Label1.setText("N/A");
        this.Display15Label2.setText("N/A");
        this.Display15Label3.setText("N/A");
        this.Display16Label1.setText("N/A");
        this.Display16Label2.setText("N/A");
        this.Display17Label.setText("N/A");
        this.Display18Label.setText("N/A");
        this.Display20Label.setText("N/A");
    }

    /**
     * This is the function to display a form in the Form Display area of any given Scene
     * whose controller properly implements the IDisplayForm Interface.
     * This will be evoked by accessing the FormDisplayHelper on the Controller
     * and then passing in the form that needs to be displayed.
     *
     * @param form The form which needs to be displayed
     */
    protected void displayForm(Form form) {
        this.wipeForm();
        this.Display1Label.setText(form.getRepID());
        System.out.println(form.getBrandName());
        System.out.println(form.getEmail());
        if (!form.getBrewersPermit().isEmpty()) {
            this.Display2Label.setText(form.getBrewersPermit().get(0).getBrewersNo());
        }
        String dom;
        if (form.getSource()) {
            dom = "IMPORTED";
        } else {
            dom = "DOMESTIC";
        }
        this.Display3Label.setText(dom);
        if (form.getSerialNumber() != null) {
            this.DisplayReview4Label1.setText(form.getSerialNumber().substring(0, 2)); //First 2
            this.Display4Label2.setText(form.getSerialNumber().substring(2)); //Rest
        }
        if (form.getAlcoholType() != null) {
            this.Display5Label1.setText(form.getAlcoholType().toString()); //Type of Product
        }
        if (form.getWineFormItems() != null) {
            this.Display5Label2.setText("" + form.getWineFormItems().getVintageYear()); //Vintage year
            this.Display5Label3.setText(String.valueOf(form.getWineFormItems().getpH()));
            if (form.getWineFormItems().getGrapeVarietal() != null) {
                this.Display11Label.setText(form.getWineFormItems().getGrapeVarietal());
            }
            if (form.getWineFormItems().getAppellation() != null) {
                this.Display12Label.setText(form.getWineFormItems().getAppellation());
            }
        }
        if (form.getBrandName() != null) {
            this.Display6Label.setText(form.getBrandName());
        } else {
            this.Display6Label.setText("N/A");
        }
        if (form.getFancifulName() != null) {
            this.Display7Label.setText(form.getFancifulName());
        }
        if (form.getMailingAddress() != null) {
            this.Display8Label.setText(form.getMailingAddress().getName());
            Address add = form.getMailingAddress();
            String addy = add.getName() + "\n" + add.getStreet() + "\n" + add.getCity() +
                    "\n" + add.getState() + "\n" + add.getZip();
            this.Display9Label.setText(addy);
        }
        if (form.getFormula() != null) {
            this.Display10Label.setText(form.getFormula());
        }

        if (form.getPhoneNumber() != null) {
            this.Display13Label.setText(form.getPhoneNumber());
        }
        if (form.getEmail() != null) {
            this.Display14Label.setText(form.getEmail());
        }
//        Man15Label1().setText(); //TODO TYPE OF APPLICATION
//        Man15Label2().setText();
//        Man15Label3().setText(); //END TODO
        if (form.getOtherInfo() != null) {
            this.Display16Label1.setText(form.getOtherInfo());
        }
//        Man16Label2().setText(); //TODO TRANSLATION
        if (form.getDateSubmitted() != null) {
            this.Display17Label.setText(form.getDateSubmitted().toString());
        }
        this.Display20Label.setText(String.valueOf(form.getAlcoholContent()));
    }

    @Override
    protected void onLeave() {

    }

    /**
     * Creates new blank form
     */
    @Override
    void onLoad() {
        AttributeContainer.getInstance().currentForm = new Form("ABC");
        wipeForm();

    }

    /**
     * Displays the current form
     * @param location URL of form
     * @param resources ResourceBundle
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayCurrentForm();
    }
}

