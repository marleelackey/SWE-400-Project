package commands;

/**
 * 
 * @author Madeline and Adam
 *
 */
public class DeleteElementFromCompoundCmd implements CommandInterface {

	private int elementID;
	private int compoundID;
	
	/**
	 * 
	 * Constructor
	 * 
	 * @param elementID
	 * @param compoundID
	 */
	public DeleteElementFromCompoundCmd(int elementID, int compoundID) {
		this.elementID = elementID;
		this.compoundID = compoundID;
	}
	
	
	/**
	 * We deleting elements from compounds out here
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


	public int getCompoundID() {
		return compoundID;
	}

}
