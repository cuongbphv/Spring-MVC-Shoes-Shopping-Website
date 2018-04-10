package com.mvp.model;

public class CustomerAddress {

	private int cusID;
	private String address;
	private boolean defaultAdd;
	
	
	
	public CustomerAddress(int cusID, String address, boolean defaultAdd) {
		super();
		this.cusID = cusID;
		this.address = address;
		this.defaultAdd = defaultAdd;
	}
	
	public int getCusID() {
		return cusID;
	}
	public void setCusID(int cusID) {
		this.cusID = cusID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isDefaultAdd() {
		return defaultAdd;
	}
	public void setDefaultAdd(boolean defaultAdd) {
		this.defaultAdd = defaultAdd;
	}
	
	
}
