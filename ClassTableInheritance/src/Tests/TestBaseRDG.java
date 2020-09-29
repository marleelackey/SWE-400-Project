package Tests;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import Classes.BaseRDG;
import Datasource.DatabaseException;
import Datasource.DatabaseManager;

public class TestBaseRDG {
	
	@Before
	public void runRunnable() {
		DatabaseManager.setPatternNumber(3);
	}
	
	@Test
	public void testBaseRDG() {
		BaseRDG rdg = new BaseRDG(1, 2);
		
		assertEquals(1, rdg.getID());
		assertEquals(2, rdg.getSolute());
		
		rdg.setID(3);
		rdg.setSolute(4);
		
		assertEquals(3, rdg.getID());
		assertEquals(4, rdg.getSolute());
	}
	
	@Test
	public void testFindByID() {
		BaseRDG rdg = BaseRDG.findByID(12);
		assertEquals(12, rdg.getID());
	}
	
	@Test
	public void testUpdate() {
		try {
			DatabaseManager.getSingleton().setTesting();
			
			BaseRDG rdg = new BaseRDG(12, 5);
			rdg.setSolute(7);
			rdg.update();
			
			BaseRDG rdg2 = BaseRDG.findByID(12);
			assertEquals(7, rdg2.getSolute());
			
			DatabaseManager.getSingleton().rollBack();			
		} catch (Exception e) {
			DatabaseException.detectError(e, "Exception in TestBaseRDG.testUpdate");
		}
	}

}
