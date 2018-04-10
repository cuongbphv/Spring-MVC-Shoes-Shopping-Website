package com.mvp.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.mvp.DAO.DataProvider;

public class CustomerTypeServices {
private static CustomerTypeServices instance;
	
	public CustomerTypeServices() {
		
	}

	public static CustomerTypeServices getInstance() {
		if(instance == null)
			instance = new CustomerTypeServices();
		return instance;
	}

	public static void setInstance(CustomerTypeServices instance) {
		CustomerTypeServices.instance = instance;
	}
	
	public boolean DeleteCustomerType(int iD){		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spDeleteCustomerType(?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			
			cstmt.setInt(1, iD);			
			
			return cstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;		
	}
	
	public boolean EditCustomerType(int iD, String newName, int discount, String levelMoney){		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spEditCustomerType(?,?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			cstmt.setInt(1, iD);
			cstmt.setString(2, newName);
			cstmt.setInt(3, discount);
			cstmt.setString(4, levelMoney);
			
			return cstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;		
	}
	
	public boolean AddCustomerType(String name, int discount, String levelMoney) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spAddCustomerType(?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, name);
			cstmt.setInt(2, discount);
			cstmt.setString(3, levelMoney);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
}
