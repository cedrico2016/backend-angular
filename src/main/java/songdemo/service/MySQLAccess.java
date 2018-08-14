package songdemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLAccess {
    private static final MySQLAccess ourInstance = new MySQLAccess();

    public static MySQLAccess getInstance() {
        return ourInstance;
    }

    private MySQLAccess() {
    }
    
    private String dbHost = System.getenv("DBHOST");

    private String dbPort = System.getenv("DBPORT");

    private String dbName = System.getenv("DBNAME");

    private String dbUser = System.getenv("DBUSER");

    private String dbPassword = System.getenv("DBPASSWORD");

    private static final String URL = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

    // private static final String USERNAME = "songuser";
    // private static final String PASSWORD = "songpass";

    public Connection getConnection() {
        Connection connection = null;

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");

            } catch (ClassNotFoundException e) {
                return null;
            }

            connection = DriverManager.getConnection(URL, dbUser, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
