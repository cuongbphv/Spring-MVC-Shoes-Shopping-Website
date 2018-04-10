package com.mvp.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.mvp.DAO.DataProvider;

public class SizeServices {

private static SizeServices instance;
	
	public SizeServices() {
		
	}

	public static SizeServices getInstance() {
		if(instance == null)
			instance = new SizeServices();
		return instance;
	}

	public static void setInstance(SizeServices instance) {
		SizeServices.instance = instance;
	}
	
	public boolean DeleteSize(int iD){		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spDeleteSize(?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			cstmt.setInt(1, iD);			
			return cstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;		
	}
	
	public boolean EditSize(int iD, int newName){		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spEditSize(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			cstmt.setInt(1, iD);
			cstmt.setInt(2, newName);
			return cstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;		
	}
	
	public boolean AddSize(int name) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spAddSize(?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setInt(1, name);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
}
