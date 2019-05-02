package dataAccess;

import dataAccess.exceptions.AjoutCandidatException;

import java.sql.*;

public class SingletonConnection {
    private static Connection uniqueConnection;

    public static Connection getInstance() throws AjoutCandidatException {
        if (uniqueConnection == null) {
            try {
                uniqueConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sallefitness", "root", "1234");
            } catch (SQLException e) {
                throw new AjoutCandidatException();
            }
        }
        return uniqueConnection;
    }
}
