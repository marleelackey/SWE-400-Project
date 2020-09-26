package Tests;

import org.junit.Test;

public class TestEVERYTHING {

	@Test
	public static void testRunAllTheTests() throws Exception {
		TestChemicalDTO.testAll();
		TestChemicalRDG.testAll();
		TestChemicalTDG.testAll();
	}

}