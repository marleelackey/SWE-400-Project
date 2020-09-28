package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;

/**
 * 
 * @author Dan Holmgren
 * @author Josh Kellogg
 *
 */
public class ElementTDG {
	private int ID,
				atomicNumber;
	private double atomicMass;
	private String name;
	
	private static ElementTDG instance;
	
	/**
	 * @author Dan Holmgren
	 * @return an instance of the ElementTDG
	 */
	private ElementTDG() {
		
	}
	
	public static ElementTDG getInstance() {
		if(instance == null) {
			instance = new ElementTDG();
		}
		return instance;
	}
	
	public ArrayList<ElementDTO> getElementsInRange(double lower, double upper) {
		ArrayList<ElementDTO> data = new ArrayList<ElementDTO>();
		ResultSet rs;
		
		try {
			DatabaseManager db = DatabaseManager.getSingleton();
			db.setPatternNumber(2);
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
