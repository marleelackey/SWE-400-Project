package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import datasource.MetalDTO;

/**
 * @author Daniel Holmgren
 * @author Joshua Kellogg
 * A data transfer object for metal test
 *
 */
public class TestMetalDTO {

	/**
	 * Makes sure the constructor constructs
	 */
	@Test
	public static void testConstructor() {
		MetalDTO m = new MetalDTO(1, 2);
		assertEquals(m.getID(), 1);
		assertEquals(m.getDissolvedBy(), 2);
	}
	
	/**
	 * Sets a value and makes sure the value was set
	 */
	@Test
	public static void testSetters() {
		MetalDTO m = new MetalDTO(1, 2);
		m.setDissolvedBy(1234);
		assertEquals(m.getDissolvedBy(), 1234);
	}
	
	/**
	 * Runs all the tests at the same time for efficiency's sake
	 */
	public static void runAllTheTests() {
		testConstructor();
		testSetters();
	}

}
