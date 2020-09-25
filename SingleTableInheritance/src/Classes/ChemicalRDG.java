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
	Connection connection;
	
	/* constructor */
	public ChemicalRDG(int ID) throws DatabaseException {
		this.ID = ID;
		ResultSet rs = null;
		String query = "SELECT * FROM Chemical WHERE Chemical.chemicalID = ?";

		// connection to the DB
		connection = DatabaseManager.getSingleton().getConnection();	
		
		try {
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if(rs.next()) {
				chem = new ChemicalDTO(ID, type, name, atomicNumber, atomicMass, dissolvedBy, soluteA, soluteB);
			 }
		}
		catch (SQLException e) {
			/* ask merlin about whether we should close rs, statement, and/or connection */
			DatabaseException.detectError(e);
			
		}

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
	public ChemicalDTO findByIDSingle(int ID) {
		
		String query = "SELECT * FROM Chemical WHERE Chemical.chemicalID = ?";
		ResultSet rs = null;
		ChemicalDTO chem = null;
		try {
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if(rs.next()) {
				chem = new ChemicalDTO(ID, type, name, atomicNumber, atomicMass, dissolvedBy, soluteA, soluteB);
			 }
		}
		catch (SQLException e) {
			/* ask merlin about whether we should close rs, statement, and/or connection */
			DatabaseException.detectError(e);
			
		}
		
		return chem;
	}
	
	public ChemicalDTO findByName(String name) {
		String query = "SELECT * FROM Chemical WHERE Chemical.chemicalName = ? ";
		ResultSet rs = null;
		ChemicalDTO chem = null;							
		try {
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if(rs.next()) {
				chem = new ChemicalDTO(ID, type, name, atomicNumber, atomicMass, dissolvedBy, soluteA, soluteB);
			}							
		} 
		catch (SQLException e) {
			DatabaseException.detectError(e);
								
		}
										
		return chem;	
		
	}
	
	public ChemicalDTO findByAtomicNumber(int atomicNumber) {
		String query = "SELECT * FROM Chemical WHERE Chemical.chemcialAtomicNumber = ? ";
		ResultSet rs = null;
		ChemicalDTO chem = null;
		try {
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if(rs.next()) {
				chem = new ChemicalDTO(ID, type, name, atomicNumber, atomicMass, dissolvedBy, soluteA, soluteB);
			}							
		}
		catch (SQLException e) {
			DatabaseException.detectError(e);

		}
		
		return chem;
	}
	
	public ChemicalDTO findByAtomicMass(double atomicMass) {
		String query = "SELECT * FROM Chemical WHERE Chemical.chemicalAtomicMass = ? ";
		ResultSet rs = null;
		ChemicalDTO chem = null;
		try {
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if(rs.next()) {
				chem = new ChemicalDTO(ID, type, name, atomicNumber, atomicMass, dissolvedBy, soluteA, soluteB);
			}							
		}
		catch (SQLException e) {
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
