package datasource;

import java.util.ArrayList;

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
	public ArrayList<ChemicalDTO> getAllBases() {
		ArrayList<ChemicalDTO> data = new ArrayList<ChemicalDTO>();
		ResultSet rs;
		
		try {
			Connection cn = DatabaseManager.getSingleton().getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM Chemical WHERE chemicalType = 1");
			while(rs.next()) {
				data.add(new ChemicalDTO(rs.getInt("chemicalID"), rs.getInt("chemicalType"), rs.getString("chemicalName"), rs.getInt("chemicalAtomicNumber"),
						rs.getDouble("chemicalAtomicMass"), rs.getInt("chemicalDissolvedBy"), rs.getInt("chemicalAcidSolute"), rs.getInt("chemicalBaseSolute")));
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
	public ArrayList<ChemicalDTO> getElementsInRange(double lower, double upper) {
		ArrayList<ChemicalDTO> data = new ArrayList<ChemicalDTO>();
		ResultSet rs;
		
		try {
			Connection cn = DatabaseManager.getSingleton().getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM Chemical WHERE chemicalAtomicMass > " + lower + " AND chemicalAtomicMass < " + upper);
			while(rs.next()) {
				data.add(new ChemicalDTO(rs.getInt("chemicalID"), rs.getInt("chemicalType"), rs.getString("chemicalName"), rs.getInt("chemicalAtomicNumber"),
						rs.getDouble("chemicalAtomicMass"), rs.getInt("chemicalDissolvedBy"), rs.getInt("chemicalAcidSolute"), rs.getInt("chemicalBaseSolute")));
			}
			
		} catch(Exception e) {
			DatabaseException.detectError(e);
		}
		
		return data;
	}
	
	/**
	 * @author Dan Holmgren
	 * @param ID the ID of the element that all compounds are searched for
	 * @return a list of the names of compounds with the element
	 */
	public ArrayList<CompoundMadeOfElementDTO> getCompoundsByElement(int ID) {
		ArrayList<CompoundMadeOfElementDTO> data = new ArrayList<CompoundMadeOfElementDTO>();
		ResultSet rs;
		
		try {
			Connection cn = DatabaseManager.getSingleton().getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM CompoundMadeOfElement WHERE elementID = " + ID);
			while(rs.next()) {
				data.add(new CompoundMadeOfElementDTO(rs.getInt("compoundID"), ID));
			}

		} catch(Exception e) {
			DatabaseException.detectError(e);
		}
		return data;
	}
	
}
