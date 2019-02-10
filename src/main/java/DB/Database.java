package DB;

//This is the class for controlling all the lower database classes. Singleton class and all classes controlled are singletons
//TODO FIGURE OUT HOW TO STOP INFO FROM HIBERNATE
public class Database {
    private static Database database;
    public TableBuilder tableBuilder;
    public DBSelect dbSelect;
    public DBInsert dbInsert;

    private Database() {
        tableBuilder = TableBuilder.getTablebuilder();
        dbSelect = DBSelect.getDbselect();
        dbInsert = DBInsert.getDbinsert();
    }

    private static class SingletonHelper {
        private static final Database database = new Database();
    }

    public static Database getDatabase() {
        return SingletonHelper.database;
    }
}
