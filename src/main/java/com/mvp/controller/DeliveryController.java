package com.mvp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvp.DAO.DeliveryDAO;
import com.mvp.DAO.GuaranteeDAO;
import com.mvp.DAO.OrderDAO;
import com.mvp.DAO.StaffDAO;
import com.mvp.model.Account;
import com.mvp.model.Order;
import com.mvp.model.OrderDetail;
import com.mvp.model.Support;
import com.mvp.services.DeliveryServices;
import com.mvp.services.StaffServices;
import com.mvp.services.SupportServices;

@Controller	
public class DeliveryController {
	@RequestMapping(value="/delivery", method = RequestMethod.GET)
	public String manage(HttpSession session, ModelMap md) {
		Account loginacc = (Account)session.getAttribute("user");
		if(loginacc == null) {
			return "redirect:login";
		}
		if(loginacc.getPhanQuyen() == 2 || loginacc.getPhanQuyen() == 4) {
			return "redirect:home";
		}

		return "delivery";
	}

	@RequestMapping(value = "/loadOrderDelivery/{state}/{typeID}/{searchContent}", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String loadOrderDelivery(@PathVariable String state, @PathVariable String typeID, 
			@PathVariable String searchContent, ModelMap md) {

		List<Order> list;

		if(state.equals("TC"))
			list = DeliveryDAO.getInstance().GetListOrderDelivery();
		else if(state.equals("DHMN"))
			list = DeliveryDAO.getInstance().GetListOrderDeliveryDESC();
		else if(state.equals("DHCN"))
			list = DeliveryDAO.getInstance().GetListOrderDeliveryASC();
		else
			list = null;

		try {	

			if(!searchContent.equals("0")) {
				if(typeID.equals("DH"))
					list =  list.stream().filter(p->p.getiD() == Integer.parseInt(searchContent.toLowerCase())).collect(Collectors.toList());
				else if(typeID.equals("KH"))
					list =  list.stream().filter(p->p.getCusID() == Integer.parseInt(searchContent.toLowerCase())).collect(Collectors.toList());
				else if(typeID.equals("DC"))
					list =  list.stream().filter(p->p.getAddress().toLowerCase().contains(searchContent.toLowerCase())).collect(Collectors.toList());
				else if(typeID.equals("SDT"))
					list =  list.stream().filter(p->p.getCustomer().getPhoneNo().contains(searchContent)).collect(Collectors.toList());
			}
		}
		catch(Exception e){
			list = null;
		}

		md.addAttribute("list", list);

		return "ajax/loadOrderDelivery";
	}
	
	@RequestMapping(value = "/loadDeliveryTrucking/{state}/{typeID}/{searchContent}/{page}", method = RequestMethod.GET,
			produces = "text/html; charset=utf-8")
	public String loadDeliveryTrucking(@PathVariable String state, @PathVariable String typeID, 
			@PathVariable String searchContent,@PathVariable int page, ModelMap md, HttpSession session) {

		Account acc = (Account)session.getAttribute("user");
		List<Order> list;
		if (acc == null)
			list = null;
		else {
			if(state.equals("DGHTC"))
				list = DeliveryDAO.getInstance().GetListDeliveryTrucking(acc.getMaNguoiDung());
			else if(state.equals("DGHDHMN"))
				list = DeliveryDAO.getInstance().GetListDeliveryTruckingDESC(acc.getMaNguoiDung());
			else if(state.equals("DGHDHCN"))
				list = DeliveryDAO.getInstance().GetListDeliveryTruckingASC(acc.getMaNguoiDung());
			else
				list = null;

			try {	

				if(!searchContent.equals("0")) {
					if(typeID.equals("DGHDH"))
						list =  list.stream().filter(p->p.getiD() == Integer.parseInt(searchContent.toLowerCase())).collect(Collectors.toList());
					else if(typeID.equals("DGHKH"))
						list =  list.stream().filter(p->p.getCusID() == Integer.parseInt(searchContent.toLowerCase())).collect(Collectors.toList());
					else if(typeID.equals("DGHDC"))
						list =  list.stream().filter(p->p.getAddress().toLowerCase().contains(searchContent.toLowerCase())).collect(Collectors.toList());
					else if(typeID.equals("DGHSDT"))
						list =  list.stream().filter(p->p.getCustomer().getPhoneNo().contains(searchContent)).collect(Collectors.toList());
				}
			}
			catch(Exception e){
				list = null;
			}
		}		

		int pageSize = 10;
		int lsize = list.size();

		int pageNums = lsize/pageSize;
		if(lsize % pageSize != 0)
			pageNums += 1;

		int startPos = (page-1) * pageSize;

		list = list.stream().skip(startPos).limit(pageSize).collect(Collectors.toList());

		md.addAttribute("page", page);
		md.addAttribute("pageNums", pageNums);
		md.addAttribute("list", list);

		return "ajax/loadDeliveryList";
	}
	
	@RequestMapping(value="/setDeliverID/{orderID}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String setDeliverID(@PathVariable String orderID, HttpSession session) {
		
		String notify = "";
		Account acc = (Account)session.getAttribute("user");
		if(acc == null)
			notify = "Không lấy được mã nhân viên giao hàng, vui lòng đăng nhập";
		else {
		
			try {
				if(DeliveryServices.getInstance().SetDeliveryID(Integer.parseInt(orderID), acc.getMaNguoiDung())) {
					notify = "Đã nhận giao đơn hàng thành công!";
				}
				else {
					notify= "Có lỗi trong quá trình nhận giao đơn hàng, vui lòng kiểm tra lại!";
				}
				
			}
			catch(Exception e) {
				notify= "Vui lòng kiểm tra lỗi: " + e;
			}
		}
		return notify;
	}
	
	@RequestMapping(value = "/viewDetailDelivery/{orderID}", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String viewDetailDelivery(@PathVariable String orderID, ModelMap md) {

		Order ord = OrderDAO.getInstance().GetOrderByID(Integer.parseInt(orderID));
		List<OrderDetail> list = ord.getListDetail();

		md.addAttribute("ord", ord);
		md.addAttribute("list", list);

		return "ajax/loadOrderDetailDelivery";
	}
	
	@RequestMapping(value="/submitOrderStateDelivery/{orderID}/{state}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String submitOrderStateDelivery(@PathVariable String orderID, @PathVariable int state, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String log = staffName + " ("+username+") " + " đã xác nhận khách không nhận đơn hàng "+orderID;
		String log2 = staffName + " ("+username+") " + " đã xác nhận giao đơn hàng "+orderID;
		String notify = "";
		if(state == 1){
			try {
				if(DeliveryServices.getInstance().SubmitOrderStateDelivery(Integer.parseInt(orderID), state)) {
					notify = "Đã xác nhận giao hàng thành công!";
					if(SupportServices.getInstance().AddNewLog(log2))
						System.out.println("Thêm nhật ký hệ thống thành công");
					else
						System.out.println("Có lỗi khi thêm nhật ký hệ thống");
				}
				else {
					notify= "Có lỗi trong quá trình xác nhận giao hàng, vui lòng kiểm tra lại!";
				}
				
			}
			catch(Exception e) {
				notify= "Vui lòng kiểm tra lỗi: " + e;
			}
		}
		else {
			try {
				if(DeliveryServices.getInstance().SubmitOrderStateDelivery(Integer.parseInt(orderID), state)) {
					notify = "Đã xác nhận khách không nhận hàng thành công!";
					
					if(SupportServices.getInstance().AddNewLog(log))
						System.out.println("Thêm nhật ký hệ thống thành công");
					else
						System.out.println("Có lỗi khi thêm nhật ký hệ thống");
				}
				else {
					notify= "Có lỗi trong quá trình xác nhận không nhận hàng, vui lòng kiểm tra lại!";
				}
				
			}
			catch(Exception e) {
				notify= "Vui lòng kiểm tra lỗi: " + e;
			}
		}
		return notify;
	}
	
	@RequestMapping(value="/loadDeliveryHistory/{page}/{State}/{fDate}/{eDate}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String getListSupportStaff(@PathVariable int page, @PathVariable String State, @PathVariable String fDate, @PathVariable String eDate, 
			ModelMap md, HttpSession session) {

		List<Order> list;
		Account acc = (Account)session.getAttribute("user");
		if(acc == null)
			list = null;
		else {
			try {				
	
				if(State.equals("LSTC"))
					list = DeliveryDAO.getInstance().GetListDeliveryHistory(acc.getMaNguoiDung());
				else if(State.equals("LSDGH"))
					list = DeliveryDAO.getInstance().GetListDeliveredHistory(acc.getMaNguoiDung());
				else if(State.equals("LSKNH"))
					list = DeliveryDAO.getInstance().GetListCanceledHistory(acc.getMaNguoiDung());
				else
					list = null;
	
				fDate += " 00:00:01";
				eDate += " 23:59:59";			
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
				try {	
					Date start = sdf.parse(fDate);
					Date end = sdf.parse(eDate);	
	
					list = list.stream().filter(p->p.getTradeTime().getTime() >= start.getTime() &&
							p.getTradeTime().getTime() <= end.getTime()).collect(Collectors.toList());				
				}
				catch(Exception eee)
				{
					md.addAttribute("list", null);
				}			
	
				int pageSize = 7;
				int lsize = list.size();
				
				int pageNums = lsize/pageSize;
				if(lsize % pageSize != 0)
					pageNums += 1;
				
				int startPos = (page-1) * pageSize;
				
				list = list.stream().skip(startPos).limit(pageSize).collect(Collectors.toList());
				
				md.addAttribute("page", page);
				md.addAttribute("pageNums", pageNums);				
				md.addAttribute("list", list);
			}
			catch(Exception ee) {
				md.addAttribute("list", null);
			}
		}

		return "ajax/loadDeliveryHistory";
	}
}
