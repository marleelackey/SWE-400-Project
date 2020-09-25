package Classes;

public class ElementDTO {
	private int ID,
				atomicNumber;
	private double atomicMass;
	private String name;
	
	public ElementDTO(int ID, int atomicNumber, double atomicMass, String name) {
		this.ID = ID;
		this.atomicNumber = atomicNumber;
		this.atomicMass = atomicMass;
		this.name = name;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getAtomicNumber() {
		return atomicNumber;
	}
	
	public double getAtomicMass() {
		return atomicMass;
	}
	
	public String getName() {
		return name;
	}
}
