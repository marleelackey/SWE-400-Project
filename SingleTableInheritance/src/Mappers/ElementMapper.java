package Mappers;

import Interfaces.ElementMapperInterface;
import datasource.ChemicalRDG;

public class ElementMapper implements ElementMapperInterface {
	private static final int type = 3;
	private int ident;
	private String name;
	private int atomicNumber;
	private double atomicMass;	
	private double moles;

 
	public ElementMapper(int ID, String elementName, int atomicNumber, double atomicMass, double moles) {
		ident = ID;
		this.name = elementName;
		this.atomicNumber = atomicNumber;
		this.atomicMass = atomicMass;
		this.moles = moles;
	}
	

	@Override
	public void createElement() {
		ChemicalRDG tom = new ChemicalRDG(ident, type , name, atomicNumber, atomicMass, moles);
		tom.insert();
	}

}
