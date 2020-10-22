/**
 * 
 */
package mappers;

import java.util.ArrayList;

import Interfaces.AcidDomainObject;
import Interfaces.AcidMapperInterface;
import Interfaces.BaseMapperInterface;
import datasource.AcidDTO;
import datasource.AcidTDG;
import datasource.BaseDTO;
import datasource.BaseTDG;
import datasource.MetalDTO;
import datasource.MetalTDG;
import domainObjects.ElementDomainObject;
import domainObjects.MetalDomainObject;

/**
 * @author Josh B. , Ace W.
 *
 */
public class AcidMapper implements AcidMapperInterface {
	
	private int ident;
	private String name;
	private double moles;
	private int solute;
	private AcidDomainObject acid;

	
	@Override
	public AcidDomainObject createAcid(int ID, String name, double moles, int solute) throws Exception {
		ident = ID;
		this.name = name;
		this.moles = moles;
		this.solute = solute;

		return new AcidDomainObject(this);
	}

	@Override
	public ArrayList<AcidDomainObject> getAllAcids() {
				ArrayList<AcidDTO> Adot = AcidTDG.getSingleton().getAllAcids();
				ArrayList<AcidDomainObject> Doa = new ArrayList<AcidDomainObject>();
				for(AcidDTO b : Adot) {
					Doa.add(createAcid(b.getAcidID(), b.getAcidName(), b.getAcidMoles(), b.getAcidSolute()));
				}
				
				return Doa;
	}
	
	@Override
	public ArrayList<MetalDomainObject> getChemicalsDissolvedByAcid(int id) throws Exception {
		ArrayList<MetalDomainObject> metals = new ArrayList<MetalDomainObject>();
		
		ArrayList<MetalDTO> metalIDs = MetalTDG.getInstance().getAllMetals();
		MetalMapper metalMapper = new MetalMapper();
	
		for (MetalDTO d : metalIDs) {
			if (d.getID() == id) {
				metals.add(metalMapper.findByID(id));
			}
		}
		
		return metals;
	}

}
