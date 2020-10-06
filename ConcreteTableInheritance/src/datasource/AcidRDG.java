package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			DatabaseException.detectError(e, "AcidRDG.findByID - Concrete");
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
			DatabaseException.detectError(e, "AcidRDG.findByName - Concrete");
		}
		return result;
	}

	/**
	 * Method to see if a Chemical with a given name is an Acid
	 * 
	 * @param name the name of the Chemical
	 * @return Acid if it is an Acid, null if it is not
	 */
	public static String findTypeByName(String name) {
		Connection c;
		try {
			c = DatabaseManager.getSingleton().getConnection();
			ResultSet rs = c.createStatement().executeQuery("SELECT * FROM Acid WHERE Acid.acidName = '" + name + "'");
			if (rs.next()) {
				return "Acid";
			}
		} catch (SQLException | DatabaseException e) {
			DatabaseException.detectError(e, "AcidRDG.findTypeByName - Concrete");
		}
		return null;
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
			DatabaseException.detectError(e, "AcidRDG.update - Concrete");
		}
	}

	/**
	 * Getters and Setters for AcidRDG Concrete
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

	public void setAcidName(String acidName) {
		this.acidName = acidName;
	}

	public void setAcidSolute(int acidSolute) {
		this.acidSolute = acidSolute;
	}

}