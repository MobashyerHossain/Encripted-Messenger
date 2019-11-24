package BaseCode;

import java.io.File;
import java.util.Scanner;

public class Profile {
	
	private String fullname;
	private String handle;
	private String email;
	private String password;
	private String gender;
	private String dob_day;
	private String dob_month;
	private String dob_year;
	private String propic;
	
	
	public Profile(String fullname, String handle, String email, String password, String gender, String dob_day, String dob_month, String dob_year, String propic) {

		this.fullname = fullname;
		this.handle = handle;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.dob_day = dob_day;
		this.dob_month = dob_month;
		this.dob_year = dob_year;
		this.propic = propic;
		
	}
	
	public Profile(){
		
	}


	public String getFullname() {
		return fullname;
	}


	public String getHandle() {
		return handle;
	}


	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}


	public String getGender() {
		return gender;
	}


	public String getDob_day() {
		return dob_day;
	}


	public String getDob_month() {
		return dob_month;
	}


	public String getDob_year() {
		return dob_year;
	}
	
	public String getPropic() {
		return propic;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public void setHandle(String handle) {
		this.handle = handle;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public void setDob_day(String dob_day) {
		this.dob_day = dob_day;
	}


	public void setDob_month(String dob_month) {
		this.dob_month = dob_month;
	}


	public void setDob_year(String dob_year) {
		this.dob_year = dob_year;
	}
	
	public void setPropic(String propic) {
		this.propic = propic;
	}
	
	
	public Boolean handleMatch(String handle){
		
		if(new Handle_Unavailable(handle).h_check() == true){
			return true;
			
		}
		
		else{
			Encryption en = new Encryption();
			
			String filename = new String("Data/Profiles/"+en.Encrypt(handle)+".txt");
			
			try {
				File f = new File(filename);
				Scanner s = new Scanner(f);
				
				s.nextLine();
				String h = s.nextLine();
				
				s.close();
				
				if(h.equals(en.Encrypt(handle)) == true){
					return true;
				}
				
				else{
					return false;
				}
									
				
			} catch (Exception e) {
				return false;
			}
		}
		
	}
	
	
	public Boolean passwordMatch(String handle, String password){
		
		Encryption en = new Encryption();
		
		String filename = new String("Data/Profiles/"+en.Encrypt(handle)+".txt");
		
		try {
			File f = new File(filename);
			Scanner s = new Scanner(f);
			
			s.nextLine();
			s.nextLine();
			s.nextLine();
			String p = s.nextLine();
			
			s.close();
			
			if(p.equals(en.Encrypt(password)) == true){
				return true;
			}
			
			else{
				return false;
			}
							
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean Propic_Check(String propic){
		
		String filename = propic;
		File f = new File(filename);
		if(f.exists() == true){
			return true;
		}
		
		else return false;
	}
			
	
}
