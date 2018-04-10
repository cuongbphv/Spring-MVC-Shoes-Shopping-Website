package com.mvp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvp.DAO.ProductTypeDAO;
import com.mvp.DAO.SizeDAO;
import com.mvp.DAO.StaffDAO;
import com.mvp.model.Account;
import com.mvp.model.SizeProduct;
import com.mvp.services.SizeServices;
import com.mvp.services.SupportServices;

@Controller
public class SizeController {

	@RequestMapping(value="/getListSize", method = RequestMethod.GET)
	public String getListSize(ModelMap md) {
		List<SizeProduct> list = SizeDAO.getInstance().GetSizeList();
		md.addAttribute("list", list);
		return "ajax/sizeList";
	}
	
	@RequestMapping(value="/deleteSize/{ID}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String deleteSize(@PathVariable String ID ,ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldSize = (SizeDAO.getInstance().GetSizeByID(Integer.parseInt(ID))).getName()+"";
		String log = staffName + " ("+username+") " + "đã xóa size giày "+oldSize;
		
		if(SizeServices.getInstance().DeleteSize(Integer.parseInt(ID))) {
			if(SupportServices.getInstance().AddNewLog(log))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			return "Xóa kích cỡ thành công";
		}
		else
			return "Đã xảy ra lỗi khi xóa kích cỡ";
	}
	
	@RequestMapping(value="/editSize/{ID}/{newName}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String editSize(@PathVariable String ID , @PathVariable String newName, ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldSize = (SizeDAO.getInstance().GetSizeByID(Integer.parseInt(ID))).getName()+"";
		String log = staffName + " ("+username+") " + "đã chỉnh sửa size giày "+oldSize;
		
		if(SizeServices.getInstance().EditSize(Integer.parseInt(ID), Integer.parseInt(newName))) {
			if(SupportServices.getInstance().AddNewLog(log+" thành "+newName))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			return "Chỉnh sửa kích cỡ thành công";
		}
		else
			return "Đã xảy ra lỗi khi chỉnh sửa kích cỡ";
	}
	
	@RequestMapping(value="/addSize/{newName}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String addSize(@PathVariable String newName, HttpSession session){ 
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String log = staffName + " ("+username+") " + "đã thêm size giày "+newName;
		
		
		String notify = "";
		try {
			if(SizeServices.getInstance().AddSize(Integer.parseInt(newName))) {
				notify = "Đã thêm kích cỡ thành công";
				if(SupportServices.getInstance().AddNewLog(log))
					System.out.println("Thêm nhật ký hệ thống thành công");
				else
					System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			}
			else {
				notify= "Đã xảy ra lỗi khi thêm kích cỡ, vui lòng kiểm tra lại thông tin nhập";
			}
			
		}
		catch(Exception e) {
			notify= "Đã xảy ra lỗi khi thêm kích cỡ";
		}
		
		return notify;
	}
	
}
