package UI;

import Entities.AlcoholType;
import Entities.Form;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import com.jfoenix.controls.*;

import java.sql.Timestamp;
@Deprecated
public class ManSearchController extends PageControllerUI  {

    @FXML
    JFXTextField SearchSource;

    @FXML
    JFXTextField SearchSerialNumber;

    @FXML
    JFXTextField SearchAlcoholType;

    @FXML
    JFXTextField SearchBrandName;

    @FXML
    TextField SearchFancifulName;

    @FXML
    TextField SearchWineVintageYear;

    @FXML
    TextField SearchWinePH;

    @FXML
    JFXTextField SearchAlcoholContent;

    @FXML
    JFXTextField SearchManufacturerName;

    @FXML
    JFXTextField SearchOriginState;

    @FXML
    JFXTextField SearchOriginCity;

    @FXML
    TextField SearchWineGrapeVarietal;

    @FXML
    TextField SearchWineAppellation;

    @FXML
    JFXTextField SearchTimestamp;

    @FXML
    JFXTextField SearchTTBID;

    @FXML
    TextField SearchNumResults;

    @FXML
    JFXButton SearchSearchLineText;

    @FXML
    JFXButton SearchSubmitSearch;

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
