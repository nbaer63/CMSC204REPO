package exceptions;

/**Exception class for volunteer line being full or empty
 * 
 * @author NBAER
 *
 */
public class VolunteerException extends RuntimeException {

	public VolunteerException(){};
	
	public VolunteerException(String message) {
		super(message);
	}
}
