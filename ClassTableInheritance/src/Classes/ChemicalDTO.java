package Classes;

/**
 * Data Transfer Object for a Chemical
 * 
 * @author everyone
 *
 */
public class ChemicalDTO {

	private int chemicalID;
	private String chemicalName;

	/**
	 * Constructor for Chemical DTO
	 * 
	 * @param id   the ID of the chemical
	 * @param name the name of the chemical
	 */
	public ChemicalDTO(int id, String name) {
		chemicalID = id;
		chemicalName = name;
	}

	public int getChemicalID() {
		return chemicalID;
	}

	public String getChemicalName() {
		return chemicalName;
	}

}