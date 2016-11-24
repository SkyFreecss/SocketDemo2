package com.Demo2.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//服務器端啟動程序。
public class StartServer {
             public static void main(String args[])
             {
            	 //創建Socket服務端，并指定端口。
            	 try {
					ServerSocket serversocket = new ServerSocket(8800);
					Socket socket = null;
					System.out.println("**************歡迎使用   sky 的私人服務器**************");
				    System.out.println("服務器即將啟動，等待客戶端連接------");    
				    while(true)//服務器循環監聽客戶端的請求。
				    {
				    	//開始監聽。
				    	socket = serversocket.accept();
				    	//開啟多線程。
				    	ServerThread st = new ServerThread(socket);
				    	st.start();
				    	
				    }
					
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
             }
}
