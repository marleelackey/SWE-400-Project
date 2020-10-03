package Tests;

import Datasource.DatabaseException;

/**
 * Class to run all the tests for Class Table Inheritance
 * @author Madeline & Adam
 *
 */
public class TestEVERYTHING {

	public static void testRunAllTheTests() {
		TestChemicalDTO.runAllTheTests();
		try {
			TestChemicalRDG.runAllTheTests();
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		TestChemicalTDG.runAllTheTests();
		
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