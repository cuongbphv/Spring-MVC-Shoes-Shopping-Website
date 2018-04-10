package com.mvp.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.mvp.DAO.DataProvider;

public class DeliveryServices {
	private static DeliveryServices instance;

	public DeliveryServices() {
		
	}

	public static DeliveryServices getInstance() {
		if(instance == null)
			instance = new DeliveryServices();
		return instance;
	}

	public static void setInstance(DeliveryServices instance) {
		DeliveryServices.instance = instance;
	}
	
	public boolean SetDeliveryID(int orderID, String deliveryID) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spSetDeliveryID(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setInt(1, orderID);
			cstmt.setString(2, deliveryID);
			

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean SubmitOrderStateDelivery(int orderID, int state) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spSubmitOrderStateDelivery(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setInt(1, orderID);
			cstmt.setInt(2, state);
			

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
}
