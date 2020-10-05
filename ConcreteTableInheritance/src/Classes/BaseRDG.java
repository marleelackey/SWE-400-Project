package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;

/**
 * @author Josh B, Madeline, Adam and Ace  
 * 
 *
 */
public class BaseRDG {
	private int ID;
	private String name;
	private int solute;
	
	/**
	 * Constructor for the RDG class 
	 * @param id, (Identification number)
	 * @param nme  (base name)
	 * @param slte (Solute for the base) 
	 */
	public BaseRDG(int id, String nme, int slte)
	{
		this.ID = id;
		name = nme;
		solute = slte;
	}
	
	/**
	 * @param ident
	 * @return a RDG instance of the result of the search 
	 * of a specific base via ID number 
	 */
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
			DatabaseException.detectError( e);
		}
		return result;
	}

	/**
	 * @param nm
	 * @return a RDG instance of the result of the search 
	 * of a specific base via Base name 
	 */
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
	
	/**
	 * Method to see if a Chemical with a given name is a Base
	 * @author Madeline and Adam
	 * @param name the name of the Chemical
	 * @return Base if it is a Base, null if it is not
	 */
	public static String findTypeByName(String name) {
		Connection c;
		try {
			c = DatabaseManager.getSingleton().getConnection();
			ResultSet rs = c.createStatement().executeQuery("SELECT * FROM Base WHERE Base.baseName = '" + name + "'");
			if (rs.next()) {
				return "Base";
			}
		} catch (SQLException | DatabaseException e) {
			DatabaseException.detectError(e);
		}
		return null;
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
