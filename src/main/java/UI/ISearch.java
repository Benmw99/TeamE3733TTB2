package UI;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public interface ISearch extends ITableView {

    TextField getSearchSource();

    TextField getSearchSerialNumber();

    TextField getSearchAlcoholType();

    TextField getSearchBrandName();

    TextField getSearchFancifulName();

    TextField getSearchWineVintageYear();

    TextField getSearchWinePH();

    TextField getSearchWineGrapeVarietal();

    TextField getSearchWineAppellation();

    TextField getSearchTimestamp();

    TextField getSearchTTBID();

    TextField getSearchNumResults();

    Button getSearchSubmitSearch();

}
