package com.mvp.model;

import com.mvp.DAO.CustomerDAO;

public class Account {
	private String tenDangNhap;
	private String matKhau;
	private String maNguoiDung;
	private int phanQuyen;
	
	private Customer cus;
	
	public Customer getCus() {
		return cus = CustomerDAO.getInstance().GetCustomerByID(Integer.parseInt(this.maNguoiDung));
	}

	public Account() {
		
	}
	
	public Account(String tenDangNhap, String matKhau, String maNguoiDung, int phanQuyen) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.maNguoiDung = maNguoiDung;
		this.phanQuyen = phanQuyen;
	}
	
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public String getMaNguoiDung() {
		return maNguoiDung;
	}
	public int getPhanQuyen() {
		return phanQuyen;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}
	public void setPhanQuyen(int phanQuyen) {
		this.phanQuyen = phanQuyen;
	}
}
