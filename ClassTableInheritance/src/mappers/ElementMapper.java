package mappers;

import Interfaces.ElementMapperInterface;
import datasource.ChemicalRDG;
import datasource.DatabaseException;
import datasource.ElementRDG;
import domainObjects.ChemicalDomainObject;
import domainObjects.ElementDomainObject;

public class ElementMapper implements ElementMapperInterface {

	private int ident;
	private String name;
	private int atomicNumber;
	private double atomicMass;
	private double moles;
	private ElementDomainObject edo;

	public ElementDomainObject createElement(int ID, String elementName, int atomicNumber, double atomicMass,
			double moles) throws Exception {
		ident = ID;
		this.name = elementName;
		this.atomicNumber = atomicNumber;
		this.atomicMass = atomicMass;
		this.moles = moles;
		return new ElementDomainObject(this);
	}

	public ElementDomainObject findByID(int id) throws Exception {
		ChemicalRDG c_element = ChemicalRDG.findByID(id);
		ElementRDG element = ElementRDG.findByID(id);
		return createElement(c_element.getChemicalID(), c_element.getChemicalName(), element.getAtomicNumber(),
				element.getAtomicMass(), c_element.getChemicalMoles());
	}

	public ElementDomainObject findByName(String name) throws Exception {
		ChemicalRDG c_element = ChemicalRDG.findByName(name);
		ElementRDG element = ElementRDG.findByID(c_element.getChemicalID());
		return createElement(c_element.getChemicalID(), c_element.getChemicalName(), element.getAtomicNumber(),
				element.getAtomicMass(), c_element.getChemicalMoles());
	}

	public ElementDomainObject findByAtomicNumber(int aNum) throws Exception {
		ElementRDG element = ElementRDG.findByAtomicNumber(aNum);
		ChemicalRDG c_element = ChemicalRDG.findByID(element.getID());
		return createElement(element.getID(), c_element.getChemicalName(), element.getAtomicNumber(),
				element.getAtomicMass(), c_element.getChemicalMoles());
	}

	public ElementDomainObject findByAtomicMass(int aMass) throws Exception {
		ElementRDG element = ElementRDG.findByAtomicMass(aMass);
		ChemicalRDG c_element = ChemicalRDG.findByID(element.getID());
		return createElement(element.getID(), c_element.getChemicalName(), element.getAtomicNumber(),
				element.getAtomicMass(), c_element.getChemicalMoles());
	}

	public void persist() {
		try {
			ChemicalRDG element = ChemicalRDG.findByID(ident);
			if (element.equals(null)) {
				ElementRDG rdg = new ElementRDG(ident, atomicNumber, atomicMass);
				rdg.insert();
			} else {
				ElementRDG e = ElementRDG.findByID(ident);
				e.setAtomicMass(atomicMass);
				e.setAtomicNumber(atomicNumber);
				e.update();
			}
			ChemicalMapper cm = new ChemicalMapper();
			ChemicalDomainObject cdo = cm.createChemical(ident, name, moles);
			cdo.persist();
		} catch (Exception e) {
			DatabaseException.detectError(e, "Error spotted in the ElementMapper class, Persist method");
		}
	}

	public int getIdent() {
		return ident;
	}

	public String getName() {
		return name;
	}

	public int getAtomicNumber() {
		return atomicNumber;
	}

	public double getAtomicMass() {
		return atomicMass;
	}

	public double getMoles() {
		return moles;
	}

	public void setIdent(int ident) {
		this.ident = ident;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}

	public void setAtomicMass(double atomicMass) {
		this.atomicMass = atomicMass;
	}

	public void setMoles(double moles) {
		this.moles = moles;
	}

	public void setElement(ElementDomainObject elementDomainObject) {
		edo = elementDomainObject;
	}

	public ElementDomainObject getElement() {
		return edo;
	}

}