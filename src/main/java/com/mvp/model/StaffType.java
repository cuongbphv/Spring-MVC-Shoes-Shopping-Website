package com.mvp.model;

public class StaffType {
	private int maLoaiNV;
	private String tenLoaiNV;
	
	public StaffType() {
		
	}
	
	public StaffType(int maLoaiNV, String tenLoaiNV) {
		super();
		this.maLoaiNV = maLoaiNV;
		this.tenLoaiNV = tenLoaiNV;
	}
	
	public int getMaLoaiNV() {
		return maLoaiNV;
	}
	public void setMaLoaiNV(int maLoaiNV) {
		this.maLoaiNV = maLoaiNV;
	}
	public String getTenLoaiNV() {
		return tenLoaiNV;
	}
	public void setTenLoadiNV(String tenLoaiNV) {
		this.tenLoaiNV = tenLoaiNV;
	}
	
	
}
