package com.Demo2.util;

import java.io.Serializable;

//此類表示客戶機和服務器之間傳輸的指令數據。

public class CommanderTransfer implements Serializable{
	
	  
       
	   private String cmd;//當前操作的命令
	   private Object data;//發送的數據
	   private boolean flag;//操作是否成功
	   public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	private String result;//返回的結果。
	

}
