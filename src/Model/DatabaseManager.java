/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;

/**
 *
 * @author abtahi
 */
public class DatabaseManager {

    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    final String USER = "root";
    final String PASS = "minhaz068117";

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    @SuppressWarnings("CallToPrintStackTrace")
    public DatabaseManager() {
        try {
            System.out.println("Registering Driver...");
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to Database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected.");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticateUser(User user) throws SQLException {
        
        String query = "SELECT * FROM users WHERE username ='" + user.getUserName()
                + "' AND password ='" + user.getPassword() + "'";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                return true;
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw e;
        }
        return false;
    }
}
