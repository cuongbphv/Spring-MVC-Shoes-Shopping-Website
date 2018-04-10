package com.mvp.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvp.DAO.ColorDAO;
import com.mvp.DAO.MaterialDAO;
import com.mvp.DAO.StaffDAO;
import com.mvp.model.Account;
import com.mvp.model.Material;
import com.mvp.services.MaterialServices;
import com.mvp.services.SupportServices;

@Controller
public class MaterialController {
	@RequestMapping(value="/getListMaterial", method = RequestMethod.GET)
	public String home(ModelMap md) {
		List<Material> list = MaterialDAO.getInstance().GetMaterialList();
		md.addAttribute("list", list);
		return "ajax/materialList";
	}
	
	@RequestMapping(value="/deleteMaterial/{ID}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String deleteMaterial(@PathVariable String ID ,ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldMaterial = (MaterialDAO.getInstance().GetMaterialByID(Integer.parseInt(ID))).getName();
		String log = staffName + " ("+username+") " + "đã xóa chất liệu "+oldMaterial;
		
		if(MaterialServices.getInstance().DeleteMaterial(Integer.parseInt(ID))) {
			if(SupportServices.getInstance().AddNewLog(log))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			return "Xóa chất liệu thành công";
		}
		else
			return "Đã xảy ra lỗi khi xóa chất liệu";
	}
	
	
	@RequestMapping(value="/editMaterial/{ID}/{newName}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String editMaterial(@PathVariable String ID , @PathVariable String newName, ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldMaterial = (MaterialDAO.getInstance().GetMaterialByID(Integer.parseInt(ID))).getName();
		String log = staffName + " ("+username+") " + "đã chỉnh sửa chất liệu "+oldMaterial;
		
		if(MaterialServices.getInstance().EditMaterial(Integer.parseInt(ID), newName)) {
			if(SupportServices.getInstance().AddNewLog(log +" thành "+newName))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			return "Chỉnh sửa chất liệu thành công";
		}
		else
			return "Đã xảy ra lỗi khi chỉnh sửa chất liệu";
	}
	
	
	@RequestMapping(value="/addMaterial/{newName}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String addMaterial(@PathVariable String newName, HttpSession session){ 
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String log = staffName + " ("+username+") " + "đã thêm chất liệu "+newName;
		
		String notify = "";
		try {
			if(MaterialServices.getInstance().AddMaterial(newName)) {
				notify = "Đã thêm chất liệu thành công";
				if(SupportServices.getInstance().AddNewLog(log +" thành "+newName))
					System.out.println("Thêm nhật ký hệ thống thành công");
				else
					System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			}
			else {
				notify= "Đã xảy ra lỗi khi thêm chất liệu, vui lòng kiểm tra lại thông tin nhập";
			}
			
		}
		catch(Exception e) {
			notify= "Đã xảy ra lỗi khi thêm chất liệu";
		}
		
		return notify;
	}
}
