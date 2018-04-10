package com.mvp.model;

public class AdminFeature {
	
	private String iD;
	private String name;
	private String value;
	
	
	public AdminFeature(String iD, String name, String value) {
		super();
		this.iD = iD;
		this.name = name;
		this.value = value;
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
