package com.mvp.model;

public class Producer {
	private int iD;
	private String name;
	private String address;
	private String phoneNumber;
	
	public Producer(){
		
	}

	public Producer(int iD, String name, String address, String phoneNumber) {
		super();
		this.iD = iD;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
