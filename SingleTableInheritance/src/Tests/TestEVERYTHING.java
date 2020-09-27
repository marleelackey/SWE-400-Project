package Tests;

import org.junit.Test;

/**
 * Class to run all the tests for Single Table Inheritance
 * 
 * @author Madeline & Adam
 *
 */
public class TestEVERYTHING {

	@Test
	public static void testRunAllTheTests() throws Exception {
		TestChemicalDTO.testAll();
		TestChemicalRDG.testAll();
		TestChemicalTDG.testAll();
	}

}