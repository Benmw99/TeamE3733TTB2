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

public class ManHomeController extends PageControllerUI {

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
    protected void onLeave() {

    }

    @Override
    void onLoad() {

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
