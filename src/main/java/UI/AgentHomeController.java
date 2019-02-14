package UI;

import DB.Database;
import Entities.Agent;
import Entities.Form;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.jfoenix.controls.*;


import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AgentHomeController extends PageControllerUI implements Initializable {

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
    JFXButton PrintButton;

    @FXML
    Button SaveToCSVButton;

    @FXML
    Button AsciiDelimitedFileButton;

    //From ITableView
    /*
    @FXML
    JFXTreeTableView<Form> FormTable;

    @FXML
    JFXTreeTableColumn<Form, Integer> TTBIDColumn;

    @FXML
    JFXTreeTableColumn<Form, Timestamp> DateSubmittedColumn;

    @FXML
    JFXTreeTableColumn<Form, String> BrandNameColumn;

    @FXML
    JFXTreeTableColumn<Form, AlcoholType> TypeColumn;

    @FXML
    JFXTreeTableColumn<Form, String> BrandColumn;

    @FXML
    JFXTreeTableColumn<Form, String> SerialColumn;
    */
    // TODO add the nested tableview fxml for this page

    //From ILogOut
    @FXML
    Button LogOutButton;

    @FXML
    JFXButton reviewToolButton;

    @FXML
    JFXButton RejectFormButton;

    @FXML
    JFXButton ApproveFormButton;

    @FXML
    JFXTextField SearchField;

    @FXML
    JFXButton GetNewQueueButon;



    ///////////////////////////////////////////////////
    ///////////       The Actual Code      ////////////
    ///////////////////////////////////////////////////

    @Override
    protected void onLeave() {

    }

    /**
    * Refreshes Agent queue automatically on load
    */
    @Override
    void onLoad() {
        try {
            this.refreshQueue(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates new blank form for Agent to fill
     */
    @FXML
    void newApp() {
        attributeContainer.currentForm = new Form();
//        goToPage("AgentApp.fxml");//TODO: this is not a page
    }

    //New controller overrides
    @FXML
    public void logOut(ActionEvent event) throws IOException {
        attributeContainer.currentUser = null;
        attributeContainer.formQueue = new ArrayList<Form>();
        attributeContainer.currentForm = null;
        goToPage("Login.fxml");
    }

    /**
     * Update Agent queue with new forms
     * @param event
     * @throws IOException
     */
    @FXML
    public void refreshQueue(ActionEvent event) throws IOException {
        //TODO CHANGE THIS ENTIRELY AS IT SHOULD WORK DIFFERENTLY. IT SHOULD GET A NEW FORM FOR HOWEVER MANY IT IS MISSING COMPARED TO ITS MAX FORMS
        //attributeContainer.formQueue = ((Agent)attributeContainer.currentUser).getThreeForms();
    //    getNewQueue();//TODO: replace this with tableViewHelper
//        tableViewHelper.updateTable(); //TODO: make tableViewHelper
    }

    /**
     * Set approval status of current form to approved
     * @param event
     * @throws IOException
     */
    @FXML
    public void approveForm(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {
            //TODO: get qualifications from text field
            ((Agent)AttributeContainer.getInstance().currentUser).approveForm(AttributeContainer.getInstance().currentForm, "");
            attributeContainer.currentForm = null;
            attributeContainer.formQueue = ((Agent)AttributeContainer.getInstance().currentUser).getCurrentQueue();
            goToPage("AgentHome.fxml");
        }
    }

    /**
     * Set approval status of current form to rejected
     * @param event
     * @throws IOException
     */
    @FXML
    public void rejectForm(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {
            ((Agent)AttributeContainer.getInstance().currentUser).rejectForm(AttributeContainer.getInstance().currentForm);
             attributeContainer.currentForm = null;
            attributeContainer.formQueue = ((Agent)AttributeContainer.getInstance().currentUser).getCurrentQueue();
            goToPage("AgentHome.fxml");
        }
    }

    /**
     * Directs Agent to reviewing tools
     * @param event
     * @throws IOException
     */
    @FXML
    public void reviewingTools(ActionEvent event) throws IOException {
        goToPage("resources/AgentViewForm.fxml");
    }

    /**
     * Sends current form to printable format
     * @param event
     * @throws IOException
     */
    @FXML
    public void print(ActionEvent event) throws IOException {
        if (!(attributeContainer.currentForm == null)) {
            System.out.println("lol nah");
        }
    }


    //////////////////////////////////////////////////
    //////////     Move to Interfaces     ////////////          //TODO:...
    //////////////////////////////////////////////////

    @FXML
    public void getNewQueue() throws IOException {
//        AttributeContainer ac =  AttributeContainer.getInstance();
//        ((Agent)ac.currentUser).getQueueIntoAC();

    }

 @Override
 public void initialize(URL location, ResourceBundle resources) {
        AttributeContainer.getInstance().formQueue = Database.getDatabase().dbSelect.getNext(AttributeContainer.getInstance().numForQueue);
 }
 // TODO fix this so that it can be used with the nested table
//        attributeContainer.formQueue = ((Agent)attributeContainer.currentUser).getThreeForms();
       /* this.TTBIDColumn.setCellValueFactory(new PropertyValueFactory<>("ttbID"));
        this.DateSubmittedColumn.setCellValueFactory(new PropertyValueFactory<>("dateSubmitted"));
        this.BrandColumn.setCellValueFactory(new PropertyValueFactory<>("brandName"));

    //    tableView();

        ObservableList<Form> tableValues = FXCollections.observableArrayList();
        for (int i = 0; i < attributeContainer.formQueue.size(); i++) {
            tableValues.add(attributeContainer.formQueue.get(i));
        }
        this.FormTable.setItems(tableValues);
        // TODO need to figure out how to do the following
        // this.PrintButton.setEnabled(true);//setDisable(false);
    }
*/

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
