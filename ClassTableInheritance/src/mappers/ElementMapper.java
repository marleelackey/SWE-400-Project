package mappers;

import Interfaces.ElementMapperInterface;
import datasource.ChemicalRDG;
import datasource.DatabaseException;
import datasource.ElementRDG;

public class ElementMapper implements ElementMapperInterface {
	
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
		
		try {
			ChemicalRDG rdg1 = new ChemicalRDG(ident, name, moles);
			rdg1.insert();
			
			ElementRDG rdg2 = new ElementRDG(ident, atomicNumber, atomicMass);
			rdg2.insert();
			
		} catch (Exception e) {
			DatabaseException.detectError(e, "Error spotted in the ElementMapper class, CreateElementMethod");
		}
	}

}