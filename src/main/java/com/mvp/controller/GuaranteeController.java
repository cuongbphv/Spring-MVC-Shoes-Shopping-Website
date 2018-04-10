package com.mvp.controller;


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

import com.mvp.DAO.GuaranteeDAO;
import com.mvp.DAO.SupportDAO;
import com.mvp.model.Account;
import com.mvp.model.Guarantee;
import com.mvp.model.ShoppingCart;
import com.mvp.model.Support;
import com.mvp.services.SupportServices;

@Controller
public class GuaranteeController {
	@RequestMapping(value="/guarantee", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String getListColor(HttpSession session, ModelMap md) {

		ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");

		md.addAttribute("list", cart.getItemsOrdered());
		md.addAttribute("totalPrice", cart.getTotalPrice());

		Account acc = (Account)session.getAttribute("user");

		if(acc == null) {
			List<Guarantee> lst = null;		
			md.addAttribute("listGuarantee", lst);

			List<Support> lstSupport = null;		
			md.addAttribute("listSupport", lstSupport);


			md.addAttribute("listGuarantee", lst);
			session.setAttribute("url", "login" );
			session.setAttribute("headerText","Đăng nhập/Đăng ký" );			
		}
		else {
			if(acc.getPhanQuyen() == 4) {
				session.setAttribute("url", "profile" );
				session.setAttribute("headerText","Tài khoản: " + acc.getCus().getName());
				List<Guarantee> lst = GuaranteeDAO.getInstance().GetGuaranteeListByID(Integer.parseInt(acc.getMaNguoiDung()));			
				md.addAttribute("listGuarantee", lst);

				List<Support> lstSupport = GuaranteeDAO.getInstance().GetSupportingRequireListByID(Integer.parseInt(acc.getMaNguoiDung()));			
				md.addAttribute("listSupport", lstSupport);
			}else {
				return "redirect:home";
			}
		}

		return "guarantee";
	}

	@RequestMapping(value="/getListSupportStaff/{State}/{fDate}/{eDate}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String getListSupportStaff(@PathVariable String State, @PathVariable String fDate, @PathVariable String eDate, 
			ModelMap md) {

		try {
			List<Support> lst = GuaranteeDAO.getInstance().GetSupportingRequireList();
			List<Support> list;

			if(State.equals("TC"))
				list = lst.stream().collect(Collectors.toList());
			else if(State.equals("DTL"))
				list = lst.stream().filter(p->p.isSeen() == true).collect(Collectors.toList());
			else if(State.equals("CTL"))
				list = lst.stream().filter(p->p.isSeen() == false).collect(Collectors.toList());
			else
				list = null;

			fDate += " 00:00:01";
			eDate += " 23:59:59";			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			try {	
				Date start = sdf.parse(fDate);
				Date end = sdf.parse(eDate);	

				list = list.stream().filter(p->p.getSendDate().getTime() >= start.getTime() &&
						p.getSendDate().getTime() <= end.getTime()).collect(Collectors.toList());				
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


		return "ajax/showListSupport";
	}

	@RequestMapping(value="/getListGuaranteeStaff/{state}/{typeID}/{searchContent}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String getListGuaranteeStaff(@PathVariable String state, @PathVariable String typeID, 
			@PathVariable String searchContent, ModelMap md) {

		List<Guarantee> lst = GuaranteeDAO.getInstance().GetGuaranteeList();
		List<Guarantee> list;

		if(state.equals("TC"))
			list = lst.stream().collect(Collectors.toList());
		else if(state.equals("DTL"))
			list = lst.stream().filter(p->p.isSeen() == true).collect(Collectors.toList());
		else if(state.equals("CTL"))
			list = lst.stream().filter(p->p.isSeen() == false).collect(Collectors.toList());
		else
			list = null;

		try {	

			if(!searchContent.equals("0")) {
				if(typeID.equals("DH"))
					list =  list.stream().filter(p->p.getOrderID() == Integer.parseInt(searchContent.toLowerCase())).collect(Collectors.toList());
				else if(typeID.equals("KH"))
					list =  list.stream().filter(p->p.getCusID() == Integer.parseInt(searchContent.toLowerCase())).collect(Collectors.toList());
				else if(typeID.equals("PRO"))
					list =  list.stream().filter(p->p.getProductID().toLowerCase().equals(searchContent.toLowerCase())).collect(Collectors.toList());	
				else
					list = null;
			}
		}
		catch(Exception e){
			list = null;
		}

		md.addAttribute("list", list);
		return "ajax/showGuaranteeList";
	}


	@RequestMapping(value="/getSupportRequireByID/{ID}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String getSupportRequireByID(@PathVariable String ID, ModelMap md) {

		try {
			Support sp = SupportDAO.getInstance().GetSupportByID(Integer.parseInt(ID));
			md.addAttribute("sp", sp);
		}
		catch(Exception ee) {
			md.addAttribute("sp", null);
		}

		return "ajax/replySupport";
	}

	@RequestMapping(value="/getGuaranteeStaffByID/{ID}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String getGuaranteeStaffByID(@PathVariable String ID, ModelMap md) {

		try {
			Guarantee guarantee = GuaranteeDAO.getInstance().GetGuaranteeByID(Integer.parseInt(ID));
			md.addAttribute("guarantee", guarantee);
		}
		catch(Exception ee) {
			md.addAttribute("guarantee", null);
		}

		return "ajax/receiveGuarantee";
	}

	@RequestMapping(value="/addNewGuarantee", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String addNewGuarantee(@RequestParam("productID") String productID ,@RequestParam("orderID") int orderID,
			@RequestParam("reasonGuarantee") String reason, HttpSession session) {
		String notify=" ";
		Account acc = (Account)session.getAttribute("user");
		if(acc == null)
		{
			return "Vui lòng đăng nhập để gửi yêu cầu bảo hành";
		}
		try {
			if(SupportServices.getInstance().AddNewGuarantee(productID, orderID, Integer.parseInt(acc.getMaNguoiDung()), reason)) {
				notify = "Gửi yêu cầu bảo hành thành công, khách hàng vui lòng chờ phản hồi từ cửa hàng";
			}else {
				notify = "Gửi yêu cầu bảo hành không thành công vui lòng kiểm tra lại thông tin";
			}
		}
		catch(Exception e)
		{
			notify = e.getMessage();
		}

		return notify;
	}

	@RequestMapping(value="/replyAnswerSupportStaff", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String replyAnswerSupportStaff(@RequestParam("idSP") String spID, @RequestParam("answerSP") String answer, 
			HttpSession session) {
		String notify=" ";
		Account acc = (Account)session.getAttribute("user");
		if(acc == null)
		{
			return "Không lấy được mã nhân viên trả lời vui lòng đăng nhập lại!";
		}
		try {
			if(SupportServices.getInstance().AnswerSupport(Integer.parseInt(spID), acc.getMaNguoiDung(), answer)) {
				notify = "Phản hồi yêu cầu hỗ trợ thành công!";
			}else {
				notify = "Phản hồi yêu cầu hỗ trợ thất bại vui lòng kiểm tra lại";
			}
		}
		catch(Exception e)
		{
			notify = "Lỗi : " + e.getMessage();
		}

		return notify;
	}

	@RequestMapping(value="/receiveGuaranteeStaff", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String receiveGuaranteeStaff(@RequestParam("idGT") String gtID, HttpSession session) {
		String notify=" ";
		Account acc = (Account)session.getAttribute("user");
		if(acc == null)
		{
			return "Không lấy được mã nhân viên trả lời vui lòng đăng nhập lại!";
		}
		try {
			if(SupportServices.getInstance().ReceiveGuarantee(Integer.parseInt(gtID), acc.getMaNguoiDung())) {
				notify = "Xác nhận thông tin bảo hành thành công!";
			}else {
				notify = "Xác nhận thông tin bảo hành không thành công vui lòng kiểm tra lại";
			}
		}
		catch(Exception e)
		{
			notify = "Lỗi : " + e.getMessage();
		}

		return notify;
	}

	@RequestMapping(value="/submitReturnDateGuarantee/{ID}/{returnDate}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String submitReturnDateGuarantee(@PathVariable String ID, @PathVariable String returnDate, HttpSession session) {

		String notify=" ";
		Account acc = (Account)session.getAttribute("user");
		if(acc == null)
		{
			return "Không lấy được mã nhân viên trả lời vui lòng đăng nhập lại!";
		}
		try {
			if(SupportServices.getInstance().ReturnGuarantee(Integer.parseInt(ID), returnDate)) {
				notify = "Xác nhận thông tin bảo hành thành công!";
			}else {
				notify = "Xác nhận thông tin bảo hành không thành công vui lòng kiểm tra ngày trả phải sau ngày nhận bảo hành";
			}
		}
		catch(Exception e)
		{
			notify = "Lỗi : " + e.getMessage();
		}

		return notify;
	}

	@RequestMapping(value="/addSupportingRequire", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String addSupportingRequire(@RequestParam("questionSupport") String questionSupport ,HttpSession session) {
		String notify=" ";
		Account acc = (Account)session.getAttribute("user");
		if(acc == null)
		{
			return "Vui lòng đăng nhập để gửi câu hỏi yêu cầu";
		}
		try {
			if(SupportServices.getInstance().AddSupportingRequire(questionSupport, Integer.parseInt(acc.getMaNguoiDung()))) {
				notify = "Gửi câu hỏi yêu cầu thành công, khách hàng vui lòng chờ phản hồi từ cửa hàng";
			}else {
				notify = "Gửi câu hỏi yêu cầu không thành công vui lòng kiểm tra lại thông tin";
			}
		}
		catch(Exception e)
		{
			notify = e.getMessage();
		}

		return notify;
	}

}
