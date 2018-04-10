package com.mvp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvp.model.Material;
import com.mvp.model.ProductType;

public class ProductTypeDAO {

	private static ProductTypeDAO instance;
	
	public ProductTypeDAO() {
		
	}

	public static ProductTypeDAO getInstance() {
		if(instance == null)
			instance = new ProductTypeDAO();
		return instance;
	}

	public static void setInstance(ProductTypeDAO instance) {
		ProductTypeDAO.instance = instance;
	}
	
	public List<ProductType> GetProductTypeList() {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<ProductType> lst = new ArrayList<ProductType>();
			ResultSet rs;
			   String SQL = "{call spGetProductTypeList}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   ProductType ac = new ProductType(rs.getInt(1),rs.getString(2));
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
	
	public ProductType GetProductTypeByID(int ID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			String SQL = "{call spGetProductTypeByID(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setInt(1, ID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				return new ProductType(rs.getInt(1),rs.getString(2));
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
