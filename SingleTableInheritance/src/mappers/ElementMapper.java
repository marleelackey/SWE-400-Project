package mappers;

import java.util.ArrayList;

import domainObjects.ElementDomainObject;
import Interfaces.ElementMapperInterface;
import datasource.ChemicalDTO;
import datasource.ChemicalRDG;
import datasource.ChemicalTDG;
import datasource.DatabaseException;

public class ElementMapper implements ElementMapperInterface {
	private static final int type = 3;
	private int ident;
	private String name;
	private int atomicNumber;
	private double atomicMass;
	private double moles;
	private ElementDomainObject edo;

//	public ElementMapper(int ID, String elementName, int atomicNumber, double atomicMass, double moles) {
//		ident = ID;
//		this.name = elementName;
//		this.atomicNumber = atomicNumber;
//		this.atomicMass = atomicMass;
//		this.moles = moles;
//	}

	@Override
	public ElementDomainObject createElement(int ID, String elementName, int atomicNumber, double atomicMass,
			double moles) throws Exception {
		ident = ID;
		this.name = elementName;
		this.atomicNumber = atomicNumber;
		this.atomicMass = atomicMass;
		this.moles = moles;
		this.edo = new ElementDomainObject(this);

		return this.edo;
//		return new ElementDomainObject(this);
	}

	@Override
	public ElementDomainObject findByID(int id) throws Exception {
		ChemicalRDG rdg = ChemicalRDG.findByIDSingle(id);
		return createElement(rdg.getID(), rdg.getName(), rdg.getAtomicNumber(), rdg.getAtomicMass(), rdg.getMoles());
	}

	@Override
	public ElementDomainObject findByName(String name) throws Exception {
		ChemicalRDG rdg = ChemicalRDG.findByName(name);
		return createElement(rdg.getID(), rdg.getName(), rdg.getAtomicNumber(), rdg.getAtomicMass(), rdg.getMoles());
	}

	@Override
	public ElementDomainObject findByAtomicNumber(int aNum) throws Exception {
		ChemicalRDG element = ChemicalRDG.findByAtomicNumber(aNum);
		return createElement(element.getID(), element.getName(), element.getAtomicNumber(), element.getAtomicMass(),
				element.getMoles());
	}

	@Override
	public ElementDomainObject findByAtomicMass(double aMass) throws Exception {
		ChemicalRDG element = ChemicalRDG.findByAtomicMass(aMass);
		return createElement(element.getID(), element.getName(), element.getAtomicNumber(), element.getAtomicMass(),
				element.getMoles());
	}

	@Override
	public ArrayList<ElementDomainObject> findElementsInRange(double highRange, double lowRange) throws Exception {
		ChemicalTDG et = ChemicalTDG.getSingleton();
		ArrayList<ChemicalDTO> edto = et.getElementsInRange(lowRange, highRange);
		ArrayList<ElementDomainObject> edo = new ArrayList<ElementDomainObject>();
		for (ChemicalDTO e : edto) {
			edo.add(createElement(e.getChemicalID(), e.getChemicalName(), e.getChemicalAtomicNumber(),
					e.getChemicalAtomicMass(), e.getChemicalMoles()));
		}
		return edo;
	}

	@Override
	public ArrayList<ElementDomainObject> getAllElements() throws Exception {
		ArrayList<ChemicalDTO> elements = ChemicalTDG.getSingleton().getElementsInRange(0, 999999);
		ArrayList<ElementDomainObject> list = new ArrayList<ElementDomainObject>();
		for (ChemicalDTO e : elements) {
			list.add(createElement(e.getChemicalID(), e.getChemicalName(), e.getChemicalAtomicNumber(),
					e.getChemicalAtomicMass(), e.getChemicalMoles()));
		}
		return list;
	}

	@Override
	public void persist() {
		try {
			ChemicalRDG element = ChemicalRDG.findByIDSingle(ident);
			if (element == null) {
				ChemicalRDG rdg = new ChemicalRDG(ident, type, name, atomicNumber, atomicMass, moles);
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
}
