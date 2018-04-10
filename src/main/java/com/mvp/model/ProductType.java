package com.mvp.model;

public class ProductType {
	private int iD;
	private String name;
	
	
	public ProductType(int iD, String name) {
		super();
		this.iD = iD;
		this.name = name;
	}


	public int getiD() {
		return iD;
	}


	public String getName() {
		return name;
	}


	public void setiD(int iD) {
		this.iD = iD;
	}


	public void setName(String name) {
		this.name = name;
	}	
	
}
