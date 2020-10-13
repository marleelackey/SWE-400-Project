package Interfaces;

import java.util.HashMap;

import DomainObjects.ElementDomainObject;
import Interfaces.ElementMapperInterface;

public interface ElementMapperInterface {
	
	static HashMap<Integer, ElementDomainObject> identityMap = new HashMap<Integer, ElementDomainObject>();
	
	public ElementDomainObject createElement() throws Exception;
	public void persist();
	public int getIdent();
	public String getName();
	public double getAtomicMass();
	public int getAtomicNumber();
	public double getMoles();

//	public Element findByAtomicNumber(int atomicNumber);
//	public Element findByAtomicMass(int atomicMass);
//	public Element findByID(int elementID);
//	public Element getContainingCompounds(int atomicNumber);



	
}
