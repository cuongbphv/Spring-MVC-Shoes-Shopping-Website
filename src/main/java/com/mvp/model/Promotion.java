package com.mvp.model;

import java.util.Date;

public class Promotion {
	
	private String iD;
	private String name;
	private int percent;
	private Date startTime;
	private Date endTime;
	
	
	public Promotion() {
		
	}
	
	public Promotion(String iD, String name, int percent, Date startTime, Date endTime) {
		super();
		this.iD = iD;
		this.name = name;
		this.percent = percent;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
	public String getiD() {
		return iD;
	}
	public String getName() {
		return name;
	}
	public int getPercent() {
		return percent;
	}
	public Date getStartTime() {
		return startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
	
}
