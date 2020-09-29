package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Classes.MetalDTO;
import Classes.MetalTDG;

public class TestMetalTDG {

	@Test
	public static void testConstructor() {
		MetalTDG m = MetalTDG.getSingleton();
		assertNotEquals(m, null);
		MetalTDG d = MetalTDG.getSingleton();
		assertEquals(m, d);
	}
	
	@Test
	public static void testGetAllMetals() {
		MetalTDG m = MetalTDG.getSingleton();
		ArrayList<MetalDTO> results = new ArrayList<MetalDTO>();
		results = m.getAllMetals();
		assertEquals(results.size(), 3);
	}
	
	public static void runAllTheTests() {
		testConstructor();
		testGetAllMetals();
	}

}
