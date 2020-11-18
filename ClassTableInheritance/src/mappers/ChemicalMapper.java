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
import datasource.DatabaseException;
import datasource.ElementDTO;
import datasource.ElementRDG;
import datasource.ElementTDG;
import datasource.MetalDTO;
import datasource.MetalTDG;
import domainObjects.ChemicalDomainObject;

/**
 * 
 * @author Mad&Ad
 *
 */
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
		ChemicalRDG chem = ChemicalRDG.findByID(ID);

		moles = cdo.getChemicalMoles();
		chem.setChemicalMoles(moles);
		chem.update();
	}

	@Override
	public ChemicalDomainObject findByID(int chemicalID) throws Exception {
		ChemicalRDG chem = ChemicalRDG.findByID(chemicalID);

		ChemicalDomainObject cdo = createChemical(chem.getChemicalID(), chem.getChemicalName(),
				chem.getChemicalMoles());

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

		ChemicalDomainObject cdo = createChemical(chem.getChemicalID(), chem.getChemicalName(),
				chem.getChemicalMoles());

		return cdo;
	}

	@Override
	public ArrayList<ChemicalDomainObject> findLowChemicals() throws Exception {
		ArrayList<ChemicalDomainObject> lowChemicals = new ArrayList<ChemicalDomainObject>();

		// elements that have less than 20 moles
		ArrayList<ElementDTO> elements = ElementTDG.getInstance().getAllElements();
		for (ElementDTO e : elements) {
			ChemicalRDG chemrdg = ChemicalRDG.findByID(e.getID());
			if (chemrdg.getChemicalMoles() < 20) {
				lowChemicals.add(createChemical(e.getID(), chemrdg.getChemicalName(), chemrdg.getChemicalMoles()));
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
				ChemicalRDG c_chemrdg = ChemicalRDG.findByID(c.getCompoundID());
				totalToReplenish += thisElement / numAtoms * c_chemrdg.getChemicalMoles();
			}
			ChemicalRDG e_chemrdg = ChemicalRDG.findByID(e.getID());
			if (e_chemrdg.getChemicalMoles() < totalToReplenish) {
				lowChemicals.add(createChemical(e.getID(), e_chemrdg.getChemicalName(), e_chemrdg.getChemicalMoles()));
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
			ChemicalRDG chemrdg = ChemicalRDG.findByID(a.getAcidID());
			if (chemrdg.getChemicalMoles() < totalToDissolve) {
				lowChemicals.add(createChemical(a.getAcidID(), chemrdg.getChemicalName(), chemrdg.getChemicalMoles()));
			}
		}

		// bases that have less than 40 moles
		ArrayList<BaseDTO> bases = BaseTDG.getAllBases();
		for (BaseDTO b : bases) {
			ChemicalRDG chemrdg = ChemicalRDG.findByID(b.getID());
			if (chemrdg.getChemicalMoles() < 40) {
				lowChemicals.add(createChemical(b.getID(), chemrdg.getChemicalName(), chemrdg.getChemicalMoles()));
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