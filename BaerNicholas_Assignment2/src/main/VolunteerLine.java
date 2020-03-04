package main;

import exceptions.*;
import interfaces.*;

/**Data Structure class that deals with generic queue of Volunteers
 * 
 * @author NBAER
 *
 * @param <T> generic object
 */
@SuppressWarnings("unchecked")
public class VolunteerLine<T> implements VolunteerLineInterface{
	private Queue<T> queue;
	
	/**
	 * Two Constructors, one that makes new queue with default size, and other that makes new queue with given size
	 */
	public VolunteerLine() {
		queue = new Queue<T>();
	}
	public VolunteerLine(int size) {
		queue = new Queue<T>(size);
	}
	
	/**Method that adds a new volunteer to queue
	 * @param v volunteer to be added to queue
	 * @exception VolunteerException throws if queue is full
	 * @return true if successfully added
	 */
	public boolean addNewVolunteer(Volunteer v) throws VolunteerException {
		if (queue.isFull()) {
			throw new VolunteerException("Volunteer Queue is full");
		}
		queue.enqueue((T) v);
		return true;
	}
	
	/**Method that removes volunteer at front of queue
	 * @exception VolunteerException throws if queue is empty
	 * @return Volunteer that is removed from queue
	 */
	public Volunteer volunteerTurn() throws VolunteerException {
		if (queue.isEmpty()) {
			throw new VolunteerException("Volunteer queue is empty");
		}
		return (Volunteer) queue.dequeue();
	}
	
	/**
	 * Method to test if queue is empty
	 * @return true if queue is empty
	 * @return false if not empty
	 */
	public boolean volunteerLineEmpty() {
		if(queue.isEmpty()) {
			return true;
		}
		return false;
	}

	/**Method to cast the queue array from a generic array into a Volunteer array, then returns that array
	 * @return pArray the casted array of type Volunteer
	 */
	public Volunteer[] toArrayVolunteer() {
		Volunteer[] pArray = new Volunteer[queue.toArray().length];
		for(int i = 0; i < pArray.length; i++) {
			pArray[i] = (Volunteer) queue.toArray()[i];
		}
		return pArray;
	}

}
