package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class Error_Window implements ActionListener, MouseMotionListener {
	
	private int i;
	private int width;
	private int height;
	
	private JFrame frame;
	
	private JLabel backgroundL;
	private JLabel warning;
	
	private JButton warningB;
	
	private ImageIcon icon;
	private ImageIcon background;
	private ImageIcon warningicon;
	
	public Error_Window(int j){	
		
		i = j;
		
		double w = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double h = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		width = (int)w/4;
		height = (int)h/5;
		//System.out.println(width + "\n" + height);
		
		icon = new ImageIcon("Data/Images/TopIcon2.png");
		background = new ImageIcon(new ImageIcon("Data/Images/Warning bg.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		
		warningicon = new ImageIcon(new ImageIcon("Data/Images/Icons/7.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		
		backgroundL = new JLabel();
		backgroundL.setIcon(background);
		
		warningB = new JButton();
		warningB.setIcon(warningicon);
		warningB.setBorderPainted(false);
		warningB.addActionListener(this);
		warningB.setContentAreaFilled(false);
		warningB.addMouseMotionListener(this);
		warningB.setToolTipText("Try Again");
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(icon.getImage());
		frame.setTitle("MSM EnCrypted MessEnger / Error!!!");
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		if(i == 1){
			warning = new JLabel("This Handle is Unavailable!!!");
			warning.setForeground(new Color(255, 0, 0));
			warning.setFont(new Font("Lucida Calligraphy", 0, 17));
			
			frame.getContentPane().add(warning);
			warning.setBounds(40, 5, 300, 60);
		}
		
		else if(i == 2){
			warning = new JLabel("Re-Password doesn't match Password!!!");
			warning.setForeground(new Color(255, 0, 0));
			warning.setFont(new Font("Lucida Calligraphy", 0, 15));
			
			frame.getContentPane().add(warning);
			warning.setBounds(10, 5, 320, 60);
		}
		
		else if(i == 3){
			warning = new JLabel("Either Handle or Password is Wrong!!!");
			warning.setForeground(new Color(255, 0, 0));
			warning.setFont(new Font("Lucida Calligraphy", 0, 15));
			
			frame.getContentPane().add(warning);
			warning.setBounds(10, 5, 320, 60);
		}
		
		else if(i == 4){
			warning = new JLabel("Some fields are left Empty!!!");
			warning.setForeground(new Color(255, 0, 0));
			warning.setFont(new Font("Lucida Calligraphy", 0, 15));
			
			frame.getContentPane().add(warning);
			warning.setBounds(50, 5, 320, 60);
		}
		
		else if(i == 5){
			warning = new JLabel("Password Must be Between (8-20) Characters!!!");
			warning.setForeground(new Color(255, 0, 0));
			warning.setFont(new Font("Lucida Calligraphy", 0, 13));
			
			frame.getContentPane().add(warning);
			warning.setBounds(5, 5, 340, 60);
		}
		
		else if(i == 6){
			warning = new JLabel("Chat Room ID must be a 4 digit Integer!!!");
			warning.setForeground(new Color(255, 0, 0));
			warning.setFont(new Font("Lucida Calligraphy", 0, 14));
			
			frame.getContentPane().add(warning);
			warning.setBounds(10, 5, 320, 60);
		}
		
		else if(i == 7){
			warning = new JLabel("Chat Room with this ID can not found!!!");
			warning.setForeground(new Color(255, 0, 0));
			warning.setFont(new Font("Lucida Calligraphy", 0, 14));
			
			frame.getContentPane().add(warning);
			warning.setBounds(20, 5, 320, 60);
		}
		
		
		
		frame.getContentPane().add(warningB);
		warningB.setBounds(135, 60, 40, 40);
		
		
		frame.getContentPane().add(backgroundL);
		backgroundL.setBounds(0, 0, width, height);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == warningB){
			frame.dispose();
			
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
			
		if(e.getSource() == warningB){
			warningB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
	}

}
