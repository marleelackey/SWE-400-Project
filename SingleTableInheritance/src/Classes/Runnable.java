package Classes;

import java.sql.SQLException;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;
import Datasource.SingleTableCreator;

public class Runnable {

	public static void main(String[] args) throws DatabaseException, SQLException {
		DatabaseManager.setPatternNumber(1);
        DatabaseManager.getSingleton().openConnection();
//        SingleTableCreator.dropAllTables();

        SingleTableCreator.createTables();
//        SingleTableCreator.addTestRows();

        
        
        DatabaseManager.getSingleton().closeConnection();


	}

}
