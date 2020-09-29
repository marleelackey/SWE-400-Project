package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Classes.BaseDTO;
import Classes.BaseTDG;
import Datasource.DatabaseManager;

public class TestBaseTDG {
	
	
	@Before
	public void runRunnable() {
		DatabaseManager.setPatternNumber(3);
	}
	
	@Test
	public void testGetAllBases() {
		ArrayList<BaseDTO> list = new ArrayList<BaseDTO>();
		
		list = BaseTDG.getAllBases();
		assertEquals(list.get(0).getID(), 12);
		assertEquals(list.get(1).getID(), 13);

		
	}


}
