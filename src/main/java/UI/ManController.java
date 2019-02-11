package UI;

import DB.Database;
import Entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.commons.lang3.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class ManController {
    Entities.Form currentForm;
    private int currentFormPage;

    static Manufacturer manufacturer;
    Entities.Form form;
    static Entities.Form newForm;

    static Form view;
    //ManHome
    @FXML
    SplitMenuButton menuSplitButton;

    @FXML
    SplitMenuButton alcoholTypeSplitMenu;

    @FXML
    static TextField searchMHField;

    @FXML
    Button logOutButton;

    @FXML
    Button addAppButton;

    @FXML
    ToggleButton editToggle;

    @FXML
    Button downloadButton;

    @FXML
    Button commentsButton;

    @FXML
    Button printButton;

    //ManLogin

    @FXML
    Button manRegisterButton;

    @FXML
    Button backButton;

    @FXML
    TextField nameField;

    @FXML
    TextField passField;

    @FXML
    TextField idLoginField;

    @FXML
    Button loginButton;

    @FXML
    Button faqButton;

    @FXML
    Button search1Button;

    //ManProfile
    @FXML
    Button menuMPButton;

    @FXML
    Button menuMSButton;

    @FXML
    TextField searchMSField;

    @FXML
    TextField manField;

    @FXML
    TextField stateField;

    @FXML
    TextField cityField;

    @FXML
    TextField dateField;

    @FXML
    TextField idField;

    //ManFAQ
    @FXML
    Button menuFAQButton;

    @FXML
    MenuButton catMenuButton;

    @FXML
    TextField searchFAQField;

    //ManApp1
    @FXML
    MenuButton menuMA1MenuButton;

    @FXML
    TextField repIDField;

    @FXML
    TextField producerNumField;

    @FXML
    ComboBox<String> sourceComboBox;

    @FXML
    TextField serialYearField;

    @FXML
    TextField serialDigitsField;

    @FXML
    ComboBox<String> typeComboBox;

    @FXML
    TextField vintageYearField;

    @FXML
    TextField phField;

    @FXML
    TextField alcoholContentTextField;

    @FXML
    TextField brandNameTextField;

    @FXML
    TextField brandField;

    @FXML
    Button prevSectionMA1Button;

    @FXML
    Button nextSectionMA1Button;

    @FXML
    TextField fancifulField;

    @FXML
    TextField name8Field;

    @FXML
    ComboBox<String> state8ComboBox;

    @FXML
    TextField address8Field;

    @FXML
    TextField city8Field;

    @FXML
    TextField zip8Field;

    @FXML
    RadioButton sameAddressRadioButton;

    @FXML
    TextField name9Field;

    @FXML
    ComboBox<String> state9ComboBox;

    @FXML
    TextField address9Field;

    @FXML
    TextField city9Field;

    @FXML
    TextField zip9Field;

    @FXML
    TextField formulaField;

    @FXML
    TextField grapeVarField;

    @FXML
    TextField wineAppField;

    @FXML
    Button prevSectionMA2Button;

    @FXML
    Button nextSectionMA2Button;

    @FXML
    TextField phoneNumField;

    @FXML
    TextField emailField;

    @FXML
    CheckBox certCheckbox;

    @FXML
    TextField state15Field;

    @FXML
    CheckBox liquorCheckbox;

    @FXML
    TextField amountField;

    @FXML
    CheckBox resubmitCheckbox;

    @FXML
    TextField TTBIDField;

    @FXML
    TextField additionalInfoField;

    @FXML
    TextField translationField;

    @FXML
    DatePicker appDate;

    @FXML
    Button prevSectionMA3Button;

    @FXML
    Button nextSectionMA3Button;

    //ManApp4
    @FXML
    MenuButton menuMA4MenuButton;

    @FXML
    TextField signatureField;

    @FXML
    Button uploadLabelButton;

    @FXML
    Button prevSectionMA4Button;

    @FXML
    Button submitButton;

    @FXML
    Button refresh;

    @FXML
    TableView<Form> tableViewMan;

    @FXML
    TableColumn<Form, Integer> col1;

    @FXML
    TableColumn<Form, Timestamp> col2;

    @FXML
    TableColumn<Form, String> col3;

    @FXML
    TableColumn<Form, ApprovalStatus> col4;

    @FXML
    TableColumn<Form, Timestamp> col5;

    @FXML
    TableColumn<Form, String> col6;



    public void tableView()  {
        List<Form> forms = manufacturer.loadForms();

        col1.setCellValueFactory(new PropertyValueFactory<>("ttbID"));
        col2.setCellValueFactory(new PropertyValueFactory<>("dateSubmitted"));
        col3.setCellValueFactory(new PropertyValueFactory<>("approvalStatus"));
        col4.setCellValueFactory(new PropertyValueFactory<>("approval.timestamp"));
        col5.setCellValueFactory(new PropertyValueFactory<>("approval.expDate"));
        col6.setCellValueFactory(new PropertyValueFactory<>("approval.agentApprovalName"));
        tableViewMan.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            /**
             * Makes it so that, if you click on a row of the Table, a form is loaded based on that TTB_ID
             */
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    @SuppressWarnings("rawtypes")
                    TablePosition pos = tableViewMan.getSelectionModel().getSelectedCells().get(0);
                    int row = pos.getRow();
                    int col = pos.getColumn();
                    int ID = col1.getCellData(row);
                    displayForm(Database.getInstance().dbSelect.getFormByTTB_ID(ID));
                }
            }
        });
        ObservableList<Form> tableValues = FXCollections.observableArrayList();
        for (int i = 0; i < forms.size(); i++) {
            tableValues.add(forms.get(i));
        }
        tableViewMan.setItems(tableValues);

    }

    protected void displayForm(Form form){
        Man1Label.setText("N/A");
        Man2Label.setText("N/A");
        Man3Label.setText("N/A");
        ManReview4Label1.setText("N/A");
        Man4Label2.setText("N/A");
        Man5Label1.setText("N/A");
        Man5Label2.setText("N/A");
        Man5Label3.setText("N/A");
        Man6Label.setText("N/A");
        Man7Label.setText("N/A");
        Man8Label.setText("N/A");
        Man9Label.setText("N/A");
        Man10Label.setText("N/A");
        Man11Label.setText("N/A");
        Man12Label.setText("N/A");
        Man13Label.setText("N/A");
        Man14Label.setText("N/A");
        Man15Label1.setText("N/A");
        Man16Label1.setText("N/A");
        Man16Label2.setText("N/A");
        Man17Label.setText("N/A");
        Man20Label.setText("N/A");
        Man1Label.setText(form.getRepID());
        if(!form.getBrewersPermit().isEmpty()){
            Man2Label.setText(form.getBrewersPermit().get(0));
        }
        String dom;
            if(form.getSource()){
                dom = "IMPORTED";
            } else {
                dom = "DOMESTIC";
            }
        Man3Label.setText(dom);
            if(form.getSerialNumber() != null) {
                ManReview4Label1.setText(form.getSerialNumber().substring(0, 2)); //First 2
                Man4Label2.setText(form.getSerialNumber().substring(2)); //Rest
            }
            if(form.getAlcoholType() != null) {
                Man5Label1.setText(form.getAlcoholType().toString()); //Type of Product
            }
            if(form.getWineFormItems() != null) {
                Man5Label2.setText("" + form.getWineFormItems().getVintageYear()); //Vintage year
                Man5Label3.setText(String.valueOf(form.getWineFormItems().getpH()));
                if(form.getWineFormItems().getGrapeVarietal() != null){
                    Man11Label.setText(form.getWineFormItems().getGrapeVarietal());
                }
                if(form.getWineFormItems().getAppellation() != null){
                    Man12Label.setText(form.getWineFormItems().getAppellation());
                }
            }
            if(form.getBrewersPermit() != null){

            }
            if(form.getBrandName() != null) {
                Man6Label.setText(form.getBrandName());
            } else {
                Man6Label.setText("N/A");
            }
            if(form.getFancifulName() != null) {
                Man7Label.setText(form.getFancifulName());
            }
            if(form.getMailingAddress() != null) {
                Man8Label.setText(form.getMailingAddress().getName());
                Address add = form.getMailingAddress();
                String addy = add.getName() + "\n" + add.getStreet() + "\n" + add.getCity() +
                        "\n" + add.getState() + "\n" + add.getZip();
                Man9Label.setText(addy);
            }
            if(form.getFormula() != null) {
                Man10Label.setText(form.getFormula());
            }

            if(form.getPhoneNumber() != null) {
                Man13Label.setText(form.getPhoneNumber());
            }
            if(form.getEmail() != null) {
                Man14Label.setText(form.getEmail());
            }
//        Man15Label1.setText(); //TODO TYPE OF APPLICATION
//        Man15Label2.setText();
//        Man15Label3.setText(); //END TODO
        if(form.getBlownBrandedEmbossedInfo() != null) {
            Man16Label1.setText(form.getBlownBrandedEmbossedInfo());
        }
//        Man16Label2.setText(); //TODO TRANSLATION
        if(form.getDateSubmitted() != null) {
            Man17Label.setText(form.getDateSubmitted().toString());
        }
            Man20Label.setText(String.valueOf(form.getAlcoholContent()));
    }

    //FORM labels
    @FXML
    Label Man1Label;
    @FXML
    Label Man2Label;
    @FXML
    Label Man3Label;
    @FXML
    Label ManReview4Label1;
    @FXML
    Label Man4Label2;
    @FXML
    Label Man5Label1;
    @FXML
    Label Man5Label2;
    @FXML
    Label Man5Label3;
    @FXML
    Label Man6Label;
    @FXML
    Label Man7Label;
    @FXML
    Label Man8Label;
    @FXML
    Label Man9Label;
    @FXML
    Label Man10Label;
    @FXML
    Label Man11Label;
    @FXML
    Label Man12Label;
    @FXML
    Label Man13Label;
    @FXML
    Label Man14Label;
    @FXML
    Label Man15Label1;
    @FXML
    Label Man15Label2;
    @FXML
    Label Man15Label3;
    @FXML
    Label Man16Label1;
    @FXML
    Label Man16Label2;
    @FXML
    Label Man17Label;
    @FXML
    Label Man18Label;
    @FXML
    Label Man20Label;



    @FXML
    protected void initialize(){
        if(this.currentFormPage == 1){

        }
    }


    @FXML
    public void logOut(ActionEvent event) throws IOException {
        pageSwitch(event, "WelcomePage.fxml", logOutButton);
        currentFormPage = 1;
    }

    @FXML
    public void manApp1(ActionEvent event) throws IOException {
        pageSwitch(event, "ManApp1.fxml", addAppButton);
        currentFormPage = 1;
    }

    //back buttons
    @FXML
    public void welcomePage(ActionEvent event) throws IOException {
        pageSwitch(event, "WelcomePage.fxml", backButton);
    }
    @FXML
    public void manLogin(ActionEvent event) throws IOException {
        newForm = new Form();
        pageSwitch(event, "ManLogin.fxml", backButton);
    }
    @FXML
    public void manHome(ActionEvent event) throws IOException {
        pageSwitch(event, "ManHome.fxml", backButton);
    }

    //move up pages by arrows from ManApp1
    @FXML
    public void manApp2d(ActionEvent event) throws IOException {
        pageSwitch(event, "ManApp2.fxml", nextSectionMA1Button);
        currentFormPage = 2;
    }

    //move up pages by arrows from ManApp2
    @FXML
    public void manApp3d(ActionEvent event) throws IOException {
        pageSwitch(event, "ManApp3.fxml", nextSectionMA2Button);
    }
    //move down pages by arrows from ManApp2
    @FXML
    public void manApp3e(ActionEvent event) throws IOException {
        pageSwitch(event, "ManApp1.fxml", prevSectionMA2Button);
    }

    //move up pages by arrows from ManApp3
    @FXML
    public void manApp4d(ActionEvent event) throws IOException {
        pageSwitch(event, "ManApp4.fxml", nextSectionMA3Button);
    }
    //move down pages by arrows from ManApp3
    @FXML
    public void manApp4e(ActionEvent event) throws IOException {
        pageSwitch(event, "ManApp2.fxml", prevSectionMA3Button);
    }

    //move down pages by arrows from ManApp3
    @FXML
    public void manApp5d(ActionEvent event) throws IOException {
        pageSwitch(event, "ManApp3.fxml", prevSectionMA4Button);
    }

    //manHome
    public void goHome(ActionEvent event) throws IOException {
        menuSwitch(event, "ManHome.fxml", menuMA1MenuButton);
    }

    ///manApp
    @FXML
    public void newApp(ActionEvent event) throws IOException {
        this.currentForm = new Entities.Form();
   //     this.newForm = new Form();
        pageSwitch(event, "ManApp1.fxml", backButton);
    }

    @FXML
    public void appNext(ActionEvent event) throws IOException {

        if(this.currentFormPage<4) this.currentFormPage++;
        String page = "ManApp"+Integer.toString(this.currentFormPage)+".fxml";
        pageSwitch(event, page, backButton);
    }

    @FXML
    public void appBack(ActionEvent event) throws IOException {
        if(this.currentFormPage>1) this.currentFormPage--;
        String page = "ManApp"+Integer.toString(this.currentFormPage)+".fxml";
        pageSwitch(event, page, backButton);
    }

    public void pageSwitch(ActionEvent event, String filename, Button b) throws IOException{
        Parent root;
        Stage stage;
        stage=(Stage) b.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(filename));
        Scene scene = new Scene(root, 1360, 760);
        stage.setScene(scene);
        stage.show();
    }

    /**
     *
     * @param event still not used
     * @param filename name of FXML file you wish to load
     * @param b button
     * @throws IOException
     */
    public void menuSwitch(ActionEvent event, String filename, MenuButton b) throws IOException{
        Parent root;
        Stage stage;
        stage=(Stage) b.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(filename));
        Scene scene = new Scene(root, 1360, 760);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void correctLogin(ActionEvent event) throws IOException{
        this.manufacturer = new Manufacturer(nameField.getText(), passField.getText());
        if(this.manufacturer.authenticate()){
            pageSwitch(event, "ManHome.fxml", loginButton);
            this.manufacturer = Database.getInstance().dbSelect.getManufacturer(this.manufacturer.getLogin());
        }
        else{
            //pageSwitch(event, "ManHome.fxml", loginButton);
            Alert incorrectLogin = new Alert(Alert.AlertType.WARNING);
            incorrectLogin.setTitle("Incorrect Login");
            incorrectLogin.setContentText("You have entered the incorrect login information. Please try again.");
            incorrectLogin.show();
        }
    }

    // Checks through the first page of the full TTB application to see if any of the text fields are blank.
    // If they are all filled, then the user can move on to the second page
    @FXML
    public void checkBlanksPage1(ActionEvent event) throws IOException{
        if(this.newForm == null) {
            this.newForm = new Form();
        }
        this.newForm.setRepID(repIDField.getText());
        this.newForm.getBrewersPermit().add(producerNumField.getText());
        ArrayList<String> los = new ArrayList<String>();
        los.add(producerNumField.getText());
        newForm.setBrewersPermit(los);
        this.newForm.setSource(sourceComboBox.getValue().equals("Imported"));
        this.newForm.setSerialNumber(serialYearField.getText() + serialDigitsField.getText());
        if(typeComboBox.getValue().equals("Wine")){
            this.newForm.setAlcoholType(AlcoholType.Wine);
            WineFormItems wine = new WineFormItems();
            wine.setVintageYear(Integer.valueOf(vintageYearField.getText()));
            wine.setpH(Float.valueOf(phField.getText()));
            this.newForm.setWineFormItems(wine);
        } else if (typeComboBox.getValue().equals("Distilled Spirits")){
            this.newForm.setAlcoholType(AlcoholType.DistilledLiquor);
        } else {
            this.newForm.setAlcoholType(AlcoholType.MaltBeverage);
        }
        this.newForm.setBrandName(brandField.getText());
        if(StringUtils.isBlank(this.newForm.getSerialNumber())|| StringUtils.isBlank(this.newForm.getBrandName())){
            System.out.println("I'm stuck thinking things aren't filled in");
            Alert missingTextFieldPage1 = new Alert(Alert.AlertType.WARNING);
            missingTextFieldPage1.setTitle("Missing Text Field");
            missingTextFieldPage1.setContentText("You have forgotten to fill out a text field. Please do so before moving on.");
            missingTextFieldPage1.show();
        }
        else{
            currentFormPage = 2;
            pageSwitch(event, "ManApp2.fxml", nextSectionMA1Button);
        }
    }

    // Checks through the second page of the full TTB application to see if any of the text fields are blank.
    // If they are all filled, then the user can move on to the third page
    @FXML
    public void checkBlanksPage2(ActionEvent event) throws IOException{

        this.newForm.setFancifulName(fancifulField.getText());
        if(zip9Field.getText().length() > 5 || zip8Field.getText().length() > 5){
            Alert missingTextFieldPage2 = new Alert(Alert.AlertType.WARNING);
            missingTextFieldPage2.setTitle("Missing Text Field");
            missingTextFieldPage2.setContentText("A Zip Code can only be five digits.");
            missingTextFieldPage2.show();
        }
        Address address = new Address(city8Field.getText(), state8ComboBox.getValue(), zip8Field.getText(), address8Field.getText(), name8Field.getText());
        ArrayList<Address> arr = new ArrayList<Address>();
        arr.add(address);
        this.newForm.setAddress(arr);  //need more addresses option in ui
        if(sameAddressRadioButton.isSelected()){
            this.newForm.setMailingAddress(address);
        }else {
            Address address1 = new Address(city9Field.getText(), state9ComboBox.getValue(), zip9Field.getText(), address9Field.getText(), name9Field.getText());
            this.newForm.setMailingAddress(address1);
        }
        this.newForm.setFormula(formulaField.getText());
        if(this.newForm.getAlcoholType()== AlcoholType.Wine){
            this.newForm.getWineFormItems().setGrapeVarietal(grapeVarField.getText());
            this.newForm.getWineFormItems().setAppellation(wineAppField.getText());
        }
        if(StringUtils.isBlank(this.newForm.getFancifulName())){
            Alert missingTextFieldPage2 = new Alert(Alert.AlertType.WARNING);
            missingTextFieldPage2.setTitle("Missing Text Field");
            missingTextFieldPage2.setContentText("You have forgotten to fill out a text field. Please do so before moving on.");
            missingTextFieldPage2.show();
        }
        else{
            currentFormPage = 3;
            pageSwitch(event, "ManApp3.fxml", nextSectionMA2Button);
        }
    }

    // Checks through the third page of the full TTB application to see if any of the text fields are blank.
    // If they are all filled, then the user can move on to the fourth page
    @FXML
    public void checkBlanksPage3(ActionEvent event) throws IOException{

        this.newForm.setPhoneNumber(phoneNumField.getText());
        this.newForm.setEmail(emailField.getText());

        //TODO
        // Add types of applications in future iterations
        //
        this.newForm.setBlownBrandedEmbossedInfo(additionalInfoField.getText());
        this.newForm.setDateSubmitted(Timestamp.from(Instant.now()));
        if(StringUtils.isBlank(this.newForm.getPhoneNumber()) || StringUtils.isBlank(this.newForm.getEmail())){
            Alert missingTextFieldPage1 = new Alert(Alert.AlertType.WARNING);
            missingTextFieldPage1.setTitle("Missing Text Field");
            missingTextFieldPage1.setContentText("You have forgotten to fill out a text field. Please do so before moving on.");
            missingTextFieldPage1.show();
        }
        else{
            currentFormPage = 4;
            pageSwitch(event, "ManApp4.fxml", nextSectionMA3Button);
        }
    }

    /**
     * Checks if the combobox is on wine and displays the appropriate text fields
     *
     * @throws IOException
     */
    @FXML
    public void checkWine() throws IOException{
        if (typeComboBox.getValue().equals("Wine")){
            vintageYearField.disableProperty().setValue(false);
            phField.disableProperty().setValue(false);

        }
        else{
            vintageYearField.disableProperty().setValue(true);
            vintageYearField.setText("");
            phField.disableProperty().setValue(true);
            phField.setText("");
        }
    }

    /**
     * Will disable and reset fields is they select the button "same as question 8"
     *
     * @throws IOException someone help me here, it throws errors, but works anyways
     */
    @FXML
    public void checkMail() throws IOException{
        if (sameAddressRadioButton.isSelected()){
            name9Field.setEditable(false);
            name9Field.setDisable(true);
            name9Field.setText("");
            state9ComboBox.setDisable(true);
            state9ComboBox.setPromptText("State");
            address9Field.setEditable(false);
            address9Field.setText("");
            address9Field.setDisable(true);
            city9Field.setEditable(false);
            city9Field.setText("");
            city9Field.setDisable(true);
            zip9Field.setEditable(false);
            zip9Field.setText("");
            zip9Field.setDisable(true);
        }

        else{
            name9Field.setEditable(true);
            name9Field.setDisable(false);
            state9ComboBox.setDisable(false);
            state9ComboBox.setPromptText("State");
            address9Field.setEditable(true);
            address9Field.setDisable(false);
            city9Field.setEditable(true);
            city9Field.setDisable(false);
            zip9Field.setEditable(true);
            zip9Field.setDisable(false);
        }
    }

    @FXML
    public void checkAndSubmitForm(ActionEvent event ) throws IOException {
        if(alcoholContentTextField.getText() != null && !alcoholContentTextField.getText().trim().equals("") && alcoholContentTextField.getText().length() > 0) {
            this.newForm.setAlcoholContent(Float.parseFloat(alcoholContentTextField.getText()));
            this.manufacturer.submitForm(this.newForm);
            System.out.println("Form Submitted");
            pageSwitch(event, "ManHome.fxml", submitButton);
            //tableView();
        } else {
            Alert missingTextFieldPage1 = new Alert(Alert.AlertType.WARNING);
            missingTextFieldPage1.setTitle("Missing Text Field");
            missingTextFieldPage1.setContentText("You have forgotten to fill out a text field. Please do so before moving on.");
            missingTextFieldPage1.show();
        }
    }

    /**
     * Sets the listener for each fx:id. Note, the listener only starts once an action occurs on one of the textfields.
     * After the initial action, it should begin listening for all buttons
     *
     * @throws IOException
     */
    @FXML
    public void limitManFieldsNum1() throws IOException{
        onlyNums(repIDField);
        onlyNums(producerNumField);
        onlyNums(serialYearField);
        onlyNums(serialDigitsField);
        onlyNums(vintageYearField);
        onlyNums(phField);
    }
    @FXML
    public void limitManFieldsNum2() throws IOException{
        checkZip(zip8Field);
        checkZip(zip9Field);
    }

    /**
     * Begins a listener for a textfield that will make it impossible to enter letters
     *
     * @param field this is the fx:id for the textfield that you wish to only accept nums
     * @throws IOException will throw exception if you try call in a scene that's not loaded
     */
    public void onlyNums(TextField field) throws IOException {
        field.getProperties().put("vkType", "numeric");
        field.setTextFormatter(new TextFormatter<>(c -> {
            if (c.isContentChange()) {
                if (c.getControlNewText().length() == 0) {
                    return c;
                }
                try {
                    Integer.parseInt(c.getControlNewText());
                    return c;
                } catch (NumberFormatException e) {
                }
                return null;
            }
            return c;
        }));
    }

    /**
     * Begins a listener for a textfield that will make it impossible to enter letters and numbers more than
     *
     * @param field this is the fx:id for the textfield that you wish to only accept nums
     * @throws IOException someone help me here, it throws errors, but works anyways
     */
    public void checkZip(TextField field) throws IOException {

        field.getProperties().put("vkType", "numeric");
        field.setTextFormatter(new TextFormatter<>(c -> {
            if (c.isContentChange()) {
                if (c.getControlNewText().length() == 0) {
                    return c;
                }
                try {
                    Integer.parseInt(c.getControlNewText());
                    if((c.getControlNewText().length()) < 10)
                    return c;
                } catch (NumberFormatException e) {
                }

                return null;
            }
            return c;
        }));
    }
}