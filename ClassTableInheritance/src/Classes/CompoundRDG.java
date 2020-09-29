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
}
