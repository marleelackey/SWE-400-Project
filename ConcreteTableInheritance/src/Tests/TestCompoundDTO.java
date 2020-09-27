package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.CompoundDTO;

public class TestCompoundDTO {

	@Test
	public static void testConstructor() {
		CompoundDTO chem = new CompoundDTO(7, "Carodine");
		assertEquals(chem.getCompoundID(), 7);
		assertEquals(chem.getCompoundName(), "Carodine");
		
	}
	
	public static void runAllTheTests() {
		testConstructor();
	}

}
