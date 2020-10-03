package Tests;
import static org.junit.Assert.*;
import org.junit.*;
import Classes.ChemicalRDG;
import Datasource.DatabaseException;
/** 
 * 
 * @author Taryn Whitman
 * @author Marlee Lackey
 *
 */

public class TestChemicalRDG {
	
	/* 
	 * test the constructor that makes an object from a tuple already stored in the database
	 */
	@Test
	public static void constructor1Test() throws DatabaseException {
		
		ChemicalRDG chemical = new ChemicalRDG(4, "idk", 0);
		assertEquals(chemical.getChemicalID(), 4);
		assertEquals(chemical.getChemicalName(), "idk");
		assertEquals(chemical.getChemicalType(), 0);
	}

	/**
	 * Test the find by methods for Chemical RDG
	 * @throws DatabaseException
	 */
	@Test
	public static void findersTest() throws DatabaseException{
		ChemicalRDG chem = ChemicalRDG.findByID(5);
		assertEquals(chem.getChemicalID(), 5);
		assertEquals(chem.getChemicalName(), "element2");
		assertEquals(chem.getChemicalType(), 3);
		
		ChemicalRDG chem1 = ChemicalRDG.findByName("acid1");
		assertEquals(chem1.getChemicalID(), 1);
		assertEquals(chem1.getChemicalName(), "acid1");
		assertEquals(chem1.getChemicalType(), 2);
		
		String chemmm = ChemicalRDG.findTypeByName("acid2");
		assertEquals("Acid", chemmm);
	}

	public static void runAllTheTests() throws Exception {
		constructor1Test();
		findersTest();
	}

}