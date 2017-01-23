package com.Demo2.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Demo2.entity.User;
import com.Demo2.util.DBUtil;

public class UserService {
       
	   public boolean login(User user) throws SQLException
	   {
		   Connection conn = DBUtil.getConnection();
		   String sql = " "+"select * from user where user_name=? and user_password=?";
		     
		     PreparedStatement ptmt = conn.prepareStatement(sql);
		     ptmt.setString(1, user.getUser_name());
		     ptmt.setString(2, user.getUser_password());
		     ResultSet rs = ptmt.executeQuery();//≤È‘É
		     
		      if(rs.next())
		     {
		     return true;
		     }
		     return false;
	   }
	   
	   public void register(User user) throws SQLException
	   {
		   Connection conn = DBUtil.getConnection();
		   String sql = " " + " insert into user " + " (user_name,user_password) " + " values("+"?,?)";
		   PreparedStatement ptmt = conn.prepareStatement(sql);
		   ptmt.setString(1, user.getUser_name());
		   ptmt.setString(2, user.getUser_password());
		   
		   ptmt.execute();
	   }
}
