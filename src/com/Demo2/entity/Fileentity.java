package com.Demo2.entity;

import java.io.Serializable;
import java.util.Date;

public class Fileentity implements Serializable{
            private Integer id;
            private String filename;
            private String filetype;
            private String filesize;
            private Date uploaddate;
            
			private byte[] context;
            
            public Fileentity()
            {
            	
            }
            
            public Fileentity(String filename,byte[] context,Date uploaddate)
            {
            	super();
            	this.filename = filename;
            	this.context = context;
            	this.uploaddate = uploaddate;
            }
            
			public Integer getId() {
				return id;
			}
			public void setId(Integer id) {
				this.id = id;
			}
			public String getFilename() {
				return filename;
			}
			public void setFilename(String filename) {
				this.filename = filename;
			}
			public String getFiletype() {
				return filetype;
			}
			public void setFiletype(String filetype) {
				this.filetype = filetype;
			}
			public String getFilesize() {
				return filesize;
			}
			public void setFilesize(String filesize) {
				this.filesize = filesize;
			}
			public byte[] getContext() {
				return context;
			}
			public void setContext(byte[] context) {
				this.context = context;
			}
			public Date getUploaddate() {
				return uploaddate;
			}

			public void setUploaddate(Date uploaddate) {
				this.uploaddate = uploaddate;
			}
}
