package mappers;

import DomainObjects.ElementDomainObject;
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
	public ElementDomainObject createElement() throws Exception {
		if (identityMap.containsKey(this.ident)) {
			return identityMap.get(this.ident);
		}
		ElementDomainObject element = new ElementDomainObject(this);
		identityMap.put(this.ident, element);
		return element;
	}


	/**
	 * @return the type
	 */
	public static int getType() {
		return type;
	}


	/**
	 * @return the ident
	 */
	public int getIdent() {
		return ident;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the atomicNumber
	 */
	public int getAtomicNumber() {
		return atomicNumber;
	}


	/**
	 * @return the atomicMass
	 */
	public double getAtomicMass() {
		return atomicMass;
	}


	/**
	 * @return the moles
	 */
	public double getMoles() {
		return moles;
	}


	@Override
	public void persist() {
		ChemicalRDG tom = new ChemicalRDG(ident, type , name, atomicNumber, atomicMass, moles);
		tom.insert();
	}

}
