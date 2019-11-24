package BaseCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import GUI.*;

public class Chat_Room_Server{
	
	private Profile profile;
	private String ip;
	private int port;

    ArrayList clientOutputStreams;
    ArrayList<String> users;
	
	public Chat_Room_Server(Profile p, int i, String k){

		profile = p;
		port = i;
		ip = k;	
		
        Setap_Chat_Room();
				
	}
	
	public void Setap_Chat_Room(){
		
		Start();
		
		new Chat_Window_Client(profile, port, ip);
		
	}
	
	public class Accept_Clients implements Runnable{
		
	       BufferedReader reader;
	       Socket sock;
	       PrintWriter client;

	       public Accept_Clients(Socket clientSocket, PrintWriter user){
	    	   
	            client = user;
	            
	            try{
	                sock = clientSocket;
	                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
	                reader = new BufferedReader(isReader);
	            }
	            catch (Exception ex){
	                
	            }

	       }

	       public void run(){
	    	   
	            String message;
	            String[] data;

	            try{
	                while ((message = reader.readLine()) != null){
	                	
	                    data = message.split(":");

	                    if (data[2].equals("Connect")) 
	                    {
	                    	Send_to_Everyone(data[0] + ":" + data[1] + ":" + "Chat");
	                        Add_Users(data[0]);
	                    } 
	                    else if (data[2].equals("Disconnect")) 
	                    {
	                    	Send_to_Everyone(data[0] + " has disconnected.");
	                        Remove_Users(data[0]);
	                    } 
	                    else if (data[2].equals("Chat")) 
	                    {
	                    	Send_to_Everyone(message);
	                    } 
	                } 
	             } 
	             catch (Exception ex){
	                ex.printStackTrace();
	                clientOutputStreams.remove(client);
	             } 
	       }
	}

	private void Start(){
		
        Thread starter = new Thread(new Start_Chat());
        starter.start();
    }
	
	public class Start_Chat implements Runnable{
		
		@Override
	    public void run(){
			
			clientOutputStreams = new ArrayList();
	        users = new ArrayList();  

	        try{
	        	ServerSocket serverSock = new ServerSocket(port);

	            while (true){
	            	Socket clientSocket = serverSock.accept();
					PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
					clientOutputStreams.add(writer);

					Thread listener = new Thread(new Accept_Clients(clientSocket, writer));
					listener.start();
	            }
	        }
	        catch (Exception ex){
	        	
	        }
	    }
	}
	
	public void Add_Users(String data){
		
        String message;
        String add = ": :Connect";
        String done = "Server: :Done";
        String name = data;
        
        users.add(name);
        
        String[] tempList = new String[(users.size())];
        
        users.toArray(tempList);

        for(String user : tempList){
            message = (user + add);
            Send_to_Everyone(message);
        }
        
        Send_to_Everyone(done);
    }
	
	public void Remove_Users(String data){
		
		String message;
        String add = ": :Connect";
        String done = "Server: :Done";
        String name = data;
        
        users.remove(name);
        
        String[] tempList = new String[(users.size())];
        
        users.toArray(tempList);

        for (String user:tempList){
            message = (user + add);
            Send_to_Everyone(message);
        }
        
        Send_to_Everyone(done);
    }
	
	public void Send_to_Everyone(String message){
		
		Iterator line = clientOutputStreams.iterator();

        while (line.hasNext()){
        	
            try{
                PrintWriter writer = (PrintWriter)line.next();
                writer.println(message);
                
                writer.flush();

            } 
            catch (Exception ex){
            	
            }
        } 
    }

}

