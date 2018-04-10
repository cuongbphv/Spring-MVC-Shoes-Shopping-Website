package com.mvp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvp.model.CustomerType;
import com.mvp.model.Material;

public class CustomerTypeDAO {
	private static CustomerTypeDAO instance;
	
	public CustomerTypeDAO() {
		
	}

	public static CustomerTypeDAO getInstance() {
		if(instance == null)
			instance = new CustomerTypeDAO();
		return instance;
	}

	public static void setInstance(CustomerTypeDAO instance) {
		CustomerTypeDAO.instance = instance;
	}
	
	public List<CustomerType> GetListCustomerType(){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<CustomerType> lst = new ArrayList<CustomerType>();
			ResultSet rs;
			   String SQL = "{call spGetListCustomerType}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   
			   while(rs.next())
			   {
				   CustomerType ac = new CustomerType(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
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
