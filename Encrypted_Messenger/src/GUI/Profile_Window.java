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
import javax.swing.*;
import BaseCode.*;

public class Profile_Window implements ActionListener, MouseMotionListener {
	
	private Profile profile;
	
	private int width;
	private int height;
	
	private JFrame frame;

	private JLabel backgroundL;
	private JLabel fullnameL;
	private JLabel handleL;
	private JLabel emailL;
	private JLabel passwordL;
	private JLabel genderL;
	private JLabel dobL;
	
	private JLabel fullname;
	private JLabel handle;
	private JLabel email;
	private JLabel password;
	private JLabel gender;
	private JLabel dob;
	private JLabel profilepicL;
	
	private JButton homeB;
	private JButton profileB;
	private JButton chatB;
	private JButton settingsB;
	private JButton logoutB;
	
	private ImageIcon profilepic;
	
	private ImageIcon icon;
	private ImageIcon background;
	
	private ImageIcon homeicon;
	private ImageIcon profileicon;
	private ImageIcon chaticon;
	private ImageIcon settingsicon;
	private ImageIcon logouticon;
	
	public Profile_Window(Profile p){
		
		profile = p;
		
		double w = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double h = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		width = (int)w/4;
		height = (int)h/5;
		//System.out.println(2*width + "\n" + 3*height);
		
		icon = new ImageIcon("Data/Images/TopIcon2.png");
		background = new ImageIcon(new ImageIcon("Data/Images/Background 2.png").getImage().getScaledInstance(2*width, 3*height, Image.SCALE_SMOOTH));
		
		if(new File(p.getPropic()).exists() == true){
			profilepic = new ImageIcon(new ImageIcon(p.getPropic()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));			
		}
		
		else{
			if(p.getGender().equalsIgnoreCase("Male"))
			{
				profilepic = new ImageIcon(new ImageIcon("Data/Images/Profile Pics/Propic Male.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
			}
			
			else
			{
				profilepic = new ImageIcon(new ImageIcon("Data/Images/Profile Pics/Propic Female.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
			}
			
		}
		
		homeicon = new ImageIcon(new ImageIcon("Data/Images/Icons/1.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		profileicon = new ImageIcon(new ImageIcon("Data/Images/Icons/2.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		chaticon = new ImageIcon(new ImageIcon("Data/Images/Icons/4.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		settingsicon = new ImageIcon(new ImageIcon("Data/Images/Icons/5.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		logouticon = new ImageIcon(new ImageIcon("Data/Images/Icons/6.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
				
		backgroundL = new JLabel();
		backgroundL.setIcon(background);
		
		profilepicL = new JLabel();
		profilepicL.setIcon(profilepic);
		
		homeB = new JButton();
		homeB.setIcon(homeicon);
		homeB.setBorderPainted(false);
		homeB.addActionListener(this);
		homeB.setContentAreaFilled(false);
		homeB.addMouseMotionListener(this);
		homeB.setToolTipText("Home Page");
		
		profileB = new JButton();
		profileB.setIcon(profileicon);
		profileB.setBorderPainted(false);
		profileB.addActionListener(this);
		profileB.setContentAreaFilled(false);
		profileB.addMouseMotionListener(this);
		profileB.setToolTipText("Profile");
		
		chatB = new JButton();
		chatB.setIcon(chaticon);
		chatB.setBorderPainted(false);
		chatB.addActionListener(this);
		chatB.setContentAreaFilled(false);
		chatB.addMouseMotionListener(this);
		chatB.setToolTipText("Chat");
		
		settingsB = new JButton();
		settingsB.setIcon(settingsicon);
		settingsB.setBorderPainted(false);
		settingsB.addActionListener(this);
		settingsB.setContentAreaFilled(false);
		settingsB.addMouseMotionListener(this);
		settingsB.setToolTipText("Settings");
		
		logoutB = new JButton();
		logoutB.setIcon(logouticon);
		logoutB.setBorderPainted(false);
		logoutB.addActionListener(this);
		logoutB.setContentAreaFilled(false);
		logoutB.addMouseMotionListener(this);
		logoutB.setToolTipText("Logout");
		
		fullnameL = new JLabel("Full Name");
		fullnameL.setForeground(new Color(255, 0, 0));
		fullnameL.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		handleL = new JLabel("Handle");
		handleL.setForeground(new Color(255, 0, 0));
		handleL.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		emailL = new JLabel("Email");
		emailL.setForeground(new Color(255, 0, 0));
		emailL.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		passwordL = new JLabel("Password");
		passwordL.setForeground(new Color(255, 0, 0));
		passwordL.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		genderL = new JLabel("Gender");
		genderL.setForeground(new Color(255, 0, 0));
		genderL.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		dobL = new JLabel("Date of Birth");
		dobL.setForeground(new Color(255, 0, 0));
		dobL.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		fullname = new JLabel(profile.getFullname());
		fullname.setForeground(new Color(255, 0, 0));
		fullname.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		handle = new JLabel(profile.getHandle());
		handle.setForeground(new Color(255, 0, 0));
		handle.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		email = new JLabel(profile.getEmail());
		email.setForeground(new Color(255, 0, 0));
		email.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		password = new JLabel(profile.getPassword());
		password.setForeground(new Color(255, 0, 0));
		password.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		gender = new JLabel(profile.getGender());
		gender.setForeground(new Color(255, 0, 0));
		gender.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		dob = new JLabel(profile.getDob_day() + "  " + profile.getDob_month() + "  " + profile.getDob_year());
		dob.setForeground(new Color(255, 0, 0));
		dob.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(2*width, 3*height);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(icon.getImage());
		frame.setTitle("MSM EnCrypted MessEnger / Profile");
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		int q = 20;
		frame.getContentPane().add(homeB);
		homeB.setBounds(q, 10, 30, 30);
		
		frame.getContentPane().add(profileB);
		profileB.setBounds(q*4, 10, 30, 30);
		
		frame.getContentPane().add(chatB);
		chatB.setBounds(q*7, 10, 30, 30);
		
		frame.getContentPane().add(settingsB);
		settingsB.setBounds(q*10, 10, 30, 30);
		
		frame.getContentPane().add(logoutB);
		logoutB.setBounds(q*13, 10, 30, 30);
		
		
		frame.getContentPane().add(profilepicL);
		profilepicL.setBounds(20, 60, 150, 150);		
		
		frame.getContentPane().add(fullnameL);
		fullnameL.setBounds(20, 220, 150, 75);

		frame.getContentPane().add(handleL);
		handleL.setBounds(20, 250, 150, 75);
		
		frame.getContentPane().add(emailL);
		emailL.setBounds(20, 280, 150, 75);
		
		//frame.getContentPane().add(passwordL);
		//passwordL.setBounds(20, 130, 150, 75);
		
		frame.getContentPane().add(genderL);
		genderL.setBounds(20, 310, 150, 75);
		
		frame.getContentPane().add(dobL);
		dobL.setBounds(20, 340, 150, 75);
		
		frame.getContentPane().add(fullname);
		fullname.setBounds(170, 220, 350, 75);

		frame.getContentPane().add(handle);
		handle.setBounds(170, 250, 350, 75);
		
		frame.getContentPane().add(email);
		email.setBounds(170, 280, 350, 75);
		
		//frame.getContentPane().add(password);
		//password.setBounds(170, 130, 350, 75);
		
		frame.getContentPane().add(gender);
		gender.setBounds(170, 310, 200, 75);
		
		frame.getContentPane().add(dob);
		dob.setBounds(170, 340, 200, 75);
		
		
		frame.getContentPane().add(backgroundL);
		backgroundL.setBounds(0, 0, 2*width, 3*height);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == homeB){
			new Homepage_Window(profile);
			frame.dispose();
		}
		
		if(e.getSource() == profileB){
			new Profile_Window(profile);
			frame.dispose();
		}
		
		if(e.getSource() == chatB){
			new Chat_Window(profile);
			frame.dispose();
		}
		
		if(e.getSource() == settingsB){
			new Setting_Window(profile);
			frame.dispose();
		}
		
		if(e.getSource() == logoutB){
			new SignIn_Window();
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
		
		if(e.getSource() == homeB){
			homeB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == profileB){
			profileB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == chatB){
			chatB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == settingsB){
			settingsB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == logoutB){
			logoutB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
	}
}
