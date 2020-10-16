package mappers;

import Interfaces.MetalMapperInterface;
import datasource.DatabaseException;
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
		name = rdg.getName();
		atomicNumber = rdg.getAtomicNumber();
		atomicMass = rdg.getAtomicMass();
		dissolvedBy = rdg.getDissolvedBy();
		moles = rdg.getMoles();
		molesOfAcidToDissolve = rdg.getMolesOfAcidToDissolve();

		return new MetalDomainObject(this);
	}

	public void persist() {
		try {
			MetalRDG rdg = new MetalRDG(ident, atomicNumber, dissolvedBy, atomicMass, name, moles,
					molesOfAcidToDissolve);
			rdg.insert();
		} catch (Exception e) {
			DatabaseException.detectError(e, "Error spotted in the MetalMapper class, CreateMetal method");
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