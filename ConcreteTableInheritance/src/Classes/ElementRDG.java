package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;

public class ElementRDG {
	private int ID,
				atomicNumber;
	private double atomicMass;
	private String name;
	
	/**
	 * Constructor for ElementRDG
	 * 
	 * @author Dan Holmgren
	 * @author Josh Kellogg
	 * @param ID The ID of the Element
	 * @param atomicNumber The Element's atomic number
	 * @param atomicMass The Element's atomic mass
	 * @param name The Element's name
	 */
	public ElementRDG(int ID, int atomicNumber, double atomicMass, String name) {
		this.ID = ID;
		this.atomicNumber = atomicNumber;
		this.atomicMass = atomicMass;
		this.name = name;
	}
	
	/**
	 * @author Dan Holmgren
	 * @author Josh Kellogg
	 * @param ID The ID to search the Element table for
	 * @return An ElementRDG with the element with the ID passed in
	 */
	public static ElementRDG findByID(int ID) {
		Connection cn;
		ElementRDG data = null;
		try {
			DatabaseManager db = DatabaseManager.getSingleton();
			db.setPatternNumber(2);
			cn = db.getConnection();
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM Element WHERE elementOrMetalID = " + ID);
			rs.next();
			data = new ElementRDG(rs.getInt("elementOrMetalID"), rs.getInt("elementAtomicNumber"), rs.getDouble("elementAtomicMass"), rs.getString("elementName"));
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		return data;
	}
	
	/**
	 * @author Dan Holmgren
	 * @author Josh Kellogg
	 * @param atomicNum The atomic number to search the Element table for
	 * @return an Element RDG with the element with the atomic number passed in
	 */
	public static ElementRDG findByAtomicNumber(int atomicNum) {
		Connection cn;
		ElementRDG data = null;
		try {
			DatabaseManager db = DatabaseManager.getSingleton();
			db.setPatternNumber(2);
			cn = db.getConnection();
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM Element WHERE elementAtomicNumber = " + atomicNum);
			rs.next();
			data = new ElementRDG(rs.getInt("elementOrMetalID"), rs.getInt("elementAtomicNumber"), rs.getDouble("elementAtomicMass"), rs.getString("elementName"));
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		
		return data;
	}
	
	/**
	 * @author Dan Holmgren
	 * @author Josh Kellogg
	 * @param atomMass The atomic mass to search the Element table for
	 * @return An element RDG with the element with the atomic mass that was passed in
	 */
	public static ElementRDG findByAtomicMass(double atomMass) {
		Connection cn;
		ElementRDG data = null;
		try {
			DatabaseManager db = DatabaseManager.getSingleton();
			db.setPatternNumber(2);
			cn = db.getConnection();
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM Element WHERE elementAtomicMass = " + atomMass);
			rs.next();
			data = new ElementRDG(rs.getInt("elementOrMetalID"), rs.getInt("elementAtomicNumber"), rs.getDouble("elementAtomicMass"), rs.getString("elementName"));		} catch (Exception e ){
			DatabaseException.detectError(e);
		}
		return data;
	}
	
	/**
	 * @author Dan Holmgren
	 * @author Josh Kellogg
	 * @param eName The name of the element to search the element table for
	 * @return An element RDG with the element with the name that was passed in
	 */
	public static ElementRDG findByName(String eName) {
		Connection cn;
		ElementRDG data = null;
		try {
			DatabaseManager db = DatabaseManager.getSingleton();
			db.setPatternNumber(2);
			cn = db.getConnection();
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM Element WHERE elementName = '" + eName + "'");
			rs.next();
			data = new ElementRDG(rs.getInt("elementOrMetalID"), rs.getInt("elementAtomicNumber"), rs.getDouble("elementAtomicMass"), rs.getString("elementName"));		} catch (Exception e ){
			DatabaseException.detectError(e);
		}
		return data;
	}

	/**
	 * Below are getters and setters for the instance variables
	 */
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getAtomicNumber() {
		return atomicNumber;
	}

	public void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}

	public double getAtomicMass() {
		return atomicMass;
	}

	public void setAtomicMass(double atomicMass) {
		this.atomicMass = atomicMass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @author Dan Holmgren
	 * @author Josh Kellogg
	 * Updates the database with the new information from the RDG
	 */
	public void update() {
		PreparedStatement stmt;
		Connection cn;
		try {
			DatabaseManager db = DatabaseManager.getSingleton();
			db.setPatternNumber(2);
			cn = db.getConnection();
			//May need a WHERE clause at end
			stmt = cn.prepareStatement("UPDATE ELEMENT SET ID = ?, atomicNumber = ?, atomicMass = ?, name = ?");
			stmt.setInt(1, ID);
			stmt.setInt(2, atomicNumber);
			stmt.setDouble(3, atomicMass);
			stmt.setString(4, name);
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
	}
}
