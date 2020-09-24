package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import Classes.ChemicalDTO;

/**
 * Test Class for Chemical DTO
 * 
 * @author Madeline and Adam
 *
 */
public class TestChemicalDTO {

	/**
	 * A JUnit to test manual insertion of data into a ChemicalDTO
	 */
	@Test
	public void testConstructorAndGetters() {
		ChemicalDTO dto = new ChemicalDTO(1, 2, "Boron", 5, 21.3, 7, 9, 12);

		assertEquals(dto.getChemicalID(), 1);
		assertEquals(dto.getChemicalType(), 2);
		assertEquals(dto.getChemicalName(), "Boron");
		assertEquals(dto.getChemicalAtomicNumber(), 5);
		assertEquals(dto.getChemicalAtomicMass(), 21.3, 0);
		assertEquals(dto.getChemicalDissolvedBy(), 7);
		assertEquals(dto.getChemicalSoluteA(), 9);
		assertEquals(dto.getChemicalSoluteB(), 12);
	}

}