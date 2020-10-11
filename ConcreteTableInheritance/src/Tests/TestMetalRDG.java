package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import datasource.MetalRDG;

/**
 * 
 * @author Daniel Holmgren
 * @author Joshua Kellogg Test class for metalRDG
 */
public class TestMetalRDG {

	/**
	 * Tests the constructor assigns variables correctly and that we can get them
	 * back
	 */
	@Test
	public static void testConstructorAndGetters() {
		MetalRDG m = new MetalRDG(1, 2, 3, 4.0, "Test", 4.5);
		assertEquals(m.getID(), 1);
		assertEquals(m.getAtomicNumber(), 2);
		assertEquals(m.getDissolvedBy(), 3);
		assertEquals(m.getAtomicMass(), 4.0, 0.01);
		assertEquals(m.getName(), "Test");
		assertEquals(m.getMoles(), 4.5, 0.01);
	}

	/**
	 * Tests the findByID method
	 */
	@Test
	public static void testFindByID() {
		MetalRDG m = MetalRDG.findByID(20);
		assertEquals(m.getAtomicMass(), 21.0, 0.01);
		assertEquals(m.getAtomicNumber(), 21);
		assertEquals(m.getID(), 20);
		assertEquals(m.getName(), "metal1");
		assertEquals(m.getMoles(), 29.4, 0.01);
	}

	/**
	 * Tests the findByName method
	 */
	@Test
	public static void testFindByName() {
		MetalRDG m = MetalRDG.findByName("metal2");
		assertEquals(m.getAtomicMass(), 22.0, 0.01);
		assertEquals(m.getAtomicNumber(), 22);
		assertEquals(m.getID(), 21);
		assertEquals(m.getName(), "metal2");
		assertEquals(m.getMoles(), 29.5, 0.01);
	}

	/**
	 * Tests to make sure our update method successfully updates the database
	 */
	@Test
	public static void testUpdate() {
		MetalRDG m = MetalRDG.findByID(20);
		assertEquals(m.getAtomicMass(), 21.0, 0.01);
		m.setAtomicMass(450.0);
		m.update();
		MetalRDG f = MetalRDG.findByID(20);
		assertEquals(f.getAtomicMass(), 450.0, 0.01);
	}

	/**
	 * Runs all the tests at once for efficiency
	 */
	public static void runAllTheTests() {
		testConstructorAndGetters();
		testFindByID();
		testFindByName();
		testUpdate();
	}

}