package com.revature.revabooks.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory connFactory = new ConnectionFactory();

    private ConnectionFactory(){
        super();
    }

    public static ConnectionFactory getInstance(){
        return connFactory;
    }


    public Connection getConnection(){
        Connection conn = null;

        try {
            // force the JVM to load the postgres jdbc driver
            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:postgresql://java-ng-usf-200727.cmgr36vlmagf.us-east-2.rds.amazonaws.com:5432/postgres",
                    "revabooks_app",
                    "revabooks");

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        if(conn == null){
            throw new RuntimeException("Failed to establish connection");
        }

        return conn;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
