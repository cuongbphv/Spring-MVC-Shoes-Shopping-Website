package com.mvp.model;

public class Material {
	private int iD;
	private String name;
	
	public Material(int iD, String name) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Material() {
		
	}
	
	
}
