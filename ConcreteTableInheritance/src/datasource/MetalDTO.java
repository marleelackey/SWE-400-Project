package datasource;

/**
 * 
 * @author Daniel Holmgren
 * @author Joshua Kellogg A data transfer object to transfer information about a
 *         metal around
 */
public class MetalDTO {
	private int ID, atomicNumber, dissolvedBy;
	private double atomicMass;
	private String name;

	/**
	 * Assigns instance variables
	 * 
	 * @param ID
	 * @param atomicNumber
	 * @param dissolvedBy
	 * @param atomicMass
	 * @param name
	 */
	public MetalDTO(int ID, int atomicNumber, int dissolvedBy, double atomicMass, String name) {
		this.ID = ID;
		this.atomicNumber = atomicNumber;
		this.dissolvedBy = dissolvedBy;
		this.atomicMass = atomicMass;
		this.name = name;
	}

	/**
	 * Getters and Setters
	 * 
	 * @return the requested variables
	 */

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

	public int getDissolvedBy() {
		return dissolvedBy;
	}
}
