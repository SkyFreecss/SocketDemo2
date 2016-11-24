package com.Demo2.socket;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.Demo2.entity.Fileentity;
import com.Demo2.entity.User;
import com.Demo2.util.CommanderTransfer;

//客戶端
public class SocketClient {
       Scanner input = new Scanner(System.in);
       private Socket socket = null; //客戶端socket
       
       //主菜單。
       public void showMainMenu()
       {
    	   System.out.println("**********您正在使用此服務器的文件上傳服務**********");
    	   System.out.println("1.註冊、2.登錄、3.退出");
    	   System.out.println("---------------------------------------------------");
    	   System.out.println("請選擇：");
    	   
    	   int choice = input.nextInt();
    	   
    	   switch(choice)
    	   {
    	          case 1:
                  showRegister();//註冊
                  break;
    	          
    	          case 2:
    	          showLogin();//登陸
    	          break;
    	          
    	          case 3:
    	          System.out.println("再見，感謝您對  sky 私人服務器的支持！");
    	          System.exit(0);
    	          
    	          default:
    	          System.out.println("輸入有誤！");
    	          System.exit(0);
    	   }
       }
       
       //登陸實現
       private void showLogin()
       {
    	   User user = new User();
    	   CommanderTransfer transfer = new CommanderTransfer();
    	   int count = 0;//登陸次數
    	   
    	   while(true)
    	   {
    		   count++;
    		   if(count>3)
    		   {
    			   System.out.println("您已經連續三次登陸失敗，本服務器已關閉！");
    			   System.exit(0);
    		   }
    		   
    		   System.out.println("請輸入用戶名：");
    		   user.setUser_name(input.next());
    		   System.out.println("請輸入密碼：");
    		   user.setUser_password(input.next());
    		   transfer.setCmd("login");
    		   transfer.setData(user);
    		   
    		   try {
				socket = new Socket("127.0.0.1",8800);
				sendData(transfer);//將數據發送到服務器
				transfer = getData();//獲取服務器返回的數據
				System.out.println(transfer.getResult());//顯示輸出結果。
				System.out.println("-----------------------------------");
				if(transfer.isFlag())
				{
					break;//如果登陸不成功，則不再重複執行登陸。
				}
			} catch (UnknownHostException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally
    		   {
				closeAll();//結束本次socket通信。
    		   }
    	   }
    	   showUpLoadFile();
       }
       
       //註冊實現
       private void showRegister()
       {
    	   User user = new User();
    	   CommanderTransfer transfer = new CommanderTransfer();
    	   while(true)
    	   {
    		   System.out.println("請輸入用戶名：");
    		   user.setUser_name(input.next());
    		   System.out.println("請輸入密碼：");
    		   user.setUser_password(input.next());
    		   System.out.println("請再次輸入密碼：");
    		   String rePassword = input.next();
    		   if(!user.getUser_password().equals(rePassword))
    		   {
    			   System.out.println("兩次輸入的密碼不一致！");
    			   System.out.println("----------------------------------");
    			   continue;
    		   }
    		   transfer.setCmd("register");
    		   transfer.setData(user);
    		   
    		   try {
				socket = new Socket("127.0.0.1",8800);
				sendData(transfer);
				transfer = getData();
				System.out.println(transfer.getResult());
				System.out.println("-------------------------------------");
				if(!transfer.isFlag())
				{
					break;//如果註冊成功，則不重複執行註冊。
				}
				
			} catch (UnknownHostException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
    		finally
    		{
    			closeAll();
    		}
    	   }
    	   showLogin();
       }
       
       //文件上傳實現。
       public void showUpLoadFile()
       {
    	   System.out.println("您已進入 sky 私人服務器的文件上傳系統！");
    	   System.out.println("請輸入上傳文件的絕對路徑（如f:/JavaIo/斯大林.jpg）：");
    	   Fileentity file = null;
   		   String path = input.next();
   		   String fname = path.substring(path.lastIndexOf("/")+1);
		   CommanderTransfer transfer = new CommanderTransfer();
   		   try {
			FileInputStream fis = new FileInputStream(path);
			byte[] fcontext = new byte[fis.available()];
			BufferedInputStream bis = new BufferedInputStream(fis);
			bis.read(fcontext);
			file = new Fileentity(fname,fcontext);
			
			socket = new Socket("127.0.0.1",8800);
			transfer.setCmd("upLoadFile");
			transfer.setData(file);
			sendData(transfer);
			transfer = getData();
			System.out.println(transfer.getResult());
			
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
       }
       
       

	private void closeAll() {
		    try {
				socket.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		
	}

	private CommanderTransfer getData() {
		//獲取輸入流，接受服務器端返回的數據,並轉換為對象輸入流。
		    try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				return (CommanderTransfer)ois.readObject();	
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				return null;
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return null;
			
	}

	private void sendData(CommanderTransfer transfer) {
		  //獲取輸出流，向服務器端發送數據,並轉換為對象輸出流。
		  try {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(transfer);
			oos.flush();
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
}
