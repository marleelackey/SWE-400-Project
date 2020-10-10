package Mappers;

import Interfaces.ElementMapperInterface;
import datasource.ChemicalRDG;
import datasource.DatabaseException;

public class ElementMapper implements ElementMapperInterface {
 private static final int type = 3;
	@Override
	public void CreateElement(int ident, int atomicNumber, double atomicMass, String name) {
		try {
			ChemicalRDG tom = new ChemicalRDG( ident, type , name, atomicNumber, atomicMass, (Integer) null, (Integer) null,
					(Integer) null);
			tom.update();
		} catch (DatabaseException e) {
			DatabaseException.detectError(e, "Error spotted in the ElementMapper class, CreateElementMethod");
		}
		
	}

}
