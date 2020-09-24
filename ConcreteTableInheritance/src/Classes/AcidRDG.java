package Classes;

/**
 * A Row Data Gateway for the Acid table
 * 
 * @author Madeline and Adam
 *
 */
public class AcidRDG {

	private int acidID;
	private String acidName;
	private int acidSolute;

	/**
	 * Constructor for AcidRDG
	 * 
	 * @param ID     the ID of the Acid
	 * @param name   the name of the Acid
	 * @param solute the Chemical ID that is a solute of the Acid
	 */
	public AcidRDG(int ID, String name, int solute) {
		acidID = ID;
		acidName = name;
		acidSolute = solute;
	}

	public int getAcidID() {
		return acidID;
	}

	public void setAcidID(int acidID) {
		this.acidID = acidID;
	}

	public String getAcidName() {
		return acidName;
	}

	public void setAcidName(String acidName) {
		this.acidName = acidName;
	}

	public int getAcidSolute() {
		return acidSolute;
	}

	public void setAcidSolute(int acidSolute) {
		this.acidSolute = acidSolute;
	}

}