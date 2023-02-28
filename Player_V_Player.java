package Rope_Pulling_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")

public class Player_V_Player extends JPanel implements ActionListener, KeyListener{

	Timer t = new Timer(5, this);
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
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnMode;
	private JMenuItem Exit;
    public Player_V_Player()
    {
    	setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
    	setBackground(Color.LIGHT_GRAY);
    	
    	t.start();
    	addKeyListener(this);
    	requestFocus();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    	setLayout(null);
        
    	
        
    	image = new ImageIcon(getClass().getResource("rope.gif"));

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
    	    	requestFocus();
    			start = true;
    			score = 0;
    			label.setText(score + "");
    		}
    	});
    	btnStart.setBounds(356, 504, 97, 25);
    	add(btnStart);
    	//////////////////////////////////////////
    					//Menu
    	menuBar = new JMenuBar();
    	menuBar.setBounds(0, 0, 800, 23);
    	add(menuBar);
    	
    	mnFile = new JMenu("File");
    	menuBar.add(mnFile);
    	
    	Exit = new JMenuItem("Exit");
    	mnFile.add(Exit);
    	
    	mnMode = new JMenu("Mode");
    	menuBar.add(mnMode);
    	
    	JMenuItem VSComp = new JMenuItem("VS Comp");
    	mnMode.add(VSComp);
    	
    	JLabel lblNewLabel_1 = new JLabel("Use the arrow keys");
    	lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
    	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    	lblNewLabel_1.setBounds(331, 467, 146, 25);
    	add(lblNewLabel_1);
    	
    	
    	VSComp.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    	Player_VS_Comp PC = new Player_VS_Comp();	    	
	    	FinalDriverRopeTug.getFrame().getContentPane().removeAll();
	    	FinalDriverRopeTug.getFrame().getContentPane().add(PC);
	    	FinalDriverRopeTug.getFrame().setVisible(true);

	    		}});
    	
    	
    	
	    ExitClass e = new ExitClass(); 
	    Exit.addActionListener(e);
	    }
 
    
  public void left()
    {
        if (start)
        {
            width += -5;
            lblNewLabel.setBounds(width, 233, 676, 161);

            score--;
          label.setText(score + "");

                if ( score == -20 )
                {
                	
                    try {
                    	label.setText("Left Won!");
                        start = false;
                        btnStart.setText("restart");
                        width = OgWidth;
                        lblNewLabel.setBounds(OgWidth, 233, 676, 161);
						Thread.sleep(10);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
                }
        }
    }
    
    public void right()
    {
        if ( start )
        {
        	
        	width += 5;
            lblNewLabel.setBounds(width, 233, 676, 161);

            score++;
           label.setText(score + "");

            if ( score == 20 )
            {
            	
                try {
                	label.setText("Right Won!");
                	start = false;  
                    btnStart.setText("restart");
                    width = OgWidth;
                    lblNewLabel.setBounds(OgWidth, 233, 676, 161);
					Thread.sleep(10);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}

            }
        }
    }
    
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
       
        if (code == KeyEvent.VK_RIGHT)
        {
            right();
        }
        if (code == KeyEvent.VK_LEFT)
        {
            left();
        }   
    }
    
    public void keyTyped(KeyEvent e)
    {
    }
    public void keyReleased(KeyEvent e)
    {
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO Auto-generated method stub
				
	}
}
