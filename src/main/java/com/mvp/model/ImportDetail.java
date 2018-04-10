package com.mvp.model;

import java.io.Serializable;

import com.mvp.DAO.ProductDAO;

public class ImportDetail implements Serializable{

	private String productID;
	private int colorID;
	private int sizeID;
	private int quantity;
	private String price;
	
	private Product product;
	
	public Product getProduct() {
		return product = ProductDAO.getInstance().GetProductByID(productID);
	}


	public ImportDetail(String productID, int colorID, int sizeID, int quantity, String price) {
		super();
		this.productID = productID;
		this.colorID = colorID;
		this.sizeID = sizeID;
		this.quantity = quantity;
		this.price = price;
	}


	public String getProductID() {
		return productID;
	}


	public int getColorID() {
		return colorID;
	}


	public int getSizeID() {
		return sizeID;
	}


	public int getQuantity() {
		return quantity;
	}


	public String getPrice() {
		return price;
	}


	public void setProductID(String productID) {
		this.productID = productID;
	}


	public void setColorID(int colorID) {
		this.colorID = colorID;
	}


	public void setSizeID(int sizeID) {
		this.sizeID = sizeID;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
