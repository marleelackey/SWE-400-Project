package mappers;

import java.util.ArrayList;

import Interfaces.MetalMapperInterface;
import datasource.ChemicalRDG;
import datasource.DatabaseException;
import datasource.ElementRDG;
import datasource.MetalDTO;
import datasource.MetalRDG;
import datasource.MetalTDG;
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

	@Override
	public MetalDomainObject findByID(int mID) throws Exception {
		MetalRDG m = MetalRDG.findByID(mID);
		ElementRDG e = ElementRDG.findByID(mID);
		ChemicalRDG c = ChemicalRDG.findByID(mID);

		ident = mID;
		name = c.getChemicalName();
		atomicNumber = e.getAtomicNumber();
		atomicMass = e.getAtomicMass();
		dissolvedBy = m.getDissolvedBy();
		moles = c.getChemicalMoles();
		molesOfAcidToDissolve = m.getMolesOfAcidToDissolve();

		return new MetalDomainObject(this);
	}

	@Override
	public ArrayList<MetalDomainObject> getAllMetals() throws Exception {
		ArrayList<MetalDTO> metals = MetalTDG.getSingleton().getAllMetals();
		ArrayList<MetalDomainObject> list = new ArrayList<>();
		for (MetalDTO m : metals) {
			ChemicalRDG c = ChemicalRDG.findByID(m.getID());
			ElementRDG e = ElementRDG.findByID(m.getID());
			list.add(createMetal(m.getID(), c.getChemicalName(), e.getAtomicNumber(), e.getAtomicMass(),
					m.getDissolvedBy(), c.getChemicalMoles(), m.getMolesOfAcidToDissolve()));
		}
		return list;
	}

	@Override
	public void persist() {
		try {
			MetalRDG m = MetalRDG.findByID(ident);
			ChemicalRDG c = ChemicalRDG.findByID(ident);
			ElementRDG e = ElementRDG.findByID(ident);
			if (m == null && c == null && e == null) {
				c = new ChemicalRDG(ident, name, moles);
				e = new ElementRDG(ident, atomicNumber, atomicMass);
				m = new MetalRDG(ident, dissolvedBy, molesOfAcidToDissolve);
				c.insert();
				e.insert();
				m.insert();
				System.out.println("Metal created with ID " + ident);
			} else {
				atomicMass = mdo.getMetalAtomicMass();
				atomicNumber = mdo.getMetalAtomicNumber();
				dissolvedBy = mdo.getDissolvedBy();
				moles = mdo.getMoles();
				molesOfAcidToDissolve = mdo.getMolesOfAcidToDissolve();
				name = mdo.getMetalName();

				e.setAtomicMass(atomicMass);
				e.setAtomicNumber(atomicNumber);
				m.setDissolvedBy(dissolvedBy);
				c.setChemicalMoles(moles);
				m.setMolesOfAcidToDissolve(molesOfAcidToDissolve);
				c.setName(name);
				c.update();
				e.update();
				m.update();
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