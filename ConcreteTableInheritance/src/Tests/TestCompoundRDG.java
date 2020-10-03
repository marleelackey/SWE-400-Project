package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.CompoundRDG;

/**
 * 
 * @author Marlee Lackey
 * @author Taryn Whitman
 *
 */
public class TestCompoundRDG {

	/**
	 * Test that the constructor, getters, and setters all work
	 */
	@Test
	public static void testConstructorAndGettersAndSetters() {
		CompoundRDG comp = new CompoundRDG(2, "Iodine");
		assertEquals(comp.getCompoundID(), 2);
		assertEquals(comp.getCompoundName(), "Iodine");
		
		comp.setCompoundName("Carodine");
		assertEquals(comp.getCompoundName(), "Carodine");
	
	}

	/**
	 * Test that all the findBy's work
	 */
	@Test
	public static void testFinders() {
		CompoundRDG comp = CompoundRDG.findByIDConcrete(1);
		assertEquals(comp.getCompoundID(), 1);
		assertEquals(comp.getCompoundName(), "Carodine");
		
		CompoundRDG comp1 = CompoundRDG.findByNameConcrete("Carodine");
		assertEquals(comp1.getCompoundID(), 1);
		assertEquals(comp1.getCompoundName(), "Carodine");
		
	}
	
	/**
	 * JUnit to test that we can get the type from a name (if it exists)
	 * @author Madeline and Adam
	 */
	@Test
	public static void testFindTypeByName() {
		String type = CompoundRDG.findTypeByName("Carodine");
		assertEquals("Compound", type);
		
		String typeFakeNews = CompoundRDG.findTypeByName("notReallyACompound");
		assertNull(typeFakeNews);
	}
	
	/**
	 * Test that the update method works correctly
	 */
	@Test
	public static void testUpdate() {
		CompoundRDG comp = CompoundRDG.findByIDConcrete(1);
		comp.setCompoundName("Sweet Carodine");
		comp.update();
		
		CompoundRDG compare = CompoundRDG.findByIDConcrete(1);
		assertEquals(compare.getCompoundName(), "Sweet Carodine");
	}
	
	/**
	 *  runner used by entire Concrete project to run all tests at once
	 */
	public static void runAllTheTests() {
		testConstructorAndGettersAndSetters();
		testFinders();
		testFindTypeByName();
		testUpdate();
	}
}