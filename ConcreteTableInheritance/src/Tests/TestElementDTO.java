package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import datasource.ElementDTO;

/**
 * @author Daniel Holmgren
 * @author Joshua Kellogg
 * Test class for the ElementDTO
 */
public class TestElementDTO {

	/**
	 * Makes sure the constructor can assign the correct values
	 */
	@Test
	public static void testConstructor() {
		ElementDTO e = new ElementDTO(1, 2, 3.0, "Test");
		assertEquals(1, e.getID());
		assertEquals(2, e.getAtomicNumber());
		assertEquals(3.0, e.getAtomicMass(), 0.01);
		assertEquals("Test", e.getName());
	}
	
	/**
	 * To be efficient
	 */
	public static void runAllTheTests() {
		testConstructor();
	}

}
