package UI;

import Entities.AlcoholType;
import Entities.Form;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.Timestamp;

public interface ITableView extends IPage {
    void setTableViewHelper(TableViewHelper helper);
    TableView<Form> getFormTable();
    TableColumn<Form, Integer> getTTBIDColumn();
    TableColumn<Form, Timestamp> getDateSubmittedColumn();
    TableColumn<Form, String> getBrandNameColumn();
    TableColumn<Form, AlcoholType> getTypeColumn();
    TableColumn<Form, String> getBrandColumn();
    TableColumn<Form, String> getSerialColumn();
}
