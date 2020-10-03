package Classes;

/**
 * Data Transfer Object for a Chemical
 * @author everyone
 *
 */
public class ChemicalDTO {
	
	private int chemicalID;
	private String chemicalName;
	private int chemicalType;
	
	/**
	 * Constructor for Chemical DTO
	 * @param id the ID of the chemical
	 * @param name the name of the chemical
	 * @param type the type of the chemical
	 */
	public ChemicalDTO(int id, String name, int type) {
		chemicalID = id;
		chemicalName = name;
		chemicalType = type;
	}

	public int getChemicalID() {
		return chemicalID;
	}

	public String getChemicalName() {
		return chemicalName;
	}
	
	public int getChemicalType() {
		return chemicalType;
	}

}