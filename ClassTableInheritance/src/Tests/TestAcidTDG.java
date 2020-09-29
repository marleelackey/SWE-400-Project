package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Classes.AcidDTO;
import Classes.AcidTDG;

/**
 * Test class for the AcidTDG class
 * 
 * @author Madeline & Adam
 *
 */
public class TestAcidTDG {

	/**
	 * Test method to make sure we can get the AcidTDG singleton
	 */
	@Test
	public static void testInitialization() {
		AcidTDG tdg = AcidTDG.getSingleton();

		assertNotEquals(tdg, null);
	}

	/**
	 * Test method to make sure we can get all the Acids in the database
	 */
	@Test
	public static void testGetAll() {
		AcidTDG tdg = AcidTDG.getSingleton();
		ArrayList<AcidDTO> list = tdg.getAllAcids();
		assertEquals(2, list.size());
		assertEquals(1, list.get(0).getAcidID());
		assertEquals(2, list.get(1).getAcidID());
	}

}