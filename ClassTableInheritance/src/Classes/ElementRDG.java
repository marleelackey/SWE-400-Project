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
	private static Connection cn;
	
	public ElementRDG(int ID, int atomicNumber, double atomicMass) {
		this.ID = ID;
		this.atomicNumber = atomicNumber;
		this.atomicMass = atomicMass;
		
		try {
			DatabaseManager db = DatabaseManager.getSingleton();
			db.setPatternNumber(3);
			cn = db.getConnection();
		} catch(Exception e) {
			DatabaseException.detectError(e);
		}
	}
	
	public static ElementRDG findByID(int ID) {
		ElementRDG data = null;
		try {
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM Element WHERE elementID = " + ID);
			rs.next();
			data = new ElementRDG(rs.getInt("elementID"), rs.getInt("elementAtomicNumber"), rs.getDouble("elementAtomicMass"));
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		return data;
	}
	
	public static ElementRDG findByAtomicNumber(int atomicNumber) {
		ElementRDG data = null;
		try {
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM Element WHERE elementAtomicNumber = " + atomicNumber);
			rs.next();
			data = new ElementRDG(rs.getInt("elementID"), rs.getInt("elementAtomicNumber"), rs.getDouble("elementAtomicMass"));
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		return data;
	}
	
	public static ElementRDG findByAtomicMass(double atomicMass) {
		ElementRDG data = null;
		try {
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM Element WHERE elementAtomicMass = " + atomicMass);
			rs.next();
			data = new ElementRDG(rs.getInt("elementID"), rs.getInt("elementAtomicNumber"), rs.getDouble("elementAtomicMass"));
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		return data;
	}
	
	public void update() {
		PreparedStatement stmt;
		try {
			stmt = cn.prepareStatement("UPDATE Element SET elementAtomicNumber = ?, elementAtomicMass = ? WHERE elementID = ?");
			stmt.setInt(1, atomicNumber);
			stmt.setDouble(2, atomicMass);
			stmt.setInt(3, ID);
			stmt.execute();
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
	}
	
	public int getID() {
		return ID;
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
}
