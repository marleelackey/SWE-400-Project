package commands;

import domainObjects.CompoundDomainObject;
import mappers.CompoundMapper;
import mappers.ElementMapper;

/**
 * Command class to add an existing element to an existing compound
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
	 * @param elementID       the ID of the element to be added
	 * @param elementQuantity the quantity of the element
	 * @param compoundID      the ID of the compound to add the element to
	 */
	public AddElementToCompoundCmd(int elementID, int elementQuantity, int compoundID) {
		this.elementID = elementID;
		this.elementQuantity = elementQuantity;
		this.compoundID = compoundID;
	}

	/**
	 * Execute method that invokes the add element to a compound command
	 */
	@Override
	public void execute() {
		CompoundMapper cm = new CompoundMapper();
		CompoundDomainObject cdo = cm.findByID(compoundID);
		cdo.addElement(elementID, elementQuantity);
		cdo.persist();
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
