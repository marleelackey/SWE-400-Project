package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import Classes.ChemicalDTO;

public class TestChemicalDTO {

	@Test
	public void testConstructorAndGetters() {
		ChemicalDTO dto = new ChemicalDTO(1, 2, "Boron", 5, 21.3, 7, 9, 12);

		assertEquals(dto.getID(), 1);
		assertEquals(dto.getType(), 2);
		assertEquals(dto.getName(), "Boron");
		assertEquals(dto.getAtomicNumber(), 5);
		assertEquals(dto.getAtomicMass(), 21.3, 0);
		assertEquals(dto.getDissolvedBy(), 7);
		assertEquals(dto.getSoluteA(), 9);
		assertEquals(dto.getSoluteB(), 12);
	}

}