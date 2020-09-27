package Classes;

import java.sql.*;
import Datasource.DatabaseException;
import Datasource.DatabaseManager;
/**
 * @author Taryn Whitman
 * @author Marlee Lackey
 */
public class ChemicalRDG {
	int ID;
	int type;
	String name;
	int atomicNumber;
	double atomicMass;
	int dissolvedBy; // is the ID of the Acid it is dissolved by 
	int soluteA;
	int soluteB;
	static Connection connection;
	
	/** Constructor used to make an instance of an object already created in the database
	 * @param ID 
	 * @throws DatabaseException
	 */
	public ChemicalRDG(int ID, int type, String name, int atomicNumber, double atomicMass, int dissolvedBy, int soluteA, int soluteB) throws DatabaseException {
		this.ID = ID;
		this.type = type;
		this.name = name;
		this.atomicNumber = atomicNumber;
		this.atomicMass = atomicMass;
		this.dissolvedBy = dissolvedBy;
		this.soluteA = soluteA;
		this.soluteB = soluteB;
		
		// connection to the DB
		connection = DatabaseManager.getSingleton().getConnection();

	}
	
	// setters
	public void setID(int id) {
		ID = id;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}
	public void setAtomicMass(double atomicMass) {
		this.atomicMass = atomicMass;
	}
	public void setDissolvedBy(int dissolvedBy) {
		this.dissolvedBy = dissolvedBy;
	}
	public void setSoluteA(int soluteA) {
		this.soluteA = soluteA;
	}
	public void setSoluteB(int soluteB) {
		this.soluteB = soluteB;
	}
	
	
	// getters
	public int getID() {
		return ID;
	}
	
	public int getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAtomicNumber() {
		return atomicNumber;
	}
	
	public double getAtomicMass() {
		return atomicMass;
	}
	
	public int getDissolvedBy() {
		return dissolvedBy;
	} 
	
	public int getSoluteA() {
		return soluteA;
	}
	
	public int getSoluteB() {
		return soluteB;
	}
	
	// finders
	public static ChemicalRDG findByIDSingle(int ID) {
		ChemicalRDG chem = null;							
		try {
			ResultSet r = connection.createStatement().executeQuery("SELECT * FROM Chemical WHERE Chemical.chemicalID = "+ ID);
			r.next();
			chem = new ChemicalRDG(r.getInt(1), r.getInt(2), r.getString(3), r.getInt(4), r.getDouble(5), r.getInt(6), r.getInt(7), r.getInt(8));						
		} catch (SQLException | DatabaseException e) {
			DatabaseException.detectError(e);					
		}
										
		return chem;	
	}
	
	public static ChemicalRDG findByName(String name) {
		ChemicalRDG chem = null;							
		try {
			ResultSet r = connection.createStatement().executeQuery("SELECT * FROM Chemical WHERE Chemical.chemicalName = "+ name);
			r.next();
			chem = new ChemicalRDG(r.getInt(1), r.getInt(2), r.getString(3), r.getInt(4), r.getDouble(5), r.getInt(6), r.getInt(7), r.getInt(8));	
			} 
		catch (SQLException | DatabaseException e) {
			DatabaseException.detectError(e);					
		}
										
		return chem;	
		
	}
	
	public static ChemicalRDG findByAtomicNumber(int atomicNumber) {
		ChemicalRDG chem = null;							
		try {
			ResultSet r = connection.createStatement().executeQuery("SELECT * FROM Chemical WHERE Chemical.chemcialAtomicNumber = "+ atomicNumber);
			r.next();
			chem = new ChemicalRDG(r.getInt(1), r.getInt(2), r.getString(3), r.getInt(4), r.getDouble(5), r.getInt(6), r.getInt(7), r.getInt(8));	
			} 
		catch (SQLException | DatabaseException e) {
			DatabaseException.detectError(e);					
		}
										
		return chem;	
	}
	
	public static ChemicalRDG findByAtomicMass(double atomicMass) {
		ChemicalRDG chem = null;							
		try {
			ResultSet r = connection.createStatement().executeQuery("SELECT * FROM Chemical WHERE Chemical.chemicalAtomicMass = "+ atomicMass);
			r.next();
			chem = new ChemicalRDG(r.getInt(1), r.getInt(2), r.getString(3), r.getInt(4), r.getDouble(5), r.getInt(6), r.getInt(7), r.getInt(8));	
			} 
		catch (SQLException | DatabaseException e) {
			DatabaseException.detectError(e);					
		}
										
		return chem;

	}
	
	public void update() {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("UPDATE Chemical SET chemicalName = ?, chemicalType = ?, chemicalAtomicNumber = ?,"
					+ "chemicalAtomicMass = ?, chemicalDissolvedBy = ?, chemicalBaseSolute = ?, chemicalAcidSolute = ? WHERE Chemical.chemicalID = ?");
			stmt.setString(1, name);
			stmt.setInt(2,  type);
			stmt.setInt(3, atomicNumber);
			stmt.setDouble(4,  atomicMass);
			stmt.setInt(5, dissolvedBy);
			stmt.setInt(6, soluteB);
			stmt.setInt(7,  soluteA);
			stmt.setInt(8, ID);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			DatabaseException.detectError(e);
			
		}
		
	}

}
