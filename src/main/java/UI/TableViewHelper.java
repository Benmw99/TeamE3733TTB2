package UI;

public class TableViewHelper {

    public ITableView controller;

    public TableViewHelper(ITableView controller){
        this.controller = controller;
        this.controller.setTableViewHelper(this);
    }
}
