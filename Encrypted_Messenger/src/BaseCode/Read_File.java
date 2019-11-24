package BaseCode;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.SystemException;

import GUI.SignIn_Window;

public class Read_File {
	
	private String filename;
	private ArrayList<String> lines = new ArrayList();

	public Read_File(String file){
		
		filename = file;
		
		try {
			File f = new File(filename);
			Scanner s = new Scanner(f);
			
			while(s.hasNextLine() == true){
				lines.add(new Decryption().Decrypt(s.nextLine()));
			}
			
			s.close();
			
		}
		catch(Exception e){

		}
		
	}
	
	public ArrayList<String> getLines(){
		
		return lines;
	}

}

	
