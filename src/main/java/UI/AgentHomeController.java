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

public class AgentHomeController extends PageControllerUI  {

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
        goToPage("Login.fxml");
    }

    @FXML
    public void refreshQueue(ActionEvent event) throws IOException {
        //TODO CHANGE THIS ENTIRELY AS IT SHOULD WORK DIFFERENTLY. IT SHOULD GET A NEW FORM FOR HOWEVER MANY IT IS MISSING COMPARED TO ITS MAX FORMS
        //attributeContainer.formQueue = ((Agent)attributeContainer.currentUser).getThreeForms();
        getNewQueue();//TODO: replace this with tableViewHelper
//        tableViewHelper.updateTable(); //TODO: make tableViewHelper
    }

    @FXML
    public void approveForm(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {

            //TODO: get qualifications from text field
            ((Agent) attributeContainer.currentUser).approveForm(attributeContainer.currentForm, "");
            attributeContainer.currentForm = null;
            getNewQueue();//TODO: replace this with tableViewHelper
//        tableViewHelper.updateTable(); //TODO: make tableViewHelper
        }
    }
    @FXML
    public void rejectForm(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {
            ((Agent) attributeContainer.currentUser).rejectForm(attributeContainer.currentForm);
//            getNewQueue();//TODO: replace this with tableViewHelper
            attributeContainer.currentForm = null;
//        tableViewHelper.updateTable(); //TODO: make tableViewHelper
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
        this.TTBIDColumn.setCellValueFactory(new PropertyValueFactory<>("ttbID"));
        this.DateSubmittedColumn.setCellValueFactory(new PropertyValueFactory<>("dateSubmitted"));
        this.BrandColumn.setCellValueFactory(new PropertyValueFactory<>("brandName"));

    //    tableView();

        ObservableList<Form> tableValues = FXCollections.observableArrayList();
        for (int i = 0; i < attributeContainer.formQueue.size(); i++) {
            tableValues.add(attributeContainer.formQueue.get(i));
        }
        this.FormTable.setItems(tableValues);
        this.PrintButton.setEnabled(true);//setDisable(false);
    }


// TODO Implement the TableViewController to take care of this for us.
//    public void tableView()  {
//     //   ITableView temp = this;
//        this.getFormTable().setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            /**
//             * Makes it so that, if you click on a row of the Table, a form is loaded based on that TTB_ID
//             */
//            public void handle(MouseEvent click) {
//                if (click.getClickCount() == 2) {
//                    @SuppressWarnings("rawtypes")
//                    TablePosition pos = temp.getFormTable().getSelectionModel().getSelectedCells().get(0);
//                    int row = pos.getRow();
//                    int col = pos.getColumn();
//                    int ID = temp.getTTBIDColumn().getCellData(row);
//                    System.out.println(ID);
//                    attributeContainer.currentForm = Database.getDatabase().dbSelect.getFormByTTB_ID(ID);
////                    ((AgentHomeController) temp).formDisplayHelper.displayForm(attributeContainer.currentForm);
//                }
//            }
//        });
//        //    ObservableList<Form> tableValues = FXCollections.observableArrayList();
//
//    }
}
