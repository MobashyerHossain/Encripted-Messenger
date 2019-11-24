package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.*;

import org.w3c.dom.UserDataHandler;

import BaseCode.*;

public class Chat_Window_Client implements ActionListener, MouseMotionListener {
	
	private Profile profile;
	
	private String[] chat;
	private String username;
	private String ip;
	
	private Boolean isConnected = false;
	
	private int width;
	private int height;
	private int port;
	
	private JFrame frame;
	
	private JLabel backgroundL;
    
    private JTextArea chatA;

    private JTextField messageT;

	private JButton homeB;
	private JButton profileB;
	private JButton chatB;
	private JButton settingsB;
	private JButton logoutB;
    private JButton sendB;
	
	private ImageIcon icon;
	private ImageIcon background;
	
	private ImageIcon homeicon;
	private ImageIcon profileicon;
	private ImageIcon chaticon;
	private ImageIcon settingsicon;
	private ImageIcon logouticon;
	private ImageIcon sendicon;
	
	private JScrollPane scroll;

    ArrayList<String> users = new ArrayList();
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
	
	public Chat_Window_Client(Profile p, int i, String k){

		profile = p;
		port = i;
		ip = k;
		
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
		
		sendicon = new ImageIcon(new ImageIcon("Data/Images/Icons/13.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		
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
		      
        sendB = new JButton();
        sendB.setIcon(sendicon);
        sendB.setBorderPainted(false);
        sendB.addActionListener(this);
        sendB.setContentAreaFilled(false);
        sendB.addMouseMotionListener(this);
        sendB.setToolTipText("Send");

        chatA = new JTextArea();
        chatA.setEditable(false);
        chatA.setForeground(new Color(255, 0, 0));
        
        scroll = new JScrollPane(chatA);
        
        messageT = new JTextField();
        messageT.setForeground(new Color(0, 0, 0));
        messageT.addActionListener(this);
        
        
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(2*width, 3*height);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(icon.getImage());
		frame.setTitle("MSM EnCrypted MessEnger / Chat Room ID " + Integer.toString(port) + " / User ID "+ profile.getFullname());
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.add(scroll);
		
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
        
        frame.getContentPane().add(scroll);
        scroll.setBounds(20, 60, 350, 280);
        
        frame.getContentPane().add(messageT);
        messageT.setBounds(20, 360, 310, 25);
        
        frame.getContentPane().add(sendB);
        sendB.setBounds(345, 360, 25, 25);
        

		frame.getContentPane().add(backgroundL);
		backgroundL.setBounds(0, 0, 2*width, 3*height);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Connected();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == homeB){
			Disconnected();			
			new Homepage_Window(profile);
			frame.dispose();
		}
		
		if(e.getSource() == profileB){
			Disconnected();
			new Profile_Window(profile);
			frame.dispose();
		}
		
		if(e.getSource() == chatB){
			Disconnected();
			new Chat_Window(profile);
			frame.dispose();
		}
		
		if(e.getSource() == settingsB){
			Disconnected();
			new Setting_Window(profile);
			frame.dispose();
		}
		
		if(e.getSource() == logoutB){
			Disconnected();
			new SignIn_Window();
			frame.dispose();
		}
		
		if(e.getSource() == messageT){
			Send();
		}
		
		if(e.getSource() == sendB){
			Send();		
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
		
		if(e.getSource() == sendB){
			sendB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

	}
	
	public void Save_Chat(){
   	 	chat = chatA.getText().split("\n");
   	 	new Chat_Messages().Messages_Save(port, chat);
	}
	
	public class Recieve_Message implements Runnable{
    	
        @Override
        public void run(){
        	
            String[] data;
            String stream;
            
            try{
                while ((stream = reader.readLine()) != null){
                     data = stream.split(":");
                     if (data[2].equals("Chat")){
                    	 
                    	 chatA.append(data[0] + ": " + data[1] + "\n");
                    	 chatA.setCaretPosition(chatA.getDocument().getLength());
                    	 
                    	 Save_Chat();
                     } 

                     else if (data[2].equals("Connect")){
                    	 
                    	 chatA.removeAll();
                    	 Add_Users(data[0]);
                     } 
                     
                     else if (data[2].equals("Disconnect")){
                    	 
                    	 Remove_Users(data[0]);
                     }
                     
                     else if (data[2].equals("Done")){
                    	 
                        Users();
                        users.clear();
                     }

                }
           }
           catch(Exception ex){
        	   
           }
        }
    }
    
    private void Connected(){
    	
        if(isConnected == false){
        	
            username = profile.getHandle() + " ";

            try{
                sock = new Socket(ip, port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                
                writer = new PrintWriter(sock.getOutputStream());
                writer.println("\t" + username + ": Joined the Chat Room :Connect");
                writer.flush(); 
                
                isConnected = true; 
            } 
            catch (Exception ex){
            	No_ChatRoom_Found();
            }
           
            chatA.setText(new Chat_Messages().Messages_Retrive(port));
            Start();  
        } 
        
        else if(isConnected == true){
            chatA.append("You are already connected.\n");
        }
    }
    
    private void No_ChatRoom_Found(){
    	frame.dispose();
    	new Chat_Window(profile);
    	new Error_Window(7);
    }
    
    private void Disconnected(){
        Send_Disconnect();
        Disconnect();
    }
    
    private void Send(){    	
        if ((messageT.getText()).equals("")){
            messageT.requestFocus();
        }
        
        else{
        	
            try{
               writer.println(username + ": " + messageT.getText() + ":" + "Chat");
               writer.flush(); 
               
            }
            catch (Exception ex){
                chatA.append("Message could not be sent.\n");
            }
            messageT.setText("");
            messageT.requestFocus();
        }

    }
    
    public void Start(){
 
        new Thread(new Recieve_Message()).start();

    }
    
    
    public void Add_Users(String data){
    	
         users.add(data);
    }
    
    
    public void Remove_Users(String data){
    	
         chatA.append(data + " is now offline.\n");
    }
    
    
    public void Users(){
    	
         String[] tempList = new String[(users.size())];
         users.toArray(tempList);
    }
    
    
    public void Send_Disconnect(){
    	
        String bye = (username + ": :Disconnect");
        
        try{
            writer.println(bye); 
            writer.flush(); 
        }
        catch (Exception e){
            chatA.append("Could not send Disconnect message.\n");
        }
    }

    
    public void Disconnect(){
    	
        try{
            chatA.append("Disconnected.\n");
            sock.close();
        }
        catch(Exception ex){
            chatA.append("Failed to disconnect. \n");
        }
        
        isConnected = false;

    }


}
