package com.revature.revabooks.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory connFactory = new ConnectionFactory();

    private Properties props = new Properties();

    private ConnectionFactory() {

        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream propsInput = loader.getResourceAsStream("application.properties");

            if (propsInput == null) {
                return;
            }

            props.load(propsInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ConnectionFactory getInstance() {
        return connFactory;
    }

    public Connection getConnection() {

        Connection conn = null;

        try {

            // Force the JVM to load the PostGreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(
                    props.getProperty("url"),
                    props.getProperty("username"),
                    props.getProperty("password")
            );

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
