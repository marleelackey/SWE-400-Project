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

	// getters and setters

	public String getCompoundName() {
		return compoundName;
	}


	public void setCompoundName(String compoundName) {
		this.compoundName = compoundName;
	}

	public int getCompoundID() {
		return compoundID;
	}


	public void setCompoundID(int compoundID) {
		this.compoundID = compoundID;
	}
	

	
}
