package com.mvp.model;

public class ShoeSize {
	private int iD;
	private int name;
	
	
	public ShoeSize(int iD, int name) {
		super();
		this.iD = iD;
		this.name = name;
	}


	public int getiD() {
		return iD;
	}


	public int getName() {
		return name;
	}


	public void setiD(int iD) {
		this.iD = iD;
	}


	public void setName(int name) {
		this.name = name;
	}
	
	
	
	
}
