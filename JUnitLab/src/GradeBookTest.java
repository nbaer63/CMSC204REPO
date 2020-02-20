import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
	GradeBook bookOne;
	GradeBook bookTwo;
	
	@Before
	public void setUp() throws Exception {
		bookOne = new GradeBook(5);
		bookOne.addScore(98);
		bookOne.addScore(78);
		bookOne.addScore(86);
		
		bookTwo = new GradeBook(5);
		bookTwo.addScore(64);
		bookTwo.addScore(75);
	}
	@After
	public void tearDown() throws Exception {
		bookOne = null;
		bookTwo = null;
	}
	
	@Test
	public void testAddScore() {
		assertTrue(bookOne.toString().equals("98.0 78.0 86.0 "));
		assertEquals(3, bookOne.getScoreSize(), .0001);
		
		assertTrue(bookTwo.toString().equals("64.0 75.0 "));
		assertEquals(2, bookTwo.getScoreSize(), .0001);
	}
	
	@Test
	public void testSum() {
		assertEquals(262, bookOne.sum(), .0001);
		assertEquals(139, bookTwo.sum(), .0001);
	}
	
	@Test
	public void testMinimum() {
		assertEquals(78, bookOne.minimum(), .0001);
		assertEquals(64, bookTwo.minimum(), .0001);
	}
	
	@Test
	public void testFinalScore() {
		assertEquals(184, bookOne.finalScore(), .0001);
		assertEquals(75, bookTwo.finalScore(), .0001);
	}
}
