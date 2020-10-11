package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Mappers.ElementMapper;
import datasource.ChemicalRDG;
import datasource.DatabaseException;
import datasource.DatabaseManager;

public class TestElementMapper {
	
	@Test
	public static void testCreateElement() {
		ElementMapper mapper = new ElementMapper(40, "element", 10, 10);
		try {
			DatabaseManager.getSingleton().setTesting();
			mapper.createElement();
			ChemicalRDG rdg = ChemicalRDG.findByIDSingle(40);
			assertEquals("element", rdg.getName());
			DatabaseManager.getSingleton().rollBack();


		} catch (Exception e) {
			e.printStackTrace();
			DatabaseException.detectError(e, "Exception in TestElementMapper.testCreateElement()");
		}
	}

	public static void runAllTheTests() {
		testCreateElement();
		
	}

}
