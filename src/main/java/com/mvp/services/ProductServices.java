package com.mvp.services;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.web.multipart.MultipartFile;

import com.mvp.DAO.DataProvider;

public class ProductServices {
	
	private static ProductServices instance;
	
	public ProductServices() {
		
	}

	public static ProductServices getInstance() {
		if(instance == null)
			instance = new ProductServices();
		return instance;
	}

	public static void setInstance(ProductServices instance) {
		ProductServices.instance = instance;
	}

	public boolean AddProductAD(String iD, String name, int quantity, int producerID, int materialID, String price,
			int discount, byte[] image, int typeID, String description){
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_InsertProductAD(?,?,?,?,?,?,?,?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, iD);
			cstmt.setString(2, name);
			cstmt.setInt(3, quantity);
			cstmt.setInt(4, producerID);
			cstmt.setInt(5, materialID);
			cstmt.setString(6, price);
			cstmt.setInt(7, discount);
			cstmt.setBytes(8, image);
			cstmt.setInt(9, typeID);
			cstmt.setString(10, description);
			
			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
public boolean AddColorItem(String pID, int colorID, MultipartFile[] Image) {
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_AddColorItem(?,?,?)}" ;
		
		try {
			for(MultipartFile img: Image ) {
				
				
				if(!img.isEmpty()) {
					try {
						byte[] contents = img.getBytes();
						
						cstmt = conn.prepareCall(SQL);

						cstmt.setString(1, pID);
						cstmt.setInt(2, colorID);
						cstmt.setBytes(3, contents);

						cstmt.executeUpdate();
						
					} catch (IOException e) {
						e.printStackTrace();
						return false;
					}	
				}
				else {
					return false;
				}
			}
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public boolean DeleteProduct(String iD){
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call sp_DeleteProduct(?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, iD);
			
			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	public boolean updatePrice(String iD, String newPrice){
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spUpdatePrice(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, iD);
			cstmt.setString(2, newPrice);
			
			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
public boolean updateDiscount(String iD, String newPrice){
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spUpdateDiscount(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, iD);
			cstmt.setString(2, newPrice);
			
			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}


	public int GetStock(String pID, int colorID, int sizeID) {
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			   String SQL = "{call sp_GetStocksByPID(?,?,?)}";
			  
			   cstmt = conn.prepareCall(SQL);
			   cstmt.setString(1, pID);
			   cstmt.setInt(2, colorID);
			   cstmt.setInt(3, sizeID);
			   
			   rs= cstmt.executeQuery();
			   while(rs.next())
			   {
				  return rs.getInt(1);
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
		return 0;
		
	}
	
	public boolean EditProductHasImage(String iD, String name, int producerID, int materialID, String price,
			int discount, byte[] image, int typeID, String description){
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spEditProductHasImage(?,?,?,?,?,?,?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, iD);
			cstmt.setString(2, name);
			cstmt.setInt(3, producerID);
			cstmt.setInt(4, materialID);
			cstmt.setString(5, price);
			cstmt.setInt(6, discount);
			cstmt.setInt(7, typeID);
			cstmt.setBytes(8, image);			
			cstmt.setString(9, description);
			
			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;		
	}
	
	public boolean EditProductNoImage(String iD, String name, int producerID, int materialID, String price,
			int discount, int typeID, String description){
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spEditProductNoImage(?,?,?,?,?,?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, iD);
			cstmt.setString(2, name);
			cstmt.setInt(3, producerID);
			cstmt.setInt(4, materialID);
			cstmt.setString(5, price);
			cstmt.setInt(6, discount);
			cstmt.setInt(7, typeID);			
			cstmt.setString(8, description);
			
			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;		
	}
	
	public boolean DeleteProductImage(String pID, int cID, int keyID){
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spDeleteProductImage(?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, pID);
			cstmt.setInt(2, cID);
			cstmt.setInt(3, keyID);

			
			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;		
	}
	
	public boolean EditProductHasColorNoImage(String pID, int cID, int keyID){
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spEditProductHasColorNoImage(?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, pID);
			cstmt.setInt(2, cID);
			cstmt.setInt(3, keyID);

			
			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;		
	}

	public boolean EditProductHasColorHasImage(String pID, int cID, int keyID, byte[] image){
	
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spEditProductHasColorHasImage(?,?,?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, pID);
			cstmt.setInt(2, cID);
			cstmt.setInt(3, keyID);
			cstmt.setBytes(4, image);
			
			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;		
	}
	
}
