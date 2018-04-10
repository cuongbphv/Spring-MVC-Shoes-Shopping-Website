package com.mvp.services;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvp.*;
import com.mvp.DAO.AccountDAO;
import com.mvp.DAO.DataProvider;

public class AccountServices {

	private static AccountServices instance;
	
	public AccountServices() {
		
	}

	public static AccountServices getInstance() {
		if(instance == null)
			instance = new AccountServices();
		return instance;
	}

	public static void setInstance(AccountServices instance) {
		AccountServices.instance = instance;
	}
	
	public boolean CheckExistAccount(String username){
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		ResultSet rs =null;
		String SQL = "{call sp_CheckExistAccount(?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, username);
			
			rs = cstmt.executeQuery();
			
			if(rs.next())
			{
				if(rs.getString(1).equals("1"))
					return true;
				else
					return false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean resetCustomerPass(String cusID, String pass)
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_ResetPassCustomer(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
		
			cstmt.setString(1, cusID);
			cstmt.setString(2, pass);
			
			return cstmt.executeUpdate() > 0;
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
