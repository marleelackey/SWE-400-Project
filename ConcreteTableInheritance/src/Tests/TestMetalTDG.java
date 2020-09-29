package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Classes.MetalDTO;
import Classes.MetalTDG;
import Datasource.DatabaseException;

public class TestMetalTDG {

	/**
	 * @author Dan Holmgren
	 * @author Josh Kellogg
	 */
	@Test
	public void testConstructor() {
		MetalTDG m = MetalTDG.getInstance();
		assertNotEquals(m, null);
	}
	
	@Test
	public void testGetAllMetals() {
		MetalTDG m = MetalTDG.getInstance();
		ArrayList<MetalDTO> results = m.getAllMetals();
		assertEquals(results.size(), 4);
		for(int i = 0; i < results.size(); i++) {
			assertEquals(results.get(i).getDissolvedBy(), (i + 5));
		}
	}

}
