package com.mvp.DAO;

import com.mvp.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

	private static CustomerDAO instance;
	
	public CustomerDAO() {
		
	}

	public static CustomerDAO getInstance() {
		if(instance == null)
			instance = new CustomerDAO();
		return instance;
	}

	public static void setInstance(CustomerDAO instance) {
		CustomerDAO.instance = instance;
	}
	
	
	public Customer GetCustomerByID(int cusID)
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			   String SQL = "{call sp_GetCustomerByID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setInt(1, cusID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   return new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),
						   rs.getDate(4),rs.getString(5),rs.getInt(6));
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
	
	public List<Customer> GetListCustomer()
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			List<Customer> list = new ArrayList<Customer>();
			   String SQL = "{call sp_GetListCustomer}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   Customer temp =  new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),
						   rs.getDate(4),rs.getString(5),rs.getInt(6));
				   list.add(temp);
			   }
			   return list;
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
	
	
	public String GetAddressByCusID(int cusID) {
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			   String SQL = "{call sp_GetAddressByCusID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setInt(1, cusID);
			   
			  
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   return rs.getString(1);
			   }
			}
		catch (SQLException e) {
			 	e.printStackTrace();
			 	return "Lỗi truy vấn";
		}
		finally {
			   try {
				   cstmt.close();
			   }catch (SQLException e) {
				e.printStackTrace();
			   }
		}
		return "";
	}
	
	public List<CustomerAddress> GetListAddressByCusID(int cusID)
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			List<CustomerAddress> list = new ArrayList<CustomerAddress>();
			   String SQL = "{call sp_GetAllAddressByCusID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setInt(1, cusID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   CustomerAddress temp =  new CustomerAddress(rs.getInt(1),rs.getString(2),rs.getBoolean(3));
				   list.add(temp);
			   }
			   return list;
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
	
	
	public CustomerType GetCustomerTypeByCusID(int cusID)
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			   String SQL = "{call sp_GetCustomerTypeByCusID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setInt(1, cusID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   return new CustomerType(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
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
	
	
	public CustomerType GetCustomerTypeByID(int typeID)
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			   String SQL = "{call sp_GetCustomerTypeByID(?)}";
			   
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setInt(1, typeID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   return new CustomerType(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
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
	
	public List<CustomerType> GetListCustomerType()
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			List<CustomerType> list = new ArrayList<CustomerType>();
			   String SQL = "{call sp_GetListCustomerType}";
			   
			   cstmt = conn.prepareCall(SQL);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				   CustomerType temp =  new CustomerType(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
				   list.add(temp);
			   }
			   return list;
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
	
	public boolean AddCustomerAdd(int cusID, String address) {
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_AddNewAddress(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			cstmt.setInt(1, cusID);
			cstmt.setString(2, address);
			
			return cstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean DeleteCustomerAdd(int cusID, String address) {
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_DeleteAddress(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			cstmt.setInt(1, cusID);
			cstmt.setString(2, address);
			
			return cstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
}