package com.mvp.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.mvp.DAO.DataProvider;

public class StaffServices {

	private static StaffServices instance;
	
	public StaffServices() {
		
	}

	public static StaffServices getInstance() {
		if(instance == null)
			instance = new StaffServices();
		return instance;
	}

	public static void setInstance(StaffServices instance) {
		StaffServices.instance = instance;
	}
	
	
	public boolean AddStaff(String id, String name, String address, String phone, String date, String gender, String user,
			String password, int typeID) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spAddStaffAndAccount(?,?,?,?,?,?,?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, id);
			cstmt.setString(2, name);
			cstmt.setString(3, address);
			cstmt.setString(4, phone);
			cstmt.setString(5, date);
			cstmt.setString(6, gender);
			cstmt.setString(7, user);
			cstmt.setString(8, password);
			cstmt.setInt(9, typeID);
			

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean EditStaff(String id, String name, String address, String phone, String date, String gender, int typeID) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spEditStaffInfo(?,?,?,?,?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, id);
			cstmt.setString(2, name);
			cstmt.setString(3, address);
			cstmt.setString(4, phone);
			cstmt.setString(5, date);
			cstmt.setString(6, gender);
			cstmt.setInt(7, typeID);
			

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean ResetStaffPassword(String id, String pass)
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spResetPassword(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, id);
			cstmt.setString(2, pass);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean DeleteStaff(String id)
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spDeleteStaff(?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, id);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean ModifyOrderDetail(String pID, int orderID, int oldColorID, int oldSizeID
			, int newColorID, int newSizeID, int stocks) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {

			String SQL = "{call sp_ModifyOrderDetail(?,?,?,?,?,?,?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setInt(1, orderID);
			cstmt.setString(2, pID);
			cstmt.setInt(3, oldColorID);
			cstmt.setInt(4, oldSizeID);
			cstmt.setInt(5, newColorID);
			cstmt.setInt(6, newSizeID);
			cstmt.setInt(7, stocks);
			

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;

	}
	
	public boolean CancelOrderStaff(String staffID, int orderID) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_CancelOrderStaff(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, staffID);
			cstmt.setInt(2, orderID);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean ConfirmOrder(String staffID, int orderID) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_ConfirmOrder(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, staffID);
			cstmt.setInt(2, orderID);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean UpdateOrderState(int orderID) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_UpdateOrderState(?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setInt(1, orderID);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean UpdateBillState(int billID) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_UpdateBillState(?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setInt(1, billID);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
}
