package UI;

import Entities.AlcoholType;
import Entities.Form;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.Timestamp;

public class AgentSearchController extends PageControllerUI implements ISearch {

    @FXML
    TextField SearchSource;

    @FXML
    TextField SearchSerialNumber;

    @FXML
    TextField SearchAlcoholType;

    @FXML
    TextField SearchBrandName;

    @FXML
    TextField SearchFancifulName;

    @FXML
    TextField SearchWineVintageYear;

    @FXML
    TextField SearchWinePH;

    @FXML
    TextField SearchWineGrapeVarietal;

    @FXML
    TextField SearchWineAppellation;

    @FXML
    TextField SearchTimestamp;

    @FXML
    TextField SearchTTBID;

    @FXML
    TextField SearchNumResults;

    @FXML
    Button SearchSubmitSearch;


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

    @Override
    public TextField getSearchSource() {
        return SearchSource;
    }

    @Override
    public TextField getSearchSerialNumber() {
        return SearchSerialNumber;
    }

    @Override
    public TextField getSearchAlcoholType() {
        return SearchAlcoholType;
    }

    @Override
    public TextField getSearchBrandName() {
        return SearchBrandName;
    }

    @Override
    public TextField getSearchFancifulName() {
        return SearchFancifulName;
    }

    @Override
    public TextField getSearchWineVintageYear() {
        return SearchWineVintageYear;
    }

    @Override
    public TextField getSearchWinePH() {
        return SearchWinePH;
    }

    @Override
    public TextField getSearchWineGrapeVarietal() {
        return SearchWineGrapeVarietal;
    }

    @Override
    public TextField getSearchWineAppellation() {
        return SearchWineAppellation;
    }

    @Override
    public TextField getSearchTimestamp() {
        return SearchTimestamp;
    }

    @Override
    public TextField getSearchTTBID() {
        return SearchTTBID;
    }

    @Override
    public TextField getSearchNumResults() {
        return SearchNumResults;
    }

    @Override
    public Button getSearchSubmitSearch() {
        return SearchSubmitSearch;
    }

    @Override
    protected void onLeave(){}

    @Override
    protected void onLoad(){}

    @Override
    public void setTableViewHelper(TableViewHelper helper){}

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
}
