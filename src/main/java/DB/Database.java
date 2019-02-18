package DB;

import Entities.Address;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;

//This is the class for controlling all the lower database classes. Singleton class and all classes controlled are singletons
public class Database {
    private static Database database;
    public TableBuilder tableBuilder;
    public DBSelect dbSelect;
    public DBInsert dbInsert;
    public FirebaseFunc firebaseFunc;
    private static SessionFactory factory;

    private Database() {
        tableBuilder = TableBuilder.getTablebuilder();
        dbSelect = DBSelect.getDbselect();
        dbInsert = DBInsert.getDbinsert();
        firebaseFunc = FirebaseFunc.getFirebaseFunc();
        try {
            //factory = new Configuration().configure().buildSessionFactory();
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
