package com.mvp.DAO;

import com.mvp.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

	private static OrderDAO instance;
	
	public OrderDAO() {
		
	}

	public static OrderDAO getInstance() {
		if(instance == null)
			instance = new OrderDAO();
		return instance;
	}

	public static void setInstance(OrderDAO instance) {
		OrderDAO.instance = instance;
	}
	
	
	public List<Order> GetListOrder(){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Order> lst = new ArrayList<Order>();
			ResultSet rs;
			   String SQL = "{call sp_GetListOrder}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Date date;
				   Timestamp timestamp = rs.getTimestamp(6);
				   date = new Date(timestamp.getTime());
				   
				   Order ac = new Order(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getString(4),rs.getString(5),
						   date,rs.getString(9),rs.getString(8),rs.getString(7),rs.getBoolean(10));
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

	public List<Order> GetListOrderByCusID(int cusID){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Order> lst = new ArrayList<Order>();
			ResultSet rs;
			   String SQL = "{call sp_GetListOrderByCustomerID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setInt(1, cusID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Date date;
				   Timestamp timestamp = rs.getTimestamp(6);
				   date = new Date(timestamp.getTime());
				   
				   Order ac = new Order(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getString(4),rs.getString(5),
						   date,rs.getString(9),rs.getString(8),rs.getString(7),rs.getBoolean(10));
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

	public Order GetOrderByID(int orderID){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			   String SQL = "{call sp_GetOrderByID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setInt(1, orderID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Date date;
				   Timestamp timestamp = rs.getTimestamp(6);
				   date = new Date(timestamp.getTime());
				   
				   return new Order(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getString(4),rs.getString(5),
						   date,rs.getString(9),rs.getString(8),rs.getString(7),rs.getBoolean(10));
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
	
	
	
	
	public Order GetOrderByIDAndCusID(int orderID, int cusID){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			   String SQL = "{call sp_GetOrderByIDAndCusID(?,?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setInt(1, orderID);
			   cstmt.setInt(2, cusID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Date date;
				   Timestamp timestamp = rs.getTimestamp(6);
				   date = new Date(timestamp.getTime());
				   
				   return new Order(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getString(4),rs.getString(5),
						   date,rs.getString(9),rs.getString(8),rs.getString(7),rs.getBoolean(10));
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
	
	
	
	

	public List<Order> GetOrderByCustomerIDAndDate(int customerID, int numofDays){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Order> lst = new ArrayList<Order>();
			ResultSet rs;
			   String SQL = "{call sp_GetOrdersByCustomerIDAndDate(?,?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setInt(1, customerID);
			   cstmt.setInt(2, numofDays);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Date date;
				   Timestamp timestamp = rs.getTimestamp(6);
				   date = new Date(timestamp.getTime());
				   
				   Order ac = new Order(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getString(4),rs.getString(5),
						   date,rs.getString(9),rs.getString(8),rs.getString(7),rs.getBoolean(10));
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
	
	public List<OrderDetail> GetOrderDetailByOrderID(int orderID){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<OrderDetail> lst = new ArrayList<OrderDetail>();
			ResultSet rs;
			   String SQL = "{call sp_GetOrderDetailByOrderID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setInt(1, orderID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   OrderDetail ac = new OrderDetail(rs.getInt(1),rs.getString(2), rs.getInt(3),rs.getInt(4),
						   rs.getInt(5),rs.getString(6),rs.getString(7));
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
