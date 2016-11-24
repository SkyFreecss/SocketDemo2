package com.Demo2.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

import com.Demo2.entity.Fileentity;
import com.Demo2.entity.User;
import com.Demo2.service.FileService;
import com.Demo2.service.UserService;
import com.Demo2.util.CommanderTransfer;

public class ServerThread extends Thread{
      private ObjectInputStream ois=null;
      private ObjectOutputStream oos=null;
      private UserService us = new UserService();//�Ñ��I�Ռ���
      private FileService fs = new FileService();//�ļ��I�Ռ���
	  private Socket socket=null;
	   
	   //ͨ�^���췽������ʼ��Socket
	   public ServerThread(Socket socket)
	   {
		   this.socket = socket;
	   }
	   
	   
	   
	   
	   public void run()
	   {
		   try {
			   //��socket�@ȡݔ�������K�����D�Q�Ɍ���ݔ������
			ois = new ObjectInputStream(socket.getInputStream());
			   //��socket�@ȡݔ�������K�����D�Q�Ɍ���ݔ������
			oos = new ObjectOutputStream(socket.getOutputStream());
			CommanderTransfer transfer = (CommanderTransfer)ois.readObject();
			transfer = excute(transfer);//���п͑��˰l�͵���������ָ�������
			oos.writeObject(transfer);//�����͑��˵Ĳ�����
			oos.flush();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	   }



  //���п͑��˰l�͵���������ָ�������
	private CommanderTransfer excute(CommanderTransfer transfer) throws SQLException {
		String cmd = transfer.getCmd();//�@ȡ��ǰ������ָ�
		if(cmd.equals("login"))//�Ñ���䛡�
		{
			User user = (User)transfer.getData();
			boolean flag = us.login(user);
			transfer.setFlag(flag);
			if(flag)//�Д��Ƿ��䛳ɹ���
			{
				transfer.setResult("��ꑳɹ�!");
			}
			else
			{
				transfer.setResult("�Ñ������ܴa�����_��Ո���µ��!");
			}
		}
		else if(cmd.equals("register"))//�Ñ��]��
		{
			User user = (User)transfer.getData();
			us.register(user);//�]���Ñ���
			transfer.setResult("���x���]�� sky ��˽�˷�������");
		}
		
		else if(cmd.equals("upLoadFile"))//�ļ��ς�
		{
			Fileentity file = (Fileentity)transfer.getData();
			fs.upLoadFile(file);
			transfer.setResult("�ļ��ς��ɹ���");
		}
		
		return transfer;
	}
}
