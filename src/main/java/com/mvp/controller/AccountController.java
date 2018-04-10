package com.mvp.controller;
import com.mvp.model.*;
import com.mvp.services.*;
import com.sun.xml.internal.bind.CycleRecoverable.Context;
import com.mvp.DAO.*;

import java.net.HttpCookie;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.AbstractDocument.Content;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AccountController {
//	
//	@RequestMapping("/showacc")
//	public String showAcc(ModelMap md) {
//		List<Account> acc = new ArrayList<Account>();
//		acc = AccountDAO.getInstance().GetAccountList();
//		
//		md.addAttribute("tk",acc.get(0));
//		
//		return "showacc";
//	}
	
	public final static String firstSALT = "daxua";
	public final static String lastSALT = "ganktem";
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String manage(HttpSession session, ModelMap md) {
		Account loginacc = (Account)session.getAttribute("user");
		if(loginacc == null) {
			return "redirect:login";
		}
		if(loginacc.getPhanQuyen() != 1) {
			return "redirect:home";
		}
		
		List<Color> list = ProductDAO.getInstance().GetColorList();
		md.addAttribute("listColor", list);
		
		List<Material> listMaterial = ProductDAO.getInstance().GetMaterialList();
		md.addAttribute("listMaterialP", listMaterial);
		
		List<Producer> listProducer = ProductDAO.getInstance().GetProducerList();
		md.addAttribute("listProducerP", listProducer);
		
		List<ProductType> listProductType = ProductDAO.getInstance().GetProductTypeList();
		md.addAttribute("listProductTypeP", listProductType);
		
		
		List<StaffType> listStaffType = StaffTypeDAO.getInstance().GetStaffTypeList();
		md.addAttribute("listStaffType", listStaffType);
		
		return "admin";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
	@RequestMapping(value="/editProduct", method = RequestMethod.GET)
	public String editProduct(ModelMap md) {
		md.addAttribute("productModel", new Account());
		return "editProduct";
	}
	
//	@RequestMapping(value="/profile", method = RequestMethod.GET)
//	public String profile(HttpSession session) {
//		return "profile";
//	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap md, HttpSession session) {
		if(session.getAttribute("user") != null)
		{
			Account loginacc = (Account)session.getAttribute("user");
			if(loginacc.getPhanQuyen() == 1) {
				return "redirect:admin";
			}
			else if(loginacc.getPhanQuyen() == 2) {
				return "redirect:staff";
			}
			else if(loginacc.getPhanQuyen() == 4) {
				return "redirect:home";
			}
		}
		
		Banner banner = AdminDAO.getInstance().GetBannerByID("Login");
		
		md.addAttribute("banner", banner);
		md.addAttribute("tk", new Temp());
		return "login";
	}
	
	@RequestMapping(value= "/register", method = RequestMethod.GET)
	public String register(ModelMap m) {
		Banner banner = AdminDAO.getInstance().GetBannerByID("Register");
		
		m.addAttribute("banner", banner);
		
		m.addAttribute("register", new Register());
		return "register";
	}
	
	@RequestMapping(value="/addcustomeracc",method = RequestMethod.POST)
	public String AddCustomerAcc(@Valid Register register, BindingResult result, Model m) {
		
		Banner banner = AdminDAO.getInstance().GetBannerByID("Register");
		
		m.addAttribute("banner", banner);
		
		if(register.getDateOfBirth().toString().equals("1900-01-01") ||register.getDateOfBirth().toString().equals("") ) {
			m.addAttribute("dateErr","Không bỏ trống Ngày Sinh");
			return "register";
		}
		
		if(!register.getPassword().equals(register.getRetype()))
		{
			m.addAttribute("retypeErr", "Mật khẩu không khớp");
			return "register";
		}
		
		m.addAttribute("dateErr",register.getDateOfBirth().toString());
//		
		if(result.hasErrors()) {
			return "register";
		}
		
		register.setPassword(generateHash(firstSALT + register.getPassword() + lastSALT));
		
		System.out.println(register.getUsername() + " " + register.getPassword() + " " + register.getName()
		+ " " + register.getPhoneNo() + " " + register.getGender() + " " + register.getDateOfBirth());
		
		if(AccountDAO.getInstance().AddCustomerAcc(register.getUsername(), register.getPassword(), register.getName(), 
				register.getPhoneNo(), (register.getGender().equals("M"))?"Nam":"Nữ",register.getDateOfBirth().toString())) {
			m.addAttribute("username", register.getUsername());
			m.addAttribute("message", "Đăng ký thành công, Đăng nhập ngay!");
			m.addAttribute("tk", new Temp());
			return "login";
		}
		else
		{
			return "register";
		}
	}
	
	@RequestMapping(value="/checkLogin", method = RequestMethod.POST,produces = "text/html; charset=utf-8")
	public String CheckLogin(@ModelAttribute("tk") Temp account, ModelMap md,RedirectAttributes rd, HttpSession session, 
			HttpServletRequest request, HttpServletResponse response,RedirectAttributes rm)
	{
		// account để lấy từ form vào
		// accInfo để get thông tin lên 1 tài khoản 
		// acc để kiểm tra cookie
		
		account.setMatKhau(generateHash(firstSALT + account.getMatKhau() + lastSALT));
		
		Temp acc = CheckCookie(request);
		if(acc == null) { // nếu chưa lưu cookie
			Account accInfo = AccountDAO.getInstance().CheckLogin(account.getTenDangNhap(), account.getMatKhau());
			if(accInfo != null)
			{
				if(account.isGhiNho() == true){ // đăng nhập lần đầu tích vào ghi nhớ 
				
					// tạo mới 1 cookie 
					Cookie ckUsername = new Cookie("username",accInfo.getTenDangNhap());
					ckUsername.setMaxAge(60*60*24*365); // thời gian 1 năm
					response.addCookie(ckUsername);
					
					Cookie ckPassword = new Cookie("password",accInfo.getMatKhau());
					ckPassword.setMaxAge(60*60*24*365); // thời gian 1 năm
					response.addCookie(ckPassword);
					
					//
				}
				if(accInfo.getPhanQuyen() == 4) {
					session.setAttribute("user", accInfo);
					session.setAttribute("url", "home" );
					session.setAttribute("headerText","Tài khoản: " + accInfo.getCus().getName());
					
					Banner banner = AdminDAO.getInstance().GetBannerByID("Home");
					
					rm.addFlashAttribute("banner", banner);
					
					return "redirect:home";
				}
				else if(accInfo.getPhanQuyen() == 3){
					session.setAttribute("user", accInfo);
					session.setAttribute("url", "profile" );
					session.setAttribute("headerText",accInfo.getTenDangNhap() );
					return "redirect:delivery";
				}
				else if(accInfo.getPhanQuyen() == 2){
					session.setAttribute("user", accInfo);
					session.setAttribute("url", "profile" );
					session.setAttribute("headerText",accInfo.getTenDangNhap() );
					return "redirect:staff";
				}
				else if(accInfo.getPhanQuyen() == 1){
					session.setAttribute("user", accInfo);
					session.setAttribute("url", "profile" );
					session.setAttribute("headerText", accInfo.getTenDangNhap() );
					return "redirect:admin";
				}
			}
			else
			{				
				md.addAttribute("message", "Đăng nhập thất bại!");
				Banner banner = AdminDAO.getInstance().GetBannerByID("Login");
				
				account.setMatKhau("");
				md.addAttribute("banner", banner);
				return "login";
			}
		}
		else { //  đã lưu cookie
			Account accInfo = AccountDAO.getInstance().CheckLogin(acc.getTenDangNhap(), acc.getMatKhau());
				if(acc.isGhiNho()) {
					md.addAttribute("username", acc.getTenDangNhap());
					md.addAttribute("password", acc.getMatKhau());
					account.setGhiNho(true);
				}
				else {
					Cookie []cookies = request.getCookies();
					for(Cookie ck : cookies)
					{
						ck.setMaxAge(0);
					}
				}
//			if(accInfo != null) // lấy cookie nếu có tài khoản
//			{
//				
//				
//				return "home";
//			}
//			else // nếu k có tài khoản hoặc hết hạn
//			{
//				md.addAttribute("message", "Hết hạn cookie. Vui lòng đăng nhập lại!!");
//				return "login";
//			}
		}
		return "home";
	}
	
	public Temp CheckCookie(HttpServletRequest request)
	{
		Cookie []cookies = request.getCookies();
		Temp acc= null;
		String username = "";
		String password = "";
		
		for(Cookie ck : cookies)
		{
			if(ck.getName().equalsIgnoreCase(username))
				username = ck.getValue();
			if(ck.getName().equalsIgnoreCase(password))
				password = ck.getValue();
			if(!username.isEmpty() && !password.isEmpty()) {
				acc = new Temp(username,password);
				acc.setGhiNho(true); // tạo 1 Temp để so sánh khi đăng nhập
			}
		}		
		return acc;
		
	}
	@RequestMapping(value="/registerResult", method = RequestMethod.GET)
	public String RegisterResult() {
		
		return "registerResult";
	}
	
	@RequestMapping(value="/checkExist", method = RequestMethod.POST,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String CheckExist(String username) {
		if(username.equals("")) {
			return "";
		}
		else if(AccountServices.getInstance().CheckExistAccount(username))
			return "Đã có người sử dụng tài khoản này";
		else
			return "Có thể sử dụng tài khoản này";
	}
	
	public static String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int i = 0; i < hashedBytes.length; ++i) {
				byte b = hashedBytes[i];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}

		return hash.toString();
	}
}
