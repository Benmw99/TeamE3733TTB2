package UI;

import Entities.*;
import Entities.LabelImage;
import com.jfoenix.controls.*;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RegexValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import org.apache.commons.io.IOUtils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
@Deprecated
public class ManSingleAppPageController extends PageControllerUI implements  Initializable {

    @FXML
    public JFXButton SendApp;

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
    JFXTextField AmountField;

    @FXML
    JFXTextField TTBIDField;

    @FXML
    private JFXTextField AdditionalInfoField;

    @FXML
    JFXTextField TranslationField;

    @FXML
    JFXDatePicker AppDate;

    @FXML
    private JFXTextField SignatureField;

    @FXML
    JFXButton UploadButton;

    @FXML
    private JFXTextField AlcoholContentTextField;

    @FXML
    ImageView labelImageDisplay;

    @FXML
    JFXButton goBackHome;

    private Form workingForm;

    @Override
    void onLoad() {
    }
    @Override
    protected void onLeave() {
    }



    public static boolean errorInForm = false;


    /**
     * Sets up application form and fields within it
     * @param location URL of forms
     * @param resources ResourceBundle
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Fill ComboBoxes
        List<String> states = Arrays.asList("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL",
                "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT",
                "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",
                "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");
        State8ComboBox.getItems().addAll(states);
        State9ComboBox.getItems().addAll(states);
        SourceComboBox.getItems().addAll("Domestic", "Imported");
        TypeComboBox.getItems().addAll("Malt Beverage", "Wine", "Distilled Liquor");
        //setup submit button

        // we can just keep the button disabled through a listener

        this.SendApp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int id;
                if(AttributeContainer.getInstance().currentUser.isManufacturer()){
                    id = getForm((Manufacturer)AttributeContainer.getInstance().currentUser);
                } else {
                    // What?
                    Manufacturer temp = new Manufacturer();
                    temp.setManID(0);
                    id = getForm(temp);
                }
                AttributeContainer.getInstance().labelImage.setTTBID(id);
                AttributeContainer.getInstance().labelImage.insert();
                AttributeContainer.getInstance().currentForm = null;
                AttributeContainer.getInstance().formQueue = ((Manufacturer)AttributeContainer.getInstance().currentUser).loadForms();
                goToPage("ManHome.fxml");
            }
        });



    }

    @FXML
    public void goBack(){
        AttributeContainer.getInstance().currentForm = null;
        goToPage("ManHome.fxml");
    }

    /**
     * Will disable and reset fields is they select the button "same as question 8"
     *
     * @throws IOException someone help me here, it throws errors, but works anyways
     */

    @FXML
    public void checkMail() throws IOException {
        if (SameAddressRadioButton.isSelected()) {
            Name9Field.setEditable(false);
            Name9Field.setDisable(true);
            Name9Field.setText("");
            State9ComboBox.setDisable(true);
            State9ComboBox.setPromptText("State");
            Address9Field.setEditable(false);
            Address9Field.setText("");
            Address9Field.setDisable(true);
            City9Field.setEditable(false);
            City9Field.setText("");
            City9Field.setDisable(true);
            Zip9Field.setEditable(false);
            Zip9Field.setText("");
            Zip9Field.setDisable(true);
        } else {
            Name9Field.setEditable(true);
            Name9Field.setDisable(false);
            State9ComboBox.setDisable(false);
            State9ComboBox.setPromptText("State");
            Address9Field.setEditable(true);
            Address9Field.setDisable(false);
            City9Field.setEditable(true);
            City9Field.setDisable(false);
            Zip9Field.setEditable(true);
            Zip9Field.setDisable(false);
        }
    }

    /**
     * Checks if the combobox is on wine and displays the appropriate text fields
     *
     * @throws IOException
     */

    @FXML
    public void checkWine() throws IOException {
        if (TypeComboBox.getValue().equals("Wine")) {
            VintageYearField.disableProperty().setValue(false);
            PhField.disableProperty().setValue(false);

        } else {
            VintageYearField.disableProperty().setValue(true);
            VintageYearField.setText("");
            PhField.disableProperty().setValue(true);
            PhField.setText("");
            GrapeVarField.setText("");
            WineAppField.setText("");
        }
    }

    /**
     * This is the method which gets a form from the associated controller and persists
     * it to the database. Pass it the manufacturer who is inserting the form. Later there might
     * be another option using no Manufacturer at all.
     * @param man The manufacturer performing the insert... We need to think about this?
     * @return int the TTBID
     */
    int getForm(Manufacturer man){
        Form working = new Form();
        working.setBrandName(BrandField.getText());
        working.setSerialNumber(SerialYearField.getText()
                + SerialDigitsField.getText());
        working.setPhoneNumber(PhoneNumField.getText());
        working.setOtherInfo(AdditionalInfoField.getText());
        working.setEmail(EmailField.getText());
        working.setAlcoholContent(Float.parseFloat(AlcoholContentTextField.getText()));
        working.setFancifulName(FancifulField.getText());
        working.setRepID(RepIDField.getText());
        working.setFormula(FormulaField.getText());
        working.setApprovalStatus(ApprovalStatus.Incomplete);
        if(SourceComboBox.getValue().equals("Domestic")) {
            working.setSource(false);
        } else {
            working.setSource(true);
        }
        if(TypeComboBox.getValue().equals("Malt Beverage")){
            working.setAlcoholType(AlcoholType.MaltBeverage);
        } else if(TypeComboBox.getValue().equals("Wine")){
            working.setAlcoholType(AlcoholType.Wine);
            /* This part takes care of the Wine */
            WineFormItems wine = new  WineFormItems();
            wine.setVintageYear(Integer.valueOf(VintageYearField.getText()));
            wine.setGrapeVarietal(GrapeVarField.getText());
            wine.setpH(Float.valueOf(PhField.getText()));
            wine.setAppellation(WineAppField.getText());
            working.setWineFormItems(wine);
        } else {
            working.setAlcoholType(AlcoholType.DistilledLiquor);
        }
        /* Mailing Address */
        Address addy = new Address();
        addy.setCity(City8Field.getText());
        addy.setName(Name8Field.getText());
        addy.setState(State8ComboBox.getValue());
        addy.setStreet(Address8Field.getText());
        addy.setZip(Zip8Field.getText());
        addy.setMailing(true);
        if(!SameAddressRadioButton.isSelected()){
            /* Other Address */
            Address other = new Address();
            addy.setCity(City9Field.getText());
            addy.setName(Name9Field.getText());
            addy.setState(State9ComboBox.getValue());
            addy.setStreet(Address9Field.getText());
            addy.setZip(Zip9Field.getText());
        }
        List<Address> adds = new ArrayList<>();
        adds.add(addy);
        working.setAddress(adds);
        List<BrewersPermit> brews = new ArrayList<>();
        BrewersPermit brew = new BrewersPermit(ProducerNumField.getText(), true);
        brews.add(brew);
        working.setBrewersPermit(brews);
        man.submitForm(working);
        this.workingForm = working;
        return working.getTtbID();

    }
    @FXML
    void uploadLabelImage(){
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG Files", "*.png")
                ,new FileChooser.ExtensionFilter("JPEG Files", "*.jpg")
        );


        try {
            fileChooser.setTitle("Select label image");
            File selectedFile = fileChooser.showOpenDialog(PageSwitcher.stage);
            LabelImage labelImage = new LabelImage();
            InputStream is = new FileInputStream(selectedFile);
            labelImage.setImage(IOUtils.toByteArray(is));
            labelImage.setImageName(selectedFile.getName());
            attributeContainer.labelImage = labelImage;
            attributeContainer.labelImageFile = selectedFile;
//            BufferedImage img = ImageIO.read(selectedFile);
            Image img = new Image(selectedFile.toURI().toString());
            labelImageDisplay.setImage(img);
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

}
