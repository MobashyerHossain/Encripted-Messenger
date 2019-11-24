package BaseCode;

import java.io.File;
import java.io.FileWriter;

import GUI.Error_Window;

public class Change_Profile_Info {
	
	public Change_Profile_Info(){
		
	}
	
	public void delete_Profile(String handle){
		
		String filename = new String("Data/Profiles/" + new Encryption().Encrypt(handle) + ".txt");
		
		try {
			File f = new File(filename);
			f.delete();
			
		} catch (Exception e) {
			new Error_Window(1);
		}
		
	}
	
	public void change_Fullname(Profile profile, String fullname){
		
		String filename = new String("Data/Profiles/" + new Encryption().Encrypt(profile.getHandle()) + ".txt");
		
		try {
			File f = new File(filename);
			f.delete();
			
		} catch (Exception e) {
			new Error_Window(1);
		}
		
		profile.setFullname(fullname);
		new Profile_Writer(profile).CreatProfile();
		
	}
	
	public void change_Handle(Profile profile, String handle){
		
		String filename = new String("Data/Profiles/" + new Encryption().Encrypt(profile.getHandle()) + ".txt");
		
		try {
			File f = new File(filename);
			f.delete();
			
		} catch (Exception e) {
			new Error_Window(1);
		}
		
		profile.setHandle(handle);
		new Profile_Writer(profile).CreatProfile();
		
	}
	
	public void change_Email(Profile profile, String email){

		String filename = new String("Data/Profiles/" + new Encryption().Encrypt(profile.getHandle()) + ".txt");
		
		try {
			File f = new File(filename);
			f.delete();
			
		} catch (Exception e) {
			new Error_Window(1);
		}
		
		profile.setEmail(email);
		new Profile_Writer(profile).CreatProfile();
		
	}
	
	public void change_Password(Profile profile, String password){

		String filename = new String("Data/Profiles/" + new Encryption().Encrypt(profile.getHandle()) + ".txt");
		
		try {
			File f = new File(filename);
			f.delete();
			
		} catch (Exception e) {
			new Error_Window(1);
		}
		
		profile.setPassword(password);
		new Profile_Writer(profile).CreatProfile();
		
	}
	
	public void change_Gender(Profile profile, String gender){

		String filename = new String("Data/Profiles/" + new Encryption().Encrypt(profile.getHandle()) + ".txt");
		
		try {
			File f = new File(filename);
			f.delete();
			
		} catch (Exception e) {
			new Error_Window(1);
		}
		
		profile.setGender(gender);
		new Profile_Writer(profile).CreatProfile();
		
	}
	
	public void change_DOB(Profile profile, String day, String month, String year){

		String filename = new String("Data/Profiles/" + new Encryption().Encrypt(profile.getHandle()) + ".txt");
		
		try {
			File f = new File(filename);
			f.delete();
			
		} catch (Exception e) {
			new Error_Window(1);
		}
		
		profile.setDob_day(day);
		profile.setDob_month(month);
		profile.setDob_year(year);
		new Profile_Writer(profile).CreatProfile();
		
	}
	
	public void change_Propic(Profile profile, String propic){
		
		String filename = new String("Data/Profiles/" + new Encryption().Encrypt(profile.getHandle()) + ".txt");
		
		try {
			File f = new File(filename);
			f.delete();
			
		} catch (Exception e) {
			new Error_Window(1);
		}
		
		profile.setPropic(propic);
		new Profile_Writer(profile).CreatProfile();
		
	}
}
