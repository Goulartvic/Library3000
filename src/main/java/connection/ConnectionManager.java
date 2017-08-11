package connection;

import java.sql.*;

public class ConnectionManager {

    public ConnectionManager() throws ClassNotFoundException {
        connection();
    }

    public Connection connection() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/librarytest", "root", "root");
     
            return connection;
        } catch (SQLException e) {
            System.err.println("error:" + e);
            return null;
        }
    }

    public static void main(String[] args) {

    }

}