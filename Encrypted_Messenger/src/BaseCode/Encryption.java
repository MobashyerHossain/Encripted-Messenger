package BaseCode;

public class Encryption {
	
	private StringBuilder build;
	private String encrypt;
	private int key;
	private int i;

	public Encryption(){

	}
	
	public String Encrypt(String text){
		
		encrypt = "vampire" + text + "warewolf";
		
		build = new StringBuilder(encrypt);
		
		build = build.reverse();
		
		for(i=0 ; i<encrypt.length() ; i++)
		{
			
			if(i%2 == 0){
				key = (int) encrypt.charAt(i);
				key = key + 4;
			}
			
			else{
				key = (int) encrypt.charAt(i);
				key = key - 4;
			}
			
			build.setCharAt(i, (char)key);
					
		}
		
		return build.toString();
	}
	
	public String Encrypt2(String text){

		encrypt = text;
		
		build = new StringBuilder();
		
		for(i=0 ; i<encrypt.length() ; i++)
		{
			key = Integer.valueOf(encrypt.charAt(i));
			key = key * (i+2);
			build.append("liue");
			build.append(key);
			build.append("jdgs");
		}
		
		encrypt = build.toString();
		
		return encrypt;
	}
	
}
