package com.Demo2.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.Demo2.entity.Fileentity;
import com.Demo2.util.DBUtil;

public class FileService {
       
	   public void upLoadFile(Fileentity file) throws SQLException
	   {
		   Connection conn = DBUtil.getConnection();
		   
		   String sql = " " + " insert into file " + " (filename,uploaddate,context) " + " values("+"?,?,?)";
		   
		  
		   PreparedStatement ptmt = conn.prepareStatement(sql);
		   
		   ptmt.setString(1,file.getFilename());
		   ptmt.setDate(2,new Date(file.getUploaddate().getTime()));
		   ptmt.setBytes(3, file.getContext());
		   
		   ptmt.execute();
	   }
}
