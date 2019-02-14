package UI;

import DB.Database;
import Entities.AdvancedSearch;
import Entities.AlcoholType;
import Entities.Form;
import Entities.SearchResult;
import SearchAlgo.Search;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static Entities.AlcoholType.*;

public class CivilController extends PageControllerUI implements Initializable {



    private Entities.SearchResult results;

    //not added because no button to go back from civilsearch to welcome screen
    /*
    @FXML
    Button BacktoWelcome;

    @FXML
    public void welcomePage(ActionEvent event) throws IOException {
        pageSwitch(event, "WelcomePage.fxml", BacktoWelcome);
    }
    */

    //CivilSearch
    @FXML
    TextField searchfield;

    @FXML
    Button advSearchButton;

    //CivilAdvSearch
    @FXML
    Button goButton;

    @FXML
    Button newThirtyButton;

    @FXML
    Button prevThirtyButton;

    @FXML
    Label civilTTBLabel;

    @FXML
    Label civilManLabel;

    @FXML
    Button menuASButton;

    @FXML
    Button search1Button;

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
    TextField cityField;

    @FXML
    DatePicker manufactureDate;

    @FXML
    TextField idField;

    @FXML
    Button printResults;

    @FXML
    Button backToWelcomeButton;

    @FXML
    ComboBox SearchAlcoholType;

    //Form Labels
    @FXML
    Label Civ1Label;
    @FXML
    Label Civ2Label;
    @FXML
    Label Civ3Label;
    @FXML
    Label CivReview4Label1;
    @FXML
    Label Civ4Label2;
    @FXML
    Label Civ5Label1;
    @FXML
    Label Civ5Label2;
    @FXML
    Label Civ5Label3;
    @FXML
    Label Civ6Label;
    @FXML
    Label Civ7Label;
    @FXML
    Label Civ8Label;
    @FXML
    Label Civ9Label;
    @FXML
    Label Civ10Label;
    @FXML
    Label Civ11Label;
    @FXML
    Label Civ12Label;
    @FXML
    Label Civ14Label;
    @FXML
    Label Civ15Label;
    @FXML
    Label Civ16Label;
    @FXML
    ImageView Agent13Image;

    @FXML
    Button printButt;
    @FXML
    Button SearchButt;

    @FXML
    TableView<Form> resultTable;

    @FXML
    TableColumn<Form, Integer> col1;

    @FXML
    TableColumn<Form, AlcoholType> col2;

    @FXML
    TableColumn<Form, String> col3;

    @FXML
    TableColumn<Form, String> col4;

    @FXML
    ComboBox<String> typeField;
    //CivilSearchForm
    @FXML
    Button backToAdvSearch;

    @FXML
    Button printSearchResultsCSV;



    SearchResult result;
    int searchPage;

    //Brewers Permit
    //Mailing address
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SearchAlcoholType.getItems().addAll("Beers", "Wines", "Distilled Liquor");

        if (attributeContainer.currentForm != null) {
            Civ1Label.setText(attributeContainer.currentForm.getRepID());
            String fullPermit = "";
            for (int i = 0; i < attributeContainer.currentForm.getBrewersPermit().size(); i++) {
                fullPermit += attributeContainer.currentForm.getBrewersPermit().get(i) + "\n";
            }
            Civ2Label.setText(fullPermit);
            if (attributeContainer.currentForm.getSource()) {
                Civ3Label.setText("Domestic");
            } else {
                Civ3Label.setText("Imported");
            }
            CivReview4Label1.setText(attributeContainer.currentForm.getSerialNumber());
            Civ5Label1.setText(attributeContainer.currentForm.getAlcoholType().toString());
            if (attributeContainer.currentForm.getAlcoholType().toInt() == Wine.toInt()) {
                Civ5Label2.setText("" + attributeContainer.currentForm.getWineFormItems().getpH());
                Civ5Label3.setText("" + attributeContainer.currentForm.getWineFormItems().getVintageYear());
                Civ11Label.setText(attributeContainer.currentForm.getWineFormItems().getGrapeVarietal());
                Civ12Label.setText(attributeContainer.currentForm.getWineFormItems().getAppellation());
            } else {
                Civ5Label2.setText("N/A");
                Civ5Label3.setText("N/A");
                Civ11Label.setText("N/A");
                Civ12Label.setText("N/A");
            }
            Civ6Label.setText(attributeContainer.currentForm.getBrandName());
            Civ7Label.setText(attributeContainer.currentForm.getFancifulName());

            String fullAddress = "";
            for (int i = 0; i < attributeContainer.currentForm.getAddress().size(); i++) {
                fullAddress += attributeContainer.currentForm.getAddress().get(i).getName() + "\n"; //NAME MIGHT NOT BE STORED OR RETRIEVED CORRECTLY
                fullAddress += attributeContainer.currentForm.getAddress().get(i).getStreet() + ", " + attributeContainer.currentForm.getAddress().get(i).getCity() + ", " + attributeContainer.currentForm.getAddress().get(i).getState();
                fullAddress += ", " + attributeContainer.currentForm.getAddress().get(i).getZip() + "\n";
            }
            Civ8Label.setText(fullAddress);
            if (attributeContainer.currentForm.getMailingAddress() != null) {
                String mailingAddress = "";
                mailingAddress += attributeContainer.currentForm.getMailingAddress().getStreet() + ", " + attributeContainer.currentForm.getMailingAddress().getCity() + ", " + attributeContainer.currentForm.getMailingAddress().getState() + ", " + attributeContainer.currentForm.getMailingAddress().getZip();
                Civ9Label.setText(mailingAddress);
            } else {
                Civ9Label.setText("");
            }
            Civ10Label.setText(attributeContainer.currentForm.getFormula());
            Civ14Label.setText("" + attributeContainer.currentForm.getAlcoholContent());
            Civ15Label.setText(attributeContainer.currentForm.getEmail());
            Civ16Label.setText(attributeContainer.currentForm.getPhoneNumber());


        }
    }
    //#################################################################################################################################
    //                                   advanced search
    @FXML
    public void searchAdvanced(ActionEvent event) throws IOException {
        printSearchResultsCSV.setDisable(false);
        printSearchResultsCSV.setText("Print Results");

        Entities.AdvancedSearch advancedSearch = new AdvancedSearch();

        if(SearchAlcoholType.getValue() != null && SearchAlcoholType.getValue().equals("Beers")){
            advancedSearch.setAlcoholType(MaltBeverage);
        }else if(SearchAlcoholType.getValue() != null && SearchAlcoholType.getValue().equals("Wines")){
            advancedSearch.setAlcoholType(Wine);
        }else if(SearchAlcoholType.getValue() != null && SearchAlcoholType.getValue().equals("Distilled Liquor")){
            advancedSearch.setAlcoholType(DistilledLiquor);
        }
        if (brandNameTextField.getText() != null && !brandNameTextField.getText().trim().equals("")) {
            advancedSearch.setBrandName(brandNameTextField.getText());
        }
        //if (alcoholContentTextField.getText() != "") {
            //Alcohol Content not in search yet
        //}
        //if (manField.getText() != "") {
            //Manufacturer not in search yet
        //}
        //if (stateField.getText() != "") {
            //State not in search yet
        //}
        //if (cityField.getText() != "") {
            //city not in search yet
        //}
        //if (manufactureDate.get) DATE NOT IMPLEMENTED YET


        List<Form> forms = Search.SearchDLBrand(advancedSearch, new SearchAlgo.DamerauLevenshtein());
        AttributeContainer.getInstance().currentResults = new SearchResult();
        AttributeContainer.getInstance().currentResults.setResults(forms);
        AttributeContainer.getInstance().currentResults.setSearch(advancedSearch);
        AttributeContainer.getInstance().currentResults.setQuery(advancedSearch.getBrandName());
        AttributeContainer.getInstance().formQueue = forms;
        goToPage("HomeSearch.fxml");
        AttributeContainer.getInstance().backlog.pop();
    }



    @FXML
    public void clickItem(MouseEvent event) throws IOException
    {
        if (event.getClickCount() == 1) //Checking double click kinda, just click quick enough
        {
            attributeContainer.currentForm = resultTable.getSelectionModel().getSelectedItem();
            Parent root;
            Stage stage;
            stage=(Stage) resultTable.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("ViewSelectedForm.fxml"));
            Scene scene = new Scene(root, 1360, 820);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    public void printResults(ActionEvent event) throws IOException {
        //TODO REWRITE THIS PASSING A BOOLEAN FOR WHETHER OR NOT IT IS A CSV OR ASCII
        //results.printResults();
        Database.getDatabase().dbSelect.downloadQuery(AttributeContainer.getInstance().currentResults, true);
        //printSearchResultsCSV.setDisable(true);
        printSearchResultsCSV.setText("Printed");
    }

    @FXML
    public void loginPage(){
        goToPage("Login.fxml");
    }


    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {

    }

}
