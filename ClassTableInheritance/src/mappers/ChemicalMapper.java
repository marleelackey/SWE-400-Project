package mappers;

import java.util.ArrayList;

import Interfaces.ChemicalMapperInterface;
import datasource.AcidDTO;
import datasource.AcidTDG;
import datasource.BaseDTO;
import datasource.BaseTDG;
import datasource.ChemicalRDG;
import datasource.CompoundDTO;
import datasource.CompoundTDG;
import datasource.ElementDTO;
import datasource.ElementRDG;
import datasource.ElementTDG;
import datasource.MetalDTO;
import datasource.MetalTDG;
import domainObjects.ChemicalDomainObject;

public class ChemicalMapper implements ChemicalMapperInterface {

	private int ID;
	private String name;
	private double moles;
	private ChemicalDomainObject cdo;

	public ChemicalDomainObject createChemical(int ID, String name, double moles) throws Exception {
		this.ID = ID;
		this.name = name;
		this.moles = moles;

		return new ChemicalDomainObject(this);
	}

	public void persist() {
		ChemicalRDG rdg = ChemicalRDG.findByID(ID);
		if (rdg.equals(null)) {
			rdg = new ChemicalRDG(ID, name, moles);
			rdg.insert();
		} else {
			rdg.setChemicalMoles(moles);
			rdg.update();
		}
	}

	public ChemicalDomainObject findByID(int chemicalID) throws Exception {
		ChemicalRDG rdg = ChemicalRDG.findByID(chemicalID);

		return createChemical(chemicalID, rdg.getChemicalName(), rdg.getChemicalMoles());
	}

	public ArrayList<ChemicalDomainObject> findLowChemicals() throws Exception {
		ArrayList<ChemicalDomainObject> lowChemicals = new ArrayList<ChemicalDomainObject>();

		// elements that have less than 20 moles
		ArrayList<ElementDTO> elements = ElementTDG.getInstance().getAllElements();
		for (ElementDTO e : elements) {
			ChemicalRDG cForElements1 = ChemicalRDG.findByID(e.getID());
			if (cForElements1.getChemicalMoles() < 20) {
				lowChemicals.add(
						createChemical(e.getID(), cForElements1.getChemicalName(), cForElements1.getChemicalMoles()));
				elements.remove(e);
			}
		}

		// elements that don't have enough to replenish all compounds that contain it
		for (ElementDTO e : elements) {
			ArrayList<CompoundDTO> compounds = CompoundTDG.getSingleton().getCompoundsByElement(e.getID());
			double totalToReplenish = 0;
			for (CompoundDTO c : compounds) {
				ArrayList<ElementDTO> allElementsInCompound = ElementTDG.getInstance()
						.getElementsInCompound(c.getCompoundID());
				int numAtoms = 0; // total number of atoms in the compound
				for (ElementDTO containedElement : allElementsInCompound) {
					numAtoms += ElementRDG.findQuantityInCompound(containedElement.getID(), c.getCompoundID());
				}
				int thisElement = ElementRDG.findQuantityInCompound(e.getID(), c.getCompoundID());
				// calculate percentage that the element makes up of total number of moles
				ChemicalRDG cForCompound = ChemicalRDG.findByID(c.getCompoundID());
				totalToReplenish += thisElement / numAtoms * cForCompound.getChemicalMoles();
			}
			ChemicalRDG cForElement2 = ChemicalRDG.findByID(e.getID());
			if (cForElement2.getChemicalMoles() < totalToReplenish) {
				lowChemicals.add(
						createChemical(e.getID(), cForElement2.getChemicalName(), cForElement2.getChemicalMoles()));
			}
		}

		// acids that don't have enough to dissolve all metals that can be dissolved by
		// it
		ArrayList<AcidDTO> acids = AcidTDG.getSingleton().getAllAcids();
		for (AcidDTO a : acids) {
			ArrayList<MetalDTO> metals = MetalTDG.getSingleton().getMetalsDissolvedByAcid(a.getAcidID());
			double totalToDissolve = 0;
			for (MetalDTO m : metals) {
				totalToDissolve += m.getMolesOfAcidToDissolve();
			}
			ChemicalRDG cForAcids = ChemicalRDG.findByID(a.getAcidID());
			if (cForAcids.getChemicalMoles() < totalToDissolve) {
				lowChemicals
						.add(createChemical(a.getAcidID(), cForAcids.getChemicalName(), cForAcids.getChemicalMoles()));
			}
		}

		// bases that have less than 40 moles
		ArrayList<BaseDTO> bases = BaseTDG.getAllBases();
		for (BaseDTO b : bases) {
			ChemicalRDG cForBases = ChemicalRDG.findByID(b.getID());
			if (cForBases.getChemicalMoles() < 40) {
				lowChemicals.add(createChemical(b.getID(), cForBases.getChemicalName(), cForBases.getChemicalMoles()));
			}
		}

		return lowChemicals;
	}

	public int getID() {
		return ID;
	}

	public double getMoles() {
		return moles;
	}

	public ChemicalDomainObject getCdo() {
		return cdo;
	}

	public void setCdo(ChemicalDomainObject cdo) {
		this.cdo = cdo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMoles(double moles) {
		this.moles = moles;
	}

	@Override
	public String getName() {
		return this.name;
	}

}