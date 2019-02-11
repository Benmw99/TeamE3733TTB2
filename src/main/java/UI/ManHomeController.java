package UI;

import Entities.AlcoholType;
import Entities.Form;
import Entities.Manufacturer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.awt.*;
import java.io.IOException;
import java.sql.Timestamp;

public class ManHomeController extends PageControllerUI implements IFormDisplay, IExport, ITableView, ILogOut {

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
        this.formDisplayHelper = helper;
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
        this.tableViewHelper = helper;
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

    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {

    }

    @Override
    public Button getLogOutButton() {
        return LogOutButton;
    }


    ////////////////////////////////////
    ////////Controller Functions////////
    ////////////////////////////////////

    @FXML
    public void logOut(ActionEvent event) throws IOException {
        attributeContainer.currentUser = null;
        goToPage("ManLogin.fxml");
    }

    @FXML
    public void addForm(ActionEvent event) throws IOException {
        goToPage("ManApp1.fxml");
    }

    @FXML
    public void refreshForms(ActionEvent event) throws IOException {
        ((Manufacturer)attributeContainer.currentUser).loadForms();
        //TODO Integrate tableViewHelper to make work
        formDisplayHelper.displayForm(attributeContainer.currentForm);
    }

    @FXML
    public void viewAgentComments(ActionEvent event) throws IOException {
        //TODO Make comments a thing
    }

    @FXML
    public void download(ActionEvent event) throws IOException {
        //TODO Make download
    }

    @FXML
    public void print(ActionEvent event) throws IOException {
        //TODO Make print
    }

}
