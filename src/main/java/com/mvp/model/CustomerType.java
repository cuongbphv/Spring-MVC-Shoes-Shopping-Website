package com.mvp.model;

public class CustomerType {
	private int iD;
	private String name;
	private int discount;
	private String levelMoney;
	
	public CustomerType() {
		
	}
	
	public CustomerType(int iD, String name, int discount, String levelMoney) {
		super();
		this.iD = iD;
		this.name = name;
		this.discount = discount;
		this.levelMoney = levelMoney;
	
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getLevelMoney() {
		return levelMoney;
	}

	public void setLevelMoney(String levelMoney) {
		this.levelMoney = levelMoney;
	}
	
	
}
