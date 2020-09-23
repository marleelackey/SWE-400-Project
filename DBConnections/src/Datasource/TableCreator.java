package Datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {
	static Statement stmt;
    static String insertData;
    
	  public static void createTables() throws SQLException, DatabaseException {



		    stmt = DatabaseManager.getSingleton().getConnection().createStatement();

		    if (DatabaseManager.getPatternNumber() == 1) {
		    	createSingleTableTables();
		    	
		    } else if (DatabaseManager.getPatternNumber() == 2) {
//		    	createConcreteTableTables();

		    }

	  }
	  
	  
	  private static void createSingleTableTables() throws SQLException {
		    String[] table_statements =
	            {"CREATE TABLE IF NOT EXISTS CHEMICAL (name VARCHAR(32) NOT NULL, id long NOT NULL, type int NOT NULL, atomicNumber int, atomicMass double, baseSolute long, acidSolute long, dissolvedBy long)",
	             "CREATE TABLE IF NOT EXISTS CompoundMadeOfElement (compoundID long, elementID long)"
	            };

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

		    String[] table_statements =
		            {"DROP TABLE IF EXISTS CHEMICAL",
		             "DROP TABLE IF EXISTS CompoundMadeOfElement"
		            };

		    for (int i = table_statements.length - 1; i >= 0; i--) {
		      insertData = new String(table_statements[i]);
		      stmt.executeUpdate(insertData);
		    }

		  }

}
