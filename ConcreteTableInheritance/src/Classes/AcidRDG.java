package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import Datasource.DatabaseException;
import Datasource.DatabaseManager;

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

	/**
	 * Method to query the database for an Acid selected by its ID
	 * 
	 * @param ID the ID of the Acid we want to select
	 * @return an AcidRDG for the Acid we select
	 */
	public AcidRDG findByID(int ID) {
		Connection c;
		AcidRDG result = null;
		try {
			c = DatabaseManager.getSingleton().getConnection();
			ResultSet rs = c.createStatement().executeQuery("SELECT * FROM ACID WHERE ID = " + ID);
			result = new AcidRDG(rs.getInt(0), rs.getString(1), rs.getInt(2));
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		return result;
	}

	/**
	 * Method to query the database for an Acid selected by its name
	 * 
	 * @param name the name of the Acid we want to select
	 * @return an AcidRDG for the Acid we select
	 */
	public AcidRDG findByName(String name) {
		Connection c;
		AcidRDG result = null;
		try {
			c = DatabaseManager.getSingleton().getConnection();
			ResultSet rs = c.createStatement().executeQuery("SELECT * FROM ACID WHERE NAME = " + name);
			result = new AcidRDG(rs.getInt(0), rs.getString(1), rs.getInt(2));
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		return result;
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