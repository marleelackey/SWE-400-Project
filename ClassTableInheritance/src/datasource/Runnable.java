package datasource;

import java.sql.SQLException;

import Tests.TestEVERYTHING;
import datasource.ClassTableCreator;
import datasource.DatabaseException;
import datasource.DatabaseManager;

/**
 * Class Table Inheritance Runner
 * 
 * @author Joshua & Madeline
 *
 */
public class Runnable {

	/**
	 * Main method for Class Table Inheritance
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DatabaseManager.setPatternNumber(3);
			DatabaseManager.getSingleton().openConnection();
			ClassTableCreator.dropAllTables();
			ClassTableCreator.createTables();
			ClassTableCreator.addTestRows();

			TestEVERYTHING.testRunAllTheTests();

			System.out.println("tis a fine day, my good sir");

			DatabaseManager.getSingleton().closeConnection();
		} catch (Exception e) {
			DatabaseException.detectError(e, "Runnable - Class");
		}
	}

}