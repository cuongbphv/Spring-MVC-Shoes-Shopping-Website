package com.mvp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvp.DAO.ColorDAO;
import com.mvp.DAO.ProductDAO;
import com.mvp.model.Account;
import com.mvp.model.Color;
import com.mvp.model.Material;
import com.mvp.model.Producer;
import com.mvp.model.Product;
import com.mvp.model.ProductType;
import com.mvp.model.ShoeSize;
import com.mvp.model.ShoppingCart;

@Controller
public class DisplayProductController {
	
	@RequestMapping(value="/shopping", method = RequestMethod.GET)
	public String shopping(ModelMap md, HttpSession session) {

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
		List<Producer> producers = ProductDAO.getInstance().GetProducerList();
		List<ShoeSize> sizes = ProductDAO.getInstance().GetSizeList();
		List<Color> colors = ColorDAO.getInstance().GetColorList();
		List<Material> materials = ProductDAO.getInstance().GetMaterialList();
		List<Product> products = ProductDAO.getInstance().GetProductList();
		List<ProductType> types = ProductDAO.getInstance().GetProductTypeList();
		List<List<Product>> list = new ArrayList<List<Product>>();
		
		for (ProductType pt : types) {
			List<Product> lst = products.stream().filter(p->p.getTypeID() == pt.getiD()).collect(Collectors.toList());
			if(!lst.isEmpty())
				list.add(lst);
		}
		
		md.addAttribute("producers", producers);
		md.addAttribute("sizes", sizes);
		md.addAttribute("colors", colors);
		md.addAttribute("materials", materials);
		md.addAttribute("types", types);
		md.addAttribute("list",list);
		
		return "shopping";
	}
	
	
	@RequestMapping(value="/shopping/type/{typeID}", method = RequestMethod.GET)
	public String shoppingWithType(@PathVariable int typeID, ModelMap md, HttpSession session) {

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
		
		List<Producer> producers = ProductDAO.getInstance().GetProducerList();
		List<ShoeSize> sizes = ProductDAO.getInstance().GetSizeList();
		List<Color> colors = ColorDAO.getInstance().GetColorList();
		List<Material> materials = ProductDAO.getInstance().GetMaterialList();
		List<Product> products = ProductDAO.getInstance().GetProductList();
		List<ProductType> types = ProductDAO.getInstance().GetProductTypeList();
		List<Product> list = ProductDAO.getInstance().GetProductList();
		
		if(typeID!=0)
			list = list.stream().filter(p->p.getTypeID() == typeID).collect(Collectors.toList());
		
		int page = 1;
		int pageSize = 16;
		int lsize = list.size();
		
		int pageNums = lsize/pageSize;
		if(lsize % pageSize != 0)
			pageNums += 1;
		
		int startPos = (page-1) * pageSize;
		
		list = list.stream().skip(startPos).limit(pageSize).collect(Collectors.toList());
		
		md.addAttribute("page", page);
		md.addAttribute("pageNums", pageNums);
		md.addAttribute("list", list);
		md.addAttribute("producers", producers);
		md.addAttribute("sizes", sizes);
		md.addAttribute("colors", colors);
		md.addAttribute("materials", materials);
		md.addAttribute("types", types);
		md.addAttribute("currentType", typeID);
		
		return "shoppingwithtype";
	}
	
	
	@RequestMapping(value="/shopping/hotproduct", method = RequestMethod.GET)
	public String hotProduct(HttpSession session, ModelMap md) {

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
		
		List<Producer> producers = ProductDAO.getInstance().GetProducerList();
		List<ShoeSize> sizes = ProductDAO.getInstance().GetSizeList();
		List<Color> colors = ColorDAO.getInstance().GetColorList();
		List<Material> materials = ProductDAO.getInstance().GetMaterialList();
		List<ProductType> types = ProductDAO.getInstance().GetProductTypeList();
		List<Product> list = ProductDAO.getInstance().GetHotProductList();
		
		
		int page = 1;
		int pageSize = 16;
		int lsize = list.size();
		
		int pageNums = lsize/pageSize;
		if(lsize % pageSize != 0)
			pageNums += 1;
		
		int startPos = (page-1) * pageSize;
		
		list = list.stream().skip(startPos).limit(pageSize).collect(Collectors.toList());
		
		md.addAttribute("page", page);
		md.addAttribute("pageNums", pageNums);
		md.addAttribute("list", list);
		md.addAttribute("producers", producers);
		md.addAttribute("sizes", sizes);
		md.addAttribute("colors", colors);
		md.addAttribute("materials", materials);
		md.addAttribute("types", types);
		md.addAttribute("currentType", -1);
		
		return "shoppingwithtype";
	}
	
	@RequestMapping(value="/shopping/hotsaleproduct", method = RequestMethod.GET)
	public String hotSaleProduct(HttpSession session, ModelMap md) {

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
		
		
		List<Producer> producers = ProductDAO.getInstance().GetProducerList();
		List<ShoeSize> sizes = ProductDAO.getInstance().GetSizeList();
		List<Color> colors = ColorDAO.getInstance().GetColorList();
		List<Material> materials = ProductDAO.getInstance().GetMaterialList();
		List<ProductType> types = ProductDAO.getInstance().GetProductTypeList();
		List<Product> list = ProductDAO.getInstance().GetHotSaleProductList();
		
		
		int page = 1;
		int pageSize = 16;
		int lsize = list.size();
		
		int pageNums = lsize/pageSize;
		if(lsize % pageSize != 0)
			pageNums += 1;
		
		int startPos = (page-1) * pageSize;
		
		list = list.stream().skip(startPos).limit(pageSize).collect(Collectors.toList());
		
		md.addAttribute("page", page);
		md.addAttribute("pageNums", pageNums);
		md.addAttribute("list", list);
		md.addAttribute("producers", producers);
		md.addAttribute("sizes", sizes);
		md.addAttribute("colors", colors);
		md.addAttribute("materials", materials);
		md.addAttribute("types", types);
		md.addAttribute("currentType", -1);
		
		return "shoppingwithtype";
	}
	
	@RequestMapping(value="/shopping/discountproduct", method = RequestMethod.GET)
	public String discountProduct(HttpSession session, ModelMap md) {

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
		
		List<Producer> producers = ProductDAO.getInstance().GetProducerList();
		List<ShoeSize> sizes = ProductDAO.getInstance().GetSizeList();
		List<Color> colors = ColorDAO.getInstance().GetColorList();
		List<Material> materials = ProductDAO.getInstance().GetMaterialList();
		List<ProductType> types = ProductDAO.getInstance().GetProductTypeList();
		List<Product> list = ProductDAO.getInstance().GetDiscountProductList();
		
		
		int page = 1;
		int pageSize = 16;
		int lsize = list.size();
		
		int pageNums = lsize/pageSize;
		if(lsize % pageSize != 0)
			pageNums += 1;
		
		int startPos = (page-1) * pageSize;
		
		list = list.stream().skip(startPos).limit(pageSize).collect(Collectors.toList());
		
		md.addAttribute("page", page);
		md.addAttribute("pageNums", pageNums);
		md.addAttribute("list", list);
		md.addAttribute("producers", producers);
		md.addAttribute("sizes", sizes);
		md.addAttribute("colors", colors);
		md.addAttribute("materials", materials);
		md.addAttribute("types", types);
		md.addAttribute("currentType", -1);
		
		return "shoppingwithtype";
	}
	

	@RequestMapping(value="/searchproduct", method = RequestMethod.POST,produces = "text/html; charset=utf-8")
	public String searchProduct(int productType,int colorID, int sizeID, int materialID, 
			int producerID, String searchContent,int page, ModelMap md, HttpSession session) {

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
		}
		else {
			if(acc.getPhanQuyen() == 4) {
				session.setAttribute("user", acc);
				session.setAttribute("url", "home" );
				session.setAttribute("headerText","Tài khoản: " + acc.getCus().getName());
			}
			else if(acc.getPhanQuyen() == 3){
				session.setAttribute("user", acc);
				session.setAttribute("url", "profile" );
				session.setAttribute("headerText",acc.getTenDangNhap() );
			}
			else if(acc.getPhanQuyen() == 2){
				session.setAttribute("user", acc);
				session.setAttribute("url", "profile" );
				session.setAttribute("headerText",acc.getTenDangNhap() );
			}
			else if(acc.getPhanQuyen() == 1){
				session.setAttribute("user", acc);
				session.setAttribute("url", "profile" );
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
		
		List<Product> list = ProductDAO.getInstance().GetProductList();
		if(productType == -1)
			list = ProductDAO.getInstance().GetHotProduct();
		else if(productType == -2)
			list = ProductDAO.getInstance().GetHotSaleProductList();
		else if(productType == -3)
			list = ProductDAO.getInstance().GetDiscountProductList();
		
		if(productType > 0)
			list = list.stream().filter(p->p.getTypeID() == productType).collect(Collectors.toList());
		
		
		if(sizeID!=0)
			list = list.stream().filter(p->p.getSizeList().stream().
					anyMatch(c->c.getiD() == sizeID)).collect(Collectors.toList());
		
		if(colorID!=0)
			list = list.stream().filter(p->p.getColorList().stream().
					anyMatch(c->c.getiD() == colorID)).collect(Collectors.toList());	
			

		if(materialID!=0)
			list = list.stream().filter(p->p.getMaterialID() == materialID).collect(Collectors.toList());
		
		if(producerID!=0)
			list = list.stream().filter(p->p.getProducerID() == producerID).collect(Collectors.toList());
		
		if(!searchContent.equals("0")) {
			list = list.stream().filter(p->p.getName().toLowerCase().contains(searchContent.toLowerCase()))
					.collect(Collectors.toList());
		}
		
		int pageSize = 16;
		int lsize = list.size();
		
		int pageNums = lsize/pageSize;
		if(lsize % pageSize != 0)
			pageNums += 1;
		
		int startPos = (page-1) * pageSize;
		
		list = list.stream().skip(startPos).limit(pageSize).collect(Collectors.toList());
		
		md.addAttribute("type", 0);
		md.addAttribute("page", page);
		md.addAttribute("pageNums", pageNums);
		md.addAttribute("list", list);
		
		return "ajax/productfilter";
	}
	
	@RequestMapping("/about")
	public String about(HttpSession session, ModelMap md)
	{
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
		}
		else {
			if(acc.getPhanQuyen() == 4) {
				session.setAttribute("user", acc);
				session.setAttribute("url", "home" );
				session.setAttribute("headerText","Tài khoản: " + acc.getCus().getName());
			}
			else if(acc.getPhanQuyen() == 3){
				session.setAttribute("user", acc);
				session.setAttribute("url", "profile" );
				session.setAttribute("headerText",acc.getTenDangNhap() );
			}
			else if(acc.getPhanQuyen() == 2){
				session.setAttribute("user", acc);
				session.setAttribute("url", "profile" );
				session.setAttribute("headerText",acc.getTenDangNhap() );
			}
			else if(acc.getPhanQuyen() == 1){
				session.setAttribute("user", acc);
				session.setAttribute("url", "profile" );
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
		return "about";
	}
	
	@RequestMapping("/error")
	public String error(HttpSession session, ModelMap md)
	{

		return "error";
	}
	
	@RequestMapping("/errorReLogin")
	public String errorReLogin(HttpSession session, ModelMap md)
	{

		return "errorReLogin";
	}
}
