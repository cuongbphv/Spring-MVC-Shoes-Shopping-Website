package com.mvp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvp.model.SizeProduct;
import com.mvp.model.Staff;

public class StaffDAO {
	private static StaffDAO instance;

	public StaffDAO() {

	}

	public static StaffDAO getInstance() {
		if(instance == null)
			instance = new StaffDAO();
		return instance;
	}

	public static void setInstance(StaffDAO instance) {
		StaffDAO.instance = instance;
	}

	public List<Staff> GetListStaff() {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Staff> lst = new ArrayList<Staff>();
			ResultSet rs;
			String SQL = "{call spGetListStaff}";

			cstmt = conn.prepareCall(SQL);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Staff st = new Staff(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getInt(7),rs.getString(8));
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

	public String GetStaffUsername(String id) {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			String username = ""; 
			ResultSet rs;
			String SQL = "{call spGetStaffUsernameByID(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setString(1, id);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				username = rs.getString(1);
			}
			return username;
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

	public Staff GetStaffByID(String ID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			String SQL = "{call sp_GetStaffByID(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setString(1, ID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				return new Staff(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8));
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
