package datasource;

/**
 * @author Joshua Kellogg
 * @author Daniel Holmgren
 * 
 * The data transfer object for metal
 */
public class MetalDTO {
	private int ID,
				dissolvedBy;

	/**
	 * Constructor, assigns instance variables
	 * @param ID
	 * @param dissolvedBy
	 */
	public MetalDTO(int ID, int dissolvedBy) {
		this.ID = ID;
		this.dissolvedBy = dissolvedBy;
	}
	
	// Getters and setter
	public int getID() {
		return ID;
	}

	public int getDissolvedBy() {
		return dissolvedBy;
	}

	public void setDissolvedBy(int dissolvedBy) {
		this.dissolvedBy = dissolvedBy;
	}
}
