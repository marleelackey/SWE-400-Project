package datasource;

import java.sql.*;
import java.util.ArrayList;

import datasource.DatabaseException;
import datasource.DatabaseManager;

/**
 * @author Daniel Holmgren
 * @author Joshua Kellogg
 *
 */
public class ElementTDG {

	private static ElementTDG instance;
	
	/**
	 * Empty constructor for singleton purposes 
	 */
	private ElementTDG() {
		
	}
	
	/**
	 * Singleton getter for singleton purposes
	 * @return
	 */
	public static ElementTDG getInstance() {
		if(instance == null) {
			instance = new ElementTDG();
		}
		return instance;
	}
	
	/**
	 * the getElementsInRange method,
	 * It gets a list of elementDTOs corresponding to elements
	 * in the database within the lower and upper range
	 * @param lower
	 * @param upper
	 * @return
	 */
	public ArrayList<ElementDTO> getElementInRange(double lower, double upper){
		ArrayList<ElementDTO> data = new ArrayList<ElementDTO>();
		ResultSet rs;
		try {
			DatabaseManager db = DatabaseManager.getSingleton();
			Connection cn = db.getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM Element WHERE elementAtomicMass > " + lower + " AND elementAtomicMass < " + upper);
			while(rs.next()) {
				data.add(new ElementDTO(rs.getInt("elementID"), rs.getInt("elementAtomicNumber"), rs.getDouble("elementAtomicMass")));
			}
			
		} catch(Exception e) {
			DatabaseException.detectError(e);
		}
		
		return data;
	}
}
