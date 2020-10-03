package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;

/**
 * Row Data Gateway for Chemical
 * @author Madeline & co.
 *
 */
public class ChemicalRDG {
	
	private int chemicalID;
	private String chemicalName;
	private int chemicalType;
	
	/**
	 * Constructor for Chemical RDG
	 * @param id the ID of the chemical
	 * @param name the name of the chemical
	 * @param type the type of the chemical
	 */
	public ChemicalRDG(int id, String name, int type) {
		chemicalID = id;
		chemicalName = name;
		chemicalType = type;
	}
	
	/**
	 * method to find a chemical based on its ID
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
			data = new ChemicalRDG(rs.getInt(1), rs.getString(2), rs.getInt(3));
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		return data;
	}
	
	/**
	 * a method to find a chemical by its name
	 * @param name the name of the chemical
	 * @return an RDG for the chemical
	 */
	public static ChemicalRDG findByName(String name) {
		Connection cn;
		ChemicalRDG data = null;
		try {
			cn = DatabaseManager.getSingleton().getConnection();
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM Chemical WHERE chemicalName = '" + name + "'");
			rs.next();
			data = new ChemicalRDG(rs.getInt(1), rs.getString(2), rs.getInt(3));
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		return data;
	}
	
	/**
	 * a method to figure out the type of a chemical by its name
	 * @param name the name of the chemical
	 * @return a String that is the type of the chemical
	 */
	public static String findTypeByName(String name) {
		Connection connection;
		ChemicalRDG chem = null;
		try {
			connection = DatabaseManager.getSingleton().getConnection();
			ResultSet r = connection.createStatement()
					.executeQuery("SELECT * FROM Chemical WHERE Chemical.chemicalName = '" + name + "'");
			r.next();
			chem = new ChemicalRDG(r.getInt(1), r.getString(2), r.getInt(3));
		} catch (SQLException | DatabaseException e) {
			DatabaseException.detectError(e);
		}

		String typeString = "";

		switch (chem.getChemicalType()) {
		case (0):
			typeString = "Chemical";
			break;
		case (1):
			typeString = "Base";
			break;
		case (2):
			typeString = "Acid";
			break;
		case (3):
			typeString = "Element";
			break;
		case (4):
			typeString = "Metal";
			break;
		case (5):
			typeString = "Compound";
		}

		return typeString;
	}

	public int getChemicalID() {
		return chemicalID;
	}

	public String getChemicalName() {
		return chemicalName;
	}
	
	public int getChemicalType() {
		return chemicalType;
	}

}