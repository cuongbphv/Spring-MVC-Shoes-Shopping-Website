package com.mvp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvp.model.Staff;
import com.mvp.model.Support;

public class SupportDAO {

	private static SupportDAO instance;

	public SupportDAO() {

	}

	public static SupportDAO getInstance() {
		if(instance == null)
			instance = new SupportDAO();
		return instance;
	}

	public static void setInstance(SupportDAO instance) {
		SupportDAO.instance = instance;
	}
	
	public Support GetSupportByID(int supportID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			String SQL = "{call spGetSupportingRequireBySupportID(?)}";

			cstmt = conn.prepareCall(SQL);
			
			cstmt.setInt(1, supportID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				return new Support(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getDate(5),rs.getString(6),
						   rs.getInt(7),rs.getBoolean(8));
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
