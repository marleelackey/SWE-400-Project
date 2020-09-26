package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.AcidTDG;

/**
 * JUnit for the AcidTDG class
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

	public static void runAllTheTests() {
		testInitialization();
	}

}