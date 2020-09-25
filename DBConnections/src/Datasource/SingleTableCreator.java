package Datasource;

import java.sql.SQLException;
import java.sql.Statement;

public class SingleTableCreator {
	
	static Statement stmt;
    static String insertData; 
    
    
	public static void createTables() throws SQLException, DatabaseException {
		stmt = DatabaseManager.getSingleton().getConnection().createStatement();

	    String[] table_statements =
            {"CREATE TABLE IF NOT EXISTS Chemical (chemicalID int NOT NULL, chemicalType int NOT NULL, chemicalName VARCHAR(32) NOT NULL, chemicalAtomicNumber int, chemicalAtomicMass double, chemicalDissolvedBy int, chemicalAcidSolute int, chemicalBaseSolute int, PRIMARY KEY (chemicalID))",
             "CREATE TABLE IF NOT EXISTS CompoundMadeOfElement (compoundID int, elementID int)"
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
		            {"DROP TABLE IF EXISTS Chemical",
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
            {"INSERT INTO Chemical VALUES ('name1', 1, 0, null, 100, null, null, null)",
             "INSERT INTO Chemical VALUES ('name2', 2, 0, null, 20.11, null, null, null)",  
             "INSERT INTO Chemical VALUES ('name3', 3, 0, null, 30, null, null, null)",  
             "INSERT INTO Chemical VALUES ('name4', 4, 1, null, 55.9, null, null, null)",            		
             "INSERT INTO Chemical VALUES ('name5', 5, 1, null, 300, null, null, null)",            		
             "INSERT INTO Chemical VALUES ('name6', 6, 1, null, 98.7, null, null, null)",            		
             "INSERT INTO Chemical VALUES ('name7', 7, 2, null, 5, null, null, null)",            		
             "INSERT INTO Chemical VALUES ('name8', 8, 2, null, 9, null, null, null)",            		
             "INSERT INTO Chemical VALUES ('name9', 9, 2, null, 13.3, null, null, null)",            		
             "INSERT INTO Chemical VALUES ('name10', 10, 3, null, 44, null, null, null)",  
             "INSERT INTO Chemical VALUES ('name11', 11, 3, null, 130, null, null, null)",            		
             "INSERT INTO Chemical VALUES ('name12', 12, 3, null, 30.8, null, null, null)",   
             "INSERT INTO Chemical VALUES ('name13', 13, 4, null, 320, null, null, null)",  
             "INSERT INTO Chemical VALUES ('name14', 14, 4, null, 55.23, null, null, null)",            		
             "INSERT INTO Chemical VALUES ('name15', 15, 4, null, 8, null, null, null)",   


            };

	    for (int i = 0; i < table_statements.length; i++) {
	      insertData = new String(table_statements[i]);
	      stmt.executeUpdate(insertData);
	    }
		
			
	}

}
