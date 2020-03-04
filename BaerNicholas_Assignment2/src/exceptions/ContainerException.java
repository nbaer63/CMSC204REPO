package exceptions;

/**Exception class for container being full or empty
 * 
 * @author NBAER
 *
 */
public class ContainerException extends RuntimeException {

	public ContainerException(){};
	
	public ContainerException(String message) {
		super(message);
	}
}