package Classes;

/**
 * 
 * @author Dan Holmgren
 * @author Josh Kellogg
 *
 */
public class ElementDTO {
	private int ID,
				atomicNumber;
	private double atomicMass;
	
	public ElementDTO(int ID, int atomicNumber, double atomicMass) {
		this.ID = ID;
		this.atomicNumber = atomicNumber;
		this.atomicMass = atomicMass;
	}

	
	//Getters and Setters
	public int getID() {
		return ID;
	}

	public int getAtomicNumber() {
		return atomicNumber;
	}

	public void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}

	public double getAtomicMass() {
		return atomicMass;
	}

	public void setAtomicMass(double atomicMass) {
		this.atomicMass = atomicMass;
	}
}
