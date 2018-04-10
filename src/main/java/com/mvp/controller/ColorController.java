package com.mvp.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mvp.DAO.ColorDAO;
import com.mvp.DAO.StaffDAO;
import com.mvp.model.Account;
import com.mvp.model.Color;
import com.mvp.services.ColorServices;
import com.mvp.services.MaterialServices;
import com.mvp.services.SupportServices;

@Controller
public class ColorController {

	@RequestMapping(value="/getListColor/{page}/{typeID}/{searchContent}", method = RequestMethod.GET)
	public String getListColor(@PathVariable int page, @PathVariable String typeID, @PathVariable String searchContent,
			ModelMap md) {
		List<Color> list = ColorDAO.getInstance().GetColorList();
			
		try {	

			if(!searchContent.equals("0")) {
				if(typeID.equals("MMS"))
					list =  list.stream().filter(p->p.getiD() == Integer.parseInt(searchContent.trim())).collect(Collectors.toList());
				else if(typeID.equals("TMS"))
					list =  list.stream().filter(p->p.getName().toLowerCase().contains(searchContent.toLowerCase())).collect(Collectors.toList());				
			}
		}
		catch(Exception e){
			list = null;
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
		
		return "ajax/colorList";
	}
	
	@RequestMapping(value="/getEditColorByID/{id}", method = RequestMethod.GET)
	public String getEditColorByID(@PathVariable String id, ModelMap md) {
		Color cl = ColorDAO.getInstance().GetColorByID(Integer.parseInt(id));
		md.addAttribute("cl", cl);
		return "ajax/loadImageByColor";
	}
	
	@RequestMapping(value="/deleteColor/{ID}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String deleteColor(@PathVariable String ID ,ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldColor = (ColorDAO.getInstance().GetColorByID(Integer.parseInt(ID))).getName();
		String log = staffName + " ("+username+") " + "đã xóa màu "+oldColor;
		
		if(ColorServices.getInstance().DeleteColor(Integer.parseInt(ID))) {
			if(SupportServices.getInstance().AddNewLog(log))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			return "Xóa màu sắc thành công";
		}
		else
			return "Đã xảy ra lỗi khi xóa màu sắc";
	}
	
	@RequestMapping(value="/editColor",method = RequestMethod.POST,produces = "text/html; charset=utf-8", 
			headers=("content-type=multipart/*"))
	@ResponseBody
	public String editColor(@RequestParam("editColorID") String id , @RequestParam("editColorName") String name ,
			@RequestParam("editColorImage") MultipartFile Image, ModelMap md, HttpSession session) throws IOException {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldColor = (ColorDAO.getInstance().GetColorByID(Integer.parseInt(id))).getName();
		String log = staffName + " ("+username+") " + "đã chỉnh sửa màu "+oldColor;
		
		String notify = "";
		try {
			if(!Image.isEmpty()) {
				byte[] contents = Image.getBytes();
				if(ColorServices.getInstance().EditColorHasImage(Integer.parseInt(id), name, contents)) {
					notify = "Đã chỉnh sửa màu sắc thành công";
					
					if(SupportServices.getInstance().AddNewLog(log+ " thành màu " + name +" có chỉnh sửa hình ảnh"))
						System.out.println("Thêm nhật ký hệ thống thành công");
					else
						System.out.println("Có lỗi khi thêm nhật ký hệ thống");
				}
				else {
					notify= "Đã xảy ra lỗi khi chỉnh sửa màu sắc, vui lòng kiểm tra lại thông tin nhập";
				}
			}
			else {
				if(ColorServices.getInstance().EditColor(Integer.parseInt(id), name)) {
					notify = "Đã chỉnh sửa màu sắc thành công";
					
					if(SupportServices.getInstance().AddNewLog(log+ " thành màu " + name +" không chỉnh sửa hình ảnh"))
						System.out.println("Thêm nhật ký hệ thống thành công");
					else
						System.out.println("Có lỗi khi thêm nhật ký hệ thống");
				}
				else {
					notify= "Đã xảy ra lỗi khi chỉnh sửa màu sắc, vui lòng kiểm tra lại thông tin nhập";
				}
			}
			
		}
		catch(Exception e) {
			notify= "Đã xảy ra lỗi khi thêm màu sắc";
		}
		
		return notify;
	}
	
	@RequestMapping(value="/addColor",method = RequestMethod.POST,produces = "text/html; charset=utf-8", 
			headers=("content-type=multipart/*"))
	@ResponseBody
	public String addColor(@RequestParam("newNameColor") String newName , @RequestParam("imageByColor") MultipartFile Image,
			HttpSession session) throws IOException{ 
		
		Account acc = (Account)session.getAttribute("user");
		String name = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String log = name + " ("+username+") " + " đã thêm mới màu";
		
		String notify = "";
		try {
			if(!Image.isEmpty()) {
				byte[] contents = Image.getBytes();
				if(ColorServices.getInstance().AddColor(newName,contents)) {
					notify = "Đã thêm màu sắc thành công";
					
					if(SupportServices.getInstance().AddNewLog(log+ " " + newName))
						System.out.println("Thêm nhật ký hệ thống thành công");
					else
						System.out.println("Có lỗi khi thêm nhật ký hệ thống");
				}
				else {
					notify= "Đã xảy ra lỗi khi thêm màu sắc, vui lòng kiểm tra lại thông tin nhập";
				}
			}
			else {
				notify = "Chưa thêm hình ảnh theo màu sắc, vui lòng kiểm tra lại!";
			}
			
		}
		catch(Exception e) {
			notify= "Đã xảy ra lỗi khi thêm màu sắc";
		}
		
		return notify;
	}
	
}
