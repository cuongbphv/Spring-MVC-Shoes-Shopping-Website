package com.mvp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvp.model.Account;
import com.mvp.model.Color;
import com.mvp.model.Material;

public class MaterialDAO {

	private static MaterialDAO instance;
	
	public MaterialDAO() {
		
	}

	public static MaterialDAO getInstance() {
		if(instance == null)
			instance = new MaterialDAO();
		return instance;
	}

	public static void setInstance(MaterialDAO instance) {
		MaterialDAO.instance = instance;
	}
	
	public List<Material> GetMaterialList() {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Material> lst = new ArrayList<Material>();
			ResultSet rs;
			   String SQL = "{call spGetMaterialList}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Material ac = new Material(rs.getInt(1),rs.getString(2));
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
	
	public Material GetMaterialByID(int ID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			String SQL = "{call spGetMaterialByID(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setInt(1, ID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				return new Material(rs.getInt(1),rs.getString(2));
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
