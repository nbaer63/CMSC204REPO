package jUnit;

import static org.junit.Assert.*;
import exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.InvalidSequenceException;
import exceptions.LengthException;
import exceptions.NoLowerAlphaException;
import exceptions.NoUpperAlphaException;
import utility.PasswordCheckerUtility;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerSTUDENT_Test {

	ArrayList<String> passwords;
	String password1, password2;

	@Before
	public void setUp() throws Exception {
		String[] p = {"223344AA", "Am4Kool2ME", "jose3BBB", "5male", "martha55", "2wardApril", 
				"october19", "lmnopq", "OrangesLL", "jj22g", "sailorProject", "myAccount", 
				"myAccount2"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p)); 
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}


	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("lmnLMN21"));
			PasswordCheckerUtility.isValidPassword("lmn21");
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("7blahblahcC"));
			PasswordCheckerUtility.isValidPassword("7blahblahc");
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("7blahblahCc"));
			PasswordCheckerUtility.isValidPassword("7BLAHBLAHC");
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("5678ccCC"));
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("5678ccCC");
			assertTrue(weakPwd);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("5678ccCC"));
			PasswordCheckerUtility.isValidPassword("5678cCCC");
			assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("5abbccCC"));
			PasswordCheckerUtility.isValidPassword("aabbccCC");
			assertTrue("Did not throw an NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw an NoDigitExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an NoDigitException",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertEquals(true,PasswordCheckerUtility.isValidPassword("5abbccCC"));
			assertTrue("Successfull",true);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Some exception",false);
		}
	}
	
	/**
	 * Test the validPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testValidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.validPasswords(passwords);
		Scanner scan = new Scanner(results.get(0)); //
		assertEquals(scan.next(), "223344AA");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		//assertEquals(scan.nextLine(), " The password must contain at least one lowercase alphabetic character.");
		scan = new Scanner(results.get(1)); //
		assertEquals(scan.next(), "jose3BBB");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("more than two"));
		//assertEquals(scan.nextLine(), " The password cannot contain more than two of the same character in sequence.");
		scan = new Scanner(results.get(3)); //
		assertEquals(scan.next(), "martha55");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		//assertEquals(scan.nextLine(), " The password must contain at least one uppercase alphabetic character.");
		scan = new Scanner(results.get(5)); //
		assertEquals(scan.next(), "lmnopq");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
		//assertEquals(scan.nextLine(), " The password must contain at least one digit.");
		scan = new Scanner(results.get(6)); //a
		assertEquals(scan.next(), "OrangesLL");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
		//assertEquals(scan.nextLine(), " The password must contain at least one digit.");
	}
	
}