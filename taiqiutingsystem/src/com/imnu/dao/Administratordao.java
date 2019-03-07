package com.imnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.imnu.bean.Administratorbean;
import com.imnu.util.DBUtil;




//根据用户名和密码查询用户是否存在
public class Administratordao {
	
	
	public Administratorbean login(String adUsername, String adPassword) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql ="select * from administrators where ad_username = ? and ad_password =?";
		Administratorbean Administrator =null;
		
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, adUsername);
			pstm.setString(2, adPassword);
			ResultSet rs = pstm.executeQuery();
			 Administrator = new Administratorbean();
			while(rs.next()) {
				//Administrator.setAdId(rs.getString("ad_id"));
				Administrator.setAdUsername(rs.getString("adUsername"));
				Administrator.setAdPassword(rs.getString("adPassword"));
			}
			
			
		} catch (SQLException e) {
			
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Administrator;
		
	}

}
