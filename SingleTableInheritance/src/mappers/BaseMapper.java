/**
 * 
 */
package mappers;

import java.util.ArrayList;

import Interfaces.BaseMapperInterface;
import datasource.ChemicalDTO;
import datasource.ChemicalRDG;
import datasource.ChemicalTDG;
import domainObjects.BaseDomainObject;

/**
 * @author Joshua, Ace, Marlee &&&&&&&&&&&&&&&&&& mad :)
 *
 */
public class BaseMapper implements BaseMapperInterface {

	private static final int type = 1;
	private int baseID;
	private String baseName;
	private int baseSolute;
	private double baseMoles;

	@Override
	public ArrayList<BaseDomainObject> getAllBases() {
		ArrayList<ChemicalDTO> Adot = ChemicalTDG.getSingleton().getAllBases();
		ArrayList<BaseDomainObject> Doa = new ArrayList<>();
		for (ChemicalDTO b : Adot) {
			baseID = b.getChemicalID();
			baseName = b.getChemicalName();
			baseSolute = b.getChemicalSoluteB();
			baseMoles = b.getChemicalMoles();
			Doa.add(new BaseDomainObject(this));
		}

		return Doa;
	}

	@Override
	public void persist() {
		ChemicalRDG b = new ChemicalRDG(baseID, type, baseName, baseSolute, baseMoles);
		b.update();
	}

	public int getBaseID() {
		return baseID;
	}

	public String getBaseName() {
		return baseName;
	}

	public int getBaseSolute() {
		return baseSolute;
	}

	public double getBaseMoles() {
		return baseMoles;
	}

}