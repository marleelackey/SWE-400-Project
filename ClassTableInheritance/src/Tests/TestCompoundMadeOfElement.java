package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.CompoundMadeOfElement;

public class TestCompoundMadeOfElement {

	@Test
	public static void testConstructorAndGetters() {
		CompoundMadeOfElement comp = new CompoundMadeOfElement(1,2);
		assertEquals(comp.getCompoundID(), 1);
		assertEquals(comp.getElementID(), 2);
	}

	
	@Test
	public static void runAllTheTests() {
		testConstructorAndGetters();
	}
}
