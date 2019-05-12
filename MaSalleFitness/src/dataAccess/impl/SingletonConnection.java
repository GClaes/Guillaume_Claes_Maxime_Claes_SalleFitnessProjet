package dataAccess.impl;

import dataAccess.exceptions.SingletonConnectionException;

import java.sql.*;

public class SingletonConnection {
    private static Connection uniqueConnection;

    public static Connection getInstance() {
        if (uniqueConnection == null) {
            try {
                uniqueConnection = DriverManager.getConnection("jdbc:mysql://localhost/dbsallefitness?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", "root", "1234");
            } catch (SQLException e) {
                throw new SingletonConnectionException(e);
            }
        }
        return uniqueConnection;
    }
}
