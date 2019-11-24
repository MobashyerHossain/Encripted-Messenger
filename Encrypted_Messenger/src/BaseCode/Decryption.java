package BaseCode;


public class Decryption {
	
	private StringBuilder build;
	private String decrypt;
	private int key;
	private int i;

	public Decryption(){
		
	}
	
	public String Decrypt(String text){
		
		decrypt = text;
		
		build = new StringBuilder(decrypt);
		
		build = build.reverse();
		
		for(i=0 ; i<decrypt.length() ; i++)
		{
		
			if(i%2 == 0){
				key = (int) decrypt.charAt(i);
				key = key - 4;
			}
			
			else{
				key = (int) decrypt.charAt(i);
				key = key + 4;
			}
			
			build.setCharAt(i, (char)key);
					
		}
		
		return build.toString().substring(7,build.length()-8);
	}
	
}
