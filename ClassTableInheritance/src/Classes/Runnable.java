package Classes;

import java.sql.SQLException;

import Datasource.ClassTableCreator;
import Datasource.DatabaseException;
import Datasource.DatabaseManager;
import Tests.TestEVERYTHING;

/**
 * Class Table Inheritance Runner
 * @author Joshua & Madeline
 *
 */
public class Runnable {

	public static void main(String[] args) throws DatabaseException, SQLException {
		DatabaseManager.setPatternNumber(3);
        DatabaseManager.getSingleton().openConnection();
        ClassTableCreator.dropAllTables();
        ClassTableCreator.createTables();
        ClassTableCreator.addTestRows();
        
        TestEVERYTHING.testRunAllTheTests();
                
        System.out.println("tis a fine day, my good sir");
        
        DatabaseManager.getSingleton().closeConnection();
	}

}