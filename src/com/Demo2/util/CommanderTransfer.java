package com.Demo2.util;

import java.io.Serializable;

//���ʾ�͑��C�ͷ�����֮�g��ݔ��ָ�����

public class CommanderTransfer implements Serializable{
	
	  
       
	   private String cmd;//��ǰ����������
	   private Object data;//�l�͵Ĕ���
	   private boolean flag;//�����Ƿ�ɹ�
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
	private String result;//���صĽY����
	

}
