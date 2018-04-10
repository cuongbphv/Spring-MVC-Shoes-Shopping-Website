package com.mvp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvp.DAO.AdminDAO;
import com.mvp.DAO.BillDAO;
import com.mvp.DAO.CustomerDAO;
import com.mvp.DAO.OrderDAO;
import com.mvp.DAO.ProductDAO;
import com.mvp.DAO.SizeDAO;
import com.mvp.DAO.StaffDAO;
import com.mvp.DAO.StaffTypeDAO;
import com.mvp.model.Account;
import com.mvp.model.Bill;
import com.mvp.model.BillDetail;
import com.mvp.model.Color;
import com.mvp.model.Customer;
import com.mvp.model.CustomerType;
import com.mvp.model.Order;
import com.mvp.model.OrderDetail;
import com.mvp.model.Product;
import com.mvp.model.ShoeSize;
import com.mvp.model.Staff;
import com.mvp.model.StaffType;
import com.mvp.services.AccountServices;
import com.mvp.services.ProductServices;
import com.mvp.services.StaffServices;
import com.mvp.services.SupportServices;




@Controller
public class StaffController {

	@RequestMapping(value = "/staff", method = RequestMethod.GET)
	public String staff(HttpSession session) {
		Account acc = (Account)session.getAttribute("user");
		
		if(acc == null)
			return "redirect:login";
		
		if(acc.getPhanQuyen() == 3 || acc.getPhanQuyen() == 4) {
			return "redirect:home";
		}
		
		return "staff";
	}
	
	@RequestMapping(value = "/guarantee", method = RequestMethod.GET)
	public String guarantee() {
		return "guarantee";
	}

	
	@RequestMapping(value="/getListStaff/{typeID}/{searchContent}/{staffType}", method = RequestMethod.GET)
	public String getListStaff(@PathVariable String typeID, @PathVariable String searchContent, @PathVariable String staffType,
			ModelMap md) {
		List<Staff> lst = StaffDAO.getInstance().GetListStaff();	
		List<Staff> list;
		
		if(!staffType.equals("0"))
			list = lst.stream().filter(p->p.getMaLoaiNV() == Integer.parseInt(staffType)).collect(Collectors.toList());
		else
			list = StaffDAO.getInstance().GetListStaff();
		
		try {	

			if(!searchContent.equals("-1")) {
				if(typeID.equals("NVTNV"))
					list =  list.stream().filter(p->p.getTenNV().toLowerCase().contains(searchContent.toLowerCase())).collect(Collectors.toList());
				else if(typeID.equals("NVMNV"))
					list =  list.stream().filter(p->p.getMaNV().toLowerCase().equals(searchContent.toLowerCase())).collect(Collectors.toList());
				else if(typeID.equals("NVDC"))
					list =  list.stream().filter(p->p.getDiaChi().toLowerCase().contains(searchContent.toLowerCase())).collect(Collectors.toList());
				else if(typeID.equals("NVSDT"))
					list =  list.stream().filter(p->p.getSoDienThoai().toLowerCase().contains(searchContent.toLowerCase())).collect(Collectors.toList());
			}
		}
		catch(Exception e){
			list = null;
		}
		md.addAttribute("list", list);		
		return "ajax/staffList";
	}
	
	@RequestMapping(value="/getUsernameStaff/{ID}",  method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String getUsernameStaff(@PathVariable String ID, ModelMap md){
		String user = StaffDAO.getInstance().GetStaffUsername(ID);
		if(user == null || user == "")
		{
			user = "Không có tài khoản";
		}
		return user;
	}
	
	@RequestMapping(value="/editStaffInfo",  method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String editStaffInfo(@RequestParam("staffID") String staffID,@RequestParam("staffName") String staffName,
			@RequestParam("staffAddress") String staffAddress, @RequestParam("staffPhoneNumber") String staffPhoneNumber,
					@RequestParam("staffDateofBirth") String staffDateofBirth, @RequestParam("staffGender") String staffGender,
					@RequestParam("staffTypeID") String staffTypeID, HttpSession session){
		
		Account acc = (Account)session.getAttribute("user");
		String staffn = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldStaff = (StaffDAO.getInstance().GetStaffByID(staffID)).getTenNV();
		String oldUser = StaffDAO.getInstance().GetStaffUsername(staffID);
		String log = staffn + " ("+username+") " + "đã chỉnh sửa nhân viên "+oldStaff+" ("+oldUser+")";
		
		String notify = "";
		
		if(StaffServices.getInstance().EditStaff(staffID, staffName, staffAddress, staffPhoneNumber, staffDateofBirth, staffGender, 
				Integer.parseInt(staffTypeID))) {
			notify = "Chỉnh sửa thông tin nhân viên thành công";
			if(SupportServices.getInstance().AddNewLog(log))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
		}
		else {
			notify = "Xảy ra lỗi khi chỉnh sửa thông tin nhân viên";
		}
		
		return notify;
	}
	
	@RequestMapping(value="/addStaff",  method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String addStaff(@RequestParam("staffID") String staffID,@RequestParam("staffName") String staffName,
			@RequestParam("staffAddress") String staffAddress, @RequestParam("staffPhoneNumber") String staffPhoneNumber,
					@RequestParam("staffDateofBirth") String staffDateofBirth, @RequestParam("staffGender") String staffGender,
					@RequestParam("staffUsername") String staffUsername, @RequestParam("staffPassword") String staffPassword,
					@RequestParam("staffTypeID") String staffTypeID, HttpSession session){
		
		Account acc = (Account)session.getAttribute("user");
		String staffn = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String log = staffn + " ("+username+") " + "đã thêm nhân viên "+staffName;
		
		String notify = "";
		
		String pass = AccountController.generateHash(AccountController.firstSALT+ staffPassword + AccountController.lastSALT);
		
		if(StaffServices.getInstance().AddStaff(staffID, staffName, staffAddress, staffPhoneNumber, staffDateofBirth, 
				staffGender, staffUsername, pass, Integer.parseInt(staffTypeID))) {
			notify = "Thêm nhân viên và tài khoản thành công!";
			String oldUser = StaffDAO.getInstance().GetStaffUsername(staffID);
			if(SupportServices.getInstance().AddNewLog(log + "("+oldUser+")"))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
		}
		else
			notify = "Có lỗi trong quá trình thêm nhân viên, kiểm tra lại dữ liệu nhập!";
		return notify;
	}
	
	@RequestMapping(value="/deleteStaff/{id}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String deleteStaff(@PathVariable String id, HttpSession session) {
		Account acc = (Account)session.getAttribute("user");
		String notify = "";
		if(acc.getMaNguoiDung().equals(id) ){
			notify = "Không thể xóa người đang đăng nhập!";
		}
		else {
			try {
				String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
				String username = acc.getMaNguoiDung();
				String oldStaff = (StaffDAO.getInstance().GetStaffByID(id)).getTenNV();
				String oldUser = StaffDAO.getInstance().GetStaffUsername(id);
				String log = staffName + " ("+username+") " + "đã xóa nhân viên "+oldStaff+" ("+oldUser+")";
				
				if(StaffServices.getInstance().DeleteStaff(id)) {
					notify = "Đã xóa nhân viên thành công!";
					if(SupportServices.getInstance().AddNewLog(log))
						System.out.println("Thêm nhật ký hệ thống thành công");
					else
						System.out.println("Có lỗi khi thêm nhật ký hệ thống");
				}
				else {
					notify= "Đã xảy ra lỗi khi xóa nhân viên vui lòng kiểm tra lỗi!";
				}
				
			}
			catch(Exception e) {
				notify= "Đã xảy ra lỗi khi xóa nhân viên!";
			}
		}
		return notify;
	}
	
	@RequestMapping(value="/resetStaffPassword/{id}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String resetStaffPassword(@PathVariable String id, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldStaff = (StaffDAO.getInstance().GetStaffByID(id)).getTenNV();
		String oldUser = StaffDAO.getInstance().GetStaffUsername(id);
		String log = staffName + " ("+username+") " + "đã khôi phục mật khẩu của nhân viên "+oldStaff+" ("+oldUser+")";
		
		String notify = "";
		
		String pass=  (AdminDAO.getInstance().GetFeatureByID("PASSNV")).getValue();
		
		pass = AccountController.generateHash(AccountController.firstSALT+ pass + AccountController.lastSALT); 
		
		try {
			if(StaffServices.getInstance().ResetStaffPassword(id,pass)) {
				notify = "Đã khôi phục mật khẩu tài khoản nhân viên thành công!";
				if(SupportServices.getInstance().AddNewLog(log))
					System.out.println("Thêm nhật ký hệ thống thành công");
				else
					System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			}
			else {
				notify= "Đã xảy ra lỗi khi khôi phục mật khẩu!";
			}
			
		}
		catch(Exception e) {
			notify= "Đã xảy ra lỗi khi khôi phục mật khẩu!";
		}
		
		return notify;
	}
	

	@RequestMapping(value = "/getOrder/{page}/{state}/{typeID}/{searchContent}", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String getOrder(@PathVariable int page, @PathVariable String state, @PathVariable String typeID, 
							@PathVariable String searchContent,ModelMap md) {
		
		
		List<Order> orders = OrderDAO.getInstance().GetListOrder();
		List<Order> list;
		
		if(state.equals("TC"))
			list = orders.stream().collect(Collectors.toList());
		else if(state.equals("DCXL"))
			list = orders.stream().filter(p->p.getStatus().equals("Đang chờ xử lý")).collect(Collectors.toList());
		else if(state.equals("DXN"))
			list = orders.stream().filter(p->p.getStatus().equals("Đã xác nhận")).collect(Collectors.toList());
		else if(state.equals("DGH"))
			list = orders.stream().filter(p->p.getStatus().equals("Đang giao hàng")).collect(Collectors.toList());
		else if(state.equals("GH"))
			list = orders.stream().filter(p->p.getStatus().equals("Đã giao hàng")).collect(Collectors.toList());
		else
			list = orders.stream().filter(p->p.getStatus().equals("Đã hủy")).collect(Collectors.toList());
		
		try {	

			if(!searchContent.equals("0")) {
				if(typeID.equals("DH"))
					list =  list.stream().filter(p->p.getiD() == Integer.parseInt(searchContent.toLowerCase())).collect(Collectors.toList());
				else if(typeID.equals("KH"))
					list =  list.stream().filter(p->p.getCusID() == Integer.parseInt(searchContent.toLowerCase())).collect(Collectors.toList());
				else if(typeID.equals("NV"))
					list =  list.stream().filter(p->p.getStaffID().toLowerCase().contains(searchContent.toLowerCase())).collect(Collectors.toList());	
			}
		}
		catch(Exception e){
			list = null;
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
		
		return "ajax/showOrderList";
	}
	
	@RequestMapping(value = "/getOrderDetail/{orderID}", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String getOrderDetail(@PathVariable int orderID, ModelMap md) {
		
		Order order = OrderDAO.getInstance().GetOrderByID(orderID);
		List<OrderDetail> orderDetail = OrderDAO.getInstance().GetOrderDetailByOrderID(orderID);
		md.addAttribute("orderDetail", orderDetail);
		md.addAttribute("order", order);
		
		double total = orderDetail.stream().filter(p->Double.parseDouble(p.getTotalPrice()) > 1).mapToDouble(p->Double.parseDouble(p.getTotalPrice())).sum();
		String totalPrice = total +"";
		md.addAttribute("totalPrice", totalPrice);
		
		int ck = 0;
		int pr = 0;
		if(order.getDiscount() != null)
			pr = order.getDiscount().getPercent();
			
		double tprice = total*(100 - pr)/100;
		tprice = tprice * 1.1;
		if(Double.parseDouble(order.getTotalPrice()) != tprice) {
			for(int i = 0 ; i <= 10; i++) {
				double tprice1 = total*(100 - pr - i)/100;
				tprice1 = tprice1 * 1.1;
				if(tprice1 == Double.parseDouble(order.getTotalPrice())) {
					ck = i;
					break;
				}
			}
		}
		md.addAttribute("ck", ck);
		Date date = new Date();
		int blockCancel = 0;
		int blockConfirm = 1;
		
		//List<OrderDetail> list = OrderDAO.getInstance().GetOrderDetailByOrderID(orderID);
		//date.getTime() - order.getTradeTime().getTime() < 24*3600*1000 &&
		if( order.getStatus().equals("Đang chờ xử lý"))
			blockCancel = 0;
		
		if(order.getStatus().equals("Đang chờ xử lý"))
			blockConfirm = 0;
		
		md.addAttribute("blockCancel", blockCancel);
		md.addAttribute("blockConfirm", blockConfirm);
		
		
		return "ajax/staffOrderDetail";
	}
	
	@RequestMapping(value="/modifyOrderDetail", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String modifyOrderDetail(String pID, String orderID, String oldColorID, String oldSizeID
			, String newColorID, String newSizeID, String stocks, HttpSession session) {
		String notify = " ";
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String log = staffName + " ("+username+") " + "đã chỉnh sửa đơn hàng "+orderID+" theo yêu cầu";
		
		
		try {
			Product pd = ProductDAO.getInstance().GetProductByID(pID);
			Color cl = ProductDAO.getInstance().GetColorById(Integer.parseInt(newColorID));
			ShoeSize sz = ProductDAO.getInstance().GetSizeById(Integer.parseInt(newSizeID));
			

				if(!StaffServices.getInstance().ModifyOrderDetail(pID, Integer.parseInt(orderID), Integer.parseInt(oldColorID),
						Integer.parseInt(oldSizeID), Integer.parseInt(newColorID), 
						Integer.parseInt(newSizeID), Integer.parseInt(stocks))){
					notify = "Đã xảy ra lỗi khi thêm Sản phẩm: " +pd.getName() +" (" + cl.getName() + " - " + sz.getName() +")" +
							", Kiểm tra số lượng và thử lại";
				}
				else {
					if(SupportServices.getInstance().AddNewLog(log))
						System.out.println("Thêm nhật ký hệ thống thành công");
					else
						System.out.println("Có lỗi khi thêm nhật ký hệ thống");
				}
			
		}
		catch(Exception e) {
			notify= "Đã xảy ra lỗi, vui lòng kiểm tra thông tin và thử lại!";
		}
		
		return notify;
	}
	
	@RequestMapping(value="/confirmOrder/{orderID}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String confirmOrder(@PathVariable int orderID, HttpSession session) {
		String notify = "Xác nhận thành công";
		Account acc = (Account)session.getAttribute("user");
		String staffID = acc.getMaNguoiDung();
		try {
			
			if(!StaffServices.getInstance().ConfirmOrder(staffID, orderID)){
				notify = "Đã xảy ra lỗi khi xác nhận đơn hàng, vui lòng thử lại";
			}
			else {
				String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
				String username = acc.getMaNguoiDung();
				String log = staffName + " ("+username+") " + "đã xác nhận đơn hàng "+orderID;
				
				if(SupportServices.getInstance().AddNewLog(log))
					System.out.println("Thêm nhật ký hệ thống thành công");
				else
					System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			}
			
		}
		catch(Exception e) {
			notify = "Đã xảy ra lỗi khi xác nhận đơn hàng, vui lòng thử lại";
		}
		
		return notify;
	}
	
	@RequestMapping(value="/cancelOrderStaff/{orderID}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String cancelOrderStaff(@PathVariable int orderID, HttpSession session) {
		String notify = "Hủy thành công";
		Account acc = (Account)session.getAttribute("user");
		String staffID = acc.getMaNguoiDung();
		try {
			
			if(!StaffServices.getInstance().CancelOrderStaff(staffID, orderID)){
				notify = "Đã xảy ra lỗi khi hủy đơn hàng, vui lòng thử lại";
			}else {
				String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
				String username = acc.getMaNguoiDung();
				String log = staffName + " ("+username+") " + "đã hủy đơn hàng "+orderID;
				
				if(SupportServices.getInstance().AddNewLog(log))
					System.out.println("Thêm nhật ký hệ thống thành công");
				else
					System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			}
			
		}
		catch(Exception e) {
			notify = "Đã xảy ra lỗi khi hủy đơn hàng, vui lòng thử lại";
		}
		
		return notify;
	}
	
	@RequestMapping(value="/updateOrderState/{orderID}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String UpdateOrderState(@PathVariable int orderID) {
		
		
		StaffServices.getInstance().UpdateOrderState(orderID);
		
		return "";
	}
	
	
	@RequestMapping(value="/getComboboxCustomerType", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String getComboboxCustomerType(ModelMap md) {
		
		List<CustomerType> list = CustomerDAO.getInstance().GetListCustomerType();
		md.addAttribute("list", list);
		
		return "ajax/selectBoxCustomerType";
	}
	
	
	@RequestMapping(value="/getCustomers/{page}/{state}/{typeID}/{searchContent}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String getListCustomer(@PathVariable int page, @PathVariable String state, @PathVariable String typeID, 
			@PathVariable String searchContent,ModelMap md) {

		Locale.setDefault(new Locale("vn"));

		List<Customer> customers = CustomerDAO.getInstance().GetListCustomer();
		List<Customer> list;

		customers.sort((p1,p2)-> p1.getName().split(" ")[p1.getName().split(" ").length - 1].compareTo(
				p2.getName().split(" ")[p2.getName().split(" ").length - 1]));
		
		
		if(state.equals("0"))
			list = customers.stream().collect(Collectors.toList());
		else
			list = customers.stream().filter(p->p.getCusTypeID()== Integer.parseInt(state)).collect(Collectors.toList());


		if(!searchContent.equals("0")) {
			if(typeID.equals("MKH"))
			{
				try {
				list =  list.stream().filter(p->p.getCusID() == Integer.parseInt(searchContent.toLowerCase())).collect(Collectors.toList());
				}
				catch(Exception e){
					list = null;
				}
			}
			else if(typeID.equals("TKH"))
				list =  list.stream().filter(p->p.getName().toLowerCase().contains(searchContent.toLowerCase())).collect(Collectors.toList());
			else if(typeID.equals("SDT"))
				list =  list.stream().filter(p->p.getPhoneNo().equals(searchContent.toLowerCase())).collect(Collectors.toList());	
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

		
		return "ajax/showCustomerList";
	}

	@RequestMapping(value = "/getOrderListByCusID/{cusID}/{startDate}/{endDate}", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String getOrderByCusID(@PathVariable int cusID,@PathVariable String startDate, @PathVariable String endDate,ModelMap md) {
		
		
		List<Order> orders = OrderDAO.getInstance().GetListOrderByCusID(cusID);
		List<Order> list = null;
		
		startDate += " 00:00:01";
		endDate += " 23:59:59";
			
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {	
	        Date start = simpleDateFormat.parse(startDate);
	        Date end = simpleDateFormat.parse(endDate);	
	        
	        list = orders.stream().filter(p->p.getTradeTime().getTime() >= start.getTime() &&
	        		p.getTradeTime().getTime() <= end.getTime()).collect(Collectors.toList());
			
		}
        catch (ParseException ex)
        {
            System.out.println("Exception "+ex);
        }
		catch(Exception e){
			list = null;
		}
		
		
		md.addAttribute("list", list);
		
		return "ajax/showCustomerTradeHistory";
	}
	
	@RequestMapping(value="/customerInfo/{cusID}", method = RequestMethod.GET)
	public String profileInfo(@PathVariable int cusID, ModelMap md) {
		
		Customer ct = CustomerDAO.getInstance().GetCustomerByID(cusID);
		md.addAttribute("info", ct);
		md.addAttribute("staffRequest", 1);
	
		return "ajax/showProfile";
	}
	
	@RequestMapping(value="/resetCustomerPass/{cusID}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String resetCustomerPass(@PathVariable String cusID, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String cusName = (CustomerDAO.getInstance().GetCustomerByID(Integer.parseInt(cusID))).getName();
		String log = staffName + " ("+username+") " + "đã khôi phục mật khẩu mặc định khách hàng "+
										cusName+"( Mã khách hàng: "+cusID+" )";
		
		String pass= (AdminDAO.getInstance().GetFeatureByID("PASSKH")).getValue();
		
		pass = AccountController.generateHash(AccountController.firstSALT+ pass + AccountController.lastSALT); 
		
		if(AccountServices.getInstance().resetCustomerPass(cusID, pass)) {
			if(SupportServices.getInstance().AddNewLog(log))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			return "Đặt lại mật khẩu thành công";
		}
		
		return "Có lỗi xảy ra trong quá trình thực hiện, vui lòng thử lại";
	}
	
	
	@RequestMapping(value = "/getBill/{page}/{state}/{typeID}/{searchContent}", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String getBill(@PathVariable int page,@PathVariable String state, @PathVariable String typeID, 
							@PathVariable String searchContent,ModelMap md) {
		
		
		List<Bill> bills = BillDAO.getInstance().GetListBill();
		List<Bill> list = null;
		
		if(state.equals("TC"))
			list = bills.stream().collect(Collectors.toList());
		else if(state.equals("DI"))
			list = bills.stream().filter(p->p.isPrint() == true).collect(Collectors.toList());
		else if(state.equals("CI"))
			list = bills.stream().filter(p->p.isPrint() == false).collect(Collectors.toList());
		
		try {	

			if(!searchContent.equals("0")) {
				if(typeID.equals("MHD"))
					list =  list.stream().filter(p->p.getiD() == Integer.parseInt(searchContent.toLowerCase())).collect(Collectors.toList());
				else if(typeID.equals("MDH"))
					list =  list.stream().filter(p->p.getOrderID() == Integer.parseInt(searchContent.toLowerCase())).collect(Collectors.toList());
				else if(typeID.equals("MKH"))
					list =  list.stream().filter(p->p.getCusID() == Integer.parseInt(searchContent.toLowerCase())).collect(Collectors.toList());
				else if(typeID.equals("MNV"))
					list =  list.stream().filter(p->p.getStaffID().contains(searchContent.toLowerCase())).collect(Collectors.toList());
			}
		}
		catch(Exception e){
			list = null;
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
		
		return "ajax/showBillsList";
	}
	
	
	@RequestMapping(value = "/getBillDetail/{billID}", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String getBillDetail(@PathVariable int billID, ModelMap md) {
		
		Bill bill = BillDAO.getInstance().GetBillByID(billID);
		List<BillDetail> billDetail = BillDAO.getInstance().GetListBillDetailByBillID(billID);
		
		double total = billDetail.stream().filter(p->Double.parseDouble(p.getTotalPrice()) > 1).mapToDouble(p->Double.parseDouble(p.getTotalPrice())).sum();
		int ck = 0;
		int pr = 0;
		if(bill.getDiscount() != null)
			pr = bill.getDiscount().getPercent();
			
		double tprice = total*(100 - pr)/100;
		tprice = tprice * 1.1;
		if(Double.parseDouble(bill.getTotalPrice()) != tprice) {
			for(int i = 0 ; i <= 10; i++) {
				double tprice1 = total*(100 - pr - i)/100;
				tprice1 = tprice1 * 1.1;
				if(tprice1 == Double.parseDouble(bill.getTotalPrice())) {
					ck = i;
					break;
				}
			}
		}
		md.addAttribute("ck", ck);
		
		
		String totalPrice = total + "";
		
		md.addAttribute("billDetail", billDetail);
		md.addAttribute("bill", bill);
		md.addAttribute("totalPrice", totalPrice);
		
		return "ajax/staffBillDetail";
	}
	
	@RequestMapping(value="/updateBillState/{billID}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String UpdateBillState(@PathVariable int billID) {
		
		
		StaffServices.getInstance().UpdateBillState(billID);
		
		return "";
	}
	
	
}
