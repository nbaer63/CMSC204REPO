package main;
/**DonationPackage data element class
 * 
 * @author Nick Baer
 *
 */
public class DonationPackage {
	private String description;
	private double weight;
	
	/**Default constructor for DonationPackage
	 * 
	 */
	public DonationPackage() {
		description = "";
		weight = 0.0;
	}
	/**Constructor for DonationPackage that takes a description and weight to assign to 
	 * @param description information of the package
	 * @param weight the weight of package
	 */
	public DonationPackage(String description,double weight) {
		this.description = description;
		this.weight = weight;
	}
	/**Method to see if package weight is over 20
	 * 
	 * @return true if package is over 20 
	 * @return false if package is not over 20
	 */
	public boolean isHeavy() {
		if (weight >= 20.0) {
			return true;
		}
		return false;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
