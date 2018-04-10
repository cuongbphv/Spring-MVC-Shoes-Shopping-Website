package com.mvp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvp.DAO.ProducerDAO;
import com.mvp.DAO.ProductTypeDAO;
import com.mvp.DAO.StaffDAO;
import com.mvp.model.Account;
import com.mvp.model.ProductType;
import com.mvp.services.MaterialServices;
import com.mvp.services.ProductTypeServices;
import com.mvp.services.SupportServices;

@Controller
public class ProductTypeController {
	@RequestMapping(value="/getListProductType", method = RequestMethod.GET)
	public String home(ModelMap md) {
		List<ProductType> list = ProductTypeDAO.getInstance().GetProductTypeList();
		md.addAttribute("list", list);
		return "ajax/productTypeList";
	}
	
	@RequestMapping(value="/deleteProductType/{ID}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String deleteProductType(@PathVariable String ID ,ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldPT = (ProductTypeDAO.getInstance().GetProductTypeByID(Integer.parseInt(ID))).getName();
		String log = staffName + " ("+username+") " + "đã xóa loại giày "+oldPT;
		
		if(ProductTypeServices.getInstance().DeleteProductType(Integer.parseInt(ID))) {
			if(SupportServices.getInstance().AddNewLog(log))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			return "Xóa loại sản phẩm thành công";
		}
		else
			return "Đã xảy ra lỗi khi xóa loại sản phẩm";
	}
	
	@RequestMapping(value="/editProductType/{ID}/{newName}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String editProductType(@PathVariable String ID , @PathVariable String newName, ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldPT = (ProductTypeDAO.getInstance().GetProductTypeByID(Integer.parseInt(ID))).getName();
		String log = staffName + " ("+username+") " + "đã chỉnh sửa loại "+oldPT;
		
		if(ProductTypeServices.getInstance().EditProductType(Integer.parseInt(ID), newName)) {
			if(SupportServices.getInstance().AddNewLog(log+" thành loại "+newName))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			return "Chỉnh sửa loại sản phẩm thành công";
		}
		else
			return "Đã xảy ra lỗi khi chỉnh sửa loại sản phẩm";
	}
	
	@RequestMapping(value="/addProductType/{newName}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String addProductType(@PathVariable String newName, HttpSession session){ 
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String log = staffName + " ("+username+") " + "đã thêm loại giày "+newName;
		
		String notify = "";
		try {
			if(ProductTypeServices.getInstance().AddProductType(newName)) {
				notify = "Đã thêm loại sản phẩm thành công";
				
				if(SupportServices.getInstance().AddNewLog(log))
					System.out.println("Thêm nhật ký hệ thống thành công");
				else
					System.out.println("Có lỗi khi thêm nhật ký hệ thống");
				
			}
			else {
				notify= "Đã xảy ra lỗi khi thêm loại sản phẩm, vui lòng kiểm tra lại thông tin nhập";
			}
			
		}
		catch(Exception e) {
			notify= "Đã xảy ra lỗi khi thêm loại sản phẩm";
		}
		
		return notify;
	}
	
}
