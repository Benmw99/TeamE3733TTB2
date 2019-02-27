package UI;

import DB.Database;
import Entities.AdvancedSearch;
import Entities.AlcoholType;
import Entities.Form;
import Entities.SearchResult;
import SearchAlgo.AsciiPrinter;
import SearchAlgo.Search;
import SearchAlgo.SearchContainer;
import SearchAlgo.*;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static Entities.AlcoholType.*;

public class HomeAdvancedSearchController extends PageControllerUI implements Initializable, PageObservable {

    private Entities.SearchResult results;

    List<PageObserver> pageObservers = new ArrayList<PageObserver>();

    @FXML
    AnchorPane MasterPane;

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

    @FXML
    TextField SearchID;

    @FXML
    JFXButton helpButton;

    @FXML
    Pane largePane;

    @FXML
    Pane smallPane;

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

    @FXML
    Button aboutPageNav;

    @FXML
    JFXButton UsernameButton;

    @FXML
    StackPane UsernameStackPane;

    @FXML
    Button clearSearch;

    @FXML
    JFXRadioButton fuzzy;

    @FXML
    Button SearchLoginButton;

    @FXML
    JFXRadioButton levenshtein;

    @FXML
    JFXRadioButton damereauLevenshtein;

    @FXML
    JFXRadioButton mongoRadioButton;

    @FXML
    JFXRadioButton apacheRadioButton;

    @FXML
    Button backToHomeButton;

    @FXML
    JFXTextField downloadDelimiter;

    @FXML
    Button previousButton;

    @FXML
    Button nextButton;

    @FXML
    TextField pageTextField;

    @FXML
    TextField brandNameTextField1;

    @FXML
    private JFXDatePicker SearchDate;

    @FXML
    private JFXDatePicker SearchDate1;

    @FXML
    private JFXComboBox<String> State9ComboBox;

    ToggleGroup searchOptions = new ToggleGroup();
    ToggleGroup searchOptions2 = new ToggleGroup();

    SearchResult result;
    int searchPage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SearchAlcoholType.getItems().addAll("Beers", "Wines", "Distilled Liquor");
        UsernameStackPane.setOpacity(0);
        UsernameStackPane.setPickOnBounds(false);

        List<String> states = Arrays.asList("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL",
                "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT",
                "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",
                "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");
        State9ComboBox.getItems().addAll(states);


        if(attributeContainer.currentUser != null){
//            System.out.println("This is true");
            UsernameStackPane.setOpacity(1);
            UsernameButton.setText(attributeContainer.currentUser.getLogin());
        }
        else{
            UsernameStackPane.toBack();
        }
//
//        if (attributeContainer.currentForm != null) {
//            Civ1Label.setText(attributeContainer.currentForm.getRepID());
//            String fullPermit = "";
//            for (int i = 0; i < attributeContainer.currentForm.getBrewersPermit().size(); i++) {
//                fullPermit += attributeContainer.currentForm.getBrewersPermit().get(i) + "\n";
//            }
//            Civ2Label.setText(fullPermit);
//            if (attributeContainer.currentForm.getSource()) {
//                Civ3Label.setText("Domestic");
//            } else {
//                Civ3Label.setText("Imported");
//            }
//            CivReview4Label1.setText(attributeContainer.currentForm.getSerialNumber());
//            Civ5Label1.setText(attributeContainer.currentForm.getAlcoholType().toString());
//            if (attributeContainer.currentForm.getAlcoholType().toInt() == Wine.toInt()) {
//                Civ5Label2.setText("" + attributeContainer.currentForm.getWineFormItems().getpH());
//                Civ5Label3.setText("" + attributeContainer.currentForm.getWineFormItems().getVintageYear());
//                Civ11Label.setText(attributeContainer.currentForm.getWineFormItems().getGrapeVarietal());
//                Civ12Label.setText(attributeContainer.currentForm.getWineFormItems().getAppellation());
//            } else {
//                Civ5Label2.setText("N/A");
//                Civ5Label3.setText("N/A");
//                Civ11Label.setText("N/A");
//                Civ12Label.setText("N/A");
//            }
//            Civ6Label.setText(attributeContainer.currentForm.getBrandName());
//            Civ7Label.setText(attributeContainer.currentForm.getFancifulName());
//
//            String fullAddress = "";
//            for (int i = 0; i < attributeContainer.currentForm.getAddress().size(); i++) {
//                fullAddress += attributeContainer.currentForm.getAddress().get(i).getName() + "\n"; //NAME MIGHT NOT BE STORED OR RETRIEVED CORRECTLY
//                fullAddress += attributeContainer.currentForm.getAddress().get(i).getStreet() + ", " + attributeContainer.currentForm.getAddress().get(i).getCity() + ", " + attributeContainer.currentForm.getAddress().get(i).getState();
//                fullAddress += ", " + attributeContainer.currentForm.getAddress().get(i).getZip() + "\n";
//            }
//            Civ8Label.setText(fullAddress);
//            if (attributeContainer.currentForm.getMailingAddress() != null) {
//                String mailingAddress = "";
//                mailingAddress += attributeContainer.currentForm.getMailingAddress().getStreet() + ", " + attributeContainer.currentForm.getMailingAddress().getCity() + ", " + attributeContainer.currentForm.getMailingAddress().getState() + ", " + attributeContainer.currentForm.getMailingAddress().getZip();
//                Civ9Label.setText(mailingAddress);
//            } else {
//                Civ9Label.setText("");
//            }
//            Civ10Label.setText(attributeContainer.currentForm.getFormula());
//            Civ14Label.setText("" + attributeContainer.currentForm.getAlcoholContent());
//            Civ15Label.setText(attributeContainer.currentForm.getEmail());
//            Civ16Label.setText(attributeContainer.currentForm.getPhoneNumber());
//
//        }

        //helpButton.isPressed();
        largePane.setOpacity(0);
        largePane.setDisable(true);
        smallPane.setOpacity(0);
        smallPane.setDisable(true);

        helpButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                largePane.setOpacity(0.63);
                largePane.setDisable(false);
                smallPane.setOpacity(1);
                smallPane.setDisable(false);
                System.out.println(event.getSource());
            }


        });

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

        //fanciful name
        if ( brandNameTextField1.getText() != null && !brandNameTextField1.getText().trim().equals("")) {
            advancedSearch.setFancifulName(brandNameTextField1.getText());
        }

        //dates
        if(SearchDate.getValue() != null && SearchDate1.getValue() != null ){
            if(SearchDate.getValue().compareTo(SearchDate1.getValue()) <= 0) {
                advancedSearch.setStartDate(java.sql.Date.valueOf(SearchDate.getValue()));
                advancedSearch.setEndDate(java.sql.Date.valueOf(SearchDate1.getValue()));
            }else{
                Alert yikes = new Alert(Alert.AlertType.WARNING);
                yikes.setContentText("Make sure your date's are entered chronologically, they will be ignored");
                yikes.setHeaderText("Invalid Date");
                yikes.show();
            }
        }

        //ttb id
        if(SearchID.getText() != null && !SearchID.getText().trim().equals("") && isNumeric(SearchID.getText()) && SearchID.getText() != "0") {
            if((int)Double.parseDouble(SearchID.getText()) > 0) {
                advancedSearch.setTtbID((int) Double.parseDouble(SearchID.getText()));
            }
        }

        //state
        if(State9ComboBox.getValue() != null){
            advancedSearch.setState(State9ComboBox.getValue());
        }





        List<Form> forms;

        if (apacheRadioButton.isSelected()) {
            if (damereauLevenshtein.isSelected()) {           //DL
                forms = Search.SearchDL(advancedSearch);
                AttributeContainer.getInstance().searchType = 2;
            } else if (levenshtein.isSelected()) {             //LD
                forms = Search.SearchLD(advancedSearch);
                AttributeContainer.getInstance().searchType = 3;
            } else {                                           //wild
                forms = Search.SearchWild(advancedSearch);
                AttributeContainer.getInstance().searchType = 1;
            }
        } else {
            Database db = Database.getDatabase();
            //forms = Search.SearchWild(advancedSearch);
            forms = db.mongoFunc.searchMongo(advancedSearch);
        }
        SearchContainer.getInstance().searchResult = new SearchResult();
        SearchContainer.getInstance().searchResult.setResults(forms);
        SearchContainer.getInstance().searchResult.setSearch(advancedSearch);
        SearchContainer.getInstance().searchResult.setQuery(advancedSearch.getBrandName());
        SearchContainer.getInstance().setPages();
        SearchContainer.getInstance().currentPage = 1;
        if(SearchContainer.getInstance().searchResult.getResults().size() != 0) {
            SearchContainer.getInstance().loadQueue();
        }
        goToPage("HomeSearch.fxml");
        AttributeContainer.getInstance().backlog.pop();
    }

    @FXML
    public void nextPage(ActionEvent event) throws IOException {
        if(SearchContainer.getInstance().currentPage != SearchContainer.getInstance().maxPages) {
            SearchContainer.getInstance().currentPage += 1;
            SearchContainer.getInstance().loadQueue();
            goToPage("HomeSearch.fxml");
            AttributeContainer.getInstance().backlog.pop();
        }
    }

    @FXML
    public void prevPage(ActionEvent event) throws IOException {
        if(SearchContainer.getInstance().currentPage != 1) {
            SearchContainer.getInstance().currentPage -= 1;
            SearchContainer.getInstance().loadQueue();
            goToPage("HomeSearch.fxml");
            AttributeContainer.getInstance().backlog.pop();
        }
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
        printSearchResultsCSV.setDisable(true);
        String raw = downloadDelimiter.getText();
        char sep;
        if(downloadDelimiter.getText() == null || downloadDelimiter.getText().isEmpty()){
            sep = ',';
        }else{
            sep = raw.charAt(0);
        }
        AttributeContainer.getInstance().delimeter = sep;
        AsciiPrinter.print(SearchContainer.getInstance().searchResult.getResults(),AttributeContainer.getInstance().delimeter);
        printSearchResultsCSV.setText("Printed");
    }

    @FXML
    public void clearSearch(ActionEvent event) throws IOException {
        SearchContainer.getInstance().searchResult.setSearch(null);
        AttributeContainer.getInstance().formQueue = new ArrayList<Form>();
        AttributeContainer.getInstance().searchType = 1;
        goToPage("HomeSearch.fxml");
        AttributeContainer.getInstance().backlog.pop();
    }

    @FXML
    public void loginPage(){
        attributeContainer.currentUser = null;
        SearchContainer.getInstance().searchResult = new SearchResult();
        SearchContainer.getInstance().currentPage = 1;
        AttributeContainer.getInstance().formQueue = new ArrayList<Form>();
        AttributeContainer.getInstance().currentResults = new SearchResult();
        AttributeContainer.getInstance().searchType = 1;
        goToPage("Login.fxml");
    }

    @FXML
    public void aboutPage() {goToPage("AboutPage.fxml"); }

    @FXML
    public void backToHome() {
        if(attributeContainer.currentUser.isAgent()){
            goToPage("AgentHome.fxml");
        } else {
            goToPage("ManHome.fxml");

        }
    }

    @Override
    protected void onLeave() {

    }

    @Override
    void onLoad() {
        if(AttributeContainer.getInstance().formQueue.size() == 0) {
            printSearchResultsCSV.setDisable(true);
        }

        //search radio buttons
        fuzzy.setToggleGroup(searchOptions);
        levenshtein.setToggleGroup(searchOptions);
        damereauLevenshtein.setToggleGroup(searchOptions);
        if(AttributeContainer.getInstance().searchType == 2) {
            damereauLevenshtein.setSelected(true);
        }else if(AttributeContainer.getInstance().searchType == 3) {
            levenshtein.setSelected(true);
        }else{
            fuzzy.setSelected(true);
        }

        //search radio buttons
        apacheRadioButton.setToggleGroup(searchOptions2);
        mongoRadioButton.setToggleGroup(searchOptions2);
        apacheRadioButton.setSelected(true);


        //persist search stuff
        if(!(SearchContainer.getInstance().searchResult.getSearch() == null)) {

            if(SearchContainer.getInstance().searchResult.getSearch().getAlcoholType() != null) {
                if (SearchContainer.getInstance().searchResult.getSearch().getAlcoholType().toString().equals("Wine")) {
                    SearchAlcoholType.getSelectionModel().select(1);
                } else if (SearchContainer.getInstance().searchResult.getSearch().getAlcoholType().toString().equals("DistilledLiquor")) {
                    SearchAlcoholType.getSelectionModel().select(2);
                } else if (SearchContainer.getInstance().searchResult.getSearch().getAlcoholType().toString().equals("MaltBeverage")) {
                    SearchAlcoholType.getSelectionModel().select(0);
                }
            }
            brandNameTextField.setText(SearchContainer.getInstance().searchResult.getSearch().brandName);
            brandNameTextField1.setText(SearchContainer.getInstance().searchResult.getSearch().fancifulName);

            if(SearchContainer.getInstance().searchResult.getSearch().getStartDate() != null){
                SearchDate.setValue(Instant.ofEpochMilli(SearchContainer.getInstance().searchResult.getSearch().startDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
                SearchDate1.setValue(Instant.ofEpochMilli(SearchContainer.getInstance().searchResult.getSearch().endDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());

            }

            if(SearchContainer.getInstance().searchResult.getSearch().ttbID != 0){
                SearchID.setText(SearchContainer.getInstance().searchResult.getSearch().ttbID + "");
            }

            if(SearchContainer.getInstance().searchResult.getSearch().getState() != null) {
                List<String> states = Arrays.asList("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL",
                        "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT",
                        "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",
                        "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");
                State9ComboBox.getSelectionModel().select(states.indexOf(SearchContainer.getInstance().searchResult.getSearch().getState()));
            }
        }

        //TODO save the type of search algorithm

        pageTextField.setText(SearchContainer.getInstance().currentPage + "");
        if(SearchContainer.getInstance().currentPage == 1){
            previousButton.setDisable(true);
        }
        if(SearchContainer.getInstance().currentPage == SearchContainer.getInstance().maxPages){
            nextButton.setDisable(true);
        }

        this.register(new PageNumberUpdater());

    }

    @FXML
    public void limitDelimit()  {
        if (downloadDelimiter.getText().length() > 1) {
            downloadDelimiter.setText(downloadDelimiter.getText().substring(0, 1));
        }
    }


    public static boolean isNumeric(String str) {
        try{
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe){
            return false;
        }
        return true;
    }


    @Override
    public void register(PageObserver o) {
        pageObservers.add(o);
    }

    @FXML
    @Override
    public void notifyObservers() {
        for (PageObserver o:pageObservers) { o.notify(pageTextField.getText());}

    }

    @FXML
    public void toProfile(){
        goToPage("Profile.fxml");
    }


}
