package com.mvp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvp.model.Color;
import com.mvp.model.Image;
import com.mvp.model.ImportDetail;
import com.mvp.model.Material;
import com.mvp.model.Producer;
import com.mvp.model.Product;
import com.mvp.model.ProductImage;
import com.mvp.model.ProductPrice;
import com.mvp.model.ProductType;
import com.mvp.model.ShoeSize;


public class ProductDAO {

	private static ProductDAO instance;

	public ProductDAO() {

	}

	public static ProductDAO getInstance() {
		if(instance == null)
			instance = new ProductDAO();
		return instance;
	}

	public static void setInstance(ProductDAO instance) {
		ProductDAO.instance = instance;
	}

	public List<ProductPrice> GetPriceProductList(){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<ProductPrice> lst = new ArrayList<ProductPrice>();
			ResultSet rs;
			String SQL = "{call spGetProductPrice}";

			cstmt = conn.prepareCall(SQL);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				ProductPrice ac = new ProductPrice(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
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


	public List<Product> GetProductList() {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Product> lst = new ArrayList<Product>();
			ResultSet rs;
			String SQL = "{call sp_GetProductList}";

			cstmt = conn.prepareCall(SQL);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Product ac = new Product(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),
						rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getBytes(8),rs.getInt(9),rs.getString(10));
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

	public List<ProductImage> GetProductImageList(String id) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<ProductImage> lst = new ArrayList<ProductImage>();
			ResultSet rs;
			String SQL = "{call spGetProductImageList(?)}";

			cstmt = conn.prepareCall(SQL);

			cstmt.setString(1, id);
			
			rs= cstmt.executeQuery();
			while(rs.next())
			{
				ProductImage ac = new ProductImage(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getBytes(4));
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

	public List<Product> GetLowStockProduct() {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Product> lst = new ArrayList<Product>();
			ResultSet rs;
			String SQL = "{call sp_GetLowStockProduct}";

			cstmt = conn.prepareCall(SQL);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Product ac = new Product(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),
						rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getBytes(8),rs.getInt(9),rs.getString(10));
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


	public List<Product> GetHotProduct() {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Product> lst = new ArrayList<Product>();
			ResultSet rs;
			String SQL = "{call sp_GetHotProduct}";

			cstmt = conn.prepareCall(SQL);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Product ac = new Product(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),
						rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getBytes(8),rs.getInt(9),rs.getString(10));
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


	public List<Product> GetDiscountProduct() {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Product> lst = new ArrayList<Product>();
			ResultSet rs;
			String SQL = "{call sp_GetDiscountProduct}";

			cstmt = conn.prepareCall(SQL);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Product ac = new Product(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),
						rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getBytes(8),rs.getInt(9),rs.getString(10));
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



	public List<Product> GetHotSale() {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Product> lst = new ArrayList<Product>();
			ResultSet rs;
			String SQL = "{call sp_GetHotSaleList}";

			cstmt = conn.prepareCall(SQL);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Product ac = new Product(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),
						rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getBytes(8),rs.getInt(9),rs.getString(10));
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


	public List<Product> GetHotProductByTypeID(int typeID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Product> lst = new ArrayList<Product>();
			ResultSet rs;
			String SQL = "{call sp_GetTopProductByType(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setInt(1, typeID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Product ac = new Product(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),
						rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getBytes(8),rs.getInt(9),rs.getString(10));
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

	public List<ImportDetail> GetImportDetailByID(int ID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<ImportDetail> lst = new ArrayList<ImportDetail>();
			ResultSet rs;
			String SQL = "{call spGetImportDetailByID(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setInt(1, ID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				ImportDetail ac = new ImportDetail(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),
						rs.getString(5));
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

	public List<Producer> GetProducerList() {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Producer> lst = new ArrayList<Producer>();
			ResultSet rs;
			String SQL = "{call sp_GetProducer}";

			cstmt = conn.prepareCall(SQL);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Producer ac = new Producer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
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


	public Producer GetProducerByPID(String PID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			String SQL = "{call sp_GetProducerByPID(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setString(1, PID);

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



	public List<Material> GetMaterialList() {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Material> lst = new ArrayList<Material>();
			ResultSet rs;
			String SQL = "{call sp_GetMaterial}";

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

	public Material GetMaterialByPID(String PID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			String SQL = "{call sp_GetMaterialByPID(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setString(1, PID);

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


	public List<Color> GetColorList() {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Color> lst = new ArrayList<Color>();
			ResultSet rs;
			String SQL = "{call sp_GetColor}";

			cstmt = conn.prepareCall(SQL);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Color ac = new Color(rs.getInt(1),rs.getString(2),rs.getBytes(4));
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


	public List<Color> GetColorListByPID(String PID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Color> lst = new ArrayList<Color>();
			ResultSet rs;
			String SQL = "{call sp_GetListColorByPID(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setString(1, PID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Color ac = new Color(rs.getInt(1),rs.getString(2),rs.getBytes(3));
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


	public Color GetColorById(int ID) {
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			String SQL = "{call sp_GetColorByID(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setInt(1, ID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				return new Color(rs.getInt(1),rs.getString(2),rs.getBytes(4));
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




	public List<ShoeSize> GetSizeList() {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<ShoeSize> lst = new ArrayList<ShoeSize>();
			ResultSet rs;
			String SQL = "{call sp_GetSize}";

			cstmt = conn.prepareCall(SQL);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				ShoeSize ac = new ShoeSize(rs.getInt(1),rs.getInt(2));
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


	public List<ShoeSize> GetSizeListByPID(String PID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<ShoeSize> lst = new ArrayList<ShoeSize>();
			ResultSet rs;
			String SQL = "{call sp_GetListSizeByPID(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setString(1, PID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				ShoeSize ac = new ShoeSize(rs.getInt(1),rs.getInt(2));
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


	public ShoeSize GetSizeById(int ID) {
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			String SQL = "{call sp_GetSizeByID(?)}";

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


	public List<ProductType> GetProductTypeList() {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<ProductType> lst = new ArrayList<ProductType>();
			ResultSet rs;
			String SQL = "{call sp_GetProductTypeList}";

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

	public ProductType GetProductTypeByPID(String PID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			String SQL = "{call sp_GetProductTypeByPID(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setString(1, PID);

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


	public Product GetProductByID(String PID) {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			ResultSet rs;
			String SQL = "{call sp_GetProductById(?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setString(1, PID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				return new Product(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),
						rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getBytes(8),rs.getInt(9),rs.getString(10));
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
	
	public List<Image> getListImageByPIDAndColorID(String pID, int colorID){
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Image> lst = new ArrayList<Image>();
			ResultSet rs;
			String SQL = "{call sp_GetImageByPIDAndColorID(?,?)}";

			cstmt = conn.prepareCall(SQL);
			cstmt.setString(1, pID);
			cstmt.setInt(2, colorID);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Image ac = new Image(rs.getString(1),rs.getInt(2),rs.getBytes(3));
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
	
	public List<Product> GetHotProductList() {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Product> lst = new ArrayList<Product>();
			ResultSet rs;
			String SQL = "{call sp_GetHotProductList}";

			cstmt = conn.prepareCall(SQL);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Product ac = new Product(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),
						rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getBytes(8),rs.getInt(9),rs.getString(10));
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
	
	
	public List<Product> GetDiscountProductList() {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Product> lst = new ArrayList<Product>();
			ResultSet rs;
			String SQL = "{call sp_GetDiscountProductList}";

			cstmt = conn.prepareCall(SQL);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Product ac = new Product(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),
						rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getBytes(8),rs.getInt(9),rs.getString(10));
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



	public List<Product> GetHotSaleProductList() {

		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Product> lst = new ArrayList<Product>();
			ResultSet rs;
			String SQL = "{call sp_GetHotSaleProductList}";

			cstmt = conn.prepareCall(SQL);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Product ac = new Product(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),
						rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getBytes(8),rs.getInt(9),rs.getString(10));
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




