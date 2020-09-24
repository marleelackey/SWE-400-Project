package Datasource;

import java.sql.SQLException;
import java.sql.Statement;

public class SingleTableCreator {
	
	static Statement stmt;
    static String insertData; 
    
    
	public static void createTables() throws SQLException, DatabaseException {
		stmt = DatabaseManager.getSingleton().getConnection().createStatement();

	    String[] table_statements =
            {"CREATE TABLE IF NOT EXISTS CHEMICAL (name VARCHAR(32) NOT NULL, id int NOT NULL, type int NOT NULL, atomicNumber int, atomicMass double, baseSolute long, acidSolute long, dissolvedBy long, PRIMARY KEY (id))",
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

	public static void addTestRows() throws SQLException, DatabaseException {
		stmt = DatabaseManager.getSingleton().getConnection().createStatement();

	    String[] table_statements =
            {"INSERT INTO CHEMICAL VALUES ('name1', 1, 1, null, null, null, null, null)",
             "INSERT INTO CHEMICAL VALUES ('name2', 2, 1, null, null, null, null, null)",  
             "INSERT INTO CHEMICAL VALUES ('name3', 3, 1, null, null, null, null, null)",  
             "INSERT INTO CHEMICAL VALUES ('name4', 4, 2, null, null, null, null, null)",            		
             "INSERT INTO CHEMICAL VALUES ('name5', 5, 2, null, null, null, null, null)",            		
             "INSERT INTO CHEMICAL VALUES ('name6', 6, 2, null, null, null, null, null)",            		
             "INSERT INTO CHEMICAL VALUES ('name7', 7, 3, null, null, null, null, null)",            		
             "INSERT INTO CHEMICAL VALUES ('name8', 8, 3, null, null, null, null, null)",            		
             "INSERT INTO CHEMICAL VALUES ('name9', 9, 3, null, null, null, null, null)",            		
             "INSERT INTO CHEMICAL VALUES ('name10', 10, 4, null, null, null, null, null)",  
             "INSERT INTO CHEMICAL VALUES ('name11', 11, 4, null, null, null, null, null)",            		
             "INSERT INTO CHEMICAL VALUES ('name12', 12, 4, null, null, null, null, null)",            		


            };

	    for (int i = 0; i < table_statements.length; i++) {
	      insertData = new String(table_statements[i]);
	      stmt.executeUpdate(insertData);
	    }
		
			
	}

}
