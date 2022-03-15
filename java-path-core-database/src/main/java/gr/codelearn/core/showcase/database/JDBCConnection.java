package gr.codelearn.core.showcase.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCConnection {

    private static Connection connection;
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ed_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static void createJDBCConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database");
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connection with database was established successfully");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            createJDBCConnection();
        }
        return connection;
    }
}
