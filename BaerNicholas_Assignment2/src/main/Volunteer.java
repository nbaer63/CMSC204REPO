package main;

/**Volunteer data element class
 * 
 * @author Nick Baer
 *
 */
public class Volunteer {
	private String name;
	/**
	 * Default constructor with default name
	 */
	public Volunteer() {
		name = "";
	}
	/**Constructor that gives name to volunteer
	 * 
	 * @param name name of volunteer
	 */
	public Volunteer(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
