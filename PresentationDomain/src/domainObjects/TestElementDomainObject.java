package domainObjects;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestElementDomainObject {

	@Test
	public void testConstructorAndSetters() {
		// int ID, String elementName, int atomicNumber, double atomicMass, double moles
		ElementMapper d = new ElementMapper(23, "Carodine", 2, 234.22, 28.2);
		ElementDomainObject e = new ElementDomainObject(d);
		assertEquals(e.getDataMapper(), d);
		assertEquals(e.getElementAtomicMass(), 234.22, 0.01);
		assertEquals(e.getElementAtomicNumber(), 2);
		assertEquals(e.getElementID(), 23);
		assertEquals(e.getElementName(), "Carodine");

		// test border cases
		assertNotEquals(e.setElementAtomicNumber(1111), e.getElementAtomicNumber()); // atomic number cant be more than atomic mass
		assertNotEquals(e.setElementName("Carodine Rocks"), e.getElementName()); // name can't be two words
		
	}

}
