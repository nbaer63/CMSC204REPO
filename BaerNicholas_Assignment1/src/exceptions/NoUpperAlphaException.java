package exceptions;
/**Exception class for no uppercase letter
 * 
 * @author NBAER
 *
 */
public class NoUpperAlphaException extends Exception{
	/**Exception message for no uppercase letter in password
	 * 
	 * @param message
	 */
	public NoUpperAlphaException(String message) {
		super(message + " The password must contain at least one uppercase alphabetic character.");
		System.out.println("The password must contain at least one uppercase alphabetic character.");
	}

}
