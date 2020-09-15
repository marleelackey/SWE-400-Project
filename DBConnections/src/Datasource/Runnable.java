package Datasource;

import java.sql.SQLException;

public class Runnable {

	  public static void main(String[] args) throws SQLException, DatabaseException {
	        DatabaseManager.getSingleton().openConnection();
	        
	        TableCreator.createTables();

	        DatabaseManager.getSingleton().closeConnection();
	    }
	
}
