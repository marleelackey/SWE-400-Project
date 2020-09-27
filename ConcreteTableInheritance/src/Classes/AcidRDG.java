package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public static AcidRDG findByID(int ID) {
		Connection c;
		AcidRDG result = null;
		try {
			c = DatabaseManager.getSingleton().getConnection();
			ResultSet rs = c.createStatement().executeQuery("SELECT * FROM Acid WHERE acidID = " + ID);
			rs.next();
			result = new AcidRDG(rs.getInt(1), rs.getString(2), rs.getInt(3));
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
	public static AcidRDG findByName(String name) {
		Connection c;
		AcidRDG result = null;
		try {
			c = DatabaseManager.getSingleton().getConnection();
			ResultSet rs = c.createStatement().executeQuery("SELECT * FROM Acid WHERE acidName = '" + name + "'");
			rs.next();
			result = new AcidRDG(rs.getInt(1), rs.getString(2), rs.getInt(3));
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		return result;
	}

	/**
	 * Method to persist an AcidRDG to the database
	 */
	public void update() {
		Connection c;
		try {
			c = DatabaseManager.getSingleton().getConnection();
			PreparedStatement s = c.prepareStatement("UPDATE Acid SET acidName = ?, acidSolute = ? WHERE acidID = ?");
			s.setString(1, acidName);
			s.setInt(2, acidSolute);
			s.setInt(3, acidID);
			s.execute();
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
	}

	public int getAcidID() {
		return acidID;
	}

	public String getAcidName() {
		return acidName;
	}

	public int getAcidSolute() {
		return acidSolute;
	}

	public void setAcidName(String acidName) {
		this.acidName = acidName;
	}

	public void setAcidSolute(int acidSolute) {
		this.acidSolute = acidSolute;
	}

}