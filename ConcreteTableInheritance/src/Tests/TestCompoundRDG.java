package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.CompoundRDG;

public class TestCompoundRDG {

	@Test
	public static void testConstructorAndGettersAndSetters() {
		CompoundRDG comp = new CompoundRDG(2, "Iodine");
		assertEquals(comp.getCompoundID(), 2);
		assertEquals(comp.getCompoundName(), "Iodine");
		
		comp.setCompoundName("Carodine");
		assertEquals(comp.getCompoundName(), "Carodine");
	
	}

	@Test
	public static void testFinders() {
		CompoundRDG comp = CompoundRDG.findByIDConcrete(1);
		assertEquals(comp.getCompoundID(), 1);
		assertEquals(comp.getCompoundName(), "Carodine");
		
		CompoundRDG comp1 = CompoundRDG.findByNameConcrete("Carodine");
		assertEquals(comp1.getCompoundID(), 1);
		assertEquals(comp1.getCompoundName(), "Carodine");
		
	}
	
	
	@Test
	public static void testUpdate() {
		CompoundRDG comp = CompoundRDG.findByIDConcrete(1);
		comp.setCompoundName("Sweet Carodine");
		comp.update();
		
		CompoundRDG compare = CompoundRDG.findByIDConcrete(1);
		assertEquals(compare.getCompoundName(), "Sweet Carodine");
	}
	
	public static void runAllTheTests() {
		testConstructorAndGettersAndSetters();
		//testFinders();
		testUpdate();
	}
}
