package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import Classes.CompoundMadeOfElementDTO;

public class TestCompoundMadeOfElement {

	@Test
	public static void testGetters() {
		CompoundMadeOfElementDTO idk = new CompoundMadeOfElementDTO(1, 3);
		assertEquals(1, idk.getCompoundID());
		assertEquals(3, idk.getElementID());
	}
	
	@Test
	public static void runAllTheTests() {
		testGetters();
	}

}