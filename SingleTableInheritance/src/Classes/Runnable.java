package Classes;

import java.sql.SQLException;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;
import Datasource.TableCreator;

public class Runnable {

	public static void main(String[] args) throws DatabaseException, SQLException {
		DatabaseManager.setPatternNumber(1);
        DatabaseManager.getSingleton().openConnection();
        TableCreator.dropAllTables();

        TableCreator.createTables();
        
        
        DatabaseManager.getSingleton().closeConnection();


	}

}
