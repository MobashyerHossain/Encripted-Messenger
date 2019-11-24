package BaseCode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import GUI.*;


public class Profile_Writer {
	
	private Profile profile;	
	
	public Profile_Writer(Profile profile){
		this.profile = profile;
	}
	
	public void CreatProfile() {
		
		Encryption en = new Encryption();
		
		String filename = new String("Data/Profiles/"+en.Encrypt(this.profile.getHandle())+".txt");
		
		try {
			File f = new File(filename);
			FileWriter w = new FileWriter(f.getAbsoluteFile());
			
			w.write(en.Encrypt(this.profile.getFullname()));
			w.write(System.getProperty( "line.separator" ));
			w.write(en.Encrypt(this.profile.getHandle()));
			w.write(System.getProperty( "line.separator" ));
			w.write(en.Encrypt(this.profile.getEmail()));
			w.write(System.getProperty( "line.separator" ));
			w.write(en.Encrypt(this.profile.getPassword()));
			w.write(System.getProperty( "line.separator" ));
			w.write(en.Encrypt(this.profile.getGender()));
			w.write(System.getProperty( "line.separator" ));
			w.write(en.Encrypt(this.profile.getDob_day()));
			w.write(System.getProperty( "line.separator" ));
			w.write(en.Encrypt(this.profile.getDob_month()));
			w.write(System.getProperty( "line.separator" ));
			w.write(en.Encrypt(this.profile.getDob_year()));
			w.write(System.getProperty( "line.separator" ));
			w.write(en.Encrypt(this.profile.getPropic()));
			
			w.close();
			
		} catch (Exception e) {
			new Error_Window(1);
		}	
						
	}		
	
}
