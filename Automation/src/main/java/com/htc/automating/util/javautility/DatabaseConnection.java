package com.htc.automating.util.javautility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import com.htc.automating.globalvariables.GlobalVariables;

public class DatabaseConnection {
	
	public static Connection getConnection() throws MyException  {
		try {
			Loggers.info(DatabaseConnection.class.getName(), "Starting DBConnection");
			LoadPropertyFile file =LoadPropertyFile.getInstance();
			Properties prop=file.getProperty(GlobalVariables.DB_PROPERTIES_FILE_PATH);
			Class.forName(prop.getProperty("driver"));
			Connection connect = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
			Loggers.info(DatabaseConnection.class.getName(), "DBConnection established successfully");
			return connect;
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
}
