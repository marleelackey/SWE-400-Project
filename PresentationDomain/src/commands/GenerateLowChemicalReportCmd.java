package commands;

import domainObjects.ChemicalDomainObject;

/**
 * Will print a report when the amount of chemicals left is 
 * too low
 * @author Dan Holmgren
 *
 */
public class GenerateLowChemicalReportCmd implements CommandInterface{
	private int chemID;
	private double chemMoles;
	
	@Override
	public void execute(){
		ChemicalMapper cm = new ChemicalMapper();
		ChemicalDomainObject cdo;
		cdo.getChemicalMoles();
		
	}
	
	/**
	 * Constructor for the command
	 * @param ID - The Chemical ID
	 * @param moles - The Amount of Moles of the chemical in storage
	 */
	public GenerateLowChemicalReportCmd(int ID, double moles) {
		chemID = ID;
		chemMoles = moles;
	}
	
	public int getChemID() {
		return chemID;
	}
	
	public double getChemMoles() {
		return chemMoles;
	}
}
