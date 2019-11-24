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
import BaseCode.Profile;

public class Homepage_Window implements ActionListener, MouseMotionListener {
	
	private Profile profile;
	private int width;
	private int height;
	
	private JFrame frame;
	
	private JLabel backgroundL;
	private JLabel greeting;
	private JLabel genderL;
	private JLabel fullname;
	
	private JButton homeB;
	private JButton profileB;
	private JButton chatB;
	private JButton settingsB;
	private JButton logoutB;
	
	private ImageIcon icon;
	private ImageIcon background;
	
	private ImageIcon homeicon;
	private ImageIcon profileicon;
	private ImageIcon chaticon;
	private ImageIcon settingsicon;
	private ImageIcon logouticon;
	
	public Homepage_Window(Profile p){
		
		profile = p;
		
		double w = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double h = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		width = (int)w/4;
		height = (int)h/5;
		//System.out.println(2*width + "\n" + 3*height);
		
		icon = new ImageIcon("Data/Images/TopIcon2.png");
		background = new ImageIcon(new ImageIcon("Data/Images/Background 2.png").getImage().getScaledInstance(2*width, 3*height, Image.SCALE_SMOOTH));

		homeicon = new ImageIcon(new ImageIcon("Data/Images/Icons/1.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		profileicon = new ImageIcon(new ImageIcon("Data/Images/Icons/2.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		chaticon = new ImageIcon(new ImageIcon("Data/Images/Icons/4.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		settingsicon = new ImageIcon(new ImageIcon("Data/Images/Icons/5.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		logouticon = new ImageIcon(new ImageIcon("Data/Images/Icons/6.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		
		backgroundL = new JLabel();
		backgroundL.setIcon(background);
		
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
	
		
		greeting = new JLabel("Wellcome ");
		greeting.setForeground(new Color(255, 0, 0));
		greeting.setFont(new Font("Lucida Calligraphy", 0, 20));
		
		if(profile.getGender().equalsIgnoreCase("Male")){
			genderL = new JLabel("Mr. ");
		}
		
		else{
			genderL = new JLabel("Ms. ");
		}
		
		genderL.setForeground(new Color(255, 0, 0));
		genderL.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		fullname = new JLabel(profile.getFullname());
		fullname.setForeground(new Color(255, 0, 0));
		fullname.setFont(new Font("Lucida Calligraphy", 0, 16));
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(2*width, 3*height);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(icon.getImage());
		frame.setTitle("MSM EnCrypted MessEnger / Home Page");
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
		
		frame.getContentPane().add(greeting);
		greeting.setBounds(20, 60, 200, 75);
		
		frame.getContentPane().add(genderL);
		genderL.setBounds(100, 90, 300, 75);
		
		frame.getContentPane().add(fullname);
		fullname.setBounds(140, 90, 300, 75);
		
		
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
