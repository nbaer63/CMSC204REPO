package exceptions;
/**Exception class for not long enough
 * 
 * @author NBAER
 *
 */
public class LengthException extends Exception{
	/**Exception message for not long enough password
	 * 
	 * @param message
	 */
	public LengthException(String message) {
		super(message + " The password must be at least 6 characters in length.");
		System.out.println("The password must be at least 6 characters in length.");
	}

}
