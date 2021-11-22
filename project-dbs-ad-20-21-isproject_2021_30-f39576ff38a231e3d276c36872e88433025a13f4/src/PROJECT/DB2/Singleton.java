/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PROJECT.DB2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Deny Prasetyo
 */
public class Singleton {

    // deze klasse mag weg volgens mij?? (vraag)

    private static Singleton instance;
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/jdbc";
    private String username = "root";
    private String password = "localhost";

    private Singleton() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Singleton getInstance() throws SQLException {
        if (instance == null) {
            instance = new Singleton();
        } else if (instance.getConnection().isClosed()) {
            instance = new Singleton();
        }

        return instance;
    }
}
