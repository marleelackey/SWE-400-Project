package Datasource;

import java.sql.SQLException;
import java.sql.Statement;

public class ConcreteTableCreator {
	
	static Statement stmt;
    static String insertData; 
    
    
	public static void createTables() throws SQLException, DatabaseException {
		stmt = DatabaseManager.getSingleton().getConnection().createStatement();

	    String[] table_statements =
            {"CREATE TABLE IF NOT EXISTS Element (name VARCHAR(32) NOT NULL, elementOrMetalId long NOT NULL, inhabits VARCHAR(32) NOT NULL, atomicNumber int, atomicMass double, PRIMARY KEY (elementOrMetalId))",
             "CREATE TABLE IF NOT EXISTS Compound (name VARCHAR(32) NOT NULL, id long NOT NULL, inhabits VARCHAR(32) NOT NULL, PRIMARY KEY (id))",
             "CREATE TABLE IF NOT EXISTS Base (name VARCHAR(32) NOT NULL, id long NOT NULL, inhabits VARCHAR(32) NOT NULL, solute long NOT NULL, PRIMARY KEY (id))",
             "CREATE TABLE IF NOT EXISTS Acid (name VARCHAR(32) NOT NULL, id long NOT NULL, inhabits VARCHAR(32) NOT NULL, solute long NOT NULL, PRIMARY KEY (id))",
             "CREATE TABLE IF NOT EXISTS Metal (name VARCHAR(32) NOT NULL, elementOrMetalId long NOT NULL, inhabits VARCHAR(32) NOT NULL, atomicNumber int NOT NULL, atomicMass double NOT NULL, dissolvedBy long NOT NULL, PRIMARY KEY (elementOrMetalId))",
             "CREATE TABLE IF NOT EXISTS CompoundMadeOfElement (compoundID long, elementID long)"
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
		            {"DROP TABLE IF EXISTS Element",
		             "DROP TABLE IF EXISTS Compound",
		             "DROP TABLE IF EXISTS Base",
		             "DROP TABLE IF EXISTS Acid",
		             "DROP TABLE IF EXISTS Metal",
		             "DROP TABLE IF EXISTS CompoundMadeOfElement"
		            };

		    for (int i = table_statements.length - 1; i >= 0; i--) {
		      insertData = new String(table_statements[i]);
		      stmt.executeUpdate(insertData);
		    }
		    
	}

}