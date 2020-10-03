package Tests;

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
		
		TestBaseDTO.runAllTheTests();
		TestBaseRDG.runAllTheTests();
		TestBaseTDG.runAllTheTests();
		
		TestCompoundDTO.runAllTheTests();
		TestCompoundRDG.runAllTheTests();
		TestCompoundTDG.runAllTheTests();
		
		TestCompoundMadeOfElement.runAllTheTests();
		
		TestElementDTO.runAllTheTests();
		TestElementRDG.runAllTheTests();
		TestElementTDG.runAllTheTests();
		
		TestMetalDTO.runAllTheTests();
		TestMetalRDG.runAllTheTests();
		TestMetalTDG.runAllTheTests();
	}

}