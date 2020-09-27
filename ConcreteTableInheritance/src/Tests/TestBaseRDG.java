package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Classes.BaseRDG;
import Datasource.DatabaseManager;

public class TestBaseRDG {
	
	@Before
	public void SelectDatabase() {
		DatabaseManager.setPatternNumber(2);
	}

	@Test
	public void testBaseRDGConstructor() {
		BaseRDG dot = new BaseRDG(23, "Sodium Hydroxide" , 83);
		assertEquals(23, dot.getID());
		assertEquals("Sodium Hydroxide", dot.getName());
		assertEquals(83, dot.getSolute());
	}
	
	@Test
	public void testBaseRDG_findByID()
	{
		BaseRDG dot = BaseRDG.findByID(10);
		assertEquals("base2", dot.getName());
	}
	
	@Test
	public void testBaseRDG_findByName()
	{
		BaseRDG dot = BaseRDG.findByName("base2");
		assertEquals(10, dot.getID());
	}

	@Test
	public void testBaseRDG_Update() 
	{
		BaseRDG dot = BaseRDG.findByID(10);
		assertEquals("base2", dot.getName());
		dot.setName("Sodium Hydroxide");
		dot.update();
		BaseRDG doto = BaseRDG.findByID(10);
		assertEquals("Sodium Hydroxide", doto.getName());
	}

}
