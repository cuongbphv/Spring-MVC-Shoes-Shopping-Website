package com.mvp.model;

import com.mvp.DAO.OrderDAO;
import com.mvp.DAO.ProductDAO;

public class OrderDetail {

	private int orderID;
	private String productID;
	private int colorID;
	private int sizeID;
	private int quantity;
	private String price;
	private String totalPrice;
	private Product product;
	private Color color;
	private ShoeSize size;
	private Order order;
	
	public Order getOrder() {
		this.order = OrderDAO.getInstance().GetOrderByID(this.orderID);
		return order;
	}
	
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
	
	public OrderDetail(int orderID, String productID, int colorID, int sizeID, int quantity, String price,
			String totalPrice) {
		super();
		this.orderID = orderID;
		this.productID = productID;
		this.colorID = colorID;
		this.sizeID = sizeID;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
	}


	public int getOrderID() {
		return orderID;
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


	public String getTotalPrice() {
		return totalPrice;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
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


	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
	
}
