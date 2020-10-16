package domainObjects;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMetalDomainObject {

	@Test
	public void test() {
		
//		int ID, String elementName, int atomicNumber, double atomicMass, int dissolvedBy, double moles, double molesOfAcidToDissolve
		
		MetalMapper d = new MetalMapper(12, "Bobrogyn", 123, 2343.3, 2, 232.6, 345.3);
		MetalDomainObject e = new MetalDomainObject(d);
		assertEquals(e.getDataMapper(), d);
		assertEquals(e.getMetalAtomicMass(), 2343.3, 0.01);
		assertEquals(e.getMetalAtomicNumber(), 123);
		assertEquals(e.getMetalID(), 12);
		assertEquals(e.getMetalName(), "Bobrogyn");
		assertEquals(e.getAcidID(), 2);  //acid ID is equivelant to dissolvedBy I believe?
		
		// TODO: Should we add dissolvedBy, molesOfAcidToDissolve, etc to DO??

		// test border cases
		assertNotEquals(e.setMetalAtomicNumber(2500), e.getMetalAtomicNumber()); // atomic number cant be more than atomic mass
		assertNotEquals(e.setMetalName("Bobrogyn Rocks"), e.getMetalName()); // name can't be two words
	}

}
