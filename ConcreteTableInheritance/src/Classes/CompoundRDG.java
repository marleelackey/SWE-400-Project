package Classes;

import java.sql.*;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;

/**
 * 
 * @author Marlee Lackey
 * @author Taryn Whitman
 *
 */
public class CompoundRDG {
	
	private int compoundID;
	private String compoundName;
	static Connection connection;

	/**
	 * Constructor for CompoundRDG
	 * @param id Passes in the ID for CompoundRDG
	 * @param name Passes in the Name for CompoundRDG
	 */
	public CompoundRDG (int id, String name) {
		compoundID = id;
		compoundName = name;
		
		try {
			connection = DatabaseManager.getSingleton().getConnection();
		} catch (DatabaseException e) {
			DatabaseException.detectError(e);
		}	

	}

	/**
	 * Getter for compoundID
	 * @return compoundID
	 */
	public int getCompoundID() {
		return compoundID;
	}

	/**
	 * Getter for compoundName
	 * @return compoundName
	 */
	public String getCompoundName() {
		return compoundName;
	}
	
	/**
	 * Setter for compoundName
	 * @param compoundName name of compound
	 */
	public void setCompoundName(String compoundName) {
		this.compoundName = compoundName;
	}

	/**
	 * Find a chemical using the ID
	 * @param ID the id of a chemical you are looking for
	 * @return ChemicalRDG
	 */
	public static CompoundRDG findByIDConcrete(int ID) {
		CompoundRDG chem = null;							
		try {
			ResultSet r = connection.createStatement().executeQuery("SELECT * FROM Compound WHERE Compound.compoundID = " + ID);
			r.next();
			chem = new CompoundRDG(r.getInt(1), r.getString(2));						
		} catch (SQLException e) {
			DatabaseException.detectError(e);					
		}
										
		return chem;	
	
		}
	
	/**
	 * Find a chemical using the name
	 * @param name the name of a chemical you are looking for
	 * @return ChemicalRDG
	 */
	public static CompoundRDG findByNameConcrete(String name) {
		CompoundRDG chem = null;							
		try {
			ResultSet r = connection.createStatement().executeQuery("SELECT * FROM Compound WHERE Compound.compoundName = '" + name + "'");
			r.next();
			chem = new CompoundRDG(r.getInt(1), r.getString(2));						
		} catch (SQLException e) {
			DatabaseException.detectError(e);					
		}
										
		return chem;	
	}
	
	/**
	 * Method to see if a Chemical with a given name is a Compound
	 * @author Madeline and Adam
	 * @param name the name of the Chemical
	 * @return Compound if it is a Compound, null if it is not
	 */
	public static String findTypeByName(String name) {
		Connection c;
		try {
			c = DatabaseManager.getSingleton().getConnection();
			ResultSet rs = c.createStatement().executeQuery("SELECT * FROM Compound WHERE Compound.compoundName = '" + name + "'");
			if (rs.next()) {
				return "Compound";
			}
		} catch (SQLException | DatabaseException e) {
			DatabaseException.detectError(e);
		}
		return null;
	}
	
	/**
	 * Updates the database with new values to an existing chemical
	 */
	public void update() {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("UPDATE Compound SET compoundName = ? WHERE Compound.compoundID = ?");
			stmt.setString(1, compoundName);
			stmt.setInt(2, compoundID);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			DatabaseException.detectError(e);
		}
	}

}
