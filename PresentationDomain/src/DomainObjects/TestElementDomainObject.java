package DomainObjects;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestElementDomainObject {

	@Test
	public void testConstructorAndSetters() {
		ElementDataMapper d = new ElementDataMapper();
		ElementDomainObject e = new ElementDomainObject(d);
		assertEquals(e.dataMapper, d);
		assertEquals(e.setAcidID(123), e.acidID);
		assertEquals(e.setElementAtomicMass(123.1), e.elementAtomicMass);
		assertEquals(e.setElementAtomicNumber(12), e.elementAtomicNumber);
		assertEquals(e.setElementID(1222), e.elementID);
		assertEquals(e.setElementName("Carodine"), e.elementName);

		// test border cases
		assertNotEquals(e.setElementAtomicNumber(124), e.elementAtomicNumber); // atomic number cant be more than atomic mass
		assertNotEquals(e.setElementName("Carodine Rocks"), e.elementName); // name can't be two words
		
	}

}
