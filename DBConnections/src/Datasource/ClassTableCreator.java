package Datasource;

import java.sql.SQLException;
import java.sql.Statement;

public class ClassTableCreator {
	
	static Statement stmt;
    static String insertData; 
    
    
	public static void createTables() throws SQLException, DatabaseException {
		stmt = DatabaseManager.getSingleton().getConnection().createStatement();

	    String[] table_statements =
            {"CREATE TABLE IF NOT EXISTS Chemical (name VARCHAR(32) NOT NULL, id long NOT NULL, inhabits VARCHAR(32) NOT NULL, PRIMARY KEY (id))",
             "CREATE TABLE IF NOT EXISTS Element (id long NOT NULL, atomicNumber int NOT NULL, atomicMass double NOT NULL, PRIMARY KEY (id))",
             "CREATE TABLE IF NOT EXISTS Compound (id long NOT NULL, PRIMARY KEY (id))",
             "CREATE TABLE IF NOT EXISTS CompoundMadeOfElement (compoundID long, elementID long)",
             "CREATE TABLE IF NOT EXISTS Base (id long NOT NULL, solute long NOT NULL, PRIMARY KEY (id))",
             "CREATE TABLE IF NOT EXISTS Acid (id long NOT NULL, solute long NOT NULL, PRIMARY KEY (id))",
             "CREATE TABLE IF NOT EXISTS Metal (id long NOT NULL, dissolvedBy long NOT NULL, PRIMARY KEY (id))",
            };

	    for (int i = 0; i < table_statements.length; i++) {
	      insertData = new String(table_statements[i]);
	      stmt.executeUpdate(insertData);
	      System.out.println("created table " + i);
	    }
	    
	}

	public static void dropAllTables() throws SQLException, DatabaseException {

		    Statement stmt;
		    String insertData;

		    stmt = DatabaseManager.getSingleton().getConnection().createStatement();

		    String[] table_statements =
		            {"DROP TABLE IF EXISTS Chemical",
		             "DROP TABLE IF EXISTS Element",
		             "DROP TABLE IF EXISTS Compound",
		             "DROP TABLE IF EXISTS CompoundMadeOfElement",
		             "DROP TABLE IF EXISTS Base",
		             "DROP TABLE IF EXISTS Acid",
		             "DROP TABLE IF EXISTS Metal",
		            };

		    for (int i = table_statements.length - 1; i >= 0; i--) {
		      insertData = new String(table_statements[i]);
		      stmt.executeUpdate(insertData);
		    }
		    
	}

}