package UI;

import Entities.DisplayForm;
import Entities.Form;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.JFXTreeView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import javafx.scene.control.*;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {


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
     */
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<DisplayForm> formlist = FXCollections.observableArrayList();
        for(Form f : AttributeContainer.getInstance().formQueue){
            formlist.add(new DisplayForm(f));
        }
        table.getColumns().addAll(colttb, coltype, colsub, coltype, colbrand, colstatus, colserial);
        table.setItems(formlist);
    }
}