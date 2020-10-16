package commands;


/**
 * 
 * @author Madeline and Adam
 *
 */
public class AddElementToCompoundCmd implements CommandInterface {

	private int elementID;
	private int elementQuantity;
	private int compoundID;
	
	/**
	 * 
	 * Constructor
	 * 
	 * @param elementID
	 * @param elementQuantity
	 * @param compoundID
	 */
	public AddElementToCompoundCmd(int elementID, int elementQuantity, int compoundID) {
		this.elementID = elementID;
		this.elementQuantity = elementQuantity;
		this.compoundID = compoundID;
	}
	
	/**
	 * Something about adding elements to a compound
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Getters
	 * 
	 */
	public int getElementID() {
		return elementID;
	}

	public int getElementQuantity() {
		return elementQuantity;
	}

	public int getCompoundID() {
		return compoundID;
	}
	
}
