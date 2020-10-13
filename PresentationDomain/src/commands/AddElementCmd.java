/**
 * 
 */
package commands;

import mappers.ElementMapper;
import mappers.MetalMapper;

/**
 * 
 * A command to add an element to the database
 * 
 * @authors Madeline and Adam
 *
 */
public class AddElementCmd implements CommandInterface {

	private int elementID;
	private String elementName;
	private int elementAtomicNumber;
	private double elementAtomicMass;
	private boolean isMetal;
	private int acidID;
	private double elementMoles;
	private double elementMolesOfAcidToDissolve;

	/**
	 * Constructor
	 * 
	 * @param id            the ID of the element
	 * @param name          the name of the element
	 * @param num           the atomic number of the element
	 * @param mass          the atomic mass of the element
	 * @param metal         whether the element is a metal or not
	 * @param a_id          the acid that dissolves the element if it's a metal
	 * @param mol           the number of moles of the element we have in inventory
	 * @param molToDissolve the number of moles of an acid it takes to dissolve a
	 *                      mole of the element
	 */
	public AddElementCmd(int id, String name, int num, double mass, boolean metal, int a_id, double mol,
			double molToDissolve) {
		elementID = id;
		elementName = name;
		elementAtomicNumber = num;
		elementAtomicMass = mass;
		isMetal = metal;
		acidID = a_id;
		elementMoles = mol;
		elementMolesOfAcidToDissolve = molToDissolve;
	}

	/**
	 * Execute the AddElementCmd by creating a mapper and receiving a domain object
	 */
	@Override
	public void execute() {
		if (isMetal()) {
			MetalMapper mm = new MetalMapper(elementID, elementName, elementAtomicNumber, elementAtomicMass, acidID,
					elementMoles, elementMolesOfAcidToDissolve);
			MetalDomainObject mdo = mm.createMetal();
			mdo.persist();
		} else {
			ElementMapper em = new ElementMapper(elementID, elementName, elementAtomicNumber, elementAtomicMass,
					elementMoles);
			ElementDomainObject edo = em.createElement();
			edo.persist();
		}
		// BOO!!!
	}

	public int getElementID() {
		return elementID;
	}

	public String getElementName() {
		return elementName;
	}

	public int getElementAtomicNumber() {
		return elementAtomicNumber;
	}

	public double getElementAtomicMass() {
		return elementAtomicMass;
	}

	public boolean isMetal() {
		return isMetal;
	}

	public int getAcidID() {
		return acidID;
	}

	public double getElementMoles() {
		return elementMoles;
	}

	public double getElementMolesOfAcidToDissolve() {
		return elementMolesOfAcidToDissolve;
	}

}