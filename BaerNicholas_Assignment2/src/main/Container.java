package main;

import exceptions.*;
import interfaces.*;
/**Data Structure class that deals with a generic stack of DonationPackages
 * 
 * @author Nick Baer
 *
 * @param <T> generic object
 */
@SuppressWarnings("unchecked")
public class Container<T> implements ContainerInterface{
	private Stack<T> stack;
	
	/**
	 * Two constructors, one with no parameter and creates a new stack with default size, and one that takes an int of size and creates a new stack with that size
	 */
	public Container() {
		stack = new Stack<T>();
	}
	public Container(int size) {
		stack = new Stack<T>(size);
	}
	
	/**Method to add a donation package to the container stack
	 * @param dPackage donation package to be added to stack
	 * @exception ContainerException throws exception if stack is full
	 * @return true if successfully added
	 */
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {
		if (stack.isFull()) {
			throw new ContainerException("The Container is Full");
		}
		stack.push((T) dPackage);
		return true;
	}
	
	/**Method to remove a donation package from the container stack
	 * @exception ContainerException throws exception if stack is empty
	 * @return DonationPackage that is removes from stack
	 */
	public DonationPackage removePackageFromContainer() throws ContainerException {
		if (stack.isEmpty()) {
			throw new ContainerException("The Container is Empty");
		}
		return (DonationPackage) stack.pop();
	}
	
	/**Method to cast the stack array from a generic array into a DonationPackage array, then returns that array
	 * @return pArray the casted array of type DonationPackage
	 */
	public DonationPackage[] toArrayPackage() {
		DonationPackage[] pArray = new DonationPackage[stack.toArray().length];
		for(int i = 0; i < pArray.length; i++) {
			pArray[i] = (DonationPackage) stack.toArray()[i];
		}
		return pArray;
	}

}
