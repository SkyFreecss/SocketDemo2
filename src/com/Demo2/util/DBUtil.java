package com.Demo2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
       private static final String URL="jdbc:mysql://localhost:3306/hwj?useUnicode=true&characterEncoding=utf-8";
       private static final String USER="root";
       private static final String PASSWORD="83493233";
       
       private static Connection conn=null;
       
       static 
       {
    	   try {
    		   //加载驱动程序。
			Class.forName("com.mysql.jdbc.Driver");
			  //获得数据库的连接。
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    	   
    	   
       }
       
       //对外提供一个方法，获取连接。
       public static Connection getConnection()
       {
    	   return conn;
       }
}
