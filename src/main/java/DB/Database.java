package DB;

//This is the overarching database class that controls all lower pieces and is a singleton
public class Database {
    private static Database database_instance = null;
    public TableBuilder tableBuilder;
    public DBSelect dbSelect;
    public DBInsert dbInsert;

    private Database() {
        tableBuilder = TableBuilder.getInstance();
        dbSelect = DBSelect.getInstance();
        dbInsert = DBInsert.getInstance();
    }

    /**
     * Gets the one instance of the class making it a singleton
     * @author Jordan
     * @return The current instance of DBSelect
     */
    public static Database getInstance() {
        if (database_instance == null) {
            database_instance = new Database();
        }
        return database_instance;
    }
}
