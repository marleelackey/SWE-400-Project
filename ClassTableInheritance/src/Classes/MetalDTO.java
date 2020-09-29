package Classes;

public class MetalDTO {
	private int ID,
				dissolvedBy;

	public MetalDTO(int ID, int dissolvedBy) {
		this.ID = ID;
		this.dissolvedBy = dissolvedBy;
	}
	
	public int getID() {
		return ID;
	}

	public int getDissolvedBy() {
		return dissolvedBy;
	}

	public void setDissolvedBy(int dissolvedBy) {
		this.dissolvedBy = dissolvedBy;
	}
}
