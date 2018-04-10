package com.mvp.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvp.DAO.DataProvider;
import com.mvp.DAO.ProductDAO;
import com.mvp.model.Product;

public class ProfileServices {
	
	private static ProfileServices instance;
	
	public ProfileServices() {
		
	}

	public static ProfileServices getInstance() {
		if(instance == null)
			instance = new ProfileServices();
		return instance;
	}

	public static void setInstance(ProfileServices instance) {
		ProfileServices.instance = instance;
	}
	
	public boolean EditProfile(String userID, int permission, String name, String dateOfBirth,
								String phoneNo, String gender, String address) {
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL;
		if(permission == 4) {
			SQL = "{call sp_EditProfileCustomer(?,?,?,?,?,?)}" ;
		}
		else {
			SQL = "{call sp_EditProfileStaff(?,?,?,?,?,?)}" ;
		}
		
		try {
			cstmt = conn.prepareCall(SQL);
			
			if(permission == 4) {
				cstmt.setInt(1, Integer.parseInt(userID));
			}
			else {
				cstmt.setString(1, userID);
			}
			cstmt.setString(2, name);
			cstmt.setString(3, dateOfBirth);
			cstmt.setString(4, phoneNo);
			cstmt.setString(5, gender);
			cstmt.setString(6, address);
			
			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			   try {
				   cstmt.close();
			   }catch (SQLException e) {
				e.printStackTrace();
			   }
		}
		
		return false;
	}
	
	
	public boolean ChangePass(String username,String pass,  String newPass) {

		CallableStatement cstmt = null;
		try {
			Connection conn= DataProvider.getInstance().getConn();
			String SQL = "{call sp_ChangePass(?,?,?)}";
			cstmt = conn.prepareCall(SQL);

			cstmt.setString(1, username);
			cstmt.setString(2, pass);
			cstmt.setString(3, newPass);

			return cstmt.executeUpdate()>0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				cstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}
	
}
