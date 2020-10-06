package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Daniel Holmgren
 * @author Joshua Kellogg
 * The row data gateway that will allow us to access the metal table
 */
public class MetalRDG {
	private int ID,
				atomicNumber,
				dissolvedBy;
	private double atomicMass;
	private String name;
	private static Connection cn;
	
	/**
	 * Constructor assigns instance variables and sets up the connection that well need for the other methods in this class
	 * @param ID
	 * @param atomicNumber
	 * @param dissolvedBy
	 * @param atomicMass
	 * @param name
	 */
	public MetalRDG(int ID, int atomicNumber, int dissolvedBy, double atomicMass, String name) {
		this.ID = ID;
		this.atomicNumber = atomicNumber;
		this.dissolvedBy = dissolvedBy;
		this.atomicMass = atomicMass;
		this.name = name;
		
		try {
			DatabaseManager db = DatabaseManager.getSingleton();
			cn = db.getConnection();
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
	}
	
	/**
	 * @author Dan Holmgren
	 * @author Josh Kellogg
	 * @param ID The ID to search the database for
	 * @return A metalRDG with the correct Metal
	 */
	public static MetalRDG findByID(int ID) {
		MetalRDG results = null;
		try {
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM Metal WHERE elementOrMetalID = " + ID);
			rs.next();
			results = new MetalRDG(rs.getInt("elementOrMetalID"), rs.getInt("metalAtomicNumber"), rs.getInt("metalDissolvedBy"), rs.getDouble("metalAtomicMass"), rs.getString("metalName"));						
		} catch (SQLException e) {
			DatabaseException.detectError(e);					
		}
		return results;
	}
	
	/**
	 * Given the name of a metal will return the information from the database about that metal
	 * @param name
	 * @return A metalRDG with information from the database corresponding to the given name
	 */
	public static MetalRDG findByName(String name) {
		MetalRDG results = null;
		try {
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM Metal WHERE metalName = '" + name + "'");
			rs.next();
			results = new MetalRDG(rs.getInt("elementOrMetalID"), rs.getInt("metalAtomicNumber"), rs.getInt("metalDissolvedBy"), rs.getDouble("metalAtomicMass"), rs.getString("metalName"));						
		} catch (SQLException e) {
			DatabaseException.detectError(e);					
		}
		return results;
	}
	
	/**
	 * Method to see if a Chemical with a given name is a Metal
	 * @author Madeline and Adam
	 * @param name the name of the Chemical
	 * @return Metal if it is a Metal, null if it is not
	 */
	public static String findTypeByName(String name) {
		Connection c;
		try {
			c = DatabaseManager.getSingleton().getConnection();
			ResultSet rs = c.createStatement().executeQuery("SELECT * FROM Metal WHERE Metal.MetalName = '" + name + "'");
			if (rs.next()) {
				return "Metal";
			}
		} catch (SQLException | DatabaseException e) {
			DatabaseException.detectError(e);
		}
		return null;
	}
	
	/**
	 * Will update the database with the current values of the instance variables
	 */
	public void update() {
		PreparedStatement stmt;
		try {
			stmt = cn.prepareStatement("UPDATE Metal SET metalName = ?, metalAtomicNumber = ?, metalAtomicMass = ?, metalDissolvedBy = ? WHERE elementOrMetalID = ?");
			stmt.setString(1, name);
			stmt.setInt(2, atomicNumber);
			stmt.setDouble(3, atomicMass);
			stmt.setDouble(4, dissolvedBy);
			stmt.setInt(5, ID);
			stmt.execute();
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
	}
	
	//Getters and Setters
	
	public int getID() {
		return ID;
	}

	public int getAtomicNumber() {
		return atomicNumber;
	}

	public void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}

	public int getDissolvedBy() {
		return dissolvedBy;
	}

	public void setDissolvedBy(int dissolvedBy) {
		this.dissolvedBy = dissolvedBy;
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
	
	
}
