package com.mvp.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mvp.DAO.StatisticDAO;
import com.mvp.model.Revenue;
import com.mvp.services.StaffServices;

@Controller
public class StatisticController {
	@RequestMapping(value="/statisticRevenue/{id}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String statisticRevenue(@PathVariable String id, ModelMap md) {
		
		int selectID = Integer.parseInt(id);
		List<Revenue> lst;
		
		if (selectID == 1)
			lst = StatisticDAO.getInstance().StatisticRevenueEachMonth();
		else if (selectID == 2)
			lst = StatisticDAO.getInstance().StatisticRevenueEachYear();
		else if	(selectID == 3)
			lst = StatisticDAO.getInstance().StatisticSalesOfSale();
		else 
			lst = null;
		
		String json = new Gson().toJson(lst);
		
		return json;
	}
	
	@RequestMapping(value="/statisticRevenueByMonthYear/{id}/{m}/{y}", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String statisticRevenueByMonthYear(@PathVariable String id, @PathVariable String m, @PathVariable String y, ModelMap md) {
		
		int selectID = Integer.parseInt(id);
		List<Revenue> lst;
		
		if (selectID == 0)
			lst = StatisticDAO.getInstance().StatisticRevenueThisMonth(Integer.parseInt(m),Integer.parseInt(y));
		else 
			lst = null;
		
		String json = new Gson().toJson(lst);
		
		return json;
	}
}
