package exceptions;
/**Exception class for more than 2 of the same character in a row
 * 
 * @author NBAER
 *
 */
public class InvalidSequenceException extends Exception{
	/**Exception message for more than 2 of the same character in a row in a password
	 * 
	 * @param message
	 */
	public InvalidSequenceException(String message) {
		super(message + " The password cannot contain more than two of the same character in sequence.");
		System.out.println("The password cannot contain more than two of the same character in sequence.");
	}

}
