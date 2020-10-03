package Classes;

/**
 * 
 * @author Marlee Lackey
 * @author Taryn Whitman
 */
public class CompoundDTO {
	private int compoundID;
	private String compoundName;
	
	/**
	 * Constructor for CompoundDTO
	 * @param id Pass in the ID for the compound
	 * @param name Pass in the name for the compound
	 */
	public CompoundDTO(int id, String name) {
		setCompoundID(id);
		setCompoundName(name);
	}

	
	/**
	 * Getter for compoundName
	 * @return compoundName name of the compound
	 */
	public String getCompoundName() {
		return compoundName;
	}

	/**
	 * Setter for compoundName
	 * @param compoundName name of the compound
	 */
	public void setCompoundName(String compoundName) {
		this.compoundName = compoundName;
	}

	/**
	 * Getter for compoundID
	 * @return compoundID ID of the compound
	 */
	public int getCompoundID() {
		return compoundID;
	}

	/**
	 * Setter for compoundID
	 * @param compoundID ID of the compound
	 */
	public void setCompoundID(int compoundID) {
		this.compoundID = compoundID;
	}
	

	
}
