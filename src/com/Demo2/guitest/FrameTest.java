package com.Demo2.guitest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * �򵥵Ľ�����ת���� 
 * @author SkyFreecss
 *
 */
public class FrameTest extends JFrame implements ActionListener{      
 	   
	   private JButton button;
	   
	   public FrameTest()
	   {
		   this.setSize(300,200);
		   this.setLocation(300,400);
		   button = new JButton("��ת��ҳ��2");
		   this.add(button);
		   button.addActionListener(this);//��Ӽ����¼�
		   this.setVisible(true);
	   }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button)
		{
			this.dispose();//�����ťʱ���ٵ�ǰframe��newһ���µ�frame
			new Frame2();
		}
		
	}
	   
	public static void main(String args[])
	{
		FrameTest frametest = new FrameTest();
	}
	   
}
