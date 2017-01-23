package com.Demo2.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.Demo2.socket.SocketClient;

/**
 * 程序的开始界面
 * @author SkyFreecss
 *
 */
public class MainFrame extends JFrame implements ActionListener{
	
	   private static final long serialVersionUID = 8254825643745454668L;
	   private static Log log = LogFactory.getLog("MainFrame.class");
	   private JButton button1;
       private JButton button2;
       private JPanel outer;
	   public MainFrame()
	   {
		   this.setTitle("Sky的私人服务器");
		   this.setSize(300,200);
		   this.setLocation(800,300);
		   this.getContentPane().setLayout(null);
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//能使窗口关闭，结束程序。
		   outer = new JPanel();
		   this.getContentPane().add(outer);
		   outer.setBounds(45,24,200,100);
		   outer.setBorder(BorderFactory.createTitledBorder("欢迎使用Sky的私人服务器！"));
		   outer.setLayout(null);
		   button1 = new JButton();
		   button2 = new JButton();
		   button1.setBounds(30,45,60,20);
		   button1.setText("登陆");
		   button2.setBounds(110,45,60,20);
		   button2.setText("注册");
		   button1.addActionListener(this);//添加事件处理
		   button2.addActionListener(this);//添加事件处理
		   outer.add(button1);
		   outer.add(button2);
		   this.setVisible(true);
	   }
	   
	   
	   public static void main(String args[])
	   {
		   try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			MainFrame mainframe = new MainFrame();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }


	@Override
	public void actionPerformed(ActionEvent arg0) {
		   
		 if(arg0.getSource().equals(button1))
		 {
			 this.dispose();
			 new LoginFrame();
			 log.info("您已进入登陆界面！");
		 }
		
		 if(arg0.getSource().equals(button2))
		 {
			 this.dispose();
		 }
	}
	   
}
