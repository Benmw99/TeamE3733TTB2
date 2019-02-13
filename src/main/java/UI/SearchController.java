package UI;

import Entities.AdvancedSearch;
import Entities.AlcoholType;
import Entities.Form;
import SearchAlgo.Search;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.Timestamp;

import static Entities.AlcoholType.*;

public class SearchController {

    @FXML
    JFXComboBox SearchAlcoholType;
    @FXML
    JFXTextField SearchPercentage;
    @FXML
    JFXTextField SearchBrand;
    @FXML
    JFXTextField SearchManufacturer;
    @FXML
    JFXTextField SearchState;
    @FXML
    JFXTextField SearchCity;
    @FXML
    JFXDatePicker SearchDate;
    @FXML
    JFXTextField SearchID;
    @FXML
    JFXButton SearchButton;

    public JFXComboBox getSearchAlcoholType() {
        return SearchAlcoholType;
    }

    public JFXTextField getSearchPercentage() {
        return SearchPercentage;
    }

    public JFXTextField getSearchBrand() {
        return SearchBrand;
    }

    public JFXTextField getSearchManufacturer() {
        return SearchManufacturer;
    }

    public JFXTextField getSearchState() {
        return SearchState;
    }

    public JFXTextField getSearchCity() {
        return SearchCity;
    }

    public JFXDatePicker getSearchDate() {
        return SearchDate;
    }

    public JFXTextField getSearchID() {
        return SearchID;
    }

    public JFXButton getSearchButton() {
        return SearchButton;
    }

    /**
     * Performs search
     * @param event
     * @throws IOException
     */
    public void search(ActionEvent event) throws IOException {

        Entities.AdvancedSearch advancedSearch = new AdvancedSearch();

        if(getSearchAlcoholType().getValue() != null && getSearchAlcoholType().getValue().equals("Beers")){
            advancedSearch.setAlcoholType(MaltBeverage);
        }else if(getSearchAlcoholType().getValue() != null && getSearchAlcoholType().getValue().equals("Wines")){
            advancedSearch.setAlcoholType(Wine);
        }else if(getSearchAlcoholType().getValue() != null && getSearchAlcoholType().getValue().equals("Distilled Liquor")){
            advancedSearch.setAlcoholType(DistilledLiquor);
        }

    }

}
