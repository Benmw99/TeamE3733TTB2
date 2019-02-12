//package UI;
//
//import Entities.AdvancedSearch;
//import Entities.AlcoholType;
//import Entities.Form;
//import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXComboBox;
//import com.jfoenix.controls.JFXDatePicker;
//import com.jfoenix.controls.JFXTextField;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.io.IOException;
//import java.sql.Timestamp;
//
//import static Entities.AlcoholType.*;
//
//public class SearchController {
//
//    @FXML
//    JFXComboBox SearchAlcoholType;
//    @FXML
//    JFXTextField SearchPercentage;
//    @FXML
//    JFXTextField SearchBrand;
//    @FXML
//    JFXTextField SearchManufacturer;
//    @FXML
//    JFXTextField SearchState;
//    @FXML
//    JFXTextField SearchCity;
//    @FXML
//    JFXDatePicker SearchDate;
//    @FXML
//    JFXTextField SearchID;
//    @FXML
//    JFXButton SearchButton;
//
//    public JFXComboBox getSearchAlcoholType() {
//        return SearchAlcoholType;
//    }
//
//    public JFXTextField getSearchPercentage() {
//        return SearchPercentage;
//    }
//
//    public JFXTextField getSearchBrand() {
//        return SearchBrand;
//    }
//
//    public JFXTextField getSearchManufacturer() {
//        return SearchManufacturer;
//    }
//
//    public JFXTextField getSearchState() {
//        return SearchState;
//    }
//
//    public JFXTextField getSearchCity() {
//        return SearchCity;
//    }
//
//    public JFXDatePicker getSearchDate() {
//        return SearchDate;
//    }
//
//    public JFXTextField getSearchID() {
//        return SearchID;
//    }
//
//    public JFXButton getSearchButton() {
//        return SearchButton;
//    }
//
//    public void search(ActionEvent event) throws IOException {
//
//        Entities.AdvancedSearch advancedSearch = new AdvancedSearch();
//
//        if(getSearchAlcoholType().getValue() != null && getSearchAlcoholType().getValue().equals("Beers")){
//            advancedSearch.setAlcoholType(MaltBeverage);
//        }else if(getSearchAlcoholType().getValue() != null && getSearchAlcoholType().getValue().equals("Wines")){
//            advancedSearch.setAlcoholType(Wine);
//        }else if(getSearchAlcoholType().getValue() != null && getSearchAlcoholType().getValue().equals("Distilled Liquor")){
//            advancedSearch.setAlcoholType(DistilledLiquor);
//        }
//        if (getSearchPercentage().getText() != null && !getSearchPercentage().getText().trim().equals("")) {
//            advancedSearch.setAlcoholContent(getSearchPercentage().getText());
//        }
//        if (getSearchBrand().getText() != null && !getSearchBrand().getText().trim().equals("")) {
//            advancedSearch.setBrandName(getSearchBrand().getText());
//        }
//        if (getSearchManufacturer().getText() != null && !getSearchManufacturer().getText().trim().equals("")) {
//            advancedSearch.setBrandName(getSearchManufacturer().getText());
//        }
//        if (getSearchState().getText() != null && !getSearchState().getText().trim().equals("")) {
//            advancedSearch.setBrandName(getSearchState().getText());
//        }
//        if (getSearchCity().getText() != null && !getSearchCity().getText().trim().equals("")) {
//            advancedSearch.setBrandName(getSearchCity().getText());
//        }
//        if (getSearchDate().getValue() != null) {
//            advancedSearch.setBrandName(getSearchDate().getValue());
//        }
//
//        DB.Database db = DB.Database.getInstance();
//        results = db.dbSelect.searchBy(advancedSearch);
//
//        col1.setCellValueFactory(new PropertyValueFactory<>("ttbID"));
//        col2.setCellValueFactory(new PropertyValueFactory<>("alcoholType"));
//        col3.setCellValueFactory(new PropertyValueFactory<>("brandName"));
//        col4.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
//
//        ObservableList<Form> tableValues = FXCollections.observableArrayList();
//        for (int i = 0; i < results.getResults().size(); i++) {
//            tableValues.add(results.getResults().get(i));
//        }
//        resultTable.setItems(tableValues);
//        printSearchResultsCSV.setDisable(false);
//    }
//
//}
