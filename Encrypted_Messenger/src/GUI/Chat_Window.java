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

public class Chat_Window implements ActionListener, MouseMotionListener {
	
	private Profile profile;
	
	private int width;
	private int height;
	private int k;
	
	private JFrame frame;
	
	private JLabel backgroundL;
	private JLabel portL;
	private JLabel ipL;
	
	private JTextField portT;
	private JTextField ipT;
	
	private JButton homeB;
	private JButton profileB;
	private JButton chatB;
	private JButton settingsB;
	private JButton logoutB;
	private JButton createB;
	private JButton joinB;
	private JButton startB;	
	
	private ImageIcon icon;
	private ImageIcon background;
	
	private ImageIcon homeicon;
	private ImageIcon profileicon;
	private ImageIcon chaticon;
	private ImageIcon settingsicon;
	private ImageIcon logouticon;
	
	public Chat_Window(Profile p){
		
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
		
		portL = new JLabel("Chat Room ID");
	    portL.setForeground(new Color(255, 0, 0));
		portL.setFont(new Font("Lucida Calligraphy", 0, 14));
		portL.setVisible(false);
	        
	    portT = new JTextField();
	    portT.setText("2222");
	    portT.setForeground(new Color(0, 0, 0));
		portT.setFont(new Font("Lucida Calligraphy", 0, 14));
		portT.setVisible(false);
		
		ipL = new JLabel("Chat Room Host IP");
        ipL.setForeground(new Color(255, 0, 0));
		ipL.setFont(new Font("Lucida Calligraphy", 0, 14));
		ipL.setVisible(false);
        
        ipT = new JTextField();
        ipT.setText("localhost");
        ipT.setForeground(new Color(0, 0, 0));
		ipT.setFont(new Font("Lucida Calligraphy", 0, 14));
		ipT.setVisible(false);
		
		createB = new JButton();
		createB.setText("Create a Chat Room");
		createB.setBorderPainted(false);
		createB.addActionListener(this);
		createB.addMouseMotionListener(this);
		
		joinB = new JButton();
		joinB.setText("Join a Chat Room");
		joinB.setBorderPainted(false);
		joinB.addActionListener(this);
		joinB.addMouseMotionListener(this);
		
		startB = new JButton();
		startB.setText("Start Chatting");
		startB.setBorderPainted(false);
		startB.addActionListener(this);
		startB.addMouseMotionListener(this);
		startB.setVisible(false);
		

		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(2*width, 3*height);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(icon.getImage());
		frame.setTitle("MSM EnCrypted MessEnger / Chat");
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
		
		frame.getContentPane().add(portL);
        portL.setBounds(30, 100, 170, 25);
        
        frame.getContentPane().add(portT);
        portT.setBounds(200, 100, 150, 25);
        
        frame.getContentPane().add(ipL);
        ipL.setBounds(30, 140, 170, 25);
        
        frame.getContentPane().add(ipT);
        ipT.setBounds(200, 140, 150, 25);
		
		frame.getContentPane().add(createB);
		createB.setBounds(20, 200, 150, 25);
		
		frame.getContentPane().add(joinB);
		joinB.setBounds(200, 200, 150, 25);
		
		frame.getContentPane().add(startB);
		startB.setBounds(120, 200, 130, 25);

		
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
		
		if(e.getSource() == createB){
			k = 1;
			
			createB.setVisible(false);
			joinB.setVisible(false);
			portL.setVisible(true);
			portT.setVisible(true);
			startB.setVisible(true);
			
		}
		
		if(e.getSource() == joinB){
			k = 2;
			
			createB.setVisible(false);
			joinB.setVisible(false);
			portL.setVisible(true);
			portT.setVisible(true);
			ipL.setVisible(true);
			ipT.setVisible(true);
			startB.setVisible(true);
			
		}
		
		if(e.getSource() == startB){
			if(portT.getText().equals("") || ipT.getText().equals("") || portT.getText().length() != 4){
				new Error_Window(6);
			}
			
			else{
				if(k == 1){
					frame.dispose();
					new Chat_Room_Server(profile, Integer.parseInt(portT.getText()), ipT.getText());					
				}
				
				else if(k == 2){
					new Chat_Window_Client(profile, Integer.parseInt(portT.getText()), ipT.getText());
					frame.dispose();
				}
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
		
		if(e.getSource() == createB){
			createB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == joinB){
			joinB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		
	}

}
