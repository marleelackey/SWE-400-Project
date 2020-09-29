package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;

public class BaseRDG {

	private int id;
	private int solute;
	
	public static BaseRDG findByID(int id) {
		Connection c;
		BaseRDG result = null;
		try {
			c = DatabaseManager.getSingleton().getConnection();
			ResultSet rs = c.createStatement().executeQuery("SELECT * FROM Base WHERE baseID = " + id);
			rs.next();
			result = new BaseRDG(rs.getInt(1), rs.getInt(2));
		} catch (Exception e) {
			DatabaseException.detectError(e, "Exception in BaseRDG.findByID()");
		}
		return result;
	}

	public BaseRDG(int id, int solute) {
		this.id = id;
		this.solute = solute;
	}

	public int getID() {
		return this.id;
	}

	public int getSolute() {
		return this.solute;
	}

	public void setID(int id) {
		this.id = id;
	}

	public void setSolute(int s) {
		this.solute = s;		
	}

	public void update() {
		Connection c;
		try {
			c = DatabaseManager.getSingleton().getConnection();
			PreparedStatement s = c.prepareStatement("UPDATE Base SET baseSolute = ? WHERE baseID = ?");
			s.setInt(1, solute);
			s.setInt(2, id);
			s.execute();
		} catch (Exception e) {
			DatabaseException.detectError(e, "exception in BaseRDG.update()");
		}
		
	}


	

}
