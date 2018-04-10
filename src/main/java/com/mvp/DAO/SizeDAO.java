package com.mvp.DAO;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvp.model.Material;
import com.mvp.model.ShoeSize;
import com.mvp.model.SizeProduct;

public class SizeDAO {

	private static SizeDAO instance;
	
	public SizeDAO() {
		
	}

	public static SizeDAO getInstance() {
		if(instance == null)
			instance = new SizeDAO();
		return instance;
	}

	public static void setInstance(SizeDAO instance) {
		SizeDAO.instance = instance;
	}
	
	public List<SizeProduct> GetSizeList() {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<SizeProduct> lst = new ArrayList<SizeProduct>();
			ResultSet rs;
			   String SQL = "{call spGetSizeList}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   SizeProduct cl = new SizeProduct(rs.getInt(1),rs.getInt(2));
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
	
	public ShoeSize GetSizeByID(int ID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			String SQL = "{call spGetSizeByID(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setInt(1, ID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				return new ShoeSize(rs.getInt(1),rs.getInt(2));
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
