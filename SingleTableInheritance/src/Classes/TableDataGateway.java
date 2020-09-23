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
public class TableDataGateway {
	
	private static TableDataGateway instance;
	private TableDataGateway() {
		
	}
	
	/**
	 * @author Dan Holmgren
	 * @return an instance of the TDG
	 */
	public static TableDataGateway getSingleton() {
		if(instance == null) {
			instance = new TableDataGateway();
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
			rs = cn.createStatement().executeQuery("SELECT * FROM Chemical WHERE type = 1");
			while(rs.next()) {
				data.add(new ChemicalDTO(rs.getInt("ID"), rs.getInt("Type"), rs.getString("Name"), rs.getInt("atomicNumber"),
						rs.getDouble("atomicMass"), rs.getInt("dissolvedBy"), rs.getInt("soluteA"), rs.getInt("soluteB")));
			}
		} catch (SQLException | DatabaseException e){
			
		}
		return data;
	}
	
	/**
	 * @author Dan Holmgren
	 * @param lower
	 * @param upper
	 * @return a list of names of the elements with atomic mass in the given range
	 */
	private ArrayList<ChemicalDTO> getElementsInRange(double lower, double upper) {
		ArrayList<ChemicalDTO> data = new ArrayList<ChemicalDTO>();
		ResultSet rs;
		
		try {
			Connection cn = DatabaseManager.getSingleton().getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM Chemical WHERE atomicMass > " + lower
					+ "AND WHERE atomicMass < " + upper);
			while(rs.next()) {
				data.add(new ChemicalDTO(rs.getInt("ID"), rs.getInt("Type"), rs.getString("Name"), rs.getInt("atomicNumber"),
						rs.getDouble("atomicMass"), rs.getInt("dissolvedBy"), rs.getInt("soluteA"), rs.getInt("soluteB")));
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
	private ArrayList<ChemicalDTO> getCompoundsByElement(int ID) {
		ArrayList<ChemicalDTO> data = new ArrayList<ChemicalDTO>();
		ResultSet rs;
		
		try {
			Connection cn = DatabaseManager.getSingleton().getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM CompoundMadeOfElement WHERE ElementID = " + ID);
			while(rs.next()) {
				//data.add();
			}
			
		} catch(SQLException | DatabaseException e) {
			
		}
		
		return data;
	}
}
