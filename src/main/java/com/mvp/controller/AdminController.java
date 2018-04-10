package com.mvp.controller;

import java.io.IOException;
import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mvp.DAO.AdminDAO;
import com.mvp.DAO.StaffDAO;
import com.mvp.model.Account;
import com.mvp.model.AdminFeature;
import com.mvp.model.Banner;
import com.mvp.model.Logs;
import com.mvp.services.SupportServices;


@Controller
public class AdminController {

	
	@RequestMapping(value = "/getsettings", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String showSettings(ModelMap md) {
		
		List<AdminFeature> feature = AdminDAO.getInstance().GetListFeature();
		List<Banner> banner = AdminDAO.getInstance().GetListBanner();
		
		md.addAttribute("features", feature);
		md.addAttribute("banners", banner);
		
		return "ajax/showsettings";
	}
	
	@RequestMapping(value = "/updatefeature/{ID}/{value}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String updateFeature(@PathVariable String ID, @PathVariable String value, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String name = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String log = name + " ("+username+") " + "đã cập nhật chức năng ";
		
		String notify = "";
		
		if(AdminDAO.getInstance().UpdateFeature(ID, value)) {
			notify = "Cập nhật thành công";
			String featureName = (AdminDAO.getInstance().GetFeatureByID(ID)).getName();
			String featureValue = (AdminDAO.getInstance().GetFeatureByID(ID)).getValue();
			if(SupportServices.getInstance().AddNewLog(log+" " + featureName + " thành " + featureValue))
				System.out.println("Thêm nhật ký thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
		}
		else {
			notify = "Đã xảy ra lỗi";
		}
		
		return notify;
	}
	
	@RequestMapping(value = "/updatebanner", method = RequestMethod.POST, produces = "text/html; charset=utf-8",headers=("content-type=multipart/*"))
	@ResponseBody
	public String updateBanner(@RequestParam("bannerID") String ID, @RequestParam("fileSelector") MultipartFile Image,
			HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String name = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String log = name + " ("+username+") " + "đã cập nhật ";
		
		String notify = "Đã xảy ra lỗi";
		
		if(!Image.isEmpty()) {
			byte[] contents;
			try {
				contents = Image.getBytes();
				if(AdminDAO.getInstance().UpdateBanner(ID, contents)) {
					notify = "Cập nhật thành công";
					
					String bannerName = (AdminDAO.getInstance().GetBannerByID(ID)).getName();
					if(SupportServices.getInstance().AddNewLog(log+" " + bannerName))
						System.out.println("Thêm nhật ký thành công");
					else
						System.out.println("Có lỗi khi thêm nhật ký hệ thống");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		
		return notify;
	}
	
	@RequestMapping(value = "/getlogs/{startDate}/{endDate}/{content}", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String getOrderByCusID(@PathVariable String startDate, @PathVariable String endDate,@PathVariable String content,ModelMap md) {
		
		
		List<Logs> list = AdminDAO.getInstance().GetListLogs();
		
		startDate += " 00:00:01";
		endDate += " 23:59:59";
			
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {	
	        Date start = simpleDateFormat.parse(startDate);
	        Date end = simpleDateFormat.parse(endDate);	
	        
	        list = list.stream().filter(p->p.getTime().getTime() >= start.getTime() &&
	        		p.getTime().getTime() <= end.getTime()).collect(Collectors.toList());
	        
	        if(!content.equals("-1"))
	        	list = list.stream().filter(p->p.getContent().trim().toLowerCase().contains(content.trim().toLowerCase())).collect(Collectors.toList());
		}
        catch (ParseException ex)
        {
            System.out.println("Exception "+ex);
        }
		catch(Exception e){
			list = null;
		}
		
		md.addAttribute("list", list);
		
		return "ajax/showlogs";
	}
}
