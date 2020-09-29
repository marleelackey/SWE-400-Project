package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.MetalRDG;

public class TestMetalRDG {

	@Test
	public void testConstructorAndGetters() {
		MetalRDG m = new MetalRDG(1, 2, 3, 4.0, "Test");
		assertEquals(m.getID(), 1);
		assertEquals(m.getAtomicNumber(), 2);
		assertEquals(m.getDissolvedBy(), 3);
		assertEquals(m.getAtomicMass(), 4.0, 0.01);
		assertEquals(m.getName(), "Test");
	}
	
	@Test
	public void testFindByID() {
		MetalRDG m = MetalRDG.findByID(20);
		assertEquals(m.getAtomicMass(), 21.0, 0.01);
		assertEquals(m.getAtomicNumber(), 21);
		assertEquals(m.getID(), 20);
		assertEquals(m.getName(), "metal1");
	}
	
	@Test
	public void testFindByAtomicNumber() {
		MetalRDG m = MetalRDG.findByName("metal2");
		assertEquals(m.getAtomicMass(), 22.0, 0.01);
		assertEquals(m.getAtomicNumber(), 22);
		assertEquals(m.getID(), 21);
		assertEquals(m.getName(), "metal2");
	}
	
	@Test
	public void testUpdate() {
		
	}

}
