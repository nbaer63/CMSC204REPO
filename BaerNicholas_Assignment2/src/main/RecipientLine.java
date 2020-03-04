package main;

import exceptions.*;
import interfaces.*;

/**Data Structure class that deals with generic queue of Recipient
 * 
 * @author Nick Baer
 *
 * @param <T> generic object
 */
@SuppressWarnings("unchecked")
public class RecipientLine<T> implements RecipientLineInterface{
	private Queue<T> queue;
	
	/**
	 * Two Constructors, one that makes new queue with default size, and other that makes new queue with given size
	 */
	public RecipientLine() {
		queue = new Queue<T>();
	}
	public RecipientLine(int size) {
		queue = new Queue<T>(size);
	}
	
	/**Method that adds a new recipient to queue
	 * @param rc recipient to be added to queue
	 * @exception RecipientException throws if queue is full
	 * @return true if successfully added
	 */
	public boolean addNewRecipient(Recipient rc) throws RecipientException {
		if (queue.isFull()) {
			throw new RecipientException("Recipient Queue is full");
		}
		queue.enqueue((T) rc);
		return true;
	}
	/**Method that removes recipient at front of queue
	 * @exception RecipientException throws if queue is empty
	 * @return Recipient that is removed from queue
	 */
	public Recipient recipientTurn() throws RecipientException {
		if (queue.isEmpty()) {
			throw new RecipientException("Recipient queue is empty");
		}
		return (Recipient) queue.dequeue();
	}
	/**Method to test if queue is empty
	 * @return true if queue is empty
	 * @return false if not empty
	 */
	public boolean recipientLineEmpty() {
		if(queue.isEmpty()) {
			return true;
		}
		return false;
	}
	/**Method to cast the queue array from a generic array into a Recipient array, then returns that array
	 * @return pArray the casted array of type Recipient
	 */
	public Recipient[] toArrayRecipient() {
		Recipient[] pArray = new Recipient[queue.toArray().length];
		for(int i = 0; i < pArray.length; i++) {
			pArray[i] = (Recipient) queue.toArray()[i];
		}
		return pArray;
	}

}
