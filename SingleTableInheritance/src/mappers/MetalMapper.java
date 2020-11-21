package mappers;

import java.util.ArrayList;

import Interfaces.MetalMapperInterface;
import datasource.ChemicalDTO;
import datasource.ChemicalRDG;
import datasource.ChemicalTDG;
import datasource.DatabaseException;
import domainObjects.MetalDomainObject;

public class MetalMapper implements MetalMapperInterface {

	private static final int type = 4;
	private int ident;
	private String name;
	private int atomicNumber;
	private double atomicMass;
	private int dissolvedBy;
	private double moles;
	private double molesOfAcidToDissolve;
	private MetalDomainObject mdo;

	@Override
	public MetalDomainObject createMetal(int ID, String elementName, int atomicNumber, double atomicMass,
			int dissolvedBy, double moles, double molesOfAcidToDissolve) throws Exception {
		ident = ID;
		this.name = elementName;
		this.atomicNumber = atomicNumber;
		this.atomicMass = atomicMass;
		this.dissolvedBy = dissolvedBy;
		this.moles = moles;
		this.molesOfAcidToDissolve = molesOfAcidToDissolve;

		return new MetalDomainObject(this);
	}

	@Override
	public MetalDomainObject findByID(int mID) throws Exception {
		ChemicalRDG rdg = ChemicalRDG.findByIDSingle(mID);

		ident = mID;
		name = rdg.getName();
		atomicNumber = rdg.getAtomicNumber();
		atomicMass = rdg.getAtomicMass();
		dissolvedBy = rdg.getDissolvedBy();
		moles = rdg.getMoles();
		molesOfAcidToDissolve = rdg.getMolesOfAcidToDissolve();

		return new MetalDomainObject(this);
	}

	@Override
	public ArrayList<MetalDomainObject> getAllMetals() throws Exception {
		ArrayList<ChemicalDTO> metals = ChemicalTDG.getSingleton().getAllMetals();
		ArrayList<MetalDomainObject> list = new ArrayList<>();
		for (ChemicalDTO m : metals) {
			list.add(createMetal(m.getChemicalID(), m.getChemicalName(), m.getChemicalAtomicNumber(),
					m.getChemicalAtomicMass(), m.getChemicalDissolvedBy(), m.getChemicalMoles(),
					m.getChemicalMolesToDissolveMetal()));
		}
		return list;
	}

	@Override
	public void persist() {
		try {
			ChemicalRDG metal = ChemicalRDG.findByIDSingle(ident);
			if (metal == null) {
				ChemicalRDG rdg = new ChemicalRDG(ident, type, name, atomicNumber, atomicMass, dissolvedBy, moles,
						molesOfAcidToDissolve);
				rdg.insert();
				System.out.println("Metal created with ID " + ident);
			} else {
				atomicMass = this.getMetal().getMetalAtomicMass();
				atomicNumber = this.getMetal().getMetalAtomicNumber();
				dissolvedBy = this.getMetal().getDissolvedBy();
				moles = this.getMetal().getMoles();
				molesOfAcidToDissolve = this.getMetal().getMolesOfAcidToDissolve();
				name = this.getMetal().getMetalName();

				metal.setAtomicMass(atomicMass);
				metal.setAtomicNumber(atomicNumber);
				metal.setDissolvedBy(dissolvedBy);
				metal.setMoles(moles);
				metal.setMolesOfAcidToDissolve(molesOfAcidToDissolve);
				metal.setName(name);
				metal.update();
			}
		} catch (Exception e) {
			DatabaseException.detectError(e, "Error spotted in the MetalMapper class, Persist method");
		}
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

	public void setDissolvedBy(int dissolvedBy) {
		this.dissolvedBy = dissolvedBy;
	}

	public void setMoles(double moles) {
		this.moles = moles;
	}

	public void setMolesOfAcidToDissolve(double molesOfAcidToDissolve) {
		this.molesOfAcidToDissolve = molesOfAcidToDissolve;
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

	public int getDissolvedBy() {
		return dissolvedBy;
	}

	public double getMoles() {
		return moles;
	}

	public double getMolesOfAcidToDissolve() {
		return molesOfAcidToDissolve;
	}

	public MetalDomainObject getMetal() {
		return mdo;
	}

	public void setMetal(MetalDomainObject mdo) {
		this.mdo = mdo;
	}

}