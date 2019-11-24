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

public class Setting_Sub_window implements ActionListener, MouseMotionListener {
	
	private int i;
	private int width;
	private int height;
	
	private Profile profile;
	
	private JFrame frame;
	
	private JLabel backgroundL;
	private JLabel warning;
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
	
	private JButton tickB;
	private JButton crossB;
	private JButton image;
	
	private JFileChooser propicpath;
	
	private ImageIcon icon;
	private ImageIcon background;
	private ImageIcon tick;
	private ImageIcon cross;
	
	public Setting_Sub_window(Profile p, int j){	
		
		profile = p;
		
		i = j;
		
		double w = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double h = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		width = (int)w/4;
		height = (int)h/5;
		//System.out.println(width + "\n" + height);
		
		icon = new ImageIcon("Data/Images/TopIcon2.png");
		background = new ImageIcon(new ImageIcon("Data/Images/Warning bg.png").getImage().getScaledInstance((3*width)/2, height, Image.SCALE_SMOOTH));
		
		tick = new ImageIcon(new ImageIcon("Data/Images/Icons/8.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		cross = new ImageIcon(new ImageIcon("Data/Images/Icons/9.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		
		backgroundL = new JLabel();
		backgroundL.setIcon(background);
		
		tickB = new JButton();
		tickB.setIcon(tick);
		tickB.setBorderPainted(false);
		tickB.addActionListener(this);
		tickB.setContentAreaFilled(false);
		tickB.addMouseMotionListener(this);
		tickB.setToolTipText("Confirm");
		
		crossB = new JButton();
		crossB.setIcon(cross);
		crossB.setBorderPainted(false);
		crossB.addActionListener(this);
		crossB.setContentAreaFilled(false);
		crossB.addMouseMotionListener(this);
		crossB.setToolTipText("Go Back");
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize((3*width)/2, height);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(icon.getImage());
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		if(i == 1){
			frame.setTitle("MSM EnCrypted MessEnger / De-Activating MSM Account");
			
			warning = new JLabel("Are you sure you want to De-Activate Your MSM Account???");
			warning.setForeground(new Color(255, 0, 0));
			warning.setFont(new Font("Lucida Calligraphy", 0, 14));
			
			frame.getContentPane().add(warning);
			warning.setBounds(18, 20, 480, 25);
		}
		
		else if(i == 2){
			frame.setTitle("MSM EnCrypted MessEnger / Changing Full Name");
			
			fullnameL = new JLabel("New Full Name");
			fullnameL.setForeground(new Color(255, 0, 0));
			fullnameL.setFont(new Font("Lucida Calligraphy", 0, 15));
			
			fullname = new JTextField();
			fullname.setForeground(new Color(0, 0, 0));
			fullname.setFont(new Font("Lucida Calligraphy", 0, 13));
			fullname.addActionListener(this);
			
			frame.getContentPane().add(fullnameL);
			fullnameL.setBounds(20, 20, 130, 20);
			
			frame.getContentPane().add(fullname);
			fullname.setBounds(180, 20, 300, 25);
		}
		
		else if(i == 3){
			frame.setTitle("MSM EnCrypted MessEnger / Changing Handle");
			
			handleL = new JLabel("New Handle");
			handleL.setForeground(new Color(255, 0, 0));
			handleL.setFont(new Font("Lucida Calligraphy", 0, 15));
			
			handle = new JTextField();
			handle.setForeground(new Color(0, 0, 0));
			handle.setFont(new Font("Lucida Calligraphy", 0, 13));
			handle.addActionListener(this);
			
			frame.getContentPane().add(handleL);
			handleL.setBounds(20, 20, 130, 20);
			
			frame.getContentPane().add(handle);
			handle.setBounds(180, 20, 300, 25);
		}
		
		else if(i == 4){
			frame.setTitle("MSM EnCrypted MessEnger / Changing Email");
			
			emailL = new JLabel("New Email");
			emailL.setForeground(new Color(255, 0, 0));
			emailL.setFont(new Font("Lucida Calligraphy", 0, 15));
			
			email = new JTextField();
			email.setForeground(new Color(0, 0, 0));
			email.setFont(new Font("Lucida Calligraphy", 0, 13));
			email.addActionListener(this);
			
			frame.getContentPane().add(emailL);
			emailL.setBounds(20, 20, 130, 20);
			
			frame.getContentPane().add(email);
			email.setBounds(180, 20, 300, 25);
		}
		
		else if(i == 5){
			frame.setTitle("MSM EnCrypted MessEnger / Changing Password");
			
			pass1L = new JLabel("New Password");
			pass1L.setForeground(new Color(255, 0, 0));
			pass1L.setFont(new Font("Lucida Calligraphy", 0, 15));
			
			pass2L = new JLabel("Re-Password");
			pass2L.setForeground(new Color(255, 0, 0));
			pass2L.setFont(new Font("Lucida Calligraphy", 0, 15));
			
			pass1 = new JPasswordField();
			pass1.setEchoChar('*');
			pass1.setForeground(new Color(0, 0, 0));
			pass1.setFont(new Font("Lucida Calligraphy", 0, 13));
			pass1.addActionListener(this);
			
			pass2 = new JPasswordField();
			pass2.setEchoChar('*');
			pass2.setForeground(new Color(0, 0, 0));
			pass2.setFont(new Font("Lucida Calligraphy", 0, 13));
			pass2.addActionListener(this);
			
			frame.getContentPane().add(pass1L);
			pass1L.setBounds(20, 10, 130, 20);
			
			frame.getContentPane().add(pass1);
			pass1.setBounds(180, 10, 300, 25);
			
			frame.getContentPane().add(pass2L);
			pass2L.setBounds(20, 45, 130, 20);
			
			frame.getContentPane().add(pass2);
			pass2.setBounds(180, 45, 300, 25);
		}
		
		else if(i == 6){
			frame.setTitle("MSM EnCrypted MessEnger / Changing Gender");
			
			genderL = new JLabel("New Gender");
			genderL.setForeground(new Color(255, 0, 0));
			genderL.setFont(new Font("Lucida Calligraphy", 0, 16));
			
			Mgender = new JRadioButton("Male");
			Mgender.setForeground(new Color(255, 0, 0));
			Mgender.setFont(new Font("Lucida Calligraphy", 0, 15));
			Mgender.setBorderPainted(false);
			Mgender.setContentAreaFilled(false);
			Mgender.setActionCommand("Male");
			Mgender.addMouseMotionListener(this);

			Fgender = new JRadioButton("Female");
			Fgender.setForeground(new Color(255, 0, 0));
			Fgender.setFont(new Font("Lucida Calligraphy", 0, 15));
			Fgender.setBorderPainted(false);
			Fgender.setContentAreaFilled(false);
			Fgender.setActionCommand("Female");
			Fgender.addMouseMotionListener(this);
			
			gender = new ButtonGroup();
			gender.add(Fgender);
			gender.add(Mgender);
			Mgender.setSelected(true);
			
			frame.getContentPane().add(genderL);
			genderL.setBounds(70, 20, 100, 20);
			
			frame.getContentPane().add(Mgender);
			Mgender.setBounds(250, 20, 70, 20);
			
			frame.getContentPane().add(Fgender);
			Fgender.setBounds(350, 20, 100, 20);
		}
		
		else if(i == 7){
			frame.setTitle("MSM EnCrypted MessEnger / Changing Date of Birth");
			
			dobL = new JLabel("New Date of Birth");
			dobL.setForeground(new Color(255, 0, 0));
			dobL.setFont(new Font("Lucida Calligraphy", 0, 15));
			
			String[] days = new String[31];
			for(int i = 0 ; i<31 ; i++){
				days[i] = Integer.toString(i+1);
			}
			day = new JComboBox(days);
			day.setForeground(new Color(0, 0, 0));
			day.setFont(new Font("Lucida Calligraphy", 0, 13));
			day.addMouseMotionListener(this);
			
			String[] months = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
			month = new JComboBox(months);
			month.setForeground(new Color(0, 0, 0));
			month.setFont(new Font("Lucida Calligraphy", 0, 13));
			month.addMouseMotionListener(this);
			
			String[] years = new String[61];
			for(int i = 0 ; i<61 ; i++){
				years[i] = Integer.toString(2011-i);
			}
			year = new JComboBox(years);
			year.setForeground(new Color(0, 0, 0));
			year.setFont(new Font("Lucida Calligraphy", 0, 13));
			year.addMouseMotionListener(this);
			
			frame.getContentPane().add(dobL);
			dobL.setBounds(30, 20, 150, 20);
			
			frame.getContentPane().add(day);
			day.setBounds(210, 20, 45, 25);
			
			frame.getContentPane().add(month);
			month.setBounds(275, 20, 105, 25);
			
			frame.getContentPane().add(year);
			year.setBounds(400, 20, 65, 25);
	
		}
		
		else if(i == 8){
			frame.setTitle("MSM EnCrypted MessEnger / Changing Profile Picture");
			
			propicL = new JLabel("New Profile Picture");
			propicL.setForeground(new Color(255, 0, 0));
			propicL.setFont(new Font("Lucida Calligraphy", 0, 15));
			
			propic = new JTextField();
			propic.setForeground(new Color(0, 0, 0));
			propic.setFont(new Font("Lucida Calligraphy", 0, 13));
			propic.addActionListener(this);
			
			image = new JButton("Img");
			image.setForeground(new Color(0, 0, 0));
			image.setFont(new Font("Lucida Calligraphy", 0, 12));
			image.setBorderPainted(false);
			image.addActionListener(this);
			image.addMouseMotionListener(this);
			
			frame.getContentPane().add(propicL);
			propicL.setBounds(20, 20, 180, 20);
			
			frame.getContentPane().add(propic);
			propic.setBounds(200, 20, 200, 25);
			
			frame.getContentPane().add(image);
			image.setBounds(410, 20, 70, 25);
		}

		
		frame.getContentPane().add(tickB);
		tickB.setBounds(200, 75, 40, 40);
		
		frame.getContentPane().add(crossB);
		crossB.setBounds(260, 75, 40, 40);
		
		
		frame.getContentPane().add(backgroundL);
		backgroundL.setBounds(0, 0, (3*width)/2, height);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == fullname){
			if(fullname.getText().equals("")){
				
				new Error_Window(4);
				
			}
			
			else{
				new Change_Profile_Info().change_Fullname(profile, fullname.getText());
				
				frame.dispose();
				new SignIn_Window();
			}
		}
		
		if(e.getSource() == handle){
			if(handle.getText().equals("")){
				
				new Error_Window(4);
				
			}
			
			else if(new Profile().handleMatch(handle.getText()) == true){
				
				new Error_Window(1);
				
			}
			
			else{
				new Change_Profile_Info().change_Handle(profile, handle.getText());
				
				frame.dispose();
				new SignIn_Window();
			}
		}
		
		if(e.getSource() == email){
			if(email.getText().equals("")){
				
				new Error_Window(4);
				
			}
			
			else{
				new Change_Profile_Info().change_Email(profile, email.getText());
				
				frame.dispose();
				new SignIn_Window();
			}
		}
		
		if(e.getSource() == pass1){
			pass2.requestFocus();
		}
		
		if(e.getSource() == pass2){
			if(pass1.getText().length() < 8 || pass1.getText().length() > 20){
				
				new Error_Window(5);
				
			}
			
			else if(!(pass2.getText().equals(pass1.getText()))){
				
				new Error_Window(2);
				
			}
			
			else{
				new Change_Profile_Info().change_Password(profile, pass1.getText());
				
				frame.dispose();
				new SignIn_Window();
			}
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
		
		if(e.getSource() == propic){
			if(propic.getText().equals("")){
				
				new Error_Window(4);
				
			}
			
			else{
				new Change_Profile_Info().change_Propic(profile, propic.getText());
				
				frame.dispose();
				new SignIn_Window();
			}
		}
		
		if(e.getSource() == tickB){
			
			if(i == 1){
				new Change_Profile_Info().delete_Profile(profile.getHandle());
				frame.dispose();
				new SignIn_Window();
			}
			
			else if(i == 2){
				if(fullname.getText().equals("")){
					
					new Error_Window(4);
					
				}
				
				else{
					new Change_Profile_Info().change_Fullname(profile, fullname.getText());
					
					frame.dispose();
					new SignIn_Window();
				}
			}
			
			else if(i == 3){
				if(handle.getText().equals("")){
					
					new Error_Window(4);
					
				}
				
				else if(new Profile().handleMatch(handle.getText()) == true){
					
					new Error_Window(1);
					
				}
				
				else{
					new Change_Profile_Info().change_Handle(profile, handle.getText());
					
					frame.dispose();
					new SignIn_Window();
				}
				
			}
			
			else if(i == 4){
				if(email.getText().equals("")){
					
					new Error_Window(4);
					
				}
				
				else{
					new Change_Profile_Info().change_Email(profile, email.getText());
					
					frame.dispose();
					new SignIn_Window();
				}
			}
			
			else if(i == 5){
				if(pass1.getText().length() < 8 || pass1.getText().length() > 20){
					
					new Error_Window(5);
					
				}
				
				else if(!(pass2.getText().equals(pass1.getText()))){
					
					new Error_Window(2);
					
				}
				
				else{
					new Change_Profile_Info().change_Password(profile, pass1.getText());
					
					frame.dispose();
					new SignIn_Window();
				}
			}
			
			else if(i == 6){
				String d;
				
				if(gender.getSelection().getActionCommand().equals(Mgender.getText())){
					d = Mgender.getText();
				}
				
				else{
					d = Fgender.getText();
				}
				
				new Change_Profile_Info().change_Gender(profile, d);
				
				frame.dispose();
				new SignIn_Window();
			}
			
			else if(i == 7){
				
				String a =day.getSelectedItem().toString();
				String b =month.getSelectedItem().toString();
				String c =year.getSelectedItem().toString();
				
				new Change_Profile_Info().change_DOB(profile, a, b, c);
				
				frame.dispose();
				new SignIn_Window();
			}
			
			else if(i == 8){
				if(propic.getText().equals("")){
					
					new Error_Window(4);
					
				}
				
				else{
					new Change_Profile_Info().change_Propic(profile, propic.getText());
					
					frame.dispose();
					new SignIn_Window();
				}
			}
			
		}
		
		if(e.getSource() == crossB){
			
			new Setting_Window(profile);
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
			
		if(e.getSource() == tickB){
			tickB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		if(e.getSource() == crossB){
			crossB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
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
	}

}
