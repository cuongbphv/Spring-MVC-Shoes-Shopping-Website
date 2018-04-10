package com.mvp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvp.DAO.MaterialDAO;
import com.mvp.DAO.ProducerDAO;
import com.mvp.DAO.StaffDAO;
import com.mvp.model.Account;
import com.mvp.model.Producer;
import com.mvp.services.ProducerServices;
import com.mvp.services.SupportServices;


@Controller
public class ProducerController {

	@RequestMapping(value="/getListProducer", method = RequestMethod.GET)
	public String getListProducer(ModelMap md) {
				
		List<Producer> list = ProducerDAO.getInstance().GetProducerList();
		md.addAttribute("list", list);
		return "ajax/producerList";
	}
	
	@RequestMapping(value="/deleteProducer/{ID}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String deleteProducer(@PathVariable String ID ,ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldProducer = (ProducerDAO.getInstance().GetMaterialByID(Integer.parseInt(ID))).getName();
		String log = staffName + " ("+username+") " + "đã xóa nhà sản xuất "+oldProducer;
		
		if(ProducerServices.getInstance().DeleteProducer(Integer.parseInt(ID))) {
			if(SupportServices.getInstance().AddNewLog(log))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			return "Xóa nhà sản xuất thành công";
		}
		else
			return "Đã xảy ra lỗi khi xóa nhà sản xuất";
	}
	
	@RequestMapping(value="/editProducer/{ID}/{newName}/{newAddress}/{newPhoneNumber}",method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String editProducer(@PathVariable String ID , 
			@PathVariable String newName, 
			@PathVariable String newAddress, 
			@PathVariable String newPhoneNumber, 
			ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldProducer = (ProducerDAO.getInstance().GetMaterialByID(Integer.parseInt(ID))).getName();
		String log = staffName + " ("+username+") " + "đã chỉnh sửa nhà sản xuất "+oldProducer;
		
		if(ProducerServices.getInstance().EditProducer(Integer.parseInt(ID), newName, newAddress, newPhoneNumber)) {
			if(SupportServices.getInstance().AddNewLog(log+" thành nhà sản xuất "+newName))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			return "Chỉnh sửa nhà sản xuất thành công";
		}
		else
			return "Đã xảy ra lỗi khi chỉnh sửa nhà sản xuất";
	}
	
	@RequestMapping(value="/addProducer/{newName}/{newAddress}/{newPhoneNumber}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String addProducer(@PathVariable String newName,@PathVariable String newAddress, @PathVariable String newPhoneNumber,
			HttpSession session){ 
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String log = staffName + " ("+username+") " + "đã thêm nhà sản xuất "+newName;
		String notify = "";
		try {
			if(ProducerServices.getInstance().AddProducer(newName, newAddress, newPhoneNumber)) {
				if(SupportServices.getInstance().AddNewLog(log))
					System.out.println("Thêm nhật ký hệ thống thành công");
				else
					System.out.println("Có lỗi khi thêm nhật ký hệ thống");
				notify = "Đã thêm nhà sản xuất thành công";
			}
			else {
				notify= "Đã xảy ra lỗi khi thêm nhà sản xuất, vui lòng kiểm tra lại thông tin nhập";
			}
			
		}
		catch(Exception e) {
			notify= "Đã xảy ra lỗi khi thêm nhà sản xuất";
		}
		
		return notify;
	}
	
}
