public class CaesarCipher {
	
	// Stores the final encoded String. Use string builder as string
	// Concatenation is a more expensive operation
	
	private StringBuilder encoded = new StringBuilder();

	public static void main(String[] args) {

		CaesarCipher caesarCipher = new CaesarCipher();
		caesarCipher.run();
	}

	public void run() {
		
		System.out.println(new CaesarCipher().cipher("abc def", 3));
		System.out.println(new CaesarCipher().cipher(
				"THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG", 3));

	}
	
	/*
	 * This method takes in a string and a shift value that adds
	 * the shift value to the original string and produces a new
	 * encoded string. 
	 * 
	 * E.g: - cipher("abc",3) = "def"
	 *  
	 */

	public String cipher(String str, int shift) {
		
		// Throw exception for null values and empty string
		if (str == null || str == "") {
			throw new IllegalArgumentException("Invalid Input");
		}
		
		
		for (int i = 0; i < str.length(); i++) {
			
			// encode the character by adding the shift value to it
			char c = (char) (str.charAt(i) + shift);
			
			// Check if it is an uppercase character or Lowercase character
			// If its not either of them, then the character is not a letter and
			// and hence we just append them. My assumption is that if the
			// character is not a letter, then we don't encode them and just append
			// the original character
			
			if (Character.isUpperCase(str.charAt(i))) {
				encodeCharacter(c, 'Z');
			} else if (Character.isLowerCase(str.charAt(i))) {
				encodeCharacter(c, 'z');
			} else {
				encoded.append((char) str.charAt(i));
			}

		}
		return encoded.toString();
	}
	
	/*
	 * This function takes in an encoded character and the last character in
	 * the english alphabet. It compares both of them to determine if there
	 * is an overflow of a character. For Example, if originalcharacter is x and
	 * we shift it by 3 times, the encoded character should be a. so If x + 3 > z,
	 * we subtract 26 from it to get the wrapped around character. 
	 * 
	 */

	private void encodeCharacter(Character encodedCharacter,
			Character lastCharacter) {
		
		if (encodedCharacter > lastCharacter) {
			encoded.append((char) (encodedCharacter - 26));
		} else {
			encoded.append((char) (encodedCharacter));
		}
	}

}
