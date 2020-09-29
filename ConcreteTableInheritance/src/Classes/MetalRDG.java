package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;

public class MetalRDG {
	private int ID,
				atomicNumber,
				dissolvedBy;
	private double atomicMass;
	private String name;
	private static Connection cn;
	
	public MetalRDG(int ID, int atomicNumber, int dissolvedBy, double atomicMass, String name) {
		this.ID = ID;
		this.atomicNumber = atomicNumber;
		this.dissolvedBy = dissolvedBy;
		this.atomicMass = atomicMass;
		this.name = name;
		
		try {
			DatabaseManager db = DatabaseManager.getSingleton();
			db.setPatternNumber(2);
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
	
	public static MetalRDG findByName(String name) {
		MetalRDG results = null;
		try {
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM Metal WHERE metalAtomicNumber = '" + name + "'");
			rs.next();
			results = new MetalRDG(rs.getInt("elementOrMetalID"), rs.getInt("metalAtomicNumber"), rs.getInt("metalDissolvedBy"), rs.getDouble("metalAtomicMass"), rs.getString("metalName"));						
		} catch (SQLException e) {
			DatabaseException.detectError(e);					
		}
		return results;
	}
	
	public void update() {
		PreparedStatement stmt;
		Connection cn;
		try {
			DatabaseManager db = DatabaseManager.getSingleton();
			db.setPatternNumber(2);
			cn = db.getConnection();
			//May need a WHERE clause at end
			stmt = cn.prepareStatement("UPDATE Metal SET metalName = ?, metalAtomicNumber = ?, metalAtomicMass = ?, metalDissolvedBy = ?, WHERE elementOrMetalID = ?");
			stmt.setString(1, name);
			stmt.setInt(2, atomicNumber);
			stmt.setDouble(3, atomicMass);
			stmt.setDouble(4, dissolvedBy);
			stmt.setInt(5, ID);
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
