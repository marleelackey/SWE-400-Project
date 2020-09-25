package Classes;

import java.util.ArrayList;

/**
 * Table Data Gateway for the Acid table
 * 
 * @author Madeline and Adam
 *
 */
public class AcidTDG {

	/**
	 * Constructor-y stuff for the singleton of AcidTDG
	 */
	private static AcidTDG Singleton;

	private AcidTDG() {
	}

	public static AcidTDG getSingleton() {
		if (Singleton == null) {
			Singleton = new AcidTDG();
		}
		return Singleton;
	}

	/**
	 * Method to return all the Acids in the DB
	 * 
	 * @return an ArrayList of AcidDTOs
	 */
	public ArrayList<AcidDTO> getAllAcids() {
		// can be done if we feel like it l8r
	}
}