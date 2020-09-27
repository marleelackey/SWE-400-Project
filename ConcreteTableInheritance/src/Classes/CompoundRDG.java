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
		
		//connection = DatabaseManager.getSingleton().getConnection();
		try {
			connection = DatabaseManager.getSingleton().getConnection();
		} catch (DatabaseException e) {
			DatabaseException.detectError(e);
		}	

	}

	// getters 
	public int getCompoundID() {
		return compoundID;
	}

	public String getCompoundName() {
		return compoundName;
	}
	
	// setters
	public void setCompoundName(String compoundName) {
		this.compoundName = compoundName;
	}
	
	// find bys
	
	// finders
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
	
	public static CompoundRDG findByNameConcrete(String name) {
		CompoundRDG chem = null;							
		try {
			ResultSet r = connection.createStatement().executeQuery("SELECT * FROM Compound WHERE Compound.compoundName = " + name);
			r.next();
			chem = new CompoundRDG(r.getInt(1), r.getString(2));						
		} catch (SQLException e) {
			DatabaseException.detectError(e);					
		}
										
		return chem;	
	}
	
	// update
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
