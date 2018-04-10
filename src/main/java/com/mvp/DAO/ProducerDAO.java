package com.mvp.DAO;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvp.model.Material;
import com.mvp.model.Producer;


public class ProducerDAO {

	private static ProducerDAO instance;
	
	public ProducerDAO() {
		
	}

	public static ProducerDAO getInstance() {
		if(instance == null)
			instance = new ProducerDAO();
		return instance;
	}

	public static void setInstance(ProducerDAO instance) {
		ProducerDAO.instance = instance;
	}
	
	public List<Producer> GetProducerList() {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Producer> lst = new ArrayList<Producer>();
			ResultSet rs;
			   String SQL = "{call spGetProducerList}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Producer pro = new Producer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				   lst.add(pro);
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
	
	public Producer GetMaterialByID(int ID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			String SQL = "{call spGetProducerByID(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setInt(1, ID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				return new Producer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
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
