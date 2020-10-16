package commands;

/**
 * Command class to overwrite which acid can dissolve a particular metal
 * 
 * @author Madeline and Adam
 *
 */
public class OverwriteAcidToDissolveMetalCmd {

	private int metalID;
	private int newAcidID;

	/**
	 * Constructor
	 * 
	 * @param metal the ID of the metal to modify
	 * @param acid  the ID of the new acid that dissolves it
	 */
	public OverwriteAcidToDissolveMetalCmd(int metal, int acid) {
		metalID = metal;
		newAcidID = acid;
	}

	/**
	 * Execute method to invoke the overwrite acid to dissolve metal command
	 */
	public void execute() {
		// TODO
	}

	public int getMetalID() {
		return metalID;
	}

	public int getNewAcidID() {
		return newAcidID;
	}

}