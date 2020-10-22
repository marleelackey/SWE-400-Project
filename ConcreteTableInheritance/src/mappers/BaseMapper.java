/**
 * 
 */
package mappers;

import java.util.ArrayList;

import Interfaces.BaseDomainObject;
import Interfaces.BaseMapperInterface;
import datasource.BaseDTO;
import datasource.BaseTDG;

/**
 * @author Joshua, Ace, Marlee
 *
 */
public class BaseMapper implements BaseMapperInterface {

	@Override
	public ArrayList<BaseDomainObject> getAllBases() {
		ArrayList<BaseDTO> Adot = BaseTDG.getAllBases();
		ArrayList<BaseDomainObject> Doa = null;
		for(BaseDTO b :Adot) {
			Doa.add(new BaseDomainObject(b.getID(),b.getName(), b.getSolute(),b.getMoles()));
		}
		
		return Doa;
	}

}
