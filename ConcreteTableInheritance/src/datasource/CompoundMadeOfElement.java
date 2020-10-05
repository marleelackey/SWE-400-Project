package datasource;

/**
 * 
 * @author Marlee Lackey
 * @author Taryn Whitman
 *
 */
public class CompoundMadeOfElement {

	private int compoundID;
	private int elementID;
	
	/**
	 * Constructor for CompoundMadeOfElement
	 * @param compoundID ID of the compound
	 * @param elementID ID of the element
	 */
	public CompoundMadeOfElement(int compoundID, int elementID) {
		this.compoundID = compoundID;
		this.elementID = elementID;
	}
	
	/**
	 * Getter for elementID
	 * @return elementID
	 */
	public int getElementID() {
		return elementID;
	}
	
	/**
	 * Getter for compoundID
	 * @return compoundID
	 */
	public int getCompoundID() {
		return compoundID;
	}
}
