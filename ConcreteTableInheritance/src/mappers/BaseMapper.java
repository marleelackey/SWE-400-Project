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

/**
 * @author Joshua, Ace, Marlee
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
		for(BaseDTO b :Adot) {
			baseID = b.getID();
			baseName = b.getName();
			baseSolute = b.getSolute();
			baseMoles = b.getMoles();
			Doa.add(new BaseDomainObject(this));
		}
		
		return Doa;
	}

	@Override
	public void persist() {
		BaseRDG b = new BaseRDG(baseID, baseName, baseSolute, baseMoles);
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