package datasource;

/**
 * 
 * @author Dan Holmgren
 *
 */
public class CompoundMadeOfElementDTO {
	private int compoundID,
				elementID;
	/**
	 * Constructor for CompoundMadeOfElement
	 * @param cID The compound ID
	 * @param eID The element ID
	 */
	public CompoundMadeOfElementDTO(int cID, int eID) {
		this.compoundID = cID;
		this.elementID = eID;
	}
	
	/**
	 * Getter for compoundID
	 * @return The compoundID
	 */
	public int getCompoundID() {
		return compoundID;
	}
	
	/**
	 * Getter for elementID
	 * @return The elementID
	 */
	public int getElementID() {
		return elementID;
	}
}
