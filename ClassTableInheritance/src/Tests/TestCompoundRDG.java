package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.CompoundRDG;

public class TestCompoundRDG {

	@Test
	public static void testConstructor() {
		CompoundRDG comp = new CompoundRDG(5);
		assertEquals(comp.getCompoundID(), 5);
		
	}
	
	@Test 
	public static void testFinders() {
		CompoundRDG comp = CompoundRDG.findByIDClass(1);
		assertEquals(comp.getCompoundID(), 1);
		
	}
	
	@Test
	public static void runAllTheTests() {
		testConstructor();
		testFinders();
	}

}
