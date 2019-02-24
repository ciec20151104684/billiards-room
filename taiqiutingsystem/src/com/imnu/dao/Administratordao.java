package com.imnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.imnu.util.DBUtil;
import com.mysql.jdbc.Statement;

//根据用户名和密码查询用户是否存在
public class Administratordao {
	
	public void getAdUserInfo(String adUsername,String adPassword) throws SQLException {
		//获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from administrators where ad_username = ? and ad_password =?");
		
		statement.setString(1, adUsername);
		statement.setString(1, adPassword);
		
		//执行sql
		ResultSet result=statement.executeQuery();
		
	}
	
	

}
