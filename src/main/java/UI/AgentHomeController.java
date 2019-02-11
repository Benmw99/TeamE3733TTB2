package UI;

import DB.Database;
import Entities.Agent;
import Entities.AlcoholType;
import Entities.Form;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.IOException;
import java.sql.Timestamp;

public class AgentHomeController extends PageControllerUI implements IFormDisplay, IExport, ITableView, ILogOut {

   //From IFormDisplay
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


    //From IExport
    @FXML
    Button PrintButton;

    @FXML
    Button SaveToCSVButton;

    @FXML
    Button AsciiDelimitedFileButton;

    //From ITableView
    @FXML
    TableView<Form> FormTable;

    @FXML
    TableColumn<Form, Integer> TTBIDColumn;

    @FXML
    TableColumn<Form, Timestamp> DateSubmittedColumn;

    @FXML
    TableColumn<Form, String> BrandNameColumn;

    @FXML
    TableColumn<Form, AlcoholType> TypeColumn;

    @FXML
    TableColumn<Form, String> BrandColumn;

    @FXML
    TableColumn<Form, String> SerialColumn;

    //From ILogOut
    @FXML
    Button LogOutButton;


    @Override
    public Button getPrintButton() {
        return PrintButton;
    }

    @Override
    public Button getSaveToCSVButton() {
        return SaveToCSVButton;
    }

    @Override
    public Button getAsciiDelimitedFileButton() {
        return AsciiDelimitedFileButton;
    }

    FormDisplayHelper formDisplayHelper;

     @Override
     public void setFormDisplayHelper(FormDisplayHelper helper) {
         formDisplayHelper = helper;
     }

     @Override
    public Label getDisplay1Label() {
        return Display1Label;
    }

    @Override
    public Label getDisplay2Label() {
        return Display2Label;
    }

    @Override
    public Label getDisplay3Label() {
        return Display3Label;
    }

    @Override
    public Label getDisplayReview4Label1() {
        return DisplayReview4Label1;
    }

    @Override
    public Label getDisplay4Label2() {
        return Display4Label2;
    }

    @Override
    public Label getDisplay5Label1() {
        return Display5Label1;
    }

    @Override
    public Label getDisplay5Label2() {
        return Display5Label2;
    }

    @Override
    public Label getDisplay5Label3() {
        return Display5Label3;
    }

    @Override
    public Label getDisplay6Label() {
        return Display6Label;
    }

    @Override
    public Label getDisplay7Label() {
        return Display7Label;
    }

    @Override
    public Label getDisplay8Label() {
        return Display8Label;
    }

    @Override
    public Label getDisplay9Label() {
        return Display9Label;
    }

    @Override
    public Label getDisplay10Label() {
        return Display10Label;
    }

    @Override
    public Label getDisplay11Label() {
        return Display11Label;
    }

    @Override
    public Label getDisplay12Label() {
        return Display12Label;
    }

    @Override
    public Label getDisplay13Label() {
        return Display13Label;
    }

    @Override
    public Label getDisplay14Label() {
        return Display14Label;
    }

    @Override
    public Label getDisplay15Label1() {
        return Display15Label1;
    }

    @Override
    public Label getDisplay15Label2() {
        return Display15Label2;
    }

    @Override
    public Label getDisplay15Label3() {
        return Display15Label3;
    }

    @Override
    public Label getDisplay16Label1() {
        return Display16Label1;
    }

    @Override
    public Label getDisplay16Label2() {
        return Display16Label2;
    }

    @Override
    public Label getDisplay17Label() {
        return Display17Label;
    }

    @Override
    public Label getDisplay18Label() {
        return Display18Label;
    }

    @Override
    public Label getDisplay20Label() {
        return Display20Label;
    }

    TableViewHelper tableViewHelper;
    @Override
    public void setTableViewHelper(TableViewHelper helper) {
        tableViewHelper = helper;
    }
    @Override
    public Button getLogOutButton() {
        return LogOutButton;
    }

    @Override
    public TableView<Form> getFormTable() {
        return FormTable;
    }

    @Override
    public TableColumn<Form, Integer> getTTBIDColumn() {
        return TTBIDColumn;
    }

    @Override
    public TableColumn<Form, Timestamp> getDateSubmittedColumn() {
        return DateSubmittedColumn;
    }

    @Override
    public TableColumn<Form, String> getBrandNameColumn() {
        return BrandNameColumn;
    }

    @Override
    public TableColumn<Form, AlcoholType> getTypeColumn() {
        return TypeColumn;
    }

    @Override
    public TableColumn<Form, String> getBrandColumn() {
        return BrandColumn;
    }

    @Override
    public TableColumn<Form, String> getSerialColumn() {
        return SerialColumn;
    }

    ///////////////////////////////////////////////////
    ///////////       The Actual Code      ////////////
    ///////////////////////////////////////////////////

    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {
        try {
            this.refreshQueue(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void logOut(ActionEvent event) throws IOException {
        attributeContainer.currentUser = null;
        goToPage("AgentLogin.fxml");
    }

    @FXML
    public void refreshQueue(ActionEvent event) throws IOException {
        attributeContainer.formQueue = ((Agent)attributeContainer.currentUser).getThreeForms();
        getNewQueue();//TODO: replace this with tableViewHelper
//        tableViewHelper.updateTable(); //TODO: make tableViewHelper
        formDisplayHelper.displayForm(attributeContainer.currentForm);
    }
    @FXML
    public void approveForm(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {

            //TODO: get qualifications from text field
            ((Agent) attributeContainer.currentUser).approveForm(attributeContainer.currentForm, "");
            attributeContainer.currentForm = null;
            getNewQueue();//TODO: replace this with tableViewHelper
//        tableViewHelper.updateTable(); //TODO: make tableViewHelper
            formDisplayHelper.displayForm(attributeContainer.currentForm);
        }
    }
    @FXML
    public void rejectForm(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {
            ((Agent) attributeContainer.currentUser).rejectForm(attributeContainer.currentForm);
//            getNewQueue();//TODO: replace this with tableViewHelper
            attributeContainer.currentForm = null;
//        tableViewHelper.updateTable(); //TODO: make tableViewHelper
            formDisplayHelper.displayForm(attributeContainer.currentForm);
        }
    }
    @FXML
    public void reviewingTools(ActionEvent event) throws IOException {
        goToPage("AgentViewForm.fxml");
    }
    @FXML
    public void print(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {
            System.out.println("lol nah");
        }
    }


    //////////////////////////////////////////////////
    //////////     Move to Interfaces     ////////////          //TODO:...
    //////////////////////////////////////////////////

    public void getNewQueue() throws IOException{
//        attributeContainer.formQueue = ((Agent)attributeContainer.currentUser).getThreeForms();
        this.getTTBIDColumn().setCellValueFactory(new PropertyValueFactory<>("ttbID"));
        this.getDateSubmittedColumn().setCellValueFactory(new PropertyValueFactory<>("dateSubmitted"));
        this.getBrandColumn().setCellValueFactory(new PropertyValueFactory<>("brandName"));

        tableView();

        ObservableList<Form> tableValues = FXCollections.observableArrayList();
        for (int i = 0; i < attributeContainer.formQueue.size(); i++) {
            tableValues.add(attributeContainer.formQueue.get(i));
        }
        this.getFormTable().setItems(tableValues);
        this.getPrintButton().setEnabled(true);//setDisable(false);
    }



    public void tableView()  {
        ITableView temp = this;
        this.getFormTable().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            /**
             * Makes it so that, if you click on a row of the Table, a form is loaded based on that TTB_ID
             */
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    @SuppressWarnings("rawtypes")
                    TablePosition pos = temp.getFormTable().getSelectionModel().getSelectedCells().get(0);
                    int row = pos.getRow();
                    int col = pos.getColumn();
                    int ID = temp.getTTBIDColumn().getCellData(row);
                    System.out.println(ID);
                    attributeContainer.currentForm = Database.getInstance().dbSelect.getFormByTTB_ID(ID);
//                    ((AgentHomeController) temp).formDisplayHelper.displayForm(attributeContainer.currentForm);
                }
            }
        });
        //    ObservableList<Form> tableValues = FXCollections.observableArrayList();

    }
}
