package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.ElementRDG;
import Classes.MetalRDG;

public class TestMetalRDG {

	@Test
	public static void testConstructor() {
		MetalRDG m = new MetalRDG(1, 2);
		assertEquals(m.getID(), 1);
		assertEquals(m.getDissolvedBy(), 2);
		m.setDissolvedBy(3);
		assertEquals(m.getDissolvedBy(), 3);
	}
	
	@Test
	public static void testFindByID() {
		MetalRDG m = MetalRDG.findByID(10);
		assertEquals(m.getID(), 10);
		assertEquals(m.getDissolvedBy(), 66);
	}
	
	@Test
	public static void testUpdate() {
		MetalRDG m = MetalRDG.findByID(11);
		assertEquals(m.getID(), 11);
		assertEquals(m.getDissolvedBy(), 77);
		m.setDissolvedBy(456);
		m.update();
		MetalRDG d = MetalRDG.findByID(11);
		assertEquals(d.getDissolvedBy(), 456);
	}
	
	public static void runAllTheTests() {
		testConstructor();
		testFindByID();
		testUpdate();
	}
}
