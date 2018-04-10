package com.mvp.model;

import java.util.Date;

import com.mvp.DAO.CustomerDAO;

public class Comment {

	private String productID;
	private int cusID;
	private String content;
	private int star;
	private Date commentDate;
	private String title;
	private Customer customer;
	
	
	public Customer getCustomer() {
		setCustomer(CustomerDAO.getInstance().GetCustomerByID(this.cusID));
		return this.customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Comment(String productID, int cusID, String content, int star, Date commentDate, String title) {
		super();
		this.productID = productID;
		this.cusID = cusID;
		this.content = content;
		this.star = star;
		this.commentDate = commentDate;
		this.title = title;
	}


	public String getProductID() {
		return productID;
	}


	public int getCusID() {
		return cusID;
	}


	public String getContent() {
		return content;
	}


	public int getStar() {
		return star;
	}


	public Date getCommentDate() {
		return commentDate;
	}


	public String getTitle() {
		return title;
	}


	public void setProductID(String productID) {
		this.productID = productID;
	}


	public void setCusID(int cusID) {
		this.cusID = cusID;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public void setStar(int star) {
		this.star = star;
	}


	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
	
	
}
