package datasource;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Table creator for Concrete Table Inheritance.
 * @author Joshua B
 * @author Madeline C
 */
public class ConcreteTableCreator {

	static Statement stmt;
	static String insertData;

	/**
	 * Creates tables in the database.
	 */
	public static void createTables() {
		
		try {
			stmt = DatabaseManager.getSingleton().getConnection().createStatement();

			String[] table_statements = {
					"CREATE TABLE IF NOT EXISTS Element (elementOrMetalID int NOT NULL, elementName VARCHAR(32) NOT NULL, elementAtomicNumber int, elementAtomicMass double, PRIMARY KEY (elementOrMetalID))",
					"CREATE TABLE IF NOT EXISTS Compound (compoundID int NOT NULL, compoundName VARCHAR(32) NOT NULL, PRIMARY KEY (compoundID))",
					"CREATE TABLE IF NOT EXISTS Base (baseID int NOT NULL, baseName VARCHAR(32) NOT NULL, baseSolute int NOT NULL, PRIMARY KEY (baseID))",
					"CREATE TABLE IF NOT EXISTS Acid (acidID int NOT NULL, acidName VARCHAR(32) NOT NULL, acidSolute int NOT NULL, PRIMARY KEY (acidID))",
					"CREATE TABLE IF NOT EXISTS Metal (elementOrMetalID int NOT NULL, metalName VARCHAR(32) NOT NULL, metalAtomicNumber int NOT NULL, metalAtomicMass double NOT NULL, metalDissolvedBy int NOT NULL, PRIMARY KEY (elementOrMetalID))",
					"CREATE TABLE IF NOT EXISTS CompoundMadeOfElement (compoundID int, elementID int)" };

			for (int i = 0; i < table_statements.length; i++) {
				insertData = new String(table_statements[i]);
				stmt.executeUpdate(insertData);
				System.out.println("created table " + i);
			}
	
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
	}

	/**
	 * drops all of the tables in the database.
	 */
	public static void dropAllTables() {
		
		try {
			Statement stmt;
			String insertData;

			stmt = DatabaseManager.getSingleton().getConnection().createStatement();

			String[] table_statements = { "DROP TABLE IF EXISTS Element", "DROP TABLE IF EXISTS Compound",
					"DROP TABLE IF EXISTS Base", "DROP TABLE IF EXISTS Acid", "DROP TABLE IF EXISTS Metal",
					"DROP TABLE IF EXISTS CompoundMadeOfElement" };

			for (int i = table_statements.length - 1; i >= 0; i--) {
				insertData = new String(table_statements[i]);
				stmt.executeUpdate(insertData);
			}
	
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
	}

	/**
	 * Adds some rows to all tables in the database.
	 */
	public static void addTestRows() {
		
		try {
			stmt = DatabaseManager.getSingleton().getConnection().createStatement();

			String[] table_statements = { "INSERT INTO Acid VALUES (1, 'acid1', 4)",
										"INSERT INTO Acid VALUES (2, 'acid2', 5)", 
										"INSERT INTO Acid VALUES (3, 'acid3', 5)",
										"INSERT INTO Base VALUES (9, 'base1', 5)",
										"INSERT INTO Base VALUES (10, 'base2', 6)",
										"INSERT INTO Base VALUES (11, 'base3', 7)",
										"INSERT INTO Base VALUES (12, 'base4', 810)",
										"INSERT INTO Element VALUES (4, 'element1', 12, 50.01)",
										"INSERT INTO Element VALUES (5, 'element2', 40, 20.0)",
										"INSERT INTO Element VALUES (6, 'element3', 55, 20.2)",
										"INSERT INTO Element VALUES (7, 'element4', 30, 40.0)",
										"INSERT INTO Element VALUES (8, 'element5', 44, 100.1)",
										"INSERT INTO Compound VALUES (0, 'Sugar Water')",
										"INSERT INTO Compound VALUES (1, 'Carodine')",
										"INSERT INTO Compound VALUES (2, 'Spicy Water')",
										"INSERT INTO Metal VALUES (20, 'metal1', 21, 21.0, 5)",
										"INSERT INTO Metal VALUES (21, 'metal2', 22, 22.0, 6)",
										"INSERT INTO Metal VALUES (22, 'metal3', 23, 23.0, 7)",
										"INSERT INTO Metal VALUES (23, 'metal4', 24, 24.0, 8)",
										"INSERT INTO CompoundMadeOfElement VALUES (0, 4)",
										"INSERT INTO CompoundMadeOfElement VALUES (0, 5)",
										"INSERT INTO CompoundMadeOfElement VALUES (2, 4)",
										"INSERT INTO CompoundMadeOfElement VALUES (2, 8)" };

			for (int i = 0; i < table_statements.length; i++) {
				insertData = new String(table_statements[i]);
				stmt.executeUpdate(insertData);
			}
	
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
	}
}