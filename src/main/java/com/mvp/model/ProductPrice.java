package com.mvp.model;

public class ProductPrice {
	private String iD;
	private String name;
	private String price;
	private int discount;
	
	public ProductPrice() {
		
	}

	public ProductPrice(String iD, String name, String price, int discount) {
		super();
		this.iD = iD;
		this.name = name;
		this.price = price;
		this.discount = discount;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
}
