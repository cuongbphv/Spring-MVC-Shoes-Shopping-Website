package com.mvp.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.mvp.DAO.DataProvider;

public class ProducerServices {

private static ProducerServices instance;
	
	public ProducerServices() {
		
	}

	public static ProducerServices getInstance() {
		if(instance == null)
			instance = new ProducerServices();
		return instance;
	}

	public static void setInstance(ProducerServices instance) {
		ProducerServices.instance = instance;
	}
	
	public boolean DeleteProducer(int iD){		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spDeleteProducer(?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			cstmt.setInt(1, iD);			
			return cstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;		
	}
	
	public boolean EditProducer(int iD, String newName, String newAddress, String newPhoneNumber){		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spEditProducer(?,?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			cstmt.setInt(1, iD);
			cstmt.setString(2, newName);
			cstmt.setString(3, newAddress);
			cstmt.setString(4, newPhoneNumber);
			return cstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;		
	}
	
	public boolean AddProducer(String name, String address, String phoneNumber) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spAddProducer(?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, name);
			cstmt.setString(2, address);
			cstmt.setString(3, phoneNumber);
			
			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
}
