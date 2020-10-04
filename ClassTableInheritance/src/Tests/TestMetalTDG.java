package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Classes.MetalDTO;
import Classes.MetalTDG;
/**
 * @author Daniel Holmgren
 * @author Joshua Kellogg
 * Test class for the MetalTDG
 *
 */
public class TestMetalTDG {

	/**
	 * Asserts the constructor works
	 */
	@Test
	public static void testConstructor() {
		MetalTDG m = MetalTDG.getSingleton();
		assertNotEquals(m, null);
		MetalTDG d = MetalTDG.getSingleton();
		assertEquals(m, d);
	}
	
	/**
	 * Makes sure the getAllMetals method returns the correct amount of items
	 */
	@Test
	public static void testGetAllMetals() {
		MetalTDG m = MetalTDG.getSingleton();
		ArrayList<MetalDTO> results = new ArrayList<MetalDTO>();
		results = m.getAllMetals();
		assertEquals(results.size(), 3);
	}
	
	/**
	 * To be effiecient
	 */
	public static void runAllTheTests() {
		testConstructor();
		testGetAllMetals();
	}

}
