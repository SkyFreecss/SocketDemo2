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
      private UserService us = new UserService();//用戶業務對象
      private FileService fs = new FileService();//文件業務對象
	  private Socket socket=null;
	   
	   //通過構造方法，初始化Socket
	   public ServerThread(Socket socket)
	   {
		   this.socket = socket;
	   }
	   
	   
	   
	   
	   public void run()
	   {
		   try {
			   //從socket獲取輸入流，並將其轉換成對象輸入流。
			ois = new ObjectInputStream(socket.getInputStream());
			   //從socket獲取輸出流，並將其轉換成對象輸出流。
			oos = new ObjectOutputStream(socket.getOutputStream());
			CommanderTransfer transfer = (CommanderTransfer)ois.readObject();
			transfer = excute(transfer);//執行客戶端發送到服務器的指令操作。
			oos.writeObject(transfer);//相應客戶端的操作。
			oos.flush();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	   }



  //執行客戶端發送到服務器的指令操作。
	private CommanderTransfer excute(CommanderTransfer transfer) throws SQLException {
		String cmd = transfer.getCmd();//獲取當前操作的指令。
		if(cmd.equals("login"))//用戶登錄。
		{
			User user = (User)transfer.getData();
			boolean flag = us.login(user);
			transfer.setFlag(flag);
			if(flag)//判斷是否登錄成功。
			{
				transfer.setResult("登陸成功!");
			}
			else
			{
				transfer.setResult("用戶名或密碼不正確，請重新登陸!");
			}
		}
		else if(cmd.equals("register"))//用戶註冊
		{
			User user = (User)transfer.getData();
			us.register(user);//註冊用戶。
			transfer.setResult("感謝您註冊 sky 的私人服務器！");
		}
		
		else if(cmd.equals("upLoadFile"))//文件上傳
		{
			Fileentity file = (Fileentity)transfer.getData();
			fs.upLoadFile(file);
			transfer.setResult("文件上傳成功！");
		}
		
		return transfer;
	}
}
