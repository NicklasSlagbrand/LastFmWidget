package de.umass.lastfm;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;

import javax.swing.JButton;

public class Button2 extends JButton implements ActionListener {  //custom button two

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//private boolean OnOff= false;
private Color off1,on1;	
private String type;

private int size=20;

	public Button2(Icon arg0) {
		super(arg0);
		
		
	}

	public Button2(String typ) {
		
		type=typ;
		
		
		on1 = new Color( 184, 4, 0 ); //röd
		
		off1=new Color( 96, 167, 222 ); //blå
	
		this.addActionListener(this);
		
		
	}

	public Button2(Action arg0) {
		super(arg0);
	
	}

	public Button2(String arg0, Icon arg1) {
		super(arg0, arg1);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fill3DRect(0, 0, 150, 50,true);
		
		if (GUI.OnOff2==true && GUI.OnOff==false){ // button selected
			
			
			g.setColor(this.on1);
			
		
		
			size=20;
			g.fill3DRect(4, 4, 150, 50,true);
			
			
		}
		if (GUI.OnOff2==false && GUI.OnOff==true){ // button not selected
		
			 g.setColor(this.off1);
			
			size=15;
			g.fill3DRect(1, 1, 150, 50,true);	
		  
		}
		 
		
	
		
		g.setFont(new Font("Arial", Font.BOLD, size));
		g.setColor(Color.WHITE);
		g.drawString(type, 10, 27);
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
	
	GUI.OnOff2=true;                                    // custom button one and two booleans
	GUI.OnOff= false;

	
	}


	
	

}
