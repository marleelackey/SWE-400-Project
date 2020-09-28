package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.ElementRDG;

public class TestElementRDG {
	
	//DONT FORGET ROLLBACK

	@Test
	public void testConstructor() {
		ElementRDG e = new ElementRDG(1, 10, 12.4, "Test");
		assertEquals(e.getID(), 1);
		assertEquals(e.getAtomicMass(), 12.4, 0.01);
		assertEquals(e.getAtomicNumber(), 10);
		assertEquals(e.getName(), "Test");
	}
	
	@Test
	public void testGettersAndSetters() {
		ElementRDG e = new ElementRDG(1, 2, 3.0, "Tester");
		e.setAtomicMass(50.0);
		e.setAtomicNumber(651);
		e.setID(987);
		e.setName("New Name");
		assertEquals(e.getAtomicMass(), 50.0, 0.01);
		assertEquals(e.getAtomicNumber(), 651);
		assertEquals(e.getID(), 987);
		assertEquals(e.getName(), "New Name");
	}
	
	@Test
	public void testFindByID() {
		ElementRDG e = ElementRDG.findByID(4);
		assertEquals(e.getID(), 4);
		assertEquals(e.getName(), "element1");
		assertEquals(e.getAtomicNumber(), 12);
		assertEquals(e.getAtomicMass(), 50.01, 0.01);
	}
	
	@Test
	public void testFindByName() {
		ElementRDG e = ElementRDG.findByName("element2");
		assertEquals(e.getID(), 5);
		assertEquals(e.getName(), "element2");
		assertEquals(e.getAtomicNumber(), 40);
		assertEquals(e.getAtomicMass(), 20.0, 0.01);
	}
	
	@Test
	public void testFindByAtomicNumber() {
		ElementRDG e = ElementRDG.findByAtomicNumber(55);
		assertEquals(e.getID(), 6);
		assertEquals(e.getName(), "element3");
		assertEquals(e.getAtomicNumber(), 55);
		assertEquals(e.getAtomicMass(), 20.2, 0.01);
	}
	
	@Test
	public void testFindByAtomicMass() {
		ElementRDG e = ElementRDG.findByAtomicMass(40.0);
		assertEquals(e.getID(), 7);
		assertEquals(e.getName(), "element4");
		assertEquals(e.getAtomicNumber(), 30);
		assertEquals(e.getAtomicMass(), 40.0, 0.01);
	}
	
	@Test
	public void testUpdate() {
		//Write after figuring out rollback
	}

}
