package com.revature.revabooks.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static ConnectionFactory connFactory = new ConnectionFactory();

	private Properties props = new Properties();

	private ConnectionFactory(){
		try {

			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream propsInput = loader.getResourceAsStream("application.properties");

			if (propsInput == null) {
				props.setProperty("url", System.getProperty("url"));
				props.setProperty("username", System.getProperty("username"));
				props.setProperty("password", System.getProperty("password"));
			} else {
				props.load(propsInput);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionFactory getInstance() {
		return connFactory;
	}

	public Connection getConnection(){
		Connection conn = null;
		try{
			// Force the JVM to load the PostGreSQL JDBC driver.
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(
					"jdbc:" +
							"postgresql://" +
							props.getProperty("url") +
							":5432" +
							"/postgres",
					props.getProperty("username"),
					props.getProperty("password")
			);
			if (conn == null) {
				conn = DriverManager.getConnection(
						"jdbc:" +
								"postgresql://" +
								System.getenv("url") +
								":5432" +
								"/postgres",
						System.getenv("username"),
						System.getenv("password")
				);
			}
		} catch(ClassNotFoundException | SQLException e) {
		    e.printStackTrace();
		}

		return conn;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Clone method not supported for singleton ConnectionFactory.");
	}
}
