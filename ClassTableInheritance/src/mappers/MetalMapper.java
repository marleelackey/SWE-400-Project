package mappers;

import Interfaces.MetalMapperInterface;
import datasource.ChemicalRDG;
import datasource.DatabaseException;
import datasource.ElementRDG;
import datasource.MetalRDG;

public class MetalMapper implements MetalMapperInterface {
	
	private int ident;
	private String name;
	private int atomicNumber;
	private double atomicMass;
	private int dissolvedBy;
	private double moles;
	private double molesOfAcidToDissolve;

 
	public MetalMapper(int ID, String elementName, int atomicNumber, double atomicMass, int dissolvedBy, double moles, double molesOfAcidToDissolve) {
		ident = ID;
		this.name = elementName;
		this.atomicNumber = atomicNumber;
		this.atomicMass = atomicMass;
		this.dissolvedBy = dissolvedBy;
		this.moles = moles;
		this.molesOfAcidToDissolve = molesOfAcidToDissolve;
	}
	
	
	@Override
	public void createMetal() {
		
		try {
			ChemicalRDG rdg1 = new ChemicalRDG(ident, name, moles);
			rdg1.insert();
			
			ElementRDG rdg2 = new ElementRDG(ident, atomicNumber, atomicMass);
			rdg2.insert();
			
			MetalRDG rdg3 = new MetalRDG(ident, dissolvedBy, molesOfAcidToDissolve);
			rdg3.insert();
			
		} catch (Exception e) {
			DatabaseException.detectError(e, "Error spotted in the MetalMapper class, CreateMetalMethod");
		}
	}

}