package com.Demo2.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * �ļ��ϴ�����
 * @author SkyFreecss
 *
 */
public class UpLoadFrame extends JFrame implements ActionListener{
	   /**
	 * 
	 */
	private static final long serialVersionUID = -5272771142394364079L;
	private JPanel outer; 
	   private JLabel label;
	   private JFileChooser jfc;//�ļ�ѡ����
	   private JTextField text;
	   private JButton button1;
	   private JButton button2;
	   public UpLoadFrame()
	   {
		   jfc = new JFileChooser();
		   jfc.setCurrentDirectory(new File("F://"));//�ļ�ѡ�����ĳ�ʼ·����
		   this.setSize(300,200);
		   this.setLocation(800, 300);
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.getContentPane().setLayout(null);   
		   outer = new JPanel();
		   this.getContentPane().add(outer);
		   outer.setBorder(BorderFactory.createTitledBorder("���ѽ��뱾���������ļ��ϴ�ϵͳ��"));
		   outer.setLayout(null);
		   outer.setBounds(30,14,225,120);
		   label = new JLabel("ѡ����Ҫ�ϴ����ļ���");
		   label.setBounds(14,30,120,20);
		   outer.add(label);
		   
		   
		   text = new JTextField();
		   text.setBounds(12,55,120,20);
		   outer.add(text);
		   
		   button1 = new JButton();
		   button1.setText("ѡ��");
		   button1.setBounds(150,55,60,20);
		   button1.addActionListener(this);
		   outer.add(button1);
		   
		   button2 = new JButton();
		   button2.setText("�ϴ�");
		   button2.setBounds(80,80,60,30);
		   button2.addActionListener(this);
		   outer.add(button2);
		   
		   this.setVisible(true);
	   }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		   
		   if(arg0.getSource().equals(button1))
		   {
			   jfc.setFileSelectionMode(0);//�趨ֻ��ѡ���ļ���
			   int state = jfc.showOpenDialog(null);//�˾��Ǵ��ļ�ѡ�����Ĵ�����䡣
			   if(state==1)
			   {
				   return;
			   }
			   else
			   {
				   File file = jfc.getSelectedFile();//fileΪѡ����ļ���
				   text.setText(file.getAbsolutePath());
			   }
		   }
	}
	   
	   
}
