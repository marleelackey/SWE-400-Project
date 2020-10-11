package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Daniel Holmgren
 * @author Joshua Kellogg
 *
 * The metalRDG class for accessing the database
 */
public class MetalRDG {
	private int ID,
				dissolvedBy;
	private static Connection cn;
	
	/**
	 * Constructor, assigns variables and sets up the connection for use in the rest of the class
	 * @param ID
	 * @param dissolvedBy
	 */
	public MetalRDG(int ID, int dissolvedBy) {
		this.ID = ID;
		this.dissolvedBy = dissolvedBy;
		
		DatabaseManager db;
		try {
			db = DatabaseManager.getSingleton();
			cn = db.getConnection();
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
	}
	
	/**
	 * Returns a metalRDG with the given ID
	 * @param ID
	 * @return
	 */
	public static MetalRDG findByID(int ID) {
		MetalRDG data = null;
		try {
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM Metal WHERE metalID = " + ID);
			rs.next();
			data = new MetalRDG(rs.getInt("metalID"),rs.getInt("metalDissolvedBy"));
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		return data;
	}
	
	/**
	 * Updates the database with the given instance variables 
	 */
	public void update() {
		PreparedStatement stmt;
		try {
			stmt = cn.prepareStatement("UPDATE Metal SET metalDissolvedBy = ? WHERE metalID = ?");
			stmt.setInt(1, dissolvedBy);
			stmt.setInt(2, ID);
			stmt.execute();
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
	}
	
	public void insert() {
		PreparedStatement stmt;
		try {
			Connection connection = DatabaseManager.getSingleton().getConnection();

			stmt = connection.prepareStatement(
					"INSERT INTO Metal VALUES (?, ?)");
			stmt.setInt(1, ID);
			stmt.setInt(2, dissolvedBy);

			stmt.executeUpdate();		
		
		} catch (Exception e) {
			DatabaseException.detectError(e);

		}

	}

	// Getters and setter
	public int getID() {
		return ID;
	}

	public int getDissolvedBy() {
		return dissolvedBy;
	}

	public void setDissolvedBy(int dissolvedBy) {
		this.dissolvedBy = dissolvedBy;
	}
}
