package exceptions;
/**Exception class for no lowercase character
 * 
 * @author NBAER
 *
 */
public class NoLowerAlphaException extends Exception{
	/**Exception message for no lowercase character in password
	 * 
	 * @param message
	 */
	public NoLowerAlphaException(String message) {
		super(message + " The password must contain at least one lowercase alphabetic character.");
		System.out.println("The password must contain at least one lowercase alphabetic character.");
	}

}
