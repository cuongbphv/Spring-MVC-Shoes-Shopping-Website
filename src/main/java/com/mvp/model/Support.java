package com.mvp.model;

import java.util.Date;

import com.mvp.DAO.CustomerDAO;
import com.mvp.DAO.StaffDAO;

public class Support {
	private int iD;
	private String question;
	private Date sendDate;
	private String answer;
	private Date receiveDate;
	private String staffID;
	private int cusID;
	private boolean seen;
	private Staff staff;
	private Customer cus;
	
	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
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

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}
	
	public Staff getStaff() {
		return staff = StaffDAO.getInstance().GetStaffByID(staffID);
	}

	public Customer getCus() {
		return cus = CustomerDAO.getInstance().GetCustomerByID(cusID);
	}

	public Support() {
		
	}
	
	public Support(int iD, String question, Date sendDate, String answer, Date receiveDate, String staffID, int cusID, boolean seen) {
		super();
		this.iD = iD;
		this.question = question;
		this.sendDate = sendDate;
		this.answer = answer;
		this.receiveDate = receiveDate;
		this.staffID = staffID;
		this.cusID = cusID;
		this.seen = seen;
	}
}
