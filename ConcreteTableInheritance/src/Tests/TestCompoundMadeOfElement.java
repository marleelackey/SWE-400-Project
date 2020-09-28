package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.CompoundMadeOfElement;
import Classes.CompoundRDG;

public class TestCompoundMadeOfElement {

	@Test
	public static void testConstructorAndGetters() {
		
		CompoundMadeOfElement comp = new CompoundMadeOfElement(1,2);
		assertEquals(comp.getCompoundID(), 1);
		assertEquals(comp.getElementID(), 2);
	}

	
	public static void runAllTheTests() {
		testConstructorAndGetters();
	}
}
