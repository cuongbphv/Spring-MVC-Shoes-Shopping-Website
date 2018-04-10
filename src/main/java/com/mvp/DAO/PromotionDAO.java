package com.mvp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvp.model.*;


public class PromotionDAO {
	
	private static PromotionDAO instance;
	
	public PromotionDAO() {
		
	}

	public static PromotionDAO getInstance() {
		if(instance == null)
			instance = new PromotionDAO();
		return instance;
	}

	public static void setInstance(PromotionDAO instance) {
		PromotionDAO.instance = instance;
	}
	
	public List<Promotion> GetPromotionList() {
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Promotion> lst = new ArrayList<Promotion>();
			ResultSet rs;
			   String SQL = "{call sp_GetListPromotion}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Promotion ac = new Promotion(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDate(4),rs.getDate(5));
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
	
	public List<Promotion> GetPromotionValidList() {
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Promotion> lst = new ArrayList<Promotion>();
			ResultSet rs;
			   String SQL = "{call spGetListPromotionValid}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Promotion ac = new Promotion(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDate(4),rs.getDate(5));
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
	
	public List<Promotion> GetPromotionInvalidList() {
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Promotion> lst = new ArrayList<Promotion>();
			ResultSet rs;
			   String SQL = "{call spGetListPromotionInvalid}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Promotion ac = new Promotion(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDate(4),rs.getDate(5));
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

	public Promotion GetAvailablePromotionByID(String ID) {
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			   String SQL = "{call sp_GetAvailablePromotionByID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setString(1, ID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   return new Promotion(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDate(4),rs.getDate(5));
			   }
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
	
	
	public Promotion GetPromotionByID(String ID) {
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			   String SQL = "{call sp_GetPromotionByID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setString(1, ID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   return new Promotion(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDate(4),rs.getDate(5));
			   }
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
	
}