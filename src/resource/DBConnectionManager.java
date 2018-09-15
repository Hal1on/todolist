package resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    private Connection connection;

    public DBConnectionManager() {
        String driver = ConfigurationManager.getProperty("jdbc.driver");
        String url = ConfigurationManager.getProperty("jdbc.url");
        String username = ConfigurationManager.getProperty("jdbc.username");
        String password = ConfigurationManager.getProperty("jdbc.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
}
