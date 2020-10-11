package datasource;

/**
 * Data Transfer Object for a Chemical
 * 
 * @author everyone
 *
 */
public class ChemicalDTO {

	private int chemicalID;
	private String chemicalName;
	private int numMoles;

	/**
	 * Constructor for Chemical DTO
	 * 
	 * @param id   the ID of the chemical
	 * @param name the name of the chemical
	 */
	public ChemicalDTO(int id, String name, int numOfMoles) {
		chemicalID = id;
		chemicalName = name;
		numMoles = numOfMoles;
	}

	public int getChemicalID() {
		return chemicalID;
	}

	public String getChemicalName() {
		return chemicalName;
	}
	
	public int getNumMoles() {
		return numMoles;
	}

}