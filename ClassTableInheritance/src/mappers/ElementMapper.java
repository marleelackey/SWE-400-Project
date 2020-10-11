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
 
	public ElementMapper(int ID, String elementName, int atomicNumber, double atomicMass) {
		ident = ID;
		this.name = elementName;
		this.atomicNumber = atomicNumber;
		this.atomicMass = atomicMass;
	}
	
	
	@Override
	public void createElement() {
		
		try {
			ChemicalRDG rdg1 = new ChemicalRDG(ident, name);
			rdg1.insert();
			
			ElementRDG rdg2 = new ElementRDG(ident, atomicNumber, atomicMass);
			rdg2.insert();
			
		} catch (Exception e) {
			DatabaseException.detectError(e, "Error spotted in the ElementMapper class, CreateElementMethod");
		}
	}

}
