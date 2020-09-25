package Classes;

import java.sql.SQLException;

import Datasource.ConcreteTableCreator;
import Datasource.DatabaseException;
import Datasource.DatabaseManager;

public class Runnable {

	public static void main(String[] args) throws DatabaseException, SQLException {
		DatabaseManager.setPatternNumber(2);
        DatabaseManager.getSingleton().openConnection();
        ConcreteTableCreator.dropAllTables();

        ConcreteTableCreator.createTables();
        ConcreteTableCreator.addTestRows();
        
        DatabaseManager.getSingleton().closeConnection();

	}

}