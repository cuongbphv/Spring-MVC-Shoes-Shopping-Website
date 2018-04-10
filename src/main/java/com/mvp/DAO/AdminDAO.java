package com.mvp.DAO;

import com.mvp.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

	private static AdminDAO instance;
	
	public AdminDAO() {
		
	}

	public static AdminDAO getInstance() {
		if(instance == null)
			instance = new AdminDAO();
		return instance;
	}
	
	
	public boolean UpdateFeature(String iD, String value){		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_UpdateAdminFeature(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			cstmt.setString(1, iD);
			cstmt.setString(2, value);
			
			return cstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;		
	}
	
	
	public boolean UpdateBanner(String iD, byte[] hinh){		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_UpdateBanner(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			cstmt.setString(1, iD);
			cstmt.setBytes(2, hinh);
			
			return cstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;		
	}
	
	
	public AdminFeature GetFeatureByID(String ID){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			   String SQL = "{call sp_GetFeatureByID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setString(1, ID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   return new AdminFeature(rs.getString(1),rs.getString(2),rs.getString(3));
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
	
	
	public Banner GetBannerByID(String ID){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			   String SQL = "{call sp_GetBannerByID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setString(1, ID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   return new Banner(rs.getString(1),rs.getString(2),rs.getBytes(3));
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
	
	
	public List<Banner> GetListBanner(){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			   String SQL = "{call sp_GetListBanner}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   
			   List<Banner> lst = new ArrayList<Banner>();
			   while(rs.next())
			   {
				   Banner bn =  new Banner(rs.getString(1),rs.getString(2),rs.getBytes(3));
				   lst.add(bn);
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
	
	
	public List<AdminFeature> GetListFeature(){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			   String SQL = "{call sp_GetListFeature}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   
			   List<AdminFeature> lst = new ArrayList<AdminFeature>();
			   while(rs.next())
			   {
				   AdminFeature bn =  new AdminFeature(rs.getString(1),rs.getString(2),rs.getString(3));
				   lst.add(bn);
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
	
	public List<Logs> GetListLogs()
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			   String SQL = "{call sp_GetLogs}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   
			   List<Logs> lst = new ArrayList<Logs>();
			   while(rs.next())
			   {
				   Date date;
				   Timestamp timestamp = rs.getTimestamp(2);
				   date = new Date(timestamp.getTime());
				   
				   Logs bn =  new Logs(rs.getInt(1),date,rs.getString(3));
				   lst.add(bn);
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
	
}