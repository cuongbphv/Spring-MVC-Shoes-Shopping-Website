package com.mvp.model;

import com.mvp.DAO.ProductDAO;

public class BillDetail {

	private int billID;
	private String productID;
	private int colorID;
	private int sizeID;
	private int quantity;
	private String price;
	private String totalPrice;
	
	
	private Product product;
	private Color color;
	private ShoeSize size;
	
	public Product getProduct() {
		this.product = ProductDAO.getInstance().GetProductByID(this.productID);
		return product;
	}
	
	public Color getColor() {
		this.color = ProductDAO.getInstance().GetColorById(this.colorID);
		return color;
	}
	
	public ShoeSize getSize() {
		this.size = ProductDAO.getInstance().GetSizeById(this.sizeID);
		return size;
	}
	
	
	
	public BillDetail(int billID, String productID, int colorID, int sizeID, int quantity, String price,
			String totalPrice) {
		super();
		this.billID = billID;
		this.productID = productID;
		this.colorID = colorID;
		this.sizeID = sizeID;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
	}
	
	
	public int getBillID() {
		return billID;
	}
	public void setBillID(int billID) {
		this.billID = billID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public int getColorID() {
		return colorID;
	}
	public void setColorID(int colorID) {
		this.colorID = colorID;
	}
	public int getSizeID() {
		return sizeID;
	}
	public void setSizeID(int sizeID) {
		this.sizeID = sizeID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
