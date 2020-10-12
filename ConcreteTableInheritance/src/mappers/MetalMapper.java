package mappers;

import Interfaces.MetalMapperInterface;
import datasource.DatabaseException;
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
			MetalRDG rdg = new MetalRDG(ident, atomicNumber, dissolvedBy, atomicMass, name, moles, molesOfAcidToDissolve);
			rdg.insert();
		} catch (Exception e) {
			DatabaseException.detectError(e, "Error spotted in the MetalMapper class, CreateMetal method");
		}
	}

}
