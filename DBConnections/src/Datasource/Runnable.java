package Datasource;

public class Runnable {

	  public static void main(String[] args) {
		  try {
	        DatabaseManager.getSingleton().openConnection();
	        
	        TableCreator.createTables();

	        DatabaseManager.getSingleton().closeConnection();
		  } catch (Exception e) {
			  DatabaseException.detectError(e);
		  }
	    }
	
}