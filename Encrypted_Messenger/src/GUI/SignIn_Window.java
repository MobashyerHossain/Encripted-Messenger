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
import BaseCode.*;

public class SignIn_Window implements ActionListener, MouseMotionListener {
	
	private int width;
	private int height;
	
	private JFrame frame;
	
	private JLabel backgroundL;
	private JLabel handleL;
	private JLabel pass;
	private JLabel or;
	
	private JTextField handle;
	
	private JPasswordField password;
	
	private JButton signin;
	private JButton signup;
	
	private ImageIcon icon;
	private ImageIcon background;
	
	
	public SignIn_Window(){
		
		double w = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double h = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		width = (int)w/4;
		height = (int)h/5;
		//System.out.println(2*width + "\n" + 3*height);
		
		icon = new ImageIcon("Data/Images/TopIcon2.png");
		background = new ImageIcon(new ImageIcon("Data/Images/Background 2.png").getImage().getScaledInstance(2*width, 3*height, Image.SCALE_SMOOTH));
		
		backgroundL = new JLabel();
		backgroundL.setIcon(background);
		
		handleL = new JLabel("Handle");
		handleL.setForeground(new Color(255, 0, 0));
		handleL.setFont(new Font("Lucida Calligraphy", 0, 20));
		
		pass = new JLabel("Password");
		pass.setForeground(new Color(255, 0, 0));
		pass.setFont(new Font("Lucida Calligraphy", 0, 20));
		
		or = new JLabel("Or");
		or.setForeground(new Color(255, 0, 0));
		or.setFont(new Font("Lucida Calligraphy", 0, 20));
				
		handle = new JTextField();
		handle.setForeground(new Color(0, 0, 0));
		handle.setFont(new Font("Lucida Calligraphy", 0, 15));
		handle.addActionListener(this);
		
		password = new JPasswordField();
		password.setEchoChar('*');
		password.setForeground(new Color(0, 0, 0));
		password.setFont(new Font("Lucida Calligraphy", 0, 15));
		password.addActionListener(this);
		
		signin = new JButton("Sign In");
		signin.setForeground(new Color(0, 0, 0));
		signin.setFont(new Font("Lucida Calligraphy", 0, 15));
		signin.setBorderPainted(false);
		signin.addActionListener(this);
		signin.addMouseMotionListener(this);
		
		signup = new JButton("Sign Up");
		signup.setForeground(new Color(0, 0, 0));
		signup.setFont(new Font("Lucida Calligraphy", 0, 15));
		signup.setBorderPainted(false);
		signup.addActionListener(this);
		signup.addMouseMotionListener(this);

		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(2*width, 3*height);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		frame.setTitle("MSM EnCrypted MessEnger / Sign In");
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		frame.getContentPane().add(handleL);
		handleL.setBounds(20, 50, 140, 100);
		
		frame.getContentPane().add(pass);
		pass.setBounds(20, 100, 140, 100);
		
		frame.getContentPane().add(handle);
		handle.setBounds(160, 88, 200, 25);
		
		frame.getContentPane().add(password);
		password.setBounds(160, 137, 200, 25);
		
		frame.getContentPane().add(signin);
		signin.setBounds(60, 200, 100, 25);
		
		frame.getContentPane().add(or);
		or.setBounds(175, 200, 30, 25);
		
		frame.getContentPane().add(signup);
		signup.setBounds(220, 200, 100, 25);
		
		frame.getContentPane().add(backgroundL);
		backgroundL.setBounds(0, 0, 2*width, 3*height);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == handle){
			
			password.requestFocus();

		}
		
		if(e.getSource() == password){
			
			if((new Profile().handleMatch(handle.getText()) == true) && (new Profile().passwordMatch(handle.getText(), password.getText()) == true)){
				
				Profile_Reader prof = new Profile_Reader(handle.getText());
				
				new Homepage_Window(prof.ReadProfile());
				frame.dispose();
				
			}
			
			else if(handle.getText().equals("") || password.getText().equals("")){
				new Error_Window(4);
			}
			
			else{
				new Error_Window(3);
			}

		}

		if(e.getSource() == signup){
			
			new SignUp_Window();
			
			frame.dispose();

		}
		
		if(e.getSource() == signin){
			
			if((new Profile().handleMatch(handle.getText()) == true) && (new Profile().passwordMatch(handle.getText(), password.getText()) == true)){
				
				Profile_Reader prof = new Profile_Reader(handle.getText());
				
				new Homepage_Window(prof.ReadProfile());
				frame.dispose();
				
			}
			
			else if(handle.getText().equals("") || password.getText().equals("")){
				new Error_Window(4);
			}
			
			else{
				new Error_Window(3);
			}
					
		}
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == signup){
			signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == signin){
			signin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
	
	}

}
