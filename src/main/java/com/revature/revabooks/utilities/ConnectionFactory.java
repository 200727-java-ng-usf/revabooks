package com.revature.revabooks.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // The next three blocks make it a singleton
    private static ConnectionFactory connFactory = new ConnectionFactory();

    private ConnectionFactory() {
        super();
    }

    public static ConnectionFactory getInstance() {
        return connFactory;
    }

    public Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection
                    ("jdbc:postgresql://java-project-0.ccfjhmis2yua.us-west-1.rds.amazonaws.com:5432/postgres",
                    "fake-username",
                            "fake-pass");

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
