package DomainObjects;

/**
 * 
 * @author Marlee Lackey
 * @author Taryn Whitman
 *
 */
public class ElementDomainObject {
	private int atomicNumber,
				ID;
	
	
	/**
	 * createConstructor for Single table 
	 * @param ID
	 * @param type
	 * @param name
	 * @param atomicNumber
	 * @param atomicMass
	 * @param dissolvedBy
	 * @param soluteA
	 * @param soluteB
	 * @param moles
	 */
	public void createConstructor(int ID, int type, String name, int atomicNumber, double atomicMass, int dissolvedBy, int soluteA,
			int soluteB, double moles) {
		ElementMapper em = new ElementMapper(ID, type, name, atomicNumber, atomicMass, dissolvedBy, soluteA, soluteB, moles);
		em.createElement(ID, name, atomicNumber, atomicMass);
		
	}
	
	public void findConstructor(/*paramsn*/) {
		ElementMapper em = new ElementMapper(/* param */);
		em.findByID(); // only an example
	}

}
