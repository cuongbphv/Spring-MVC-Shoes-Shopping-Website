package com.mvp.services;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvp.*;
import com.mvp.DAO.AccountDAO;
import com.mvp.DAO.DataProvider;

public class CommentServices {

	private static CommentServices instance;
	
	public CommentServices() {
		
	}

	public static CommentServices getInstance() {
		if(instance == null)
			instance = new CommentServices();
		return instance;
	}

	public static void setInstance(CommentServices instance) {
		CommentServices.instance = instance;
	}
	
	public boolean addComment(String productID, int cusID, String title, int star, String content)
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_AddComment(?,?,?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setInt(2, cusID);
			cstmt.setString(1, productID);
			cstmt.setString(3, title);
			cstmt.setInt(4, star);
			cstmt.setString(5, content);
			
			return cstmt.executeUpdate() > 0;
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
