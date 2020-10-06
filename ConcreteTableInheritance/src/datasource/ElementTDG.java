package datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * 
 * @author Dan Holmgren
 * @author Josh Kellogg
 *
 */
public class ElementTDG {
	
	private static ElementTDG instance;

	private ElementTDG() {
		
	}
	
	/**
	 * @author Dan Holmgren
	 * @author Joshua Kellogg
	 * @return an instance of the ElementTDG
	 */
	public static ElementTDG getInstance() {
		if(instance == null) {
			instance = new ElementTDG();
		}
		return instance;
	}
	
	/**
	 * Returns the elements in the database between the atomic mass lower and upper
	 * @param lower
	 * @param upper
	 * @return Arraylist of ElementDTOs each of which corresponds to an Element in the database
	 */
	public ArrayList<ElementDTO> getElementsInRange(double lower, double upper) {
		ArrayList<ElementDTO> data = new ArrayList<ElementDTO>();
		ResultSet rs;
		
		try {
			DatabaseManager db = DatabaseManager.getSingleton();
			Connection cn = db.getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM Element WHERE elementAtomicMass > " + lower + " AND elementAtomicMass < " + upper);
			while(rs.next()) {
				data.add(new ElementDTO(rs.getInt("elementOrMetalID"), rs.getInt("elementAtomicNumber"), rs.getDouble("elementAtomicMass"), rs.getString("elementName")));
			}
			
		} catch(Exception e) {
			DatabaseException.detectError(e);
		}
		
		return data;
	}
}
