package Classes;

/**
 * 
 * @author Marlee Lackey
 * @author Taryn Whitman
 *
 */
public class CompoundRDG {
	
	private int compoundID;
	private String compoundName;

	/**
	 * Constructor for CompoundRDG
	 * @param id Passes in the ID for CompoundRDG
	 * @param name Passes in the Name for CompoundRDG
	 */
	public CompoundRDG (int id, String name) {
		compoundID = id;
		compoundName = name;
	}

	// getters 
	public int getCompoundID() {
		return compoundID;
	}

	public String getCompoundName() {
		return compoundName;
	}
	
	// setters
	public void setCompoundID(int compoundID) {
		this.compoundID = compoundID;
	}

	public void setCompoundName(String compoundName) {
		this.compoundName = compoundName;
	}
	

}
