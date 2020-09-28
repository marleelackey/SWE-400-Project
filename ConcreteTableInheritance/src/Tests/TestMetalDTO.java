package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.MetalDTO;

public class TestMetalDTO {

	@Test
	public void testConstructorAndGetters() {
		MetalDTO m = new MetalDTO(1, 2, 3, 4.0, "Name");
		assertEquals(m.getAtomicMass(), 4.0, 0.01);
		assertEquals(m.getAtomicNumber(), 2);
		assertEquals(m.getDissolvedBy(), 3);
		assertEquals(m.getID(), 1);
		assertEquals(m.getName(), "Name");
	}
	
	@Test
	public void testSetters() {
		MetalDTO m = new MetalDTO(1, 2, 3, 4.0, "Name");
		m.setAtomicMass(656.0);
		m.setAtomicNumber(351);
		m.setDissolvedBy(5);
		m.setID(65);
		m.setName("Yeetus");
		
		assertEquals(m.getAtomicMass(), 656.0, 0.01);
		assertEquals(m.getAtomicNumber(), 351);
		assertEquals(m.getDissolvedBy(), 5);
		assertEquals(m.getID(), 65);
		assertEquals(m.getName(), "Yeetus");
	}

}