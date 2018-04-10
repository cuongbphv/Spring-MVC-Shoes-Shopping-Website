package com.mvp.model;

import java.util.Date;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

public class Register {

	@Size(min=3, max = 20, message="Tên tài khoản ngắn nhất là 3 và dài nhất 20 ký tự")
	@Pattern(regexp = "^[A-Z]*[a-z]*[0-9]*$", message="Tên tài khoản chỉ bao gồm chữ không dấu và số")
    @NotNull(message= "Không được để trống")
	private String username;
	
	@Size(min=3, max = 20)
	@Pattern(regexp = "^[A-Z]*[a-z]*[0-9]*$",message="Tên tài khoản chỉ bao gồm chữ không dấu và số")
    @NotNull(message= "Không được để trống")	
	private String password;
	
	@Size(min=3, max = 20)
	@Pattern(regexp = "^[A-Z]*[a-z]*[0-9]*$",message="Tên tài khoản chỉ bao gồm chữ không dấu và số")
    @NotNull(message= "Không được để trống")
	private String retype;
	
	@Size(min=3, max = 50,message= "Tên người dùng ngắn nhất là 3 và dài nhất 50 ký tự")
    @NotNull(message= "Không được để trống")
	private String name;
	
	@Size(min=10, max = 11, message="Số điện thoại là số dài từ 10-11 số")
	@Pattern(regexp = "[0-9]*")
    @NotNull(message= "Không được để trống")
	private String phoneNo;
	
    @NotNull(message= "Không được để trống")
	private String gender;
    
    @NotNull(message= "Không được để trống")
	private String dateOfBirth;
	
	public Register() {
		
	}
	
	public Register(String username, String password, String retype, String name, String phoneNo, String gender,
			String dateOfBirth) {
		super();
		this.username = username;
		this.password = password;
		this.retype = retype;
		this.name = name;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getRetype() {
		return retype;
	}
	public String getName() {
		return name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getGender() {
		return gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRetype(String retype) {
		this.retype = retype;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	
}
