package domainObjects;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Marlee Lackey
 * @author Taryn Whitman
 *
 */
public class TestChemicalDomainObject {

	@Test
	public void test() {
		ChemicalMapper c = new ChemicalMapper();
		ElementDomainObject e = new ElementDomainObject(c);
		assertEquals(e.getDataMapper(), c);
		assertEquals(e.setChemicalID(1222), e.getChemicalID());
		assertEquals(e.setChemicalMoles(23.22), e.getChemicalMoles());

		
	}

}
