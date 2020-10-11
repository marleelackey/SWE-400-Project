package Mappers;

import Interfaces.ElementMapperInterface;
import datasource.ChemicalRDG;
import datasource.DatabaseException;

public class ElementMapper implements ElementMapperInterface {
	private static final int type = 3;
	private int ident;
	private String name;
	private int atomicNumber;
	private double atomicMass;	

 
	public ElementMapper(int ID, String elementName, int atomicNumber, double atomicMass) {
		ident = ID;
		this.name = elementName;
		this.atomicNumber = atomicNumber;
		this.atomicMass = atomicMass;
	}
	

	@Override
	public void createElement() {
		try {
			ChemicalRDG tom = new ChemicalRDG(ident, type , name, atomicNumber, atomicMass);
			tom.insert();
		} catch (DatabaseException e) {
			DatabaseException.detectError(e, "Error spotted in the ElementMapper class, CreateElementMethod");
		}
		//	public void CreateElement(int ident, int atomicNumber, double atomicMass, String name) {
	}

}
