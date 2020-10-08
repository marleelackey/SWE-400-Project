package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import datasource.MetalDTO;
/**
 * 
 * @author Daniel Holmgren
 * @author Joshua Kellogg
 * Test class for the metalDTO
 */
public class TestMetalDTO {

	/**
	 * Tests to make sure we can assign variables and'
	 * get accurate information back
	 */
	@Test
	public static void testConstructorAndGetters() {
		MetalDTO m = new MetalDTO(1, 2, 3, 4.0, "Name");
		assertEquals(m.getAtomicMass(), 4.0, 0.01);
		assertEquals(m.getAtomicNumber(), 2);
		assertEquals(m.getDissolvedBy(), 3);
		assertEquals(m.getID(), 1);
		assertEquals(m.getName(), "Name");
	}

	/**
	 * Runs all the tests to be efficient
	 */
	public static void runAllTheTests() {
		testConstructorAndGetters();
	}

}