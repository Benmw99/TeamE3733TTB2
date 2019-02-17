package DB;

import Entities.Address;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.ogm.cfg.OgmConfiguration;

//This is the class for controlling all the lower database classes. Singleton class and all classes controlled are singletons
//TODO FIGURE OUT HOW TO STOP INFO FROM HIBERNATE
public class Database {
    private static Database database;
    public TableBuilder tableBuilder;
    public DBSelect dbSelect;
    public DBInsert dbInsert;
    private static SessionFactory factory;

    private Database() {
        tableBuilder = TableBuilder.getTablebuilder();
        dbSelect = DBSelect.getDbselect();
        dbInsert = DBInsert.getDbinsert();
        try {
            ////factory = new Configuration().configure().buildSessionFactory();
            //factory = new Configuration().configure().addAnnotatedClass(Address.class).buildSessionFactory();
            Configuration cfg = new OgmConfiguration();

            //assuming you are using JTA in a non contained environment
            cfg.setProperty(environment.TRANSACTION_STRATEGY, "org.hibernate.transaction.JTATransactionFactory");
            //assuming JBoss TransactionManager in standalone mode
            cfg.setProperty(Environment.JTA_PLATFORM, "org.hibernate.service.jta.platform.internal.JBossStandAloneJtaPlatform");
            //assuming the default infinispan settings
            cfg.setProperty("hibernate.ogm.datastore.provider", "mongoDB");
            //add your annotated classes
            cfg.addAnnotatedClass(Order.class).addAnnotatedClass(Item.class);
            //build the SessionFactory
            factory = cfg.buildSessionFactory();
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
