package UI;

import Entities.*;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.JFXTreeView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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
     */
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<DisplayForm> formlist = FXCollections.observableArrayList();
        colttb.setCellValueFactory(new PropertyValueFactory("TTB_ID"));
        colbrand.setCellValueFactory(new PropertyValueFactory("Brand"));
        colserial.setCellValueFactory(new PropertyValueFactory("Serial"));
        colstatus.setCellValueFactory(new PropertyValueFactory("Status"));
        colsub.setCellValueFactory(new PropertyValueFactory("Submitted"));
        coltype.setCellValueFactory(new PropertyValueFactory("Type"));
        table.setItems(formlist);
        for(Form f : AttributeContainer.getInstance().formQueue){
                formlist.add(new DisplayForm(f));

        }
//        table.getColumns().addAll(colttb, colsub, coltype, colbrand, colstatus, colserial);



    }

    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {

    }
}