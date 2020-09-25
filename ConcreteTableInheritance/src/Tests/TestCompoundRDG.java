package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.CompoundRDG;


public class TestCompoundRDG {

	/**
	 * 
	 */
	@Test
	public void testConstructorAndGetters() {
		CompoundRDG comp = new CompoundRDG(40, "Selenaium");
		assertEquals(comp.getCompoundID(), 40);
		assertEquals(comp.getCompoundName(), "Selenaium");
	}
	
	@Test
	public void testSetters() {
		CompoundRDG comp = new CompoundRDG(41, "Francium");
		assertEquals(comp.getCompoundID(), 41);
		assertEquals(comp.getCompoundName(), "Francium");
		comp.setCompoundID(42);
		comp.setCompoundName("Francisium");
		assertEquals(comp.getCompoundID(), 42);
		assertEquals(comp.getCompoundName(), "Francisium");
		
		
	}

}
