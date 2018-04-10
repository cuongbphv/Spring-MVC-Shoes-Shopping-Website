package com.mvp.model;

import java.util.Date;

import com.mvp.DAO.CustomerDAO;
import com.mvp.DAO.StaffDAO;

public class Guarantee {
	private int iD;
	private String productID;
	private int orderID;
	private int cusID;
	private Date receiveGuarantee;
	private String staffID;
	private Date returnGuarantee;
	private String reason;
	private boolean seen;
	private Customer cus;
	private Staff staff;
	
	public Guarantee() {
		
	}
	
	public Guarantee(int iD, String productID, int orderID, int cusID, Date receiveGuarantee, String staffID,
			Date returnGuarantee, String reason,boolean seen) {
		super();
		this.iD = iD;
		this.productID = productID;
		this.orderID = orderID;
		this.cusID = cusID;
		this.receiveGuarantee = receiveGuarantee;
		this.staffID = staffID;
		this.returnGuarantee = returnGuarantee;
		this.reason = reason;
		this.seen = seen;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getCusID() {
		return cusID;
	}

	public void setCusID(int cusID) {
		this.cusID = cusID;
	}

	public Date getReceiveGuarantee() {
		return receiveGuarantee;
	}

	public void setReceiveGuarantee(Date receiveGuarantee) {
		this.receiveGuarantee = receiveGuarantee;
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public Date getReturnGuarantee() {
		return returnGuarantee;
	}

	public void setReturnGuarantee(Date returnGuarantee) {
		this.returnGuarantee = returnGuarantee;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}
	
	public Customer getCus() {
		return cus = CustomerDAO.getInstance().GetCustomerByID(cusID);
	}

	public Staff getStaff() {
		return staff = StaffDAO.getInstance().GetStaffByID(staffID);
	}
	
	
}
