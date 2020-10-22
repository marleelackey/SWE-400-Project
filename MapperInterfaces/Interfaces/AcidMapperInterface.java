/**
 * 
 */
package Interfaces;

import java.util.ArrayList;

import domainObjects.ElementDomainObject;
import domainObjects.MetalDomainObject;
import mappers.AcidDomainObject;

/**
 * @author Josh B., Ace
 *
 */
public interface AcidMapperInterface {
	
	ArrayList<MetalDomainObject> getChemicalsDissolvedByAcid(int id) throws Exception;

	AcidDomainObject createAcid(int ID, String name, double moles, int solute) throws Exception;

	ArrayList<AcidDomainObject> getAllAcids();

}
