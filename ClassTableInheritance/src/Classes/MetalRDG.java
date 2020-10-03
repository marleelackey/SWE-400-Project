package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;

public class MetalRDG {
	private int ID,
				dissolvedBy;
	private static Connection cn;
	
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
