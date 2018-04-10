package com.mvp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mvp.model.Import;
import com.mvp.model.Material;
import com.mvp.model.Producer;

public class ImportDAO {
private static ImportDAO instance;
	
	public ImportDAO() {
		
	}

	public static ImportDAO getInstance() {
		if(instance == null)
			instance = new ImportDAO();
		return instance;
	}

	public static void setInstance(ImportDAO instance) {
		ImportDAO.instance = instance;
	}
	
	public Import GetImportByID(int ID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			String SQL = "{call spGetImportByID(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setInt(1, ID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Date date;
				Timestamp timestamp = rs.getTimestamp(4);
				date = new Date(timestamp.getTime());
				return new Import(rs.getInt(1),rs.getString(2),rs.getInt(3),date,rs.getString(5));
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
	
	public List<Import> GetImportListByTime() {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Import> lst = new ArrayList<Import>();
			ResultSet rs;
			   String SQL = "{call spGetListImportByTime}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Date date;
				   Timestamp timestamp = rs.getTimestamp(4);
				   date = new Date(timestamp.getTime());
				   Import ac = new Import(rs.getInt(1),rs.getString(2),rs.getInt(3),date,rs.getString(5));
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
	
	public List<Import> GetImportListByTotal() {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Import> lst = new ArrayList<Import>();
			ResultSet rs;
			   String SQL = "{call spGetListImportByTotal}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Date date;
				   Timestamp timestamp = rs.getTimestamp(4);
				   date = new Date(timestamp.getTime());
				   Import ac = new Import(rs.getInt(1),rs.getString(2),rs.getInt(3),date,rs.getString(5));
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
	
	public List<Import> GetImportListByQuantity() {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Import> lst = new ArrayList<Import>();
			ResultSet rs;
			   String SQL = "{call spGetListImportByQuantity}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Date date;
				   Timestamp timestamp = rs.getTimestamp(4);
				   date = new Date(timestamp.getTime());
				   Import ac = new Import(rs.getInt(1),rs.getString(2),rs.getInt(3),date,rs.getString(5));
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
}
