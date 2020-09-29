package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.MetalDTO;

public class TestMetalDTO {

	@Test
	public static void testConstructor() {
		MetalDTO m = new MetalDTO(1, 2);
		assertEquals(m.getID(), 1);
		assertEquals(m.getDissolvedBy(), 2);
	}
	
	@Test
	public static void testSetters() {
		MetalDTO m = new MetalDTO(1, 2);
		m.setDissolvedBy(1234);
		assertEquals(m.getDissolvedBy(), 1234);
	}
	
	public static void runAllTheTests() {
		testConstructor();
		testSetters();
	}

}
