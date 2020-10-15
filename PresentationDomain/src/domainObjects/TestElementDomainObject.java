package domainObjects;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestElementDomainObject {

	@Test
	public void testConstructorAndSetters() {
		ElementDataMapper d = new ElementDataMapper();
		ElementDomainObject e = new ElementDomainObject(d);
		assertEquals(e.getDataMapper(), d);
		assertEquals(e.setAcidID(123), e.getAcidID());
		assertEquals(e.setIsMetal(true), e.getIsMetal());
		assertEquals(e.setElementAtomicMass(123.1), e.getElementAtomicMass());
		assertEquals(e.setElementAtomicNumber(12), e.getElementAtomicNumber());
		assertEquals(e.setElementID(1222), e.getElementID());
		assertEquals(e.setElementName("Carodine"), e.getElementName());

		// test border cases
		assertNotEquals(e.setElementAtomicNumber(124), e.getElementAtomicNumber()); // atomic number cant be more than atomic mass
		assertNotEquals(e.setElementName("Carodine Rocks"), e.getElementName()); // name can't be two words
		
	}

}
