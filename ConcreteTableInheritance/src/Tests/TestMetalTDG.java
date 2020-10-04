package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import Classes.MetalDTO;
import Classes.MetalTDG;

/**
 * @author Dan Holmgren
 * @author Josh Kellogg
 * Test class for the metalTDG
 */
public class TestMetalTDG {

	/**
	 * Tests the constructor
	 */
	@Test
	public static void testConstructor() {
		MetalTDG m = MetalTDG.getInstance();
		assertNotEquals(m, null);
	}
	
	/**
	 * Tests the getAllMetals method
	 */
	@Test
	public static void testGetAllMetals() {
		MetalTDG m = MetalTDG.getInstance();
		ArrayList<MetalDTO> results = m.getAllMetals();
		assertEquals(results.size(), 4);
		for(int i = 0; i < results.size(); i++) {
			assertEquals(results.get(i).getDissolvedBy(), (i + 5));
		}
	}

	/**
	 * Runs all of the tests in this class
	 */
	public static void runAllTheTests() {
		testConstructor();
		testGetAllMetals();
	}

}
