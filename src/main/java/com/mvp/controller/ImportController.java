package com.mvp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mvp.DAO.ImportDAO;
import com.mvp.DAO.ProductDAO;
import com.mvp.DAO.StaffDAO;
import com.mvp.model.Account;
import com.mvp.model.Color;
import com.mvp.model.Import;
import com.mvp.model.ImportDetail;
import com.mvp.model.ShoeSize;
import com.mvp.services.ImportServices;
import com.mvp.services.SupportServices;

@Controller
public class ImportController {
	
	@RequestMapping(value="/importShoe", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String  getSearchUserProfiles(HttpServletRequest request, HttpSession session) {
		
		String notify = "Thành công";
		String jsonInString =  request.getParameter("Import");


		Gson gson = new Gson();
		ImportDetail lst[] = gson.fromJson(jsonInString,ImportDetail[].class);

		List<ImportDetail> listImport = new ArrayList<ImportDetail>();


		for(int i = 0; i < lst.length; i++) {
			listImport.add(lst[i]);
		}

		Account loginacc = (Account)session.getAttribute("user");

		String staffID = loginacc.getMaNguoiDung();

		String staffName = (StaffDAO.getInstance().GetStaffByID(staffID)).getTenNV();
		String username = loginacc.getMaNguoiDung();
		String log = staffName + " ("+username+") " + " đã nhập hàng thành công";
		
		String err = ""; 

		if(ImportServices.getInstance().AddImport(staffID, listImport, err)) {
			notify = "Nhập hàng thành công";
			
			if(SupportServices.getInstance().AddNewLog(log))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
		}
		else
			notify= "Lỗi nhập hàng vui lòng kiểm tra lại thông tin nhập!";


		return notify;
	}
	
	@RequestMapping(value="/getImportList/{ID}/{fDate}/{eDate}", method = RequestMethod.GET)
	public String getImportList(@PathVariable String ID, @PathVariable String fDate, @PathVariable String eDate,ModelMap md) {
		
		List<Import> list;
		
		if(Integer.parseInt(ID) == 1) {
			list = ImportDAO.getInstance().GetImportListByTime();		
		}
		else if(Integer.parseInt(ID) == 2) {
			list = ImportDAO.getInstance().GetImportListByQuantity();			
		}
		else if(Integer.parseInt(ID) == 3) {
			list = ImportDAO.getInstance().GetImportListByTotal();		
		}
		else
			list = null;
		
		fDate += " 00:00:01";
		eDate += " 23:59:59";			
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {	
			Date start = sdf.parse(fDate);
			Date end = sdf.parse(eDate);	

			list = list.stream().filter(p->p.getImportDate().getTime() >= start.getTime() &&
					p.getImportDate().getTime() <= end.getTime()).collect(Collectors.toList());				
		}
		catch(Exception eee)
		{
			md.addAttribute("list", null);
		}
		
		md.addAttribute("list", list);
		
		return "ajax/importList";
	}
	
	@RequestMapping(value="/viewListImportDetail/{ID}", method = RequestMethod.GET)
	public String viewListImportDetail(@PathVariable String ID, ModelMap md) {
		List<Color> lst = ProductDAO.getInstance().GetColorList();
		List<ShoeSize> list = ProductDAO.getInstance().GetSizeList();
		List<ImportDetail> lstID = ProductDAO.getInstance().GetImportDetailByID(Integer.parseInt(ID));		
		Import imProduct = ImportDAO.getInstance().GetImportByID(Integer.parseInt(ID));
		
		md.addAttribute("listColor", lst);
		md.addAttribute("listSize", list);
		md.addAttribute("list", lstID);
		md.addAttribute("im", imProduct);
		
		return "ajax/importDetailList";
	}
	
	
}
