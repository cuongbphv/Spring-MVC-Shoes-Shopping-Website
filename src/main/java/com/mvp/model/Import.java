package com.mvp.model;

import java.util.Date;

import com.mvp.DAO.StaffDAO;

public class Import {
	private int importID;
	private String staffID;
	private int quantity;
	private Date importDate;
	private String total;
	private Staff staff;

	public Import() {
		
	}
	
	public Import(int importID, String staffID, int quantity, Date importDate, String total) {
		super();
		this.importID = importID;
		this.staffID = staffID;
		this.quantity = quantity;
		this.importDate = importDate;
		this.total = total;
	}
	
	
	public int getImportID() {
		return importID;
	}
	public void setImportID(int importID) {
		this.importID = importID;
	}
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	
	public Staff getStaff() {
		return staff = StaffDAO.getInstance().GetStaffByID(staffID);
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getImportDate() {
		return importDate;
	}
	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
}
