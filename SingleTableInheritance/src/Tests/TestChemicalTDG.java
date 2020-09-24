package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.ChemicalTDG;

public class TestChemicalTDG {

	@Test
	public void testSingleton() {
		ChemicalTDG c = ChemicalTDG.getSingleton();
		ChemicalTDG d = ChemicalTDG.getSingleton();
		assertEquals(c, d);
	}

}