package DB;

import Entities.Address;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//This is the class for controlling all the lower database classes. Singleton class and all classes controlled are singletons
//TODO FIGURE OUT HOW TO STOP INFO FROM HIBERNATE
public class Database {
    private static Database database;
    public TableBuilder tableBuilder;
    public DBSelect dbSelect;
    public DBInsert dbInsert;
    public MongoFunc mongoFunc;
    private static SessionFactory factory;

    private Database() {
        tableBuilder = TableBuilder.getTablebuilder();
        dbSelect = DBSelect.getDbselect();
        dbInsert = DBInsert.getDbinsert();
        mongoFunc = MongoFunc.getMongoFunc();
        try {
            //factory = new Configuration().configure().buildSessionFactory();
            //So this is like not the technically correct way to initialize annotated class factories but it works fine sooooooo I'm keeping it
            factory = new Configuration().configure().addAnnotatedClass(Address.class).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        dbSelect.setFactory(factory);
        dbInsert.setFactory(factory);
    }

    private static class SingletonHelper {
        private static final Database database = new Database();
    }

    public static Database getDatabase() {
        return SingletonHelper.database;
    }

    //This shuts down hibernate completely
    public void shutdown() {
        factory.close();
    }
}
