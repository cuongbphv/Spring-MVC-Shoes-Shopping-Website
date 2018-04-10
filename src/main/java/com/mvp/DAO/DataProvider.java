package com.mvp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataProvider {
	private static Connection conn;
	
	private static DataProvider instance;

	private DataProvider() {

    }

    private static String ConnectionString = "jdbc:sqlserver://localhost:1433;databaseName=MVPFinal;user=sa;password=03091997;integratedSecurity=true;";
    
    public static DataProvider getInstance() {
		if(instance == null)
			instance = new DataProvider();
		return instance;
	}

	public static void setInstance(DataProvider instance) {
		DataProvider.instance = instance;
	}

	
	public Connection getConn() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(ConnectionString);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (SQLException e)
        {
        	e.printStackTrace();
        }
        return conn;
	}
    
}
