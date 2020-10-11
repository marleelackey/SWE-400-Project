package mappers;

import Interfaces.ElementMapperInterface;
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
 
	public MetalMapper(int ID, String elementName, int atomicNumber, double atomicMass, int dissolvedBy) {
		ident = ID;
		this.name = elementName;
		this.atomicNumber = atomicNumber;
		this.atomicMass = atomicMass;
		this.dissolvedBy = dissolvedBy;
	}
	
	
	@Override
	public void createMetal() {
		
		try {
			ChemicalRDG rdg1 = new ChemicalRDG(ident, name);
			rdg1.insert();
			
			ElementRDG rdg2 = new ElementRDG(ident, atomicNumber, atomicMass);
			rdg2.insert();
			
			MetalRDG rdg3 = new MetalRDG(ident, dissolvedBy);
			rdg3.insert();
			
		} catch (Exception e) {
			DatabaseException.detectError(e, "Error spotted in the MetalMapper class, CreateMetalMethod");
		}
	}

}