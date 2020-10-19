package mappers;

import Interfaces.MetalMapperInterface;
import datasource.ChemicalRDG;
import datasource.DatabaseException;
import datasource.ElementRDG;
import datasource.MetalRDG;
import domainObjects.MetalDomainObject;

public class MetalMapper implements MetalMapperInterface {

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

	public MetalDomainObject findByID(int mID) throws Exception {
		MetalRDG rdg = MetalRDG.findByID(mID);

		ident = mID;
		dissolvedBy = rdg.getDissolvedBy();
		molesOfAcidToDissolve = rdg.getMolesOfAcidToDissolve();

		return new MetalDomainObject(this);
	}

	public void persist() {
		try {
			MetalRDG metal = MetalRDG.findByID(ident);
			if (metal.equals(null)) {
				MetalRDG rdg = new MetalRDG(ident, dissolvedBy, molesOfAcidToDissolve);
				rdg.insert();
			} else {
				metal.setDissolvedBy(dissolvedBy);
				metal.setMolesOfAcidToDissolve(molesOfAcidToDissolve);
				metal.update();
			}
			ElementRDG e = ElementRDG.findByID(ident);
			ChemicalRDG c = ChemicalRDG.findByID(ident);
			ElementMapper em = new ElementMapper();
			em.createElement(ident, c.getChemicalName(), e.getAtomicNumber(), e.getAtomicMass(), c.getChemicalMoles());
			em.persist();
		} catch (Exception e) {
			DatabaseException.detectError(e, "Error spotted in the MetalMapper class, Persist method");
		}
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