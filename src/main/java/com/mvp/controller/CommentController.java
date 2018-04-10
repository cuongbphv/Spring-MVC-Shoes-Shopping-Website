package com.mvp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvp.DAO.*;
import com.mvp.model.*;
import com.mvp.services.CommentServices;
import com.sun.org.apache.xml.internal.security.utils.Base64;

@Controller
public class CommentController {

	@RequestMapping(value="/addComment",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String addComment(String productID, String title, String content, int star, HttpSession session ){
		String notify = "";
		Account acc = (Account)session.getAttribute("user");
		if (CommentDAO.getInstance().CheckExistComment(productID, Integer.parseInt(acc.getMaNguoiDung())) > 0) {
			return notify = "Bạn đã nhận xét sản phẩm này rồi!";
		}
		
		if(!CommentServices.getInstance().addComment(productID, Integer.parseInt(acc.getMaNguoiDung()), title, star, content)) {
			notify = "Xảy ra lỗi khi nhận xét sản phẩm, kiểm tra lại thông tin nhập";
		}
		
		return notify;
	}
	
	@RequestMapping(value="/showComment/{showType}/{productID}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String showComment(@PathVariable String showType,@PathVariable String productID, ModelMap md ){
		
		List<Comment> list;
		if(showType.equals("top")) {
			list = CommentDAO.getInstance().GetTopCommentByProductID(productID);
		}
		else {
			list = CommentDAO.getInstance().GetAllCommentByProductID(productID);
		}
		
		
		md.addAttribute("list", list);
		
		return "ajax/showComment";
	}
	
	
}
