package com.Demo2.entity;

import java.io.Serializable;

public class Fileentity implements Serializable{
            private Integer id;
            private String filename;
            private String filetype;
            private String filesize;
            private byte[] context;
            
            public Fileentity()
            {
            	
            }
            
            public Fileentity(String filename,byte[] context)
            {
            	super();
            	this.filename = filename;
            	this.context = context;
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
}
