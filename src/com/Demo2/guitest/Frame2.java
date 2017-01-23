package com.Demo2.guitest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame2 extends JFrame implements ActionListener{
       
	   private JButton button;
	   public Frame2()
	   {
		   this.setSize(300,200);
		   this.setLocation(300,400);
		   button = new JButton("Ìø×ªÖÁÒ³Ãæ1");
		   this.add(button);
		   button.addActionListener(this);
		   this.setVisible(true);
	   }
	@Override
	public void actionPerformed(ActionEvent e) {
	      if(e.getSource()==button)	
	      {
	    	  this.dispose();
	    	  new FrameTest();
	      }
	}
	   
	
	public static void main(String args[])
	{
		Frame2 frame2 = new Frame2();
	}
	   
}
