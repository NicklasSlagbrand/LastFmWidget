package de.umass.lastfm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Component2 extends JComponent implements ActionListener,MouseListener{ // component to hold all last fm music info


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  int listeners1=0;
	private String artist1="";
	private String rank1="";
	private ImageIcon icon1;
	private  String genre1;
	private int lyssnare1;
	private GUI gui;    // objekt från gui klass
	private boolean test =false;
	
	
	
	private String track;
	
	public  void setInfo (ImageIcon icon2, int listeners, String artist, String rank, String genre,int lyssnare,String track1){
		
		listeners1 = listeners;
		artist1 = artist;
		rank1 = rank;
		icon1=icon2;
		genre1=genre;
		lyssnare1=lyssnare;
		track=track1;
		
	}
	
	public Component2(GUI myGUI) {
		super();
		gui=myGUI;
		addMouseListener(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		
	
		
		// TODO Auto-generated method stub
		int listSize = 11;
		int artSize = 11;
		int rankSize = 15;
		int lyssnabred =280;
		
		int max1;
		
			double tiotal = (listeners1*100/lyssnare1);         // formel for growing listers bar
			double procent = tiotal/100;
			double max = procent*lyssnabred;
			max1 = (int)max;
		
		g.setColor(Color.white);
		g.fillRect(0, 0, 337, 68);
		icon1.paintIcon(this, g, 47, 7);
	
		int[]x = new int[3];
		int[]y = new int[3];
		int n;                           // count of points Make a triangle
		x[0]=123; x[1]=130; x[2]=130;
		y[0]=40; y[1]=48; y[2]=33;
		n = 3;
		
		Polygon myTri = new Polygon(x, y, n);  // a triangle
		
		
		g.setColor( new Color( 96, 167, 222 ) );

		if (test==true){
			
			g.fill3DRect(9, 7, 36, 61,true);		//Placeringsboxen
			g.fill3DRect(47, 55, max1, 13,true);	//Listenersboxen
			
		}else if (test==false){
		
		
		g.fillRect(9, 7, 36, 61);		//Placeringsboxen
		g.fillRect(47, 55, max1, 13);	//Listenersboxen
		}
	
		if (test==true ){
		g.setFont(new Font("Arial", Font.BOLD, artSize+1));          // mouse over 

		g.setColor(Color.BLACK);
		g.drawString(artist1, 130, 17);
		repaint();
		}else if (test==false){
			g.setFont(new Font("Arial", Font.BOLD, artSize));           // mouse exit

			g.setColor(Color.BLACK);
			g.drawString(artist1, 130, 17);
			repaint();
		}
		
		g.setColor(Color.BLACK);
		g.drawString(track, 130, 30);
		
		g.setFont(new Font("Arial", Font.BOLD, rankSize));
		g.setColor(Color.WHITE);
		g.drawString(rank1, 22, 23);
		
		
		
		g.setFont(new Font("Arial", Font.PLAIN, listSize));
		g.setColor(Color.WHITE);
		g.drawString(listeners1 + " listeners", 50, 65);
		
		Font f = new Font("Ariel", Font.PLAIN, listSize);
	    Rectangle2D r = f.getStringBounds(genre1, new FontRenderContext(null, RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT, RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT));
	  
		
	    g.setColor( new Color( 210, 19, 9 ) );
		g.fillRect(130, 34, (int)r.getWidth()+10, (int)r.getHeight());
		g.fillPolygon(myTri);
	    
		

		
		g.setFont(new Font("Arial", Font.PLAIN, listSize));
		g.setColor(Color.WHITE);
		g.drawString(genre1, 135, 44);
		g.setColor(Color.WHITE);
		
	    
	    
	    g.setColor(new Color(204,204,204));
	    g.draw3DRect(0, 0, 308, 0, true);
	    
	   
		
		super.paintComponent(g);
		
		
	}
	@Override
	
	public void actionPerformed(ActionEvent MouseClick) {

		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	
		if (GUI.load1==true && GUI.OnOff==true){                                   // going into Artist info
			gui.loadNext(rank1); 
  
	
		}
	}
		
		
		
		
		
		
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		test=true;
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		test=false;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}