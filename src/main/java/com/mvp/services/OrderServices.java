package com.mvp.services;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.mvp.*;
import com.mvp.DAO.AccountDAO;
import com.mvp.DAO.DataProvider;

public class OrderServices {

	private static OrderServices instance;
	
	public OrderServices() {
		
	}

	public static OrderServices getInstance() {
		if(instance == null)
			instance = new OrderServices();
		return instance;
	}

	public static void setInstance(OrderServices instance) {
		OrderServices.instance = instance;
	}
	
	
	
	public int SetOrder(int cusID, String discountCode,String address)
	{
		int orderID;
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_AddOrder(?,?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setInt(2, cusID);
			cstmt.setString(3, discountCode);
			cstmt.setString(4, address);
			
			cstmt.execute();
			
			orderID = cstmt.getInt(1);
			return orderID;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	
	public boolean SetOrderDetail(int orderID, String productID, int colorID, int sizeID, int quantity, String price)
	{
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_InsertOrderDetail(?,?,?,?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setInt(1, orderID);
			cstmt.setString(2, productID);
			cstmt.setInt(3, colorID);
			cstmt.setInt(4, sizeID);
			cstmt.setInt(5, quantity);
			cstmt.setString(6, price);
			
			return cstmt.executeUpdate() > 0;
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean CancelOrder(int OrderID, int cusID)
	{
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spCancelOrderByID(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setInt(1, OrderID);
			cstmt.setInt(2, cusID);
			
			return cstmt.executeUpdate() > 0 ;
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
