package com.mvp.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.mvp.DAO.DataProvider;

public class SupportServices {
private static SupportServices instance;
	
	public SupportServices() {
		
	}

	public static SupportServices getInstance() {
		if(instance == null)
			instance = new SupportServices();
		return instance;
	}

	public static void setInstance(SupportServices instance) {
		SupportServices.instance = instance;
	}
	
	public boolean AddNewGuarantee(String productID, int orderID, int customerID, String reason) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spAddNewGuarantee(?,?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, productID);
			cstmt.setInt(2, orderID);
			cstmt.setInt(3, customerID);
			cstmt.setString(4, reason);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean AddSupportingRequire(String questionSupport, int cusID) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spAddSupportingRequire(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, questionSupport);
			cstmt.setInt(2, cusID);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean AnswerSupport(int spID, String staffID, String answer) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spAnswerSupport(?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			
			cstmt.setInt(1, spID);
			cstmt.setString(2, staffID);
			cstmt.setString(3, answer);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean ReceiveGuarantee(int spID, String staffID) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spReceiveGuarantee(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			
			cstmt.setInt(1, spID);
			cstmt.setString(2, staffID);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean ReturnGuarantee(int spID, String date) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spReturnGuarantee(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			
			cstmt.setInt(1, spID);
			cstmt.setString(2, date);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean AddNewLog(String content) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spAddNewLog(?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			
			cstmt.setString(1, content);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
}
