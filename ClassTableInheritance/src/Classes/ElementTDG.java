package Classes;

import java.sql.*;
import java.util.ArrayList;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;

public class ElementTDG {

	private static ElementTDG instance;
	
	private ElementTDG() {
		
	}
	
	public static ElementTDG getInstance() {
		if(instance == null) {
			instance = new ElementTDG();
		}
		return instance;
	}
	
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
