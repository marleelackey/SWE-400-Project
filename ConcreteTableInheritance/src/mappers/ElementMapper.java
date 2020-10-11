package mappers;

import Interfaces.ElementMapperInterface;
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
			ElementRDG rdg = new ElementRDG(ident, atomicNumber, atomicMass, name, moles);
			rdg.insert();
		} catch (Exception e) {
			DatabaseException.detectError(e, "Error spotted in the ElementMapper class, CreateElementMethod");
		}
	}

}
