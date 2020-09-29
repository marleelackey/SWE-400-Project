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

	public void setCompoundID(int id) {
		this.compoundID = id;
		
	}
	
	public int getCompoundID() {
		return compoundID;
	}
}
