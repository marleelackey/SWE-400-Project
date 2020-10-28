package mappers;

import java.util.ArrayList;

import Interfaces.ElementMapperInterface;
import datasource.DatabaseException;
import datasource.ElementDTO;
import datasource.ElementRDG;
import datasource.ElementTDG;
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
		ElementRDG element = ElementRDG.findByID(id);
		return createElement(element.getID(), element.getName(), element.getAtomicNumber(), element.getAtomicMass(),
				element.getMoles());
	}

	public ElementDomainObject findByName(String name) throws Exception {
		ElementRDG element = ElementRDG.findByName(name);
		return createElement(element.getID(), element.getName(), element.getAtomicNumber(), element.getAtomicMass(),
				element.getMoles());
	}

	public ElementDomainObject findByAtomicNumber(int aNum) throws Exception {
		ElementRDG element = ElementRDG.findByAtomicNumber(aNum);
		return createElement(element.getID(), element.getName(), element.getAtomicNumber(), element.getAtomicMass(),
				element.getMoles());
	}

	public ElementDomainObject findByAtomicMass(double aMass) throws Exception {
		ElementRDG element = ElementRDG.findByAtomicMass(aMass);
		return createElement(element.getID(), element.getName(), element.getAtomicNumber(), element.getAtomicMass(),
				element.getMoles());
	}

	public ArrayList<ElementDomainObject> findElementsInRange(double highRange, double lowRange) throws Exception {
		ElementTDG et = ElementTDG.getInstance();
		ArrayList<ElementDTO> edto = et.getElementsInRange(lowRange, highRange);
		ArrayList<ElementDomainObject> edo = new ArrayList<ElementDomainObject>();
		for (ElementDTO e : edto) {
			edo.add(createElement(e.getID(), e.getName(), e.getAtomicNumber(), e.getAtomicMass(), e.getMoles()));
		}
		return edo;
	}
	
	public ArrayList<ElementDomainObject> getAllElements() throws Exception {
		ArrayList<ElementDTO> elements = ElementTDG.getInstance().getAllElements();
		ArrayList<ElementDomainObject> list = new ArrayList<>();
		for (ElementDTO e : elements) {
			list.add(createElement(e.getID(), e.getName(), e.getAtomicNumber(), e.getAtomicMass(), e.getMoles()));
		}
		return list;
	}

	public void persist() {
		try {
			ElementRDG element = ElementRDG.findByID(ident);
			if (element == null) {
				ElementRDG rdg = new ElementRDG(ident, atomicNumber, atomicMass, name, moles);
				rdg.insert();
			} else {
				element.setAtomicMass(atomicMass);
				element.setAtomicNumber(atomicNumber);
				element.setMoles(moles);
				element.setName(name);
				element.update();
			}
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