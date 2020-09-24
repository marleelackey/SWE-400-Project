package Classes;

import java.util.ArrayList;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;

import java.sql.*;

/**
 * 
 * @author Dan Holmgren
 * @author Joshua Kellogg
 *
 */
public class ChemicalTDG {
	
	private static ChemicalTDG instance;
	private ChemicalTDG() {
		//Doesn't need any instance variables, but needs to make sure there's only
		//one instance of the TDG per table
	}
	
	/**
	 * @author Dan Holmgren
	 * @return an instance of the TDG
	 */
	public static ChemicalTDG getSingleton() {
		if(instance == null) {
			instance = new ChemicalTDG();
		} 
		return instance;
	}
	
	/**
	 * 
	 * @author Dan Holmgren
	 * @return a list of all bases in the Chemical database
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	private ArrayList<ChemicalDTO> getAllBases() throws DatabaseException, SQLException{
		ArrayList<ChemicalDTO> data = new ArrayList<ChemicalDTO>();
		ResultSet rs;
		
		try {
			Connection cn = DatabaseManager.getSingleton().getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM CHEMICAL WHERE type = 1");
			while(rs.next()) {
				data.add(new ChemicalDTO(rs.getInt("id"), rs.getInt("type"), rs.getString("name"), rs.getInt("atomicNumber"),
						rs.getDouble("atomicMass"), rs.getInt("dissolvedBy"), rs.getInt("acidSolute"), rs.getInt("baseSolute")));
			}
		} catch (Exception e){
			DatabaseException.detectError(e);
		}
		return data;
	}

	
	/**
	 * @author Dan Holmgren
	 * @param lower
	 * @param upper
	 * @return a list of the elements with atomic mass in the given range
	 */
	private ArrayList<ChemicalDTO> getElementsInRange(double lower, double upper) {
		ArrayList<ChemicalDTO> data = new ArrayList<ChemicalDTO>();
		ResultSet rs;
		
		try {
			Connection cn = DatabaseManager.getSingleton().getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM CHEMICAL WHERE atomicMass > " + lower
					+ "AND WHERE atomicMass < " + upper);
			while(rs.next()) {
				data.add(new ChemicalDTO(rs.getInt("id"), rs.getInt("type"), rs.getString("name"), rs.getInt("atomicNumber"),
						rs.getDouble("atomicMass"), rs.getInt("dissolvedBy"), rs.getInt("acidSolute"), rs.getInt("baseSolute")));
			}
			
		} catch(SQLException | DatabaseException e) {
			
		}
		
		return data;
	}
	
	/**
	 * @author Dan Holmgren
	 * @param ID the ID of the element that all compounds are searched for
	 * @return a list of the names of compounds with the element
	 */
	private ArrayList<Integer> getCompoundsByElement(int ID) {
		ArrayList<Integer> data = new ArrayList<Integer>();
		ResultSet rs;
		
		try {
			Connection cn = DatabaseManager.getSingleton().getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM CompoundMadeOfElement WHERE elementID = " + ID);
			while(rs.next()) {
				data.add(rs.getInt("compoundID"));
			}
			
		} catch(SQLException | DatabaseException e) {
			
		}
		
		return data;
	}
	
}
