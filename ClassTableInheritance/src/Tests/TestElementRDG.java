package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.ElementRDG;

public class TestElementRDG {

	@Test
	public static void testConstructorAndGetters() {
		ElementRDG e = new ElementRDG(1, 2, 3.0);
		assertEquals(e.getID(), 1);
		assertEquals(e.getAtomicNumber(), 2);
		assertEquals(e.getAtomicMass(), 3.0, 0.01);
	}
	
	@Test
	public static void testFindByID() {
		ElementRDG e = ElementRDG.findByID(4);
		assertEquals(e.getID(), 4);
		assertEquals(e.getAtomicNumber(), 12);
		assertEquals(e.getAtomicMass(), 50.01, 0.01);
	}
	
	@Test
	public static void testFindByAtomicNumber() {
		ElementRDG e = ElementRDG.findByAtomicNumber(40);
		assertEquals(e.getID(), 5);
		assertEquals(e.getAtomicNumber(), 40);
		assertEquals(e.getAtomicMass(), 20.0, 0.01);
	}
	
	@Test
	public static void testFindByAtomicMass() {
		ElementRDG e = ElementRDG.findByAtomicMass(40.0);
		assertEquals(e.getID(), 7);
		assertEquals(e.getAtomicNumber(), 30);
		assertEquals(e.getAtomicMass(), 40.0, 0.01);
	}
	
	public static void runAllTheTests() {
		testConstructorAndGetters();
		testFindByID();
		testFindByAtomicNumber();
		testFindByAtomicMass();
	}
	
	

}
