package exceptions;
/**Exception class for when password entered in GUI are not the same
 * 
 * @author NBAER
 *
 */
public class UnmatchedException extends Exception{
	/**Exception message for when passwords dont match
	 * 
	 * @param message
	 */
	public UnmatchedException(String message) {
		super(message + " The passwords do not match.");
		System.out.println("The passwords do not match.");
	}
	/**Exception message for when passwords dont match
	 * 
	 */
	public UnmatchedException() {
		super("The passwords do not match.");
		System.out.println("The passwords do not match.");
	}
}
