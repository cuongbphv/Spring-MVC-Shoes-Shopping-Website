package com.mvp.model;

import java.util.Date;
import java.util.List;

import com.mvp.DAO.CustomerDAO;

public class Customer {

	private int cusID;
	private String name;
	private String address;
	private String phoneNo;
	private Date dateofBirth;
	private String gender;
	private int cusTypeID;
	private CustomerType type;
	private List<CustomerAddress> allAddress;
	
	public List<CustomerAddress> getAllAddress(){
		this.allAddress = CustomerDAO.getInstance().GetListAddressByCusID(cusID);
		return this.allAddress;
	}
	
	public CustomerType getType() {
		this.type = CustomerDAO.getInstance().GetCustomerTypeByID(this.cusTypeID);
		return type;
	}


	public Customer(int cusID, String name, String phoneNo, Date dateofBirth, String gender,
			int cusTypeID) {
		super();
		this.cusID = cusID;
		this.name = name;
		this.phoneNo = phoneNo;
		this.dateofBirth = dateofBirth;
		this.gender = gender;
		this.cusTypeID = cusTypeID;
	}


	public int getCusID() {
		return cusID;
	}


	public String getName() {
		return name;
	}


	public String getAddress() {
		this.address = CustomerDAO.getInstance().GetAddressByCusID(this.cusID);
		return address;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public Date getDateofBirth() {
		return dateofBirth;
	}


	public String getGender() {
		return gender;
	}


	public int getCusTypeID() {
		return cusTypeID;
	}


	public void setCusID(int cusID) {
		this.cusID = cusID;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public void setCusTypeID(int cusTypeID) {
		this.cusTypeID = cusTypeID;
	}
	
	
	

}


