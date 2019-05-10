package dataAccess.impl;

import dataAccess.exceptions.ConnectionException;

import java.sql.*;

public class SingletonConnection {
    private static Connection uniqueConnection;

    public static Connection getInstance() {
        if (uniqueConnection == null) {
            try {
                uniqueConnection = DriverManager.getConnection("jdbc:mysql://localhost/sallefitness?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", "root", "1234");
            } catch (SQLException e) {
                throw new ConnectionException(e);
            }
        }
        return uniqueConnection;
    }
}
