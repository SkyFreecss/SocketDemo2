package com.Demo2.service;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Demo2.entity.Fileentity;
import com.Demo2.util.DBUtil;

public class FileService {
       
	   public void upLoadFile(Fileentity file) throws SQLException
	   {
		   Connection conn = DBUtil.getConnection();
		   
		   String sql = " " + " insert into file " + " (filename,context) " + " values("+"?,?)";
		   
		  
		   PreparedStatement ptmt = conn.prepareStatement(sql);
		   
		   ptmt.setString(1,file.getFilename());
		   ptmt.setBytes(2, file.getContext());
		   
		   ptmt.execute();
	   }
}
