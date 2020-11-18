/**
 * 
 */
package mappers;

import java.util.ArrayList;

import Interfaces.AcidMapperInterface;
import datasource.ChemicalDTO;
import datasource.ChemicalTDG;
import domainObjects.MetalDomainObject;
import domainObjects.AcidDomainObject;

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
		this.acid = new AcidDomainObject(this);

		return this.acid;
	}

	@Override
	public ArrayList<AcidDomainObject> getAllAcids() throws Exception {
				ArrayList<ChemicalDTO> Adot = ChemicalTDG.getSingleton().getAllAcids();
				ArrayList<AcidDomainObject> Doa = new ArrayList<AcidDomainObject>();
				try {
					for(ChemicalDTO b : Adot) {
						Doa.add(createAcid(b.getChemicalID(), b.getChemicalName(), b.getChemicalMoles(), b.getChemicalSoluteA()));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return Doa;
	}
	
	@Override//---------------------------------------------------------------------------------------
	public ArrayList<MetalDomainObject> getChemicalsDissolvedByAcid(int id) throws Exception {
		ArrayList<MetalDomainObject> metals = new ArrayList<MetalDomainObject>();
		
		ArrayList<ChemicalDTO> dtos = ChemicalTDG.getSingleton().getAllMetals();
		MetalMapper metalMapper = new MetalMapper();
	
		for (ChemicalDTO d : dtos) {
			if (d.getChemicalDissolvedBy() == id) {
				metals.add(metalMapper.findByID(id));
			}
		}
		
		return metals;
	}

//	@Override
//	public static domainObjects.AcidDomainObject findByName(String acidName) throws Exception {
//		AcidMapper mapper = new AcidMapper();
//		ChemicalRDG rdg = ChemicalRDG.findByName(acidName);
//		
//		mapper.ident = rdg.getAcidID();
//		mapper.name = rdg.getAcidName();
//		mapper.moles = rdg.getAcidMoles();
//		mapper.ident = rdg.getAcidSolute();
//
//		return mapper.createAcid(rdg.getAcidID(), rdg.getAcidName(), rdg.getAcidMoles(), rdg.getAcidSolute());
//	}
	
	@Override
	public AcidDomainObject findByName(String acidName) throws Exception {
		AcidMapper mapper = new AcidMapper();
		ChemicalRDG rdg = ChemicalRDG.findByName(acidName);
		
		mapper.ident = rdg.getAcidID();
		mapper.name = rdg.getAcidName();
		mapper.moles = rdg.getAcidMoles();
		mapper.solute = rdg.getAcidSolute();

		return mapper.createAcid(rdg.getAcidID(), rdg.getAcidName(), rdg.getAcidMoles(), rdg.getAcidSolute());
	}
	
	@Override
	public void persist() {
		// TODO Auto-generated method stub
		
	}

	public int getIdent() {
		return ident;
	}

	public String getName() {
		return name;
	}

	public double getMoles() {
		return moles;
	}

	public int getSolute() {
		return solute;
	}

	public AcidDomainObject getAcid() {
		return acid;
	}

}
