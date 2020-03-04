package main;
/**Recipient data element class
 * 
 * @author Nick Baer
 *
 */
public class Recipient {
	private String name;
	
	/**
	 * Default constructor with default name
	 */
	public Recipient() {
		name = "";
	}
	/**Constructor that gives name to new recipient 
	 * 
	 * @param name name of recipient
	 */
	public Recipient(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
