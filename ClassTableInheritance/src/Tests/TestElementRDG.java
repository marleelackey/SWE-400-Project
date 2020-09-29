package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.ElementRDG;

public class TestElementRDG {

	@Test
	public void testConstructorAndGetters() {
		ElementRDG e = new ElementRDG(1, 2, 3.0);
		assertEquals(e.getID(), 1);
		assertEquals(e.getAtomicNumber(), 2);
		assertEquals(e.getAtomicMass(), 3.0, 0.01);
	}
	
	@Test
	public void testFindByID() {
		ElementRDG e = ElementRDG.findByID(4);
		assertEquals(e.getID(), 4);
		assertEquals(e.getAtomicNumber(), 12);
		assertEquals(e.getAtomicMass(), 50.01, 0.01);
	}
	
	@Test
	public void testFindByAtomicNumber() {
		ElementRDG e = ElementRDG.findByAtomicNumber(40);
		assertEquals(e.getID(), 5);
		assertEquals(e.getAtomicNumber(), 40);
		assertEquals(e.getAtomicMass(), 20.0, 0.01);
	}
	
	@Test
	public void testFindByAtomicMass() {
		ElementRDG e = ElementRDG.findByAtomicMass(20.2);
		assertEquals(e.getID(), 6);
		assertEquals(e.getAtomicNumber(), 55);
		assertEquals(e.getAtomicMass(), 20.2, 0.01);
	}
	
	

}
