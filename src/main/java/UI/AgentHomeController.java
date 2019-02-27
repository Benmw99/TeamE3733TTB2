package UI;

import Entities.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import com.jfoenix.controls.*;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AgentHomeController extends PageControllerUI implements Initializable {

    @FXML
    Pane largePane;

    @FXML
    Pane smallPane;

    @FXML
    JFXButton helpButton;

    @FXML
    JFXButton exitHelp;

    @FXML
    public JFXButton GetNewQueueButton;

    public AnchorPane hamburger;
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

   // @FXML
   // JFXButton GetNewQueueButon;

    @FXML
    JFXTextField queueAmountField;




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
        //try {
    //        this.refreshQueue(null);
    //    } catch (IOException e) {
      //      e.printStackTrace();
     //   }
    }

    /**
     * Creates new blank form for Agent to fill
     */
    @FXML
    void newApp() {
        goToPage("ManSingleAppPage.fxml");
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
            //TODO: mail
            AttributeContainer.getInstance().currentForm.getApproval().setPage1(ApprovalStatus.Complete);
            AttributeContainer.getInstance().currentForm.getApproval().setPage2(ApprovalStatus.Complete);
            AttributeContainer.getInstance().currentForm.getApproval().setPage3(ApprovalStatus.Complete);
            AttributeContainer.getInstance().currentForm.getApproval().setPage4(ApprovalStatus.Complete);
            ((Agent)AttributeContainer.getInstance().currentUser).approveForm(AttributeContainer.getInstance().currentForm, "");
            attributeContainer.formQueue = ((Agent)AttributeContainer.getInstance().currentUser).getCurrentQueue();
            Thread mailThread = new Thread( new Mailer(AttributeContainer.getInstance().currentForm));
            mailThread.start();
            attributeContainer.currentForm = null;

            Notifications notificationsBuilder = Notifications.create()
                    .title("Approved Form")
                    .text("You have just approved this form.")
                    .graphic(null)
                    .hideAfter(Duration.seconds(6))
                    .position(Pos.CENTER)
                    .onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            goToPage("AgentHome.fxml");
                        }
                    });
            notificationsBuilder.showConfirm();

        } else {
            Alert yikes = new Alert(Alert.AlertType.WARNING);
            yikes.setContentText("Please select a form!");
            yikes.setHeaderText("Invalid Form Selection");
            yikes.show();
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
            //TODO: mail
            AttributeContainer.getInstance().currentForm.getApproval().setPage1(ApprovalStatus.Incorrect);
            AttributeContainer.getInstance().currentForm.getApproval().setPage2(ApprovalStatus.Incorrect);
            AttributeContainer.getInstance().currentForm.getApproval().setPage3(ApprovalStatus.Incorrect);
            AttributeContainer.getInstance().currentForm.getApproval().setPage4(ApprovalStatus.Incorrect);
            ((Agent)AttributeContainer.getInstance().currentUser).rejectForm(AttributeContainer.getInstance().currentForm, "");
            attributeContainer.formQueue = ((Agent)AttributeContainer.getInstance().currentUser).getCurrentQueue();
            Thread mailThread = new Thread( new Mailer(AttributeContainer.getInstance().currentForm));
            mailThread.start();
            attributeContainer.currentForm = null;

            Notifications notificationsBuilder = Notifications.create()
                    .title("Rejected Form")
                    .text("You have just rejected this form.")
                    .graphic(null)
                    .hideAfter(Duration.seconds(6))
                    .position(Pos.CENTER)
                    .onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            goToPage("AgentHome.fxml");
                        }
                    });
            notificationsBuilder.showError();

        } else {
            Alert yikes = new Alert(Alert.AlertType.WARNING);
            yikes.setContentText("Please select a form!");
            yikes.setHeaderText("Invalid Form Selection");
            yikes.show();
        }
    }

    /**
     * Directs Agent to reviewing tools
     * @param event
     * @throws IOException
     */
    @FXML
    public void reviewingTools(ActionEvent event) throws IOException {
        if(AttributeContainer.getInstance().currentForm != null) {
            goToPage("AgentReviewingTools.fxml");
        } else {
            Alert yikes = new Alert(Alert.AlertType.WARNING);
            yikes.setContentText("Please select a form!");
            yikes.setHeaderText("Invalid Form Selection");
            yikes.show();
        }
    }

    /**
     * Sends current form to printable format
     * @param event
     * @throws IOException
     */
    @FXML
    public void print(ActionEvent event) throws IOException {
        if(AttributeContainer.getInstance().currentForm != null){
            new FormExporter(AttributeContainer.getInstance().currentForm, "S");
            PrintButton.setText("Printed!");
        } else {
            Alert yikes = new Alert(Alert.AlertType.WARNING);
            yikes.setContentText("Please select a form!");
            yikes.setHeaderText("Invalid Form Selection");
            yikes.show();
        }
    }


    //////////////////////////////////////////////////
    //////////     Move to Interfaces     ////////////          //TODO:...
    //////////////////////////////////////////////////

    @FXML
    public void getNewQueue() throws IOException {
        AttributeContainer ac =  AttributeContainer.getInstance();
        if(queueAmountField.getText().trim().isEmpty()) {
            ac.numForQueue = 5;
        } else {
            ac.numForQueue = Integer.parseInt(queueAmountField.getText());
        }
        ((Agent)ac.currentUser).getQueueIntoAC();
        AttributeContainer.getInstance().backlog.pop();
        goToPage("AgentHome.fxml");
    }

    @FXML
    public void handleHelp(ActionEvent event) {
        final Node source = (Node) event.getSource();
        String id = source.getId();
        if (id.equals("helpButton")) {
            largePane.setOpacity(0.63);
            largePane.setDisable(false);
            smallPane.setOpacity(1);
            smallPane.setDisable(false);
//            System.out.println(event.getSource());
            System.out.println(id + " true");
        } else if(id.equals("exitHelp")){
            System.out.println(id + " else");
            largePane.setOpacity(0);
            largePane.setDisable(true);
            smallPane.setOpacity(0);
            smallPane.setDisable(true);
        }
    }

 @Override
 public void initialize(URL location, ResourceBundle resources) {
    //    hamburger.setMaxWidth(50);
   //     hamburger.setMouseTransparent(true);
        hamburger.setBackground(null);
        for(Node n : hamburger.getChildren()){
         if(n.getId().equals("Hamburger")){
             n.toFront();
           //  n.setMouseTransparent(false);
             n.setPickOnBounds(true);
            }
        }
  //      hamburger.toBack();
//(true);a
        GetNewQueueButton.toFront();

     //helpToggleButton.setSelected(false);
     largePane.setOpacity(0);
     largePane.setDisable(true);
     smallPane.setOpacity(0);
     smallPane.setDisable(true);


//        AttributeContainer.getInstance().formQueue = Database.getDatabase().dbSelect.getNext(AttributeContainer.getInstance().numForQueue);
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
