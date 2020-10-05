package datasource;

/**
 * A Data Transfer Object for the Base table 
 * @author Ace Josh B.
 *
 */
public class BaseDTO {
	private int ID;
	private String name;
	private int solute;
	
	public BaseDTO(int id, String nme, int slte)
	{
		this.ID = id;
		name = nme;
		solute = slte;
	}

	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getSolute()
	{
		return solute;
	}
	
}
