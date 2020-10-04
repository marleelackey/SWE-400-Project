package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;

/**
 * 
 * @author Daniel Holmgren
 * @author Joshua Kellogg
 * Table data gateway for accessing the metal table
 */
public class MetalTDG {
	
	private static MetalTDG instance;
	/**
	 * Empty constructor for singleton
	 */
	private MetalTDG() {
		
	}
	
	/**
	 * getInstance method to return the instance of the metalTDG
	 * @return metalTDG singleton
	 */
	public static MetalTDG getInstance() {
		if(instance == null) {
			instance = new MetalTDG();
		}
		return instance;
	}
	
	/**
	 * Will search and return all of the metals in the database
	 * @return an ArrayList of metalDTOs each of which corresponds to a metal in the database
	 */
	public ArrayList<MetalDTO> getAllMetals() {
		ArrayList<MetalDTO> data = new ArrayList<MetalDTO>();
		ResultSet rs;
		try {
			DatabaseManager db = DatabaseManager.getSingleton();
			Connection cn = db.getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM Metal");
			while(rs.next()) {
				data.add(new MetalDTO(rs.getInt("elementOrMetalID"), rs.getInt("metalAtomicNumber"), rs.getInt("metalDissolvedBy"), rs.getDouble("metalAtomicMass"), rs.getString("metalName")));
			}
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		return data;
	}
}
