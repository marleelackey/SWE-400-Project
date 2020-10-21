package Interfaces;

import domainObjects.CompoundDomainObject;

public interface CompoundMapperInterface {

	public CompoundDomainObject findByID(int cID) throws Exception;

	public void persist();

}