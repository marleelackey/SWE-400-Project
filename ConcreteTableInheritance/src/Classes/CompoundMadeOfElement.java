package Classes;

/**
 * 
 * @author Marlee Lackey
 * @author Taryn Whitman
 *
 */
public class CompoundMadeOfElement {

	private int compoundID;
	private int elementID;
	
	public CompoundMadeOfElement(int compoundID, int elementID) {
		this.compoundID = compoundID;
		this.elementID = elementID;
	}
	
	// getters
	public int getElementID() {
		return elementID;
	}
	
	public int getCompoundID() {
		return compoundID;
	}
}
