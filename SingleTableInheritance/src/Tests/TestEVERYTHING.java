package Tests;

import org.junit.Test;

/**
 * Class to run all the tests for Single Table Inheritance
 * 
 * @author Madeline & Adam
 *
 */
public class TestEVERYTHING {

	/**
	 * Runs every test in Single Table Inheritance
	 */
	@Test
	public static void testRunAllTheTests() {
		TestChemicalDTO.runAllTheTests();
		TestChemicalRDG.runAllTheTests();
		TestChemicalTDG.runAllTheTests();
		TestCompoundMadeOfElement.runAllTheTests();
		TestElementMapper.runAllTheTests();
		TestMetalMapper.runAllTheTests();

	}

}