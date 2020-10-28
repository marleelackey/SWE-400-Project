package commands;

import domainObjects.CompoundDomainObject;
import mappers.CompoundMapper;

/**
 * Command class to modify how many atoms of an element are in one molecule of a
 * compound
 * 
 * @author Mad&Ad
 *
 */
public class ModifyElementInCompoundCmd {

	private int elementID;
	private int compoundID;
	private int newElementQuantity;

	/**
	 * Constructor
	 * 
	 * @param element  the ID of the element
	 * @param compound the ID of the compound
	 * @param quantity the new quantity of the element
	 */
	public ModifyElementInCompoundCmd(int element, int compound, int quantity) {
		elementID = element;
		compoundID = compound;
		newElementQuantity = quantity;
	}

	/**
	 * Execute method to invoke the modify element in compound command
	 * @throws Exception 
	 */
	public void execute() throws Exception {
		CompoundMapper cm = new CompoundMapper();
		CompoundDomainObject cdo = cm.findByID(compoundID);
		cdo.modifyElementQuantity(elementID, newElementQuantity);
		cdo.persist();
	}

	public int getElementID() {
		return elementID;
	}

	public int getCompoundID() {
		return compoundID;
	}

	public int getNewElementQuantity() {
		return newElementQuantity;
	}

}