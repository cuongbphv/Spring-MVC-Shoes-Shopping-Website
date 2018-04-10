package com.mvp.model;

import java.util.Date;
import java.util.List;

import com.mvp.DAO.CustomerDAO;
import com.mvp.DAO.OrderDAO;
import com.mvp.DAO.PromotionDAO;
import com.mvp.DAO.StaffDAO;

public class Order {
	
	private int iD;
	private int cusID;
	private String staffID;
	private String deliverID;
	private String totalPrice;
	private Date tradeTime;
	private String status;
	private String discountCode;
	private String address;
	private boolean seen;





	private List<OrderDetail> listDetail;
	private Promotion discount;
	private Staff staff;
	private Customer customer;
	private Staff deliver;
	
	
	public Staff getDeliver() {
		this.deliver = StaffDAO.getInstance().GetStaffByID(deliverID);
		return deliver;
	}
	
	public Staff getStaff() {
		setStaff(StaffDAO.getInstance().GetStaffByID(this.staffID));
		return staff;
	}


	public Customer getCustomer() {
		setCustomer(CustomerDAO.getInstance().GetCustomerByID(this.cusID));
		return customer;
	}


	public void setStaff(Staff staff) {
		this.staff = staff;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Promotion getDiscount() {
		setDiscount(PromotionDAO.getInstance().GetPromotionByID(this.discountCode));
		return this.discount;
	}


	public void setListDetail(List<OrderDetail> listDetail) {
		this.listDetail = listDetail;
	}


	public void setDiscount(Promotion discount) {
		this.discount = discount;
	}


	public List<OrderDetail> getListDetail() {
		this.listDetail = OrderDAO.getInstance().GetOrderDetailByOrderID(this.iD);
		return listDetail;
	}


	public Order(int iD, int cusID, String staffID, String deliverID, String totalPrice, Date tradeTime, String status,
			String discountCode, String address, boolean seen ) {
		super();
		this.iD = iD;
		this.cusID = cusID;
		this.staffID = staffID;
		this.deliverID = deliverID;
		this.totalPrice = totalPrice;
		this.tradeTime = tradeTime;
		this.status = status;
		this.discountCode = discountCode;
		this.address = address;
		this.seen = seen;
	}


	public int getiD() {
		return iD;
	}


	public int getCusID() {
		return cusID;
	}


	public String getStaffID() {
		return staffID;
	}


	public String getDeliverID() {
		return deliverID;
	}


	public String getTotalPrice() {
		return totalPrice;
	}


	public Date getTradeTime() {
		return tradeTime;
	}


	public String getStatus() {
		return status;
	}


	public String getDiscountCode() {
		return discountCode;
	}
	
	public String getAddress() {
		return address;
	}


	public void setiD(int iD) {
		this.iD = iD;
	}


	public void setCusID(int cusID) {
		this.cusID = cusID;
	}


	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}


	public void setDeliverID(String deliverID) {
		this.deliverID = deliverID;
	}


	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}


	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public void setDeliver(Staff deliver) {
		this.deliver = deliver;
	}

	
}
