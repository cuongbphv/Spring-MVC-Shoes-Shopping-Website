package com.mvp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvp.DAO.SizeDAO;
import com.mvp.DAO.StaffDAO;
import com.mvp.DAO.StaffTypeDAO;
import com.mvp.model.Account;
import com.mvp.model.StaffType;
import com.mvp.services.MaterialServices;
import com.mvp.services.StaffTypeServices;
import com.mvp.services.SupportServices;

@Controller
public class StaffTypeController {

	@RequestMapping(value="/getStaffTypeList", method = RequestMethod.GET )
	public String getStaffTypeList(ModelMap md) {
		
		List<StaffType> list = StaffTypeDAO.getInstance().GetStaffTypeList();
		md.addAttribute("list", list);
		
		return "ajax/selectBoxStaffType";
	}
	
	@RequestMapping(value="/getStaffTypeListEdit", method = RequestMethod.GET )
	public String getStaffTypeListEdit(ModelMap md) {
		
		List<StaffType> list = StaffTypeDAO.getInstance().GetStaffTypeList();
		md.addAttribute("list", list);
		
		return "ajax/selectBoxStaffTypeEdit";
	}
	
	@RequestMapping(value="/getStaffTypeListModal", method = RequestMethod.GET )
	public String getStaffTypeListModal(ModelMap md) {
		
		List<StaffType> list = StaffTypeDAO.getInstance().GetStaffTypeList();
		md.addAttribute("list", list);
		
		return "ajax/staffTypeList";
	}
	
	@RequestMapping(value="/deleteStaffType/{ID}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String deleteStaffType(@PathVariable String ID ,ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldST = (StaffTypeDAO.getInstance().GetStaffTypeByID(Integer.parseInt(ID))).getTenLoaiNV();
		String log = staffName + " ("+username+") " + "đã xóa loại nhân viên "+oldST;
		
		if(StaffTypeServices.getInstance().DeleteStaffType(Integer.parseInt(ID))) {
			if(SupportServices.getInstance().AddNewLog(log))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			return "Xóa loại nhân viên thành công";
		}
		else
			return "Đã xảy ra lỗi khi xóa loại nhân viên";
	}
	
	@RequestMapping(value="/editStaffType/{ID}/{name}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String editStaffType(@PathVariable String ID, @PathVariable String name ,ModelMap md) {
		
		md.addAttribute("id", ID);
		md.addAttribute("name", name);
		
		return "ajax/editStaffType";
	}
	
	@RequestMapping(value="/addStaffType/{newName}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String addStaffType(@PathVariable String newName, HttpSession session){ 
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String log = staffName + " ("+username+") " + "đã chỉnh sửa loại nhân viên "+newName;
		
		
		String notify = "";
		try {
			if(StaffTypeServices.getInstance().AddStaffType(newName)) {
				notify = "Đã thêm loại nhân viên thành công";
				if(SupportServices.getInstance().AddNewLog(log))
					System.out.println("Thêm nhật ký hệ thống thành công");
				else
					System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			}
			else {
				notify= "Đã xảy ra lỗi khi thêm loại nhân viên, vui lòng kiểm tra lại thông tin nhập";
			}
			
		}
		catch(Exception e) {
			notify= "Đã xảy ra lỗi khi thêm loại nhân viên";
		}
		
		return notify;
	}
	
	@RequestMapping(value="/submitEditStaffType/{ID}/{name}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String submitEditStaffType(@PathVariable String ID, @PathVariable String name, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldST = (StaffTypeDAO.getInstance().GetStaffTypeByID(Integer.parseInt(ID))).getTenLoaiNV();
		String log = staffName + " ("+username+") " + "đã chỉnh sửa loại nhân viên "+oldST;
		
		String notify = "";
		if(StaffTypeServices.getInstance().EditStaffType(Integer.parseInt(ID), name)) {
			notify = "Chỉnh sửa loại nhân viên thành công";
			if(SupportServices.getInstance().AddNewLog(log+" thành "+name))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
		}else {
			notify = "Chỉnh sửa loại nhân viên không thành công";
		}
		
		return notify;
	}
	
}
