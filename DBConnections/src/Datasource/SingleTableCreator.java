package Datasource;

import java.sql.SQLException;
import java.sql.Statement;

public class SingleTableCreator {

	static Statement stmt;
	static String insertData;

	public static void createTables() throws SQLException, DatabaseException {
		stmt = DatabaseManager.getSingleton().getConnection().createStatement();

		String[] table_statements = {
				"CREATE TABLE IF NOT EXISTS Chemical (chemicalID int NOT NULL, chemicalType int NOT NULL, chemicalName VARCHAR(32) NOT NULL, chemicalAtomicNumber int, chemicalAtomicMass double, chemicalDissolvedBy int, chemicalAcidSolute int, chemicalBaseSolute int, PRIMARY KEY (chemicalID))",
				"CREATE TABLE IF NOT EXISTS CompoundMadeOfElement (compoundID int, elementID int)" };

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

		String[] table_statements = { "DROP TABLE IF EXISTS Chemical", "DROP TABLE IF EXISTS CompoundMadeOfElement" };

		for (int i = table_statements.length - 1; i >= 0; i--) {
			insertData = new String(table_statements[i]);
			stmt.executeUpdate(insertData);
		}

	}

	public static void addTestRows() throws SQLException, DatabaseException {
		stmt = DatabaseManager.getSingleton().getConnection().createStatement();

		String[] table_statements = { "INSERT INTO Chemical VALUES (1, 0, 'name1', null, 20.7, null, null, null)",
				"INSERT INTO Chemical VALUES (2, 0, 'name1', null, 20.8, null, null, null)",
				"INSERT INTO Chemical VALUES (3, 0, 'name2', 5, 20.9, 5, 5,6)",
				"INSERT INTO Chemical VALUES (4, 1, 'name3', null, 21.7, null, null, null)",
				"INSERT INTO Chemical VALUES (5, 1, 'name4', null, 23.7, null, null, null)",
				"INSERT INTO Chemical VALUES (6, 1, 'name5', null, 25.0, null, null, null)",
				"INSERT INTO Chemical VALUES (7, 2, 'name6', null, 26.2, null, null, null)",
				"INSERT INTO Chemical VALUES (8, 2, 'name7', null, 21.6, null, null, null)",
				"INSERT INTO Chemical VALUES (9, 2, 'name8', 51, 20.7, 52, 53, null)",
				"INSERT INTO Chemical VALUES (10, 3, 'name9', null, 20.7, null, null, null)",
				"INSERT INTO Chemical VALUES (11, 3, 'name10', null, 29.5, null, null, null)",
				"INSERT INTO Chemical VALUES (12, 4, 'name11', null, 26.7, null, null, null)",
				"INSERT INTO Chemical VALUES (13, 4, 'name12', null, 27.7, null, null, null)",
				"INSERT INTO Chemical VALUES (14, 4, 'name13', null, 26.7, null, null, null)",
				"INSERT INTO Chemical VALUES (15, 5, 'name14', null, 27.7, null, null, null)",
				"INSERT INTO Chemical VALUES (16, 5, 'name15', null, 1230.7, null, null, null)" };

		for (int i = 0; i < table_statements.length; i++) {
			insertData = new String(table_statements[i]);
			stmt.executeUpdate(insertData);
		}

	}

}