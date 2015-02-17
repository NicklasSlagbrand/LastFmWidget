package de.umass.lastfm;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;

import javax.swing.JButton;

public class Button extends JButton implements ActionListener {  //custom button


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//private boolean OnOff= false;
private Color off,on;	
private String type;

private int size=20;

	public Button(Icon arg0) {
		super(arg0);
		
		
	}

	public Button(String typ) {
		
		type=typ;
		
		
		on = new Color( 184, 4, 0);//röd
		
		off=new Color( 96, 167, 222 );//blå
	
		this.addActionListener(this);
		
		
	}

	public Button(Action arg0) {
		super(arg0);
	
	}

	public Button(String arg0, Icon arg1) {
		super(arg0, arg1);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
	g.setColor(Color.WHITE);
	g.fill3DRect(0, 0, 150, 50,true);

		if (GUI.OnOff==true && GUI.OnOff2==false){ //button selected
			
			
			
			g.setColor(this.on);
		size=20;
		g.fill3DRect(4, 4, 150, 50,true);
		
		}
		if (GUI.OnOff==false && GUI.OnOff2==true){   //button not selected
			
	
			g.setColor(this.off);
			
		size=15;
		g.fill3DRect(1, 1, 150, 50,true);
			
		}
		 
		
		
		
		g.setFont(new Font("Arial", Font.BOLD, size));
		g.setColor(Color.WHITE);
		g.drawString(type, 10, 27);
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {  // button clicked.

  	GUI.OnOff=true;
	GUI.OnOff2= false;                               // two buttons speaking to eachother
	
	
	
		
	}


	
	

}
