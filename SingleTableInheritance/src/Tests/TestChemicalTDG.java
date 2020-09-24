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
	public void testSingleton() {
		ChemicalTDG c = ChemicalTDG.getSingleton();
		ChemicalTDG d = ChemicalTDG.getSingleton();
		assertEquals(c, d);
	}
	
	@Test
	public void testGetAllBases() {
		ChemicalTDG c = ChemicalTDG.getSingleton();
		ArrayList<ChemicalDTO> result = c.getAllBases();
		//Test to make sure it gets the correct number of dtos
		//assertEquals(result.size(), ?);
		//Test to make sure all dtos are for bases
//		for(int i = 0; i < result.size(); i++) {
//			assertEquals(result.get(i).getType(), 1);
//		}
	}
	
	@Test
	public void testGetElementsInRange() {
		ChemicalTDG c = ChemicalTDG.getSingleton();
		ArrayList<ChemicalDTO> result = c.getElementsInRange(4,9);
		//Test to make sure it gets the correct number of dtos
		//assertEquals(result.size(), ?);
		//Test to make sure all dto atomic masses are in range
//		for(int i = 0; i < result.size(); i++) {
//			if((result.get(i).getAtomicMass() < 4) || result.get(i).getAtomicMass() > 9) {
//				fail("Atomic mass not in range");
//			}
//		}
//		System.out.println("All atomic masses in range");
	}
	
	@Test
	public void testGetCompoundsByElement() {
		ChemicalTDG c = ChemicalTDG.getSingleton();
		ArrayList<CompoundMadeOfElementDTO> result = c.getCompoundsByElement(3);
		//Test to make sure it gets the correct number of dtos
		//assertEquals(result.size(), ?);
		//Test to make sure all compounds have the correct elements
//		for(int i = 0; i < result.size(); i++) {
//			assertEquals(result.get(i).getElementID(), 3);
//		}
	}

}