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
    		   //������������
			Class.forName("com.mysql.jdbc.Driver");
			  //������ݿ�����ӡ�
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
    	   
    	   
       }
       
       //�����ṩһ����������ȡ���ӡ�
       public static Connection getConnection()
       {
    	   return conn;
       }
}
