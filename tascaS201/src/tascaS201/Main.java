package tascaS201;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // Load configuration from external source (e.g., properties file)
        Properties config = loadConfiguration();
        
        String url = config.getProperty("jdbc:mysql://localhost:3306/universidad");
        String username = config.getProperty("root");
        String password = config.getProperty("78446660579");

        // Use try-with-resources for automatic resource management
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected successfully to the database!");
            
            // ... database operations ...
            
        } catch (SQLException ex) {
            System.err.println("Database connection error:");
            System.err.println("Message: " + ex.getMessage());
            System.err.println("SQL State: " + ex.getSQLState());
            System.err.println("Error Code: " + ex.getErrorCode());
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("JDBC Driver not found: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static Properties loadConfiguration() {
        Properties prop = new Properties();
        try {
            // Load from external configuration file
            prop.load(Main.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            System.err.println("Error loading configuration: " + e.getMessage());
            // Set default values or exit
            prop.setProperty("db.url", "jdbc:mysql://localhost:3306/universidad");
            prop.setProperty("db.username", "root");
            prop.setProperty("db.password", "");
        }
        return prop;
    }
}