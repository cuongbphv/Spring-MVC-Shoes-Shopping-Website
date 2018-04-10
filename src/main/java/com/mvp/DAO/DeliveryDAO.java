package com.mvp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mvp.model.Order;

public class DeliveryDAO {
	private static DeliveryDAO instance;
	
	public DeliveryDAO() {
		
	}

	public static DeliveryDAO getInstance() {
		if(instance == null)
			instance = new DeliveryDAO();
		return instance;
	}

	public static void setInstance(DeliveryDAO instance) {
		DeliveryDAO.instance = instance;
	}
	
	public List<Order> GetListOrderDelivery(){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Order> lst = new ArrayList<Order>();
			ResultSet rs;
			   String SQL = "{call spGetListOrderDelivery}";
			   
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
	
	public List<Order> GetListOrderDeliveryDESC(){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Order> lst = new ArrayList<Order>();
			ResultSet rs;
			   String SQL = "{call spGetListOrderDeliveryDESC}";
			   
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
	
	public List<Order> GetListOrderDeliveryASC(){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Order> lst = new ArrayList<Order>();
			ResultSet rs;
			   String SQL = "{call spGetListOrderDeliveryASC}";
			   
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
	
	public List<Order> GetListDeliveryTrucking(String deliverID){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Order> lst = new ArrayList<Order>();
			ResultSet rs;
			   String SQL = "{call spGetListDeliveryTrucking(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   cstmt.setString(1, deliverID);
			   
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
	
	public List<Order> GetListDeliveryTruckingASC(String deliverID){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Order> lst = new ArrayList<Order>();
			ResultSet rs;
			   String SQL = "{call spGetListDeliveryTruckingASC(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   cstmt.setString(1, deliverID);
			   
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
	
	public List<Order> GetListDeliveryTruckingDESC(String deliverID){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Order> lst = new ArrayList<Order>();
			ResultSet rs;
			   String SQL = "{call spGetListDeliveryTruckingDESC(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   cstmt.setString(1, deliverID);
			   
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
	
	public List<Order> GetListDeliveryHistory(String deliverID){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Order> lst = new ArrayList<Order>();
			ResultSet rs;
			   String SQL = "{call spGetListDeliveryHistory(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   cstmt.setString(1, deliverID);
			   
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
	
	public List<Order> GetListDeliveredHistory(String deliverID){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Order> lst = new ArrayList<Order>();
			ResultSet rs;
			   String SQL = "{call spGetListDeliveredHistory(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   cstmt.setString(1, deliverID);
			   
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
	
	public List<Order> GetListCanceledHistory(String deliverID){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Order> lst = new ArrayList<Order>();
			ResultSet rs;
			   String SQL = "{call spGetListCanceledHistory(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   cstmt.setString(1, deliverID);
			   
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
}
