package commands;

public class ModifyChemicalAmountCmd implements CommandInterface {
	
	private int chemicalID;
	private double newChemicalAmount;
	
	public ModifyChemicalAmountCmd(int id, double newMoles) {
		chemicalID = id;
		newChemicalAmount = newMoles;
	}
	
	@Override
	public void execute() {
		ChemicalMapper cm = new ChemicalMapper();
		ChemicalDomainObject cdo = cm.findByID(chemicalID);
		cdo.setChemicalAmount(newChemicalAmount);
		cdo.persist();
	}
	
	public int getChemicalID() {
		return chemicalID;
	}
	
	public double getNewChemicalAmount() {
		return newChemicalAmount;
	}
	
}