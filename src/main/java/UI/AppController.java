package UI;

import Entities.*;
import Entities.LabelImage;
import com.jfoenix.controls.*;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RegexValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.base.ValidatorBase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import org.apache.commons.io.IOUtils;
import org.controlsfx.control.BreadCrumbBar;
import org.controlsfx.control.PopOver;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AppController extends PageControllerUI implements Initializable {

    @FXML
    private JFXButton back;

    @FXML
    private Pane pane1;

    @FXML
    private JFXTextField RepIDField;

    @FXML
    private JFXButton RepInfo;

    @FXML
    private JFXTextField ProducerNumField;

    @FXML
    private JFXButton ProducerInfo;

    @FXML
    private JFXComboBox<String> SourceComboBox;

    @FXML
    private JFXButton SourceInfo;

    @FXML
    private JFXTextField SerialYearField;

    @FXML
    private JFXTextField SerialDigitsField;

    @FXML
    private JFXButton SerialInfo;

    @FXML
    private JFXComboBox<String> TypeComboBox;

    @FXML
    private JFXTextField VintageYearField;

    @FXML
    private JFXTextField PhField;

    @FXML
    private JFXButton TypeInfo;

    @FXML
    private JFXTextField BrandField;

    @FXML
    private JFXButton BrandInfo;

    @FXML
    private Pane pane2;

    @FXML
    private JFXTextField FancifulField;

    @FXML
    private JFXButton FancyInfo;

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
    private JFXButton AddressInfo;

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
    private JFXButton MailingInfo;

    @FXML
    private JFXTextField FormulaField;

    @FXML
    private JFXButton FormulaInfo;

    @FXML
    private HBox GrapeVarHBox;

    @FXML
    private JFXTextField GrapeVarField;

    @FXML
    private JFXButton WineGrapeInfo;

    @FXML
    private HBox WineAppHBox;

    @FXML
    private JFXTextField WineAppField;

    @FXML
    private JFXButton WineAppelationInfo;

    @FXML
    private Pane pane3;

    @FXML
    private JFXTextField PhoneNumField;

    @FXML
    private JFXButton PhoneInfo;

    @FXML
    private JFXTextField EmailField;

    @FXML
    private JFXButton EmailInfo;

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
    private JFXButton AdditionalInfoInfo;

    @FXML
    private JFXDatePicker AppDate;

    @FXML
    private JFXButton DateInfo;

    @FXML
    private Pane pane4;

    @FXML
    private JFXButton SendApp;

    @FXML
    private JFXTextField SignatureField;

    @FXML
    private JFXButton SignatureInfo;

    @FXML
    private JFXButton UploadButton;

    @FXML
    private JFXButton LabelSubmitInfo;

    @FXML
    private ImageView labelImageDisplay;

    @FXML
    private JFXTextField AlcoholContentTextField;

    @FXML
    private JFXButton AlcoholPercentInfo;

    @FXML
    private BreadCrumbBar<String> Nav;

    @FXML
    private JFXButton TypeAppInfo;

    @FXML
    private JFXButton SubmitButton;

    private Form workingForm;

    List<ValidatorBase> santa_List;

    @Override
    void onLoad() {
    }

    @Override
    protected void onLeave() {
    }


    public static boolean errorInForm = false;

    /**
     * Determines tab user is on and handles appropriately
     *
     * @param actionEvent
     */
//    public void handlePage(javafx.event.ActionEvent actionEvent) {
//        if (actionEvent.getSource() == page1) {
//                pane1.toFront();
//                pane1.setDisable(false);
//                pane1.setVisible(true);
//                pane2.setVisible(false);
//                pane2.setDisable(true);
//                pane3.setVisible(false);
//                pane3.setDisable(true);
//                pane4.setVisible(false);
//                pane4.setDisable(true);
//                //System.out.println("Page1");
//
//        } else if (actionEvent.getSource() == page2) {
//            pane2.toFront();
//            pane2.setDisable(false);
//            pane2.setVisible(true);
//            pane1.setVisible(false);
//            pane1.setDisable(true);
//            pane3.setVisible(false);
//            pane3.setDisable(true);
//            pane4.setVisible(false);
//            pane4.setDisable(true);
//            //System.out.println("Page2");
//        } else if (actionEvent.getSource() == page3) {
//            pane3.toFront();
//            pane3.setDisable(false);
//            pane3.setVisible(true);
//            pane1.setVisible(false);
//            pane1.setDisable(true);
//            pane2.setVisible(false);
//            pane2.setDisable(true);
//            pane4.setVisible(false);
//            pane4.setDisable(true);
//            //System.out.println("Page3");
//        } else if (actionEvent.getSource() == page4) {
//            pane4.toFront();
//            pane4.setDisable(false);
//            pane4.setVisible(true);
//            pane1.setVisible(false);
//            pane1.setDisable(true);
//            pane2.setVisible(false);
//            pane2.setDisable(true);
//            pane3.setVisible(false);
//            pane3.setDisable(true);
//            //System.out.println("Page4");
//        }
//
//    }

    /**
     * Sets up application form and fields within it
     *
     * @param location  URL of forms
     * @param resources ResourceBundle
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set up panes
        santa_List = new ArrayList<ValidatorBase>();
        pane1.toFront();
        pane1.setDisable(false);
        pane1.setVisible(true);
        pane2.setVisible(false);
        pane2.setDisable(true);
        pane3.setVisible(false);
        pane3.setDisable(true);
        pane4.setVisible(false);
        pane4.setDisable(true);

        // Set up crumb bar
        TreeItem<String> model = BreadCrumbBar.buildTreeModel("Page 1", "Page 2", "Page 3", "Page 4");
        Nav.setSelectedCrumb(model);
        Nav.setAutoNavigationEnabled(false);
        Nav.setOnCrumbAction(new EventHandler<BreadCrumbBar.BreadCrumbActionEvent<String>>() {
            @Override
            public void handle(BreadCrumbBar.BreadCrumbActionEvent<String> event) {
                if(event.getSelectedCrumb().getValue() == "Page 1"){
                    pane1.toFront();
                    pane1.setDisable(false);
                    pane1.setVisible(true);
                    pane2.setVisible(false);
                    pane2.setDisable(true);
                    pane3.setVisible(false);
                    pane3.setDisable(true);
                    pane4.setVisible(false);
                    pane4.setDisable(true);
                }
                else if(event.getSelectedCrumb().getValue() == "Page 2"){
                    pane2.toFront();
                    pane2.setDisable(false);
                    pane2.setVisible(true);
                    pane1.setVisible(false);
                    pane1.setDisable(true);
                    pane3.setVisible(false);
                    pane3.setDisable(true);
                    pane4.setVisible(false);
                    pane4.setDisable(true);
                }
                else if(event.getSelectedCrumb().getValue() == "Page 3"){
                    pane3.toFront();
                    pane3.setDisable(false);
                    pane3.setVisible(true);
                    pane1.setVisible(false);
                    pane1.setDisable(true);
                    pane2.setVisible(false);
                    pane2.setDisable(true);
                    pane4.setVisible(false);
                    pane4.setDisable(true);
                }
                else if(event.getSelectedCrumb().getValue() == "Page 4"){
                    pane4.toFront();
                    pane4.setDisable(false);
                    pane4.setVisible(true);
                    pane1.setVisible(false);
                    pane1.setDisable(true);
                    pane2.setVisible(false);
                    pane2.setDisable(true);
                    pane3.setVisible(false);
                    pane3.setDisable(true);
                }
            }
        });

        // Initialize TextFields
        VintageYearField.disableProperty().setValue(true);
        PhField.disableProperty().setValue(true);
        AmountField.disableProperty().setValue(true);
        State15ComboBox.disableProperty().setValue(true);
        TTBIDField.disableProperty().setValue(true);
        GrapeVarHBox.disableProperty().setValue(true);
        WineAppHBox.disableProperty().setValue(true);

        // Initialize Validators
        setListener(RepIDField, 7);
        setListener(ProducerNumField, 1);
        setListener(SerialYearField, 5);
        setListener(SerialDigitsField, 1);
        setListener(BrandField, 2);
        setListener(VintageYearField, 5);
        setListener(PhField, 6);
        setListener(Name8Field, 2);
        setListener(Address8Field, 0);
        setListener(City8Field, 0);
        setListener(Zip8Field, 1);
        setListener(Name9Field, 2);
        setListener(Address9Field, 0);
        setListener(City9Field, 0);
        setListener(Zip9Field, 1);
        setListener(FormulaField, 0);
        setListener(PhoneNumField, 4);
        setListener(EmailField, 3);
        setListener(SignatureField, 0);
        setListener(AlcoholContentTextField, 1);


        // Fill ComboBoxes
        List<String> states = Arrays.asList("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL",
                "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT",
                "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",
                "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");
        State8ComboBox.getItems().addAll(states);
        State9ComboBox.getItems().addAll(states);
        State15ComboBox.getItems().addAll(states);
        SourceComboBox.getItems().addAll("Domestic", "Imported");
        TypeComboBox.getItems().addAll("Malt Beverage", "Wine", "Distilled Liquor");
        /* setup submit button */

        // we can just keep the button disabled through a listener

        this.SendApp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int id;
                if (!SendApp.isDisable()) {
                    if (AttributeContainer.getInstance().currentUser.isManufacturer()) {
                        id = getForm((Manufacturer) AttributeContainer.getInstance().currentUser);
                    } else {
                        // What?
                        Manufacturer temp = new Manufacturer();
                        temp.setManID(0);
                        id = getForm(temp);
                    }
                    AttributeContainer.getInstance().labelImage.setTTBID(id);
                    AttributeContainer.getInstance().labelImage.insert();
                    AttributeContainer.getInstance().currentForm = null;
                    AttributeContainer.getInstance().formQueue = ((Manufacturer) AttributeContainer.getInstance().currentUser).loadForms();
                    goToPage("ManHome.fxml");
                }
            }
        });






    }

    @FXML
    public void goBack() {
        AttributeContainer.getInstance().currentForm = null;
        goToPage("ManHome.fxml");
    }

    // Always checks if empty
    // 1 - Only Numbers
    // 2 - Only Strings
    // 3 - Valid email
    // 4 - Valid phone number
    // 5 - Valid 4 digits
    // 6 - Valid pH
    // 7 - Valid rep Id

    /**
     * Sets listener for fields on form
     *
     * @param field
     * @param type
     */
    public void setListener(JFXTextField field, int type) {
        if (type == 1) {
            NumberValidator numValidator = new NumberValidator();
            santa_List.add(numValidator);
            field.getValidators().add(numValidator);
            numValidator.setMessage("Enter a number");
            RequiredFieldValidator validator = new RequiredFieldValidator();
            field.getValidators().add(validator);
            validator.setMessage("* Required");
        }
        if (type == 2) {
            RegexValidator regexValidator = new RegexValidator();
            santa_List.add(regexValidator);
            regexValidator.setRegexPattern("[a-zA-Z]*");
            field.getValidators().add(regexValidator);
            regexValidator.setMessage("Enter a string!");
            RequiredFieldValidator validator = new RequiredFieldValidator();
            field.getValidators().add(validator);
            validator.setMessage("* Required");
        }
        if (type == 3) {
            RegexValidator validEmail = new RegexValidator();
            santa_List.add(validEmail);
            validEmail.setRegexPattern(".+\\@.+\\..+");
            field.getValidators().add(validEmail);
            validEmail.setMessage("Enter a valid email");
            RequiredFieldValidator validator = new RequiredFieldValidator();
            field.getValidators().add(validator);
            validator.setMessage("* Required");
        }
        if (type == 4) {
            RegexValidator validEmail = new RegexValidator();
            santa_List.add(validEmail);
            validEmail.setRegexPattern("^\\D?(\\d{3})\\D?\\D?(\\d{3})\\D?(\\d{4})$");
            field.getValidators().add(validEmail);
            validEmail.setMessage("Enter a valid phone number");
            RequiredFieldValidator validator = new RequiredFieldValidator();
            field.getValidators().add(validator);
            validator.setMessage("* Required");
        }
        if (type == 5) {
            RegexValidator validEmail = new RegexValidator();
            santa_List.add(validEmail);
            validEmail.setRegexPattern("^\\d{4}$");
            field.getValidators().add(validEmail);
            validEmail.setMessage("Enter a valid year");
            RequiredFieldValidator validator = new RequiredFieldValidator();
            field.getValidators().add(validator);
            validator.setMessage("* Required");
        }
        if (type == 6) {
            RegexValidator validEmail = new RegexValidator();
            santa_List.add(validEmail);
            validEmail.setRegexPattern("^[0-1]?[1-4]$"); // Doesn't account for decimals
            field.getValidators().add(validEmail);
            validEmail.setMessage("Enter a valid pH");
            RequiredFieldValidator validator = new RequiredFieldValidator();
            field.getValidators().add(validator);
            validator.setMessage("* Required");
        }
        if (type == 7) {
            RegexValidator validRepId = new RegexValidator();
            santa_List.add(validRepId);
            validRepId.setRegexPattern("^[a-zA-Z0-9]{0,16}$"); // Doesn't account for decimals
            field.getValidators().add(validRepId);
            validRepId.setMessage("Enter a valid rep id");
        }

        if (errorInForm) {
        }


        field.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    field.validate();


                    boolean t = true;
                    for(ValidatorBase vb : santa_List){
                        t = t && !vb.getHasErrors();
                        System.out.println(vb.getHasErrors());}

                    if(t) {

                        System.out.println("Fields has no errors");
                        SendApp.setOpacity(1);
                    } else {
                        System.out.println("Fields has  errors");
                        SendApp.setDisable(true);
                        SendApp.setOpacity(0);

                }
        }}});

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
            GrapeVarHBox.disableProperty().setValue(false);
            WineAppHBox.disableProperty().setValue(false);

        } else {
            VintageYearField.disableProperty().setValue(true);
            VintageYearField.setText("");
            PhField.disableProperty().setValue(true);
            PhField.setText("");
            GrapeVarHBox.disableProperty().setValue(true);
            GrapeVarField.setText("");
            WineAppHBox.disableProperty().setValue(true);
            WineAppField.setText("");
        }
    }

    @FXML
    public void typeCheck() throws IOException {
        if (!LiquorRadioButton.isSelected()) {
            AmountField.setText("");
            AmountField.disableProperty().setValue(true);
        } else
            AmountField.disableProperty().setValue(false);

        if (!ExemptionRadioButton.isSelected())
            State15ComboBox.disableProperty().setValue(true);
        else
            State15ComboBox.disableProperty().setValue(false);

        if (!ResubmitRadioButton.isSelected()) {
            TTBIDField.setText("");
            TTBIDField.disableProperty().setValue(true);
        } else
            TTBIDField.disableProperty().setValue(false);


    }

    /**
     * This is the method which gets a form from the associated controller and persists
     * it to the database. Pass it the manufacturer who is inserting the form. Later there might
     * be another option using no Manufacturer at all.
     *
     * @param man The manufacturer performing the insert... We need to think about this?
     * @return int the TTBID
     */
    int getForm(Manufacturer man) {
        Form working = new Form();
        WineFormItems wine = new WineFormItems();
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
        if (SourceComboBox.getValue().equals("Domestic")) {
            working.setSource(false);
        } else {
            working.setSource(true);
        }
        if (TypeComboBox.getValue().equals("Malt Beverage")) {
            working.setAlcoholType(AlcoholType.MaltBeverage);
        } else if (TypeComboBox.getValue().equals("Wine")) {
            working.setAlcoholType(AlcoholType.Wine);
            /* This part takes care of the Wine */
            wine.setVintageYear(Integer.valueOf(VintageYearField.getText()));
            wine.setGrapeVarietal(GrapeVarField.getText());
            wine.setpH(Float.valueOf(PhField.getText()));
            wine.setAppellation(WineAppField.getText());
        } else {
            working.setAlcoholType(AlcoholType.DistilledLiquor);
        }
        working.setWineFormItems(wine);
        /* Mailing Address */
        Address addy = new Address();
        addy.setCity(City8Field.getText());
        addy.setName(Name8Field.getText());
        addy.setState(State8ComboBox.getValue());
        addy.setStreet(Address8Field.getText());
        addy.setZip(Zip8Field.getText());
        addy.setMailing(true);
        if (!SameAddressRadioButton.isSelected()) {
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
        working.setApproval(new Approval());
        man.submitForm(working);
        this.workingForm = working;
        return working.getTtbID();

    }

    @FXML
    void uploadLabelImage() {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG Files", "*.png")
                , new FileChooser.ExtensionFilter("JPEG Files", "*.jpg")
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
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    public void handleButtonAction(ActionEvent event){
//        System.out.println(event.toString());
//        System.out.println(event.getPickResult().getIntersectedNode().getId());
//        popOver.show(AlcoholContentInfo);
//        if(id == RepIDField)
//        popOver.show(AlcoholContentInfo);
        final Node source = (Node) event.getSource();
        String id = source.getId();
        System.out.println(id);

        switch (id){
            case "RepInfo":
                JFXTextArea RepInfoText = new JFXTextArea("Include a third party representative ID number if your application will be submitted by a third party representative, and if you consent to the disclosure of information abou tthe applciation to thiis representative, as well as the return of the processed application to this representative. Third party filers who do not already have a Representative ID Number, please contact TTB to obtain one (See section IV for contact information)"); // Create JFXTextArea & put info here
                RepInfoText.setEditable(false);
                RepInfoText.setStyle("-fx-font-size: 14"); // Same for all
                VBox vBox = new VBox(RepInfoText); // Make sure update the TextArea for the VBox
                vBox.setPrefSize(300, 150.0);  // Same for all
                vBox.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE); // Same for all
                vBox.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver = new PopOver(vBox); // Same for all
                popOver.show(RepInfo); //Change to make sure it is linked to proper button
                break;

            case "ProducerInfo":
                JFXTextArea ProducerInfoText = new JFXTextArea("For bonded wine cellars, taxpaid wine bottline houses, and distilled spirits plants, enter the applicable registry number (BW- or TPWBH- or DSP- number). Importers must enter the TTB basic permit number and brewers must enter the brewer's notice number. Wholesalers applying to relabel must enter the wholesaler's basic permis number. ");
                ProducerInfoText.setEditable(false);
                ProducerInfoText.setStyle("-fx-font-size: 14");
                VBox vBox1 = new VBox(ProducerInfoText);
                vBox1.setPrefSize(300, 150.0);
                vBox1.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox1.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver1 = new PopOver(vBox1);
                popOver1.show(ProducerInfo);
                break;
            case "SourceInfo":
                JFXTextArea SourceInfoText = new JFXTextArea("Indicate the source of the product by checking the appropriate box.");
                SourceInfoText.setEditable(false);
                SourceInfoText.setStyle("-fx-font-size: 14");
                VBox vBox2 = new VBox(SourceInfoText);
                vBox2.setPrefSize(300, 150.0);
                vBox2.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox2.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver2 = new PopOver(vBox2);
                popOver2.show(SourceInfo);
                break;
            case "SerialInfo":
                JFXTextArea SerialInfoText = new JFXTextArea("You must assign a sequential serial number beginning with the last two digits of the current calendar year to each application and its duplicate, not to exceed 6 characters; e.g., 12-1, 12-2, etc.");
                SerialInfoText.setEditable(false);
                SerialInfoText.setStyle("-fx-font-size: 14");
                VBox vBox3 = new VBox(SerialInfoText);
                vBox3.setPrefSize(300, 150.0);
                vBox3.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox3.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver3 = new PopOver(vBox3);
                popOver3.show(SerialInfo);
                break;
            case "TypeInfo":
                JFXTextArea TypeInfoText = new JFXTextArea("Indicate the type of product by checking the appropriate box. For Sake, check the \"wine\" box.");
                TypeInfoText.setEditable(false);
                TypeInfoText.setStyle("-fx-font-size: 14");
                VBox vBox4 = new VBox(TypeInfoText);
                vBox4.setPrefSize(300, 150.0);
                vBox4.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox4.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver4 = new PopOver(vBox4);
                popOver4.show(TypeInfo);
                break;
            case "BrandInfo":
                JFXTextArea BrandInfoText = new JFXTextArea("A brand name is a name under which the product is sold. If the product is not sold under a brand name, enter the name of the bottler, packer, or importer, as applicable.");
                BrandInfoText.setEditable(false);
                BrandInfoText.setStyle("-fx-font-size: 14");
                VBox vBox5 = new VBox(BrandInfoText);
                vBox5.setPrefSize(300, 150.0);
                vBox5.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox5.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver5 = new PopOver(vBox5);
                popOver5.show(BrandInfo);
                break;
            case "FancyInfo":
                JFXTextArea FancyInfoText = new JFXTextArea("A fanciful name is a name that further identifies the product and is required for some specialty products. It is optional for other products.");
                FancyInfoText.setEditable(false);
                FancyInfoText.setStyle("-fx-font-size: 14");
                VBox vBox6 = new VBox(FancyInfoText);
                vBox6.setPrefSize(300, 150.0);
                vBox6.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox6.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver6 = new PopOver(vBox6);
                popOver6.show(FancyInfo);
                break;
            case "AddressInfo":
                JFXTextArea AddressInfoText = new JFXTextArea("Indicate your company name and address exactly as they appear on your plant registry, basic permint, or brewer's notic (include your approved DBA or trade name if you use it on the label). In the case of distilled spirits and malt beverages that are bottled at more than one location indicate your principal place of business address in this field.");
                AddressInfoText.setEditable(false);
                AddressInfoText.setStyle("-fx-font-size: 14");
                VBox vBox7 = new VBox(AddressInfoText);
                vBox7.setPrefSize(300, 150.0);
                vBox7.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox7.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver7 = new PopOver(vBox7);
                popOver7.show(AddressInfo);
                break;
            case "MailingInfo":
                JFXTextArea MailingInfoText = new JFXTextArea("You may enter a mailing address here if you receive mail at an address other than the address shown in item 8");
                MailingInfoText.setEditable(false);
                MailingInfoText.setStyle("-fx-font-size: 14");
                VBox vBox8 = new VBox(MailingInfoText);
                vBox8.setPrefSize(300, 150.0);
                vBox8.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox8.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver8 = new PopOver(vBox8);
                popOver8.show(MailingInfo);
                break;
            case "FormulaInfo":
                JFXTextArea FormulaInfoText = new JFXTextArea("The term \"Formula\" encompasses the following pre-COLA product evaluations: domestic beverage alcohol formulas, pre-import approval letters, lab analyses, and submissions formerly known as statements of process (SOPs). A formula is a quantitative list of ingredients and a step-by-step method of manufacture for alcohol beverages (wine, distilled spirits, and malt beverages) requireing approval from TTB prior to production or importation as set out in Industry Circular 2007-4. TTB's regulatory authority for such products may also be found in 27 CFR parts 4, 5, 7, 19, 24, 25, and 26. Please visit http://www.ttb.gov/formulation/pre_cola.shtml for more information about when a formula is required. For any domestic or imported alcohol beverage product requireing formula approval, specify the TTB formula ID/TTB ID number, or TTB lab number. A copy of the approved formula or pre-import approval letter must accompany this label application. If the formula approval was obtained electronically through Formulas Online, the system-generated TTB Formula ID number must be provided.");
                FormulaInfoText.setEditable(false);
                FormulaInfoText.setStyle("-fx-font-size: 14");
                VBox vBox9 = new VBox(FormulaInfoText);
                vBox9.setPrefSize(300, 150.0);
                vBox9.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox9.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver9 = new PopOver(vBox9);
                popOver9.show(FormulaInfo);
                break;
            case "WineGrapeInfo":
                JFXTextArea WineGrapeInfoText = new JFXTextArea("You must list in this block each grape varietal (if any) that appears on wine labels");
                WineGrapeInfoText.setEditable(false);
                WineGrapeInfoText.setStyle("-fx-font-size: 14");
                VBox vBox10 = new VBox(WineGrapeInfoText);
                vBox10.setPrefSize(300, 150.0);
                vBox10.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox10.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver10 = new PopOver(vBox10);
                popOver10.show(WineGrapeInfo);
                break;
            case "WineAppelationInfo":
                JFXTextArea WineAppelationInfoText = new JFXTextArea("Fill in only if a wine appellation of origin is stated on the label");
                WineAppelationInfoText.setEditable(false);
                WineAppelationInfoText.setStyle("-fx-font-size: 14");
                VBox vBox11 = new VBox(WineAppelationInfoText);
                vBox11.setPrefSize(300, 150.0);
                vBox11.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox11.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver11 = new PopOver(vBox11);
                popOver11.show(WineAppelationInfo);
                break;
            case "PhoneInfo":
                JFXTextArea PhoneInfoText = new JFXTextArea("Provide the phone number of the person responsible for the application");
                PhoneInfoText.setEditable(false);
                PhoneInfoText.setStyle("-fx-font-size: 14");
                VBox vBox12 = new VBox(PhoneInfoText);
                vBox12.setPrefSize(300, 150.0);
                vBox12.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox12.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver12 = new PopOver(vBox12);
                popOver12.show(PhoneInfo);
                break;
            case "EmailInfo":
                JFXTextArea EmailInfoText = new JFXTextArea("You may provide the e-mail address of the person who should receive TTB's response to this application. TTB will process and return all paper applications to this e-mail address if one is provided.");
                EmailInfoText.setEditable(false);
                EmailInfoText.setStyle("-fx-font-size: 14");
                VBox vBox13 = new VBox(EmailInfoText);
                vBox13.setPrefSize(300, 150.0);
                vBox13.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox13.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver13 = new PopOver(vBox13);
                popOver13.show(EmailInfo);
                break;
            case "TypeAppInfo":
                JFXTextArea TypeAppInfoText = new JFXTextArea("You must check \"a\" or \"b\". You must also check \"c\" if you intend to bottle distilled spirits in a distinctive container. You must check \"d\" and enter the TTB ID number as shown in the upper left hand corner of the rejected application if you are submitting an application that was previously rejected. If you check \"b\" 1) you may only sell this product in the State where it is bolled AND 2) the statment \"For sale in ___ only\" (using State abbreviation) must appear on each container. We do not issue certificates of exemption for products imported in bottles or for malt beverages.");
                TypeAppInfoText.setEditable(false);
                TypeAppInfoText.setStyle("-fx-font-size: 14");
                VBox vBox14 = new VBox(TypeAppInfoText);
                vBox14.setPrefSize(300, 150.0);
                vBox14.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox14.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver14 = new PopOver(vBox14);
                popOver14.show(TypeAppInfo);
                break;
            case "AdditionalInfoInfo":
                JFXTextArea AdditionalInfoInfoText = new JFXTextArea("ADDITIONAL HELP!");
                AdditionalInfoInfoText.setEditable(false);
                AdditionalInfoInfoText.setStyle("-fx-font-size: 14");
                VBox vBox15 = new VBox(AdditionalInfoInfoText);
                vBox15.setPrefSize(300, 150.0);
                vBox15.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox15.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver15 = new PopOver(vBox15);
                popOver15.show(AdditionalInfoInfo);
                break;
            case "DateInfo":
                JFXTextArea DateInfoText = new JFXTextArea("Enter date application is prepared or submitted");
                DateInfoText.setEditable(false);
                DateInfoText.setStyle("-fx-font-size: 14");
                VBox vBox16 = new VBox(DateInfoText);
                vBox16.setPrefSize(300, 150.0);
                vBox16.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox16.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver16 = new PopOver(vBox16);
                popOver16.show(DateInfo);
                break;
            case "SignatureInfo":
                JFXTextArea SignatureInfoText = new JFXTextArea("The applicant or authorized agent must sign in this block");
                SignatureInfoText.setEditable(false);
                SignatureInfoText.setStyle("-fx-font-size: 14");
                VBox vBox17 = new VBox(SignatureInfoText);
                vBox17.setPrefSize(300, 150.0);
                vBox17.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox17.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver17 = new PopOver(vBox17);
                popOver17.show(SignatureInfo);
                break;
            case "LabelSubmitInfo":
                JFXTextArea LabelSubmitInfoText = new JFXTextArea("Picture/ scan must be in .pdf or .png format");
                LabelSubmitInfoText.setEditable(false);
                LabelSubmitInfoText.setStyle("-fx-font-size: 14");
                VBox vBox18 = new VBox(LabelSubmitInfoText);
                vBox18.setPrefSize(300, 150.0);
                vBox18.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox18.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver18 = new PopOver(vBox18);
                popOver18.show(LabelSubmitInfo);
                break;
            case "AlcoholPercentInfo":
                JFXTextArea AlcoholPercentInfoText = new JFXTextArea("Enter the actual alcohol percentage of your beverage");
                AlcoholPercentInfoText.setEditable(false);
                AlcoholPercentInfoText.setStyle("-fx-font-size: 14");
                VBox vBox19 = new VBox(AlcoholPercentInfoText);
                vBox19.setPrefSize(300, 150.0);
                vBox19.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                vBox19.setStyle("-fx-background-color: #9ea7aa");
                PopOver popOver19 = new PopOver(vBox19);
                popOver19.show(AlcoholPercentInfo);
                break;
        }

    }

}
