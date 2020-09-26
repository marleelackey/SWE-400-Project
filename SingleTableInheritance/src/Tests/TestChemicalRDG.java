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
	 * test that the constructor works and that the getters work
	 */
	@Test
	public static void constructorTest() throws DatabaseException {
		ChemicalRDG chem = new ChemicalRDG(20, 2, "bobrogyn", 2, 2.999, 1, 0, 1  );
		assertEquals(chem.getID(), 2);
		assertEquals(chem.getType(), 2);
		assertEquals(chem.getName(), "bobrogyn");
		assertEquals(chem.getAtomicNumber(), 2);
		assertEquals(chem.getAtomicMass(), 2.999, 0.001);
		assertEquals(chem.getDissolvedBy(), 1);
		assertEquals(chem.getSoluteA(), 0);
		assertEquals(chem.getSoluteB(), 1);
		
	}
	
	@Test
	public static void findersTest() throws DatabaseException{
		ChemicalRDG chem = new ChemicalRDG(31, 2, "bobrogyn", 2, 2.999, 1, 0, 1 );
		ChemicalDTO d = new ChemicalDTO(3, 2, "bobrogyn", 2, 2.999, 1, 0, 1);
		assertEquals(chem.findByIDSingle(3), d);
		assertEquals(chem.findByName("bobrogyn"), d);
		assertEquals(chem.findByAtomicNumber(2), d);
		assertEquals(chem.findByAtomicMass(2.999), d);
		
	}
	
	@Test
	public static void updateTest() throws DatabaseException {
		ChemicalRDG chem = new ChemicalRDG(30, 2, "bobrogyn", 2, 2.999, 1, 0, 1 );
		chem.update();
		assertEquals(chem.getID(), 2);
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
		assertEquals(chem.getID(), 2);
		assertEquals(chem.getType(), 2);
		assertEquals(chem.getName(), "bobrogyn");
		assertEquals(chem.getAtomicNumber(), 3);
		assertEquals(chem.getAtomicMass(), 3.999, 0.001);
		assertEquals(chem.getDissolvedBy(), 1);
		assertEquals(chem.getSoluteA(), 0);
		assertEquals(chem.getSoluteB(), 1);
	}

	public static void testAll() throws Exception {
		constructorTest();
		findersTest();
		updateTest();
	}

}
