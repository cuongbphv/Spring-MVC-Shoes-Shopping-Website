package com.mvp.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.mvp.DAO.DataProvider;

public class ColorServices {

private static ColorServices instance;
	
	public ColorServices() {
		
	}

	public static ColorServices getInstance() {
		if(instance == null)
			instance = new ColorServices();
		return instance;
	}

	public static void setInstance(ColorServices instance) {
		ColorServices.instance = instance;
	}
	
	public boolean DeleteColor(int iD){		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spDeleteColor(?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			cstmt.setInt(1, iD);			
			return cstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;		
	}
	
	public boolean EditColor(int iD, String newName){		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spEditColor(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			cstmt.setInt(1, iD);
			cstmt.setString(2, newName);
			return cstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;		
	}
	
	public boolean EditColorHasImage(int iD, String newName, byte[] image){		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spEditHasImage(?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);	
			
			cstmt.setInt(1, iD);
			cstmt.setString(2, newName);
			cstmt.setBytes(3, image);
			
			return cstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;		
	}
	
	public boolean AddColor(String name, byte[] image) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spAddColor(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, name);
			cstmt.setBytes(2, image);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
}
