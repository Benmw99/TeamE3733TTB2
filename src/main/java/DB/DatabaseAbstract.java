package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Abstract class for the constructors of all the lower classes
public abstract class DatabaseAbstract {
    Connection connection;

    protected DatabaseAbstract(String path){
        try {
            String driver = "org.apache.derby.jdbc.EmbeddedDriver";
            Class.forName(driver).newInstance();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        try {
            connection = DriverManager.getConnection("jdbc:derby:" + path + ";create=true");
        } catch (SQLException e){
            System.out.println(e.toString());
        }
    }
}
