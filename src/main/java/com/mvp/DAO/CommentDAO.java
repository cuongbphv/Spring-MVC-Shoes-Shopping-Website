package com.mvp.DAO;

import com.mvp.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {

	private static CommentDAO instance;
	
	public CommentDAO() {
		
	}

	public static CommentDAO getInstance() {
		if(instance == null)
			instance = new CommentDAO();
		return instance;
	}

	public static void setInstance(CommentDAO instance) {
		CommentDAO.instance = instance;
	}
	
	
	public List<Comment> GetTopCommentByProductID(String productID)
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Comment> lst = new ArrayList<Comment>();
			ResultSet rs;
			   String SQL = "{call sp_GetTopCommentByProductID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setString(1, productID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Comment ac = new Comment(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getString(6));
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
	
	
	public List<Comment> GetAllCommentByProductID(String productID)
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Comment> lst = new ArrayList<Comment>();
			ResultSet rs;
			   String SQL = "{call sp_GetAllCommentByProductID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setString(1, productID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Comment ac = new Comment(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getString(6));
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
	
	public int CheckExistComment(String productID, int cusID)
	{
		ResultSet rs;
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_CheckExistComment(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setInt(2, cusID);
			cstmt.setString(1, productID);
			
			rs = cstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int CountComment(String productID) {
		ResultSet rs;
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_CountComment(?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, productID);
			
			rs = cstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	public float GetStar(String productID) {
		ResultSet rs;
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_GetStar(?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, productID);
			
			rs = cstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getFloat(1);
			}
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
}