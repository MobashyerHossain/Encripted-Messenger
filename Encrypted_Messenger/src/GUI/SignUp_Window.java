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
import java.io.File;
import java.nio.file.Files;

import javax.swing.*;
import BaseCode.*;

public class SignUp_Window implements ActionListener, MouseMotionListener {

	private int width;
	private int height;
	
	private JFrame frame;
	
	private JLabel backgroundL;
	private JLabel fullnameL;
	private JLabel handleL;
	private JLabel emailL;
	private JLabel pass1L;
	private JLabel pass2L;
	private JLabel genderL;
	private JLabel dobL;
	private JLabel propicL;	
	
	private JTextField fullname;
	private JTextField handle;
	private JTextField email;
	private JTextField propic;
	
	private JPasswordField pass1;
	private JPasswordField pass2;
	
	private JRadioButton Mgender;
	private JRadioButton Fgender;
	
	private ButtonGroup gender;
	
	private JComboBox day;
	private JComboBox month;
	private JComboBox year;
	
	private JButton signup;
	private JButton goback;
	private JButton image;
	
	private JFileChooser propicpath;
	
	private ImageIcon icon;
	private ImageIcon background;
	private ImageIcon gobackicon;
	
	public SignUp_Window(){
		
		double w = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double h = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		width = (int)w/4;
		height = (int)h/5;
		//System.out.println(2*width + "\n" + 3*height);
		
		icon = new ImageIcon("Data/Images/TopIcon2.png");
		background = new ImageIcon(new ImageIcon("Data/Images/Background 2.png").getImage().getScaledInstance(2*width, 3*height, Image.SCALE_SMOOTH));
		
		gobackicon = new ImageIcon(new ImageIcon("Data/Images/Icons/14.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		
		backgroundL = new JLabel();
		backgroundL.setIcon(background);
		
		goback = new JButton();
		goback.setIcon(gobackicon);
		goback.setBorderPainted(false);
		goback.addActionListener(this);
		goback.setContentAreaFilled(false);
		goback.addMouseMotionListener(this);
		goback.setToolTipText("Return");
		
		fullnameL = new JLabel("Full Name");
		fullnameL.setForeground(new Color(255, 0, 0));
		fullnameL.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		handleL = new JLabel("Handle");
		handleL.setForeground(new Color(255, 0, 0));
		handleL.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		propicL = new JLabel("Profile Picture");
		propicL.setForeground(new Color(255, 0, 0));
		propicL.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		emailL = new JLabel("Email");
		emailL.setForeground(new Color(255, 0, 0));
		emailL.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		pass1L = new JLabel("Password");
		pass1L.setForeground(new Color(255, 0, 0));
		pass1L.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		pass2L = new JLabel("Re-Password");
		pass2L.setForeground(new Color(255, 0, 0));
		pass2L.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		genderL = new JLabel("Gender");
		genderL.setForeground(new Color(255, 0, 0));
		genderL.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		dobL = new JLabel("Date of Birth");
		dobL.setForeground(new Color(255, 0, 0));
		dobL.setFont(new Font("Lucida Calligraphy", 0, 16));

		fullname = new JTextField();
		fullname.setForeground(new Color(0, 0, 0));
		fullname.setFont(new Font("Lucida Calligraphy", 0, 12));
		fullname.addActionListener(this);
		
		handle = new JTextField();
		handle.setForeground(new Color(0, 0, 0));
		handle.setFont(new Font("Lucida Calligraphy", 0, 12));
		handle.addActionListener(this);
		
		propic = new JTextField();
		propic.setForeground(new Color(0, 0, 0));
		propic.setFont(new Font("Lucida Calligraphy", 0, 12));
		propic.addActionListener(this);
		
		image = new JButton("Img");
		image.setForeground(new Color(0, 0, 0));
		image.setFont(new Font("Lucida Calligraphy", 0, 12));
		image.setBorderPainted(false);
		image.addActionListener(this);
		image.addMouseMotionListener(this);
		
		email = new JTextField();
		email.setForeground(new Color(0, 0, 0));
		email.setFont(new Font("Lucida Calligraphy", 0, 12));
		email.addActionListener(this);
		
		pass1 = new JPasswordField();
		pass1.setEchoChar('*');
		pass1.setForeground(new Color(0, 0, 0));
		pass1.setFont(new Font("Lucida Calligraphy", 0, 12));
		pass1.addActionListener(this);
		
		pass2 = new JPasswordField();
		pass2.setEchoChar('*');
		pass2.setForeground(new Color(0, 0, 0));
		pass2.setFont(new Font("Lucida Calligraphy", 0, 12));
		pass2.addActionListener(this);
		
		Mgender = new JRadioButton("Male");
		Mgender.setForeground(new Color(255, 0, 0));
		Mgender.setFont(new Font("Lucida Calligraphy", 0, 15));
		Mgender.setBorderPainted(false);
		Mgender.setContentAreaFilled(false);
		Mgender.setActionCommand("Male");
		Mgender.addMouseMotionListener(this);
		Mgender.addActionListener(this);

		Fgender = new JRadioButton("Female");
		Fgender.setForeground(new Color(255, 0, 0));
		Fgender.setFont(new Font("Lucida Calligraphy", 0, 15));
		Fgender.setBorderPainted(false);
		Fgender.setContentAreaFilled(false);
		Fgender.setActionCommand("Female");
		Fgender.addMouseMotionListener(this);
		Fgender.addActionListener(this);
		
		gender = new ButtonGroup();
		gender.add(Fgender);
		gender.add(Mgender);
		Mgender.setSelected(true);
		
		String[] days = new String[31];
		for(int i = 0 ; i<31 ; i++){
			days[i] = Integer.toString(i+1);
		}
		day = new JComboBox(days);
		day.setForeground(new Color(0, 0, 0));
		day.setFont(new Font("Lucida Calligraphy", 0, 12));
		day.addMouseMotionListener(this);
		day.addActionListener(this);
		
		String[] months = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
		month = new JComboBox(months);
		month.setForeground(new Color(0, 0, 0));
		month.setFont(new Font("Lucida Calligraphy", 0, 12));
		month.addMouseMotionListener(this);
		month.addActionListener(this);
		
		String[] years = new String[61];
		for(int i = 0 ; i<61 ; i++){
			years[i] = Integer.toString(2011-i);
		}
		year = new JComboBox(years);
		year.setForeground(new Color(0, 0, 0));
		year.setFont(new Font("Lucida Calligraphy", 0, 12));
		year.addMouseMotionListener(this);
		year.addActionListener(this);

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
		frame.setIconImage(icon.getImage());
		frame.setTitle("MSM EnCrypted MessEnger / Sign Up");
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		frame.getContentPane().add(goback);
		goback.setBounds(20, 10, 30, 30);
		
		frame.getContentPane().add(fullnameL);
		fullnameL.setBounds(20, 50, 150, 25);

		frame.getContentPane().add(handleL);
		handleL.setBounds(20, 90, 150, 25);
		
		frame.getContentPane().add(propicL);
		propicL.setBounds(20, 130, 150, 25);
		
		frame.getContentPane().add(emailL);
		emailL.setBounds(20, 170, 150, 25);
		
		frame.getContentPane().add(pass1L);
		pass1L.setBounds(20, 210, 150, 25);
		
		frame.getContentPane().add(pass2L);
		pass2L.setBounds(20, 250, 150, 25);
		
		frame.getContentPane().add(genderL);
		genderL.setBounds(20, 290, 150, 25);
		
		frame.getContentPane().add(dobL);
		dobL.setBounds(20, 330, 150, 25);

		
		frame.getContentPane().add(fullname);
		fullname.setBounds(170, 50, 210, 25);
		
		frame.getContentPane().add(handle);
		handle.setBounds(170, 90, 210, 25);
		
		frame.getContentPane().add(propic);
		propic.setBounds(170, 130, 130, 25);
		
		frame.getContentPane().add(image);
		image.setBounds(310, 130, 70, 25);
		
		frame.getContentPane().add(email);
		email.setBounds(170, 170, 210, 25);
		
		frame.getContentPane().add(pass1);
		pass1.setBounds(170, 210, 210, 25);
		
		frame.getContentPane().add(pass2);
		pass2.setBounds(170, 250, 210, 25);
		
		frame.getContentPane().add(Mgender);
		Mgender.setBounds(170, 290, 70, 25);
		
		frame.getContentPane().add(Fgender);
		Fgender.setBounds(260, 290, 100, 25);
		
		frame.getContentPane().add(day);
		day.setBounds(170, 330, 40, 25);
		
		frame.getContentPane().add(month);
		month.setBounds(220, 330, 90, 25);
		
		frame.getContentPane().add(year);
		year.setBounds(320, 330, 55, 25);
		
		frame.getContentPane().add(signup);
		signup.setBounds(200, 370, 100, 30);
		
		
		frame.getContentPane().add(backgroundL);
		backgroundL.setBounds(0, 0, 2*width, 3*height);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == fullname){
			handle.requestFocus();
		}
		
		if(e.getSource() == handle){
			propic.requestFocus();
		}
		
		if(e.getSource() == propic){
			email.requestFocus();
		}
		
		if(e.getSource() == image){
			propicpath = new JFileChooser();
			propicpath.setDialogTitle("Profile Picture");
			
			try {				
				if(propicpath.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
					
					File f = propicpath.getSelectedFile();
					File cf = new File("Data/Images/Profile Pics/"+f.getName());
					Files.copy(f.toPath(), cf.toPath());
					
					propic.setText(cf.getAbsolutePath());					
					
				}
			} catch (Exception e2) {
				
			}
		}
		
		if(e.getSource() == email){
			pass1.requestFocus();
		}
		
		if(e.getSource() == pass1){
			pass2.requestFocus();
		}
		
		if(e.getSource() == pass2){
			Mgender.requestFocus();
		}
		
		if(e.getSource() == goback){
			new SignIn_Window();
		}
		
		if(e.getSource() == signup){
			
			String a =day.getSelectedItem().toString();
			String b =month.getSelectedItem().toString();
			String c =year.getSelectedItem().toString();
			String d;
			
			if(gender.getSelection().getActionCommand().equals(Mgender.getText())){
				d = Mgender.getText();
			}
			
			else{
				d = Fgender.getText();
			}
			
			if(new Profile().handleMatch(handle.getText()) == true){
				
				new Error_Window(1);
				
			}
			
			else if(handle.getText().equals("") || fullname.getText().equals("") || email.getText().equals("") || pass1.getText().equals("") || pass2.getText().equals("")){
				new Error_Window(4);
			}

			else if(!(pass2.getText().equals(pass1.getText()))){
				
				new Error_Window(2);
				
			}
			
			else if(pass1.getText().length() <8 || pass1.getText().length() >20){
				
				new Error_Window(5);
			}

			else{
				
				Profile n = new Profile(fullname.getText(), handle.getText(), email.getText(), pass1.getText(), d, a, b, c, propic.getText());
				
				new Profile_Writer(n).CreatProfile();
				
				new SignIn_Window();
				frame.dispose();
				
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
		
		if(e.getSource() == Mgender){
			Mgender.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == Fgender){
			Fgender.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == day){
			day.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == month){
			month.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == year){
			year.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == signup){
			signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == goback){
			goback.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
	}

}
