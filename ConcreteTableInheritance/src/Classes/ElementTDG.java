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
	
	private ElementTDG instance;
	
	/**
	 * @author Dan Holmgren
	 * @return an instance of the ElementTDG
	 */
	public ElementTDG getInstance() {
		if(instance != null) {
			instance = new ElementTDG();
		}
		return instance;
	}
	
	public ArrayList<ElementDTO> getElementsInRange(double lower, double upper) {
		ArrayList<ElementDTO> data = new ArrayList<ElementDTO>();
		ResultSet rs;
		
		try {
			Connection cn = DatabaseManager.getSingleton().getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM CHEMICAL WHERE atomicMass > " + lower + " AND atomicMass < " + upper);
			while(rs.next()) {
				data.add(new ElementDTO(rs.getInt("ID"), rs.getInt("atomicNumber"), rs.getDouble("atomicMass"), rs.getString("Name")));
			}
			
		} catch(Exception e) {
			DatabaseException.detectError(e);
		}
		
		return data;
	}
}
