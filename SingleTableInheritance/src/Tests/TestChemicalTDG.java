package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.ChemicalDTO;
import Classes.ChemicalTDG;
import Classes.CompoundMadeOfElementDTO;

public class TestChemicalTDG {
	
	@Before
	public void testSetUp() {
		//create chemical tdg
	}
	
	@Test
	public static void testSingleton() {
		ChemicalTDG c = ChemicalTDG.getSingleton();
		ChemicalTDG d = ChemicalTDG.getSingleton();
		assertEquals(c, d);
	}
	
	@Test
	public static void testGetAllBases() {
		ChemicalTDG c = ChemicalTDG.getSingleton();
		ArrayList<ChemicalDTO> result = c.getAllBases();
		//Test to make sure it gets the correct number of dtos
		assertEquals(3, result.size());
		//Test to make sure all dtos are for bases
		for(int i = 0; i < result.size(); i++) {
			assertEquals(1, result.get(i).getChemicalType());
		}
	}
	
	@Test
	public static void testGetElementsInRange() {
		ChemicalTDG c = ChemicalTDG.getSingleton();
		ArrayList<ChemicalDTO> result = c.getElementsInRange(0, 100);
		//Test to make sure it gets the correct number of dtos
		assertEquals(11, result.size());
		//Test to make sure all dto atomic masses are in range
		for(int i = 0; i < result.size(); i++) {
			if((result.get(i).getChemicalAtomicMass() < 1) || result.get(i).getChemicalAtomicMass() > 100) {
				fail("Atomic mass not in range");
			}
		}
		System.out.println("All atomic masses in range");
	}
	
	@Test
	public static void testGetCompoundsByElement() {
		ChemicalTDG c = ChemicalTDG.getSingleton();
		ArrayList<CompoundMadeOfElementDTO> result = c.getCompoundsByElement(1);
		//Test to make sure it gets the correct number of dtos
		assertEquals(1, result.size());
		//Test to make sure all compounds have the correct elements
		for(int i = 0; i < result.size(); i++) {
			assertEquals(result.get(i).getElementID(), 1);
		}
	}

	public static void testAll() {
		testSingleton();
		testGetAllBases();
		testGetElementsInRange();
		testGetCompoundsByElement();
	}

}