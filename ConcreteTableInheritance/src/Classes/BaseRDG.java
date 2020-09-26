package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;

public class BaseRDG {
	private int ID;
	private String name;
	private int solute;
	
	public BaseRDG(int id, String nme, int slte)
	{
		this.ID = id;
		name = nme;
		solute = slte;
	}
	
	public static BaseRDG findByID(int ident)
	{
		Connection c;
		BaseRDG result = null;
		try {
			c = DatabaseManager.getSingleton().getConnection();
			ResultSet rs = c.createStatement().executeQuery("SELECT * FROM Base WHERE baseID = " + ident);
			rs.next();
			result = new BaseRDG(rs.getInt(1), rs.getString(2), rs.getInt(3));
		} catch (Exception e) {
			e.printStackTrace();
			DatabaseException.detectError(" BaseRDG, method: FindByID " , e);
		}
		return result;
	}

	public static BaseRDG findByName(String nm) {
		Connection c;
		BaseRDG result = null;
		try {
			c = DatabaseManager.getSingleton().getConnection();
			ResultSet rs = c.createStatement().executeQuery("SELECT * FROM Base WHERE baseName = \'" + nm + "\'");
			rs.next();
			result = new BaseRDG(rs.getInt(1), rs.getString(2), rs.getInt(3));
		} catch (Exception e) {
			e.printStackTrace();
			DatabaseException.detectError(e);
		}
		return result;
	}
	
	public void update() {
		PreparedStatement stmt;
		Connection cn;
		try {
			cn = DatabaseManager.getSingleton().getConnection();
			stmt = cn.prepareStatement("UPDATE Base SET baseName = ?, baseSolute = ? WHERE baseID = ?");
			stmt.setString(1, name);
			stmt.setInt(2, solute);
			stmt.setInt(3, ID);
			stmt.execute(); 
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
	}


	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getSolute()
	{
		return solute;
	}
	
	public void setID(int iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSolute(int solute) {
		this.solute = solute;
	}

}
