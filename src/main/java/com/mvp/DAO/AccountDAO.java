package com.mvp.DAO;

import com.mvp.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

	private static AccountDAO instance;
	
	public AccountDAO() {
		
	}

	public static AccountDAO getInstance() {
		if(instance == null)
			instance = new AccountDAO();
		return instance;
	}

	public static void setInstance(AccountDAO instance) {
		AccountDAO.instance = instance;
	}
	
	public Account CheckLogin(String username, String password)
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spDangNhapKhachHang(?,?)}" ;
		ResultSet rs;
		try {
			cstmt = conn.prepareCall(SQL);
			cstmt.setString(1, username);
			cstmt.setString(2, password);
			rs =  cstmt.executeQuery();
			if (rs.next())
			{
				Account acc = new Account(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				return acc;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Account> GetAccountList() {
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Account> lst = new ArrayList<Account>();
			ResultSet rs;
			   String SQL = "{call spGetAccountList}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Account ac = new Account(rs.getString(1),rs.getString(2),rs.getString(4),rs.getInt(3));
				   lst.add(ac);
			   }
			   return lst;
			}
		catch (SQLException e) {
			 	e.printStackTrace();
		}
		finally {
			   try {
				   cstmt.close();
			   }catch (SQLException e) {
				e.printStackTrace();
			   }
		}
		return null;
	}
	
	public boolean AddCustomerAcc(String username, String password, String name, String phoneNo, String gender,  String DOB) {
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		
		String SQL = "{call spDangKyKhachHang(?,?,?,?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, name);
			cstmt.setString(2, phoneNo);
			cstmt.setString(3, DOB);
			cstmt.setString(4, gender);
			cstmt.setString(5, username);
			cstmt.setString(6, password);
			
			return cstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;		
	}
	
}
