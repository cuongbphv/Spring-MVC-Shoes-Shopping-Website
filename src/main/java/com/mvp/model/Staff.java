package com.mvp.model;

public class Staff {
	private String maNV;	
	private String tenNV;
	private String diaChi;
	private String soDienThoai;
	private String ngaySinh;
	private String gioiTinh;
	private int maLoaiNV;
	private String tenLoaiNV;
	
	public Staff() {
		
	}
	
	public Staff(String maNV, String tenNV, String diaChi, String soDienThoai, String ngaySinh, String gioiTinh, int maLoaiNV,
			String tenLoaiNV) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.maLoaiNV = maLoaiNV;
		this.tenLoaiNV = tenLoaiNV;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
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

	public void setTenLoaiNV(String tenLoaiNV) {
		this.tenLoaiNV = tenLoaiNV;
	}
	
}
