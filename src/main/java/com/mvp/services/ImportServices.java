package com.mvp.services;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.mvp.*;
import com.mvp.DAO.AccountDAO;
import com.mvp.DAO.DataProvider;
import com.mvp.model.ImportDetail;

public class ImportServices {

	private static ImportServices instance;
	
	public ImportServices() {
		
	}

	public static ImportServices getInstance() {
		if(instance == null)
			instance = new ImportServices();
		return instance;
	}

	public static void setInstance(ImportServices instance) {
		ImportServices.instance = instance;
	}
	
	public boolean AddImport(String staffID, List<ImportDetail> lstImportDetail, String err) {
		
		int importID = -1;
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		
		String SQL = "{call sp_AddImport(?,?)}" ;
		String SubSQL = "{call sp_AddImportDetail(?,?,?,?,?,?)}" ;
		try {
			conn.setAutoCommit(false);
			
			cstmt = conn.prepareCall(SQL);
			
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setString(2, staffID);
			
			cstmt.executeUpdate();
			importID = cstmt.getInt(1);
			
			cstmt = conn.prepareCall(SubSQL);
			for(int i =0; i<lstImportDetail.size();i++) {
				cstmt.setInt(1, importID);
				cstmt.setString(2, lstImportDetail.get(i).getProductID());
				cstmt.setInt(3, lstImportDetail.get(i).getColorID());
				cstmt.setInt(4, lstImportDetail.get(i).getSizeID());
				cstmt.setInt(5, lstImportDetail.get(i).getQuantity());
				cstmt.setString(6, lstImportDetail.get(i).getPrice());
				cstmt.executeUpdate();
			}
			
			conn.commit();
			return true;
			
		} catch (SQLException e) {
			err = e.getMessage();
			e.printStackTrace();
			try {
				conn.rollback();
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return false;
		
	}

}
