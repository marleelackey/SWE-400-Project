package DomainObjects;

/**
 * 
 * @author Marlee Lackey
 * @author Taryn Whitman
 *
 */
public class ElementDomainObject {
	
	/**
	 * Instance variables
	 */
	ElementDataMapper dataMapper;
	int elementID;
	String elementName;
	int elementAtomicNumber;
	double elementAtomicMass;
	boolean isMetal;
	int acidID;
	
	/**
	 * Constructor
	 * @param dm the data mapper that created this ElementDomainObject
	 * @throws Exception throws an exception if one of the setter's throw an exception
	 */
	public ElementDomainObject(ElementDataMapper dm) throws Exception {
		dataMapper = dm;
		elementID.setElementID(dm.getID());
        elementName.setElementName(dm.getName());
        elementAtomicMass.setElementAtomicMass(dm.getAtomicMass());
        elementAtomicNumber.setElementAtomicNumber(dm.getAtomicNumber());
        isMetal.setIsMetal(dm.getIsMetal());
        acidID.setAcidID(dm.getAcidID());
 
	}
	
	
	/**
	 * Set elementID and check if the passed in elementID is allowed (check business logic)
	 * @param ID
	 * @throws Exception throws an exception if business logic is not met
	 */
	public void setElementID(int ID) throws Exception {
		elementID = ID;
		//TODO: check business logic, might be in compound not element tho
	}

	/**
	 * Set elementName and check if the passed in elementID is allowed (check business logic)
	 * @param name
	 * @throws Exception throws an exception if business logic is not met
	 */
	public void setElementName(String name) throws Exception {
		if(name.contains(" ")) { // if it contains a space, it has 2 words and therefore is illegal
			throw new Exception("Element name should only be one word with no spaces.");
		}
		else {
			elementName = name;
		}
	}

	/**
	 * Set elementAtomicNumber and check if the passed in elementID is allowed (check business logic)
	 * @param atomicNumber
	 * @throws Exception throws an exception if business logic is not met
	 */
	public void setElementAtomicNumber(int atomicNumber) throws Exception {
		if(atomicNumber > elementAtomicMass) {
			throw new Exception("You can not have an atomic number that is greater than the atomic mass.");
		}
		else {
			elementAtomicNumber = atomicNumber;
		}
		
	}

	/**
	 * Set elementAtomicMass 
	 * @param atomicMass
	 */
	public void setElementAtomicMass(double atomicMass) {
		elementAtomicMass = atomicMass;
	}

	/**
	 * Set isMetal
	 * @param isM
	 */
	public void setMetal(boolean isM) {
		isMetal = isM;
	}

	/**
	 * Set AcidID 
	 * @param a_ID
	 */
	public void setAcidID(int a_ID) {
		acidID = a_ID;
	}
	
	public void persist() {
		
	}
}
