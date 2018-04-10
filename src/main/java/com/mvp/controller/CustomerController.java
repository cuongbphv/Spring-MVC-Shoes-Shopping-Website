package com.mvp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvp.DAO.CustomerDAO;
import com.mvp.DAO.CustomerTypeDAO;
import com.mvp.DAO.StaffDAO;
import com.mvp.model.Account;
import com.mvp.model.CustomerType;
import com.mvp.services.CustomerTypeServices;
import com.mvp.services.MaterialServices;
import com.mvp.services.SupportServices;

@Controller
public class CustomerController {
	
	@RequestMapping(value="/getListCustomerType", method = RequestMethod.GET)
	public String getListCustomerType(ModelMap md) {
		List<CustomerType> list = CustomerTypeDAO.getInstance().GetListCustomerType();
		md.addAttribute("list", list);
		return "ajax/customerTypeList";
	}
	
	@RequestMapping(value="/addCustomerType/{name}/{discount}/{levelMoney}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String addCustomerType(@PathVariable String name, @PathVariable String discount, @PathVariable String levelMoney,
					HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String log = staffName + " ("+username+") " + " đã thêm loại khách hàng "+name;
		
		String notify = "";
		if(CustomerTypeServices.getInstance().AddCustomerType(name, Integer.parseInt(discount),levelMoney))
		{
			notify = "Thêm loại khách hàng mới thành công";
			
			if(SupportServices.getInstance().AddNewLog(log))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
		}
		else {
			notify= "Thêm loại khách hàng không thành công kiểm tra lại thông tin nhập";
		}
		return notify;
	}
	
	@RequestMapping(value="editCustomerType/{id}/{name}/{discount}/{levelMoney}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String editCustomerType(@PathVariable String id, @PathVariable String name, @PathVariable String discount,
			@PathVariable String levelMoney, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String log = staffName + " ("+username+") " + " đã chỉnh sửa loại khách hàng "+name;
		
		String notify = "";
		if(CustomerTypeServices.getInstance().EditCustomerType(Integer.parseInt(id),name, Integer.parseInt(discount),levelMoney))
		{
			notify = "Chỉnh sửa loại khách hàng thành công";
			
			if(SupportServices.getInstance().AddNewLog(log))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
		}
		else {
			notify= "Chỉnh sửa loại khách hàng không thành công kiểm tra lại thông tin nhập";
		}
		return notify;
	}
	
	
	@RequestMapping(value="/deleteCustomerType/{ID}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String deleteCustomerType(@PathVariable String ID ,ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String ctName = (CustomerDAO.getInstance().GetCustomerTypeByID(Integer.parseInt(ID))).getName();
		String log = staffName + " ("+username+") " + " đã xóa loại khách hàng "+ctName;
		
		if(CustomerTypeServices.getInstance().DeleteCustomerType((Integer.parseInt(ID)))) {
			if(SupportServices.getInstance().AddNewLog(log))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			return "Xóa loại khách hàng thành công";
			}		
		else
			return "Đã xảy ra lỗi khi xóa loại khách hàng";
	}
	
}
