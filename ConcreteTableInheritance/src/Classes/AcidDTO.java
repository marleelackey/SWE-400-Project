package Classes;

/**
 * A Data Transfer Object for the Acid table.
 * 
 * @author Madeline and Adam
 *
 */
public class AcidDTO {

	private int acidID;
	private String acidName;
	private int acidSolute;

	/**
	 * Constructor for an AcidDTO
	 * 
	 * @param ID     the ID of the acid
	 * @param name   the name of the acid
	 * @param solute the ID of the acid's solute
	 */
	public AcidDTO(int ID, String name, int solute) {
		acidID = ID;
		acidName = name;
		acidSolute = solute;
	}

	/**
	 * Getters for AcidDTO concrete
	 */

	public int getAcidID() {
		return acidID;
	}

	public String getAcidName() {
		return acidName;
	}

	public int getAcidSolute() {
		return acidSolute;
	}

}