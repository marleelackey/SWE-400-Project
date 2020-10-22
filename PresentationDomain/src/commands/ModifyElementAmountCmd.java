package commands;

import domainObjects.ElementDomainObject;
import mappers.ElementMapper;

/**
 * Command class to modify an element's amount in inventory
 * 
 * @author Madeline and Adam
 *
 */
public class ModifyElementAmountCmd implements CommandInterface {

	private int eID;
	private double newMoles;

	/**
	 * Constructor
	 * 
	 * @param id  the ID of the element we want to modify
	 * @param mol the new number of moles of the element in inventory
	 */
	public ModifyElementAmountCmd(int id, double mol) {
		eID = id;
		newMoles = mol;
	}

	/**
	 * Execute method to invoke the ModifyElementAmountCmd
	 * 
	 * @throws Exception
	 */
	@Override
	public void execute() throws Exception {
		ElementMapper em = new ElementMapper();
		ElementDomainObject edo = em.findByID(eID);
		edo.setElementMoles(newMoles);
		edo.persist();
	}

}