package main;

import interfaces.*;

/**Generic Queue class
 * 
 * @author Nick Baer
 *
 * @param <T> generic object
 */
@SuppressWarnings("unchecked")
public class Queue<T> implements QueueInterface<T> {
	private final int dSize = 10;
	private int count;
	private T[] array;
	
	/**
	 * Two Constructors, one that creates array with the default size, and another that creates array with given size
	 */
	public Queue() {
		array = (T[]) new Object[dSize];
		count = 0;
	}
	public Queue(int size) {
		array = (T[]) new Object[size];
		count = 0;
	}
	
	/**Method to test if queue is empty
	 * @return true if queue is empty
	 * @return false if not empty
	 */
	public boolean isEmpty() {
		if (array[0] == null) {
			return true;
		}
		return false;
	}
	/**Method to test if queue is full
	 * @return true if queue is full
	 * @return false if not full
	 */
	public boolean isFull() {
		if (count == array.length) {
			return true;
		}
		return false;
	}
	/**Method to remove the element at front of queue and push the others forward
	 * @return holder the element that is being removed from front of queue
	 */
	public T dequeue() {
		if(isEmpty()) {
			return null;
		}
		int c = 0;
		T holder = array[0];
		array[0] = null;
		for(int i = 0; i < count; i++) {
			array[i] = array[i + 1];
			c++;
		}
		array[c] = null;
		count--;
		return holder;
	}
	/**Method to return size of queue
	 * @return count the size of the queue
	 */
	public int size() {
		return count;
	}
	/**Method to add an element to back of queue
	 * @return false if queue is full
	 * @return true if successfully added to queue
	 */
	public boolean enqueue(T e) {
		if (isFull()) {
			return false;
		}
		array[count] = e;
		count++;
		return true;
	
	}
	/**Method to return the queue array
	 * @return array the queue array
	 */
	public T[] toArray() {
		return array;
	}

}
