package main;

import exceptions.*;
import interfaces.*;
/**Data Manager class that manages all the other data classes and interacts with the GUI
 * 
 * @author Nick Baer
 *
 * @param <T> generic object
 */
public class DonationManager<T> implements DonationManagerInterface {
	Container<T> container;
	RecipientLine<T> rLine;
	VolunteerLine<T> vLine;
	
	/**
	 * Two Constructors, one that takes no paramaters and creates a new container,recipientline, and volunteerline with default values, and another that takes a size and creates them with that size
	 */
	public DonationManager() {
		container = new Container<T>();
		rLine = new RecipientLine<T>();
		vLine = new VolunteerLine<T>();
	}
	public DonationManager(int size) {
		container = new Container<T>(size);
		rLine = new RecipientLine<T>(size);
		vLine = new VolunteerLine<T>(size);
	}
	
	/**Method to load a donation package into the container
	 * @param dPackage package to be added to container
	 * @exception ContainerException throws if container is full
	 * @return true if successfully added
	 */
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		container.loadContainer(dPackage);
		return true;
	}
	/**Method to put volunteer into the volunteer line
	 * @param v volunteer to be added to line
	 * @exception VolunteerException throws if line is full
	 * @return true if successfully added
	 */
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		vLine.addNewVolunteer(v);
		return true;
	}
	/**Method to put recipient into the recipient line
	 * @param r recipient to be added to line
	 * @exception RecipientException throws if line is full
	 * @return true if successfully added
	 */
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		rLine.addNewRecipient(r);
		return true;
	}
	/**Method that will take a package from the top of the container and assign the volunteer at the front to help give to recipient at front, then put volunteer at end of line
	 * @exception VolunteerException throws if volunteer line is empty
	 * @exception ContainerException throws if container is empty
	 * @exception RecipientException throws if recipient line is empty
	 * @return 0 if successfully added
	 */
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		container.removePackageFromContainer();
		vLine.addNewVolunteer(vLine.volunteerTurn());
		rLine.recipientTurn();
		return 0;
	}
	
	/**Method to return the container array casted as a DonationPackage array
	 * @return array casted as DonationPackage array
	 */
	public DonationPackage[] managerArrayPackage() {
		return container.toArrayPackage();
	}
	/**Method to return the volunteer line array casted as a Volunteer array
	 * @return array casted as Volunteer array
	 */
	public Volunteer[] managerArrayVolunteer() {
		return vLine.toArrayVolunteer();
	}
	/**Method to return the recipient line array casted as a Recipient array
	 * @return array casted as Recipient array
	 */
	public Recipient[] managerArrayRecipient() {
		return rLine.toArrayRecipient();
	}

}
