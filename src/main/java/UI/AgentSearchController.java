package UI;

import Entities.AlcoholType;
import Entities.Form;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.Timestamp;

public class AgentSearchController extends PageControllerUI {

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
    protected void onLeave(){}

    @Override
    protected void onLoad(){}


}
