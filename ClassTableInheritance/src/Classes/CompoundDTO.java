package Classes;
/**
 * 
 * @author Marlee Lackey
 * @author Taryn Whitman
 *
 */
public class CompoundDTO {
	private int compoundID;

	/** 
	 * Constructor for CompountDTO
	 * @param id of compound
	 */
	public CompoundDTO(int id) {
		setCompoundID(id);
	}

	/**
	 * Setter for compoundID
	 * @param id the new value of ID you want to set
	 */
	public void setCompoundID(int id) {
		this.compoundID = id;
		
	}
	
	/**
	 * Getter for compoundID
	 * @return compoundID
	 */
	public int getCompoundID() {
		return compoundID;
	}
}
