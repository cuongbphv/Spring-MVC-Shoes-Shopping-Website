package com.mvp.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvp.DAO.DataProvider;

public class PromotionServices {
	
	private static PromotionServices instance;
	
	public PromotionServices() {
		
	}

	public static PromotionServices getInstance() {
		if(instance == null)
			instance = new PromotionServices();
		return instance;
	}

	public static void setInstance(PromotionServices instance) {
		PromotionServices.instance = instance;
	}
	
	
	public boolean AddPromotion(String ID, int percent, String startTime, String endTime, String name) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_InsertPromotionAD(?,?,?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, ID);
			cstmt.setInt(2, percent);
			cstmt.setString(3, startTime);
			cstmt.setString(4, endTime);
			cstmt.setString(5, name);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean EditPromotion(String ID, int percent, String startTime, String endTime, String name) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_EditPromotionAD(?,?,?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, ID);
			cstmt.setInt(2, percent);
			cstmt.setString(3, startTime);
			cstmt.setString(4, endTime);
			cstmt.setString(5, name);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean DeletePromotion(String iD){
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_DeletePromotion(?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, iD);
			
			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	
}