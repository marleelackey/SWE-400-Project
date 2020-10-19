package domainObjects;

import mappers.ChemicalMapper;

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
		setChemicalID(dataMapper.getID());
		setChemicalMoles(dataMapper.getMoles());
		dm.setCdo(this);
	}

	/**
	 * Setter for chemicalID
	 * 
	 * @param id
	 */
	public void setChemicalID(int id) {
		chemicalID = id;
	}

	/**
	 * Getter for chemicalID
	 * 
	 * @return chemicalID
	 */
	public int getChemicalID() {
		return chemicalID;
	}

	/**
	 * Setter for chemcialMoles
	 * 
	 * @param mole
	 */
	public void setChemicalMoles(double mole) {
		chemicalMoles = mole;
	}

	/**
	 * Getter for chemicalMoles
	 * 
	 * @return chemicalMoles
	 */
	public double getChemicalMoles() {
		return chemicalMoles;
	}

	/**
	 * Return the data mapper that created the domain object
	 * 
	 * @return dataMapper
	 */
	public ChemicalMapper getDataMapper() {
		return dataMapper;
	}

	public void persist() {
		dataMapper.persist();
	}

}