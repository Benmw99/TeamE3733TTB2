package UI;


import DB.Database;
import Entities.Agent;
import Entities.Form;
import Entities.Mailer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
@Deprecated
public class AgentController extends PageControllerUI  {


    @Override
   public void onLeave(){

   }
   @Override
   public void onLoad(){
   }

    //AgentSearch
    @FXML
    Button menuASButton;

    @FXML
    Button searchButton;

    @FXML
    TextField searchASField;

    @FXML
    TextField alcoholContentTextField;

    @FXML
    TextField brandNameTextField;

    @FXML
    TextField manField;

    @FXML
    TextField stateField;

    @FXML
    TextField dateField;

    @FXML
    TextField idField;

    //AgentSendToAgent
    @FXML
    Button menuASTAButton;

    @FXML
    Checkbox commentASTACheckbox;

    @FXML
    Button section1ASTAButton;

    @FXML
    Button section2ASTAButton;

    @FXML
    Button section3ASTAButton;

    @FXML
    Button section4ASTAButton;

    @FXML
    Button approveASTAButton;

    @FXML
    Button rejectASTAButton;

    @FXML
    Button sendToAgentASTAButton;

    @FXML
    Button feedbackASTAButton;

    @FXML
    Button printASTAButton;

    @FXML
    TextField agentField;

    @FXML
    TextField messageASTAField;

    @FXML
    Button sendASTAButton;

    //AgentFeedback
    @FXML
    Button menuAFButton;

    @FXML
    Checkbox commentAFCheckbox;

    @FXML
    Button section1AFButton;

    @FXML
    Button section2AFButton;

    @FXML
    Button section3AFButton;

    @FXML
    Button approveAFButton;

    @FXML
    Button rejectAFButton;

    @FXML
    Button sendToAgentAFButton;

    @FXML
    Button feedbackAFButton;

    @FXML
    Button printAFButton;

    @FXML
    TextField messageAFField;

    @FXML
    Button sendAFButton;

    //AgentApp1
    @FXML
    MenuButton menuAA1MenuButton;

    @FXML
    Button section1AA1Button;

    @FXML
    Button section2AA1Button;

    @FXML
    Button section3AA1Button;

    @FXML
    Button section4AA1Button;

    @FXML
    TextField repIDField;

    @FXML
    TextField producerNumField;

    @FXML
    TextField sourceField;

    @FXML
    TextField serialYearField;

    @FXML
    TextField serialDigitsField;

    @FXML
    TextField typeField;

    @FXML
    TextField brandField;

    @FXML
    Button prevSectionAA1Button;

    @FXML
    Button nextSectionAA1Button;

    //AgentApp2
    @FXML
    MenuButton menuAA2MenuButton;

    @FXML
    Button section1AA2Button;

    @FXML
    Button section2AA2Button;

    @FXML
    Button section3AA2Button;

    @FXML
    Button section4AA2Button;

    @FXML
    TextField fancifulField;

    @FXML
    TextField name8Field;

    @FXML
    ChoiceBox state8ChoiceBox;

    @FXML
    TextField address8Field;

    @FXML
    TextField city8Field;

    @FXML
    TextField zip8Field;

    @FXML
    RadioButton sameAddressRadioButton;

    @FXML
    RadioButton difAddressRadiobutton;

    @FXML
    TextField formulaField;

    @FXML
    TextField grapeVarField;

    @FXML
    TextField wineAppField;

    @FXML
    Button prevSectionAA2Button;

    @FXML
    Button nextSectionAA2Button;

    //AgentApp3
    @FXML
    MenuButton menuAA3MenuButton;

    @FXML
    Button section1AA3Button;

    @FXML
    Button section2AA3Button;

    @FXML
    Button section3AA3Button;

    @FXML
    Button section4AA3Button;

    @FXML
    TextField phoneNumField;

    @FXML
    TextField emailField;

    @FXML
    Checkbox certCheckbox;

    @FXML
    TextField state15Field;

    @FXML
    Checkbox liquorCheckbox;

    @FXML
    TextField amountField;

    @FXML
    Checkbox resubmitCheckbox;

    @FXML
    TextField TTBIDField;

    @FXML
    TextField additionalInfoField;

    @FXML
    TextField translationField;

    @FXML
    DatePicker appDate;

    @FXML
    Button prevSectionAA3Button;

    @FXML
    Button nextSectionAA3Button;

    //AgentApp4
    @FXML
    MenuButton menuAA4MenuButton;

    @FXML
    Button section1AA4Button;

    @FXML
    Button section2AA4Button;

    @FXML
    Button section3AA4Button;

    @FXML
    Button section4AA4Button;

    @FXML
    TextField signatureField;

    @FXML
    Button uploadLabelButton;

    @FXML
    Button prevSectionButton;

    @FXML
    Button submitButton;

    //AgentLogin
    @FXML
    Button agentRegisterButton;

    @FXML
    Button backButton;

    @FXML
    TextField nameField;

    @FXML
    TextField passField;

    @FXML
    TextField regNumField;

    @FXML
    Button loginButton;

    //AgentHome
    @FXML
    SplitMenuButton menuSplitButton;

    @FXML
    SplitMenuButton alcoholTypeSplitMenu;

    @FXML
    Button getnewQueueButton;

    @FXML
    TextField searchAHField;

    @FXML
    Button addAppButton;

    @FXML
    ToggleButton commentAHToggle;

    @FXML
    ToggleButton section1AHButton;

    @FXML
    ToggleButton section2AHButton;

    @FXML
    ToggleButton section3AHButton;

    @FXML
    Button approveAHButton;

    @FXML
    Button rejectAHButton;

    @FXML
    Button sendToAgentAHButton;

    @FXML
    Button feedbackAHButton;

    @FXML
    Button commentsAHButton;

    @FXML
    Button checkFormAHButton;

    @FXML
    Button printAHButton;

    //AgentViewForm

    @FXML
    Button reviewToolButton;

    @FXML
    ComboBox sectionMarkComboBox;

    @FXML
    MenuButton menuAVFMenuButton;

    @FXML
    CheckBox commentAVFCheckBox;

    @FXML
    Button section1AVFButton;

    @FXML
    Button agentBackToHomeButton;

    @FXML
    Button section2AVFButton;

    @FXML
    Button section3AVFButton;

    @FXML
    Button approveAVFButton;

    @FXML
    Button rejectAVFButton;

    @FXML
    Button sendToAgentAVFButton;

    @FXML
    Button feedbackAVFButton;

    @FXML
    Button printAVFButton;

    //AgentViewLabel
    @FXML
    MenuButton menuAVLMenuButton;

    @FXML
    Checkbox commentAVLCheckbox;

    @FXML
    Button section1AVLButton;

    @FXML
    Button section2AVLButton;

    @FXML
    Button section3AVLButton;

    @FXML
    Button approveAVLButton;

    @FXML
    Button rejectAVLButton;

    @FXML
    Button sendToAgentAVLButton;

    @FXML
    Button feedbackAVLButton;

    @FXML
    Button printAVLButton;

    @FXML
    Label appNum1;

    @FXML
    Label  appStat1;

    @FXML
    Label expirDate1;

    @FXML
    Label appDate1;

    @FXML
    Label appNum2;

    @FXML
    Label appStat2;

    @FXML
    Label expirDate2;

    @FXML
    Label appDate2;

    @FXML
    Label appNum3;

    @FXML
    Label appStat3;

    @FXML
    Label expirDate3;

    @FXML
    Label appDate3;

    //Form Labels
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
    TableView<Form> formTable;
    @FXML
    TableColumn<Form, Integer> tTBIDColumn;
    @FXML
    TableColumn<Form, Timestamp> dateSubmittedColumn;
    @FXML
    TableColumn<Form, String> brandNameColumn;



    static private Form currentForm;
    private static Agent currentAgent;
    static private List<Form> queue;
    static AudioClip reject;
    static AudioClip accept;

    @FXML
    protected void initialize(){
        if(currentForm != null) {
        }
        File rej = new File("assets/reject.mp3");
        reject = new AudioClip(rej.toURI().toString());
        File acc = new File("assets/accept.mp3");
        accept = new AudioClip(acc.toURI().toString());
    }

    @FXML
    public void login(ActionEvent event) throws IOException {
        currentAgent = new Agent(nameField.getText(),passField.getText());
        if(currentAgent.authenticate()) {
            currentAgent.loadUser();
            pageSwitch(event, "AgentHome.fxml", loginButton);

            //TODO WRITE THIS TO USE THE GET QUEUE FOR AGENT FUNCTION IN DB, USING THE AGENT AS AN IN-BETWEEN
            //queue = currentAgent.getThreeForms();

            System.out.println(queue.size());
         //   currentForm = queue.get(0);

        }
        else {
            Alert loginFailure = new Alert(Alert.AlertType.WARNING);
            loginFailure.setContentText("Invalid Password or Username");
            loginFailure.showAndWait();
        }
    }

    @FXML
    public void selectForm(ActionEvent event) throws IOException {
        pageSwitch(event, "AgentHome.fxml", backButton);
    }

    @FXML
    public void welcomePage(ActionEvent event) throws IOException {
        pageSwitch(event, "WelcomePage.fxml", backButton);

    }

    @FXML
    public void goBackToAgentHome(ActionEvent event) throws IOException {
        pageSwitch(event, "AgentHome.fxml", agentBackToHomeButton);
    }


    @FXML
    public void reviewTool(ActionEvent event) throws IOException {
        pageSwitch(event, "AgentViewForm.fxml", reviewToolButton);
    }

    @FXML
    public void agentViewForm(ActionEvent event) throws IOException {
        //TODO:have to load selected form somehow
        pageSwitch(event, "AgentViewForm.fxml", backButton);
    }
    @FXML
    public void rejectForm(ActionEvent event) throws IOException {
        currentAgent.rejectForm(currentForm);
        queue.remove(currentForm);
  //      pageSwitch(event, "AgentHome.fxml", backButton);
        tTBIDColumn.setCellValueFactory(new PropertyValueFactory<>("ttbID"));
        dateSubmittedColumn.setCellValueFactory(new PropertyValueFactory<>("dateSubmitted"));
        brandNameColumn.setCellValueFactory(new PropertyValueFactory<>("brandName"));

        tableView();

        ObservableList<Form> tableValues = FXCollections.observableArrayList();
        for (int i = 0; i < queue.size(); i++) {
            tableValues.add(queue.get(i));
        }
        formTable.setItems(tableValues);
        printAHButton.setDisable(false);
        Thread mailThread = new Thread( new Mailer(AttributeContainer.getInstance().currentForm));
        mailThread.start();

        reject.play();
    }
    @FXML
    public void approveForm(ActionEvent event) throws IOException {

        currentAgent.approveForm(currentForm, " ");
        queue.remove(currentForm);
    //    pageSwitch(event, "AgentHome.fxml", backButton);
        tTBIDColumn.setCellValueFactory(new PropertyValueFactory<>("ttbID"));
        dateSubmittedColumn.setCellValueFactory(new PropertyValueFactory<>("dateSubmitted"));
        brandNameColumn.setCellValueFactory(new PropertyValueFactory<>("brandName"));

        tableView();

        ObservableList<Form> tableValues = FXCollections.observableArrayList();
        tableValues.remove(currentForm);
        for (int i = 0; i < queue.size(); i++) {
            tableValues.add(queue.get(i));
        }
        formTable.setItems(tableValues);
        printAHButton.setDisable(false);
        Thread mailThread = new Thread(new Mailer(currentForm));
        mailThread.start();
        accept.play();
    }

    public void tableView()  {
        formTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            /**
             * Makes it so that, if you click on a row of the Table, a form is loaded based on that TTB_ID
             */
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    @SuppressWarnings("rawtypes")
                    TablePosition pos = formTable.getSelectionModel().getSelectedCells().get(0);
                    int row = pos.getRow();
                    int col = pos.getColumn();
                    int ID = tTBIDColumn.getCellData(row);
                    System.out.println(ID);
                    currentForm = Database.getDatabase().dbSelect.getFormByTTB_ID(ID);
                //    FormDisplayHelper.displayForm(currentForm);
                }
            }
        });
    //    ObservableList<Form> tableValues = FXCollections.observableArrayList();

    }




    /* not needed for it. 1
    @FXML
    public void approveFormConditions(ActionEvent event) throws IOException {
        this.currentForm.approve(this.currentAgent, StringConditions);
        pageSwitch(event, "AgentHome.fxml", backButton);
    }
    @FXML
    public void rejectFormFeedback(ActionEvent event) throws IOException {
        this.currentForm.approve(this.currentAgent, String feedback);
        pageSwitch(event, "AgentHome.fxml", backButton);
    }
    */

    public void pageSwitch(ActionEvent event, String filename, Button b) throws IOException{
        Parent root;
        Stage stage;
        stage=(Stage) b.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(filename));
        Scene scene = new Scene(root, 1360, 760);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void getNewQueue(ActionEvent event) throws IOException{
     //TODO REWRITE THIS USING THE CORRECT QUEUE METHODS
        //queue = currentAgent.getThreeForms();

        tTBIDColumn.setCellValueFactory(new PropertyValueFactory<>("ttbID"));
        dateSubmittedColumn.setCellValueFactory(new PropertyValueFactory<>("dateSubmitted"));
        brandNameColumn.setCellValueFactory(new PropertyValueFactory<>("brandName"));

        tableView();

        ObservableList<Form> tableValues = FXCollections.observableArrayList();
        for (int i = 0; i < queue.size(); i++) {
            tableValues.add(queue.get(i));
        }
        formTable.setItems(tableValues);
        printAHButton.setDisable(false);
    }







    @FXML
    public void setPage1(){
/*
        Agent1Label.setText(currentForm.getRepID());
        ArrayList<String> arr = currentForm.getBrewersPermit();
        arr.add(producerNumField.getText());
        Agent2Label.setText(arr.toString());
        Agent3Label.setText("Is Domestic? " + currentForm.getSource());
        AgentReview4Label1.setText(currentForm.getSerialNumber());
        Agent5Label1.setText(currentForm.getAlcoholType().toString());
        Agent6Label.setText(currentForm.getBrandName());
   */ }

    public void setPage2(){
/*        Agent7Label.setText(currentForm.getFancifulName());
        Agent8Label.setText(currentForm.getAddress().toString());
        Agent9Label.setText(currentForm.getMailingAddress().toString());
        Agent10Label.setText(currentForm.getFormula());
        Agent11Label.setText(currentForm.getWineFormItems().getGrapeVarietal());
        Agent12Label.setText(currentForm.getWineFormItems().getAppellation());
  */  }

    public void setPage3(){
    /*    Agent13Label.setText(currentForm.getPhoneNumber());
        Agent14Label.setText(currentForm.getEmail());
        Agent16Label1.setText(currentForm.getBlownBrandedEmbossedInfo());
        Agent16Label2.setText(currentForm.getDateSubmitted().toString());
*/    }

    public void setPage4(){
  //      Agent18Label.setText("" + currentForm.getAlcoholContent());
    }

}
