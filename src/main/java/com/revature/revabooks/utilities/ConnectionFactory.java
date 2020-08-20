package com.revature.revabooks.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory connFactory = new ConnectionFactory();

    private ConnectionFactory() {

    }

    public static ConnectionFactory getInstance() {
        return connFactory;
    }

    public Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("org.postgres.Driver");
            conn = DriverManager.getConnection("jdbc-url", "username", "password");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        if (conn == null) {
            throw new RuntimeException("Failed to establish connection");
        }
        return conn;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
