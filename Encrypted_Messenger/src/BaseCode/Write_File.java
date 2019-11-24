package BaseCode;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;

import GUI.Error_Window;

public class Write_File {
	
	private String filename;
	private ArrayList<String> lines = new ArrayList();
	
	public Write_File(ArrayList<String> l, String name){
		lines = l;
		filename = name;
		
		try {
			File f = new File(filename);
			FileWriter w = new FileWriter(f);
			
			for(String line:lines){
				w.write(new Encryption().Encrypt(line));
				w.write(System.getProperty( "line.separator" ));
			}

			w.close();
			
		}
		catch(Exception e){

		}
		
	}
	
}
