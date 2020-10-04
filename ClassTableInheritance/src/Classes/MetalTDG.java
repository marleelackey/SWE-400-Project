package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;

/**
 * @author Daniel Holmgren
 * @author Joshua Kellogg
 *
 * The metalTDG for accessing the database
 */
public class MetalTDG {
	private static MetalTDG instance;
	
	/**
	 * Empty constructor for the singleton to use
	 */
	private MetalTDG() {
		
	}
	
	/**
	 * If an instance of this class does not yet exist
	 * creates one 
	 * @return the instance of the metalTDG
	 */
	public static MetalTDG getSingleton() {
		if(instance == null) {
			instance = new MetalTDG();
		}
		return instance;
	}
	
	/**
	 * Tests the getAllMethods method 
	 * @return
	 */
	public ArrayList<MetalDTO> getAllMetals(){
		ArrayList<MetalDTO> data = new ArrayList<MetalDTO>();
		ResultSet rs;
		try {
			DatabaseManager db = DatabaseManager.getSingleton();
			Connection cn = db.getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM Metal");
			while(rs.next()) {
				data.add(new MetalDTO(rs.getInt("metalID"), rs.getInt("metalDissolvedBy")));
			}
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		return data;
	}
}
