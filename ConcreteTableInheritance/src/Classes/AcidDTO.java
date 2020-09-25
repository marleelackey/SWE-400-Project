package Classes;

/**
 * A Data Transfer Object for the Acid table.
 * @author Madeline and Adam
 *
 */
public class AcidDTO {
	
	private int solute;
	private String name;
	
	/**
	 * Constructor for AcidDTO
	 * @param solute the ID of the solute
	 * @param name the name of the Acid
	 */
	public AcidDTO(int solute, String name) {
		this.solute = solute;
		this.name = name;
	}

	public int getSolute() {
		return solute;
	}

	public String getName() {
		return name;
	}
}