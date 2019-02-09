package DB;

public class DBSelect {
    private static DBSelect dbselect;

    private DBSelect() { }

    private static class SingletonHelper {
        private static final DBSelect dbselect = new DBSelect();
    }

    public static DBSelect getDbselect() {
        return SingletonHelper.dbselect;
    }


}
