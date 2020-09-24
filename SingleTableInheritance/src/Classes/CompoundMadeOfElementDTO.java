package Classes;

/**
 * 
 * @author Dan Holmgren
 *
 */
public class CompoundMadeOfElementDTO {
	private int compoundID,
				elementID;
	/**
	 * @author Dan Holmgren
	 * @param cID The compound ID
	 * @param eID The element ID
	 */
	public CompoundMadeOfElementDTO(int cID, int eID) {
		this.compoundID = cID;
		this.elementID = eID;
	}
	
	/**
	 * 
	 * @return The compoundID
	 */
	public int getCompoundID() {
		return compoundID;
	}
	
	/**
	 * 
	 * @return The elementID
	 */
	public int getElementID() {
		return elementID;
	}
}
