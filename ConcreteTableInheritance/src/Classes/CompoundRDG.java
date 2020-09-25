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
	Connection connection;

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

	// getters 
	public int getCompoundID() {
		return compoundID;
	}

	public String getCompoundName() {
		return compoundName;
	}
	
	// setters
	public void setCompoundID(int compoundID) {
		this.compoundID = compoundID;
	}

	public void setCompoundName(String compoundName) {
		this.compoundName = compoundName;
	}
	
	// find bys
	
	// finders
		public CompoundDTO findByIDConcrete(int ID) {
			
			// make more secure later when we know how to setInt() for Strings...
			String query = "SELECT * FROM Compound WHERE Compound.compoundID = " + ID;
			ResultSet rs = null;
			CompoundDTO comp = null;
			try {
				Statement statement = connection.createStatement();
				rs = statement.executeQuery(query);
				if(rs.next()) {
					comp = new CompoundDTO(ID, compoundName);
				 }
			}
			catch (SQLException e) {
				DatabaseException.detectError(e);
			}

			return comp;
		}
	
	
	// update
	

}
