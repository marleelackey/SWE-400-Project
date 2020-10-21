package mappers;

import java.util.ArrayList;

import Interfaces.ChemicalMapperInterface;
import datasource.AcidDTO;
import datasource.AcidRDG;
import datasource.AcidTDG;
import datasource.BaseDTO;
import datasource.BaseRDG;
import datasource.BaseTDG;
import datasource.CompoundDTO;
import datasource.CompoundRDG;
import datasource.CompoundTDG;
import datasource.ElementDTO;
import datasource.ElementRDG;
import datasource.ElementTDG;
import datasource.MetalDTO;
import datasource.MetalRDG;
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
		ElementRDG element = ElementRDG.findByID(ID);
		CompoundRDG compound = CompoundRDG.findByIDConcrete(ID);
		MetalRDG metal = MetalRDG.findByID(ID);
		AcidRDG acid = AcidRDG.findByID(ID);
		BaseRDG base = BaseRDG.findByID(ID);

		if (!element.equals(null)) {
			element.setMoles(moles);
			element.update();
		} else if (!compound.equals(null)) {
			compound.setCompoundMoles(moles);
			compound.update();
		} else if (!metal.equals(null)) {
			metal.setMoles(moles);
			metal.update();
		} else if (!acid.equals(null)) {
			acid.setAcidMoles(moles);
			acid.update();
		} else if (!base.equals(null)) {
			base.setMoles(moles);
			base.update();
		}
	}

	public ChemicalDomainObject findByID(int chemicalID) throws Exception {
		ElementRDG element = ElementRDG.findByID(chemicalID);
		CompoundRDG compound = CompoundRDG.findByIDConcrete(chemicalID);
		MetalRDG metal = MetalRDG.findByID(chemicalID);
		AcidRDG acid = AcidRDG.findByID(chemicalID);
		BaseRDG base = BaseRDG.findByID(chemicalID);

		if (!element.equals(null)) {
			cdo = createChemical(element.getID(), element.getName(), element.getMoles());
		} else if (!compound.equals(null)) {
			cdo = createChemical(compound.getCompoundID(), compound.getCompoundName(), compound.getCompoundMoles());
		} else if (!metal.equals(null)) {
			cdo = createChemical(metal.getID(), metal.getName(), metal.getMoles());
		} else if (!acid.equals(null)) {
			cdo = createChemical(acid.getAcidID(), acid.getAcidName(), acid.getAcidMoles());
		} else if (!base.equals(null)) {
			cdo = createChemical(base.getID(), base.getName(), base.getMoles());
		}

		return cdo;
	}

	public ArrayList<ChemicalDomainObject> findLowChemicals() throws Exception {
		ArrayList<ChemicalDomainObject> lowChemicals = new ArrayList<ChemicalDomainObject>();

		// elements that have less than 20 moles
		ArrayList<ElementDTO> elements = ElementTDG.getInstance().getAllElements();
		for (ElementDTO e : elements) {
			if (e.getMoles() < 20) {
				lowChemicals.add(createChemical(e.getID(), e.getName(), e.getMoles()));
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
				totalToReplenish += thisElement / numAtoms * c.getCompoundMoles();
			}
			if (e.getMoles() < totalToReplenish) {
				lowChemicals.add(createChemical(e.getID(), e.getName(), e.getMoles()));
			}
		}

		// acids that don't have enough to dissolve all metals that can be dissolved by
		// it
		ArrayList<AcidDTO> acids = AcidTDG.getSingleton().getAllAcids();
		for (AcidDTO a : acids) {
			ArrayList<MetalDTO> metals = MetalTDG.getInstance().getMetalsDissolvedByAcid(a.getAcidID());
			double totalToDissolve = 0;
			for (MetalDTO m : metals) {
				totalToDissolve += m.getMolesOfAcidToDissolve();
			}
			if (a.getAcidMoles() < totalToDissolve) {
				lowChemicals.add(createChemical(a.getAcidID(), a.getAcidName(), a.getAcidMoles()));
			}
		}

		// bases that have less than 40 moles
		ArrayList<BaseDTO> bases = BaseTDG.getAllBases();
		for (BaseDTO b : bases) {
			if (b.getMoles() < 40) {
				lowChemicals.add(createChemical(b.getID(), b.getName(), b.getMoles()));
			}
		}

		return lowChemicals;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
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

}