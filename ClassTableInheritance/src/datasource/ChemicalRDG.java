package datasource;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Row Data Gateway for Chemical
 * 
 * @author Madeline & co.
 *
 */
public class ChemicalRDG {

	private int chemicalID;
	private String chemicalName;
	private double chemicalMoles;

	/**
	 * Constructor for Chemical RDG
	 * 
	 * @param id    the ID of the chemical
	 * @param name  the name of the chemical
	 * @param moles the number of moles we have of the chemical in inventory
	 */
	public ChemicalRDG(int id, String name, double moles) {
		chemicalID = id;
		chemicalName = name;
		chemicalMoles = moles;
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
			data = new ChemicalRDG(rs.getInt(1), rs.getString(2), rs.getDouble(3));
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
			data = new ChemicalRDG(rs.getInt(1), rs.getString(2), rs.getDouble(3));
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		return data;
	}

	/**
	 * @return the chemicalID
	 */
	public int getChemicalID() {
		return chemicalID;
	}

	/**
	 * @return the chemicalName
	 */
	public String getChemicalName() {
		return chemicalName;
	}

	/**
	 * @return the chemicalMoles
	 */
	public double getChemicalMoles() {
		return chemicalMoles;
	}

	/**
	 * @param chemicalMoles the chemicalMoles to set
	 */
	public void setChemicalMoles(double chemicalMoles) {
		this.chemicalMoles = chemicalMoles;
	}

}