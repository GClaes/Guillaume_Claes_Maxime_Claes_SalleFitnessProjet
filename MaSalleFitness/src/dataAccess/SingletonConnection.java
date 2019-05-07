package dataAccess;

import dataAccess.exceptions.ConnectionException;

import java.sql.*;

public class SingletonConnection {
    private static Connection uniqueConnection;

    public static Connection getInstance() throws ConnectionException {
        if (uniqueConnection == null) {
            try {
                uniqueConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sallefitness?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
            } catch (SQLException e) {
                throw new ConnectionException(e);
            }
        }
        return uniqueConnection;
    }
}
