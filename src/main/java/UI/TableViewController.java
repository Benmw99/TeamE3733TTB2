package UI;

import DB.Database;
import Entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.ResourceBundle;

public class TableViewController extends PageControllerUI implements Initializable  {


    @FXML
    TableView<DisplayForm> table;

    @FXML
    TableColumn<DisplayForm, String> colttb = new TableColumn<DisplayForm, String>("TTB_ID");

    @FXML
    TableColumn<DisplayForm, String> coltype = new TableColumn<DisplayForm, String>("Type");

    @FXML
    TableColumn<DisplayForm, String> colsub = new TableColumn<DisplayForm, String>("Date_Submitted");

    @FXML
    TableColumn<DisplayForm, String>  colbrand = new TableColumn<DisplayForm, String>("Brand");

    @FXML
    TableColumn<DisplayForm, String>  colstatus = new TableColumn<DisplayForm, String>("Status");

    @FXML
    TableColumn<DisplayForm, String>  colserial = new TableColumn<DisplayForm, String>("Serial");

    @Override
    /**
     * Displays the List of Forms stored in the Attribute Container Form Queue
     * Also sets up the table to update a clicked form into Attribute Container CurrentForm
     */
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<DisplayForm> formlist = FXCollections.observableArrayList();
        colttb.setCellValueFactory(new PropertyValueFactory("TTB_ID"));
        colbrand.setCellValueFactory(new PropertyValueFactory("Brand"));
        colserial.setCellValueFactory(new PropertyValueFactory("Serial"));
        colstatus.setCellValueFactory(new PropertyValueFactory("Status"));
        colsub.setCellValueFactory(new PropertyValueFactory("Submitted"));
        coltype.setCellValueFactory(new PropertyValueFactory("Type"));
        if(AttributeContainer.getInstance().backlog.peek().equals("HomeSearch.fxml")){
            enableSearchVersion();
        } else {
            table.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                /**
                 * Makes it so that, if you click on a row of the Table, a form is loaded based on that TTB_ID
                 */
                public void handle(MouseEvent click) {
                    if (click.getClickCount() == 1) {
                        @SuppressWarnings("rawtypes")
                        TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int ID = Integer.valueOf(colttb.getCellData(row));
                        System.out.println(ID);
                        AttributeContainer.getInstance().currentForm = Database.getDatabase().dbSelect.getFormByTTB_ID(ID);
                        goToPage(AttributeContainer.getInstance().backlog.pop());
                    }
                }
            });
        }
        for(Form f : AttributeContainer.getInstance().formQueue){
                formlist.add(new DisplayForm(f));
        }
        table.setItems(formlist);

    }

    /**
     * This is the function that must be called for this to be the search version of the form. Under these conditions
     * the form will page switch to the
     */
    public void enableSearchVersion(){
        colstatus.setMaxWidth(0); //TODO This is spaghetti
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            /**
             * Makes it so that, if you click on a row of the Table, a form is loaded based on that TTB_ID
             */
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 1) {
                    @SuppressWarnings("rawtypes")
                    TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
                    int row = pos.getRow();
                    int ID = Integer.valueOf(colttb.getCellData(row));
                    AttributeContainer.getInstance().currentForm = Database.getDatabase().dbSelect.getFormByTTB_ID(ID);
                    goToPage("ViewSelectedForm.fxml");
                }
            }
        });    }

    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {

    }
}