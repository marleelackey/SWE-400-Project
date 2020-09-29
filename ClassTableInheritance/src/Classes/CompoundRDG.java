package Classes;

import java.sql.*;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;

/**
 * @author Taryn Whitman
 * @author Marlee Lackey
 *
 */
public class CompoundRDG {

	private int compoundID;
	static Connection connection;
	
	/**
	 * Constructor
	 * @param id of compound
	 */
	public CompoundRDG(int id) {
		compoundID = id;
		
		try {
			connection = DatabaseManager.getSingleton().getConnection();
		}catch (DatabaseException e) {
			DatabaseException.detectError(e);
		}
	}

	public int getCompoundID() {
		return compoundID;
	}

	public void setCompoundID(int compoundID) {
		this.compoundID = compoundID;
	}
	
	/**
	 * Return a CompoundRDG given the ID of a compound
	 * @param ID
	 * @return
	 */
	public static CompoundRDG findByIDClass(int ID) {
		CompoundRDG comp = null;							
		try {
			ResultSet r = connection.createStatement().executeQuery("SELECT * FROM Compound WHERE Compound.compoundID = " + ID);
			r.next();
			comp = new CompoundRDG(r.getInt(1));						
		} catch (SQLException e) {
			DatabaseException.detectError(e);					
		}
										
		return comp;	
	
		}
	
	}

