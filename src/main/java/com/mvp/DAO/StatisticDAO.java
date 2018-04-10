package com.mvp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import com.mvp.model.Revenue;
import com.mvp.model.Staff;

public class StatisticDAO {
	private static StatisticDAO instance;

	public StatisticDAO() {

	}

	public static StatisticDAO getInstance() {
		if(instance == null)
			instance = new StatisticDAO();
		return instance;
	}

	public static void setInstance(StatisticDAO instance) {
		StatisticDAO.instance = instance;
	}

	public List<Revenue> StatisticRevenueEachMonth() {	
		
		Calendar now = Calendar.getInstance();
		
		int currentYear = now.get(Calendar.YEAR);
		int currentMonth = now.get(Calendar.MONTH) + 1;
		
		int i = 1;
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Revenue> lst = new ArrayList<Revenue>();
			ResultSet rs;
			String SQL = "{call spStatisticRevenueEachMonth}";

			cstmt = conn.prepareCall(SQL);

			rs= cstmt.executeQuery();
//			while(rs.next())
//			{
//				Revenue st = new Revenue(rs.getInt(1),rs.getInt(2),rs.getString(3));
//				lst.add(st);
//			}
			if(rs.next()) {
				while(i < 13) {
					Revenue st = new Revenue(rs.getInt(1),rs.getInt(2),rs.getString(3));
					if(st.getsMonth() == currentMonth && st.getsYear() == currentYear) {
						lst.add(st);
						rs.next();
					}
					else {
						Revenue hihi = new Revenue(currentYear,currentMonth,"0");
						lst.add(hihi);
					}
					currentMonth--;
					if(currentMonth == 0) {
						currentYear--;
						currentMonth = 12;
					}
					i++;
				}
			}
			
			for(Revenue r: lst){
				System.out.println(r.getsMonth() + "/" + r.getsYear() + ": " +r.getIncome());
			}
			
			Collections.reverse(lst);
			
			return lst;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List<Revenue> StatisticRevenueEachYear() {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Revenue> lst = new ArrayList<Revenue>();
			ResultSet rs;
			String SQL = "{call spStatisticRevenueEachYear}";

			cstmt = conn.prepareCall(SQL);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Revenue st = new Revenue(rs.getInt(1),rs.getString(2));
				lst.add(st);
			}
			return lst;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List<Revenue> StatisticSalesOfSale() {		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Revenue> lst = new ArrayList<Revenue>();
			ResultSet rs;
			String SQL = "{call spStatisticSalesOfSale}";

			cstmt = conn.prepareCall(SQL);

			rs= cstmt.executeQuery();
			while(rs.next())
			{
				Revenue st = new Revenue(rs.getString(1),rs.getInt(2));
				lst.add(st);
			}
			return lst;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List<Revenue> StatisticRevenueThisMonth(int m, int y) {	
		
		Calendar now = Calendar.getInstance();
		
		
		
		now.set(Calendar.DATE,1); // 1
		now.set(Calendar.MONTH,m-1); // 12
		now.set(Calendar.YEAR,y); // 2017
		
		
		now.add(Calendar.MONTH, 1); // 1-1-2018
		now.add(Calendar.DATE, -1); // 31-12-2017
		
		int lastDate = now.get(Calendar.DATE);
		int i = 1;
		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		try {
			List<Revenue> lst = new ArrayList<Revenue>();
			ResultSet rs;
		
			String SQL = "{call spStatisticRevenueThisMonth(?,?)}";

			cstmt = conn.prepareCall(SQL);

			cstmt.setInt(1, m);
			cstmt.setInt(2, y);
			
			rs = cstmt.executeQuery();
			
			List<Revenue> temp = new ArrayList<Revenue>();
			
			while(rs.next()) {
				Revenue rv = new Revenue(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
				temp.add(rv);
			}
			
			int j = 0;
			
			while(i <= lastDate) {
				if(j<temp.size()) {
					Revenue st = new Revenue(temp.get(j).getsYear(),temp.get(j).getsMonth(),temp.get(j).getsDay(),temp.get(j).getIncome());
					if(st.getsDay() == i && st.getsMonth() == (now.get(Calendar.MONTH)+1) && st.getsYear() == now.get(Calendar.YEAR)) {
						lst.add(st);
						j++;
					}
					else {
						Revenue hihi = new Revenue(now.get(Calendar.YEAR),now.get(Calendar.MONTH)+1,i,"0");
						lst.add(hihi);
					}					
				}	
				else {
					Revenue hihi = new Revenue(now.get(Calendar.YEAR),now.get(Calendar.MONTH)+1,i,"0");
					lst.add(hihi);
				}
				i++;
			}
			
			return lst;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
