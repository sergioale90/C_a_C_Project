package infrastructura.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
        public static Connection getConnection() {
        Connection connection = null;
        String host = "localhost";
        String port = "3306";
        String username = "root";
        String password = "$ersistel4713088013";
        String nombreDB = "proyecto_cac";
        String driverClassName = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driverClassName);
            String url = "jdbc:mysql://localhost:3306/proyecto_cac";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
        return connection;
    }
}
