package Rope_Pulling_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")

public class Player_VS_Comp extends JPanel implements ActionListener {
	  
		public Timer timer = null;
        final int OgWidth = 56; 
        int width = 56;    
        int score = 0;
        boolean start = false;
        JLabel label;
        JButton btnStart;
        
        JLabel lblNewLabel;
        ImageIcon image; 
        
        JLabel lblNewLabel1;
        ImageIcon image1;
        
        JLabel labelVik;
        ImageIcon imageVik;
        
    	private JMenuBar menuBar;
    	private JMenu mnFile;
    	private JMenu mnMode;
    	private JMenuItem Exit;
        public void actionPerformed(ActionEvent PC){
            //need to call / display this class
        this.setVisible(true);      
    }
        
        public Player_VS_Comp ()
        {
                       
            setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
            setBackground(Color.LIGHT_GRAY);
            

            image = new ImageIcon(getClass().getResource("rope.gif"));
            setLayout(null);

            lblNewLabel = new JLabel(image);
            lblNewLabel.setBounds(56, 233, 676, 161);
            add(lblNewLabel);
            
            image1 = new ImageIcon(getClass().getResource("division.png"));
            
            lblNewLabel1 = new JLabel(image1);
            lblNewLabel1.setBounds(356, 166, 97, 313);
            add(lblNewLabel1);
            
                        
            label = new JLabel("0");
            label.setFont(new Font("Tahoma", Font.PLAIN, 57));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setBounds(224, 86, 361, 79);
            add(label);
            
            btnStart = new JButton("Start");
            btnStart.addActionListener(new ActionListener() {
            	
                public void actionPerformed(ActionEvent arg0) {
                    //requestFocus();
                    start = true;
                    timer.start();
                    score = 0;
                    label.setText(score + "");
                }});
            
            timer = new Timer(200, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	try {
                		
						Thread.sleep(300);
						--score; 
                        width -=5; 
                        lblNewLabel.setBounds(width, 233, 676, 161);
                        label.setText(score + "");
                        
					} catch (InterruptedException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
                    	

                        	if (score == -20)
                        	{
                               
                                try {
                                	 timer.stop();
                             		label.setText("You Lost!");
                                     start = false;
                                     btnStart.setText("restart");
                                     width = OgWidth;
                                     lblNewLabel.setBounds(OgWidth, 233, 676, 161);
									Thread.sleep(10);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
                        	}                   
                }
            });
            
            btnStart.setBounds(356, 504, 97, 25);
            add(btnStart);
            
            JButton btnClickMe = new JButton("Click Me");
            
            btnClickMe.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    requestFocus();
                    if (start)
                    {
                        width += 5;
                        lblNewLabel.setBounds(width, 233, 676, 161);

                        score++;
                      label.setText(score + "");

                            if ( score == 20 )
                            {
                               
                                try {
                                	 timer.stop();
                                     label.setText("You Won!");
                                     start = false;
                                     btnStart.setText("restart");
                                     width = OgWidth;
                                     lblNewLabel.setBounds(OgWidth, 233, 676, 161);
									Thread.sleep(10);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
                            }
                    }                    
                }
            });
            btnClickMe.setBounds(356, 466, 97, 25);
            add(btnClickMe); 
        	menuBar = new JMenuBar();
        	menuBar.setBounds(0, 0, 800, 23);
        	add(menuBar);
        	
        	mnFile = new JMenu("File");
        	menuBar.add(mnFile);
        	
        	Exit = new JMenuItem("Exit");
        	mnFile.add(Exit);
        	
        	mnMode = new JMenu("Mode");
        	menuBar.add(mnMode);
        	
        	
        	JMenuItem VSPlayer = new JMenuItem("VS Player");
        	mnMode.add(VSPlayer);
        	
       
        	
        	VSPlayer.addActionListener(new ActionListener() {
    	    	public void actionPerformed(ActionEvent e) {
    	    		
    	    		Player_V_Player a = new Player_V_Player();	    	
    	    	FinalDriverRopeTug.getFrame().getContentPane().removeAll();
    	    	FinalDriverRopeTug.getFrame().getContentPane().add(a);
    	    	FinalDriverRopeTug.getFrame().setVisible(true);

    	    		}});
        	
    	    ExitClass e = new ExitClass(); 
    	    Exit.addActionListener(e);
    	    }
   }

    

