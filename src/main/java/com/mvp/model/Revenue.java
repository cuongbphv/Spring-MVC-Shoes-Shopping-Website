package com.mvp.model;

public class Revenue {
	private int sDay;
	private int sYear;
	private int sMonth;
	private String income;
	private String productName;
	private String colorName;
	private String sizeName;
	private int quantity;
	
	public Revenue() {
		
	}
	
	public Revenue(String productName, int quantity) {
		super();
		this.productName = productName;
		this.quantity = quantity;
	}
	
	public Revenue(int sYear, String income) {
		super();
		this.sYear = sYear;
		this.income = income;
	}
	
	public Revenue(int sYear, int sMonth, String income) {
		super();
		this.sYear = sYear;
		this.sMonth = sMonth;
		this.income = income;
	}
	
	public Revenue(int sYear, int sMonth, int sDay, String income) {
		super();
		this.sYear = sYear;
		this.sMonth = sMonth;
		this.sDay = sDay;
		this.income = income;
	}
	
	
	public int getsDay() {
		return sDay;
	}

	public void setsDay(int sDay) {
		this.sDay = sDay;
	}

	public int getsYear() {
		return sYear;
	}
	public void setsYear(int sYear) {
		this.sYear = sYear;
	}
	public int getsMonth() {
		return sMonth;
	}
	public void setsMonth(int sMonth) {
		this.sMonth = sMonth;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
