package datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import datasource.DatabaseException;
import datasource.DatabaseManager;

/**
 * Row Data Gateway for Chemical
 * 
 * @author Madeline & co.
 *
 */
public class ChemicalRDG {

	private int chemicalID;
	private String chemicalName;

	/**
	 * Constructor for Chemical RDG
	 * 
	 * @param id   the ID of the chemical
	 * @param name the name of the chemical
	 */
	public ChemicalRDG(int id, String name) {
		chemicalID = id;
		chemicalName = name;
	}

	/**
	 * method to find a chemical based on its ID
	 * 
	 * @param ID the id of the chemical
	 * @return an RDG for the chemical
	 */
	public static ChemicalRDG findByID(int ID) {
		Connection cn;
		ChemicalRDG data = null;
		try {
			cn = DatabaseManager.getSingleton().getConnection();
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM Chemical WHERE chemicalID = " + ID);
			rs.next();
			data = new ChemicalRDG(rs.getInt(1), rs.getString(2));
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		return data;
	}

	/**
	 * a method to find a chemical by its name
	 * 
	 * @param name the name of the chemical
	 * @return an RDG for the chemical
	 */
	public static ChemicalRDG findByName(String name) {
		Connection cn;
		ChemicalRDG data = null;
		try {
			cn = DatabaseManager.getSingleton().getConnection();
			ResultSet rs = cn.createStatement()
					.executeQuery("SELECT * FROM Chemical WHERE chemicalName = '" + name + "'");
			rs.next();
			data = new ChemicalRDG(rs.getInt(1), rs.getString(2));
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		return data;
	}

	public int getChemicalID() {
		return chemicalID;
	}

	public String getChemicalName() {
		return chemicalName;
	}

}