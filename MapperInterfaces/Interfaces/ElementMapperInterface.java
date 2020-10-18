package Interfaces;

import domainObjects.ElementDomainObject;

public interface ElementMapperInterface {
	
	public void persist();

	public ElementDomainObject createElement(int ID, String elementName, int atomicNumber, double atomicMass, double moles) throws Exception;

//	public Element findByAtomicNumber(int atomicNumber);
//	public Element findByAtomicMass(int atomicMass);
//	public Element findByID(int elementID);
//	public Element getContainingCompounds(int atomicNumber);



	
}
