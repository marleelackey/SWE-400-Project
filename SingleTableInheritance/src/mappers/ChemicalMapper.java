package mappers;

import java.util.ArrayList;

import Interfaces.ChemicalMapperInterface;
import datasource.ChemicalDTO;
import datasource.ChemicalRDG;
import datasource.ChemicalTDG;
import datasource.CompoundMadeOfElementDTO;
import datasource.DatabaseException;
import domainObjects.ChemicalDomainObject;

public class ChemicalMapper implements ChemicalMapperInterface {

	private int ID;
	private String name;
	private double moles;
	private ChemicalDomainObject cdo;

	@Override
	public ChemicalDomainObject createChemical(int ID, String name, double moles) throws Exception {
		this.ID = ID;
		this.name = name;
		this.moles = moles;

		return new ChemicalDomainObject(this);
	}

	@Override
	public void persist() throws DatabaseException {
		ChemicalRDG chem = ChemicalRDG.findByIDSingle(ID);
		moles = cdo.getChemicalMoles();
		chem.setMoles(moles);
		chem.update();
	}

	@Override
	public ChemicalDomainObject findByID(int chemicalID) throws Exception {
		ChemicalRDG chem = ChemicalRDG.findByIDSingle(chemicalID);
		cdo = createChemical(chem.getID(), chem.getName(), chem.getMoles());

		return cdo;
	}

	/**
	 * Find a chemical from its name
	 * 
	 * @author mad&ad
	 * 
	 * @param name da name
	 * @return da chem
	 * @throws Exception da error
	 */
	@Override
	public ChemicalDomainObject findByName(String name) throws Exception {

		ChemicalRDG chem = ChemicalRDG.findByName(name);
		cdo = createChemical(chem.getID(), chem.getName(), chem.getMoles());

		return cdo;
	}

	@Override
	public ArrayList<ChemicalDomainObject> findLowChemicals() throws Exception {
		ArrayList<ChemicalDomainObject> lowChemicals = new ArrayList<ChemicalDomainObject>();

		// elements that have less than 20 moles
		ArrayList<ChemicalDTO> elements = ChemicalTDG.getSingleton().getAllElements();
		for (ChemicalDTO e : elements) {
			if (e.getChemicalMoles() < 20) {
				lowChemicals.add(createChemical(e.getChemicalID(), e.getChemicalName(), e.getChemicalMoles()));
			}
		}

		// elements that don't have enough to replenish all compounds that contain it
		for (ChemicalDTO e : elements) {
			ArrayList<CompoundMadeOfElementDTO> compounds = ChemicalTDG.getSingleton()
					.getCompoundsByElement(e.getChemicalID());
			double totalToReplenish = 0;
			for (CompoundMadeOfElementDTO c : compounds) {
				ArrayList<CompoundMadeOfElementDTO> allElementsInCompound = ChemicalTDG.getSingleton()
						.getElementsInCompound(c.getCompoundID());
				int numAtoms = 0; // total number of atoms in the compound
				for (CompoundMadeOfElementDTO containedElement : allElementsInCompound) {
					numAtoms += containedElement.getElementQuantity();
				}
				int thisElement = c.getElementQuantity();

				// calculate percentage that the element makes up of total number of moles
				ChemicalRDG comp = ChemicalRDG.findByIDSingle(c.getCompoundID());
				totalToReplenish += thisElement / numAtoms * comp.getMoles();
			}
			if (e.getChemicalMoles() < totalToReplenish) {
				lowChemicals.add(createChemical(e.getChemicalID(), e.getChemicalName(), e.getChemicalMoles()));
			}
		}

		// acids that don't have enough to dissolve all metals that can be dissolved by
		// it
		ArrayList<ChemicalDTO> acids = ChemicalTDG.getSingleton().getAllAcids();
		for (ChemicalDTO a : acids) {
			ArrayList<ChemicalDTO> metals = ChemicalTDG.getSingleton().getChemicalsDissolvedByAcid(a.getChemicalID());
			double totalToDissolve = 0;
			for (ChemicalDTO m : metals) {
				totalToDissolve += m.getChemicalMolesToDissolveMetal();
			}
			if (a.getChemicalMoles() < totalToDissolve) {
				lowChemicals.add(createChemical(a.getChemicalID(), a.getChemicalName(), a.getChemicalMoles()));
			}
		}

		// bases that have less than 40 moles
		ArrayList<ChemicalDTO> bases = ChemicalTDG.getSingleton().getAllBases();
		for (ChemicalDTO b : bases) {
			if (b.getChemicalMoles() < 40) {
				lowChemicals.add(createChemical(b.getChemicalID(), b.getChemicalName(), b.getChemicalMoles()));
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