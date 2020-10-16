//package mappers;
//
//import Interfaces.MetalMapperInterface;
//import datasource.ChemicalRDG;
//import datasource.DatabaseException;
//
//public class MetalMapper implements MetalMapperInterface {
//	private static final int type = 4;
//	private int ident;
//	private String name;
//	private int atomicNumber;
//	private double atomicMass;	
//	private int dissolvedBy;
//	private double moles;
//	private double molesOfAcidToDissolve;
//
//
//
// 
//	public MetalMapper(int ID, String elementName, int atomicNumber, double atomicMass, int dissolvedBy, double moles, double molesOfAcidToDissolve) {
//		ident = ID;
//		this.name = elementName;
//		this.atomicNumber = atomicNumber;
//		this.atomicMass = atomicMass;
//		this.dissolvedBy = dissolvedBy;
//		this.moles = moles;
//		this.molesOfAcidToDissolve = molesOfAcidToDissolve;
//	}
//	
//
//	@Override
//	public void createMetal() {
//		try {
//			ChemicalRDG tom = new ChemicalRDG(ident, type, name, atomicNumber, atomicMass, dissolvedBy, moles, molesOfAcidToDissolve);
//			tom.insert();
//		} catch (Exception e) {
//			DatabaseException.detectError(e, "Error spotted in the MetalMapper class, CreateMetal method");
//		}
//	}
//
//}
