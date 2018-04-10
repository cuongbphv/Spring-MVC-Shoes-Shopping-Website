package com.mvp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvp.model.Guarantee;
import com.mvp.model.Material;
import com.mvp.model.Support;

public class GuaranteeDAO {
	private static GuaranteeDAO instance;
	
	public GuaranteeDAO() {
		
	}

	public static GuaranteeDAO getInstance() {
		if(instance == null)
			instance = new GuaranteeDAO();
		return instance;
	}

	public static void setInstance(GuaranteeDAO instance) {
		GuaranteeDAO.instance = instance;
	}
	
	public List<Guarantee> GetGuaranteeListByID(int cusID) {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Guarantee> lst = new ArrayList<Guarantee>();
			ResultSet rs;
			   String SQL = "{call spGetGuaranteeListByID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   cstmt.setInt(1, cusID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Guarantee ac = new Guarantee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getDate(5),rs.getString(6),
						   rs.getDate(7),rs.getString(8),rs.getBoolean(9));
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
	
	public List<Support> GetSupportingRequireListByID(int cusID) {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Support> lst = new ArrayList<Support>();
			ResultSet rs;
			   String SQL = "{call spGetSupportingRequireByID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   cstmt.setInt(1, cusID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Support ac = new Support(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getDate(5),rs.getString(6),
						   rs.getInt(7),rs.getBoolean(8));
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
	
	public List<Support> GetSupportingRequireList() {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Support> lst = new ArrayList<Support>();
			ResultSet rs;
			   String SQL = "{call spGetListSupportingRequire}";
			   
			   cstmt = conn.prepareCall(SQL);
			   		   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Support ac = new Support(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getDate(5),rs.getString(6),
						   rs.getInt(7),rs.getBoolean(8));
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
	
	
	public List<Guarantee> GetGuaranteeList() {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Guarantee> lst = new ArrayList<Guarantee>();
			ResultSet rs;
			   String SQL = "{call spGetListGuarantee}";
			   
			   cstmt = conn.prepareCall(SQL);
			   		   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Guarantee ac = new Guarantee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getDate(5),rs.getString(6),
						   rs.getDate(7),rs.getString(8),rs.getBoolean(9));
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
	
	public Guarantee GetGuaranteeByID(int supportID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			String SQL = "{call spGetGuaranteeStaffByID(?)}";

			cstmt = conn.prepareCall(SQL);
			
			cstmt.setInt(1, supportID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				return new Guarantee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getDate(5),rs.getString(6),
						   rs.getDate(7),rs.getString(8),rs.getBoolean(9));
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
