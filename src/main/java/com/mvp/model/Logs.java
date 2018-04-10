package com.mvp.model;

import java.util.Date;

public class Logs {


	private int iD;
	private Date time;
	private String content;
	
	
	public Logs(int iD, Date time, String content) {
		super();
		this.iD = iD;
		this.time = time;
		this.content = content;
	}
	
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
