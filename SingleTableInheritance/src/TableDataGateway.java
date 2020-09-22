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
//	private int ID,
//				type,
//				atomicNumber,
//				soluteA,
//				soluteB,
//				dissolvedBy;
//	private String name;
//	private double atomicMass;
//	private ArrayList<Integer> madeOf = new ArrayList<Integer>();
//	private	ArrayList<Integer> dissolves = new ArrayList<Integer>();
	
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
	private ArrayList<String> getAllBases() throws DatabaseException, SQLException{
		ArrayList<String> data = new ArrayList<String>();
		ResultSet rs;
		
		try {
			Connection cn = DatabaseManager.getSingleton().getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM Chemical WHERE type = 1");
			while(rs.next()) {
				data.add(rs.getString("Name"));
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
	private ArrayList<String> getElementsInRange(double lower, double upper) {
		ArrayList<String> data = new ArrayList<String>();
		ResultSet rs;
		
		try {
			Connection cn = DatabaseManager.getSingleton().getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM Chemical WHERE atomicMass > " + lower
					+ "AND WHERE atomicMass < " + upper);
			while(rs.next()) {
				data.add(rs.getString("Name"));
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
	private ArrayList<String> getCompoundsByElement(int ID) {
		ArrayList<String> data = new ArrayList<String>();
		ResultSet rs;
		
		try {
			Connection cn = DatabaseManager.getSingleton().getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM CompoundMadeOfElement WHERE ElementID = " + ID);
			while(rs.next()) {
				data.add(rs.getString("Name"));
			}
			
		} catch(SQLException | DatabaseException e) {
			
		}
		
		return data;
	}
}
