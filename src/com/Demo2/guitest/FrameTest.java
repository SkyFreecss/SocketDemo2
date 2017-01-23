package com.Demo2.guitest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 简单的界面跳转测试 
 * @author SkyFreecss
 *
 */
public class FrameTest extends JFrame implements ActionListener{      
 	   
	   private JButton button;
	   
	   public FrameTest()
	   {
		   this.setSize(300,200);
		   this.setLocation(300,400);
		   button = new JButton("跳转至页面2");
		   this.add(button);
		   button.addActionListener(this);//添加监听事件
		   this.setVisible(true);
	   }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button)
		{
			this.dispose();//点击按钮时销毁当前frame，new一个新的frame
			new Frame2();
		}
		
	}
	   
	public static void main(String args[])
	{
		FrameTest frametest = new FrameTest();
	}
	   
}
