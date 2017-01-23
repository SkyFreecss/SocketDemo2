package com.Demo2.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.Demo2.socket.SocketClient;

/**
 * ��½����
 * @author SkyFreecss
 *
 */
public class LoginFrame extends JFrame implements ActionListener{
	   /**
	 * 
	 */
	private static final long serialVersionUID = -3827956247101073501L;
	private Log log = LogFactory.getLog("LoginFrame.class");
	private JPanel outer;
	   private JLabel label1;
	   private JLabel label2;
	   private JTextField text;
	   private JPasswordField passwd;
	   private JButton button;
	   private String username;
	   private String password;
	   public LoginFrame()
	   {
		   this.setSize(300,200);
		   this.setLocation(800,300);
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.getContentPane().setLayout(null);
		   outer = new JPanel();
		   this.getContentPane().add(outer);
		   outer.setBounds(45,24,200,120);
		   outer.setBorder(BorderFactory.createTitledBorder("��½��Ϣ��"));
		   outer.setLayout(null);
		   label1 = new JLabel("�û���");
		   label1.setBounds(30,15,50,50);
		   label2 = new JLabel("����");
		   label2.setBounds(36,45,40,50);
		   outer.add(label1);
		   outer.add(label2);
		   
		   text = new JTextField();
		   text.setBounds(75,31,100,20);
		   outer.add(text);
		   passwd = new JPasswordField();
		   passwd.setBounds(75,61,100,20);
		   outer.add(passwd);
		   
		   button = new JButton();
		   button.setText("��½");
		   button.setBounds(70,85,60,20);
		   button.addActionListener(this);//����¼�����
		   outer.add(button);
		   
		   this.setVisible(true);
	   }
	   
	   
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
	      if(arg0.getSource().equals(button))
	      {
	    	  if(text.getText()==null||text.getText().equals(""))
	    	  {
	    		 log.error("�û�������");
	    	  }
	    	  else
	    	  {
	    	  username = text.getText();//��ȡ�û���.
	    	  if(passwd.getText()==null||passwd.getText().equals(""))
	    	  {
	    		  log.error("��������");
	    	  }
	    	  else
	    	  {
	    	  password = passwd.getText();//��ȡ����.
	    	  }
	    	  }
	    	  log.info("�û�����"+username+"���룺"+password);
	    	  //sc.showLoginFrame(username, password);
	    	  SocketClient sc = new SocketClient();
	    	  sc.showLoginFrame(username, password);
	    	  this.dispose();
	    	  new UpLoadFrame();
	      }
		  
	}
	   
	   
}
