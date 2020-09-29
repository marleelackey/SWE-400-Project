package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Class to run all the tests for Concrete Table Inheritance
 * @author Madeline & Adam
 *
 */
public class TestEVERYTHING {

	@Test
	public static void testRunAllTheTests() {
		TestAcidDTO.runAllTheTests();
		TestAcidRDG.runAllTheTests();
		TestAcidTDG.runAllTheTests();
		TestCompoundDTO.runAllTheTests();
		TestCompoundRDG.runAllTheTests();
		TestCompoundTDG.runAllTheTests();
//		TestElementDTO.runAllTheTests();
//		TestElementRDG.runAllTheTests();
//		TestElementTDG.runAllTheTests();
	}

}