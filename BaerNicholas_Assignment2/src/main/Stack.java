package main;

import interfaces.*;

/**Generic Stack class
 * 
 * @author Nick Baer
 *
 * @param <T> generic object
 */
@SuppressWarnings("unchecked")
public class Stack<T> implements StackInterface<T> {
	private final int dSize = 10;
	private int count;
	private T[] array;
	
	/**
	 * Two Constructors, one that creates array with the default size, and another that creates array with given size
	 */
	public Stack() {
		array = (T[]) new Object[dSize];
		count = 0;
	}
	public Stack(int size) {
		array = (T[]) new Object[size];
		count = 0;
	}
	
	/**Method to test if stack is empty
	 * @return true if stack is empty
	 * @return false if not empty
	 */
	public boolean isEmpty() {
		if (array[0] == null) {
			return true;
		}
		return false;
	}
	/**Method to test if stack is full
	 * @return true if stack is full
	 * @return false if not full
	 */
	public boolean isFull() {
		if (count == array.length) {
			return true;
		}
		return false;
	}
	/**Method that will remove and return the element at the top of array, the last element
	 * @return holder the element that is removed from stack
	 */
	public T pop() {
		if(isEmpty()) {
			return null;
		}
		T holder = array[count - 1];
		array[count - 1] = null;
		count--;
		return holder;
	}
	
	/**Method to return size of queue
	 * @return count the size of the queue
	 */
	public int size() {
		return count;
	}

	/**Method to add an element to top of stack
	 * @return false if stack is full
	 * @return true if successfully added to stack
	 */
	public boolean push(T e) {
		if(isFull()) {
			return false;
		}
		array[count] = e;
		count++;
		return true;
	}
	/**Method to return the stack array
	 * @return array the stack array
	 */
	public T[] toArray() {
		return array;
	}

}
