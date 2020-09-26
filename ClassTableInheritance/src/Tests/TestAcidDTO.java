package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.AcidDTO;

/**
 * Test class for the AcidDTO class in Class Table Inheritance
 * 
 * @author Adam & Madeline
 *
 */
public class TestAcidDTO {

	/**
	 * JUnit to test the AcidDTO constructor and getters
	 */
	@Test
	public void test() {
		AcidDTO dto = new AcidDTO(1, 4);
		assertEquals(1, dto.getAcidID());
		assertEquals(4, dto.getAcidSolute());
	}
}