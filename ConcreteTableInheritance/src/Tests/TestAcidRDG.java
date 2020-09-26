package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.AcidRDG;

/**
 * Test class for the AcidRDG class
 * @author Madeline & Adam
 *
 */
public class TestAcidRDG {

	/**
	 * JUnit to test the AcidRDG constructors, getters, and setters with manual insertion of data
	 */
	@Test
	public static void testConstructorGettersSetters() {
		AcidRDG rdg = new AcidRDG(1, "Hydrochloric Acid", 27);
		
		assertEquals(1, rdg.getAcidID());
		assertEquals("Hydrochloric Acid", rdg.getAcidName());
		assertEquals(27, rdg.getAcidSolute());
		
		rdg.setAcidName("Nitric Acid");
		rdg.setAcidSolute(42);
		
		assertEquals("Nitric Acid", rdg.getAcidName());
		assertEquals(42, rdg.getAcidSolute());
	}
	
	/**
	 * JUnit to test that we can find an Acid by ID
	 */
	@Test
	public static void testFindByID() {
		AcidRDG rdg = AcidRDG.findByID(2);
		assertEquals(2, rdg.getAcidID());
		assertEquals("acid2", rdg.getAcidName());
		assertEquals(5, rdg.getAcidSolute());
	}
	
	/**
	 * JUnit to test that we can find an Acid by name
	 */
	@Test
	public static void testFindByName() {
		AcidRDG rdg = AcidRDG.findByName("acid1");
		assertEquals(1, rdg.getAcidID());
		assertEquals("acid1", rdg.getAcidName());
		assertEquals(4, rdg.getAcidSolute());
	}
	
	/**
	 * JUnit to test that we can persist an updated AcidRDG to the database
	 */
	@Test
	public static void testUpdate() {
		AcidRDG rdg = AcidRDG.findByID(3);
		rdg.setAcidName("acid 9 AKA Peroxydisulfuric Acid");
		rdg.setAcidSolute(6);
		
		rdg.update();
		
		AcidRDG result = AcidRDG.findByID(3);
		
		assertEquals(3, result.getAcidID());
		assertEquals("acid 9 AKA Peroxydisulfuric Acid", result.getAcidName());
		assertEquals(6, result.getAcidSolute());
	}

	public static void runAll() {
		testConstructorGettersSetters();
		testFindByID();
		testFindByName();
		testUpdate();
	}

}