package BaseCode;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.management.loading.PrivateClassLoader;
import javax.sound.sampled.Port;

public class Chat_Messages {
	
	private String name;
	private String filename;
	private String fullchat = "";
	private ArrayList<String> lines;	
	
	public void Chat_Messages(){
		
	}
	
	public void Messages_Save(int p, String[] l){
		
		name = new Encryption().Encrypt2(Integer.toString(p));
		
		filename = "Data/Chat Info/" + name + ".txt";
		
		try{
			File f = new File(filename);
			
			lines = new ArrayList(Arrays.asList(l));
			
			new Write_File(lines, filename);
		}
		catch(Exception e){
			
		}		

	}
	
	public String Messages_Retrive(int p){
		
		name = new Encryption().Encrypt2(Integer.toString(p));
		
		filename = "Data/Chat Info/" + name + ".txt";
		
		try{
			File f = new File(filename);
			
			if(f.exists() == true){
				lines = new Read_File(filename).getLines();
				for(String line:lines){
					fullchat = fullchat + line + "\n";
				}				
			}
			
			else{
				fullchat = "";
			}
		}
		catch(Exception e){
			fullchat = "";
		}
		
		
		
		return fullchat;

	}

}
