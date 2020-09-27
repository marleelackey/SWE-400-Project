package Classes;

import java.sql.SQLException;

import Datasource.ConcreteTableCreator;
import Datasource.DatabaseException;
import Datasource.DatabaseManager;
import Tests.TestAcidRDG;
import Tests.TestEVERYTHING;

/**
 * Concrete Table Inheritance Runner
 * @author Joshua
 *
 */
public class Runnable {

	public static void main(String[] args) throws DatabaseException, SQLException {
		DatabaseManager.setPatternNumber(2);
        DatabaseManager.getSingleton().openConnection();
        ConcreteTableCreator.dropAllTables();
        ConcreteTableCreator.createTables();
        ConcreteTableCreator.addTestRows();
        
        TestEVERYTHING.testRunAllTheTests();
                
        System.out.println("yee yee brethren");
        
        DatabaseManager.getSingleton().closeConnection();
	}

}