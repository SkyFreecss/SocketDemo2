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

//�͑���
public class SocketClient {
       Scanner input = new Scanner(System.in);
       private Socket socket = null; //�͑���socket
       
       //���ˆΡ�
       public void showMainMenu()
       {
    	   System.out.println("**********������ʹ�ô˷��������ļ��ς�����**********");
    	   System.out.println("1.�]�ԡ�2.��䛡�3.�˳�");
    	   System.out.println("---------------------------------------------------");
    	   System.out.println("Ո�x��");
    	   
    	   int choice = input.nextInt();
    	   
    	   switch(choice)
    	   {
    	          case 1:
                  showRegister();//�]��
                  break;
    	          
    	          case 2:
    	          showLogin();//���
    	          break;
    	          
    	          case 3:
    	          System.out.println("��Ҋ�����x����  sky ˽�˷�������֧�֣�");
    	          System.exit(0);
    	          
    	          default:
    	          System.out.println("ݔ�����`��");
    	          System.exit(0);
    	   }
       }
       
       //��ꑌ��F
       private void showLogin()
       {
    	   User user = new User();
    	   CommanderTransfer transfer = new CommanderTransfer();
    	   int count = 0;//��ꑴΔ�
    	   
    	   while(true)
    	   {
    		   count++;
    		   if(count>3)
    		   {
    			   System.out.println("���ѽ��B�m���ε��ʧ���������������P�]��");
    			   System.exit(0);
    		   }
    		   
    		   System.out.println("Ոݔ���Ñ�����");
    		   user.setUser_name(input.next());
    		   System.out.println("Ոݔ���ܴa��");
    		   user.setUser_password(input.next());
    		   transfer.setCmd("login");
    		   transfer.setData(user);
    		   
    		   try {
				socket = new Socket("127.0.0.1",8800);
				sendData(transfer);//�������l�͵�������
				transfer = getData();//�@ȡ���������صĔ���
				System.out.println(transfer.getResult());//�@ʾݔ���Y����
				System.out.println("-----------------------------------");
				if(transfer.isFlag())
				{
					break;//�����ꑲ��ɹ����t�������}���е�ꑡ�
				}
			} catch (UnknownHostException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}finally
    		   {
				closeAll();//�Y������socketͨ�š�
    		   }
    	   }
    	   showUpLoadFile();
       }
       
       //�]�Ԍ��F
       private void showRegister()
       {
    	   User user = new User();
    	   CommanderTransfer transfer = new CommanderTransfer();
    	   while(true)
    	   {
    		   System.out.println("Ոݔ���Ñ�����");
    		   user.setUser_name(input.next());
    		   System.out.println("Ոݔ���ܴa��");
    		   user.setUser_password(input.next());
    		   System.out.println("Ո�ٴ�ݔ���ܴa��");
    		   String rePassword = input.next();
    		   if(!user.getUser_password().equals(rePassword))
    		   {
    			   System.out.println("�ɴ�ݔ����ܴa��һ�£�");
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
					break;//����]�Գɹ����t�����}�����]�ԡ�
				}
				
			} catch (UnknownHostException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
    		finally
    		{
    			closeAll();
    		}
    	   }
    	   showLogin();
       }
       
       //�ļ��ς����F��
       public void showUpLoadFile()
       {
    	   System.out.println("�����M�� sky ˽�˷��������ļ��ς�ϵ�y��");
    	   System.out.println("Ոݔ���ς��ļ��Ľ^��·������f:/JavaIo/˹����.jpg����");
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
       }
       
       

	private void closeAll() {
		    try {
				socket.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		
	}

	private CommanderTransfer getData() {
		//�@ȡݔ���������ܷ������˷��صĔ���,�K�D�Q�錦��ݔ������
		    try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				return (CommanderTransfer)ois.readObject();	
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				return null;
			} catch (ClassNotFoundException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			return null;
			
	}

	private void sendData(CommanderTransfer transfer) {
		  //�@ȡݔ��������������˰l�͔���,�K�D�Q�錦��ݔ������
		  try {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(transfer);
			oos.flush();
			
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}
}
