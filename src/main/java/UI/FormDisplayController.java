package UI;

import Entities.Address;
import Entities.Form;
import Entities.LabelImage;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FormDisplayController extends PageControllerUI implements Initializable {

    public FormDisplayController(){

    }
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

    @FXML
    ImageView Display19Image1;

    @FXML
    TabPane tabPane;

    ComboBox<String> comboBox;

    JFXButton approveButton;

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


        //Getting the image from the db and setting it
        DB.Database db = DB.Database.getDatabase();
        List<LabelImage> labels = db.dbSelect.selectImagesbyTTBID(form.getTtbID());
        if (!labels.isEmpty()) {
            InputStream targetStream = new ByteArrayInputStream(labels.get(0).getImage());
            Image img = new Image(targetStream);
            Display19Image1.setImage(img);
        }
    }

    @Override
    protected void onLeave() {

    }

    /**
     * Creates new blank form
     */
    @Override
    void onLoad() {
    }

    /**
     * Displays the current form
     * @param location URL of form
     * @param resources ResourceBundle
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(AttributeContainer.getInstance().currentForm != null) {
            displayCurrentForm();
        } else {
            wipeForm();
        }

       /*This is where color switching should go

        if (){

        }

        */

    }

    /**
     * Set parent of nested form
     */
    public void setComboBox(ComboBox<String> comboBox) {
        this.comboBox = comboBox;
    }

    /**
     * Set reject button to hide
     */
    public void setApproveButton(JFXButton approveButton) {
        this.approveButton = approveButton;
    }

    /**
     * Gets current tab of display
     */
    public int getTab() {
        int tab;
        if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Section 1")) {
            tab = 1;
        } else if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Section 2")) {
            tab = 2;
        } else if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Section 3")) {
            tab = 3;
        } else if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Section 4")) {
            tab = 4;
        } else {
            tab = -1;
        }
        return tab;
    }

    public void displayStatus() {
        System.out.println("Current Section: " + tabPane.getSelectionModel().getSelectedItem().getText());
        if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Section 1")) {
            if(attributeContainer.page1Complete) {
                comboBox.setValue("Complete");
            } else if(attributeContainer.page1Incomplete) {
                comboBox.setValue("Incomplete");
            } else if(attributeContainer.page1Incorrect) {
                comboBox.setValue("Incorrect");
            }
        } else if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Section 2")) {
            if(attributeContainer.page2Complete) {
                comboBox.setValue("Complete");
            } else if(attributeContainer.page2Incomplete) {
                comboBox.setValue("Incomplete");
            } else if(attributeContainer.page2Incorrect) {
                comboBox.setValue("Incorrect");
            }
        } else if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Section 3")) {
            if(attributeContainer.page3Complete) {
                comboBox.setValue("Complete");
            } else if(attributeContainer.page3Incomplete) {
                comboBox.setValue("Incomplete");
            } else if(attributeContainer.page3Incorrect) {
                comboBox.setValue("Incorrect");
            }
        } else if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Section 4")) {
            if(attributeContainer.page4Complete) {
                comboBox.setValue("Complete");
            } else if(attributeContainer.page4Incomplete) {
                comboBox.setValue("Incomplete");
            } else if(attributeContainer.page4Incorrect) {
                comboBox.setValue("Incorrect");
            }
        }
    }

    /**
     * Marks page of form as complete/incomplete/incorrect
     */
    public void markForm() {
        System.out.println("C-C-C-COMBO BOX " + comboBox.getValue() + "Current Tab: " + getTab());
        if (comboBox.getValue() == null) {
            if(getTab() == 1) {
                attributeContainer.page1Complete = false;
                attributeContainer.page1Incomplete = false;
                attributeContainer.page1Incorrect = false;
            } else if(getTab() == 2) {
                attributeContainer.page2Complete = false;
                attributeContainer.page2Incomplete = false;
                attributeContainer.page2Incorrect = false;
            } else if(getTab() == 3) {
                attributeContainer.page3Complete = false;
                attributeContainer.page3Incomplete = false;
                attributeContainer.page3Incorrect = false;
            } else if(getTab() == 4) {
                attributeContainer.page4Complete = false;
                attributeContainer.page4Incomplete = false;
                attributeContainer.page4Incorrect = false;
            }
        } else if(comboBox.getValue().equals("Complete")){
            if(getTab() == 1) {
                attributeContainer.page1Complete = true;
                attributeContainer.page1Incomplete = false;
                attributeContainer.page1Incorrect = false;
            } else if(getTab() == 2) {
                attributeContainer.page2Complete = true;
                attributeContainer.page2Incomplete = false;
                attributeContainer.page2Incorrect = false;
            } else if(getTab() == 3) {
                attributeContainer.page3Complete = true;
                attributeContainer.page3Incomplete = false;
                attributeContainer.page3Incorrect = false;
            } else if(getTab() == 4) {
                attributeContainer.page4Complete = true;
                attributeContainer.page4Incomplete = false;
                attributeContainer.page4Incorrect = false;
            }
        } else if (comboBox.getValue().equals("Incomplete")) {
            if(getTab() == 1) {
                attributeContainer.page1Complete = false;
                attributeContainer.page1Incomplete = true;
                attributeContainer.page1Incorrect = false;
            } else if(getTab() == 2) {
                attributeContainer.page2Complete = false;
                attributeContainer.page2Incomplete = true;
                attributeContainer.page2Incorrect = false;
            } else if(getTab() == 3) {
                attributeContainer.page3Complete = false;
                attributeContainer.page3Incomplete = true;
                attributeContainer.page3Incorrect = false;
            } else if(getTab() == 4) {
                attributeContainer.page4Complete = false;
                attributeContainer.page4Incomplete = true;
                attributeContainer.page4Incorrect = false;
            }
        } else if (comboBox.getValue().equals("Incorrect")){
            if(getTab() == 1) {
                attributeContainer.page1Complete = false;
                attributeContainer.page1Incomplete = false;
                attributeContainer.page1Incorrect = true;
            } else if(getTab() == 2) {
                attributeContainer.page2Complete = false;
                attributeContainer.page2Incomplete = false;
                attributeContainer.page2Incorrect = true;
            } else if(getTab() == 3) {
                attributeContainer.page3Complete = false;
                attributeContainer.page3Incomplete = false;
                attributeContainer.page3Incorrect = true;
            } else if(getTab() == 4) {
                attributeContainer.page4Complete = false;
                attributeContainer.page4Incomplete = false;
                attributeContainer.page4Incorrect = true;
            }
        }
        System.out.println("Page 1 Statuses: Complete: " + attributeContainer.page1Complete + " Incomplete: " +
                attributeContainer.page1Incomplete + " Incorrect: " + attributeContainer.page1Incorrect);
        System.out.println("Page 2 Statuses: Complete: " + attributeContainer.page2Complete + " Incomplete: " +
                attributeContainer.page2Incomplete + " Incorrect: " + attributeContainer.page2Incorrect);
        System.out.println("Page 3 Statuses: Complete: " + attributeContainer.page3Complete + " Incomplete: " +
                attributeContainer.page3Incomplete + " Incorrect: " + attributeContainer.page3Incorrect);
        System.out.println("Page 4 Statuses: Complete: " + attributeContainer.page4Complete + " Incomplete: " +
                attributeContainer.page4Incomplete + " Incorrect: " + attributeContainer.page4Incorrect);

        if(attributeContainer.page1Incomplete || attributeContainer.page1Incorrect||
                attributeContainer.page2Incomplete || attributeContainer.page2Incorrect||
                attributeContainer.page3Incomplete || attributeContainer.page3Incorrect||
                attributeContainer.page4Incomplete || attributeContainer.page4Incorrect) {
            approveButton.setDisable(true);
        } else {
            approveButton.setDisable(false);
        }

    }

    public void page1() {
        if(attributeContainer.isInReviewingTools) {
            System.out.println("Page 1");
            if(attributeContainer.isFirstTab) {
                attributeContainer.isFirstTab = false;
                markForm();
            } else {
                attributeContainer.isFirstTab = true;
            }
        }
    }
    public void page2() {
        if(attributeContainer.isInReviewingTools) {
            System.out.println("Page 2");
            if(attributeContainer.isFirstTab) {
                attributeContainer.isFirstTab = false;
                markForm();
            } else {
                attributeContainer.isFirstTab = true;
            }
        }
    }
    public void page3() {
        if(attributeContainer.isInReviewingTools) {
            System.out.println("Page 3");
            if(attributeContainer.isFirstTab) {
                attributeContainer.isFirstTab = false;
                markForm();
            } else {
                attributeContainer.isFirstTab = true;
            }
        }
    }
    public void page4() {
        if(attributeContainer.isInReviewingTools) {
            System.out.println("Page 4");
            if(attributeContainer.isFirstTab) {
                attributeContainer.isFirstTab = false;
                markForm();
            } else {
                attributeContainer.isFirstTab = true;
            }
        }
    }
}

