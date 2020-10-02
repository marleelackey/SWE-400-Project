package Tests;
import static org.junit.Assert.*;
import java.sql.*;
import org.junit.*;
import Classes.ChemicalDTO;
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
		
		ChemicalRDG chemical = new ChemicalRDG(9, 2, "bobrogyn", 51, 20.7, 52, 53, 2);
		assertEquals(chemical.getID(), 9);
		assertEquals(chemical.getType(), 2);
		assertEquals(chemical.getName(), "bobrogyn");
		assertEquals(chemical.getAtomicNumber(), 51);
		assertEquals(chemical.getAtomicMass(), 20.7, 0.001);
		assertEquals(chemical.getDissolvedBy(), 52);
		assertEquals(chemical.getSoluteA(), 53);
		assertEquals(chemical.getSoluteB(), 2);
	}

	@Test
	public static void findersTest() throws DatabaseException{
		//ChemicalRDG chem = new ChemicalRDG(3, 2, "bobrogyn", 2, 2.999, 1, 0, 1 );
		//ChemicalDTO d = nnewew ChemicalDTO(3, 2, "bobrogyn", 2, 2.999, 1, 0, 1);
		//ChemicalRDG chem = new ChemicalRDG(3, 0, "name2", 5, 20.9, 5, 5,6);
		ChemicalRDG chem = ChemicalRDG.findByIDSingle(3);
		assertEquals(chem.getID(), 3);
		assertEquals(chem.getType(), 0);
		assertEquals(chem.getName(), "name2");
		assertEquals(chem.getAtomicNumber(), 5);
		assertEquals(chem.getAtomicMass(), 20.9, 0.001);
		assertEquals(chem.getDissolvedBy(), 5);
		assertEquals(chem.getSoluteA(), 5);
		assertEquals(chem.getSoluteB(), 6);
		
		ChemicalRDG chem1 = ChemicalRDG.findByName("name2");
		assertEquals(chem1.getID(), 3);
		assertEquals(chem1.getType(), 0);
		assertEquals(chem1.getName(), "name2");
		assertEquals(chem1.getAtomicNumber(), 5);
		assertEquals(chem1.getAtomicMass(), 20.9, 0.001);
		assertEquals(chem1.getDissolvedBy(), 5);
		assertEquals(chem1.getSoluteA(), 5);
		assertEquals(chem1.getSoluteB(), 6);
		
		String chemmm = ChemicalRDG.findTypeByName("name2");
		assertEquals("Chemical", chemmm);
		
		ChemicalRDG chem2 = ChemicalRDG.findByAtomicNumber(5);
		assertEquals(chem2.getID(), 3);
		assertEquals(chem2.getType(), 0);
		assertEquals(chem2.getName(), "name2");
		assertEquals(chem2.getAtomicNumber(), 5);
		assertEquals(chem2.getAtomicMass(), 20.9, 0.001);
		assertEquals(chem2.getDissolvedBy(), 5);
		assertEquals(chem2.getSoluteA(), 5);
		assertEquals(chem2.getSoluteB(), 6);
		
		ChemicalRDG chem3 = ChemicalRDG.findByAtomicMass(20.9);
		assertEquals(chem3.getID(), 3);
		assertEquals(chem3.getType(), 0);
		assertEquals(chem3.getName(), "name2");
		assertEquals(chem3.getAtomicNumber(), 5);
		assertEquals(chem3.getAtomicMass(), 20.9, 0.001);
		assertEquals(chem3.getDissolvedBy(), 5);
		assertEquals(chem3.getSoluteA(), 5);
		assertEquals(chem3.getSoluteB(), 6);
		
		
	}
	
	@Test
	public static void updateTest() throws DatabaseException {
		ChemicalRDG chem = new ChemicalRDG(30, 2, "bobrogyn", 2, 2.999, 1, 0, 1 );
		chem.update();
		assertEquals(chem.getID(), 30);
		assertEquals(chem.getType(), 2);
		assertEquals(chem.getName(), "bobrogyn");
		assertEquals(chem.getAtomicNumber(), 2);
		assertEquals(chem.getAtomicMass(), 2.999, 0.001);
		assertEquals(chem.getDissolvedBy(), 1);
		assertEquals(chem.getSoluteA(), 0);
		assertEquals(chem.getSoluteB(), 1);
		
		// make a change and make sure its changed
		chem = new ChemicalRDG(30, 2, "bobrogyn", 3, 3.999, 1, 0, 1 );
		chem.update();
		assertEquals(chem.getID(), 30);
		assertEquals(chem.getType(), 2);
		assertEquals(chem.getName(), "bobrogyn");
		assertEquals(chem.getAtomicNumber(), 3);
		assertEquals(chem.getAtomicMass(), 3.999, 0.001);
		assertEquals(chem.getDissolvedBy(), 1);
		assertEquals(chem.getSoluteA(), 0);
		assertEquals(chem.getSoluteB(), 1);
	}

	public static void testAll() throws Exception {
		constructor1Test();
		findersTest();
		updateTest();
	}

}
