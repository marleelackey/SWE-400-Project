package domainObjects;

import static org.junit.Assert.*;

import org.junit.Test;

import mappers.MetalMapper;

/**
 * @author Marlee Lackey
 * @author Taryn Whitman
 */
public class TestMetalDomainObject {

	/**
	 * Test that the constructor and setters work properly
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		
//		int ID, String elementName, int atomicNumber, double atomicMass, int dissolvedBy, double moles, double molesOfAcidToDissolve
		
		MetalMapper d = new MetalMapper();
		MetalDomainObject e = d.createMetal(12, "Bobrogyn", 123, 2343.3, 2, 232.6, 345.3);
		assertEquals(e.getDataMapper(), d);
		assertEquals(e.getMetalAtomicMass(), 2343.3, 0.01);
		assertEquals(e.getMetalAtomicNumber(), 123);
		assertEquals(e.getMetalID(), 12);
		assertEquals(e.getMetalName(), "Bobrogyn");
		assertEquals(e.getAcidID(), 2);  //acid ID is equivelant to dissolvedBy I believe?
		
		// TODO: Should we add dissolvedBy, molesOfAcidToDissolve, etc to DO??

		// test border cases
		e.setMetalAtomicNumber(2500);
		assertNotEquals(2500, e.getMetalAtomicNumber()); // atomic number cant be more than atomic mass
		e.setMetalName("Bobrogyn Rocks");
		assertNotEquals("Bobrogyn Rocks", e.getMetalName()); // name can't be two words
	}

}
