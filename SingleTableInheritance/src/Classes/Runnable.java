package Classes;

import java.sql.SQLException;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;
import Datasource.SingleTableCreator;
import Tests.TestEVERYTHING;

/**
 * Single Table Inheritance Runner
 * @author Joshua
 *
 */
public class Runnable {

	public static void main(String[] args) throws DatabaseException, SQLException {
		DatabaseManager.setPatternNumber(1);
		DatabaseManager.getSingleton().openConnection();

		SingleTableCreator.dropAllTables();
		SingleTableCreator.createTables();
		SingleTableCreator.addTestRows();

		try {
			TestEVERYTHING.testRunAllTheTests();
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}

		System.out.println("ya done diddly did it");

		DatabaseManager.getSingleton().closeConnection();
	}

}