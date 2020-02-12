package utility;

import java.util.ArrayList;
import exceptions.*;
import java.lang.Character;
/**Utility class with methods that check if password follows the set rules and throws the proper exception for when there arent, and also checks for if the passwords is weak, and displays 
 * the invalid passwords in a list/file that is given
 * 
 * @author NBAER
 *
 */
public class PasswordCheckerUtility {
	/**Returns true if valid password. Throws exceptions for invalid passwords. 
	 * Valid if password is greater than or equal to 6 characters, has at least one digit, has at least on upper-case alphabetic character,
	 *  has at least on lower-case alphabetic character, and has no more than two of the same character in a row.
	 * 
	 * @param passwordString the password to be checked
	 * @return true if password is valid
	 * @throws NoDigitException throws if no digit in password
	 * @throws LengthException  throws if password isnt at least 6 characters long
	 * @throws NoUpperAlphaException throws if password doesnt have an uppercase letter
	 * @throws NoLowerAlphaException  throws if password doesnt have a lowercase letter
	 * @throws InvalidSequenceException  throws if password has a letter repeating for more than 2 times in a row
	 */
	public static boolean isValidPassword(String passwordString) throws NoDigitException, LengthException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException {
		
		boolean check = false;
		
		if (passwordString.length() < 6) {
			throw new LengthException(passwordString);
		}
		
		for(int i = 0; i < passwordString.length(); i++) {
			char charac = passwordString.charAt(i);
			if(Character.isDigit(charac)) {
				check = true;
			}
		}
		if(check != true) {
			throw new NoDigitException(passwordString);
		}
		
		check = false;
		for(int i = 0; i < passwordString.length(); i++) {
			char charac = passwordString.charAt(i);
			int characType = Character.getType(charac);
			if(characType == Character.UPPERCASE_LETTER) {
				check = true;
			}
		}
		if(check != true) {
			throw new NoUpperAlphaException(passwordString);
		}
		
		check = false;
		for(int i = 0; i < passwordString.length(); i++) {
			char charac = passwordString.charAt(i);
			int characType = Character.getType(charac);
			if(characType == Character.LOWERCASE_LETTER) {
				check = true;
			}
		}
		if(check != true) {
			throw new NoLowerAlphaException(passwordString);
		}
		
	
		
		int count = 0;
		for(int i = 0; i < passwordString.length(); i++) {
			char charac = passwordString.charAt(i);
				if(i > 0) {
				if (charac == passwordString.charAt(i - 1)) {
					count++;
				}
				else if(charac != passwordString.charAt(i - 1)){
					count = 1;
				}
				if(count > 2) {
					throw new InvalidSequenceException(passwordString);
				}
			}
		}
		
		return true;
	}
	
	/**Return true if length of password is greater than or equal to 6 but less than or equal to 9
	 * 
	 * @param passwordString password to be tested
	 * @return true if password is between or equal to 6 and 9 in length
	 */
	public static boolean isWeakPassword(String passwordString) {
		if ((passwordString.length() >= 6) && (passwordString.length() <= 9)) {
			return true;
		}
		return false;
	}
	/**Returns an arraylist of invalid passwords (weak passwords are not considered invalid)
	 * 
	 * @param passwords arraylist of passwords to be tested
	 * @return the arraylist of invalid passwords
	 */
	public static ArrayList<String> validPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<>();
		
		for(String pass : passwords) {
			try {
				isValidPassword(pass);
			}
			catch(Exception e) {
				invalidPasswords.add(e.getMessage());
			}
		}
		return invalidPasswords;
	}

}
