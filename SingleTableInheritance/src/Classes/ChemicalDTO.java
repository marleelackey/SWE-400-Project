package Classes;

/**
 * Data Transfer Object for Single Chemical
 * 
 * @authors Madeline & Adam
 *
 */
public class ChemicalDTO {

	private int chemicalID;
	private int chemicalType;
	private String chemicalName;
	private int chemicalAtomicNumber;
	private double chemicalAtomicMass;
	private int chemicalDissolvedBy;
	private int chemicalSoluteA;
	private int chemicalSoluteB;

	/**
	 * Constructor for ChemicalDTO
	 * 
	 * @param ID           the Chemical's ID number
	 * @param type         the type of the Chemical--0 Chemical, 1 Base, 2 Acid, 3
	 *                     Element, 4 Metal, 5 Compound
	 * @param name         the name of the Chemical
	 * @param atomicNumber the atomic number of an Element or Metal
	 * @param atomicMass   the atomic mass of an Element or Metal
	 * @param dissolvedBy  the Acid ID that dissolves a Metal
	 * @param soluteA      the Chemical ID that is the solute of an Acid
	 * @param soluteB      the Chemical ID that is the solute of a Base
	 */
	public ChemicalDTO(int ID, int type, String name, int atomicNumber, double atomicMass, int dissolvedBy, int soluteA,
			int soluteB) {
		chemicalID = ID;
		chemicalType = type;
		chemicalName = name;
		chemicalAtomicNumber = atomicNumber;
		chemicalAtomicMass = atomicMass;
		chemicalDissolvedBy = dissolvedBy;
		chemicalSoluteA = soluteA;
		chemicalSoluteB = soluteB;
	}

	/**
	 * Getters methods for ChemicalDTO instance variables
	 */

	public int getChemicalID() {
		return chemicalID;
	}

	public int getChemicalType() {
		return chemicalType;
	}

	public String getChemicalName() {
		return chemicalName;
	}

	public int getChemicalAtomicNumber() {
		return chemicalAtomicNumber;
	}

	public double getChemicalAtomicMass() {
		return chemicalAtomicMass;
	}

	public int getChemicalDissolvedBy() {
		return chemicalDissolvedBy;
	}

	public int getChemicalSoluteA() {
		return chemicalSoluteA;
	}

	public int getChemicalSoluteB() {
		return chemicalSoluteB;
	}

}