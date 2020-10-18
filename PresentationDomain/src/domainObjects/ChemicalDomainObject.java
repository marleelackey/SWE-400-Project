package domainObjects;

/**
 * 
 * @author Marlee Lackey
 * @author Taryn Whitman
 *
 */
public class ChemicalDomainObject {
	private ChemicalMapper dataMapper;
	private int chemicalID;
	private double chemicalMoles;
	
	public ChemicalDomainObject(ChemicalMapper dm) {
		dataMapper = dm;
		chemicalID.setChemicalID(dataMapper.getID());
		chemicalMoles.setChemicalMoles(dataMapper.getMoles());
	}
	
	/**
	 * Setter for chemicalID
	 * @param id
	 */
	public void setChemicalID(int id) {
		chemicalID = id;
	}
	
	/**
	 * Getter for chemicalID
	 * @return chemicalID
	 */
	public int getChemicalID() {
		return chemicalID;
	}
	
	/**
	 * Setter for chemcialMoles
	 * @param mole
	 */
	public void setChemicalMoles(double mole) {
		chemicalMoles = mole;
	}
	
	/**
	 * Getter for chemicalMoles
	 * @return chemicalMoles
	 */
	public double getChemicalMoles() {
		return chemicalMoles;
	}
	
	/**
	 * Return the data mapper that created the domain object
	 * @return dataMapper
	 */
	public ChemicalMapper getDataMapper() {
		return dataMapper;
	}
	
	/**
	 * Call the persist() method in DataMapper to persist the changes made to chemical
	 */
	public void persist() {
		dataMapper.persist();
	}

}
