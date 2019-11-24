package BaseCode;

public class Handle_Unavailable {
	
	private String handle;
	private int i;
	private boolean flag = false;
		
	public Handle_Unavailable(String text){
		
		handle = new Encryption().Encrypt(text);
		
		for(i=0 ; i<handle.length() ; i++){
			
			//Spacial Charecter's that .txt file does not support
			
			if(handle.charAt(i) == (char)32 || handle.charAt(i) == (char)31 || handle.charAt(i) == (char)30 || handle.charAt(i) == (char)28 || handle.charAt(i) == (char)29  || handle.charAt(i) == (char)124 || handle.charAt(i) == (char)92 || handle.charAt(i) == (char)63 || handle.charAt(i) == (char)62 || handle.charAt(i) == (char)60 || handle.charAt(i) == (char)58 || handle.charAt(i) == (char)47 || handle.charAt(i) == (char)42 || handle.charAt(i) == (char)34){
				flag = true;

			} 
		}
		
	}
	
	public boolean h_check(){
		if(flag){
			return true;
		}
		
		else return false;
	}
}
