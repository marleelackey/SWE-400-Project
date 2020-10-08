package DomainObjects;

import java.sql.ResultSet;

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
	 * @param isMetal
	 * @param acidID
	 */
	public void createConstructor(int ID, int type, String name, int atomicNumber, double atomicMass, int dissolvedBy, int soluteA,
			int soluteB, double moles, boolean isMetal, int acidID) {
		ElementMapper em = new ElementMapper(ID, type, name, atomicNumber, atomicMass, dissolvedBy, soluteA, soluteB, moles, isMetal, acidID);
		em.createElement(ID, name, atomicNumber, atomicMass, isMetal, acidID);
		
	}
	
	/**
	 * createConstructor() for concrete table
	 * @param ID
	 * @param atomicNumber
	 * @param atomicMass
	 * @param name
	 * @param isMetal
	 * @param acidID
	 */
	public void createConstructor(int ID, int atomicNumber, double atomicMass, String name, boolean isMetal, int acidID) {
		ElementMapper em = new ElementMapper(ID, name, atomicNumber, atomicMass, isMetal, acidID);
		em.createElement(ID, name, atomicNumber, atomicMass, isMetal, acidID);
	}
	
	/**
	 * createConstructor() for class table
	 * @param ID
	 * @param atomicNumber
	 * @param atomicMass
	 * @param isMetal
	 * @param acidID
	 */
	public void createConstructor(int ID, int atomicNumber, double atomicMass, boolean isMetal, int acidID) {
		
	}
	
	public void findConstructor(int id) {
		ElementMapper em = new ElementMapper(/* param */);
		ResultSet rs = null;
		rs.findByID(id); 
	}

}
