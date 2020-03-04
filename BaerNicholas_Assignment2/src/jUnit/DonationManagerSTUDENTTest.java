package jUnit;


import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.*;
import exceptions.*;
 
/**
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */
public class DonationManagerSTUDENTTest {
	DonationManager manager;

	@Before
	public void setUp() throws Exception {
	 
		manager = new DonationManager();
		
	}
 
	@After
	public void tearDown() throws Exception {
		 
		manager = null;
	}
 
	/** 
	 * Student test that a new DonationPackage is created and 
	 * the manager correctly calls load the container 
	 */
	@Test
	public void testManagerLoadcontainer()   {

		try {
			manager.managerLoadContainer(new DonationPackage("Pencils",10));
			manager.managerLoadContainer(new DonationPackage("Magazines",12));
			manager.managerLoadContainer(new DonationPackage("Backpack",11));
			manager.managerLoadContainer(new DonationPackage("stools",20));
			manager.managerLoadContainer(new DonationPackage("computer",14));
			 
			 
		} catch (ContainerException e) {
			System.out.println("Should not throw exception ");
		}	 
	}
	 
	/**
	 * Student test that a new Volunteer is created and 
	 * the manager correctly queues the volunteer
	 */
	@Test
	public void testManagerQueueVolunteer() {
		try {
			manager.managerQueueVolunteer(new  Volunteer("Bob"));
			manager.managerQueueVolunteer(new  Volunteer("Amy"));
			manager.managerQueueVolunteer(new  Volunteer("Nick"));
			manager.managerQueueVolunteer(new  Volunteer("Adam"));
			manager.managerQueueVolunteer(new  Volunteer("Josh"));
			manager.managerQueueVolunteer(new  Volunteer("Jennifer"));
			
		} catch (VolunteerException e) {
			 
			System.out.println(e + "here");
		} 
	
	}

	/**
	 * Student test that a new Recipient is created and 
	 * the manager correctly queues the recipient
	 */
	@Test
	public void testManagerQueueRecipient() {
		try {
			manager.managerQueueRecipient(new  Recipient("James"));
			manager.managerQueueRecipient(new  Recipient("Nate"));
			manager.managerQueueRecipient(new  Recipient("Brendon"));
			manager.managerQueueRecipient(new  Recipient("Shirley"));
			manager.managerQueueRecipient(new  Recipient("Joe"));
			manager.managerQueueRecipient(new  Recipient("Devin"));
			
		} catch (VolunteerException e) {
			 
			System.out.println(e + "here");
		}
	}

	/**
	 * Student test that the manager correctly calls donatePackage,
	 * testing the situations noted in the assignment document
	 */
	@Test
	public void testDonatePackage() {
		 Volunteer v1;
		    Recipient r1, r2;
		    DonationPackage d1,d2,d3;
		    
		    v1 = new Volunteer("Miles"); 
			r1 = new Recipient("Ben");
			r2 = new Recipient("Megan");
			
			d1 = new DonationPackage("Pencils",10);
			d2 = new DonationPackage("Magazines",20);
			d3 = new DonationPackage("Backpack", 8);
			
			try {
				manager.managerLoadContainer(d1);
				manager.managerLoadContainer(d2);
				manager.managerLoadContainer(d3);
				
				assertEquals(manager.donatePackage(),1 );  //Can not donate package, There are no volunteers in the queue
				
				manager.managerQueueVolunteer(v1);    //add a volunteer
				assertEquals(manager.donatePackage(),2 );  // Still Can not donate package,There are no recipients in the queue
				
				manager.managerQueueRecipient(r1);   //Add a recipient
				assertEquals(manager.donatePackage(),0);    // donation process should be successful, this should remove the package from
				                                            // the container and recipients from the queue, Volunteer is enqueued again to the 
															// Volunteer line.
				
				assertEquals(manager.donatePackage(),2); //There is no recipient in the queue
				
				manager.managerQueueRecipient(r2); //Adds other recipient
				assertEquals(manager.donatePackage(),0); //Succesful donation as there is now a recipient
				
			} catch (ContainerException | VolunteerException | RecipientException e) {
				 
				e.printStackTrace();
			}
	} 

}
