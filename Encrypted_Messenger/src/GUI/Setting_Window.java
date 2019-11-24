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

public class Setting_Window implements ActionListener, MouseMotionListener {
	
	private Profile profile;
	
	private int width;
	private int height;
	
	private JFrame frame;
	
	private JLabel backgroundL;
	private JLabel helpL;
	
	private JButton homeB;
	private JButton profileB;
	private JButton chatB;
	private JButton settingsB;
	private JButton logoutB;
	private JButton helpB;
	
	private JRadioButton deactivate;
	private JRadioButton changeName;
	private JRadioButton changeHandle;	
	private JRadioButton changeEmail;
	private JRadioButton changePassword;
	private JRadioButton changeGender;
	private JRadioButton changeDob;
	private JRadioButton changePropic;
	
	private ButtonGroup options;
	
	private ImageIcon icon;
	private ImageIcon background;
	private ImageIcon help;
	
	private ImageIcon homeicon;
	private ImageIcon profileicon;
	private ImageIcon chaticon;
	private ImageIcon settingsicon;
	private ImageIcon logouticon;
	
	public Setting_Window(Profile p){
		
		profile = p;
		
		double w = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double h = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		width = (int)w/4;
		height = (int)h/5;
		//System.out.println(2*width + "\n" + 3*height);
		
		icon = new ImageIcon("Data/Images/TopIcon2.png");
		background = new ImageIcon(new ImageIcon("Data/Images/Background 2.png").getImage().getScaledInstance(2*width, 3*height, Image.SCALE_SMOOTH));
		
		help = new ImageIcon(new ImageIcon("Data/Images/Icons/10.png").getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH));
		
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
		
		helpL = new JLabel("What can we Help you with?");
		helpL.setForeground(new Color(255, 0, 0));
		helpL.setFont(new Font("Lucida Calligraphy", 0, 17));
		
		deactivate = new JRadioButton("Deactivate my MSM Account");
		deactivate.setForeground(new Color(255, 0, 0));
		deactivate.setFont(new Font("Lucida Calligraphy", 0, 15));
		deactivate.setBorderPainted(false);
		deactivate.setContentAreaFilled(false);
		deactivate.setActionCommand("1");
		deactivate.addMouseMotionListener(this);
		
		changeName = new JRadioButton("Change my Name");
		changeName.setForeground(new Color(255, 0, 0));
		changeName.setFont(new Font("Lucida Calligraphy", 0, 15));
		changeName.setBorderPainted(false);
		changeName.setContentAreaFilled(false);
		changeName.setActionCommand("2");
		changeName.addMouseMotionListener(this);
		
		changeHandle = new JRadioButton("Change my Handle");
		changeHandle.setForeground(new Color(255, 0, 0));
		changeHandle.setFont(new Font("Lucida Calligraphy", 0, 15));
		changeHandle.setBorderPainted(false);
		changeHandle.setContentAreaFilled(false);
		changeHandle.setActionCommand("3");
		changeHandle.addMouseMotionListener(this);
		
		changeEmail = new JRadioButton("Change my Email");
		changeEmail.setForeground(new Color(255, 0, 0));
		changeEmail.setFont(new Font("Lucida Calligraphy", 0, 15));
		changeEmail.setBorderPainted(false);
		changeEmail.setContentAreaFilled(false);
		changeEmail.setActionCommand("4");
		changeEmail.addMouseMotionListener(this);
		
		changePassword = new JRadioButton("Change my Password");
		changePassword.setForeground(new Color(255, 0, 0));
		changePassword.setFont(new Font("Lucida Calligraphy", 0, 15));
		changePassword.setBorderPainted(false);
		changePassword.setContentAreaFilled(false);
		changePassword.setActionCommand("5");
		changePassword.addMouseMotionListener(this);
		
		changeGender = new JRadioButton("Change my Gender");
		changeGender.setForeground(new Color(255, 0, 0));
		changeGender.setFont(new Font("Lucida Calligraphy", 0, 15));
		changeGender.setBorderPainted(false);
		changeGender.setContentAreaFilled(false);
		changeGender.setActionCommand("6");
		changeGender.addMouseMotionListener(this);
		
		changeDob = new JRadioButton("Change my Date of Birth");
		changeDob.setForeground(new Color(255, 0, 0));
		changeDob.setFont(new Font("Lucida Calligraphy", 0, 15));
		changeDob.setBorderPainted(false);
		changeDob.setContentAreaFilled(false);
		changeDob.setActionCommand("7");
		changeDob.addMouseMotionListener(this);
		
		changePropic = new JRadioButton("Change my Profile Picture");
		changePropic.setForeground(new Color(255, 0, 0));
		changePropic.setFont(new Font("Lucida Calligraphy", 0, 15));
		changePropic.setBorderPainted(false);
		changePropic.setContentAreaFilled(false);
		changePropic.setActionCommand("8");
		changePropic.addMouseMotionListener(this);
		
		options = new ButtonGroup();
		options.add(deactivate);
		options.add(changeName);
		options.add(changeHandle);
		options.add(changeEmail);
		options.add(changePassword);
		options.add(changeGender);
		options.add(changeDob);
		options.add(changePropic);
		deactivate.setSelected(true);
		
		helpB = new JButton();
		helpB.setIcon(help);
		helpB.setBorderPainted(false);
		helpB.addActionListener(this);
		helpB.setContentAreaFilled(false);
		helpB.addMouseMotionListener(this);
		helpB.setToolTipText("Fix");
		
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(2*width, 3*height);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(icon.getImage());
		frame.setTitle("MSM EnCrypted MessEnger / Settings");
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
		
		frame.getContentPane().add(helpL);
		helpL.setBounds(20, 70, 400, 25);
		
		frame.getContentPane().add(deactivate);
		deactivate.setBounds(20, 110, 280, 25);
		
		frame.getContentPane().add(changeName);
		changeName.setBounds(20, 140, 200, 25);
		
		frame.getContentPane().add(changeHandle);
		changeHandle.setBounds(20, 170, 200, 25);
		
		frame.getContentPane().add(changeEmail);
		changeEmail.setBounds(20, 200, 200, 25);
		
		frame.getContentPane().add(changePassword);
		changePassword.setBounds(20, 230, 200, 25);
		
		frame.getContentPane().add(changeGender);
		changeGender.setBounds(20, 260, 200, 25);
		
		frame.getContentPane().add(changeDob);
		changeDob.setBounds(20, 290, 250, 25);
		
		frame.getContentPane().add(changePropic);
		changePropic.setBounds(20, 320, 250, 25);
		
		frame.getContentPane().add(helpB);
		helpB.setBounds(270, 170, 55, 55);
		
		
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
		
		if(e.getSource() == helpB){
			
			if(options.getSelection().getActionCommand().equals("1")){
				new Setting_Sub_window(profile, 1);
				frame.dispose();
			}
			
			else if(options.getSelection().getActionCommand().equals("2")){
				new Setting_Sub_window(profile, 2);
				frame.dispose();
			}
			
			else if(options.getSelection().getActionCommand().equals("3")){
				new Setting_Sub_window(profile, 3);
				frame.dispose();
			}
			
			else if(options.getSelection().getActionCommand().equals("4")){
				new Setting_Sub_window(profile, 4);
				frame.dispose();
			}
			
			else if(options.getSelection().getActionCommand().equals("5")){
				new Setting_Sub_window(profile, 5);
				frame.dispose();
			}
			
			else if(options.getSelection().getActionCommand().equals("6")){
				new Setting_Sub_window(profile, 6);
				frame.dispose();
			}
			
			else if(options.getSelection().getActionCommand().equals("7")){
				new Setting_Sub_window(profile, 7);
				frame.dispose();
			}
			
			else if(options.getSelection().getActionCommand().equals("8")){
				new Setting_Sub_window(profile, 8);
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
		
		if(e.getSource() == deactivate){
			deactivate.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == changeName){
			changeName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == changeHandle){
			changeHandle.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == changeEmail){
			changeEmail.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == changePassword){
			changePassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == changeGender){
			changeGender.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == changeDob){
			changeDob.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == changePropic){
			changePropic.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == helpB){
			helpB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
	}

}
