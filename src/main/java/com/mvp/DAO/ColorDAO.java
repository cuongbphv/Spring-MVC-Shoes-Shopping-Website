package com.mvp.DAO;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvp.model.Color;
import com.mvp.model.Material;
import com.mvp.model.Producer;

public class ColorDAO {

	private static ColorDAO instance;
	
	public ColorDAO() {
		
	}

	public static ColorDAO getInstance() {
		if(instance == null)
			instance = new ColorDAO();
		return instance;
	}

	public static void setInstance(ColorDAO instance) {
		ColorDAO.instance = instance;
	}
	
	public List<Color> GetColorList() {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Color> lst = new ArrayList<Color>();
			ResultSet rs;
			   String SQL = "{call spGetColorList}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Color cl = new Color(rs.getInt(1),rs.getString(2),rs.getBytes(4));
				   lst.add(cl);
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
	
	
	public Color GetColorByID(int ID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			String SQL = "{call spGetColorByID(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setInt(1, ID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				return new Color(rs.getInt(1),rs.getString(2),rs.getBytes(4));
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
