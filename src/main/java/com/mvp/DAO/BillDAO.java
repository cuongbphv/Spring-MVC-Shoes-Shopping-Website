package com.mvp.DAO;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mvp.model.Bill;
import com.mvp.model.BillDetail;
import com.mvp.model.Order;


public class BillDAO {

	private static BillDAO instance;
	
	public BillDAO() {
		
	}

	public static BillDAO getInstance() {
		if(instance == null)
			instance = new BillDAO();
		return instance;
	}

	private static void setInstance(BillDAO instance) {
		BillDAO.instance = instance;
	}
	
	public List<Bill> GetListBill(){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Bill> lst = new ArrayList<Bill>();
			ResultSet rs;
			   String SQL = "{call sp_GetListBill}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Date date;
				   Timestamp timestamp = rs.getTimestamp(3);
				   date = new Date(timestamp.getTime());
				   
				   Bill ac = new Bill(rs.getInt(1),rs.getInt(2), date, rs.getString(4), rs.getString(5), rs.getInt(6),
						   					rs.getString(7), rs.getBoolean(8));
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
	

	public Bill GetBillByID(int ID){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			   String SQL = "{call sp_GetBillByID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setInt(1, ID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Date date;
				   Timestamp timestamp = rs.getTimestamp(3);
				   date = new Date(timestamp.getTime());
				   
				   return new Bill(rs.getInt(1),rs.getInt(2), date, rs.getString(4), rs.getString(5), rs.getInt(6),
						   					rs.getString(7), rs.getBoolean(8));
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
	
	public List<BillDetail> GetListBillDetailByBillID(int billID){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<BillDetail> lst = new ArrayList<BillDetail>();
			ResultSet rs;
			   String SQL = "{call sp_GetBillDetailByBillID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setInt(1, billID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   
				   BillDetail ac = new BillDetail(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getInt(4), 
						   							rs.getInt(5), rs.getString(6),rs.getString(7));
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
