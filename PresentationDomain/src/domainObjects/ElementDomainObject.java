package domainObjects;

import mappers.ElementMapper;

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
	private ElementMapper dataMapper;
	private int elementID;
	private String elementName;
	private int elementAtomicNumber;
	private double elementAtomicMass;
	
	/**
	 * Constructor
	 * @param dm the data mapper that created this ElementDomainObject
	 * @throws Exception throws an exception if one of the setter's throw an exception
	 */
	public ElementDomainObject(ElementMapper dm) throws Exception {
		dataMapper = dm;
		setElementID(dm.getID());
        setElementName(dm.getName());
        setElementAtomicMass(dm.getAtomicMass());
        setElementAtomicNumber(dm.getAtomicNumber());
//        setIsMetal(dm.getIsMetal());
//        setAcidID(dm.getAcidID());
        // NOTE: these probably aren't needed anymore because whether it's a metal or not is being handled in the command.
        // there should be a metal domain object that has acid ID and all the other vars, but isMetal only exists at gui and command level
	}
	
	
	/**
	 * Set elementID 
	 * @param ID
	 */
	public void setElementID(int ID) {
		elementID = ID;
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
	
	/**
	 * Call the persist() method in DataMapper to persist the changes made to element
	 */
	public void persist() {
		dataMapper.persist();
	}
	
	/**
	 * Getter for elementID
	 * @return elementID
	 */
	public int getElementID() {
		return elementID;
	}
	
	/**
	 * Getter for elementName
	 * @return elementName
	 */
	public String getElementName() {
		return elementName;
	}

	/**
	 * Getter for elementAtomicMass
	 * @return elementAtomicMass
	 */
	public double getElementAtomicMass() {
		return elementAtomicMass;
	}
	
	/**
	 * Getter for elementAtomicNumber
	 * @return elementAtomicNumber
	 */
	public int getElementAtomicNumber() {
		return elementAtomicNumber;
	}
	
	/**
	 * Getter for IsMetal
	 * @return isMetal
	 */
	public boolean getIsMetal() {
		return isMetal;
		
	}
	
	/**
	 * Getter for acidID
	 * @return acidID
	 */
	public int getAcidID() {
		return acidID;
	}
	
	/**
	 * Return the data mapper that created the domain object
	 * @return dataMapper
	 */
	public ElementMapper getDataMapper() {
		return dataMapper;
	}
	
	}
