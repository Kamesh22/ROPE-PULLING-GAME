package Rope_Pulling_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FinalDriverRopeTug  {
    public static JFrame f = new JFrame();

      public FinalDriverRopeTug() {


        }
      
    public static void main (String args [])
    {

        f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setLayout(new BorderLayout());
        f.setSize(800,600); 
        
        JLabel lblWelcomeToTug = new JLabel("Welcome to Rope Pulling game!");
        lblWelcomeToTug.setForeground(new Color(128, 0, 128));
        lblWelcomeToTug.setBackground(new Color(173, 216, 230));
        lblWelcomeToTug.setFont(new Font("Arial Black", Font.BOLD, 18));
        lblWelcomeToTug.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcomeToTug.setBounds(232, 46, 338, 37);
        f.getContentPane().add(lblWelcomeToTug);
        
        JLabel lblOption = new JLabel("Please choose the mode to continue!!");
		lblOption.setForeground(new Color(255, 0, 0));
		lblOption.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblOption.setBounds(273, 486, 287, 28);
		f.add(lblOption);
		
        JButton btnNewButton = new JButton("Versus Opponent\r\n");
        btnNewButton.setBounds(167, 417, 169, 47);
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        f.getContentPane().add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                Player_V_Player a = new Player_V_Player();
                f.getContentPane().add(a);
                f.setVisible(true);
            }
        });
  
        
     
        JButton btnNewButton_1 = new JButton("Versus Computer\r\n");
        btnNewButton_1.setBounds(477, 417, 169, 47);
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        f.getContentPane().add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                Player_VS_Comp PC = new Player_VS_Comp();
                f.getContentPane().add(PC);
                f.setVisible(true);
            }
        });
        JLabel lblNewLabel = new JLabel("");
		
        lblNewLabel.setIcon(new ImageIcon(FinalDriverRopeTug.class.getResource("/Rope_Pulling_project/bg2.png")));
		lblNewLabel.setBounds(0, 0, 784, 561);
		f.add(lblNewLabel);
       
 
        
    }
    public static JFrame getFrame()
    {
        return f;
        
    }
}
