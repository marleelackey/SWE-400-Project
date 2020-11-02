package gui;

import datasource.ConcreteTableCreator;
import datasource.DatabaseException;
import datasource.DatabaseManager;

public class Runnable {
	public static void main(String[] args) throws DatabaseException {
		DatabaseManager.getSingleton().closeConnection();
		DatabaseManager.setPatternNumber(2);
		DatabaseManager.getSingleton().openConnection();
		
		ConcreteTableCreator.dropAllTables();
		ConcreteTableCreator.createTables();
		ConcreteTableCreator.addTestRows();
		
		System.out.println("Hullabaloo");
		new MasterGUI();
	}
}