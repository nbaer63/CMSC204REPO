package exceptions;
/**Exception class for no digits
 *  
 * @author NBAER
 *
 */
public class NoDigitException extends Exception{
	/**Exception message for no digits
	 * 
	 * @param message
	 */
	public NoDigitException(String message) {
		super(message + " The password must contain at least one digit.");
		System.out.println("The password must contain at least one digit.");
	}

}
