package com.mvp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvp.model.Material;
import com.mvp.model.Staff;
import com.mvp.model.StaffType;

public class StaffTypeDAO {
	private static StaffTypeDAO instance;
	
	public StaffTypeDAO() {
		
	}

	public static StaffTypeDAO getInstance() {
		if(instance == null)
			instance = new StaffTypeDAO();
		return instance;
	}

	public static void setInstance(StaffTypeDAO instance) {
		StaffTypeDAO.instance = instance;
	}
	
	public List<StaffType> GetStaffTypeList() {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<StaffType> lst = new ArrayList<StaffType>();
			ResultSet rs;
			   String SQL = "{call spGetStaffTypeList}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   StaffType st = new StaffType(rs.getInt(1),rs.getString(2));
				   lst.add(st);
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
	
	public StaffType GetStaffTypeByID(int ID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			String SQL = "{call spGetStaffTypeByID(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setInt(1, ID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				return new StaffType(rs.getInt(1),rs.getString(2));
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
