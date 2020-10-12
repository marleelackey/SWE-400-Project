/**
 * 
 */
package commands;

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

	/**
	 * Constructor
	 * 
	 * @param id    the ID of the element
	 * @param name  the name of the element
	 * @param num   the atomic number of the element
	 * @param mass  the atomic mass of the element
	 * @param metal whether the element is a metal or not
	 * @param a_id  the acid that dissolves the element if it's a metal
	 */
	public AddElementCmd(int id, String name, int num, double mass, boolean metal, int a_id) {
		elementID = id;
		elementName = name;
		elementAtomicNumber = num;
		elementAtomicMass = mass;
		isMetal = metal;
		acidID = a_id;
	}

	/**
	 * Execute the AddElementCmd by creating a mapper to handle the insertion
	 */
	@Override
	public void execute() {
		ElementMapper em = new ElementMapper();
		em.createElement(elementID, elementName, elementAtomicNumber, elementAtomicMass, isMetal, acidID);
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

}