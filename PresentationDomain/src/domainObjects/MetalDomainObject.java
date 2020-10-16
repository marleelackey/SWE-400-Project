package domainObjects;

import mappers.MetalMapper;

/**
 * 
 * @author Marlee Lackey
 * @author Taryn Whitman
 *
 */
public class MetalDomainObject {

	/**
	 * Instance variables
	 */
	private MetalMapper dataMapper;
	private int metalID;
	private String metalName;
	private int metalAtomicNumber;
	private double metalAtomicMass;
	private int acidID;

	/**
	 * Constructor
	 * 
	 * @param mm the MetalMapper that created this MetalDomainObject
	 */
	public MetalDomainObject(MetalMapper mm) throws Exception {
		dataMapper = mm;
		setMetalID(dataMapper.getIdent());
		setMetalName(dataMapper.getName());
		setMetalAtomicNumber(dataMapper.getAtomicNumber());
		setMetalAtomicMass(dataMapper.getAtomicMass());
		mm.setMetal(this);
	}

	/**
	 * Getter for dataMapper
	 * 
	 * @return dataMapper
	 */
	public MetalMapper getDataMapper() {
		return dataMapper;
	}

	/**
	 * Setter for metalID
	 * 
	 * @param id
	 */
	public void setMetalID(int id) {
		metalID = id;
	}

	/**
	 * Getter for metalID
	 * 
	 * @return metalID
	 */
	public int getMetalID() {
		return metalID;
	}

	/**
	 * Setter for metalName
	 * 
	 * @param name
	 * @throws Exception if name is more than 1 word
	 */
	public void setMetalName(String name) throws Exception {
		if (name.contains(" ")) { // if it contains a space, it has 2 words and therefore is illegal
			throw new Exception("Metal name should only be one word with no spaces.");
		} else {
			metalName = name;
		}
	}

	/**
	 * Getter for metalName
	 * 
	 * @return metalName
	 */
	public String getMetalName() {
		return metalName;
	}

	/**
	 * Setter for metalAtomicNumber
	 * 
	 * @param an
	 * @throws Exception if atomicNumber > atomicMass
	 */
	public void setMetalAtomicNumber(int an) throws Exception {
		if (an > metalAtomicMass) {
			throw new Exception("You can not have an atomic number that is greater than the atomic mass.");
		} else {
			metalAtomicNumber = an;
		}
	}

	/**
	 * Getter for metalAtomicNumber
	 * 
	 * @return
	 */
	public int getMetalAtomicNumber() {
		return metalAtomicNumber;
	}

	/**
	 * Setter for metalAtomicMass
	 * 
	 * @param am
	 */
	public void setMetalAtomicMass(double am) {
		metalAtomicMass = am;
	}

	/**
	 * Getter for metalAtomicMass
	 * 
	 * @return metalAtomicMass
	 */
	public double getMetalAtomicMass() {
		return metalAtomicMass;
	}

	/**
	 * Setter for acidID
	 * 
	 * @param id
	 */
	public void setAcidID(int id) {
		acidID = id;
	}

	/**
	 * Getter for acidID
	 * 
	 * @return acidID
	 */
	public int getAcidID() {
		return acidID;
	}

	/**
	 * Call the persist() method in DataMapper to persist the changes made to
	 * element
	 */
	public void persist() {
		dataMapper.persist();
	}
}
