package com.mvp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import java.io.IOException;

import com.mvp.DAO.DeliveryDAO;
import com.mvp.DAO.ProductDAO;
import com.mvp.DAO.ProductTypeDAO;
import com.mvp.DAO.PromotionDAO;
import com.mvp.DAO.StaffDAO;
import com.mvp.model.Account;
import com.mvp.model.ProductType;
import com.mvp.model.Promotion;
import com.mvp.services.ProductServices;
import com.mvp.services.PromotionServices;
import com.mvp.services.SupportServices;

@Controller
public class PromotionController {
	
	
	@RequestMapping(value="/addPromotionAD",  method = RequestMethod.POST,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String AddPromotionAD(@RequestParam("ID") String ID,@RequestParam("name") String Name, @RequestParam("percent") int Percent,
			@RequestParam("startTime") String StartTime, @RequestParam("endTime") String EndTime, HttpSession session){
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		//String oldPT = (ProductTypeDAO.getInstance().GetProductTypeByID(Integer.parseInt(ID))).getName();
		String log = staffName + " ("+username+") " + "đã thêm khuyến mãi ";
		
		
		String notify = "";
		if(  !StartTime.equals("") &&  !EndTime.equals(""))
		try {
			StartTime += " 00:00:01";
			EndTime += " 23:59:59";
			if(PromotionServices.getInstance().AddPromotion(ID, Percent, StartTime, EndTime, Name)) {
				notify = "Thêm khuyến mãi thành công!";
				if(SupportServices.getInstance().AddNewLog(log+Name+"bắt đầu từ "+StartTime+" đến "+EndTime))
					System.out.println("Thêm nhật ký hệ thống thành công");
				else
					System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			}
			else {
				notify= "Xảy ra lỗi trong quá trình thêm khuyến mãi vui lòng kiểm tra lại thông tin nhập";
			}
			
		}
		catch(Exception e) {
			notify= "Xảy ra lỗi khi thêm khuyến mãi";
		}
		else {
			notify= "Xảy ra lỗi khi thêm khuyến mãi";
		}
		
		return notify;
	}
	
	
	@RequestMapping(value="/editPromotionAD",  method = RequestMethod.POST,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String EditPromotionAD(@RequestParam("ID") String ID,@RequestParam("name") String Name, @RequestParam("percent") int Percent,
			@RequestParam("startTime") String StartTime, @RequestParam("endTime") String EndTime, HttpSession session){
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		//String oldPT = (ProductTypeDAO.getInstance().GetProductTypeByID(Integer.parseInt(ID))).getName();
		String log = staffName + " ("+username+") " + "đã chỉnh sửa khuyến mãi ";
		
		String notify = "";
		try {
			EndTime += " 23:59:59";
			if(PromotionServices.getInstance().EditPromotion(ID, Percent, StartTime, EndTime, Name)) {
				notify = "Chỉnh sửa khuyến mãi thành công";
				if(SupportServices.getInstance().AddNewLog(log+Name+" bắt đầu từ "+StartTime+" đến "+EndTime))
					System.out.println("Thêm nhật ký hệ thống thành công");
				else
					System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			}
			else {
				notify= "Xảy ra lỗi trong quá trình chỉnh sửa khuyến mãi vui lòng kiểm tra lại thông tin nhập";
			}
			
		}
		catch(Exception e) {
			notify= "Xảy ra lỗi khi chỉnh sửa khuyến mãi";
		}
		
		return notify;
	}
	
	
	@RequestMapping(value="/getPromotion/{State}/{fDate}/{eDate}", method = RequestMethod.GET )
	public String getProductType(@PathVariable String State, @PathVariable String fDate, @PathVariable String eDate, ModelMap md) {
			
		List<Promotion> list;	
		
		try {				
			
			if(State.equals("KMTC"))
				list = PromotionDAO.getInstance().GetPromotionList();
			else if(State.equals("KMCH"))
				list = PromotionDAO.getInstance().GetPromotionValidList();
			else if(State.equals("KMHH"))
				list = PromotionDAO.getInstance().GetPromotionInvalidList();
			else
				list = null;

			fDate += " 00:00:01";
			eDate += " 23:59:59";			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			try {	
				Date start = sdf.parse(fDate);
				Date end = sdf.parse(eDate);	

				list = list.stream().filter(p->p.getStartTime().getTime() >= start.getTime() &&
						p.getEndTime().getTime() <= end.getTime()).collect(Collectors.toList());				
			}
			catch(Exception eee)
			{
				md.addAttribute("list", null);
			}			

			md.addAttribute("list", list);
		}
		catch(Exception ee) {
			md.addAttribute("list", null);
		}
			
		return "ajax/promotionList";
	}
	
	@RequestMapping(value="/deletePromotion/{ID}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String deletePromotion(@PathVariable String ID ,ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldPM = (PromotionDAO.getInstance().GetPromotionByID(ID)).getName();
		String log = staffName + " ("+username+") " + "đã xóa khuyến mãi ";
		
		if(PromotionServices.getInstance().DeletePromotion(ID)) {
			if(SupportServices.getInstance().AddNewLog(log+oldPM))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			return "Xóa khuyến mãi thành công";
		}
		else
			return "Xảy rra lỗi trong quá trình xóa!";
	}
	
	
}
