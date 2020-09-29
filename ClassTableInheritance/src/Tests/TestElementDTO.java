package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.ElementDTO;

public class TestElementDTO {

	@Test
	public void testConstructor() {
		ElementDTO e = new ElementDTO(1, 2, 3.0);
		assertEquals(e.getID(), 1);
		assertEquals(e.getAtomicNumber(), 2);
		assertEquals(e.getAtomicMass(), 3.0, 0.01);
		
		e.setAtomicMass(65136513.0);
		assertEquals(e.getAtomicMass(), 65136513.0, 0.01);
		e.setAtomicNumber(532);
		assertEquals(e.getAtomicNumber(), 532);
	}

}
