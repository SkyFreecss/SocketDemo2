package com.Demo2.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//�������ˆ��ӳ���
public class StartServer {
             public static void main(String args[])
             {
            	 //����Socket���նˣ���ָ���˿ڡ�
            	 try {
					ServerSocket serversocket = new ServerSocket(8800);
					Socket socket = null;
					System.out.println("**************�gӭʹ��   sky ��˽�˷�����**************");
				    System.out.println("�������������ӣ��ȴ��͑����B��------");    
				    while(true)//������ѭ�h�O �͑��˵�Ո��
				    {
				    	//�_ʼ�O ��
				    	socket = serversocket.accept();
				    	//�_���ྀ�̡�
				    	ServerThread st = new ServerThread(socket);
				    	st.start();
				    	
				    }
					
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
             }
}
