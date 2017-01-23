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
 * ����Ŀ�ʼ����
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
		   this.setTitle("Sky��˽�˷�����");
		   this.setSize(300,200);
		   this.setLocation(800,300);
		   this.getContentPane().setLayout(null);
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��ʹ���ڹرգ���������
		   outer = new JPanel();
		   this.getContentPane().add(outer);
		   outer.setBounds(45,24,200,100);
		   outer.setBorder(BorderFactory.createTitledBorder("��ӭʹ��Sky��˽�˷�������"));
		   outer.setLayout(null);
		   button1 = new JButton();
		   button2 = new JButton();
		   button1.setBounds(30,45,60,20);
		   button1.setText("��½");
		   button2.setBounds(110,45,60,20);
		   button2.setText("ע��");
		   button1.addActionListener(this);//����¼�����
		   button2.addActionListener(this);//����¼�����
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
			 log.info("���ѽ����½���棡");
		 }
		
		 if(arg0.getSource().equals(button2))
		 {
			 this.dispose();
		 }
	}
	   
}
