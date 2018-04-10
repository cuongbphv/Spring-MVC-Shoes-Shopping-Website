package com.mvp.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mvp.DAO.AccountDAO;
import com.mvp.DAO.CommentDAO;
import com.mvp.DAO.CustomerDAO;
import com.mvp.DAO.ProductDAO;
import com.mvp.DAO.StaffDAO;
import com.mvp.model.*;
import com.mvp.services.*;

@Controller
public class ProfileController {

	@RequestMapping(value="/profile", method = RequestMethod.GET)
	public String profile(HttpSession session, ModelMap md) {
		Account acc = (Account)session.getAttribute("user");
	
		if(acc == null) {
			session.setAttribute("url", "/VerOne/login" );
			session.setAttribute("headerText","Đăng nhập/Đăng ký" );			
		    synchronized(session) {
		        ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
		        if (cart == null) {
		          cart = new ShoppingCart();
		          session.setAttribute("shoppingCart", cart);
		        }
		    }
		    
		    return "errorReLogin";
		}
		else {
			if(acc.getPhanQuyen() == 4) {
				session.setAttribute("user", acc);
				session.setAttribute("url", "/VerOne/home" );
				session.setAttribute("headerText","Tài khoản: " + acc.getCus().getName());
			}
			else if(acc.getPhanQuyen() == 3){
				session.setAttribute("user", acc);
				session.setAttribute("url", "/VerOne/profile" );
				session.setAttribute("headerText",acc.getTenDangNhap() );
			}
			else if(acc.getPhanQuyen() == 2){
				session.setAttribute("user", acc);
				session.setAttribute("url", "/VerOne/profile" );
				session.setAttribute("headerText",acc.getTenDangNhap() );
			}
			else if(acc.getPhanQuyen() == 1){
				session.setAttribute("user", acc);
				session.setAttribute("url", "/VerOne/profile" );
				session.setAttribute("headerText", acc.getTenDangNhap() );
			}
		    synchronized(session) {
		        ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
		        if (cart == null) {
		          cart = new ShoppingCart();
		          session.setAttribute("shoppingCart", cart);
		        }
		    }
		}
		return "profile";
	}
	
	
	
	@RequestMapping(value="/profileInfo", method = RequestMethod.GET)
	public String profileInfo(HttpSession session, ModelMap md) {
		
		Account acc = (Account)session.getAttribute("user");
		if(acc.getPhanQuyen() == 4) {
			Customer ct = CustomerDAO.getInstance().GetCustomerByID(Integer.parseInt(acc.getMaNguoiDung()));
			md.addAttribute("info", ct);
		}
		else {
			Staff st = StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung());
			md.addAttribute("info", st);
			return "ajax/showStaffProfile";
		}
		
		md.addAttribute("staffRequest", 0);
		
		return "ajax/showProfile";
	}
	
	
	@RequestMapping(value="/editProfile", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String editProfile(@RequestParam("uname") String name, @RequestParam("dateofbirth") String dateOfBirth,
							@RequestParam("phone") String phoneNo, @RequestParam("gender") String gender,
							@RequestParam("address") String address, HttpSession session) {
		
		String notify = "";
		
		Account acc = (Account)session.getAttribute("user");
		if(ProfileServices.getInstance().EditProfile(acc.getMaNguoiDung(), acc.getPhanQuyen(), 
				name, dateOfBirth, phoneNo, (gender.equals("M")?"Nam":"Nữ"), address)) {
			notify= "Cập nhật thành công!";
		}
		else
			notify = "Xảy ra lỗi khi cập nhật thông tin kiểm tra lại thông tin nhập!";
		
		return notify;
	}
	
	
	@RequestMapping(value="/changePass", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String changePass(@RequestParam("password") String password, @RequestParam("newpassword") String newPass,
							@RequestParam("retype") String retype, HttpSession session) {
		
		String notify = "";
		password = AccountController.generateHash(AccountController.firstSALT+ password + AccountController.lastSALT); 
		Account acc = (Account)session.getAttribute("user");
		if(password.equals(acc.getMatKhau())) {
			if(newPass.equals(retype)) {
				if(newPass.length()>=3 &&  newPass.length()<=16) {
					
					
					newPass = AccountController.generateHash(AccountController.firstSALT + newPass +AccountController.lastSALT);
					if(ProfileServices.getInstance().ChangePass(acc.getTenDangNhap(), password, newPass)) {
						notify= "Cập nhật thành công!";
						Account newAcc = AccountDAO.getInstance().CheckLogin(acc.getTenDangNhap(), newPass);
						session.setAttribute("user", newAcc);
					}
					else {
						notify = "Xảy ra lỗi khi cập nhật thông tin kiểm tra lại thông tin nhập!";
					}
				}
				else {
					notify= "Độ dài mật khẩu từ 3-16 ký tự";
				}
			}
			else {
				notify = "Nhập lại mật khẩu không khớp";
			}
		}
		else {
			notify = "Mật khẩu cũ không đúng";
		}
		
		return notify;
	}
	
	
	@RequestMapping(value="/addNewAdd", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String addNewAddress(String address, HttpSession session) {
		
		String notify = " ";
		
		Account acc = (Account)session.getAttribute("user");
		if(!CustomerDAO.getInstance().AddCustomerAdd(Integer.parseInt(acc.getMaNguoiDung()), address))
			notify =  "Thêm thất bại, kiểm tra lại thông tin nhập";
		
		return notify;
	}
	
	@RequestMapping(value="/loadSubAdd", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String loadSubAdd(HttpSession session, ModelMap md) {
		
		Account acc = (Account)session.getAttribute("user");
		Customer cus = CustomerDAO.getInstance().GetCustomerByID(Integer.parseInt(acc.getMaNguoiDung()));
		List<CustomerAddress> list = cus.getAllAddress();
		
		md.addAttribute("list", list);
		
		return "ajax/subAddress";
	}
	
	@RequestMapping(value="/deleteSubAdd", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String deleteSubAdd(String address,HttpSession session) {
		
		String notify = " ";
		
		Account acc = (Account)session.getAttribute("user");
		if(!CustomerDAO.getInstance().DeleteCustomerAdd(Integer.parseInt(acc.getMaNguoiDung()), address))
			notify =  "Xóa thất bại, vui lòng thử lại";
		
		return notify;
	}
	
}
