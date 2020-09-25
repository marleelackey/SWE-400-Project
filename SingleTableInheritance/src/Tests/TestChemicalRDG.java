package Tests;
import static org.junit.Assert.*;
import java.sql.*;
import org.junit.Test;
import Classes.ChemicalDTO;
import Classes.ChemicalRDG;
import Datasource.DatabaseException;
/** 
 * Test class for ChemicalRDG
 * @author Taryn Whitman
 * @author Marlee Lackey
 *
 */

public class TestChemicalRDG {
	protected ChemicalRDG chemical;
	protected Connection connection;
	

	/**
	 * test that the constructor works and that the getters work
	 */
	@Test
	public void constructorTest() throws DatabaseException {
		ChemicalRDG chem = new ChemicalRDG(2, 2, "bobrogyn", 2, 2.999, 1, 0, 1 );
		assertEquals(chem.getID(), 2);
		assertEquals(chem.getType(), 2);
		assertEquals(chem.getName(), "bobrogyn");
		assertEquals(chem.getAtomicNumber(), 2);
		assertEquals(chem.getAtomicMass(), 2.999, 0.001);
		assertEquals(chem.getDissolvedBy(), 1);
		assertEquals(chem.getSoluteA(), 0);
		assertEquals(chem.getSoluteB(), 1);
	}
	
	// comment 
	//comment
	//comment
	
	/**
	 * Tests that the finders work properly
	 * @throws DatabaseException
	 */
	@Test
	public void findersTest() throws DatabaseException{
		ChemicalRDG chem = new ChemicalRDG(2, 2, "bobrogyn", 2, 2.999, 1, 0, 1 );
		ChemicalDTO d = new ChemicalDTO(3, 2, "bobrogyn", 2, 2.999, 1, 0, 1);
		assertEquals(chem.findByIDSingle(3), d);
		assertEquals(chem.findByName("bobrogyn"), d);
		assertEquals(chem.findByAtomicNumber(2), d);
		assertEquals(chem.findByAtomicMass(2.999), d);
		
	}
	
	/**
	 * Tests that the update() method works properly
	 * @throws DatabaseException
	 */
	@Test
	public void updateTest() throws DatabaseException {
		ChemicalRDG chem = new ChemicalRDG(2, 2, "bobrogyn", 2, 2.999, 1, 0, 1 );
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
		chem = new ChemicalRDG(3, 2, "bobrogyn", 3, 3.999, 1, 0, 1 );
		chem.update();
		assertEquals(chem.getID(), 3);
		assertEquals(chem.getType(), 2);
		assertEquals(chem.getName(), "bobrogyn");
		assertEquals(chem.getAtomicNumber(), 3);
		assertEquals(chem.getAtomicMass(), 3.999, 0.001);
		assertEquals(chem.getDissolvedBy(), 1);
		assertEquals(chem.getSoluteA(), 0);
		assertEquals(chem.getSoluteB(), 1);
	}

}
