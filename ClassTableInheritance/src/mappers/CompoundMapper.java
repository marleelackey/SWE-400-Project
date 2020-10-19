package mappers;

import java.util.ArrayList;

import Interfaces.CompoundMapperInterface;
import datasource.ChemicalRDG;
import datasource.CompoundMadeOfElementRDG;
import datasource.CompoundRDG;
import datasource.DatabaseException;
import datasource.ElementDTO;
import datasource.ElementRDG;
import datasource.ElementTDG;
import domainObjects.ChemicalDomainObject;
import domainObjects.ElementDomainObject;
import quantifiedElementPackage.QuantifiedElement;

public class CompoundMapper implements CompoundMapperInterface {

	private int compoundID;
	private String compoundName;
	private double moles;
	private ArrayList<QuantifiedElement> myElements;
	private CompoundDomainObject cdo;

	@Override
	public CompoundDomainObject findByID(int cID) {
		CompoundRDG rdg = CompoundRDG.findByIDClass(cID);
		ChemicalRDG chem = ChemicalRDG.findByID(cID);

		ArrayList<QuantifiedElement> element_list;
		ArrayList<ElementDTO> list = ElementTDG.getInstance().getElementsInCompound(cID);

		for (ElementDTO e : list) {
			ChemicalMapper cm = new ChemicalMapper();
			ChemicalDomainObject cdo = cm.findByID(e.getID());
			
			ElementMapper em = new ElementMapper();
			ElementDomainObject edo = em.createElement(e.getID(), cdo.getChemicalName(), e.getAtomicNumber(), e.getAtomicMass(),
					cdo.getChemicalMoles());

			int q = ElementRDG.findQuantityInCompound(e.getID(), cID);

			element_list.add(new QuantifiedElement(edo, q));
		}

		compoundID = cID;
		compoundName = chem.getChemicalName();
		moles = chem.getChemicalMoles();
		myElements = element_list;

		return new CompoundDomainObject(this);
	}

	@Override
	public void persist() {
		try {			
			// persist the compound's chemical variables			
			ChemicalMapper cm = new ChemicalMapper();
			ChemicalDomainObject cdo = cm.createChemical(compoundID, compoundName, moles);
			cdo.persist();

			// persist the relationships to its elements
			compareElementsAndPersist();
		} catch (Exception e) {
			DatabaseException.detectError(e, "Error spotted in the CompoundMapper class, persist method");
		}
	}	

	private void compareElementsAndPersist() {
		// see if a relationship has been deleted from cdo
		for (QuantifiedElement e : myElements) {
			if (!cdo.getElements().contains(e)) {
				myElements.remove(e);
				CompoundMadeOfElementRDG r = new CompoundMadeOfElementRDG(compoundID, e.getElement().getElementID(), e.getQuantityInCompound());
				r.delete();
			}
		}
		// see if a relationship has been inserted into cdo
		for (QuantifiedElement e : cdo.getElements()) {
			if (!myElements.contains(e)) {
				myElements.add(e);
				CompoundMadeOfElementRDG r = new CompoundMadeOfElementRDG(compoundID, e.getElement().getElementID(), e.getQuantityInCompound());
				r.insert();
			}
		}
		// see if a relationship has been modified in cdo
		for (QuantifiedElement e : myElements) {
			int currentQ = e.getQuantityInCompound();
			int domainQ = 0;

			for (QuantifiedElement de : cdo.getElements()) {
				if (de.getElement().getElementID() == e.getElement().getElementID()) {
					domainQ = de.getQuantityInCompound();
				}
			}

			if (currentQ != domainQ && domainQ != 0) {
				e.setQuantityInCompound(domainQ);
				CompoundMadeOfElementRDG r = new CompoundMadeOfElementRDG(compoundID, e.getElement().getElementID(), e.getQuantityInCompound());
				r.update();
			}
		}

	}
	
	public int getCompoundID() {
		return compoundID;
	}

	public String getCompoundName() {
		return compoundName;
	}

	public double getMoles() {
		return moles;
	}

	public ArrayList<QuantifiedElement> getMyElements() {
		return myElements;
	}

	public void setCompoundID(int compoundID) {
		this.compoundID = compoundID;
	}

	public void setCompoundName(String compoundName) {
		this.compoundName = compoundName;
	}

	public void setMoles(double moles) {
		this.moles = moles;
	}

	public void setMyElements(ArrayList<QuantifiedElement> myElements) {
		this.myElements = myElements;
	}

}