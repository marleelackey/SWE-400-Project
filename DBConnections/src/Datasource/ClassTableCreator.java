package Datasource;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Table Creator for Class Table Inheritance
 * @author Joshua & Madeline
 *
 */
public class ClassTableCreator {
	
	static Statement stmt;
    static String insertData; 
    
    
	public static void createTables() throws SQLException, DatabaseException {
		stmt = DatabaseManager.getSingleton().getConnection().createStatement();

	    String[] table_statements =
            {"CREATE TABLE IF NOT EXISTS Chemical (chemicalID int NOT NULL, chemicalName VARCHAR(32) NOT NULL, PRIMARY KEY (chemicalID))",
             "CREATE TABLE IF NOT EXISTS Element (elementID int NOT NULL, elementAtomicNumber int NOT NULL, elementAtomicMass double NOT NULL, PRIMARY KEY (elementID))",
             "CREATE TABLE IF NOT EXISTS Compound (compoundID int NOT NULL, PRIMARY KEY (compoundID))",
             "CREATE TABLE IF NOT EXISTS CompoundMadeOfElement (compoundID int, elementID int)",
             "CREATE TABLE IF NOT EXISTS Base (baseID int NOT NULL, baseSolute int NOT NULL, PRIMARY KEY (baseID))",
             "CREATE TABLE IF NOT EXISTS Acid (acidID int NOT NULL, acidSolute int NOT NULL, PRIMARY KEY (acidID))",
             "CREATE TABLE IF NOT EXISTS Metal (metalID int NOT NULL, metalDissolvedBy int NOT NULL, PRIMARY KEY (metalID))",
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
	
	public static void addTestRows() throws SQLException, DatabaseException {
		stmt = DatabaseManager.getSingleton().getConnection().createStatement();

		String[] table_statements = { "INSERT INTO Acid VALUES (1, 4)",
				"INSERT INTO Acid VALUES (2, 5)", 
				"INSERT INTO Acid VALUES (3, 5)",
				"INSERT INTO Element VALUES (4, 12, 50.01)",
				"INSERT INTO Element VALUES (5, 40, 20.0)",
				"INSERT INTO Element VALUES (6, 55, 20.2)",
				"INSERT INTO Element VALUES (7, 30, 40.0)",
				"INSERT INTO Element VALUES (8, 44, 100.1)",
				"INSERT INTO Metal VALUES (9, 55)",
				"INSERT INTO Metal VALUES (10, 66)",
				"INSERT INTO Metal VALUES (11, 77)",};

		for (int i = 0; i < table_statements.length; i++) {
			insertData = new String(table_statements[i]);
			stmt.executeUpdate(insertData);
		}

	}

}