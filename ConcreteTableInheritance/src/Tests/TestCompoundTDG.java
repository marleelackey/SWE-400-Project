package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Classes.ChemicalDTO;
import Classes.ChemicalTDG;
import Classes.CompoundDTO;
import Classes.CompoundTDG;

public class TestCompoundTDG {

	@Test
	public static void testSingleton() {
		// make sure it will be created and not null
		CompoundTDG comp = CompoundTDG.getSingleton();
		assertNotEquals(comp, null);
	}
	
	@Test
	public static void testGetCompoundsByElement() {
		// Compound VALUES (1, 'Carodine')
		// Compound VALUES (2, 'Neilium')
		// Compound VALUES (3, 'Selenaium')
		
		/*
		  ArrayList<ChemicalDTO> result = c.getAllBases();
		  //Test to make sure it gets the correct number of dtos
		  assertEquals(3, result.size());
		  
		  //Test to make sure all dtos are for bases
		  for(int i = 0; i < result.size(); i++) {
			assertEquals(1, result.get(i).getChemicalType());
		}
		 */
		CompoundTDG comp = CompoundTDG.getSingleton();
		
		ArrayList<CompoundDTO> list = comp.getCompoundsByElement();
		assertEquals(list.get(0).getCompoundID(), 1);
		assertEquals(list.get(0).getCompoundName(), "Carodine");
		assertEquals(list.get(1).getCompoundID(), 2);
		assertEquals(list.get(1).getCompoundName(), "Neilium");
		assertEquals(list.get(2).getCompoundID(), 3);
		assertEquals(list.get(2).getCompoundName(), "Selenaium");
		
	}
	
	public static void runAllTheTests() {
		testSingleton();
		testGetCompoundsByElement();
	}

}
