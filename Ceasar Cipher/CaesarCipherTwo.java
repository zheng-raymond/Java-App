
public class CaesarCipherTwo {
	
	private String alphabet;
	private String shiftedAlphabet1;
	private String shiftedAlphabet2;
	private int mainKey1;
	private int mainKey2;
	
	public CaesarCipherTwo(int key1, int key2){
		alphabet = "abcdefghijklmnopqrstuvwxyz";
		shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
		shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
		mainKey1 = key1;
		mainKey2 = key2;
	}
	
	public String encrypt(String input){
		StringBuilder sb = new StringBuilder(input);
		for(int i = 0 ; i <input.length() ; i+= 2){
			/* using key1  for even index starting from 0 */
			int idx = alphabet.indexOf(Character.toLowerCase(input.charAt(i)));
			/* avoiding occur of exception of out of bound due to non-alphabet letter */
			if(idx != -1){ /* alphabet letter verified */
				if(Character.isLowerCase(input.charAt(i))){
					sb.setCharAt(i, shiftedAlphabet1.charAt(idx));
				}else if(Character.isUpperCase(input.charAt(i))){/* trivial, but more rigorous */
					sb.setCharAt(i, Character.toUpperCase(shiftedAlphabet1.charAt(idx)));
				}
				
			}
		}
		for(int i = 1; i < input.length(); i += 2){
			/* using key2 for odd index starting from 1 */
			int idx = alphabet.indexOf(Character.toLowerCase(input.charAt(i)));
			if(idx != -1){
				if(Character.isLowerCase(input.charAt(i))){
					sb.setCharAt(i, shiftedAlphabet2.charAt(idx));
				}else if(Character.isUpperCase(input.charAt(i))){/* trivial, but more rigorous */
					sb.setCharAt(i, Character.toUpperCase(shiftedAlphabet2.charAt(idx)));
				}
			}
			
		}
		return sb.toString();
	}
	
	public String decrypt(String input){
		CaesarCipherTwo ccDecrypt = new CaesarCipherTwo(26-mainKey1,26-mainKey2);
		return ccDecrypt.encrypt(input);
	}
}
