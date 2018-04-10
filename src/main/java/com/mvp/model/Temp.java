package com.mvp.model;

public class Temp {
	private String tenDangNhap;
	private String matKhau;
	private boolean ghiNho;


	public Temp() {
		
	}
	
	
	public Temp(String tenDangNhap, String matKhau) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}

	public boolean isGhiNho() {
		return ghiNho;
	}


	public void setGhiNho(boolean ghiNho) {
		this.ghiNho = ghiNho;
	}
	
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
}
