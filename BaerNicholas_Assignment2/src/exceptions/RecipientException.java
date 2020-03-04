package exceptions;

/**Exception class for recipient line being full or empty
 * 
 * @author NBAER
 *
 */
public class RecipientException extends RuntimeException {

	public RecipientException(){};
	
	public RecipientException(String message) {
		super(message);
	}
}