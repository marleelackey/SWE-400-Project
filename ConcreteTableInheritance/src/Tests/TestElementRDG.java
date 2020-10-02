package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.AcidRDG;
import Classes.BaseRDG;
import Classes.ElementRDG;

public class TestElementRDG {
	
	//DONT FORGET ROLLBACK

	@Test
	public static void testConstructor() {
		ElementRDG e = new ElementRDG(1, 10, 12.4, "Test");
		assertEquals(e.getID(), 1);
		assertEquals(e.getAtomicMass(), 12.4, 0.01);
		assertEquals(e.getAtomicNumber(), 10);
		assertEquals(e.getName(), "Test");
	}
	
	@Test
	public static void testGettersAndSetters() {
		ElementRDG e = new ElementRDG(1, 2, 3.0, "Tester");
		e.setAtomicMass(50.0);
		e.setAtomicNumber(651);
		e.setName("New Name");
		assertEquals(e.getAtomicMass(), 50.0, 0.01);
		assertEquals(e.getAtomicNumber(), 651);
		assertEquals(e.getID(), 1);
		assertEquals(e.getName(), "New Name");
	}
	
	@Test
	public static void testFindByID() {
		ElementRDG e = ElementRDG.findByID(4);
		assertEquals(e.getID(), 4);
		assertEquals(e.getName(), "element1");
		assertEquals(e.getAtomicNumber(), 12);
		assertEquals(e.getAtomicMass(), 50.01, 0.01);
	}
	
	@Test
	public static void testFindByName() {
		ElementRDG e = ElementRDG.findByName("element2");
		assertEquals(e.getID(), 5);
		assertEquals(e.getName(), "element2");
		assertEquals(e.getAtomicNumber(), 40);
		assertEquals(e.getAtomicMass(), 20.0, 0.01);
	}
	
	/**
	 * JUnit to test that we can get the type from a name (if it exists)
	 * @author Madeline and Adam
	 */
	@Test
	public static void testFindTypeByName() {
		String type = ElementRDG.findTypeByName("element2");
		assertEquals("Element", type);
		
		String typeFakeNews = ElementRDG.findTypeByName("notReallyAnElement");
		assertNull(typeFakeNews);
	}
	
	@Test
	public static void testFindByAtomicNumber() {
		ElementRDG e = ElementRDG.findByAtomicNumber(55);
		assertEquals(e.getID(), 6);
		assertEquals(e.getName(), "element3");
		assertEquals(e.getAtomicNumber(), 55);
		assertEquals(e.getAtomicMass(), 20.2, 0.01);
	}
	
	@Test
	public static void testFindByAtomicMass() {
		ElementRDG e = ElementRDG.findByAtomicMass(40.0);
		assertEquals(e.getID(), 7);
		assertEquals(e.getName(), "element4");
		assertEquals(e.getAtomicNumber(), 30);
		assertEquals(e.getAtomicMass(), 40.0, 0.01);
	}
	
	@Test
	public static void testUpdate() {
		//Write after figuring out rollback
	}
	
	/**
	 * @author Madeline and Adam
	 */
	public static void runAllTheTests() {
		testConstructor();
		testGettersAndSetters();
		testFindByID();
		testFindByName();
		testFindTypeByName();
		testFindByAtomicNumber();
		testFindByAtomicMass();
	}

}
