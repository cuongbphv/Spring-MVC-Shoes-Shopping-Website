package com.mvp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvp.DAO.*;
import com.mvp.model.*;
import com.sun.org.apache.xml.internal.security.utils.Base64;

@Controller
public class HomeController {
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(ModelMap md, HttpSession session) {
		if(session.getAttribute("url") == null) {
			session.setAttribute("url", "login" );
			session.setAttribute("headerText","Đăng nhập/Đăng ký" );
			
			List<Product> lstHot = ProductDAO.getInstance().GetHotProduct();
			List<Product> lstDiscount = ProductDAO.getInstance().GetDiscountProduct();
			List<Product> lstHostSale = ProductDAO.getInstance().GetHotSale();
			Banner banner = AdminDAO.getInstance().GetBannerByID("Home");
			
			md.addAttribute("banner", banner);
			md.addAttribute("listHot", lstHot);
			md.addAttribute("listDiscount", lstDiscount);
			md.addAttribute("listHotSale", lstHostSale);
			
			
		    synchronized(session) {
		        ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
		        // New visitors get a fresh shopping cart.
		        // Previous visitors keep using their existing cart.
		        if (cart == null) {
		          cart = new ShoppingCart();
		          session.setAttribute("shoppingCart", cart);
		        }
		    }
		}
		else {
			List<Product> lstHot = ProductDAO.getInstance().GetHotProduct();
			List<Product> lstDiscount = ProductDAO.getInstance().GetDiscountProduct();
			List<Product> lstHostSale = ProductDAO.getInstance().GetHotSale();
			Banner banner = AdminDAO.getInstance().GetBannerByID("Home");
			
			md.addAttribute("banner", banner);
			md.addAttribute("listHot", lstHot);
			md.addAttribute("listDiscount", lstDiscount);
			md.addAttribute("listHotSale", lstHostSale);
			
		    synchronized(session) {
		        ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
		        // New visitors get a fresh shopping cart.
		        // Previous visitors keep using their existing cart.
		        if (cart == null) {
		          cart = new ShoppingCart();
		          session.setAttribute("shoppingCart", cart);
		        }
		    }
		}
		return "home";
	}
	
//	@RequestMapping("/home")
//	public String home(HttpSession session, ModelMap md)
//	{
//		List<Product> lstHot = ProductDAO.getInstance().GetHotProduct();
//		List<Product> lstDiscount = ProductDAO.getInstance().GetDiscountProduct();
//		List<Product> lstHostSale = ProductDAO.getInstance().GetHotSale();
//		
//		md.addAttribute("listHot", lstHot);
//		md.addAttribute("listDiscount", lstDiscount);
//		md.addAttribute("listHotSale", lstHostSale);
//		
//	    synchronized(session) {
//	        ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
//	        // New visitors get a fresh shopping cart.
//	        // Previous visitors keep using their existing cart.
//	        if (cart == null) {
//	          cart = new ShoppingCart();
//	          session.setAttribute("shoppingCart", cart);
//	        }
//	    }
//		
//		
//		return "home";
//	}
}
