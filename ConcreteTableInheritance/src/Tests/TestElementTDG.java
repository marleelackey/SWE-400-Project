package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Classes.ElementDTO;
import Classes.ElementTDG;

public class TestElementTDG {

	@Test
	public void testSingleton() {
		ElementTDG c = ElementTDG.getInstance();
		ElementTDG d = ElementTDG.getInstance();
		assertNotEquals(c, null);
		assertNotEquals(d, null);
		assertEquals(c, d);
	}
	
	@Test
	public void testGetElementsInRange() {
		ElementTDG c = ElementTDG.getInstance();
		ArrayList<ElementDTO> result = new ArrayList<ElementDTO>();
		result = c.getElementsInRange(0, 100);
		//Test to make sure it gets the correct number of dtos
		assertEquals(4, result.size());
		//Test to make sure all dto atomic masses are in range
		for(int i = 0; i < result.size(); i++) {
			if((result.get(i).getAtomicMass() < 1) || result.get(i).getAtomicMass() > 100) {
				fail("Atomic mass not in range");
			}
		}
		System.out.println("All atomic masses in range");
	}

}
