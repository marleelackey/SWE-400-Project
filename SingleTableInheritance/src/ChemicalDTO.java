/**
 * @authors Madeline & Adam
 *
 */
public class ChemicalDTO {
  
  private int ID;
  private int type;
  private String name;
  private int atomicNumber;
  private double atomicMass;
  private int dissolvedBy;
  private int soluteA;
  private int soluteB;
  
  public ChemicalDTO(int ID, int type, String name, int atomicNumber, double atomicMass, int dissolvedBy, int soluteA, int soluteB) {
    this.ID = ID;
    this.type = type;
    this.name = name;
    this.atomicNumber = atomicNumber;
    this.atomicMass = atomicMass;
    this.dissolvedBy = dissolvedBy;
    this.soluteA = soluteA;
    this.soluteB = soluteB;
  }
  
  public int getID() {
    return ID;
  }
  
  public int getType() {
    return type;
  }
  
  public String getName() {
    return name;
  }
  
  public int getAtomicNumber() {
    return atomicNumber;
  }
  
  public double getAtomicMass() {
    return atomicMass;
  }
  
  public int getDissolvedBy() {
    return dissolvedBy;
  }
  
  public int getSoluteA() {
    return soluteA;
  }
  
  public int getSoluteB() {
    return soluteB;
  }

}