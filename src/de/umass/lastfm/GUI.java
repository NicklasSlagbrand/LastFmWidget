package de.umass.lastfm;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import de.umass.lastfm.Track;
import de.umass.lastfm.Artist;
import de.umass.lastfm.ImageSize;

import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;




import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;




public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static int space = 0;
	private static int space2= 0; 
    public String country = "Sweden";    
    public static boolean load1=true;    // load top tracks Artists
    public static boolean OnOff=true;   // button 1
    public static boolean OnOff2=false; // button 2
    static SplashScreen splashScreen = new SplashScreen ("/bilder/load.png/");  // load screen
    private BufferedImage karta = null;
    private JScrollPane scroll1;
    private JLabel setCountry;
    private JPanel setComponents;
    private Button2 button2;                   //GUI graphics
    private Button button;
    private JLabel ram1;
    private JLabel sideram2;
    private JLabel sideram1;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		splashScreen.open (1000);        //load 1sec
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		
		try {
             karta = ImageIO.read(GUI.class.getResource("/images/EuropeMapPixels3.png"));
     } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
     }
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setBounds(100, 100, 798, 562);
		
     contentPane = new JPanel();
     contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
     setContentPane(contentPane);
     contentPane.setBackground(new Color( 210, 19, 9 ));
     
     scroll1 = new JScrollPane();
     scroll1.setBounds(11, 119, 383, 400);
     scroll1.setViewportBorder(null);

     //Label som är lika stor som ColorMap och darav kan vi göra den till spökbild och få den klickbar
     //Den hämtar pixelinformation och med ifsatserna bestäms vilken bilds som ska visas genom den pixelinfon.
     final JLabel LabelActionlistner = new JLabel("");
     LabelActionlistner.setBounds(397, 120, 383, 399);
     LabelActionlistner.addMouseListener(new MouseAdapter() {
    	    
    	 @Override
             public void mouseClicked(MouseEvent arg0) {
    		
    		 //returnerar x och y Kordinaternaj
             		Point p = arg0.getPoint();
                     //karta.get hämtar färg information i x och y kordinaterna som pekaren ligger på.
                     int col = karta.getRGB((int)p.getX(),(int) p.getY());
                    //Med color kan du hämta information(ex getRed())via RGBs färgsystem.
                     Color c = new Color(col);
                     System.out.println("RGB Pixelvärde Blå:" +  c.getBlue());
                     //If satserna hämtar bilder utfrån de argument som anges.
                 	splashScreen.open (1000);
                     if(c.getBlue() == 155){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/AlbanienMap.png")));
                        	
                        	country = "Albania";                      // set new country
                        	
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);                    //if button 1
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);             //if button 2
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                     }  	
                     if(c.getBlue() == 90){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/BelgienMap.png")));
                        	
                        	country = "Belgium";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 165){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/BulgarienMap.png")));
                        	country = "Bulgaria";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 145){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/BosnienHGMap.png")));
                        	country = "Bosnia";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() ==200){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/DanmarkMap.png")));
                        	
                        	country = "Denmark";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        	
                        }  
                     if(c.getBlue() == 230){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/EstlandMap.png")));
                        	country = "Estland";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 240){
                    	 LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/FinlandMap.png")));
                    	 country = "Finland";
                    	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                  
                    	 
                    	 
                        	
                        }  
                     if(c.getBlue() == 80){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/FrankrikeMap.png")));
                        	country = "France";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 185){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/GreklandMap.png")));
                        	country = "Greece";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 205){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/IrlandMap.png")));
                        	country = "Ireland";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 255 && c.getRed()==0 && c.getGreen() == 0){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/IslandMap.png")));
                        	country = "Iceland";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 105){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/ItalienMap.png")));
                        	country = "Italy";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 140){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/KroatienMap.png")));
                        	country = "croatia";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 225){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/LettlandMap.png")));
                        	country = "Latvia";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 220){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/LitauenMap.png")));
                        	country = "Lithuania";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 85){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/LuxemburgMap.png")));
                        	country = "Luxemburg";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 160){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/MakedonienMap.png")));
                        	country = "macedonia";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 175){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/MoldavienMap.png")));
                        	country = "Moldavia";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }
                     if(c.getBlue() == 95){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/NederländernaMap.png")));
                        	country = "Netherlands";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 250){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/NorgeMap.png")));
                        	country = "Norway";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        } 
                     if(c.getBlue() == 180){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/PolenMap.png")));
                        	country = "Polen";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 70){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/PortugalMap.png")));
                        	country = "Portugal";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 170){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/RumänienMap.png")));
                        	country = "Romania";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 235){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/RysslandMap.png")));
                        	country = "Russia";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 100){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/SchweizMap.png")));
                        	country = "Switzerland";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 150){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/SerbienMNMap.png")));
                        	country = "Serbia";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 125){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/SlovakienMap.png")));
                        	country = "Slovakia";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 135){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/SlovenienMap.png")));
                        	country = "Slovenia";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 75){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/SpanienMap.png")));
                        	country = "Spain";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 210){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/StorbritanienMap.png")));
                        	country = "United Kingdom";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 245){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/Sverige.map.png")));
                        	
                        	 country = "Sweden";
                        	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 120){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/TjeckienMap.png")));
                        	country = "Czech Republic";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 115){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/TysklandMap.png")));
                        	country = "Germany";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 190){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/TurkietMap.png")));
                        	country = "Turkey";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 130){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/UngernMap.png")));
                        	country = "Albania";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 195){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/UkrainaMap.png")));
                        	country = "Hungary";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 215){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/VitrysslandMap.png")));
                        	country = "Russia";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 110){
                        	LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/ÖsterrikeMap.png")));
                        	country = "Austria";
                       	 if (OnOff==true){
                        	 setCountry.setText(country);
                        	 System.out.println(country);
                        	 space = 0;
                             space2= 0;
                        	 loadArtists(country);
                        	 load1=true;
                        	 }
                        	 if(OnOff2==true){
                        		
                        		 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                        		 
                        		 loadTracks(country); 
                        	 }
                        }  
                     if(c.getBlue() == 255 && c.getRed() == 255 && c.getGreen() == 255){
                    	 LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/Sverige.map.png")));
                        	country = "Sweden";
                       
                        	 if (OnOff==true){
                            	 setCountry.setText(country);
                            	 System.out.println(country);
                            	 space = 0;
                                 space2= 0;
                            	 loadArtists(country);
                            	 load1=true;
                            	 }
                            	 if(OnOff2==true){
                            		
                            		 setCountry.setText(country);
                                	 System.out.println(country);
                                	 space = 0;
                                     space2= 0;
                            		 
                            	 }
                                    	 loadArtists(country);
                                    	 
                                     
                        } 
                    
             }
     });
     contentPane.setLayout(null);
      
      ram1 = new JLabel("");
      ram1.setIcon(new ImageIcon(GUI.class.getResource("/bilder/mmmm.jpg")));
      ram1.setBounds(-1, 71, 816, 9);
      contentPane.add(ram1);
     
      setCountry = new JLabel();
      setCountry.setHorizontalAlignment(SwingConstants.RIGHT);
      setCountry.setFont(new Font("Arial", Font.BOLD, 20));
      setCountry.setForeground(Color.WHITE);
      setCountry.setBounds(542, 93, 236, 24);
      setCountry.setText(country);
      
      
      contentPane.add(setCountry);
     
     JLabel ram2 = new JLabel("");
     ram2.setIcon(new ImageIcon(GUI.class.getResource("/bilder/mmmm.jpg")));
     ram2.setBounds(-1, 519, 816, 9);
     contentPane.add(ram2);
    
     LabelActionlistner.setBackground(new Color(34, 139, 34));
     
     //visarKarta i grundläget.
     //LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/EuropeMapDefault.png")));
     LabelActionlistner.setIcon(new ImageIcon(GUI.class.getResource("/images/Sverige.map.png")));
     
     contentPane.add(LabelActionlistner);  
     
     sideram1 = new JLabel("New label");
     sideram1.setIcon(new ImageIcon(GUI.class.getResource("/bilder/longbar.jpg")));
     sideram1.setBounds(-1, 78, 10, 449);
     contentPane.add(sideram1);
     
     sideram2 = new JLabel("New label");
     sideram2.setIcon(new ImageIcon(GUI.class.getResource("/bilder/longbar.jpg")));
     sideram2.setBounds(785, 78, 10, 450);
     contentPane.add(sideram2);
     
     setComponents = new JPanel();
     setComponents.setPreferredSize(new Dimension(1,750));
    setComponents.setBackground(Color.WHITE);
     contentPane.add(scroll1);
     
    
     scroll1.setViewportView(setComponents);
     GroupLayout gl_testP = new GroupLayout(setComponents);
     gl_testP.setHorizontalGroup(
     	gl_testP.createParallelGroup(Alignment.TRAILING)
     		.addGap(0, 360, Short.MAX_VALUE)
     );
     gl_testP.setVerticalGroup(
     	gl_testP.createParallelGroup(Alignment.LEADING)
     		.addGap(0, 823, Short.MAX_VALUE)
     );
     setComponents.setLayout(gl_testP);
     
  
     button = new Button("artists");
     button.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent arg0) {
     	}
     });
     button.setBounds(12, 84, 151, 36);
     contentPane.add(button);
     
     button2 = new Button2("tracks");
     button2.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
     	}
     });
     button2.setBounds(169, 84, 151, 36);
     contentPane.add(button2);
     
     JLabel hedder = new JLabel("");
     hedder.setIcon(new ImageIcon(GUI.class.getResource("/bilder/LOGO4.png")));
     hedder.setBounds(180, -13, 425, 98);
     contentPane.add(hedder);
       
  
       loadArtists(country);
     
		
	}

	
	public void loadArtists(String country){
		ArrayList<Artist> top10A = Methods.getTopArtist(country); // top atrister
		
		setComponents.removeAll();       // clear prev content
		 splashScreen.open(1000);
		String [] genre =Methods.getGenreArtist(country);											
		Component2[] comp = new Component2[10];            // make 10 components
		
		for (int i = 0; i < top10A.size(); i++) {
			comp[i] = new Component2(this);
			comp[i].setBounds(0, 0, 327, 68);
			comp[i].setLocation(0, 0 + space2);                   
			ImageIcon[] panel= new ImageIcon[10];             // 10 image holders
        
			int lyssnare = top10A.get(0).getListeners();
			
			try {
					URL url2 = new URL((top10A.get(i).getImageURL(ImageSize.valueOf("MEDIUM")))); // skapa array av artist bilder
					panel[i]= new ImageIcon(url2);            //fill image holders
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					panel[i]= new ImageIcon(GUI.class.getResource("/bilder/super.jpg"));
					e.printStackTrace();              
					// fill with defult if image missing
				}
				
			comp[i].setInfo(panel[i],top10A.get(i).getListeners(), top10A.get(i).getName().toString(), String.valueOf(i+1),genre[i],lyssnare,"");
			// set component content
			
			setComponents.add(comp[i]);
			
			space2 = space2 + 75;       //increment component space
			 scroll1.setViewportView(setComponents);
		      setComponents.repaint();
			
		}
	}
	
	public void loadArtistandSongs(String country, int pos){
		ArrayList<Track>  top10T = Methods.getTopArtistAndSongs(country, pos-1);	
		
		setComponents.removeAll();
		 splashScreen.open(1000);
		String [] genre2 =Methods.getGenreArtist(country);											
		
		Component2[] comp = new Component2[10]; // skriv ut infohållare
		
		for (int i = 0; i < top10T.size(); i++) {
		
			comp[i] = new Component2(this);
			
			comp[i].setBounds(0, 0, 327, 68);
			comp[i].setLocation(0, 0 + space);
			ImageIcon[] panel= new ImageIcon[10];
        
			int lyssnare = top10T.get(0).getListeners();
			
			try {
					URL url2 = new URL((top10T.get(i).getImageURL(ImageSize.valueOf("MEDIUM")))); // skapa array av artist bilder
					panel[i]= new ImageIcon(url2);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					panel[i]= new ImageIcon(GUI.class.getResource("/bilder/super.jpg"));
					//e.printStackTrace();
					System.out.println(panel[i]+" "+"saknar bild");
				}
			
			comp[i].setInfo(panel[i],top10T.get(i).getListeners(), top10T.get(i).getName().toString(), String.valueOf(i+1),genre2[pos-1],lyssnare,top10T.get(i).getArtist());
				System.out.println(comp[i]);
			
			
			setComponents.add(comp[i]);
			load1= false;
			space = space + 75;
		    setComponents.repaint();
			
		}
	}
	
	public void loadNext(String rank) {
		// TODO Auto-generated method stub
		
		System.out.println(rank);
		
		loadArtistandSongs(country, Integer.parseInt(rank));
		space=0;
		space2=0;
	}
	
	public void loadNext2 (String country){
		loadTracks(country);
	   space=0;
	   space2=0;

		
	}

	
	public void loadTracks(String country){
		
		 
		ArrayList <Track> topTracks = Methods.getTopTracks(country);
		ArrayList <String> topArt = Methods.getTopTrackAname(country);
		
		splashScreen.open(2000);
		
		setComponents.removeAll();
		Component2[] comp = new Component2[10];
		for(int i = 0; i < topTracks.size(); i++){
		
			
			comp[i] = new Component2(this);
			comp[i].setBounds(0,0,327,68);
			comp[i].setLocation(0,0 + space2);
			ImageIcon[] panel = new ImageIcon[10];
			int lisnare = topTracks.get(0).listeners;
			
			try {
				URL url3 = new URL((topTracks.get(i).getImageURL(ImageSize.valueOf("MEDIUM")))); // skapa array av artist bilder
				
				panel[i]= new ImageIcon(url3);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				panel[i]= new ImageIcon(GUI.class.getResource("/bilder/super.jpg"));
				//e.printStackTrace();
				System.out.println(panel[i]+" "+"saknar bild");
			}
			String [] genre =Methods.getGenreTrack(country);	
		System.out.println(genre[i]);
			comp[i].setInfo(panel[i],topTracks.get(i).listeners, topArt.get(i), String.valueOf(i+1),genre[i],lisnare,topTracks.get(i).name);
		
		setComponents.add(comp[i]);
		space2 = space2 + 75;
		 setComponents.repaint();
			
		}
		
		
	}
}

