/**
 * 
 */
package mappers;

import java.util.ArrayList;

import domainObjects.BaseDomainObject;
import Interfaces.BaseMapperInterface;
import datasource.BaseDTO;
import datasource.BaseRDG;
import datasource.BaseTDG;
import datasource.ChemicalRDG;

/**
 * @author Mad&Ad
 *
 */
public class BaseMapper implements BaseMapperInterface {

	private int baseID;
	private String baseName;
	private int baseSolute;
	private double baseMoles;

	@Override
	public ArrayList<BaseDomainObject> getAllBases() {
		ArrayList<BaseDTO> Adot = BaseTDG.getAllBases();
		ArrayList<BaseDomainObject> Doa = new ArrayList<>();
		for (BaseDTO b : Adot) {
			ChemicalRDG chem = ChemicalRDG.findByID(b.getID());
			baseID = b.getID();
			baseName = chem.getChemicalName();
			baseSolute = b.getSolute();
			baseMoles = chem.getChemicalMoles();
			Doa.add(new BaseDomainObject(this));
		}

		return Doa;
	}

	@Override
	public void persist() {
		ChemicalRDG c = new ChemicalRDG(baseID, baseName, baseMoles);
		BaseRDG b = new BaseRDG(baseID, baseSolute);
		b.update();
		c.update();
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