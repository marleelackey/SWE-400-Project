package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.AcidDTO;

/**
 * Test class for the AcidDTO class
 * 
 * @author Adam & Madeline
 *
 */
public class TestAcidDTO {

	/**
	 * JUnit to test the AcidDTO constructor and getters
	 */
	@Test
	public static void test() {
		AcidDTO dto = new AcidDTO(1, "Hydrochloric Acid", 5);
		assertEquals(1, dto.getAcidID());
		assertEquals("Hydrochloric Acid", dto.getAcidName());
		assertEquals(5, dto.getAcidSolute());
	}

	/**
	 * Runs all the tests in this class
	 */
	public static void runAllTheTests() {
		test();
	}

}