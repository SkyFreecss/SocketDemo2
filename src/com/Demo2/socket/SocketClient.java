package com.Demo2.socket;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.ProgressMonitor;
import javax.swing.ProgressMonitorInputStream;

import com.Demo2.GUI.MainFrame;
import com.Demo2.entity.Fileentity;
import com.Demo2.entity.User;
import com.Demo2.util.CommanderTransfer;

//�͑���
public class SocketClient {
       Scanner input = new Scanner(System.in);
       private Socket socket = null; //�͑���socket
       private MainFrame mf;
       static ProgressMonitorInputStream progress;
       static ProgressMonitor progressmonitor;
       static FileInputStream fis;
       //���ˆΡ�
       public void showMainMenu()
       {
    	   System.out.println("**********������ʹ�ô˷��������ļ��ς�����**********");
    	   System.out.println("1.�]�ԡ�2.��䛡�3.�˳�");
    	   System.out.println("�����ϰ�߿���̨�������밴�� 4 ������ӻ��������棡");
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
    	          System.exit(0);//�˳�
    	          
    	          case 4:
    	          mf = new MainFrame();
    	          System.out.println("�ѽ�����������");
    	          break;
    	          
    	          default:
    	          System.out.println("ݔ�����`��");
    	          System.exit(0);
    	   }
       }
       
       //��ꑌ��F
      public void showLoginFrame(String username,String password)
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
    		   
    		   user.setUser_name(username);
    		   user.setUser_password(password);
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
       public void showRegister()
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
   		   SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd");
   		   
   		   Date uploaddate = null;
		try {
			uploaddate = matter.parse(matter.format(new Date()));//��String���͵�ʱ��ת��ΪDate���ͣ�
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		   CommanderTransfer transfer = new CommanderTransfer();
   		   try {
            fis = new FileInputStream(path);
			byte[] fncontext = new byte[fis.available()];
			BufferedInputStream bis = new BufferedInputStream(fis);
            /*
			progress = new ProgressMonitorInputStream(null,"Loading",fis);
			progressmonitor = progress.getProgressMonitor();
			int read_unit = 2;//����ÿ�ζ�ȡ���ַ�����
			int all = progress.available();//�õ�Ŀ���ļ������ֽ�����
			int readed = 0;//ÿ��ʵ�ʶ�ȡ�����ֽ�����
			byte[] data = new byte[read_unit];
			while(progress.available()>0)
			{
				int in = progress.read(data);
				readed += in;
				
				float processload = (float) readed/all *100;
				progressmonitor.setNote("�ļ��ϴ����Եȣ�" + processload + "%");
			}
			*/
			bis.read(fncontext);
			file = new Fileentity(fname,fncontext,uploaddate);
			
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
