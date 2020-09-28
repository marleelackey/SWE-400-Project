package Classes;

import java.sql.*;
import java.util.ArrayList;

import Datasource.DatabaseManager;
import Datasource.DatabaseException;

/**
 * 
 * @author Marlee Lackey
 * @author Taryn Whitman
 *
 */
public class CompoundTDG {

	private static CompoundTDG Singleton;

	/** 
	 * Makes sure there is only one instance of the TDG
	 */
	public static CompoundTDG getSingleton() {
		if (Singleton == null) {
			Singleton = new CompoundTDG();
		}
		return Singleton;
	}
	
	/** 
	 * @param name -- name of the compound 
	 * @return the list of compounds by elements
	 */
	public ArrayList<CompoundDTO> getCompoundsByElement(String name) {
		ArrayList<CompoundDTO> list = new ArrayList<CompoundDTO>();
		ResultSet r;
		
		try {
			Connection connection = DatabaseManager.getSingleton().getConnection();
			r = connection.createStatement().executeQuery("SELECT * FROM Compound");
			
			while(r.next()) {
				list.add(new CompoundDTO(r.getInt("compoundID"), r.getString("compoundName")));
			}
			
		} catch (DatabaseException | SQLException e) {
			DatabaseException.detectError(e);
		}

		return list;
		
	}
	
}
