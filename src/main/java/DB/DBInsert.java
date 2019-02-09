package DB;

public class DBInsert {
    private static DBInsert dbinsert;

    private DBInsert() { }

    private static class SingletonHelper {
        private static final DBInsert dbinsert = new DBInsert();
    }

    public static DBInsert getDbinsert() {
        return SingletonHelper.dbinsert;
    }
}
