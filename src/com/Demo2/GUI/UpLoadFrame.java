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
 * 文件上传界面
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
	   private JFileChooser jfc;//文件选择器
	   private JTextField text;
	   private JButton button1;
	   private JButton button2;
	   public UpLoadFrame()
	   {
		   jfc = new JFileChooser();
		   jfc.setCurrentDirectory(new File("F://"));//文件选择器的初始路径。
		   this.setSize(300,200);
		   this.setLocation(800, 300);
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.getContentPane().setLayout(null);   
		   outer = new JPanel();
		   this.getContentPane().add(outer);
		   outer.setBorder(BorderFactory.createTitledBorder("您已进入本服务器的文件上传系统！"));
		   outer.setLayout(null);
		   outer.setBounds(30,14,225,120);
		   label = new JLabel("选择需要上传的文件：");
		   label.setBounds(14,30,120,20);
		   outer.add(label);
		   
		   
		   text = new JTextField();
		   text.setBounds(12,55,120,20);
		   outer.add(text);
		   
		   button1 = new JButton();
		   button1.setText("选择");
		   button1.setBounds(150,55,60,20);
		   button1.addActionListener(this);
		   outer.add(button1);
		   
		   button2 = new JButton();
		   button2.setText("上传");
		   button2.setBounds(80,80,60,30);
		   button2.addActionListener(this);
		   outer.add(button2);
		   
		   this.setVisible(true);
	   }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		   
		   if(arg0.getSource().equals(button1))
		   {
			   jfc.setFileSelectionMode(0);//设定只能选择文件。
			   int state = jfc.showOpenDialog(null);//此句是打开文件选择器的触发语句。
			   if(state==1)
			   {
				   return;
			   }
			   else
			   {
				   File file = jfc.getSelectedFile();//file为选择的文件。
				   text.setText(file.getAbsolutePath());
			   }
		   }
	}
	   
	   
}
