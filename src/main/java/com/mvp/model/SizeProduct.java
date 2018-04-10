package com.mvp.model;

public class SizeProduct {
	private int iD;
	private int name;
	
	public SizeProduct()
	{
		
	}
	
	public SizeProduct(int iD, int name) {
		super();
		this.iD = iD;
		this.name = name;
	}
	
	public int getiD() {
		return iD;
	}
	
	public void setiD(int iD) {
		this.iD = iD;
	}
	
	public int getName() {
		return name;
	}
	
	public void setName(int name) {
		this.name = name;
	}
	
}
