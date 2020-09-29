package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.CompoundDTO;

public class TestCompoundDTO {

	/**
	 * Tests the constructor and getter
	 */
	@Test
	public static void testConstructor() {
		CompoundDTO comp = new CompoundDTO (5);
		assertEquals(comp.getCompoundID(), 5);
	}

	/**
	 * runner used by the Class project to run all tests
	 */
	public static void runAllTheTests() {
		testConstructor();
	}
}
