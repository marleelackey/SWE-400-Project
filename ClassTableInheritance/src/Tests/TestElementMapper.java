package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import DomainObjects.ElementDomainObject;
import mappers.ElementMapper;
import datasource.ChemicalRDG;
import datasource.DatabaseException;
import datasource.DatabaseManager;
import datasource.ElementRDG;

public class TestElementMapper {
	
	@Test
	public static void testCreateElement() {
		ElementMapper mapper = new ElementMapper(40, "element", 20, 10, 4.5);
		try {
			DatabaseManager.getSingleton().setTesting();
			ElementDomainObject e = mapper.createElement();
			e.persist();
			assertEquals(e, ElementMapper.identityMap.get(40));
			assertEquals("element", e.getElementName());

			ChemicalRDG rdg = ChemicalRDG.findByID(40);
			assertEquals("element", rdg.getChemicalName());
			
			ElementRDG rdg2 = ElementRDG.findByID(40);
			assertEquals(20, rdg2.getAtomicNumber());
			assertEquals(10, rdg2.getAtomicMass(), 0.001);

			
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
