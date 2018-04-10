package com.mvp.model;

import java.util.Date;
import java.util.List;

import com.mvp.DAO.CustomerDAO;
import com.mvp.DAO.OrderDAO;
import com.mvp.DAO.PromotionDAO;
import com.mvp.DAO.StaffDAO;

public class Bill {
	
	private int iD;
	private int orderID;
	private Date tradeTime;
	private String totalPrice;
	private String staffID;
	private int cusID;
	private String discountCode;
	private boolean print;
	
	private Promotion discount;
	private Staff staff;
	private Customer customer;
	private Order order;
	
	
	public Order getOrder() {
		this.order = OrderDAO.getInstance().GetOrderByID(this.orderID);
		return this.order;
	}
	
	
	public Staff getStaff() {
		this.staff = StaffDAO.getInstance().GetStaffByID(this.staffID);
		return staff;
	}


	public Customer getCustomer() {
		this.customer = CustomerDAO.getInstance().GetCustomerByID(this.cusID);
		return customer;
	}

	public Promotion getDiscount() {
		this.discount = PromotionDAO.getInstance().GetPromotionByID(this.discountCode);
		return this.discount;
	}

	

	public Bill(int iD, int orderID, Date tradeTime, String totalPrice, String staffID, int cusID, String discountCode,
			boolean print) {
		super();
		this.iD = iD;
		this.orderID = orderID;
		this.tradeTime = tradeTime;
		this.totalPrice = totalPrice;
		this.staffID = staffID;
		this.cusID = cusID;
		this.discountCode = discountCode;
		this.print = print;
	}
	
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public Date getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	public int getCusID() {
		return cusID;
	}
	public void setCusID(int cusID) {
		this.cusID = cusID;
	}
	public String getDiscountCode() {
		return discountCode;
	}
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	public boolean isPrint() {
		return print;
	}
	public void setPrint(boolean print) {
		this.print = print;
	}
	
	
	
}