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
	int dissolvedBy; // is the ID of the Acid it is dissolved by -- should it be int[]?????
	int soluteA;
	int soluteB;
	Connection connection;
	
	/* constructor */
	public ChemicalRDG(int ID, int type, String name, int atomicNumber, double atomicMass, int dissolvedBy, 
			int soluteA, int soluteB) throws DatabaseException {
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
	public ChemicalDTO findByIDSingle(int ID) throws DatabaseException {
		
		String query = "SELECT * FROM CHEMICAL WHERE CHEMICAL.id = ?";
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
			//throw new DatabaseException("Couldn't find ID of " + ID + " in the CHEMICAL table.");
			DatabaseException.detectError(e);
		}
		
		return chem;
	}
	
	public ChemicalDTO findByName(String name) throws DatabaseException {
		String query = "SELECT * FROM CHEMICAL WHERE CHEMICAL.name = ? ";
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
			//throw new DatabaseException("Couldn't find ID to match the name of " + name + " in the CHEMICAL table.");
			DatabaseException.detectError(e);
					
		}
										
		return chem;	
		
	}
	
	public ChemicalDTO findByAtomicNumber(int atomicNumber) throws DatabaseException {
		String query = "SELECT * FROM CHEMICAL WHERE CHEMICAL.atomicNumber = ? ";
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
			//throw new DatabaseException("Couldn't find ID to match the atomic number of " + atomicNumber + " in the CHEMICAL table.");
			DatabaseException.detectError(e);

		}
		
		return chem;
	}
	
	public ChemicalDTO findByAtomicMass(double atomicMass) throws DatabaseException {
		String query = "SELECT * FROM CHEMICAL WHERE CHEMICAL.atomicMass = ? ";
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
			//throw new DatabaseException("Couldn't find ID to match the atomic mass of " + atomicMass + " in the CHEMICAL table.");
			DatabaseException.detectError(e);

		}
		
		return chem;
	}
	
	public void update() throws DatabaseException {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("UPDATE CHEMICAL SET name = ?, type = ?, atomicNumber = ?,"
					+ "atomicMass = ?, dissolvedBy = ?, baseSolute = ?, acidSolute = ?,  WHERE CHEMICAL.id = ?");
			stmt.setString(1, name);
			stmt.setInt(2,  type);
			stmt.setInt(3, atomicNumber);
			stmt.setDouble(4,  atomicMass);
			stmt.setInt(5, dissolvedBy);
			stmt.setInt(6, soluteB);
			stmt.setInt(7,  soluteA);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			//throw new DatabaseException("Couldn't update the CHEMICAL table for ID " + ID);
			DatabaseException.detectError(e);

		}
		
	}

}
