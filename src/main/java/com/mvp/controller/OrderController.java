package com.mvp.controller;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.*;
import javax.servlet.http.*;

import com.mvp.DAO.AdminDAO;
import com.mvp.DAO.CustomerDAO;
import com.mvp.DAO.OrderDAO;
import com.mvp.DAO.PromotionDAO;
import com.mvp.DAO.StaffDAO;
import com.mvp.model.*;
import com.mvp.services.OrderServices;
import com.mvp.services.ProductServices;
import com.mvp.services.SupportServices;

@Controller
public class OrderController {

	@RequestMapping(value = "product/addToCart/{pID}/{ColorID}/{SizeID}", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String AddToCart(HttpSession session,@PathVariable String pID, @PathVariable int ColorID,
			@PathVariable int SizeID) {
		String notify = "";
		synchronized(session) {
			ShoppingCart cart;
			cart = (ShoppingCart)session.getAttribute("shoppingCart");
			// New visitors get a fresh shopping cart.
			// Previous visitors keep using their existing cart.
			if (cart == null) {
				cart = new ShoppingCart();
				session.setAttribute("shoppingCart", cart);
			}
			if(ColorID != 0 && SizeID != 0) {
				if(ProductServices.getInstance().GetStock(pID, ColorID, SizeID) > cart.getCurrentStock(pID,ColorID,SizeID))
				{
					System.out.println(ProductServices.getInstance().GetStock(pID, ColorID, SizeID) + "/" +cart.getCurrentStock(pID,ColorID,SizeID) );
					if (pID != null) {
						cart.addItem(pID, ColorID, SizeID);
					}
					notify = "Đã thêm sản phẩm vào giỏ hàng thành công!";
				}
				else
				{
					notify = "Sản phẩm bạn chọn đã hết số lượng, vui lòng thử lại màu và size khác!";
				}
			}
			else
			{
				notify = "Vui lòng chọn màu sắc và size trước khi thêm vào giỏ hàng!";
			}
		}
		return notify;
	}

	@RequestMapping(value="/numItemOrdered", method = RequestMethod.GET)
	@ResponseBody
	public String numItemOrdered(HttpSession session) {

		ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
		int num = cart.getItemsOrdered().size();

		return num+"";
	}

	@RequestMapping(value="/cart", method = RequestMethod.GET)
	public String cart(HttpSession session,ModelMap md)
	{

		ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");

		md.addAttribute("list", cart.getItemsOrdered());
		md.addAttribute("totalPrice", cart.getTotalPrice());

		Account acc = (Account)session.getAttribute("user");
		
		if(acc == null) {
			session.setAttribute("url", "login" );
			session.setAttribute("headerText","Đăng nhập/Đăng ký" );			
		}
		else {
			if(acc.getPhanQuyen() == 4) {
				session.setAttribute("url", "profile" );
				session.setAttribute("headerText","Tài khoản: " + acc.getCus().getName() );
			}else {
				session.setAttribute("url", "profile" );
				session.setAttribute("headerText","Tài khoản: " + acc.getTenDangNhap() );
			}
		}

		return "ShoppingCart";

	}


	@RequestMapping(value="/setNumOrdered/{pID}/{ColorID}/{SizeID}/{Num}", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String AddWithValue(HttpSession session,@PathVariable String pID, @PathVariable int ColorID,
			@PathVariable int SizeID,@PathVariable int Num) {

		String notify="";
		if(ProductServices.getInstance().GetStock(pID, ColorID, SizeID) >= Num )
		{
			ShoppingCart cart;
			synchronized(session) {
				cart = (ShoppingCart)session.getAttribute("shoppingCart");
				// New visitors get a fresh shopping cart.
				// Previous visitors keep using their existing cart.
				if (cart == null) {
					cart = new ShoppingCart();
					session.setAttribute("shoppingCart", cart);
				}

				if (pID != null) {
					cart.setNumOrdered(pID, ColorID, SizeID,Num);
				}
				notify = "";
			}
		}
		else
		{
			notify = "Sản phẩm bạn chọn đã giới hạn số lượng!";
		}

		return notify;
	}


	@RequestMapping(value="/showCart", method = RequestMethod.GET)
	public String showCart(HttpSession session, ModelMap md) {

		ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");

		md.addAttribute("list", cart.getItemsOrdered());
		md.addAttribute("totalPrice", cart.getTotalPrice());


		return "ajax/showCart";
	}

	
	@RequestMapping(value="/checkout", method = RequestMethod.GET,produces = "text/html; charset=utf-8" )
	public String checkout(HttpSession session, ModelMap md) {
		
		Account acc = (Account)session.getAttribute("user");
		if(acc == null) {
			session.setAttribute("url", "login" );
			session.setAttribute("headerText","Đăng nhập/Đăng ký" );			
		}
		else {
			if(acc.getPhanQuyen() == 4) {
				session.setAttribute("url", "profile" );
				session.setAttribute("headerText","Tài khoản: " + acc.getCus().getName() );
			}else {
				session.setAttribute("url", "profile" );
				session.setAttribute("headerText","Tài khoản: " + acc.getTenDangNhap() );
			}
		}
		
		ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
		cart.setDiscount(0);
		Customer cus = CustomerDAO.getInstance().GetCustomerByID(Integer.parseInt(acc.getMaNguoiDung()));
		md.addAttribute("list", cart.getItemsOrdered());
		md.addAttribute("totalPrice", cart.getTotalPrice());
		md.addAttribute("discount", cart.getDiscount());
		md.addAttribute("cus",cus);
		
		return "checkout";
	}
	
	@RequestMapping(value="/checkoutprice", method = RequestMethod.GET,produces = "text/html; charset=utf-8" )
	public String checkOutPrice(HttpSession session, ModelMap md) {
		
		ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
		
		double price = Double.parseDouble(cart.getTotalPrice()) - Double.parseDouble(cart.getTotalPrice())*cart.getDiscount()/100;
		
		md.addAttribute("totalPrice", price);
		md.addAttribute("lastPrice", (price + price*0.1));
		
		return "ajax/checkoutprice";
	}
	
	@RequestMapping(value="/setDiscountCode/{DiscountCode}", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String setDiscountCode(@PathVariable String DiscountCode, HttpSession session) 
	{
		String notify = "";
		
		Promotion pr = PromotionDAO.getInstance().GetAvailablePromotionByID(DiscountCode);
		if(pr != null) {
			ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
			cart.setDiscount(pr.getPercent());
			cart.setDiscountCode(DiscountCode);
			notify = "Áp dụng mã thành công!" + "/(-" + pr.getPercent()+"%)"; 
		}
		else {
			notify = "Mã không đúng ở thời điểm hiện tại!"; 
		}
		
		return notify;
	}
	
	
	@RequestMapping(value="/setOrder", method = RequestMethod.POST,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String setOrder(String address, HttpSession session)
	{
		String notify = "";
		
		synchronized(session) {
			ShoppingCart cart;
			Account acc =  (Account)session.getAttribute("user");
			int cusID = Integer.parseInt(acc.getMaNguoiDung());
			cart = (ShoppingCart)session.getAttribute("shoppingCart");

			int orderID;
			orderID = OrderServices.getInstance().SetOrder(cusID, cart.getDiscountCode(),address);
			if(orderID != -1) {
				for(int i = 0 ; i < cart.getItemsOrdered().size();i++) {
					ItemOrder item = (ItemOrder)cart.getItemsOrdered().get(i);
					String price = (100 - item.getItem().getDiscount())*Double.parseDouble(item.getItem().getPrice())/100 + "";
					if(!OrderServices.getInstance().SetOrderDetail(orderID, item.getItemID(), item.getColorID(),
							item.getSizeID(), item.getNumItems(), price )){
						return notify = "Lỗi khi thêm sản phẩm " + item.getItem().getName() + "" + 
								item.getColorItem().getName() + "" + item.getSizeItem().getName()	+", sản phẩm đã hết hàng!";
					}
				}
				notify = "Đặt hàng thành công";	
				cart = new ShoppingCart();
				session.setAttribute("shoppingCart", cart);
			}
			else {
				notify = "Đã xảy ra lỗi khi đặt hàng";
			}
		}
		
		return notify;
	}

	@RequestMapping(value="/orderdetail/{orderID}", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String orderDetail(@PathVariable int orderID, ModelMap md,HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		
		if(acc == null) {
			return "errorReLogin";
		}
		else {
			Date date = new Date();
			int block = 0;
			int numsDay = Integer.parseInt((AdminDAO.getInstance().GetFeatureByID("CANCELORDER")).getValue());
					
			//List<OrderDetail> list = OrderDAO.getInstance().GetOrderDetailByOrderID(orderID);
			Order order = OrderDAO.getInstance().GetOrderByIDAndCusID(orderID,Integer.parseInt(acc.getMaNguoiDung()));
			if(date.getTime() - order.getTradeTime().getTime() < numsDay*3600*1000 && order.getStatus().equals("Đang chờ xử lý"))
				block = 1;
			md.addAttribute("order", order);
			md.addAttribute("block", block);
		}
			
		return "OrderDetail";
	}
	
	
	@RequestMapping(value="/orderinfo", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String orderInfo(HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		if(acc == null) {
			return "errorReLogin";			
		}
		else {
			if(acc.getPhanQuyen() == 4) {
				session.setAttribute("url", "profile" );
				session.setAttribute("headerText","Tài khoản: " + acc.getCus().getName() );
			}else {
				session.setAttribute("url", "profile" );
				session.setAttribute("headerText","Tài khoản: " + acc.getTenDangNhap() );
			}
		}
		
		return "OrderInfo";
	}
	
	@RequestMapping(value="/showOrderInfo/{numDays}", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String showOrderInfo(@PathVariable int numDays, ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		
		
		int cusID = Integer.parseInt(acc.getMaNguoiDung());
		List<Order> list = OrderDAO.getInstance().GetOrderByCustomerIDAndDate(cusID,numDays);
		md.addAttribute("list", list);
		
		return "ajax/showOrderInfo";
	}
	
	
	@RequestMapping(value="/cancelorder/{orderID}", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String cancelOrder(@PathVariable int orderID, HttpSession session) {
		String notify = "";
		Account acc = (Account)session.getAttribute("user");
		if(acc != null) {
			int cusID = Integer.parseInt(acc.getMaNguoiDung());

			if(OrderServices.getInstance().CancelOrder(orderID, cusID)) {
				notify = "Hủy đơn hàng thành công";
				String cusName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
				String username = acc.getMaNguoiDung();
				String log = cusName + " ("+username+") " + " đã hủy đơn hàng "+orderID;
				
				if(SupportServices.getInstance().AddNewLog(log))
					System.out.println("Thêm nhật ký hệ thống thành công");
				else
					System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			}
			else {
				notify = "Đã xảy ra lỗi khi hủy, vui lòng thử lại";
			}
		}else {
			notify = "Đã xảy ra lỗi khi hủy, vui lòng thử lại";
		}
		
		return notify;
	}
	
	@RequestMapping(value="/loadSubAddExMain", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String loadSubAddExMain(HttpSession session, ModelMap md) {
		
		Account acc = (Account)session.getAttribute("user");
		Customer cus = CustomerDAO.getInstance().GetCustomerByID(Integer.parseInt(acc.getMaNguoiDung()));
		List<CustomerAddress> list = cus.getAllAddress();
		
	//	list = list.stream().filter(p->p.isDefaultAdd() == false).collect(Collectors.toList());
		
		md.addAttribute("list", list);
		
		return "ajax/orderSubAddress";
	}
	
	
	
	
	
	
}
